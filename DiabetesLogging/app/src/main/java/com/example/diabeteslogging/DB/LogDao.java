package com.example.diabeteslogging.DB;

import android.icu.lang.UScript;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.example.diabeteslogging.LogD;

import java.util.List;

@Dao
public interface LogDao {

   @Insert
   void insert(LogD...LogD);
   @Update
   void update(LogD...LogD);
   @Delete
   void delete(LogD...LogD);

   @Query("SELECT * FROM " + Database.LOG_TABLE + " WHERE LogID = :LogID ")
   LogD getLogByID(int LogID);

   @Query(" SELECT * FROM " + Database.LOG_TABLE + " WHERE BloodSugar = :BloodSugar ")
    LogD getBloodSugarByID( String BloodSugar);
   @Query(" SELECT * FROM " + Database.LOG_TABLE + " WHERE Carbs = :Carbs")
   LogD getCarbsByID( String Carbs);
   @Query(" SELECT * FROM " + Database.LOG_TABLE + " WHERE Insulin = :Insulin ")
   LogD getInsulinByID( String Insulin);
   @Query(" SELECT * FROM " + Database.LOG_TABLE + " WHERE LogDate = :LogDate ")
   LogD getLogDateByID( String LogDate);
}
