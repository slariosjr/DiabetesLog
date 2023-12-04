package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Index;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.diabeteslogging.DB.Database;
import com.example.diabeteslogging.DB.NewsDao;

import java.util.ArrayList;
import java.util.List;

public class DiabetesNewsDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<News> arrayList = new ArrayList<>();
    private NewsDao newsDao;
    ListView listView;
    Button NewsBackBtn;

    String news[] ={"Hello", "Bye"};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_news_details);
        getDatabase();
        NewsBackBtn = findViewById(R.id.NewsBackBtn);
        recyclerView = findViewById(R.id.NewsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<News> NewsTitle = newsDao.getTopicTitleList();
        List<News> NewsList = new ArrayList<News>();
        for(News news: NewsTitle){
            NewsList.add(news);
        }
        RecyclerNews recyclerNews = new RecyclerNews(this, NewsList);
        recyclerView.setAdapter(recyclerNews);


        NewsBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiabetesNewsDetails.this, UserLogin.class);
                startActivity(intent);
            }
        });





    }



    private void getDatabase() {
        newsDao = Room.databaseBuilder(this, Database.class, Database.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .NewsDao();
    }
}