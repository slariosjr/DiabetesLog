package com.example.diabeteslogging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diabeteslogging.DB.Database;
import com.example.diabeteslogging.DB.User;
import com.example.diabeteslogging.DB.UserDao;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDatabase();

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User userPassword = userDao.getPasswordByID(password.getText().toString());
                User userUsername = userDao.getUsernameByID(username.getText().toString());
                if (username.getText().toString().equals("admin1") && password.getText().toString().equals("admin1")) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, UserLogin.class);
                    UserLogin.username = username.getText().toString();
                    UserLogin.isAdmin = true;
                    startActivity(intent);
                   // finish();
                } else if (userUsername != null && userPassword != null) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, UserLogin.class);
                    UserLogin.username = username.getText().toString();
                    UserLogin.isAdmin = false;
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        TextView rTextView = findViewById(R.id.register);
        String text1 = "Don't have an account? Sign Up";
        SpannableString sss = new SpannableString(text1);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(MainActivity.this, "",Toast.LENGTH_SHORT).show();
            }
        };
        sss.setSpan(clickableSpan1,23,30,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        rTextView.setText(sss);
        rTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterUser.class);
                startActivity(intent);
            }
        });
        rTextView.setMovementMethod(LinkMovementMethod.getInstance());


    }
    private void getDatabase(){
        userDao = Room.databaseBuilder(this, Database.class,Database.DATABASE_NAME).allowMainThreadQueries()
                .fallbackToDestructiveMigration().build().UserDao();
    }
}