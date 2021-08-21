package com.shivsena.yavatmal.yavtmalvidhansabha;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.adapter.ShivsenaAdapter;
import com.shivsena.yavatmal.model.ShivsenaDetails;

import java.util.ArrayList;
import java.util.List;

public class UmerkhedDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ShivsenaDetails> list;
    private ShivsenaAdapter adapter;
    private DatabaseReference mRef;
    private ChildEventListener mChildEventListener;
    private FirebaseDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umerkhed_details);
        mDatabase = FirebaseDatabase.getInstance();
        String post = getIntent().getStringExtra("post");
        mRef = mDatabase.getReference("उमरखेड_विधानसभा").child(post);
        recyclerView = findViewById(R.id.umerkhed_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new ShivsenaAdapter(this,list);
        recyclerView.setAdapter(adapter);
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                ShivsenaDetails data = snapshot.getValue(ShivsenaDetails.class);
                data.setUid(snapshot.getKey());
                list.add(data);
                adapter.notifyDataSetChanged();
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
}