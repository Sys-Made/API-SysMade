package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.api_sysmade.database.DaoContratos;
import com.example.api_sysmade.database.DtoContratos;
import java.util.ArrayList;

public class ActivityConsultaContrato extends AppCompatActivity {
    Button buttonVoltarConsulContrato;
    Button buttonNovoContrato;
    ListView listViewContrato;
    ArrayList<DtoContratos> arrayListContrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_contrato);
        buttonVoltarConsulContrato = findViewById(R.id.buttonVoltarConsulContrato);
        buttonNovoContrato = findViewById(R.id.buttonNovoContrato);
        listViewContrato = findViewById(R.id.listViewContrato);
        DaoContratos daoContratos = new DaoContratos(getApplicationContext());
        voltarAoMenuContrato();

        arrayListContrato = daoContratos.consultarTodosContratos();
        ArrayAdapter<DtoContratos> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrayListContrato);

        listViewContrato.setAdapter(adapter);



        cadastrarNovoContrato();
    }

    private void cadastrarNovoContrato(){
        buttonNovoContrato.setOnClickListener(v -> {
            Intent novoContrato = new Intent(getApplicationContext(),ActivityCadastraContrato.class);
            startActivity(novoContrato);
        });
    }

    public void voltarAoMenuContrato(){
        buttonVoltarConsulContrato.setOnClickListener(v -> {
            Intent telaContratoMenu = new Intent(getApplicationContext(), ActivityTelaContratosMenu.class);
            startActivity(telaContratoMenu);
        });

    }

}