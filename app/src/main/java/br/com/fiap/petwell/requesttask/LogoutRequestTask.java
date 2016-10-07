package br.com.fiap.petwell.requesttask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import br.com.fiap.petwell.activity.LoginActivity;
import br.com.fiap.petwell.bean.Login;
import br.com.fiap.petwell.bean.StatusResponse;
import br.com.fiap.petwell.repository.LogoutRepository;
import br.com.fiap.petwell.util.alert.AlertUtil;
import br.com.fiap.petwell.util.hash.HashUtil;

public class LogoutRequestTask extends AsyncTask<Void, Void, String>{

    private Activity activity;

    public LogoutRequestTask(Activity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... params) {
        String json = LogoutRepository.logout(activity);
        return json;
    }

    @Override
    protected void onPostExecute(String jsonResponse) {
        try {
            if (jsonResponse == null){
                AlertUtil.getConnectionTimeoutDialog(activity);
            }
            StatusResponse statusResponse = new Gson().fromJson(jsonResponse, StatusResponse.class);
            Log.i("logout", String.valueOf(statusResponse.isStatus()));
            if(statusResponse.isStatus()){
                HashUtil.hashClear(activity);
            }else{
                AlertUtil.getFailLogoutDialog(activity);
            }
        }catch (Exception e){

        }
    }
}
