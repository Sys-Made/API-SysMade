package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaSocioMenu extends AppCompatActivity {
    Button buttonVoltarSocio; //Atribuindo objeto ao botao
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socio_menu);
        buttonVoltarSocio = findViewById(R.id.buttonVoltarSocio);
        voltarAoMenu();
    }

    public void voltarAoMenu(){
        buttonVoltarSocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMenu = new Intent(getApplicationContext(), ActivityTelaMenu.class);
                startActivity(telaMenu);
            }
        });
    }
}