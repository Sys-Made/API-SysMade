package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityConsultaCliente extends AppCompatActivity {
    Button buttonVoltarConsulCli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_cliente);
        buttonVoltarConsulCli = findViewById(R.id.buttonVoltarConsulCli);
        voltarAoMenuCliente();
    }

    public void voltarAoMenuCliente(){
        buttonVoltarConsulCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaClienteMenu = new Intent(getApplicationContext(), ActivityTelaClienteMenu.class);
                startActivity(telaClienteMenu);
            }
        });
    }
}