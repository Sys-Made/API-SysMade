package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.api_sysmade.database.DaoCliente;
import com.example.api_sysmade.database.DtoCliente;

import java.util.ArrayList;

public class ActivityConsultaCliente extends AppCompatActivity {
    Button buttonVoltarConsulCli;
    Button buttonNovoCli;
    ListView listViewCliente;
    ArrayList<DtoCliente> arrayListCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_cliente);
        buttonVoltarConsulCli = findViewById(R.id.buttonVoltarConsulCli);
        buttonNovoCli = findViewById(R.id.buttonNovoCli);
        listViewCliente = findViewById(R.id.listViewCliente);
        DaoCliente daoCliente = new DaoCliente(getApplicationContext());
        voltarAoMenuCliente();

        arrayListCliente = daoCliente.consultarTodos();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arrayListCliente);

        listViewCliente.setAdapter(adapter);



        cadastrarNovoCliente();
    }

        private void cadastrarNovoCliente(){
            buttonNovoCli.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent novoCliente = new Intent(getApplicationContext(),ActivityCadastraCliente.class);
                    startActivity(novoCliente);
                }
            });
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

