package com.example.api_sysmade.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DadosOpenHelper extends SQLiteOpenHelper {
    private final  String TABELA_FUNCIONARIO = "TB_FUNCIONARIO";
    private final String TABELA_LOGIN = "TB_LOGIN";
    public DadosOpenHelper(Context context) {
        super(context, "Dados", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Instacia a classe ScriptDLL e aciona o metodo desta classe
        //db.execSQL(ScriptDLL.getCreateTableCliente());

        String comando = "CREATE TABLE "+ TABELA_FUNCIONARIO +" (" +
                "CODIGOFUNC INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "EMAIL VARCHAR(50)," +
                "SENHA VARCHAR(50)," +
                "CPF VARCHAR(50)," +
                "ENDERECO VARCHAR(50)," +
                "TELEFONE VARCHAR(15)," +
                "CELULAR VARCHAR(50))";

        db.execSQL(comando);

        String comandoLogin = "CREATE TABLE "+ TABELA_LOGIN +" (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "USUARIO VARCHAR(50)," +
                "SENHA VARCHAR(15))";
        db.execSQL(comandoLogin);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
