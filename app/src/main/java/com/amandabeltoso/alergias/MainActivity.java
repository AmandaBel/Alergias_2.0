package com.amandabeltoso.alergias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder vm = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.vm.editLogin = findViewById(R.id.edit_login);
        this.vm.editSenha = findViewById(R.id.edit_senha);
        this.vm.buttonEntrar = findViewById(R.id.button_entrar);
        this.vm.buttonCadastrar = findViewById(R.id.button_cadastrar);
        this.vm.buttonEntrar.setOnClickListener(this);
        this.vm.buttonCadastrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if(id == R.id.button_entrar){

            String login = String.valueOf(this.vm.editLogin.getText().toString());
            String senha = String.valueOf(this.vm.editSenha.getText().toString());
//            Bundle bundle = new Bundle();
//            bundle.putString("login", login);
//            bundle.putString("senha", senha);

            if (login.equals("admin") || senha.equals("admin")) {
                Intent intent = new Intent(MainActivity.this, AlergiaFormActivity.class );
//                intent.putExtras(bundle);
                startActivity(intent);

            }
        }else if (id == R.id.button_cadastrar){
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        }


    }


    private static class ViewHolder {

        EditText editLogin;
        EditText editSenha;
        Button buttonEntrar;
        Button buttonCadastrar;
    }
}
