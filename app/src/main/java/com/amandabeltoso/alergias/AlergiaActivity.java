package com.amandabeltoso.alergias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amandabeltoso.alergias.DAO.BDalergia;
import com.amandabeltoso.alergias.DAO.BDusuario;
import com.amandabeltoso.alergias.Model.Alergia;
import com.amandabeltoso.alergias.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AlergiaActivity extends AppCompatActivity {

    private Usuario usuario1;
    private ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    private BDalergia bDalergia = new BDalergia(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alergia);

        listView = findViewById(R.id.lv_alergias);
        listarA();
    }

    public void listarA(){
        List<Alergia> list = bDalergia.buscarAlergia();
        Toast.makeText(this,String.valueOf(bDalergia.buscarAlergia().size()),Toast.LENGTH_LONG);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(AlergiaActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        for (Alergia a : list){
            arrayList.add(a.getId() + " - " + a.getAlergia());
            adapter.notifyDataSetChanged();
        }
    }





}
