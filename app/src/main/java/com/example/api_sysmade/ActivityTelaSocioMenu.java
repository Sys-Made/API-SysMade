package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ActivityTelaSocioMenu extends AppCompatActivity {
    Button buttonVoltarSocioMenu;
    Button buttonChamaCadSocio;
    Button buttonChamaConsulSocio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socio_menu);
        buttonVoltarSocioMenu = findViewById(R.id.buttonVoltarSocioMenu);
        buttonChamaCadSocio = findViewById(R.id.buttonChamaCadSocio);
        buttonChamaConsulSocio = findViewById(R.id.buttonChamaConsulSocio);
        voltarAoMenu2();
        abrirCadSocio();
        abrirConsulSocio();
    }

    public void voltarAoMenu2(){
        buttonVoltarSocioMenu.setOnClickListener(v -> {
            Intent telaMenu = new Intent(getApplicationContext(), ActivityTelaMenu.class);
            startActivity(telaMenu);
        });
    }

    //Metodo que direciona o usuario para a tela de cadastro de sócios
    public void abrirCadSocio(){
        buttonChamaCadSocio.setOnClickListener(v -> {
            Intent telaCadSocio = new Intent(getApplicationContext(), ActivityCadastraSocio.class);
            startActivity(telaCadSocio);
        });
    }

    //Metodo que direciona o usuario para a tela de consultas de sócios
    public void abrirConsulSocio(){
        buttonChamaConsulSocio.setOnClickListener(v -> {
            Intent telaConsulSocio = new Intent(getApplicationContext(), ActivityConsultaSocio.class);
            startActivity(telaConsulSocio);
        });
    }
}