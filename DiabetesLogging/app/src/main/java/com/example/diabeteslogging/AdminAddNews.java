package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diabeteslogging.DB.Database;
import com.example.diabeteslogging.DB.NewsDao;
import com.google.android.material.button.MaterialButton;

public class AdminAddNews extends AppCompatActivity {
    Button backNewBtn;
    Button EditNews;
    EditText TopicTitle;
    EditText SummarySec;
    Button EditNewsAddNewsBtn;
    private NewsDao newsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_news);
        getDatabase();
        backNewBtn = findViewById(R.id.AdminAddNewsBackBtn);
        TopicTitle = findViewById(R.id.EditNewsTitleEditText);
        SummarySec = findViewById(R.id.EditNewsSummary);
        EditNewsAddNewsBtn = findViewById(R.id.EditNewsAddNewsBtn);
        backNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        EditNewsAddNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                News news = new News(TopicTitle.getText().toString(), SummarySec.getText().toString());
                newsDao.insert(news);

                Toast.makeText(AdminAddNews.this, "News Added", Toast.LENGTH_SHORT).show();
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