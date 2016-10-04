package br.com.fiap.petwell.requesttask;


import android.app.Activity;
import android.os.AsyncTask;

import com.google.gson.Gson;

import br.com.fiap.petwell.activity.R;
import br.com.fiap.petwell.bean.StatusResponse;
import br.com.fiap.petwell.repository.FeederRegisterRepository;
import br.com.fiap.petwell.util.alert.AlertUtil;

public class FeederRegisterRequestTask extends AsyncTask<Void, Void, String> {

    private Activity activity;
    private String json;
    private int devCode;
    private String nome;

    public FeederRegisterRequestTask(Activity activity, String nome, int devCode) {
        this.activity = activity;
        this.nome = nome;
        this.devCode = devCode;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {
            json = FeederRegisterRepository.register(activity,nome,devCode);
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
                    AlertUtil.ActionlessDialogBuilder(activity, R.string.msgFeederRegisterTitle, R.string.msgFeederRegisterOK);
                }else{
                    AlertUtil.ActionlessDialogBuilder(activity, R.string.msgFeederRegisterTitle, R.string.msgFeederRegisterFail);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}