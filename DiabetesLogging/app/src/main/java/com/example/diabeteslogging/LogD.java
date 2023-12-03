package com.example.diabeteslogging;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.diabeteslogging.DB.Database;

@Entity(tableName = Database.LOG_TABLE)
public class LogD {
    @PrimaryKey(autoGenerate = true)
    private int LogID;
    private String BloodSugar;
    private String Carbs;
    private String Insulin;
    private String LogDate;

    public LogD(String BloodSugar, String Carbs, String Insulin, String LogDate){
        this.BloodSugar = BloodSugar;
        this.Carbs = Carbs;
        this.Insulin = Insulin;
        this.LogDate = LogDate;
    }

    @Override
    public String toString() {
        return "LogD{" +
                "LogID=" + LogID +
                ", BloodSugar='" + BloodSugar + '\'' +
                ", Carbs='" + Carbs + '\'' +
                ", Insulin='" + Insulin + '\'' +
                ", LogDate='" + LogDate + '\'' +
                '}';
    }

    public int getLogID() {
        return LogID;
    }

    public void setLogID(int logID) {
        LogID = logID;
    }

    public String getBloodSugar() {
        return BloodSugar;
    }

    public void setBloodSugar(String bloodSugar) {
        BloodSugar = bloodSugar;
    }

    public String getCarbs() {
        return Carbs;
    }

    public void setCarbs(String carbs) {
        Carbs = carbs;
    }

    public String getInsulin() {
        return Insulin;
    }

    public void setInsulin(String insulin) {
        Insulin = insulin;
    }

    public String getLogDate() {
        return LogDate;
    }

    public void setLogDate(String logDate) {
        LogDate = logDate;
    }
}
