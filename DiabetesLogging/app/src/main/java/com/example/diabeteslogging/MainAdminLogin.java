package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainAdminLogin extends AppCompatActivity {
    Button AdminMainAdminOptionsBtn;

    Button AdminMainAppointmentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin_login);

        MaterialButton AdminMainLogoutBtn = (MaterialButton) findViewById(R.id.AdminMainLogoutBtn);
        AdminMainAdminOptionsBtn = findViewById(R.id.AdminMainAdminOptionsBtn);
        AdminMainAppointmentBtn = findViewById(R.id.AdminMainAppointmentBtn);

       AdminMainAppointmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Appointments.class);
                startActivity(intent);
            }
        });

        AdminMainLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(MainAdminLogin.this, "Logged Out",Toast.LENGTH_SHORT).show();
            }
        });
        AdminMainAdminOptionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(intent);
            }
        });

    }
}