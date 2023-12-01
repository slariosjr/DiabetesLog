package com.example.diabeteslogging;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Appointments extends AppCompatActivity {

    Button AddNewAppointmentBtn;
    AlertDialog dialog;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        AddNewAppointmentBtn = findViewById(R.id.AddNewAppointmentBtn);
        layout = findViewById(R.id.layoutContainer);

        buildDialog();

        AddNewAppointmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

    }
    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog, null);

        EditText appointment = view.findViewById(R.id.AppointmentEditText);


        builder.setView(view);
        builder.setTitle("Appointment Details").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addCard(appointment.getText().toString());
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog = builder.create();
    }
    private void addCard(String appointment) {
        View view = getLayoutInflater().inflate(R.layout.loglist,null);

        TextView AppointmentTextView = view.findViewById(R.id.AppointmentTextView);


        Button RemoveLogBtn = view.findViewById(R.id.RemoveLogBtn);

        AppointmentTextView.setText(appointment);

        RemoveLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(view);
            }
        });

        layout.addView(view);
    }

}