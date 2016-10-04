package br.com.fiap.petwell.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import br.com.fiap.petwell.bean.Alimentador;
import br.com.fiap.petwell.requesttask.FeedRequestTask;
import br.com.fiap.petwell.requesttask.GetFeederRequestTask;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
    }

    private void loadFeeders(){
        GetFeederRequestTask getFeederRequestTask = new GetFeederRequestTask(this);
        getFeederRequestTask.execute();
        ArrayAdapter<Alimentador> adapter =	new ArrayAdapter<Alimentador>(this, android.R.layout.simple_spinner_item, alimentadores);
        Spinner spFeeders = (Spinner) findViewById(R.id.spFeeders);
        spFeeders.setAdapter(adapter);
    }
}
