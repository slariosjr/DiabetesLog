package com.example.diabeteslogging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NewLogDetails extends AppCompatActivity {
    TextView dateLog, BgLog, InsulinLog, CarbsLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_log_details);

        dateLog = findViewById(R.id.AddDateTitle);
        BgLog = findViewById(R.id.AddBloodSugarTextView);
        InsulinLog = findViewById(R.id.AddInsulinTextView);
        CarbsLog = findViewById(R.id.AddCarbsTextView);

        Intent intent = getIntent();
        String dateL = intent.getExtras().getString("Date");
        String BgL = intent.getExtras().getString("Blood Sugar");
        String InsulinL = intent.getExtras().getString("Insulin");
        String CarbsL = intent.getExtras().getString("Carbs");

        dateLog.setText(dateL);
        BgLog.setText(BgL);
        InsulinLog.setText(InsulinL);
        CarbsLog.setText(CarbsL);



    }
}