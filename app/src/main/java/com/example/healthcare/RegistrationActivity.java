package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {


    EditText userName, password,regEmail,regPassword;
    Button register;
    TextView previousUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //declare variable and initialise them
        userName=(EditText) findViewById(R.id.editTextTBAppFullName);
        password=(EditText) findViewById(R.id.editTextTBPinCode);
        regEmail=(EditText) findViewById(R.id.editTextTBAppAdress);
        regPassword=(EditText) findViewById(R.id.editTextTBPhoneNumber);

        register=(Button) findViewById(R.id.ButtonAppBookAppointement);
        previousUser=(TextView) findViewById(R.id.textViewPreviousUser);

        //set the onclick listener where the user will press the link to register
        previousUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //directed this activity to the login activity if user already have an account
                 startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
            }
        });

        //set the on click listener so that the user can press the login button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //declare and initialise the variable.
                String edUserName=userName.getText().toString();
                String email=regEmail.getText().toString();
                String pass=password.getText().toString();
                String confirmPass=regPassword.getText().toString();
                Database db= new Database(getApplicationContext(),"healthcare",null,1);
                // now we are going to set the condition that say if try to login whithout  filling the above details then there must be an error message
                if(edUserName.length()==0 || email.length() == 0 || pass.length()== 0 || confirmPass.length() == 0){
                    //print the suceessfuly message
                    Toast.makeText(getApplicationContext(),"please fill all details",Toast.LENGTH_LONG).show();
                }else {
                    if(pass.compareTo(confirmPass) ==0){
                        if(isPassworValid(pass)){
                            //
                            db.register(edUserName,email,pass);
                            Toast.makeText(getApplicationContext(),"Record inserted",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(),"password must contain atleast 8 characters,having Letter,digit,special char",Toast.LENGTH_LONG).show();
                        }

                    }else {
                        Toast.makeText(getApplicationContext(),"the passwords didn't match",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    // create the static methode that will check the character in the password
    public static boolean isPassworValid(String passwordHere){
        int f1=0,f2=0,f3=0;
       //check if the password must be at least 8
        if(passwordHere.length() < 8){
            return false;
        }else {
            //iterate the for loop through the loop to check if the password have letter
            for (int i = 0; i < passwordHere.length(); i++) {
                //check if the character is  a letter
                if (Character.isLetter(passwordHere.charAt(i))) {
                    f1 = 1;
                }
            }
            //iterate through this loop to check if the password has digit
            for (int j = 0; j < passwordHere.length(); j++) {
                //check if the character is a digit
                if (Character.isDigit(passwordHere.charAt(j))) {
                    f2 = 1;
                }
            }

            //iterate through the third loop to check the password has atlease one or more special character
            for (int h = 0; h < passwordHere.length(); h++) {
                // convert the passwor  in character
                char c = passwordHere.charAt(h);
                //check if the password has atleast one character
                if (c>=33&&c<=46||c==64){
                     f3=1;
                }
            }
            //
            if (f1 == 1 && f2 ==1 && f3 == 1)
                return  true;

                return  false;
        }
    }
}