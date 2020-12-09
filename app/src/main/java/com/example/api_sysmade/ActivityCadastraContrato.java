package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api_sysmade.database.DaoContratos;
import com.example.api_sysmade.database.DtoContratos;

public class ActivityCadastraContrato extends AppCompatActivity {
    Button buttonVoltarCadContrato;
    Button buttonCadastrarContrato;
    Button buttonCancelCadContrato;

    EditText editTextNomeCliContrato;
    EditText editTextCpfCliContrato;
    EditText editTextEmailCliContrato;
    EditText editTextNomeEmpresa;
    EditText editTextCnpjEmpresa;
    EditText editTextTelEmpresa;
    EditText editTextTipoSistema;
    EditText editTextNomeDevResp;
    EditText editTextDataIniProjeto;
    EditText editTextDataFinalProjeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_contrato);

        buttonCadastrarContrato = findViewById(R.id.buttonCadastrarContrato);
        buttonCancelCadContrato = findViewById(R.id.buttonCancelCadContrato);
        buttonVoltarCadContrato = findViewById(R.id.buttonVoltarCadContrato);

        editTextNomeCliContrato = findViewById(R.id.editTextNomeCliContrato);
        editTextCpfCliContrato = findViewById(R.id.editTextCpfCliContrato);
        editTextEmailCliContrato = findViewById(R.id.editTextEmailCliContrato);
        editTextNomeEmpresa = findViewById(R.id.editTextNomeEmpresa);
        editTextCnpjEmpresa = findViewById(R.id.editTextCnpjEmpresa);
        editTextTelEmpresa = findViewById(R.id.editTextTelEmpresa);
        editTextTipoSistema = findViewById(R.id.editTextTipoSistema);
        editTextNomeDevResp = findViewById(R.id.editTextNomeDevResp);
        editTextDataIniProjeto = findViewById(R.id.editTextDataIniProjeto);
        editTextDataFinalProjeto = findViewById(R.id.editTextDataFinalProjeto);
        voltarAoMenuContratos();

        buttonCadastrarContrato.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DtoContratos dtoContratos = new DtoContratos(editTextNomeCliContrato.getText().toString(),
                        editTextCpfCliContrato.getText().toString(),
                        editTextEmailCliContrato.getText().toString(),
                        editTextNomeEmpresa.getText().toString(),
                        editTextCnpjEmpresa.getText().toString(),
                        editTextTelEmpresa.getText().toString(),
                        editTextTipoSistema.getText().toString(),
                        editTextNomeDevResp.getText().toString(),
                        editTextDataIniProjeto.getText().toString(),
                        editTextDataFinalProjeto.getText().toString());
                DaoContratos daoContratos = new DaoContratos(getApplicationContext());
                try {
                    if (daoContratos.inserirContrato(dtoContratos) > 0) {
                        Toast.makeText(ActivityCadastraContrato.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.d("Erro-ao-inserir: ", ex.toString());
                    Toast.makeText(ActivityCadastraContrato.this, "Erro ao Inserir: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        // botão limpar campos
        buttonCancelCadContrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        // Limpar os campos de texto.
                        editTextNomeCliContrato.setText("");
                        editTextCpfCliContrato.setText("");
                        editTextEmailCliContrato.setText("");
                        editTextNomeEmpresa.setText("");
                        editTextCnpjEmpresa.setText("");
                        editTextTelEmpresa.setText("");
                        editTextTipoSistema.setText("");
                        editTextNomeDevResp.setText("");
                        editTextDataIniProjeto.setText("");
                        editTextDataFinalProjeto.setText("");

            }
        });
    }


    // volta pra tela menu contratos
    public void voltarAoMenuContratos(){
        buttonVoltarCadContrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaContratoMenu = new Intent(getApplicationContext(), ActivityTelaContratosMenu.class);
                startActivity(telaContratoMenu);
            }
        });
    }

}
