package br.com.fiap.petwell.requesttask;


import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import br.com.fiap.petwell.bean.StatusResponse;
import br.com.fiap.petwell.interfaces.AsyncResponse;
import br.com.fiap.petwell.repository.GetFeederRepository;
import br.com.fiap.petwell.util.alert.AlertUtil;

public class GetFeederRequestTask extends AsyncTask<Void, Void, String> {

    public AsyncResponse delegate = null;
    private Activity activity;
    private String json;

    public GetFeederRequestTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            json = GetFeederRepository.getFeeders(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    protected void onPostExecute(String jsonResult) {
        Log.i("jsonResult", jsonResult);
        delegate.processFinish(jsonResult);
    }
}