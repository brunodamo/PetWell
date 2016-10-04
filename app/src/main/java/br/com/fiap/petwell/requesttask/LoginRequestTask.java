package br.com.fiap.petwell.requesttask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.gson.Gson;

import br.com.fiap.petwell.activity.AppNavActivity;
import br.com.fiap.petwell.bean.StatusResponse;
import br.com.fiap.petwell.repository.LoginRepository;
import br.com.fiap.petwell.util.alert.AlertUtil;

public class LoginRequestTask extends AsyncTask<Void, Void, String>{

    private Activity activity;
    private String email, senha;

    public LoginRequestTask (Activity activity, String email, String senha){
        this.activity = activity;
        this.email = email;
        this.senha = senha;
    }

    @Override
    protected String doInBackground(Void... params) {
        String json = LoginRepository.login(activity,email,senha);
        return json;
    }

    @Override
    protected void onPostExecute(String jsonResponse) {
        try {
            if (jsonResponse == null){
                AlertUtil.getConnectionTimeoutDialog(activity);
            }else {
                StatusResponse statusResponse = new Gson().fromJson(jsonResponse, StatusResponse.class);
                if (statusResponse.isStatus()) {
                    Intent toAppNav = new Intent(activity, AppNavActivity.class);
                    toAppNav.putExtra("HASH", statusResponse.getHashAcesso());
                    activity.startActivity(toAppNav);
                    activity.finish();
                } else {
                    AlertUtil.getFailLoginDialog(activity);
                }
            }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
