package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.diabeteslogging.DB.Database;
import com.example.diabeteslogging.DB.User;
import com.example.diabeteslogging.DB.UserDao;

import java.util.ArrayList;
import java.util.List;

public class RemoveUser extends AppCompatActivity {
    private UserDao userDao;
    Button RemoveUserBackBtn;
    Button ManageRemoveUserBtn;
    User selectUser;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> ListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_user);
        getDatabase();
        RemoveUserBackBtn = findViewById(R.id.RemoveUserBackBtn);
        autoCompleteTextView = findViewById(R.id.DropDownRemoveUser);
        List<User> userList = userDao.getUsers();
        List<String> ListUsers = new ArrayList<String>();
        ListItems = new ArrayAdapter<String>(this, R.layout.user_remove_list, ListUsers);
        autoCompleteTextView.setAdapter(ListItems);

        RemoveUserBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        for (User user : userList) {
            ListUsers.add(user.getUsername());
        }
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String users = autoCompleteTextView.getAdapter().getItem(position).toString();
                selectUser = userDao.getUsernameByID(users);
            }
        });
        ManageRemoveUserBtn = findViewById(R.id.ManageRemoveUserBtn);
        ManageRemoveUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDao.delete(selectUser);
                Toast.makeText(RemoveUser.this, "User Removed", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getDatabase(){
        userDao = Room.databaseBuilder(this, Database.class,Database.DATABASE_NAME).allowMainThreadQueries()
                .fallbackToDestructiveMigration().build().UserDao();
    }
}