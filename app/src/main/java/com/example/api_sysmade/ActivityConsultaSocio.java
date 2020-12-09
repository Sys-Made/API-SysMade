package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.api_sysmade.database.DaoSocio;
import com.example.api_sysmade.database.DtoSocio;

import java.util.ArrayList;


public class ActivityConsultaSocio extends AppCompatActivity {
    Button buttonVoltarConsulSocio;
    Button buttonNovoSocio;
    ListView listViewSocio;
    ArrayList<DtoSocio> arrayListSocio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_socio);
        buttonVoltarConsulSocio = findViewById(R.id.buttonVoltarConsulSocio);
        buttonNovoSocio = findViewById(R.id.buttonNovoSocio);
        listViewSocio = findViewById(R.id.listViewSocio);
        DaoSocio daoSocio = new DaoSocio(getApplicationContext());
        voltarAoMenuSocio();

        arrayListSocio = daoSocio.consultarTodosSocio();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arrayListSocio);

        listViewSocio.setAdapter(adapter);



        cadastrarNovoSocio();
    }

    private void cadastrarNovoSocio(){
        buttonNovoSocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoSocio = new Intent(getApplicationContext(),ActivityCadastraSocio.class);
                startActivity(novoSocio);
            }
        });
    }

    public void voltarAoMenuSocio(){
        buttonVoltarConsulSocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaSocioMenu = new Intent(getApplicationContext(), ActivityTelaSocioMenu.class);
                startActivity(telaSocioMenu);
            }
        });

    }

}

