package com.example.diabeteslogging.DB;

import android.icu.lang.UScript;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LogDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("DELETE FROM USER_TABLE")
    void deleteALl();

    @Query("SELECT * FROM USER_TABLE ORDER BY username ASC")
    List<User> getAlphabetizedWords();
}
