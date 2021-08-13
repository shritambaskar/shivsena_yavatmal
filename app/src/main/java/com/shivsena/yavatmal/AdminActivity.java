package com.shivsena.yavatmal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shivsena.yavatmal.admin.AdminHomeActivity;

public class AdminActivity extends AppCompatActivity {

    private Button admin_login;
    private EditText admin_email,admin_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        initialise();
        this.admin_login.setOnClickListener(this::AdminloginHere);
    }

    private void AdminloginHere(View view) {
        String admin_e= admin_email.getText().toString();
        String admin_p = admin_pass.getText().toString();

        if (admin_e.equals("adminshivsena.yavatmal@gmail.com")&&admin_p.equals("adminyavatmal")){

            startActivity(new Intent(AdminActivity.this, AdminHomeActivity.class));
            AdminActivity.this.finish();
        }
        else{
            Toast.makeText(AdminActivity.this, "Admin Login Failed...", Toast.LENGTH_SHORT).show();
        }
    }

    private void initialise() {
        admin_email = findViewById(R.id.admin_email);
        admin_pass = findViewById(R.id.admin_password);
        admin_login = findViewById(R.id.btn_admin_login);
    }
}