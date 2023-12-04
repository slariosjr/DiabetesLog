package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NewsDetails extends AppCompatActivity {
    TextView newsSummary;
    TextView newsTitle;
    Button AddNewsBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);


        newsSummary = findViewById(R.id.AddNewsSummary);
        newsTitle = findViewById(R.id.AddNewsTitle);
        AddNewsBackBtn = findViewById(R.id.AddNewsBackBtn);
        AddNewsBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Intent intent = getIntent();
        String TopicTitle = intent.getExtras().getString("Topic Title");
        String summary = intent.getExtras().getString("Summary");

        newsTitle.setText(TopicTitle);
        newsSummary.setText(summary);


    }
}