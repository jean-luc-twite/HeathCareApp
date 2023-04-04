package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText userName, password;
    Button Login;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName=(EditText)findViewById(R.id.editTextLogUserName);
        password=(EditText)findViewById(R.id.editTextLogPassword);

        Login=(Button)findViewById(R.id.ButtonAppBookAppointement);
        tv=(TextView) findViewById(R.id.textViewNewUser);

        //set on click listener so that when the user press on the button it will through

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String edUsername=userName.getText().toString();
                String edPassword=password.getText().toString();
                Database db= new Database(getApplicationContext(),"healthcare",null,1);
                //set te condition  if the details are not fill the error message mut be display and if the details are fill the success message must be display
                if(edUsername.length()== 0 || edPassword.length() == 0){
                    Toast.makeText(getApplicationContext(),"Please fill in Your details", Toast.LENGTH_LONG).show();

                }else{
                    if (db.Login(edUsername,edPassword)==1){
                        Toast.makeText(getApplicationContext(),"Login Successfully", Toast.LENGTH_LONG).show();
                        SharedPreferences sharepref=getSharedPreferences("share_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharepref.edit();
                        editor.putString("username",edUsername);
                        //to save our data with key value
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,Home_activity.class));

                    }else{
                        Toast.makeText(getApplicationContext(),"your username and password are invalid", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        //set on click listener for the registration activity so that when the user click on the link it will bring to the registration activity
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the registration activity
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));

            }
        });
    }
}