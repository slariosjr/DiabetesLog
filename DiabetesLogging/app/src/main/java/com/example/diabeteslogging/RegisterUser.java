package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diabeteslogging.DB.Database;
import com.example.diabeteslogging.DB.User;
import com.example.diabeteslogging.DB.UserDao;

public class RegisterUser extends AppCompatActivity {
    private UserDao userDao;
    EditText usernameSignUp;
    EditText passwordSignUp;
    Button SignUpBtn;
    Button SignUpBackBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        getDatabase();
        SignUpBackBtn = findViewById(R.id.SignUpBackBtn);

        usernameSignUp = findViewById(R.id.UserNameSignUp);
        passwordSignUp = findViewById(R.id.PasswordSignUp);

        SignUpBtn = findViewById(R.id.SignUpBtn);
        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User newUser = userDao.getUsernameByID(usernameSignUp.getText().toString());
                if( newUser != null){
                    Toast.makeText(RegisterUser.this,"Username Already in User", Toast.LENGTH_SHORT).show();
                } else{
                    newUser = new User(usernameSignUp.getText().toString(),passwordSignUp.getText().toString(), false);
                    userDao.insert(newUser);
                    Intent intent = new Intent(RegisterUser.this, MainActivity.class);
                    startActivity(intent);

                }
            }
        });
    SignUpBackBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });




    }
    private void getDatabase(){
        userDao = Room.databaseBuilder(this, Database.class,Database.DATABASE_NAME).allowMainThreadQueries()
                .fallbackToDestructiveMigration().build().UserDao();
    }
}