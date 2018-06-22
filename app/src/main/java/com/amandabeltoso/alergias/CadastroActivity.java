package com.amandabeltoso.alergias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amandabeltoso.alergias.DAO.BDusuario;
import com.amandabeltoso.alergias.Model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private viewHolder vm = new viewHolder();
    private Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.vm.editNome = findViewById(R.id.edit_nome);
        this.vm.editIdade = findViewById(R.id.edit_idade);
        this.vm.editTelefone = findViewById(R.id.edt_telefone);
        this.vm.editsus = findViewById(R.id.edit_sus);
        this.vm.editEmail = findViewById(R.id.edit_emai);
        this.vm.editSenha = findViewById(R.id.edit_senhaForm);
    }

    public void inserirUsuario(View view){
        BDusuario  bd = new BDusuario(CadastroActivity.this);
        String nome = this.vm.editNome.getText().toString();
        String idade = this.vm.editIdade.getText().toString();
        String telefone = this.vm.editTelefone.getText().toString();
        String cartaoSus = this.vm.editsus.getText().toString();
        String email = this.vm.editEmail.getText().toString();
        String senha = this.vm.editSenha.getText().toString();
        if(nome.isEmpty() || idade.isEmpty() || telefone.isEmpty() || email.isEmpty() || senha.isEmpty()){

            Toast.makeText(CadastroActivity.this,"Preencha todos os dados marcados com *", Toast.LENGTH_LONG).show();

        }else{
            usuario = new Usuario();
            usuario.setNome(this.vm.editNome.getText().toString());
            usuario.setIdade(Integer.valueOf(this.vm.editIdade.getText().toString()));
            usuario.setTelefone(this.vm.editTelefone.getText().toString());
            usuario.setCartaoSus(Integer.valueOf(this.vm.editsus.getText().toString()));
            usuario.setEmail(this.vm.editEmail.getText().toString());
            usuario.setSenha(this.vm.editSenha.getText().toString());
            bd.inserir(usuario);
            Toast.makeText(CadastroActivity.this,"Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }






    private static class viewHolder{

        EditText editNome;
        EditText editIdade;
        EditText editTelefone;
        EditText editsus;
        EditText editEmail;
        EditText editSenha;
    }
}
