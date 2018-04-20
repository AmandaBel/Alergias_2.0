package com.amandabeltoso.alergias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheAlergiaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_alergia);

        Intent intent  = DetalheAlergiaActivity.this.getIntent();
        String nomeAlergia = "";

        if(intent.hasExtra("nomeAlergia")){
            nomeAlergia  = intent.getStringExtra("nomeAlergia");
        }

        TextView textView = this.findViewById(R.id.text_view_alergia);
        textView.setText(nomeAlergia);
    }
}
