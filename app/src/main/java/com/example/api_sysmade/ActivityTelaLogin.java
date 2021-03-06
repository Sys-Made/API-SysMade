package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api_sysmade.database.DtoLogin;

public class ActivityTelaLogin extends AppCompatActivity {
    Button buttonEntrar;//Declarando objeto botao
    Button buttonCancelar;
    EditText txtUsuario;
    EditText txtSenha;

    //Usuario e senha de teste.
    DtoLogin dtoLogin = new DtoLogin("usuario teste","teste","1234");
    DtoLogin dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonEntrar = findViewById(R.id.buttonEntrar);//Atribuindo do objeto para a classe
        buttonCancelar = findViewById(R.id.buttonCancelar);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);



     buttonEntrar.setOnClickListener(view -> {
        String usuario = txtUsuario.getText().toString();
        String senha =  txtSenha.getText().toString();
        logar(usuario,senha);

    });
        buttonCancelar.setOnClickListener(view -> {
            // Limpar os campos de texto.
            txtUsuario.setText("");
            txtSenha.setText("");
        });

}
    private  void logar(String usuario, String senha){
        // DtoLogin dtoLogin = dao.



        if(dtoLogin.autenticar(usuario,senha)){
            //Ir para a tela de menu.
            Intent telaMenu = new Intent(getApplicationContext(),ActivityTelaMenu.class);
            startActivity(telaMenu);
        }else{
            Toast.makeText(this, "Usuario ou Senha incorretos!", Toast.LENGTH_SHORT).show();
        }
     }
  }





