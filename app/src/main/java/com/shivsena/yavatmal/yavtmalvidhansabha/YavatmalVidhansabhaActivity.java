package com.shivsena.yavatmal.yavtmalvidhansabha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.adapter.ShivsenaAdapter;
import com.shivsena.yavatmal.model.ShivsenaDetails;

import java.util.List;

public class YavatmalVidhansabhaActivity extends AppCompatActivity {

    private Button upjilha_pramukh,upjilha_sanghatika,upjilha_yuva_adhikari;
    private Button taluka_pramukh,taluka_sanghatika,taluka_yuva_adhikar;
    private Button up_taluka_pramukh,up_taluka_sanghatika,up_taluka_yuva_adhikari;
    private Button vibhag_pramukh,vibhag_sanghatika,vibhag_yuva_adhikari;
    private Button shakha_pramukh,shakha_sanghatika,shakha_yuva_adhikari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yavatmal_vidhansabha);

        initialise();
        this.upjilha_pramukh.setOnClickListener(this::upjilhaPramukh);
        this.upjilha_sanghatika.setOnClickListener(this::upjilhaSanghatika);
        this.upjilha_yuva_adhikari.setOnClickListener(this::upjilhaYuvaAdhikari);

        this.taluka_pramukh.setOnClickListener(this::talukaPramukh);
        this.taluka_sanghatika.setOnClickListener(this::talukaSanghatika);
        this.taluka_yuva_adhikar.setOnClickListener(this::talukaYuvaAdhikari);

        this.up_taluka_pramukh.setOnClickListener(this::upTalukaPramukh);
        this.up_taluka_sanghatika.setOnClickListener(this::upTalukaSanghatika);
        this.up_taluka_yuva_adhikari.setOnClickListener(this::upTalukaYuvaAdhikari);

        this.vibhag_pramukh.setOnClickListener(this::vibhagPramukh);
        this.vibhag_sanghatika.setOnClickListener(this::vibhagSanghatika);
        this.vibhag_yuva_adhikari.setOnClickListener(this::vibhagYuvaAdhikari);
        
        this.shakha_pramukh.setOnClickListener(this::shakhaPramukh);
        this.shakha_sanghatika.setOnClickListener(this::shakhaSanghatika);
        this.shakha_yuva_adhikari.setOnClickListener(this::shakhaYuvaAdhikari);



    }

    private void upjilhaPramukh(View view) {
        String post = "उपजिल्हा प्रमुख";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upjilhaSanghatika(View view) {
        String post = "उपजिल्हा संघटीका";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upjilhaYuvaAdhikari(View view) {
        String post = "उपजिल्हा युवा अधिकारी";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalDetailsActivity.class);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void talukaPramukh(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "तालुका प्रमुख";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void talukaSanghatika(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "तालुका संघटीका";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void talukaYuvaAdhikari(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "तालुका युवा अधिकारी";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upTalukaPramukh(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "उपतालुका प्रमुख";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }


    private void upTalukaSanghatika(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "उपतालुका संघटीका";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void upTalukaYuvaAdhikari(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "उपतालुका युवा अधिकारी";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void vibhagPramukh(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "विभाग प्रमुख";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void vibhagSanghatika(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "विभाग संघटीका";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void vibhagYuvaAdhikari(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "विभाग युवा अधिकारी";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void shakhaPramukh(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "शाखा प्रमुख";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void shakhaSanghatika(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "शाखा संघटीका";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }

    private void shakhaYuvaAdhikari(View view) {
        String vidhansabha = "यवतमाळ विधानसभा";
        String post = "शाखा युवा अधिकारी";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalTalukaDetailsActivity.class);
        intent.putExtra("vidhansabha",vidhansabha);
        intent.putExtra("post",post);
        startActivity(intent);
    }



    private void initialise() {
        upjilha_pramukh = findViewById(R.id.upjilha_pramukh);
        upjilha_sanghatika=findViewById(R.id.upjilha_sanghtika);
        upjilha_yuva_adhikari=findViewById(R.id.upjilha_yuva_adhikari);

        taluka_pramukh = findViewById(R.id.taluka_pramukh);
        taluka_sanghatika =findViewById(R.id.taluka_sanghtika);
        taluka_yuva_adhikar = findViewById(R.id.taluka_yuva_adhikari);

        up_taluka_pramukh = findViewById(R.id.uptaluka_pramukh);
        up_taluka_sanghatika =findViewById(R.id.uptaluka_sanghtika);
        up_taluka_yuva_adhikari = findViewById(R.id.uptaluka_yuva_adhikari);

        vibhag_pramukh = findViewById(R.id.vibhag_pramukh);
        vibhag_sanghatika =findViewById(R.id.vibhag_sanghtika);
        vibhag_yuva_adhikari = findViewById(R.id.vibhag_yuva_adhikari);

        shakha_pramukh = findViewById(R.id.shakha_pramukh);
        shakha_sanghatika =findViewById(R.id.shakha_sanghtika);
        shakha_yuva_adhikari = findViewById(R.id.shakha_yuva_adhikari);


    }
}