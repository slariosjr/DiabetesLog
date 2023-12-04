package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.diabeteslogging.DB.Database;
import com.example.diabeteslogging.DB.UserDao;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public class UserLogin extends AppCompatActivity {
    Button UserLogBtn;
    Button UserAppointmentBtn;
    Button AdminOptionsBtn;
    Button UserNewsBtn;
    public static String username;
    public static boolean isAdmin;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        getDatabase();
        TextView userName = (TextView) findViewById(R.id.UserPage);
        userName.setText("Welcome " + username);
        MaterialButton UserLogoutBtn = (MaterialButton) findViewById(R.id.UserLogoutBtn);
        UserLogBtn = findViewById(R.id.UserLogBtn);
        UserAppointmentBtn = findViewById(R.id.UserAppointmentBtn);

        AdminOptionsBtn = findViewById(R.id.AdminOptionsBtnLandingPage);
        if(isAdmin){
            AdminOptionsBtn.setVisibility(View.VISIBLE);
            AdminOptionsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(UserLogin.this, AdminLogin.class);
                    startActivity(intent);
                }
            });
        } else {
            AdminOptionsBtn.setVisibility(View.INVISIBLE);
        }

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
                Intent intent = new Intent(getApplicationContext(), LogDetails.class);
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
        UserNewsBtn = findViewById(R.id.UserNewsBtn);
        UserNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogin.this, DiabetesNewsDetails.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void getDatabase(){
        userDao = Room.databaseBuilder(this, Database.class,Database.DATABASE_NAME).allowMainThreadQueries()
                .fallbackToDestructiveMigration().build().UserDao();
    }


}