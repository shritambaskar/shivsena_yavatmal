package com.shivsena.yavatmal.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shivsena.yavatmal.R;

public class AdminHomeActivity extends AppCompatActivity {

    private Button btn_admin_yavatmal_vidhansabha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        findViewById(R.id.btn_admin_yavatmal_vidhansabha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminHomeActivity.this,AdminYavtamalActivity.class));
            }
        });
    }
}