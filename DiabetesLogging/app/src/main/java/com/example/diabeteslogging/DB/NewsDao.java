package com.example.diabeteslogging.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diabeteslogging.News;

@Dao
public interface NewsDao {

    @Insert
    void insert(News...News);
    @Update
    void update(News...News);
    @Delete
    void delete(News...News);

    @Query("SELECT * FROM " + Database.NEWS_TABLE + " WHERE newsID = :newsID ")
    News getNewsID(int newsID);

    @Query("SELECT * FROM " + Database.NEWS_TABLE + " WHERE TopicTitle = :TopicTitle")
    News getTopicByTopic(String TopicTitle);





}
