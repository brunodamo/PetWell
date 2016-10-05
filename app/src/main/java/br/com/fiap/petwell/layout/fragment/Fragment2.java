package br.com.fiap.petwell.layout.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
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

public class Fragment2 extends Fragment {

    public Fragment2(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment2 , container, false);
        return rootView;
    }

}
