package com.shivsena.yavatmal.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.deleteData.MemberDeleteActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    private Button addTaluka,addGav,addMember,deleteMember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        initialise();
        this.addTaluka.setOnClickListener(this::addTaluka);
        this.addGav.setOnClickListener(this::addGav);
        this.addMember.setOnClickListener(this::addMember);
        this.deleteMember.setOnClickListener(this::deleteMember);
    }

    private void deleteMember(View view) {
        startActivity(new Intent(AdminDashboardActivity.this, MemberDeleteActivity.class));
    }

    private void addMember(View view) {
        startActivity(new Intent(AdminDashboardActivity.this,AdminHomeActivity.class));
    }

    private void addGav(View view) {
        startActivity(new Intent(AdminDashboardActivity.this,AddGaonActivity.class));
    }

    private void addTaluka(View view) {
        startActivity(new Intent(AdminDashboardActivity.this,AddTalukaActivity.class));
    }

    private void initialise() {
        addTaluka = findViewById(R.id.btn_dash_taluka);
        addGav = findViewById(R.id.btn_dash_gav);
        addMember = findViewById(R.id.btn_dash_add_member);
        deleteMember = findViewById(R.id.btn_dash_delete_member);
    }
}