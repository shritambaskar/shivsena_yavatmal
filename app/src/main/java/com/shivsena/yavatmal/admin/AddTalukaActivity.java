package com.shivsena.yavatmal.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.model.TalukaDetails;

public class AddTalukaActivity extends AppCompatActivity {

    private Spinner sp_chooseVidhansabha;
    private EditText et_taluka;
    private Button add;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_taluka);
        setTitle("तालुका जोडा");
        initialise();
        this.add.setOnClickListener(this::addTaluka);
    }

    private void addTaluka(View view) {
        String sp = sp_chooseVidhansabha.getSelectedItem().toString();
        String taluka = et_taluka.getText().toString().trim();

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference(sp).child("तालुक्याचे नाव");
        
        if (taluka.isEmpty()){
            et_taluka.setError("क्रुपया तालुक्याचे नाव टाका");
            et_taluka.requestFocus();
            return;
        }
        //TalukaDetails details = new TalukaDetails(taluka);
        //String key = mRef.push().getKey();
        mRef.child(taluka).setValue(taluka);
        Toast.makeText(AddTalukaActivity.this, "Registered", Toast.LENGTH_SHORT).show();

        sp_chooseVidhansabha.setSelection(0);
        et_taluka.setText("");
    }

    private void initialise() {
        sp_chooseVidhansabha = findViewById(R.id.taluka_spinner);
        et_taluka = findViewById(R.id.et_add_gaon);
        add = findViewById(R.id.btn_add_gaon);
    }
}