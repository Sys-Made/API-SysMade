package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityCadastraCliente extends AppCompatActivity {
    Button buttonVoltarCadCli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_cliente);
        buttonVoltarCadCli = findViewById(R.id.buttonVoltarCadCli);
        voltarAoMenuCliente();
    }

    public void voltarAoMenuCliente(){
        buttonVoltarCadCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaClienteMenu = new Intent(getApplicationContext(), ActivityTelaClienteMenu.class);
                startActivity(telaClienteMenu);
            }
        });
    }
}