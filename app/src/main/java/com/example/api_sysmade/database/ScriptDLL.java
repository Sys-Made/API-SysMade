package com.example.api_sysmade.database;

public class ScriptDLL {

    public static String getCreateTableCliente(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS FUNCIONARIO(");
        sql.append("    CODIGOFUNC INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append("    NOME VARCHAR (80) NOT NULL DEFAULT(''),");
        sql.append("    EMAIL VARCHAR (50) NOT NULL DEFAULT(''),");
        sql.append("    SENHA VARCHAR (20) NOT NULL DEFAULT(''),");
        sql.append("    CPF VARCHAR(14) NOT NULL DEFAULT(''),");
        sql.append("    ENDERECO VARCHAR(100) NOT NULL DEFAULT(''),");
        sql.append("    TELEFONE VARCHAR(12) NOT NULL DEFAULT(''),");
        sql.append("    CELULAR VARCHAR(13) NOT NULL DEFAULT('') )");

        return sql.toString();
    }
}
