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
import com.shivsena.yavatmal.admin.AdminYavtamalActivity;

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
        deleteSpinnerVidhansabha.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vidhansabha = deleteSpinnerVidhansabha.getSelectedItem().toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        deleteSpinnerPost.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                post = deleteSpinnerPost.getSelectedItem().toString().trim();
                if(post.equals("उपजिल्हा प्रमुख") || post.equals("उपजिल्हा संघटीका") || post.equals("उपजिल्हा युवा अधिकारी")){
                    deleteSpinnerTaluka.setVisibility(View.INVISIBLE);
                }
                if(post.equals("तालुका प्रमुख") || post.equals("तालुका संघटीका") || post.equals("तालुका युवा अधिकारी")
                        || post.equals("उपतालुका प्रमुख") || post.equals("उपतालुका संघटीका")
                        || post.equals("उपतालुका युवा अधिकारी")|| post.equals("विभाग प्रमुख")
                        || post.equals("विभाग संघटीका")|| post.equals("विभाग युवा अधिकारी")
                        || post.equals("शाखा प्रमुख")|| post.equals("शाखा संघटीका")
                        || post.equals("शाखा युवा अधिकारी")){

                    deleteSpinnerTaluka.setVisibility(View.VISIBLE);

                    mDatabase = FirebaseDatabase.getInstance();
                    mRef = mDatabase.getReference(vidhansabha).child("तालुक्याचे नाव");
                    spinnerList = new ArrayList();
                    adapter = new ArrayAdapter<String>(MemberDeleteActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,spinnerList);
                    deleteSpinnerTaluka.setAdapter(adapter);
                    showData();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        deleteSpinnerTaluka.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myTaluka = deleteSpinnerTaluka.getSelectedItem().toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

         this.deleteGo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if(vidhansabha!= null && post!=null) {
                     Intent intent = new Intent(MemberDeleteActivity.this, ShowDataActivity.class);
                     intent.putExtra("vidhansabha", vidhansabha);
                     intent.putExtra("post", post);
                     startActivity(intent);
                 }
                 if(vidhansabha!= null && post!=null&&myTaluka!=null) {
                     Intent intent = new Intent(MemberDeleteActivity.this, ShowDataActivity.class);
                     intent.putExtra("vidhansabha", vidhansabha);
                     intent.putExtra("post", post);
                     intent.putExtra("taluka",myTaluka);
                     startActivity(intent);
                 }
             }
         });
        }


    private void showData() {
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot item : snapshot.getChildren()) {
                    String data = item.getValue().toString();
                    spinnerList.add(data);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MemberDeleteActivity.this, "Error " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }
    private void initialise() {
        deleteSpinnerVidhansabha = findViewById(R.id.delete_spinner_vidhansabha);
        deleteSpinnerPost = findViewById(R.id.delete_spinner_post);
        deleteSpinnerTaluka = findViewById(R.id.delete_spinner_taluka);
        deleteGo = findViewById(R.id.btn_delete_go);
    }
}