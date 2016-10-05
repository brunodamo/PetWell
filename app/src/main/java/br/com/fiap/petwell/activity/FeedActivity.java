package br.com.fiap.petwell.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import br.com.fiap.petwell.bean.Alimentador;
import br.com.fiap.petwell.interfaces.AsyncResponse;
import br.com.fiap.petwell.requesttask.FeedRequestTask;
import br.com.fiap.petwell.requesttask.GetFeederRequestTask;

public class FeedActivity extends AppCompatActivity implements AsyncResponse, AdapterView.OnItemSelectedListener {

    private List<Alimentador> alimentadores;
    private Spinner spFeederList;
    private int devCode;
    private AsyncResponse asyncResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        loadFeeders();
        spFeederList = (Spinner) findViewById(R.id.spFeeders);
    }

    private void loadFeeders(){
        GetFeederRequestTask getFeederRequestTask = new GetFeederRequestTask(this);
        getFeederRequestTask.execute();

        ArrayAdapter<Alimentador> adapter =	new ArrayAdapter<Alimentador>(this, android.R.layout.simple_spinner_item, alimentadores);
        Spinner spFeeders = (Spinner) findViewById(R.id.spFeeders);
        spFeeders.setAdapter(adapter);
    }

    @Override
    public void processFinish(String output) {
        alimentadores = new Gson().fromJson(output, new TypeToken<List<Alimentador>>(){}.getType());
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Alimentador alimentador = (Alimentador) parent.getItemAtPosition(position);
        devCode = alimentador.getDevCode();
    }

    public void feed(View v){
        FeedRequestTask feedRequestTask = new FeedRequestTask(this, devCode);
        feedRequestTask.execute();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
