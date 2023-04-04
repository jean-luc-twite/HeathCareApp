package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
   private String[][]packages ={
           {"package 1: Full Body Checkup","","","","999"},
           {"package 2:Blood Glucose Fasting","","","","299"},
           {"package 3:COVID-19 Antibody","","","","899"},
           {"package 4: Thyroid","","","","499"},
           {"package 5: Immunity Check","","","","699"}
   };

 private String[] package_details={
      "Blood Glucose Fasting\n " +
              "Complete Hemocram\n" +
              "HbA1c\n"+
              "Kidney Function Test\n"+
              "LDH Lactate Dehydrogenase, Serum\n" +
              "Lipid Profile \n"+
              "Liver Function Test",
         "Blood Glucose Fasting",
         "COVID-19 Antibody -Ig6",
         "Thyroid Profile-Total (T3,T4, & Ultra-sensitive)",
         "Complete Henogram\n" +
                 "CRP (C Reactive Protein)Quantitative, Serum\n" +
                 "Iron Studies  \n" +
                 "Kidney Function Test\n"+
                 "Vitamin D Total-25 Hydroxy\n" +
                 "Liver Function Test\n" +
                 "Lipid Profile"

    };
        HashMap<String, String> item;
        ArrayList list;
        SimpleAdapter sa;
        Button btnBack,btnGoToTheCard;
        ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

           btnBack=findViewById(R.id.buttonLTBack);
           btnGoToTheCard=findViewById(R.id.GotoCardLTbutton);
           listView=findViewById(R.id.ListViewLT);

           btnBack.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                  startActivity(new Intent(LabTestActivity.this,Home_activity.class));
               }
           });

           list =new ArrayList();
           for(int i=0;i<packages.length;i++){
               item =new HashMap<String, String>();
               item.put("Line1",packages[i][0]);
               item.put("Line2",packages[i][1]);
               item.put("Line3",packages[i][2]);
               item.put("Line4",packages[i][3]);
               item.put("Line5","Total Cons: "+packages[i][4] +"/-");
               list.add(item);
           }
           sa = new SimpleAdapter(this,list,
                   R.layout.multi_lines,
                   new String[] {"Line1","Line2","Line3","Line4","Line5"},
                   new int[] {R.id.Line_a,R.id.Line_b,R.id.Line_c,R.id.Line_d,R.id.Line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                 it.putExtra("text1",packages[i][0]);
                 it.putExtra("text2",package_details[i]);
                 it.putExtra("text3",packages[i][4]);
                 startActivity(it);
            }
        });
        btnGoToTheCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }
}