package com.amandabeltoso.alergias.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.amandabeltoso.alergias.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amanda Beltoso on 25/05/2018.
 */

public class BDusuario {

    private SQLiteDatabase database;
    private CreateBanco bdaux;
    private static final String NOME_TABELA = "Usuarios";


    public BDusuario(Context context) {

        bdaux = new CreateBanco(context);
    }

    public void inserir(Usuario usuario) {
        database = bdaux.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("idade", usuario.getIdade());
        values.put("Telefone", usuario.getTelefone());
        values.put("sus", usuario.getCartaoSus());
        values.put("Email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        database.insert(NOME_TABELA, null, values);
        database.close();
    }


    public List<Usuario> buscar() {

        List<Usuario> usuarios = new ArrayList<Usuario>();

        String[] colunas = new String[]{"id", "nome", "idade", "telefone", "sus", "email", "senha"};
        database = bdaux.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from Usuarios", null);
//        Cursor cursor = database.query("Usuarios", colunas, null, null, null, null, "nome ASC");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Usuario usuario = new Usuario();
                usuario.setId(Integer.valueOf(cursor.getString(0)));
                usuario.setNome(cursor.getString(1));
                usuario.setIdade(cursor.getInt(2));
                usuario.setTelefone(cursor.getString(3));
                usuario.setCartaoSus(cursor.getInt(4));
                usuario.setEmail(cursor.getString(5));
                usuario.setSenha(cursor.getString(6));
                usuarios.add(usuario);

            } while (cursor.moveToNext());
        }
        return (usuarios);
    }

    public Usuario selecionarUsuario(int id) {

        Cursor cursor;
        database = bdaux.getReadableDatabase();
        String[] colunasUsadas = new String[]{"_id", "nome", "idade", "telefone", "sus", "email", "senha"};
//        cursor = database.rawQuery("select id,nome,idade,telefone,sus,email,senha from Usuarios where id = id ",null);
        cursor = database.query(NOME_TABELA, colunasUsadas, "_id = ?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToNext();
        }

        Usuario usuario1 = new Usuario();
        usuario1.setId(Integer.valueOf(cursor.getInt(0)));
        usuario1.setNome(cursor.getString(1));
        usuario1.setId(cursor.getInt(2));
        usuario1.setTelefone(cursor.getString(3));
        usuario1.setCartaoSus(cursor.getInt(4));
        usuario1.setEmail(cursor.getString(5));
        usuario1.setSenha(cursor.getString(6));
        return usuario1;
    }

    public Usuario carregaDadoById(int id) {
        database = bdaux.getReadableDatabase();
        Cursor cursor;
        String[] colunasUsadas = new String[]{"_id", "nome", "idade", "telefone", "sus", "email", "senha"};
        String where = "_id=" + id;
        cursor = database.query(NOME_TABELA, colunasUsadas, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Usuario usuario1 = new Usuario();
        usuario1.setId(cursor.getInt(0));
        usuario1.setNome(cursor.getString(1));
        usuario1.setId(cursor.getInt(2));
        usuario1.setTelefone(cursor.getString(3));
        usuario1.setCartaoSus(cursor.getInt(4));
        usuario1.setEmail(cursor.getString(5));
        usuario1.setSenha(cursor.getString(6));
        database.close();
        return usuario1;
    }

    public Usuario selecionarUsuarioEmail(String email) {


        database = bdaux.getReadableDatabase();
        String[] colunasUsadas = new String[]{"_id", "nome", "idade", "telefone", "sus", "email", "senha"};
        Cursor cursor = database.query(NOME_TABELA, colunasUsadas, "email = ?", new String[]{email}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Usuario usuario1 = new Usuario();
        usuario1.setId(cursor.getInt(0));
        usuario1.setNome(cursor.getString(1));
        usuario1.setId(cursor.getInt(2));
        usuario1.setTelefone(cursor.getString(3));
        usuario1.setCartaoSus(cursor.getInt(4));
        usuario1.setEmail(cursor.getString(5));
        usuario1.setSenha(cursor.getString(6));
        return usuario1;
    }

//    public Usuario montaUsuario(Cursor cursor) {
//        if (cursor.getCount() == 0) {
//            return null;
//        }
//        Integer id = cursor.getInt(cursor.getColumnIndex("_id"));
//        String nome = cursor.getString(cursor.getColumnIndex("nome"));
//        Integer idade = cursor.getInt(cursor.getColumnIndex("idade"));
//        String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
//        Integer sus = cursor.getInt(cursor.getColumnIndex("sus"));
//        String email = cursor.getString(cursor.getColumnIndex("email"));
//        String senha = cursor.getString(cursor.getColumnIndex("senha"));
//        return new Usuario(id,nome,idade,telefone,sus,email,senha);
//    }
//
//    public Usuario findByLogin(String email, String senha) {
//        String sql = "SELECT * FROM  USUARIOS WHERE email = ? AND senha = ?";
//        String[] selectionArgs = new String[]{email, senha};
//        Cursor cursor = database.rawQuery(sql, selectionArgs);
//        cursor.moveToFirst();
//        return montaUsuario(cursor);
//    }


    public Usuario getUser(String email, String senha) {
        database = bdaux.getReadableDatabase();
        String[] colunasUsadas = new String[]{"_id", "nome", "idade", "telefone", "sus", "email", "senha"};
//        Cursor cursor = database.rawQuery("select * from Usuarios where email = '" + email + " 'and senha = '" + senha + "'", null);
        Cursor cursor = database.query(NOME_TABELA, colunasUsadas, "email = ? and senha = ?", new String[]{email, senha}, null, null, null, null);

        Usuario usuario1 = null;

        if (cursor.moveToFirst()) {
            usuario1 = new Usuario();
            usuario1.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            usuario1.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            usuario1.setIdade(cursor.getInt(cursor.getColumnIndex("idade")));
            usuario1.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            usuario1.setCartaoSus(cursor.getInt(cursor.getColumnIndex("sus")));
            usuario1.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            usuario1.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
        }


        return usuario1;


    }

}
