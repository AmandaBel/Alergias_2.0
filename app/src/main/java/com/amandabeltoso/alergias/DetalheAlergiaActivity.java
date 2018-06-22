package com.amandabeltoso.alergias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetalheAlergiaActivity extends AppCompatActivity {

    private ViewHolder vm = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_alergia);

        Intent intent  = DetalheAlergiaActivity.this.getIntent();
        String nomeAlergia = "";
        String descricao = "";

        if(intent.hasExtra("nomeAlergia")){
            nomeAlergia  = intent.getStringExtra("nomeAlergia");
        }
        if (intent.hasExtra("descricao")){
            descricao = intent.getStringExtra("descricao");
        }

        this.vm.textAlergia = findViewById(R.id.text_view_alergia);
        this.vm.textDescricao = findViewById(R.id.text_view_descricao);
        this.vm.textAlergia.setText(nomeAlergia);
        this.vm.textDescricao.setText(descricao);
    }

    private static class ViewHolder {

        TextView textAlergia;
        TextView textDescricao;
    }
}
