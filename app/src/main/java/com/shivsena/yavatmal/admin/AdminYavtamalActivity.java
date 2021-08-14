package com.shivsena.yavatmal.admin;

import androidx.appcompat.app.AppCompatActivity;

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

    private Button yavatmal_vidhansabha_login;
    private EditText yavatmal_vidhansabha_name,yavatmal_vidhansabha_phone;
    private Spinner yavatmal_vidhansabha_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_yavtamal);
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("यवतमाळ_विधानसभा");
        initialise();
        this.yavatmal_vidhansabha_login.setOnClickListener(this::saveData);
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
    }

    private void initialise() {
        yavatmal_vidhansabha_login = findViewById(R.id.yavatmal_vidhansabha_login);
        yavatmal_vidhansabha_name = findViewById(R.id.yavatmal_vidhansabha_name);
        yavatmal_vidhansabha_phone = findViewById(R.id.yavatmal_vidhansabha_phone);
        yavatmal_vidhansabha_spinner = findViewById(R.id.yavatmal_vidhansabha_spinner);
    }
}