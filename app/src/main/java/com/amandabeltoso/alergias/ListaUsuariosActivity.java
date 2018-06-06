package com.amandabeltoso.alergias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amandabeltoso.alergias.DAO.BDusuario;
import com.amandabeltoso.alergias.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuariosActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    BDusuario bDusuario = new BDusuario(this);
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        listView = findViewById(R.id.listView);
        listarU();

    }


        public void listarU(){
            List<Usuario> list = bDusuario.buscar();
            Toast.makeText(this,String.valueOf(bDusuario.buscar().size()),Toast.LENGTH_LONG);
            arrayList = new ArrayList<String>();
            adapter = new ArrayAdapter<String>(ListaUsuariosActivity.this, android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(adapter);

            for (Usuario u : list){
                arrayList.add(u.getId() + " - " + u.getNome());
                adapter.notifyDataSetChanged();
            }
    }


    }



