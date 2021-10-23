package com.shivsena.yavatmal.yavtmalvidhansabha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shivsena.yavatmal.R;

public class DigrasVidhansabhaActivity extends AppCompatActivity {

    private Button digras_upjilha_pramukh,digras_upjilha_sanghatika,digras_upjilha_yuva_adhikari;
    private Button digras_taluka_pramukh,digras_taluka_sanghatika,digras_taluka_yuva_adhikari;
    private Button digras_up_taluka_pramukh,digras_up_taluka_sanghatika,digras_up_taluka_yuva_adhikari;
    private Button digras_vibhag_pramukh,digras_vibhag_sanghatika,digras_vibhag_yuva_adhikari;
    private Button digras_shakha_pramukh,digras_shakha_sanghatika,digras_shakha_yuva_adhikari;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digras_vidhansabha);
        initialise();
        this.digras_upjilha_pramukh.setOnClickListener(this::upjilhaPramukh);
        this.digras_upjilha_sanghatika.setOnClickListener(this::upjilhaSanghatika);
        this.digras_upjilha_yuva_adhikari.setOnClickListener(this::upjilhaYuvaAdhikari);

        this.digras_taluka_pramukh.setOnClickListener(this::talukaPramukh);
        this.digras_taluka_sanghatika.setOnClickListener(this::talukaSanghatika);
        this.digras_taluka_yuva_adhikari.setOnClickListener(this::talukaYuvaAdhikari);

        this.digras_up_taluka_pramukh.setOnClickListener(this::upTalukaPramukh);
        this.digras_up_taluka_sanghatika.setOnClickListener(this::upTalukaSanghatika);
        this.digras_up_taluka_yuva_adhikari.setOnClickListener(this::upTalukaYuvaAdhikari);

        this.digras_vibhag_pramukh.setOnClickListener(this::vibhagPramukh);
        this.digras_vibhag_sanghatika.setOnClickListener(this::vibhagSanghatika);
        this.digras_vibhag_yuva_adhikari.setOnClickListener(this::vibhagYuvaAdhikari);

        this.digras_shakha_pramukh.setOnClickListener(this::shakhaPramukh);
        this.digras_shakha_sanghatika.setOnClickListener(this::shakhaSanghatika);
        this.digras_shakha_yuva_adhikari.setOnClickListener(this::shakhaYuvaAdhikari);
    }
    private void upjilhaPramukh(View view) {
        String post = "उपजिल्हा प्रमुख";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upjilhaSanghatika(View view) {
        String post = "उपजिल्हा संघटीका";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upjilhaYuvaAdhikari(View view) {
        String post = "उपजिल्हा युवा अधिकारी";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void talukaPramukh(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "तालुका प्रमुख";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void talukaSanghatika(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "तालुका संघटीका";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void talukaYuvaAdhikari(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "तालुका युवा अधिकारी";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upTalukaPramukh(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "उपतालुका प्रमुख";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }


    private void upTalukaSanghatika(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "उपतालुका संघटीका";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upTalukaYuvaAdhikari(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "उपतालुका युवा अधिकारी";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void vibhagPramukh(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "विभाग प्रमुख";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void vibhagSanghatika(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "विभाग संघटीका";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void vibhagYuvaAdhikari(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "विभाग युवा अधिकारी";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void shakhaPramukh(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "शाखा प्रमुख";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void shakhaSanghatika(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "शाखा संघटीका";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void shakhaYuvaAdhikari(View view) {
        String vidhansabha = "उमरखेड विधानसभा";
        String post = "शाखा युवा अधिकारी";
        Intent intent = new Intent(DigrasVidhansabhaActivity.this,DigrasTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void initialise() {
        digras_upjilha_pramukh = findViewById(R.id.digras_upjilha_pramukh);
        digras_upjilha_sanghatika = findViewById(R.id.digras_upjilha_sanghtika);
        digras_upjilha_yuva_adhikari = findViewById(R.id.digras_upjilha_yuva_adhikari);

        digras_taluka_pramukh = findViewById(R.id.digras_taluka_pramukh);
        digras_taluka_sanghatika = findViewById(R.id.digras_taluka_sanghtika);
        digras_taluka_yuva_adhikari = findViewById(R.id.digras_taluka_yuva_adhikari);

        digras_up_taluka_pramukh = findViewById(R.id.digras_up_taluka_pramukh);
        digras_up_taluka_sanghatika = findViewById(R.id.digras_up_taluka_sanghtika);
        digras_up_taluka_yuva_adhikari = findViewById(R.id.digras_up_taluka_yuva_adhikari);

        digras_vibhag_pramukh = findViewById(R.id.digras_vibhag_pramukh);
        digras_vibhag_sanghatika = findViewById(R.id.digras_vibhag_sanghtika);
        digras_vibhag_yuva_adhikari = findViewById(R.id.digras_vibhag_yuva_adhikari);

        digras_shakha_pramukh = findViewById(R.id.digras_shakha_pramukh);
        digras_shakha_sanghatika = findViewById(R.id.digras_shakha_sanghtika);
        digras_shakha_yuva_adhikari = findViewById(R.id.digras_shakha_yuva_adhikari);
    }
}