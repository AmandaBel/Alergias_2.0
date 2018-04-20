package com.amandabeltoso.alergias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AlergiaActivity extends AppCompatActivity {

    private String nomeAlergia;
    private String descricaoAlergia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alergia);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        nomeAlergia = bundle.getString("nomeAlergia");
        descricaoAlergia = bundle.getString("nomeAlergia");



        ListView listView = findViewById(R.id.lv_alergias);
        final ArrayList<String> AlergiasList = new ArrayList<String>();
        AlergiasList.add(nomeAlergia);
      //  AlergiasList.add("Vitamina Planetaria");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, AlergiasList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent detalheItent = new Intent(AlergiaActivity.this, DetalheAlergiaActivity.class);
                detalheItent.putExtra("nomeAlergia",AlergiasList.get(i));
                startActivity(detalheItent);
            }
        });
    }
}
