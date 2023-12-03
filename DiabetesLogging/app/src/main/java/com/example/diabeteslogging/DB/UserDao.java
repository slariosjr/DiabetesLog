package com.example.diabeteslogging.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diabeteslogging.LogD;

@Dao
public interface UserDao {
    @Insert
    void insert(User...User);

    @Update
    void update(User...User);

    @Delete
    void delete(User...User);

    @Query(" SELECT * FROM " + Database.USER_TABLE + " WHERE username = :username ")
    User getUsernameByID(String username);

    @Query(" SELECT * FROM " + Database.USER_TABLE + " WHERE password = :password ")
    User getPasswordByID(String password);

    @Query(" SELECT * FROM " + Database.USER_TABLE + " WHERE isAdmin = :isAdmin ")
    User getisAdminByID(boolean isAdmin);




}
