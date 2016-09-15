package br.com.fiap.petwell.layout.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.fiap.petwell.activity.R;

public class Fragment3 extends Fragment {
    public Fragment3(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment3 , container, false);
        return rootView;
    }

}
