package com.shivsena.yavatmal.yavtmalvidhansabha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shivsena.yavatmal.R;

public class UmerkhedVidhansabhaActivity extends AppCompatActivity {

    private Button umerkhed_upjilha_pramukh,umerkhed_upjilha_sanghatika,umerkhed_upjilha_yuva_adhikari;
    private Button umerkhed_taluka_pramukh,umerkhed_taluka_sanghatika,umerkhed_taluka_yuva_adhikari;
    private Button umerkhed_uptaluka_pramukh,umerkhed_uptaluka_sanghatika,umerkhed_uptaluka_yuva_adhikari;
    private Button umerkhed_vibhag_pramukh,umerkhed_vibhag_sanghatika,umerkhed_vibhag_yuva_adhikari;
    private Button umerkhed_shakha_pramukh,umerkhed_shakha_sanghatika,umerkhed_shakha_yuva_adhikari;

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

        umerkhed_taluka_pramukh = findViewById(R.id.umerkhed_taluka_pramukh);
        umerkhed_taluka_sanghatika=findViewById(R.id.umerkhed_taluka_sanghtika);
        umerkhed_taluka_yuva_adhikari=findViewById(R.id.umerkhed_taluka_yuva_adhikari);

        umerkhed_uptaluka_pramukh = findViewById(R.id.umerkhed_uptaluka_pramukh);
        umerkhed_uptaluka_sanghatika=findViewById(R.id.umerkhed_uptaluka_sanghtika);
        umerkhed_uptaluka_yuva_adhikari=findViewById(R.id.umerkhed_uptaluka_yuva_adhikari);

        umerkhed_vibhag_pramukh = findViewById(R.id.umerkhed_vibhag_pramukh);
        umerkhed_vibhag_sanghatika = findViewById(R.id.umerkhed_vibhag_sanghtika);
        umerkhed_vibhag_yuva_adhikari = findViewById(R.id.umerkhed_vibhag_yuva_adhikari);

        umerkhed_shakha_pramukh = findViewById(R.id.umerkhed_shakha_pramukh);
        umerkhed_shakha_sanghatika = findViewById(R.id.umerkhed_shakha_sanghtika);
        umerkhed_shakha_yuva_adhikari = findViewById(R.id.umerkhed_shakha_yuva_adhikari);

    }
}