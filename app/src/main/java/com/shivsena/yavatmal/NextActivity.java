package com.shivsena.yavatmal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shivsena.yavatmal.yavtmalvidhansabha.YavatmalVidhansabhaActivity;

public class NextActivity extends AppCompatActivity {

    private Button btn_yavatmal_vidhansabha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        btn_yavatmal_vidhansabha = findViewById(R.id.btn_yavatmal_vidhansabha);
        btn_yavatmal_vidhansabha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NextActivity.this, YavatmalVidhansabhaActivity.class));
            }
        });
    }
}