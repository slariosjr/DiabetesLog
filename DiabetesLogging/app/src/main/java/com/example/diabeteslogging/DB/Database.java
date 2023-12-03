package com.example.diabeteslogging.DB;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.diabeteslogging.AppointmentD;
import com.example.diabeteslogging.Appointments;
import com.example.diabeteslogging.Log;
import com.example.diabeteslogging.LogD;
import com.example.diabeteslogging.News;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {User.class, LogD.class, AppointmentD.class, News.class}, version = 1, exportSchema = false)
public abstract class Database  extends RoomDatabase {
    public static final String DATABASE_NAME = "DiabetesLog.db";
    public static final String USER_TABLE = "User_Table";
    public static final String NEWS_TABLE = "News_Table";
    public static final String LOG_TABLE = "Log_Table";
    public static final String Appointments_Table = "Appoint_Table";

    private static volatile Database INSTANCE;
    private static final Object Auth = new Object();

     public static Database getInstance( Context context){
        if(INSTANCE == null){
            synchronized (Auth){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),Database.class, DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }


    public abstract LogDao LogDao();
    public abstract NewsDao NewsDao();
    public abstract CarbsDao CarbsDao();
    public abstract AppointmentDao AppointmentDao();
    public abstract UserDao UserDao();



}
