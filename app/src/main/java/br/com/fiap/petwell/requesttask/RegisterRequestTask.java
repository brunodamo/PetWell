package br.com.fiap.petwell.requesttask;


import android.app.Activity;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.OutputStreamWriter;

import br.com.fiap.petwell.bean.StatusResponse;
import br.com.fiap.petwell.repository.RegisterRepository;
import br.com.fiap.petwell.util.alert.AlertUtil;

public class RegisterRequestTask extends AsyncTask<Void, Void, String> {

    private Activity activity;
    private boolean loginStatus;
    private String loginHash;
    private String json;
    private OutputStreamWriter out;
    private String nome, email, senha;

    public RegisterRequestTask(Activity activity, String nome, String email, String senha) {
        this.activity = activity;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }



    @Override
    protected String doInBackground(Void... params) {

        try {
            json = RegisterRepository.register(activity,nome,email,senha);
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