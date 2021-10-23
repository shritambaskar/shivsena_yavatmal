package com.shivsena.yavatmal.deleteData;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.shivsena.yavatmal.R;

public class ShowDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        TextView dummy = findViewById(R.id.dummy);

        String vidhansabha = getIntent().getStringExtra("vidhansabha");
        String post = getIntent().getStringExtra("post");
        String taluka = getIntent().getStringExtra("taluka");
        if(taluka == null){

            dummy.setText(vidhansabha+","+post);
        }else {

            dummy.setText(vidhansabha + "," + post + "," + taluka);
        }
    }
}