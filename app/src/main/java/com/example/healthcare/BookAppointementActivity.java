package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class BookAppointementActivity extends AppCompatActivity {
    // declare variable and inialise
    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    Button dateButton,timeButton,backButton,bookAppButton;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointement);
        //initialise variables
        ed1 = (EditText) findViewById(R.id.editTextTBAppFullName);
        ed2 = (EditText) findViewById(R.id.editTextTBAppAdress);
        ed3 = (EditText) findViewById(R.id.editTextTBPinCode);
        ed4 = (EditText) findViewById(R.id.editTextTBPhoneNumber);
        tv = (TextView) findViewById(R.id.TextViewTBAppTitle);
        dateButton = (Button) findViewById(R.id.buttonAppDate);
        timeButton =(Button)findViewById(R.id.buttonAppTime) ;
        backButton=(Button)findViewById(R.id.buttonAppBookTB);
        bookAppButton=(Button)findViewById(R.id.ButtonAppBookAppointement);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        //fetch data
        Intent it = getIntent();
        String title = it.getStringExtra("text");
        String fullName = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        ed1.setText(fullName);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Cons Fees: " + fees + "/-");
        tv.setText(title);

        //date picker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
        //
        iniTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppointementActivity.this,FindDoctorActivity.class));
            }
        });
        bookAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db =new Database(getApplicationContext(),"healthcare",null,1);
                SharedPreferences sharedPreferences =getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
               if(db.checkAppointementExist(username,title+"=>" +fullName,address,contact,dateButton.getText().toString(),timeButton.getText().toString())==1){
                   Toast.makeText(getApplicationContext()," appointement already book ",Toast.LENGTH_LONG).show();
                   startActivity(new Intent(BookAppointementActivity.this,Home_activity.class));


               }else{
                   db.addOrder(username,title+"=>"+fullName,address,contact,0,dateButton.getText().toString(),timeButton.getText().toString(),Float.parseFloat(fees),"Appointment");
                   Toast.makeText(getApplicationContext(),"your appointement is  done successfully",Toast.LENGTH_LONG).show();
               }
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton.setText(i2 + "/" + i1 + "/" + i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis());
    }

    private void iniTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                //
               timeButton.setText(i + ":" + i1);
            }
        };
         Calendar cal =Calendar.getInstance();
         int hrs = cal.get(Calendar.HOUR);
         int min =cal.get(Calendar.MINUTE);

        int style =AlertDialog.THEME_HOLO_DARK;
        timePickerDialog =new TimePickerDialog(this,style,timeSetListener,hrs,min,true);
    }

}