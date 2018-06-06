package com.amandabeltoso.alergias.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.amandabeltoso.alergias.Model.Alergia;
import com.amandabeltoso.alergias.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amanda Beltoso on 26/05/2018.
 */

public class BDalergia {

    private SQLiteDatabase database;
    private CreateBanco bdaux;
    private static final String NOME_TABELA = "Alergias";

    public BDalergia(Context context) {

        bdaux = new CreateBanco(context);
    }

    public void inserir(Alergia alergia) {
        database = bdaux.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("alergia", alergia.getAlergia());
        values.put("descricao", alergia.getDescricao());
        values.put("usuario", alergia.getUsuario().getId());
        database.insert(NOME_TABELA, null, values);
//        database.execSQL("insert into Alergias(alergia, descricao,usuario) values( " + alergia.getAlergia() + ","  + alergia.getDescricao() + "," + alergia.getUsuario().getId() + ");");
        database.close();
    }

    public List<Alergia> buscarAlergia(){
        List<Alergia> listAlergia = new ArrayList<Alergia>();
        String[] colunas = new String[]{"_id", "alergia", "descricao", "usuario"};
        database = bdaux.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from Alergias", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
             Alergia alergia = new Alergia();

             alergia.setId(cursor.getInt(0));
             alergia.setAlergia(cursor.getString(1));
             alergia.setDescricao(cursor.getString(2));
             Usuario usuario = new Usuario();
             usuario.setId(cursor.getInt(3));
             alergia.setUsuario(usuario);
             listAlergia.add(alergia);
            } while (cursor.moveToNext());
        }
        return (listAlergia);
    }
}



