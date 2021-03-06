package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ActivityTelaMenu extends AppCompatActivity {
    Button buttonSair;//Declarando objeto botao logout
    Button buttonSocio;
    Button buttonCliente;
    Button buttonMapa;
    Button buttonSobre;
    Button buttonServicos;
    Button buttonContrato;
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
        buttonSobre = findViewById(R.id.buttonSobre);
        abrirSobre();
        buttonServicos = findViewById(R.id.buttonServicos);
        abrirServicos();
        buttonContrato = findViewById(R.id.buttonContrato);
        abrirContratos();
    }


    //Metodo que faz retornar a tela de login
    public void voltarAoLogin(){
        buttonSair.setOnClickListener(v -> {
            Intent telaLogin = new Intent(getApplicationContext(),ActivityTelaLogin.class);
            startActivity(telaLogin);
        });
    }


    //Metodo que direciona o usuario para a tela de MenuSocio
    public void abrirSocioMenu(){
        buttonSocio.setOnClickListener(v -> {
            Intent telaSocioMenu = new Intent(getApplicationContext(),ActivityTelaSocioMenu.class);
            startActivity(telaSocioMenu);
        });
    }


    //Metodo que direciona o usuario para a tela de MenuCliente
    public void abrirClienteMenu(){
        buttonCliente.setOnClickListener(v -> {
            Intent telaClienteMenu = new Intent(getApplicationContext(),ActivityTelaClienteMenu.class);
            startActivity(telaClienteMenu);
        });
    }

    //Metodo que direciona o usuario para a tela de Mapa
    public void abrirMapa(){
        buttonMapa.setOnClickListener(v -> {
            Intent telaMapa = new Intent(getApplicationContext(), ActivityMapa.class);
            startActivity(telaMapa);
        });
    }

    //Metodo que direciona o usuario para a tela Sobre
    public void abrirSobre(){
        buttonSobre.setOnClickListener(v -> {
            Intent telaSobre = new Intent(getApplicationContext(), ActivityTelaSobre.class);
            startActivity(telaSobre);
        });
    }

    private void abrirServicos(){
        buttonServicos.setOnClickListener(v -> {
            Intent servicos = new Intent(getApplicationContext(), ActivityTelaServicos.class);
            startActivity(servicos);
        });
    }

    private void abrirContratos(){
        buttonContrato.setOnClickListener(v -> {
            Intent contratos = new Intent(getApplicationContext(), ActivityTelaContratosMenu.class);
            startActivity(contratos);
        });
    }
}