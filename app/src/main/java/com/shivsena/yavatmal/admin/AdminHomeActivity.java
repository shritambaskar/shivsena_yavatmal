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
                Intent intent = new Intent(AdminHomeActivity.this,AdminYavtamalActivity.class);
                String vidhansabha = "यवतमाळ_विधानसभा";
                intent.putExtra("vidhansabha",vidhansabha);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_admin_umarkhed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomeActivity.this,AdminYavtamalActivity.class);
                String vidhansabha = "उमरखेड_विधानसभा";
                intent.putExtra("vidhansabha",vidhansabha);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_admin_digras).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomeActivity.this,AdminYavtamalActivity.class);
                String vidhansabha = "दिग्रस_विधानसभा";
                intent.putExtra("vidhansabha",vidhansabha);
                startActivity(intent);
            }
        });
    }
}