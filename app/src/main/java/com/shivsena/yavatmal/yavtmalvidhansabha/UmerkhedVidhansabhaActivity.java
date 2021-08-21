package com.shivsena.yavatmal.yavtmalvidhansabha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shivsena.yavatmal.R;

public class UmerkhedVidhansabhaActivity extends AppCompatActivity {

    private Button umerkhed_upjilha_pramukh,umerkhed_upjilha_sanghatika,umerkhed_upjilha_yuva_adhikari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umerkhed_vidhansabha);
        initialise();
        this.umerkhed_upjilha_pramukh.setOnClickListener(this::upjilhaPramukh);
        this.umerkhed_upjilha_sanghatika.setOnClickListener(this::upjilhaSanghatika);
        this.umerkhed_upjilha_yuva_adhikari.setOnClickListener(this::upjilhaYuvaAdhikari);
    }

    private void upjilhaYuvaAdhikari(View view) {
        String post = "उपजिल्हा युवा अधिकारी";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upjilhaSanghatika(View view) {
        String post = "उपजिल्हा संघटीका";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upjilhaPramukh(View view) {
        String post = "उपजिल्हा प्रमुख";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void initialise() {
        umerkhed_upjilha_pramukh = findViewById(R.id.umerkhed_upjilha_pramukh);
        umerkhed_upjilha_sanghatika=findViewById(R.id.umerkhed_upjilha_sanghtika);
        umerkhed_upjilha_yuva_adhikari=findViewById(R.id.umerkhed_upjilha_yuva_adhikari);
    }
}