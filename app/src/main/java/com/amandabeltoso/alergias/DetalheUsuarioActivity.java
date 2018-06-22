package com.amandabeltoso.alergias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amandabeltoso.alergias.DAO.BDalergia;
import com.amandabeltoso.alergias.DAO.BDusuario;
import com.amandabeltoso.alergias.Model.Alergia;
import com.amandabeltoso.alergias.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DetalheUsuarioActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    private BDalergia bDalergia = new BDalergia(this);
    private BDusuario bDusuario = new BDusuario(this);
    private Usuario u = new Usuario();
    private ViewHolder vm = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_usuario);

        Intent intent  = DetalheUsuarioActivity.this.getIntent();
        String nome = "";
        String idade = "";
        String telefone = "";
        String sus = "";
        String email = "";

        if(intent.hasExtra("nome")){
            nome  = intent.getStringExtra("nome");
        }
        if (intent.hasExtra("idade")){
            idade = intent.getStringExtra("idade");
        }

        if (intent.hasExtra("telefone")){
            telefone = intent.getStringExtra("telefone");
        }

        if (intent.hasExtra("sus")){
            sus = intent.getStringExtra("sus");
        }

        if(intent.hasExtra("email")){
            email= intent.getStringExtra("email");
        }

        this.vm.textNome = findViewById(R.id.text_nome);
        this.vm.textIdade = findViewById(R.id.text_idade);
        this.vm.textTelefone = findViewById(R.id.text_telefone);
        this.vm.textSus = findViewById(R.id.text_sus);
        this.vm.listAlergiaUser = findViewById(R.id.lista_alergias_user);

        this.vm.textNome.setText(nome);
        this.vm.textIdade.setText(idade);
        this.vm.textTelefone.setText(telefone);
        this.vm.textSus.setText(sus);


         u = bDusuario.selecionarUsuarioEmail(email);

        final List<Alergia> list = bDalergia.buscarAlergiaID(u.getId());
        Toast.makeText(this,String.valueOf(bDalergia.buscarAlergia().size()),Toast.LENGTH_LONG);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        this.vm.listAlergiaUser.setAdapter(adapter);

        for (Alergia a : list){
            arrayList.add(a.getAlergia());
            adapter.notifyDataSetChanged();
        }

        this.vm.listAlergiaUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detalheItent = new Intent(DetalheUsuarioActivity.this, DetalheAlergiaActivity.class);
                detalheItent.putExtra("nomeAlergia",list.get(position).getAlergia());
                detalheItent.putExtra("descricao",list.get(position).getDescricao());
                startActivity(detalheItent);
            }
        });

    }

    private static class ViewHolder {

        TextView textNome;
        TextView textIdade;
        TextView textTelefone;
        TextView textSus;
        ListView listAlergiaUser;
    }
}
