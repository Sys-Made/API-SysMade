package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaLogin extends AppCompatActivity {
    Button buttonEntrar;//Declarando objeto botao
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonEntrar = findViewById(R.id.buttonEntrar);//Atribuindo do objeto para a classe
        abrirTelaMenu();
    }

    public void abrirTelaMenu(){
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMenu = new Intent(getApplicationContext(),ActivityTelaMenu.class);
                startActivity(telaMenu);
            }
        });
    }
}




