package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // we create the shared preferences to create one object and get string with the same key name and store that value in the username variable
        SharedPreferences sharedPreferences = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        Toast.makeText(getApplication(), "welcome" + username, Toast.LENGTH_LONG).show();
        //here we ceate object of card view that make the functionality of the Exit Button
        CardView exit = (CardView) findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // on the click we clear the username that is store in the shared preference
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity((new Intent(Home_activity.this, LoginActivity.class)));
            }
        });
        CardView findDoctor = (CardView) findViewById(R.id.findDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_activity.this, FindDoctorActivity.class));

            }
        });

        CardView labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_activity.this,LabTestActivity.class));
            }
        });
        CardView orderDetails=findViewById(R.id.cardOrderDetails);
        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_activity.this,OrderDetailsActivity.class));
            }
        });
        CardView BuyMedicine=findViewById(R.id.cardLabBuyMedcine);
        BuyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_activity.this,BuyMedicineActivity.class));
            }
        });

        CardView health=findViewById(R.id.cardHealthDoctor);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_activity.this,HealthArticleActivity.class));
            }
        });

    }
}