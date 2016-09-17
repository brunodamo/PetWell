package br.com.fiap.petwell.layout.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.fiap.petwell.activity.R;

//This fragment is referent to feeder Register
public class Fragment1 extends Fragment {
    public Fragment1(){

    }
    Button btnRegisterFeeder;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.alimentador_fragment, container, false);
        return rootView;
    }

}
