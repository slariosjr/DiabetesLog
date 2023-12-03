package com.example.diabeteslogging;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.diabeteslogging.DB.Database;

@Entity(tableName = Database.Appointments_Table)
public class AppointmentD {
    @PrimaryKey(autoGenerate = true)
    private int AppointmentID;
    private String AppointmentDetails;

    public AppointmentD(String AppointmentDetails){
        this.AppointmentDetails = AppointmentDetails;
    }

    @Override
    public String toString() {
        return "AppointmentD{" +
                "AppointmentID=" + AppointmentID +
                ", AppointmentDetails='" + AppointmentDetails + '\'' +
                '}';
    }

    public int getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        AppointmentID = appointmentID;
    }

    public String getAppointmentDetails() {
        return AppointmentDetails;
    }

    public void setAppointmentDetails(String appointmentDetails) {
        AppointmentDetails = appointmentDetails;
    }
}
