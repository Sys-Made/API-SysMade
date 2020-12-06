package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaSobre extends AppCompatActivity {
    Button buttonVoltarSobre; //Atribuindo objeto ao botao
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre);
        buttonVoltarSobre = findViewById(R.id.buttonVoltarSobre);
        voltarAoMenu();
    }

    public void voltarAoMenu(){
        buttonVoltarSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMenu = new Intent(getApplicationContext(), ActivityTelaMenu.class);
                startActivity(telaMenu);
            }
        });
    }
}