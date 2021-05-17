package com.example.api_sysmade;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import com.example.api_sysmade.database.DaoCliente;
import com.example.api_sysmade.database.DtoCliente;

public class ActivityCadastraCliente extends AppCompatActivity {
    Button buttonVoltarCadCli;
    Button buttonCadCli;
    Button buttonCancelCadCli;

    EditText editTextNomeCli;
    EditText editTextCpfCnpjCli;
    EditText editTextTelCli;
    EditText editTextEndCli;
    EditText editTextEmailCli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_cliente);

        buttonCadCli = findViewById(R.id.buttonCadCli);
        buttonCancelCadCli = findViewById(R.id.buttonCancelCadCli);
        buttonVoltarCadCli = findViewById(R.id.buttonVoltarCadCli);

        editTextNomeCli = findViewById(R.id.editTextNomeCli);
        editTextCpfCnpjCli = findViewById(R.id.editTextCpfCnpjCli);
        editTextTelCli = findViewById(R.id.editTextTelCli);
        editTextEndCli = findViewById(R.id.editTextEndCli);
        editTextEmailCli = findViewById(R.id.editTextEmailCli);
        voltarAoMenuCliente();

        buttonCadCli.setOnClickListener(v -> {
            DtoCliente dtoCliente = new DtoCliente(editTextNomeCli.getText().toString(),
                    editTextCpfCnpjCli.getText().toString(),
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
        });
        // botão limpar campos
        buttonCancelCadCli.setOnClickListener(view -> {
            // Limpar os campos de texto.
            editTextNomeCli.setText("");
            editTextCpfCnpjCli.setText("");
            editTextTelCli.setText("");
            editTextEndCli.setText("");
            editTextEmailCli.setText("");
        });
    }


        // volta pra tela menu cliente
        public void voltarAoMenuCliente(){
            buttonVoltarCadCli.setOnClickListener(v -> {
                Intent telaClienteMenu = new Intent(getApplicationContext(), ActivityTelaClienteMenu.class);
                startActivity(telaClienteMenu);
            });
        }

}













