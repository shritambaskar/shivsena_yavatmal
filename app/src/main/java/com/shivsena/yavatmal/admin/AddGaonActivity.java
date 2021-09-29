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
import com.shivsena.yavatmal.model.GaonDetails;

public class AddGaonActivity extends AppCompatActivity {

    private Spinner gaonVidhanSpinner,gaonTalukaSpinner;
    private EditText et_Gaon;
    private Button addGaon;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gaon);

        initialise();
        this.addGaon.setOnClickListener(this::addGaon);
    }

    private void addGaon(View view) {
        String sp1 = gaonTalukaSpinner.getSelectedItem().toString();
        String sp2 = gaonVidhanSpinner.getSelectedItem().toString();
        String gaon = et_Gaon.getText().toString();

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference(sp2).child(sp1);

        if (gaon.isEmpty()){
            et_Gaon.setError("क्रुपया गावाचे नाव टाका");
            et_Gaon.requestFocus();
            return;
        }
        GaonDetails details = new GaonDetails(gaon);
        String key = mRef.push().getKey();
        mRef.child(key).setValue(details);
        Toast.makeText(AddGaonActivity.this, "Registered", Toast.LENGTH_SHORT).show();

        gaonTalukaSpinner.setSelection(0);
        gaonVidhanSpinner.setSelection(0);
        et_Gaon.setText("");
    }

    private void initialise() {
        gaonVidhanSpinner = findViewById(R.id.gaon_vidhan_spinner);
        gaonTalukaSpinner = findViewById(R.id.gaon_taluka_spinner);
        et_Gaon = findViewById(R.id.et_add_gaon);
        addGaon = findViewById(R.id.btn_add_gaon);
    }
}