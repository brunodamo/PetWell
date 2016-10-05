package br.com.fiap.petwell.layout.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import br.com.fiap.petwell.activity.AppNavActivity;
import br.com.fiap.petwell.activity.R;
import br.com.fiap.petwell.bean.Alimentador;
import br.com.fiap.petwell.interfaces.AsyncResponse;
import br.com.fiap.petwell.requesttask.FeedRequestTask;
import br.com.fiap.petwell.requesttask.GetFeederRequestTask;
import br.com.fiap.petwell.util.to.DevCodeTO;

public class Fragment2 extends Fragment {

    public Fragment2(){
    }
    private Spinner spFeeders;

    private int devCode;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment2 , container, false);
        spFeeders = (Spinner) rootView.findViewById(R.id.spFeeders);
        spFeeders.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                Alimentador alimentador = (Alimentador) parent.getItemAtPosition(position);
                DevCodeTO.setDevCode(alimentador.getDevCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rootView;
    }

}
