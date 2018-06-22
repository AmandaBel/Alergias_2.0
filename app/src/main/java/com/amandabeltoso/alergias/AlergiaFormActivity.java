package com.amandabeltoso.alergias;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amandabeltoso.alergias.DAO.BDalergia;
import com.amandabeltoso.alergias.DAO.BDusuario;
import com.amandabeltoso.alergias.Model.Alergia;
import com.amandabeltoso.alergias.Model.Usuario;

public class AlergiaFormActivity extends AppCompatActivity  {

    private  ViewHolder vm = new ViewHolder();
    private Alergia alergia1;
    public static Usuario usuario1;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alergia_form);

        this.vm.editAlergia = findViewById(R.id.edit_alergia);
        this.vm.editDescricao = findViewById(R.id.edit_descricao);
        this.vm.buttonSalvar = findViewById(R.id.button_salvar);
        this.vm.btnVoltar = findViewById(R.id.btn_voltar_alergiaForm);

    }




    public void inserirAlergia(View view){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        BDalergia bd = new BDalergia(AlergiaFormActivity.this);
        BDusuario bduser = new BDusuario(AlergiaFormActivity.this);
//        usuario1 = bduser.carregaDadoById(Integer.valueOf(usuario));
        String alergia = this.vm.editAlergia.getText().toString();
        String descricao = this.vm.editDescricao.getText().toString();
        usuario1 = bduser.selecionarUsuarioEmail(MainActivity.usuario1.getEmail());

        if(alergia.isEmpty() || descricao.isEmpty()){

            Toast.makeText(AlergiaFormActivity.this,"Preencha todos os dados da alergia", Toast.LENGTH_LONG).show();

        }else{
            alergia1 = new Alergia();
            alergia1.setAlergia(alergia);
            alergia1.setDescricao(descricao);
            alergia1.setUsuario(usuario1);

            bd.inserir(alergia1);
            Toast.makeText(AlergiaFormActivity.this,usuario1.getNome(), Toast.LENGTH_LONG).show();

//            usuario1 = new Usuario();
//            usuario1 = u;
//            usuario1.getAlergias().add(alergia1);

//            bundle.putString("usuario", String.valueOf(usuario));
            Intent intent1 = new Intent(AlergiaFormActivity.this, ListaAlergiaActivity.class);


            startActivity(intent1);

        }

        }

    public void voltar(View view){
        finish();
    }





    private  static  class  ViewHolder{

        EditText editAlergia;
        EditText editDescricao;
        Button buttonSalvar;
        Button btnVoltar;
    }
}
