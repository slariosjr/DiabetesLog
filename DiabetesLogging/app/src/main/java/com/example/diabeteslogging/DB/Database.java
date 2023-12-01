package com.example.diabeteslogging.DB;

import androidx.room.RoomDatabase;

import com.example.diabeteslogging.Appointments;
import com.example.diabeteslogging.Log;


public abstract class Database  extends RoomDatabase {
    public abstract LogDao LogDao();
    public abstract NewsDao NewsDao();
    public abstract CarbsDao CarbsDao();


}
