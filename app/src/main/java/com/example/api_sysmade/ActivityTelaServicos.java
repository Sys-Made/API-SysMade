package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaServicos extends AppCompatActivity {
    Button buttonVoltarServicos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_servicos);
        buttonVoltarServicos = findViewById(R.id.buttonVoltarServicos);
        VoltarMenu();
    }

    private void VoltarMenu(){
        buttonVoltarServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(getApplicationContext(), ActivityTelaMenu.class);
                startActivity(menu);
            }
        });
    }
}