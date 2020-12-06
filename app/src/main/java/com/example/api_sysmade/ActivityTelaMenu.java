package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaMenu extends AppCompatActivity {
    Button buttonSair;//Declarando objeto botao logout
    Button buttonSocio;
    Button buttonCliente;
    Button buttonMapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonSair = findViewById(R.id.buttonSair);
        voltarAoLogin();
        buttonSocio = findViewById(R.id.buttonSocio);
        abrirSocioMenu();
        buttonCliente = findViewById(R.id.buttonCliente);
        abrirClienteMenu();
        buttonMapa = findViewById(R.id.buttonMapa);
        abrirMapa();
    }


    //Metodo que faz retornar a tela de login
    public void voltarAoLogin(){
        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaLogin = new Intent(getApplicationContext(),ActivityTelaLogin.class);
                startActivity(telaLogin);
            }
        });
    }


    //Metodo que direciona o usuario para a tela de MenuSocio
    public void abrirSocioMenu(){
        buttonSocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaSocioMenu = new Intent(getApplicationContext(),ActivityTelaSocioMenu.class);
                startActivity(telaSocioMenu);
            }
        });
    }


    //Metodo que direciona o usuario para a tela de MenuCliente
    public void abrirClienteMenu(){
        buttonCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaClienteMenu = new Intent(getApplicationContext(),ActivityTelaClienteMenu.class);
                startActivity(telaClienteMenu);
            }
        });
    }

    //Metodo que direciona o usuario para a tela de Mapa
    public void abrirMapa(){
        buttonMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMapa = new Intent(getApplicationContext(), ActivityMapa.class);
                startActivity(telaMapa);
            }
        });
    }
}