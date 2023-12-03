package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class AdminLogin extends AppCompatActivity {
Button AddCarbs;
Button RemoveUser;
Button AdminMainLogBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        MaterialButton AdminlogoutBtn = (MaterialButton) findViewById(R.id.AdminlogoutBtn);
        MaterialButton AddNews = (MaterialButton) findViewById(R.id.AddNews);
        MaterialButton AdminMainBackBtn1 = (MaterialButton) findViewById(R.id.AdminMainBackBtn1);
        AddCarbs = findViewById(R.id.AddCarbs);
        RemoveUser = findViewById(R.id.AdminRemoveUser);



        AdminMainBackBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        AdminlogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(AdminLogin.this, "Logged Out",Toast.LENGTH_SHORT).show();
            }
        });
        AddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminAddNews.class);
                startActivity(intent);

            }
        });
        AddCarbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddCarbs.class);
                startActivity(intent);
            }
        });
        RemoveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RemoveUser.class);
                startActivity(intent);
            }
        });
    }
}