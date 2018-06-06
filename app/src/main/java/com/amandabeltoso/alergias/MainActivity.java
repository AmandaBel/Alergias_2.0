package com.amandabeltoso.alergias;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amandabeltoso.alergias.DAO.BDusuario;
import com.amandabeltoso.alergias.Model.Usuario;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder vm = new ViewHolder();
    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.vm.editLogin = findViewById(R.id.edit_login);
        this.vm.editSenha = findViewById(R.id.edit_senha);
        this.vm.buttonEntrar = findViewById(R.id.button_entrar);
        this.vm.buttonCadastrar = findViewById(R.id.button_cadastrar);

//        BDusuario bDusuario = new BDusuario(MainActivity.this) ;
//
//        Usuario usuario = bDusuario.selecionarUsuario(1);
//        Log.d("usuario selecionado" , "id: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", Email:" + usuario.getEmail() );


    }

//    public void login(View view) {
//        BDusuario bDusuario = new BDusuario(MainActivity.this) ;
//            if(!this.vm.editLogin.getText().toString().isEmpty() && !this.vm.editSenha.getText().toString().isEmpty()){
//
//                try {
//
//                }catch (Exception e){
//
//                }
//
//            }{
//            Toast.makeText(MainActivity.this, "Preencha todos os dados", Toast.LENGTH_LONG).show();
//        }
//
//    }

    public  void cadastrar(View view){
        Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(intent);
    }

//    public  void validarLogin(View view){
//
//        String email = this.vm.editLogin.getText().toString();
//        String senha = this.vm.editSenha.getText().toString();
//
//        usuario = new Usuario();
//        BDusuario bDusuario = new BDusuario(MainActivity.this);
//
//        Usuario usuario1 = new Usuario();
//        usuario1.setEmail(email);
//        usuario1.setSenha(senha);
//        usuario = bDusuario.selecionarUsuario(usuario1.getEmail());
//
//        if(usuario == null){
//            Toast.makeText(MainActivity.this,"Usuario não cadastrado",Toast.LENGTH_LONG).show();
//        }else{
//            if ((usuario1.getEmail().equalsIgnoreCase(usuario.getEmail()) && usuario1.getSenha().equalsIgnoreCase(usuario.getSenha())));
//                Intent intent = new Intent(MainActivity.this, AlergiaFormActivity.class);
//                startActivity(intent);
//        }
//    }

    public  void validarLogin(View view) {

        String email = this.vm.editLogin.getText().toString();
        String senha = this.vm.editSenha.getText().toString();

//        usuario = new Usuario();


        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
        } else {

            autenticar();
            Toast.makeText(this, String.valueOf(usuario.getId()), Toast.LENGTH_LONG).show();
        }
    }


       public void listar(View view){
        Intent intent = new Intent(MainActivity.this, ListaUsuariosActivity.class);
        startActivity(intent);
    }








    public void autenticar(){
        String email = this.vm.editLogin.getText().toString();
        String senha = this.vm.editSenha.getText().toString();

        BDusuario bDusuario = new BDusuario(MainActivity.this);
        usuario = bDusuario.selecionarUsuarioEmail(email);

        if(usuario == null) {
            Toast.makeText(MainActivity.this, "Usuario não cadastrado", Toast.LENGTH_LONG).show();
        }


        if(usuario.getEmail().equalsIgnoreCase(email) && usuario.getSenha().equalsIgnoreCase(senha)){
            Bundle bundle = new Bundle();

            bundle.putString("usuario", String.valueOf(usuario.getEmail()).toString());
            Intent intent = new Intent(MainActivity.this, AlergiaFormActivity.class);
            Toast.makeText(this, "Teste:" + String.valueOf(usuario.getId()), Toast.LENGTH_LONG).show();

            intent.putExtras(bundle);

                startActivity(intent);
            }else{
                Toast.makeText(MainActivity.this,"Email ou senha incorretos", Toast.LENGTH_LONG).show();

           }
        }


    private static class ViewHolder {

        EditText editLogin;
        EditText editSenha;
        Button buttonEntrar;
        Button buttonCadastrar;
    }
}
