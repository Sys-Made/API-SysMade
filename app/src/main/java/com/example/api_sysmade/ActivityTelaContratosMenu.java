package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaContratosMenu extends AppCompatActivity {
    Button buttonVoltarContratoMenu;
    Button buttonChamaCadContrato;
    Button buttonChamaConsulContrato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contratos_menu);
        buttonVoltarContratoMenu = findViewById(R.id.buttonVoltarContratoMenu);
        buttonChamaCadContrato = findViewById(R.id.buttonChamaCadContrato);
        buttonChamaConsulContrato = findViewById(R.id.buttonChamaConsulContrato);
        voltarAoMenu3();
        abrirCadContrato();
        abrirConsulContrato();
    }

    public void voltarAoMenu3(){
        buttonVoltarContratoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMenu = new Intent(getApplicationContext(), ActivityTelaMenu.class);
                startActivity(telaMenu);
            }
        });
    }

    //Metodo que direciona o usuario para a tela de cadastro de contratos
    public void abrirCadContrato(){
        buttonChamaCadContrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaCadContrato = new Intent(getApplicationContext(), ActivityCadastraContrato.class);
                startActivity(telaCadContrato);
            }
        });
    }

    //Metodo que direciona o usuario para a tela de consultas de contratos
    public void abrirConsulContrato(){
        buttonChamaConsulContrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaConsulContrato = new Intent(getApplicationContext(), ActivityConsultaContrato.class);
                startActivity(telaConsulContrato);
            }
        });
    }
}