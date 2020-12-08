package com.example.api_sysmade.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DaoCliente extends SQLiteOpenHelper {
    private final String TABELA_CLIENTE = "TB_CLIENTE";
    private final String TABELA_LOGIN = "TB_LOGIN";


    public DaoCliente(@Nullable Context context ){

        super(context, "DB_SYSMADE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String comandoCli = "CREATE TABLE "+ TABELA_CLIENTE +" (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "CPF_CNPJ VARCHAR(20)," +
                "TELEFONE VARCHAR(15)," +
                "EMAIL VARCHAR(50)," +
                "ENDERECO VARCHAR(50))";

        sqLiteDatabase.execSQL(comandoCli);

        String comandoLogin = "CREATE TABLE "+ TABELA_LOGIN +" (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "USUARIO VARCHAR(50)," +
                "SENHA VARCHAR(15))";
        sqLiteDatabase.execSQL(comandoLogin);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Long inserir(DtoCliente dtoCliente){
        ContentValues values = new ContentValues();

        values.put("NOME", dtoCliente.getNome());
        values.put("CPF_CNPJ", dtoCliente.getCpf_cnpj());
        values.put("TELEFONE", dtoCliente.getTelefone());
        values.put("ENDERECO", dtoCliente.getEndereco());
        values.put("EMAIL", dtoCliente.getEmail());

        long nLinhas = getWritableDatabase().insert(TABELA_CLIENTE, null, values);
        return nLinhas;
    }


    public ArrayList<DtoCliente> consultarTodos(){
        String comandoCli  = "SELECT * FROM " + TABELA_CLIENTE;
        Cursor cursor = getReadableDatabase().rawQuery(comandoCli,null);
        ArrayList<DtoCliente> listaClientes = new ArrayList<>();

        while (cursor.moveToNext()){
            DtoCliente dtoCliente = new DtoCliente();
            dtoCliente.setId(cursor.getInt(0));
            dtoCliente.setNome(cursor.getString(1));
            dtoCliente.setCpf_cnpj(cursor.getString(2));
            dtoCliente.setTelefone(cursor.getString(3));
            dtoCliente.setEndereco(cursor.getString(4));
            dtoCliente.setEmail(cursor.getString(5));
            listaClientes.add(dtoCliente);
        }

        return listaClientes;
    }
    // validação de login
    public ArrayList<DtoLogin> consultarPorUsuarioESenha(String usuario, String senha ){
        String comandoCli  = "SELECT * FROM " + TABELA_LOGIN + " WHERE USUARIO= '" + usuario + "'AND SENHA= '" + senha +"'";
        Cursor cursor = getReadableDatabase().rawQuery(comandoCli,null);
        ArrayList<DtoLogin> listaLogin = new ArrayList<>();

        while (cursor.moveToNext()){
            DtoLogin dtoLogin = new DtoLogin();
            dtoLogin.setId(cursor.getInt(0));
            dtoLogin.setNome(cursor.getString(1));
            dtoLogin.setUsuario(cursor.getString(2));
            dtoLogin.setSenha(cursor.getString(3));

            listaLogin.add(dtoLogin);
        }

        return listaLogin;
    }
}
