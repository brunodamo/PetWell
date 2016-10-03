package br.com.fiap.petwell.requesttask;


import android.app.Activity;
import android.os.AsyncTask;

import com.google.gson.Gson;

import br.com.fiap.petwell.bean.StatusResponse;
import br.com.fiap.petwell.repository.FeedRepository;
import br.com.fiap.petwell.repository.FeederRegisterRepository;
import br.com.fiap.petwell.repository.UserRegisterRepository;
import br.com.fiap.petwell.util.alert.AlertUtil;

public class FeedRequestTask extends AsyncTask<Void, Void, String> {

    private Activity activity;
    private String json;
    private int devCode;
    private String nome;

    public FeedRequestTask(Activity activity, int devCode) {
        this.activity = activity;
        this.devCode = devCode;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {
            json = FeedRepository.register(activity,devCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    protected void onPostExecute(String jsonResult) {
        try {
            if(jsonResult == null){
                AlertUtil.getConnectionTimeoutDialog(activity);
            }else{
                StatusResponse statusResponse = new Gson().fromJson(jsonResult, StatusResponse.class);
                if(statusResponse.isStatus()){
                    AlertUtil.getOKRegisterDialog(activity);
                }else{
                    AlertUtil.getFailRegisterDialog(activity);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}