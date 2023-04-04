package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        //declare varaiable and initialise the variables
        CardView exit=(CardView) findViewById(R.id.CardFindBack);
        //MAKE THE CARD VIEW TO BE AN EXIT BUTTON
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set the activity when the user will click on the  button back the application will return to the home activity
                startActivity(new Intent(FindDoctorActivity.this,Home_activity.class));
            }
        });
        CardView familyPhysician= (CardView) findViewById(R.id.cardFamilyPhysician);
         // set the cardview familly physician to be a button when the user on the application will show the find doctor activity  details
          familyPhysician.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                  it.putExtra("title","family physician");
                  startActivity(it);
              }
          });
        CardView dietician =(CardView) findViewById(R.id.cardFDDietician);
        // set the cardview dietician to be a button when the user on the application will show the dietician activity  details
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });

        CardView dentist= (CardView) findViewById(R.id.CardFindDentist);
        // set the cardview familly physician to be a button when the user on the application will show the find doctor activity  details
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });


        CardView surgeon= (CardView) findViewById(R.id.CardFindSurgeon);
        // set the cardview familly physician to be a button when the user on the application will show the find doctor activity  details
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","surgeon");
                startActivity(it);
            }
        });

        CardView cardiologist= (CardView) findViewById(R.id.CardFindCardiologist);
        // set the cardview familly physician to be a button when the user on the application will show the find doctor activity  details
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);
            }
        });

    }
}