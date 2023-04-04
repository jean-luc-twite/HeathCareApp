package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticleDetailsActivity extends AppCompatActivity {
     TextView tv1;
     ImageView iv;
     Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_details);

        btnBack=findViewById(R.id.buttonHADBack);
        tv1=findViewById(R.id.textViewHADTitle);
        iv=findViewById(R.id.ImageViewHAD);

        Intent it = getIntent();
        tv1.setText(it.getStringExtra("text1"));

        Bundle bundle =getIntent().getExtras();
        if(bundle !=null){
            int resId =bundle.getInt("text2");
            iv.setImageResource(resId);
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticleDetailsActivity.this,HealthArticleActivity.class));
            }
        });
    }
}