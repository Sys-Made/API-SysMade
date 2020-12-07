package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaClienteMenu extends AppCompatActivity {
    Button buttonVoltarCliMenu;
    Button buttonChamaCadCli;
    Button buttonChamaConsulCli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_menu);
        buttonVoltarCliMenu = findViewById(R.id.buttonVoltarCliMenu);
        buttonChamaCadCli = findViewById(R.id.buttonChamaCadCli);
        buttonChamaConsulCli = findViewById(R.id.buttonChamaConsulCli);
        voltarAoMenu();
        abrirCadCli();
        abrirConsulCli();
    }

    public void voltarAoMenu(){
        buttonVoltarCliMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMenu = new Intent(getApplicationContext(), ActivityTelaMenu.class);
                startActivity(telaMenu);
            }
        });
    }

    //Metodo que direciona o usuario para a tela de cadastro de clientes
    public void abrirCadCli(){
        buttonChamaCadCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaCadCli = new Intent(getApplicationContext(), ActivityCadastraCliente.class);
                startActivity(telaCadCli);
            }
        });
    }

    //Metodo que direciona o usuario para a tela de consultas de clientes
    public void abrirConsulCli(){
        buttonChamaConsulCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaConsulCli = new Intent(getApplicationContext(), ActivityConsultaCliente.class);
                startActivity(telaConsulCli);
            }
        });
    }
}