package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityCadastraSocio extends AppCompatActivity {
    Button buttonVoltarCadSocio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_socio);
        buttonVoltarCadSocio = findViewById(R.id.buttonVoltarCadSocio);
        voltaMenuSocio();
    }

    private void voltaMenuSocio(){
        buttonVoltarCadSocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMenuSocio = new Intent(getApplicationContext(), ActivityTelaSocioMenu.class);
                startActivity(telaMenuSocio);
            }
        });
    }
}