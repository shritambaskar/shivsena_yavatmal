package com.shivsena.yavatmal.yavtmalvidhansabha;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.adapter.ShivsenaAdapter;
import com.shivsena.yavatmal.model.ShivsenaDetails;

import java.util.ArrayList;
import java.util.List;

public class UmerkhedTalukaDetailsActivity extends AppCompatActivity {

    private Spinner talukaSpinner;
    private RecyclerView talukaRecycler;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private ArrayList<String> spinnerList;
    private ArrayAdapter<String> adapter;
    private String vidhansabha,post,taluka;

    private List<ShivsenaDetails> list;
    private ShivsenaAdapter shiv_adapter;
    private ChildEventListener mChildEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umerkhed_taluka_details);
        vidhansabha = getIntent().getStringExtra("vidhansabha");
        post = getIntent().getStringExtra("post");
        setTitle(post);

        initialise();

        talukaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                taluka = talukaSpinner.getSelectedItem().toString().trim();

                mDatabase = FirebaseDatabase.getInstance();
                mRef = mDatabase.getReference(vidhansabha).child(taluka+" ??????????????????").child(post);
                talukaRecycler.setHasFixedSize(true);
                talukaRecycler.setLayoutManager(new LinearLayoutManager(UmerkhedTalukaDetailsActivity.this));
                list = new ArrayList<>();
                shiv_adapter = new ShivsenaAdapter(UmerkhedTalukaDetailsActivity.this,list);
                talukaRecycler.setAdapter(shiv_adapter);

                mChildEventListener = new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        ShivsenaDetails data = snapshot.getValue(ShivsenaDetails.class);
                        data.setUid(snapshot.getKey());
                        list.add(data);
                        shiv_adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                };
                mRef.addChildEventListener(mChildEventListener);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void showData() {
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot item: snapshot.getChildren()){
                    String data = item.getValue().toString();
                    spinnerList.add(data);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UmerkhedTalukaDetailsActivity.this, "Error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void initialise() {
        talukaSpinner = findViewById(R.id.umerkhed_taluka_spinner);
        talukaRecycler = findViewById(R.id.umerkhed_taluka_recycleView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference(vidhansabha).child("?????????????????????????????? ?????????");
        spinnerList = new ArrayList();
        adapter = new ArrayAdapter<String>(UmerkhedTalukaDetailsActivity.this,
                android.R.layout.simple_spinner_dropdown_item,spinnerList);
        talukaSpinner.setAdapter(adapter);
        showData();
    }
}