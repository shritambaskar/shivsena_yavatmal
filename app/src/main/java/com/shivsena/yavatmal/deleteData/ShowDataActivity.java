package com.shivsena.yavatmal.deleteData;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.adapter.ShivsenaAdapter;
import com.shivsena.yavatmal.model.ShivsenaDetails;
import com.shivsena.yavatmal.model.TalukaDetails;

import java.util.ArrayList;
import java.util.List;

public class ShowDataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ShivsenaDetails> list;
    private DeleteAdapter adapter;
    private DatabaseReference mRef;
    private ChildEventListener mChildEventListener;
    private FirebaseDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        mDatabase = FirebaseDatabase.getInstance();
        String vidhansabha = getIntent().getStringExtra("vidhansabha");
        String post = getIntent().getStringExtra("post");
        String taluka = getIntent().getStringExtra("taluka");

        recyclerView = findViewById(R.id.delete_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new DeleteAdapter(this,list,vidhansabha,post,taluka);
        recyclerView.setAdapter(adapter);

        if(taluka == null){
            mRef = mDatabase.getReference(vidhansabha).child(post);

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

                    ShivsenaDetails data = snapshot.getValue(ShivsenaDetails.class);
                    data.setUid(snapshot.getKey());
                    list.remove(data);
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            };
            //mRef.addChildEventListener(mChildEventListener);

        }

        else if(taluka!=null) {
            mRef = mDatabase.getReference(vidhansabha).child(taluka+" तालुका").child(post);

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

                    ShivsenaDetails data = snapshot.getValue(ShivsenaDetails.class);
                    data.setUid(snapshot.getKey());
                    list.remove(data);
                    adapter.notifyDataSetChanged();
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
        //mRef.addChildEventListener(mChildEventListener);
    }

}