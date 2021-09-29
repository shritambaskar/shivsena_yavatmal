package com.shivsena.yavatmal.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.model.ShivsenaDetails;

public class AdminYavtamalActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;

    private Button yavatmal_vidhansabha_login,addPlace;
    private EditText yavatmal_vidhansabha_name,yavatmal_vidhansabha_phone;
    private Spinner yavatmal_vidhansabha_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_yavtamal);
        String vidhansabha = getIntent().getStringExtra("vidhansabha");
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child(vidhansabha);
        initialise();
        this.yavatmal_vidhansabha_login.setOnClickListener(this::saveData);
        this.addPlace.setOnClickListener(this::addPlace);
    }

    private void addPlace(View view) {
        startActivity(new Intent(AdminYavtamalActivity.this,AdminPlaceActivity.class));
    }

    private void saveData(View view) {
        String name = yavatmal_vidhansabha_name.getText().toString();
        String phone = yavatmal_vidhansabha_phone.getText().toString();
        String post = yavatmal_vidhansabha_spinner.getSelectedItem().toString();

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

        ShivsenaDetails details = new ShivsenaDetails(name,phone,post);
        String key = mRef.push().getKey();
        mRef.child(post).child(key).setValue(details);
        Toast.makeText(AdminYavtamalActivity.this, "Registered.....", Toast.LENGTH_SHORT).show();

        yavatmal_vidhansabha_name.setText("");
        yavatmal_vidhansabha_phone.setText("");
        yavatmal_vidhansabha_spinner.setSelection(0);
    }

    private void initialise() {
        yavatmal_vidhansabha_login = findViewById(R.id.btn_addPlace);
        yavatmal_vidhansabha_name = findViewById(R.id.et_addPlace);
        yavatmal_vidhansabha_phone = findViewById(R.id.yavatmal_vidhansabha_phone);
        yavatmal_vidhansabha_spinner = findViewById(R.id.yavatmal_vidhansabha_spinner);
        addPlace = findViewById(R.id.btn_addPlace);
    }
}