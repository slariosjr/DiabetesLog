package com.example.diabeteslogging.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diabeteslogging.AppointmentD;


@Dao
public interface AppointmentDao {
    @Insert
    void insert(AppointmentD...AppointmentD);
    @Update
    void update(AppointmentD...AppointmentD);
    @Delete
    void delete(AppointmentD...AppointmentD);

    @Query("SELECT * FROM " + Database.Appointments_Table + " WHERE  AppointmentID = :AppointmentID")
    AppointmentD getAppointmentID(int AppointmentID);

    @Query("SELECT * FROM " + Database.Appointments_Table + " WHERE AppointmentDetails = :AppointmentDetails")
    AppointmentD getAppointmentDetails(String AppointmentDetails);
}
