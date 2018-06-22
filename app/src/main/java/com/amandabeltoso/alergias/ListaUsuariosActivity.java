package com.amandabeltoso.alergias;

import android.content.Intent;
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
    private ViewHolder vm = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        this.vm.listView = findViewById(R.id.listView);
        listarU();

    }


        public void listarU(){
            final List<Usuario> list = bDusuario.buscar();
            Toast.makeText(this,String.valueOf(bDusuario.buscar().size()),Toast.LENGTH_LONG);
            arrayList = new ArrayList<String>();
            adapter = new ArrayAdapter<String>(ListaUsuariosActivity.this, android.R.layout.simple_list_item_1, arrayList);
           this.vm.listView.setAdapter(adapter);

            for (Usuario u : list){
                arrayList.add(u.getId() + " - " + u.getNome());
                adapter.notifyDataSetChanged();
            }

            this.vm.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent detalheItent = new Intent(ListaUsuariosActivity.this, DetalheUsuarioActivity.class);
                    detalheItent.putExtra("nome",list.get(position).getNome());
                    detalheItent.putExtra("idade",String.valueOf(list.get(position).getIdade()));
                    detalheItent.putExtra("telefone",list.get(position).getTelefone());
                    detalheItent.putExtra("sus",String.valueOf(list.get(position).getCartaoSus()));
                    detalheItent.putExtra("email", String.valueOf(list.get(position).getEmail()));

                    startActivity(detalheItent);
                }
            });


    }

    private static class ViewHolder {

        ListView listView;
    }


    }



