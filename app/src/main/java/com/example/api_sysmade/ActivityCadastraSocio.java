package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import com.example.api_sysmade.database.DaoSocio;
import com.example.api_sysmade.database.DtoSocio;

public class ActivityCadastraSocio extends AppCompatActivity {
    Button buttonVoltarCadSocio;
    Button buttonCadastrarSocio;
    Button buttonCancelCadSocio;

    EditText editTextSenhaSocio;
    EditText editTextNomeSocio;
    EditText editTextCpfSocio;
    EditText editTextCargoSocio;
    EditText editTextEndSocio;
    EditText editTextTelSocio;
    EditText editTextEmailSocio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_socio);

        buttonCadastrarSocio = findViewById(R.id.buttonCadastrarContrato);
        buttonCancelCadSocio = findViewById(R.id.buttonCancelCadContrato);
        buttonVoltarCadSocio = findViewById(R.id.buttonVoltarCadContrato);

        editTextSenhaSocio = findViewById(R.id.editTextCpfCliContrato);
        editTextNomeSocio = findViewById(R.id.editTextCnpjEmpresa);
        editTextCpfSocio = findViewById(R.id.editTextTelEmpresa);
        editTextCargoSocio = findViewById(R.id.editTextTipoSistema);
        editTextEndSocio = findViewById(R.id.editTextNomeDevResp);
        editTextTelSocio = findViewById(R.id.editTextDataIniProjeto);
        editTextEmailSocio = findViewById(R.id.editTextDataFinalProjeto);
        voltarAoMenuSocio();

        buttonCadastrarSocio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DtoSocio dtoSocio = new DtoSocio(editTextSenhaSocio.getText().toString(),
                        editTextNomeSocio.getText().toString(),
                        editTextCpfSocio.getText().toString(),
                        editTextCargoSocio.getText().toString(),
                        editTextEndSocio.getText().toString(),
                        editTextTelSocio.getText().toString(),
                        editTextEmailSocio.getText().toString());
                DaoSocio daoSocio = new DaoSocio(getApplicationContext());
                try {
                    if (daoSocio.inserirSocio(dtoSocio) > 0) {
                        Toast.makeText(ActivityCadastraSocio.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.d("Erro-ao-inserir: ", ex.toString());
                    Toast.makeText(ActivityCadastraSocio.this, "Erro ao Inserir: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        // botão limpar campos
        buttonCancelCadSocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpar os campos de texto.
                editTextSenhaSocio .setText("");
                editTextNomeSocio.setText("");
                editTextCpfSocio.setText("");
                editTextCargoSocio.setText("");
                editTextEndSocio.setText("");
                editTextTelSocio.setText("");
                editTextEmailSocio.setText("");
            }
        });
    }


    // volta pra tela menu cliente
    public void voltarAoMenuSocio(){
        buttonVoltarCadSocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaSocioMenu = new Intent(getApplicationContext(), ActivityTelaSocioMenu.class);
                startActivity(telaSocioMenu);
            }
        });
    }

}
