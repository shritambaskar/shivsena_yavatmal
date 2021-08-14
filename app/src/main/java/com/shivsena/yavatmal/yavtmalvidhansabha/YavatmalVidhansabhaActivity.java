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

    private Button upjilha_pramukh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yavatmal_vidhansabha);



        initialise();
        this.upjilha_pramukh.setOnClickListener(this::upjilhaPramukh);
    }

    private void upjilhaPramukh(View view) {
        String post = "उपजिल्हा प्रमुख";
        Intent intent = new Intent(YavatmalVidhansabhaActivity.this,YavatmalDetailsActivity.class);
        intent.putExtra("उपजिल्हा प्रमुख",post);
        startActivity(intent);
    }

    private void initialise() {
        upjilha_pramukh = findViewById(R.id.upjilha_pramukh);
    }
}