package com.amandabeltoso.alergias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amandabeltoso.alergias.DAO.BDalergia;
import com.amandabeltoso.alergias.DAO.BDusuario;
import com.amandabeltoso.alergias.Model.Alergia;
import com.amandabeltoso.alergias.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaAlergiaActivity extends AppCompatActivity {


    private ViewHolder vm = new ViewHolder();

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    private BDalergia bDalergia = new BDalergia(this);
    private BDusuario bDusuario = new BDusuario(this);
    public static Alergia alergia;
    public static Usuario usuario1 = MainActivity.usuario1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alergia);
        this.vm.listView = findViewById(R.id.listAlergia);
        this.vm.textUser = findViewById(R.id.textNomeUser);
        this.vm.btnCadAlergia = findViewById(R.id.btn_cad_alergia);
        this.vm.btnVoltar = findViewById(R.id.btn_voltar_listaAlergia);
        listarA();
    }

//    public void listarA(){
//        List<Alergia> list = bDalergia.buscarAlergia();
//        Toast.makeText(this,String.valueOf(bDalergia.buscarAlergia().size()),Toast.LENGTH_LONG);
//        arrayList = new ArrayList<String>();
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
//        listView.setAdapter(adapter);
//
//        for (Alergia a : list){
//            arrayList.add(a.getId() + " - " + a.getAlergia());
//            adapter.notifyDataSetChanged();
//        }
//    }

    public void listarA(){
        Usuario u = bDusuario.selecionarUsuarioEmail(MainActivity.usuario1.getEmail());
        final List<Alergia> list = bDalergia.buscarAlergiaID(u.getId());

        Toast.makeText(this,String.valueOf(bDalergia.buscarAlergia().size()),Toast.LENGTH_LONG);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        this.vm.listView.setAdapter(adapter);

        for (Alergia a : list){
            arrayList.add(a.getAlergia());
            adapter.notifyDataSetChanged();
        }

       this.vm.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detalheItent = new Intent(ListaAlergiaActivity.this, DetalheAlergiaActivity.class);
                detalheItent.putExtra("nomeAlergia",list.get(position).getAlergia());
                detalheItent.putExtra("descricao",list.get(position).getDescricao());

                startActivity(detalheItent);
            }
        });
    }

    public void cadastrarAlergia(View view){
        Intent intent = new Intent(ListaAlergiaActivity.this, AlergiaFormActivity.class);
        startActivity(intent);
    }

    public void voltar(View view){
        finish();
    }


    private static class ViewHolder {

        ListView listView;
        TextView textUser;
        Button btnCadAlergia;
        Button btnVoltar;
    }

}
