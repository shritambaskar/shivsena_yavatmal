package com.shivsena.yavatmal.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.model.GaonDetails;

import java.util.ArrayList;

public class AddGaonActivity extends AppCompatActivity {

    private Spinner gaonVidhanSpinner,gaonTalukaSpinner;
    private EditText et_Gaon;
    private Button addGaon;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private ArrayList<String> spinnerList;
    private ArrayAdapter<String> adapter;
    private String myVidhanSabha,myTaluka,gaon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gaon);
        setTitle("गाव जोडा");
        initialise();

        this.addGaon.setOnClickListener(this::addGaon);
        this.gaonVidhanSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                myVidhanSabha = gaonVidhanSpinner.getSelectedItem().toString();
                mDatabase = FirebaseDatabase.getInstance();
                mRef = mDatabase.getReference(myVidhanSabha).child("तालुक्याचे नाव");
                spinnerList = new ArrayList();
                adapter = new ArrayAdapter<String>(AddGaonActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,spinnerList);
                gaonTalukaSpinner.setAdapter(adapter);
                showData();
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
                Toast.makeText(AddGaonActivity.this, "Error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void addGaon(View view) {
        myTaluka = gaonTalukaSpinner.getSelectedItem().toString().trim();
        gaon = et_Gaon.getText().toString().trim();

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference(myVidhanSabha).child("गावाचे नाव");

        if (gaon.isEmpty()){
            et_Gaon.setError("क्रुपया गावाचे नाव टाका");
            et_Gaon.requestFocus();
            return;
        }
        //GaonDetails details = new GaonDetails(gaon);
        String key = mRef.push().getKey();
        mRef.child(myTaluka).child(key).setValue(gaon);
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