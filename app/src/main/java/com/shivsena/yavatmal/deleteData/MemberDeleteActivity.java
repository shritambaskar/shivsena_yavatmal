package com.shivsena.yavatmal.deleteData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.admin.AddGaonActivity;

import java.util.ArrayList;

public class MemberDeleteActivity extends AppCompatActivity {

    private Spinner deleteSpinnerVidhansabha, deleteSpinnerPost,deleteSpinnerTaluka;
    private Button deleteGo;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private ArrayList<String> spinnerList;
    private ArrayAdapter<String> adapter;
    private String myVidhanSabha,myTaluka,post,vidhansabha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_delete);
        initialise();
        this.deleteGo.setOnClickListener(this::deleteData);

    }

    private void deleteData(View view) {

    }


    private void initialise() {
        deleteSpinnerVidhansabha = findViewById(R.id.delete_spinner_vidhansabha);
        deleteSpinnerPost = findViewById(R.id.delete_spinner_post);
        deleteSpinnerTaluka = findViewById(R.id.delete_spinner_taluka);
        deleteGo = findViewById(R.id.btn_delete_go);
    }
}