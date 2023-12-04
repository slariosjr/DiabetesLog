package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;

import com.example.diabeteslogging.DB.Database;

@Entity(tableName = Database.NEWS_TABLE)
public class News  {
    @PrimaryKey(autoGenerate = true)
    private int newsID;
    private String TopicTitle;
    private String NewsSummary;


    public News(String TopicTitle, String NewsSummary){
        this.TopicTitle = TopicTitle;
        this.NewsSummary = NewsSummary;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsID=" + newsID +
                ", TopicTitle='" + TopicTitle + '\'' +
                ", NewsSummary='" + NewsSummary + '\'' +
                '}';
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getTopicTitle() {
        return TopicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        TopicTitle = topicTitle;
    }

    public String getNewsSummary() {
        return NewsSummary;
    }

    public void setNewsSummary(String newsSummary) {
        NewsSummary = newsSummary;
    }


}