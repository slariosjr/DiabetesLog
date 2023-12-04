package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diabeteslogging.DB.Database;
import com.example.diabeteslogging.DB.LogDao;

public class AddingLogDetails extends AppCompatActivity {
    Button AddLogBackBtn;
    EditText Date;
    EditText BloodSugar;
    EditText Insulin;
    EditText Carbs;
    Button AddLogBtn;
    private LogDao logDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_log_details);
        getDatabase();

        Date = findViewById(R.id.EditLogDate);
        BloodSugar = findViewById(R.id.EditLogBloodSugar);
        Insulin = findViewById(R.id.EditLogInsulin);
        Carbs = findViewById(R.id.EditLogCarbs);






        AddLogBackBtn = findViewById(R.id.AddLogBackBtn);
        AddLogBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        AddLogBtn = findViewById(R.id.EditLogAddLogBtn);
        AddLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogD logD = new LogD(Date.getText().toString(), BloodSugar.getText().toString(), Insulin.getText().toString(), Carbs.getText().toString());
                logDao.insert(logD);
                Toast.makeText(AddingLogDetails.this,"Log Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getDatabase() {
        logDao = Room.databaseBuilder(this, Database.class, Database.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .LogDao();
    }


}