package br.com.fiap.petwell.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import br.com.fiap.petwell.requesttask.LoginRequestTask;

public class LoginActivity extends AppCompatActivity {

    private LoginRequestTask loginRequestTask;
    private String url;
    private EditText edtEmail;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmail = (EditText) findViewById(R.id.edtLoginEmail);
        edtSenha = (EditText) findViewById(R.id.edtLoginSenha);
    }

    public void logar(View v){
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        loginRequestTask = new LoginRequestTask(this,email,senha);
        loginRequestTask.execute();
    }

    public void toRegisterActivity(View v){
        Intent toRegister = new Intent(this, RegistrationActivity.class);
        startActivity(toRegister);
    }

}
