package br.com.fiap.petwell.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import br.com.fiap.petwell.requesttask.UserRegisterRequestTask;

public class RegistrationActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private UserRegisterRequestTask r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edtNome = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
    }

    public void cadastrar(View v){
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        r = new UserRegisterRequestTask(this, nome, email, senha);
        r.execute();
    }

    public void limpar(View v){
        edtNome.setText("");
        edtEmail.setText("");
        edtSenha.setText("");
    }

}


