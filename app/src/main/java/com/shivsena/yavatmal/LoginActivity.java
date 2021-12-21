package com.shivsena.yavatmal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Hello this is Comment from Ecsion
    public static final String mac = "Mac";

    public static final String MY_NAME ="user";
    public static final String FILE_NAME="login_credential";

    private Button login;
    private EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialise();
        this.login.setOnClickListener(this::loginHere);
    }

    private void loginHere(View view) {
        String e= email.getText().toString();
        String p = pass.getText().toString();

        if (e.equals("shivsena.yavatmal@gmail.com")&&p.equals("paragpingle")){
            SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
            editor.putString(MY_NAME,e);
            editor.apply();
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            LoginActivity.this.finish();
        }
        else{
            Toast.makeText(LoginActivity.this, "Login Failed...", Toast.LENGTH_SHORT).show();
        }
    }

    private void initialise() {
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.login);
    }
}