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

public class HealthArticleActivity extends AppCompatActivity {
    private String[][] health_details = {
            {"walking Daily", "", "", "", "Click More Details"},
            {"Home Care of COVID-19", "", "", "", "Click More Details"},
            {"Stop Smoking", "", "", "", "Click More Details"},
            {"Menstrual Cramps", "", "", "", "Click More Details"},
            {"Healthy Gut", "", "", "", "Click More Details"}
    };
    private int[] image = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5
    };
    ArrayList list;
    SimpleAdapter sa;
    HashMap item;
    Button btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article);
        listView = findViewById(R.id.ListViewHA);
        btnBack = findViewById(R.id.buttonHABack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticleActivity.this, Home_activity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i < health_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", health_details[i][0]);
            item.put("Line2", health_details[i][1]);
            item.put("Line3", health_details[i][2]);
            item.put("Line4", health_details[i][3]);
            item.put("Line5", health_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.Line_a, R.id.Line_b, R.id.Line_c, R.id.Line_d, R.id.Line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(HealthArticleActivity.this,HealthArticleDetailsActivity.class);
                it.putExtra("text1",health_details[i][0]);
                it.putExtra("text2",image[i]);

                startActivity(it);
            }
        });
    }
}