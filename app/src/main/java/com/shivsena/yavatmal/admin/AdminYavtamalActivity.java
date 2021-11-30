package com.shivsena.yavatmal.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.model.ShivsenaDetails;

import java.util.ArrayList;

public class AdminYavtamalActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;

    private Button yavatmal_vidhansabha_login;
    private EditText yavatmal_vidhansabha_name,yavatmal_vidhansabha_phone;
    private Spinner yavatmal_vidhansabha_spinner;

    private Spinner yavatmal_taluka_spinner;
    private Spinner yavatmal_gaon_spinner;
    private String post,name,phone,vidhansabha;
    private ArrayList<String> spinnerList;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_yavtamal);
        vidhansabha = getIntent().getStringExtra("vidhansabha");
        setTitle(vidhansabha);
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child(vidhansabha);
        initialise();
        this.yavatmal_vidhansabha_login.setOnClickListener(this::saveData);
        yavatmal_vidhansabha_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                post = yavatmal_vidhansabha_spinner.getSelectedItem().toString().trim();

                if(post.equals("उपजिल्हा प्रमुख") || post.equals("उपजिल्हा संघटीका") || post.equals("उपजिल्हा युवा अधिकारी")){
                    yavatmal_taluka_spinner.setVisibility(View.INVISIBLE);

                }
                if(post.equals("तालुका प्रमुख") || post.equals("तालुका संघटीका") || post.equals("तालुका युवा अधिकारी")
                        || post.equals("उपतालुका प्रमुख") || post.equals("उपतालुका संघटीका")
                        || post.equals("उपतालुका युवा अधिकारी")|| post.equals("विभाग प्रमुख")
                        || post.equals("विभाग संघटीका")|| post.equals("विभाग युवा अधिकारी")
                        || post.equals("शाखा प्रमुख")|| post.equals("शाखा संघटीका")
                        || post.equals("शाखा युवा अधिकारी")){

                    yavatmal_taluka_spinner.setVisibility(View.VISIBLE);

                    mDatabase = FirebaseDatabase.getInstance();
                    mRef = mDatabase.getReference(vidhansabha).child("तालुक्याचे नाव");
                    spinnerList = new ArrayList();
                    adapter = new ArrayAdapter<String>(AdminYavtamalActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,spinnerList);
                    yavatmal_taluka_spinner.setAdapter(adapter);
                    showData();
                }
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
                Toast.makeText(AdminYavtamalActivity.this, "Error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }


    private void saveData(View view) {
        name = yavatmal_vidhansabha_name.getText().toString().trim();
        phone = yavatmal_vidhansabha_phone.getText().toString().trim();
        //String post = yavatmal_vidhansabha_spinner.getSelectedItem().toString().trim();

        if (name.isEmpty()){
            yavatmal_vidhansabha_name.setError("क्रुपया नाव टाका");
            yavatmal_vidhansabha_name.requestFocus();
            return;
        }
        if (phone.isEmpty()){
            yavatmal_vidhansabha_phone.setError("क्रुपया दूरध्वनि क्रमांक टाका");
            yavatmal_vidhansabha_phone.requestFocus();
            return;
        }

        if(post.equals("तालुका प्रमुख") || post.equals("तालुका संघटीका") || post.equals("तालुका युवा अधिकारी")
                || post.equals("उपतालुका प्रमुख") || post.equals("उपतालुका संघटीका")
                || post.equals("उपतालुका युवा अधिकारी")|| post.equals("विभाग प्रमुख")
                || post.equals("विभाग संघटीका")|| post.equals("विभाग युवा अधिकारी")
                || post.equals("शाखा प्रमुख")|| post.equals("शाखा संघटीका")
                || post.equals("शाखा युवा अधिकारी")){

            String taluka = yavatmal_taluka_spinner.getSelectedItem().toString().trim();//darwha
            ShivsenaDetails details = new ShivsenaDetails(name,phone,post,taluka);
            String key = mRef.push().getKey();
            mRef = mDatabase.getReference().child(vidhansabha);
            mRef.child(taluka+" तालुका").child(post).child(key).setValue(details);
            Toast.makeText(AdminYavtamalActivity.this, "Registered.....", Toast.LENGTH_SHORT).show();
            yavatmal_taluka_spinner.setVisibility(View.INVISIBLE);

        }else if(post.equals("उपजिल्हा प्रमुख") || post.equals("उपजिल्हा संघटीका") || post.equals("उपजिल्हा युवा अधिकारी")){
            ShivsenaDetails details = new ShivsenaDetails(name,phone,post);
            String key = mRef.push().getKey();
            mRef.child(post).child(key).setValue(details);
            Toast.makeText(AdminYavtamalActivity.this, "Registered.....", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(AdminYavtamalActivity.this, "Not Registered...", Toast.LENGTH_SHORT).show();
        }
        
        yavatmal_vidhansabha_name.setText("");
        yavatmal_vidhansabha_phone.setText("");
        yavatmal_vidhansabha_spinner.setSelection(0);
    }

    private void initialise() {
        yavatmal_vidhansabha_login = findViewById(R.id.btn_addMember);
        yavatmal_vidhansabha_name = findViewById(R.id.yavatmal_vidhansabha_name);
        yavatmal_vidhansabha_phone = findViewById(R.id.yavatmal_vidhansabha_phone);
        yavatmal_vidhansabha_spinner = findViewById(R.id.yavatmal_vidhansabha_spinner);
        yavatmal_taluka_spinner = findViewById(R.id.yavatmal_taluka_spinner);
        yavatmal_gaon_spinner = findViewById(R.id.yavatmal_gaon_spinner);

    }
}