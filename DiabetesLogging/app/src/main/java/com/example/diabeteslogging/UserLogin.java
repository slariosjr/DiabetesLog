package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public class UserLogin extends AppCompatActivity {
    Button UserLogBtn;
    Button UserAppointmentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        MaterialButton UserLogoutBtn = (MaterialButton) findViewById(R.id.UserLogoutBtn);
        UserLogBtn = findViewById(R.id.UserLogBtn);
        UserAppointmentBtn = findViewById(R.id.UserAppointmentBtn);
        UserAppointmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Appointments.class);
                startActivity(intent);
            }
        });



        UserLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Log.class);
                startActivity(intent);
            }
        });

        UserLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}