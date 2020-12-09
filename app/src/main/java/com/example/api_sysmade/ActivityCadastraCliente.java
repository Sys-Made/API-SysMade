package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api_sysmade.database.DaoCliente;
import com.example.api_sysmade.database.DtoCliente;

public class ActivityCadastraCliente extends AppCompatActivity {
    Button buttonCadastrarCliente;
    Button buttonCancelCadCli;
    Button buttonVoltarCadCli;

    EditText editTextNomeCli;
    EditText editTextCpf_Cnpj;
    EditText editTextTelCli;
    EditText editTextEndCli;
    EditText editTextEmailCli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_cliente);

        buttonCadastrarCliente = findViewById(R.id.buttonCadastrarCliente);
        buttonCancelCadCli = findViewById(R.id.buttonCancelCadCli);
        buttonVoltarCadCli = findViewById(R.id.buttonVoltarCadCli);

        editTextNomeCli = findViewById(R.id.editTextNomeCli);
        editTextCpf_Cnpj = findViewById(R.id.editTextCpf_Cnpj);
        editTextTelCli = findViewById(R.id.editTextTelCli);
        editTextEndCli = findViewById(R.id.editTextEndCli);
        editTextEmailCli = findViewById(R.id.editTextEmailCli);
        voltarAoMenuCliente();

        buttonCadastrarCliente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DtoCliente dtoCliente = new DtoCliente(editTextNomeCli.getText().toString(),
                        editTextCpf_Cnpj.getText().toString(),
                        editTextTelCli.getText().toString(),
                        editTextEndCli.getText().toString(),
                        editTextEmailCli.getText().toString());
                DaoCliente daoCliente = new DaoCliente(getApplicationContext());
                try {
                    if (daoCliente.inserirCliente(dtoCliente) > 0) {
                        Toast.makeText(ActivityCadastraCliente.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.d("Erro-ao-inserir: ", ex.toString());
                    Toast.makeText(ActivityCadastraCliente.this, "Erro ao Inserir: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        // botão limpar campos
        buttonCancelCadCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpar os campos de texto.
                editTextNomeCli.setText("");
                editTextCpf_Cnpj.setText("");
                editTextTelCli.setText("");
                editTextEndCli.setText("");
                editTextEmailCli.setText("");
            }
        });
    }


        // volta pra tela menu cliente
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













