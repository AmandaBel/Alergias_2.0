package com.amandabeltoso.alergias.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amanda Beltoso on 25/05/2018.
 */

public class CreateBanco extends SQLiteOpenHelper {

    private static final String NOME_BD = "Tabela";
    private static final String NOME_TABELA = "Usuarios";
    private static final String NOME_TABELA2 = "Alergias";
    private static final Integer VERSAO = 1;

    public CreateBanco(Context context) {
        super(context, NOME_BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
//        String tabelaAlergia = ("create table" + NOME_TABELA2 +  "(id integer primary key autoincrement, alergia text, descricao, text, usuario integer, foreign key(usuario) references Usuarios(id)");
        bd.execSQL("create table " + NOME_TABELA + "(_id integer primary key autoincrement, nome text,idade integer, telefone text, sus integer, email text, senha text);");
        bd.execSQL("create table " + NOME_TABELA2 +  "(_id integer primary key autoincrement, alergia text, descricao text, usuario integer, foreign key(usuario) references Usuarios(_id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
//        String drop = "drop table " + NOME_TABELA2;
        bd.execSQL("drop table " + NOME_TABELA);
        bd.execSQL("drop table " + NOME_TABELA2);
        onCreate(bd);
    }
}
