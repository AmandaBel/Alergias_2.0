package com.amandabeltoso.alergias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlergiaFormActivity extends AppCompatActivity implements View.OnClickListener {

    private  ViewHolder vm = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alergia_form);

        this.vm.editAlergia = findViewById(R.id.edit_alergia);
        this.vm.editDescricao = findViewById(R.id.edit_descricao);
        this.vm.buttonSalvar = findViewById(R.id.button_salvar);
        this.vm.buttonSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String alergia = String.valueOf(this.vm.editAlergia.getText().toString());
        String descricao = String.valueOf(this.vm.editDescricao.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putString("nomeAlergia", alergia);
        bundle.putString("descricaoAlergia", descricao);

        Intent intent = new Intent(AlergiaFormActivity.this, AlergiaActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }


    private  static  class  ViewHolder{

        EditText editAlergia;
        EditText editDescricao;
        Button buttonSalvar;
    }
}
