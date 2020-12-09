package com.example.api_sysmade.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DaoContratos extends SQLiteOpenHelper {
    private final String TABELA_CONTRATOS = "TB_CON";


    public DaoContratos(@Nullable Context context ){

        super(context, "DB_SYSMADE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String comandoContrato = "CREATE TABLE "+ TABELA_CONTRATOS +" (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "CPF VARCHAR(20)," +
                "EMAIL VARCHAR(50)," +
                "EMPRESA VARCHAR(50)," +
                "CNPJ VARCHAR(20)," +
                "TEL_COM VARCHAR(15)," +
                "TIPO_SYS VARCHAR(50)," +
                "DEV_RESP VARCHAR(50)," +
                "DATA_INI DATE," +
                "DATA_FIM)";

        sqLiteDatabase.execSQL(comandoContrato);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Long inserirContrato(DtoContratos dtoContratos){
        ContentValues values = new ContentValues();

        values.put("NOME", dtoContratos.getNome());
        values.put("CPF", dtoContratos.getCpf());
        values.put("EMAIL", dtoContratos.getEmail());
        values.put("EMPRESA", dtoContratos.getEmpresa());
        values.put("CNPJ", dtoContratos.getCnpj());
        values.put("TEL_COM", dtoContratos.getTel_com());
        values.put("TIPO_SYS", dtoContratos.getTipo_sys());
        values.put("DEV_RESP", dtoContratos.getDev_resp());
        values.put("DATA_INI", dtoContratos.getData_ini());
        values.put("DATA_FIM", dtoContratos.getData_fim());

        long nLinhas = getWritableDatabase().insert(TABELA_CONTRATOS, null, values);
        return nLinhas;
    }


    public ArrayList<DtoContratos> consultarTodosContratos(){
        String comandoContrato  = "SELECT * FROM " + TABELA_CONTRATOS;
        Cursor cursor = getReadableDatabase().rawQuery(comandoContrato,null);
        ArrayList<DtoContratos> listaContratos = new ArrayList<>();

        while (cursor.moveToNext()){
            DtoContratos dtoContratos = new DtoContratos();
            dtoContratos.setId(cursor.getInt(0));
            dtoContratos.setNome(cursor.getString(1));
            dtoContratos.setCpf(cursor.getString(2));
            dtoContratos.setEmail(cursor.getString(3));
            dtoContratos.setEmpresa(cursor.getString(4));
            dtoContratos.setCnpj(cursor.getString(5));
            dtoContratos.setTel_com(cursor.getString(6));
            dtoContratos.setTipo_sys(cursor.getString(7));
            dtoContratos.setDev_resp(cursor.getString(8));
            dtoContratos.setData_ini(cursor.getString(9));
            dtoContratos.setData_fim(cursor.getString(10));
            listaContratos.add(dtoContratos);
        }

        return listaContratos;
    }

}
