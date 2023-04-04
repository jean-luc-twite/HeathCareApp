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

public class LabTestDetailsActivity extends AppCompatActivity {
  TextView tvPackageName,tvTotalCost;
  EditText edDetails;
  Button btnGoToCard,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName=findViewById(R.id.textViewCartPackageName);
        tvTotalCost=findViewById(R.id.TextViewLDTotalCost);
        edDetails=findViewById(R.id.editTextLDTextMultiline);
        btnGoToCard=findViewById(R.id.AddtoCardLTDbutton);
        btnBack=findViewById(R.id.buttonLTDBack);


         Intent  intent=getIntent();
         tvPackageName.setText(intent.getStringExtra("text1"));
         edDetails.setText(intent.getStringExtra("text2"));
         tvTotalCost.setText(intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }
        });
         btnGoToCard.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 SharedPreferences sharedPreferences =getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                 String username = sharedPreferences.getString("username","").toString();
                 String product =tvPackageName.getText().toString();
                 float price =Float.parseFloat(intent.getStringExtra("text3").toString());

                 Database db = new Database(getApplicationContext(),"healthCare",null,1);

                  if(db.checkCart(username,product)== 1){
                      Toast.makeText(getApplication(),"product already added",Toast.LENGTH_LONG).show();
                  }else{
                      db.addCart(username,product,price,"lab");
                      Toast.makeText(getApplicationContext(),"Record Inserted to cart",Toast.LENGTH_LONG).show();
                      startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
                  }

             }
         });
    }
}