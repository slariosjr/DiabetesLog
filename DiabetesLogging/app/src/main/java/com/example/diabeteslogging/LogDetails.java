package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.diabeteslogging.DB.Database;
import com.example.diabeteslogging.DB.LogDao;
import com.example.diabeteslogging.R;

import java.util.ArrayList;
import java.util.List;

public class LogDetails extends AppCompatActivity {
    Button LogAddNewLogBtn;
    Button LogBackBtn;
    RecyclerView recyclerView;
    ArrayList<LogD> arrayList = new ArrayList<>();
    String logs[] = {"Hello", "Bye"};
    private LogDao logDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_details);
        getDatabase();
        recyclerView = findViewById(R.id.LogView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<LogD> DateTitle = logDao.getLogDataTopic();
        List<LogD> DateList = new ArrayList<LogD>();
        for(LogD logD: DateTitle){
            DateList.add(logD);
        }
        RecyclerLog recyclerLog = new RecyclerLog(this, DateList);
        recyclerView.setAdapter(recyclerLog);


        LogBackBtn = findViewById(R.id.LogBackBtn);
        LogAddNewLogBtn = findViewById(R.id.LogAddNewLogBtn);
        LogAddNewLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogDetails.this, AddingLogDetails.class);
                startActivity(intent);
            }
        });
        LogBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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