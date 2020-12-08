package com.example.api_sysmade.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DaoSocio extends SQLiteOpenHelper {
    private final String TABELA_FUNC = "TB_FUNC";


    public DaoSocio(@Nullable Context context ){

        super(context, "DB_SYSMADE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String comandoSocio = "CREATE TABLE "+ TABELA_FUNC +" (" +
                "ID INTEGER PRIMARY KEY," +
                "SENHA VARCHAR(10)," +
                "NOME VARCHAR(100)," +
                "CPF VARCHAR(20)," +
                "CARGO VARCHAR(50)," +
                "ENDERECO VARCHAR(50)," +
                "TELEFONE VARCHAR(15)," +
                "EMAIL VARCHAR(50))";

        sqLiteDatabase.execSQL(comandoSocio);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Long inserir(DtoSocio dtoSocio){
        ContentValues values = new ContentValues();

        values.put("SENHA", dtoSocio.getSenha());
        values.put("NOME", dtoSocio.getNome());
        values.put("CPF", dtoSocio.getCpf());
        values.put("CARGO", dtoSocio.getCargo());
        values.put("ENDERECO", dtoSocio.getEndereco());
        values.put("TELEFONE", dtoSocio.getTelefone());
        values.put("EMAIL", dtoSocio.getEmail());

        long nLinhas = getWritableDatabase().insert(TABELA_FUNC, null, values);
        return nLinhas;
    }


    public ArrayList<DtoSocio> consultarTodosSocio(){
        String comandoSocio  = "SELECT * FROM " + TABELA_FUNC;
        Cursor cursor = getReadableDatabase().rawQuery(comandoSocio,null);
        ArrayList<DtoSocio> listaSocios = new ArrayList<>();

        while (cursor.moveToNext()){
            DtoSocio dtoSocio = new DtoSocio();
            dtoSocio.setId(cursor.getInt(0));
            dtoSocio.setSenha(cursor.getString(1));
            dtoSocio.setNome(cursor.getString(2));
            dtoSocio.setCpf(cursor.getString(3));
            dtoSocio.setCargo(cursor.getString(4));
            dtoSocio.setEndereco(cursor.getString(5));
            dtoSocio.setTelefone(cursor.getString(6));
            dtoSocio.setEmail(cursor.getString(7));
            listaSocios.add(dtoSocio);
        }

        return listaSocios;
    }

}
