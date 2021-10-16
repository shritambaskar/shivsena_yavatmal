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
    private Button umerkhed_up_taluka_pramukh,umerkhed_up_taluka_sanghatika,umerkhed_up_taluka_yuva_adhikari;
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

        this.umerkhed_taluka_pramukh.setOnClickListener(this::talukaPramukh);
        this.umerkhed_taluka_sanghatika.setOnClickListener(this::talukaSanghatika);
        this.umerkhed_taluka_yuva_adhikari.setOnClickListener(this::talukaYuvaAdhikari);

        this.umerkhed_up_taluka_pramukh.setOnClickListener(this::upTalukaPramukh);
        this.umerkhed_up_taluka_sanghatika.setOnClickListener(this::upTalukaSanghatika);
        this.umerkhed_up_taluka_yuva_adhikari.setOnClickListener(this::upTalukaYuvaAdhikari);

        this.umerkhed_vibhag_pramukh.setOnClickListener(this::vibhagPramukh);
        this.umerkhed_vibhag_sanghatika.setOnClickListener(this::vibhagSanghatika);
        this.umerkhed_vibhag_yuva_adhikari.setOnClickListener(this::vibhagYuvaAdhikari);

        this.umerkhed_shakha_pramukh.setOnClickListener(this::shakhaPramukh);
        this.umerkhed_shakha_sanghatika.setOnClickListener(this::shakhaSanghatika);
        this.umerkhed_shakha_yuva_adhikari.setOnClickListener(this::shakhaYuvaAdhikari);
    }

    private void upjilhaPramukh(View view) {
        String post = "उपजिल्हा प्रमुख";
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

    private void upjilhaYuvaAdhikari(View view) {
        String post = "उपजिल्हा युवा अधिकारी";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void talukaPramukh(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "तालुका प्रमुख";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void talukaSanghatika(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "तालुका संघटीका";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void talukaYuvaAdhikari(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "तालुका युवा अधिकारी";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upTalukaPramukh(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "उपतालुका प्रमुख";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }


    private void upTalukaSanghatika(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "उपतालुका संघटीका";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upTalukaYuvaAdhikari(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "उपतालुका युवा अधिकारी";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void vibhagPramukh(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "विभाग प्रमुख";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void vibhagSanghatika(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "विभाग संघटीका";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void vibhagYuvaAdhikari(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "विभाग युवा अधिकारी";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void shakhaPramukh(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "शाखा प्रमुख";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void shakhaSanghatika(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "शाखा संघटीका";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void shakhaYuvaAdhikari(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "शाखा युवा अधिकारी";
        Intent intent = new Intent(UmerkhedVidhansabhaActivity.this,UmerkhedTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
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

        umerkhed_up_taluka_pramukh = findViewById(R.id.umerkhed_uptaluka_pramukh);
        umerkhed_up_taluka_sanghatika=findViewById(R.id.umerkhed_uptaluka_sanghtika);
        umerkhed_up_taluka_yuva_adhikari=findViewById(R.id.umerkhed_uptaluka_yuva_adhikari);

        umerkhed_vibhag_pramukh = findViewById(R.id.umerkhed_vibhag_pramukh);
        umerkhed_vibhag_sanghatika = findViewById(R.id.umerkhed_vibhag_sanghtika);
        umerkhed_vibhag_yuva_adhikari = findViewById(R.id.umerkhed_vibhag_yuva_adhikari);

        umerkhed_shakha_pramukh = findViewById(R.id.umerkhed_shakha_pramukh);
        umerkhed_shakha_sanghatika = findViewById(R.id.umerkhed_shakha_sanghtika);
        umerkhed_shakha_yuva_adhikari = findViewById(R.id.umerkhed_shakha_yuva_adhikari);

    }
}