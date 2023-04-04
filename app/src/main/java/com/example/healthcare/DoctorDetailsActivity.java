package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
        private String [][] doctorDetails={
            {"Doctor Name:Ajit Saste","Hospital Adress:Pimpri","Exp : 5yrs","Mobile No :9898989898","680"},
            {"Doctor Name:Prasad Pawar","Hospital Adress:Nidgi","Exp : 15yrs","Mobile No :7898989898","900"},
            {"Doctor Name:Swapnil","Hospital Adress:Pune","Exp : 8yrs","Mobile No :8898989898","300"},
            {"Doctor Name:Jean-Luc","Hospital Adress:Arcadia","Exp : 6yrs","Mobile No :574989898","500"},
            {"Doctor Name:Gregory","Hospital Adress:hatfielld","Exp : 7yrs","Mobile No :6988989898","800"}
    };

    private String [][] doctorDetails2={
            {"Doctor Name:Alida Twite","Hospital Adress:Lubumbashi","Exp : 8yrs","Mobile No :9698989898","963"},
            {"Doctor Name:Charle Banze","Hospital Adress:kolwezi","Exp : 13yrs","Mobile No :8598989898","950"},
            {"Doctor Name:Diane Fatuma","Hospital Adress:Likasi","Exp : 9yrs","Mobile No :9865324715","350"},
            {"Doctor Name:Gracia Katumbwe","Hospital Adress:lusi","Exp : 6yrs","Mobile No :7845129632","560"},
            {"Doctor Name:Belinda Nsenga","Hospital Adress:madrid","Exp : 8yrs","Mobile No :8512689574","852"}
    };

    private String [][] doctorDetails3={
            {"Doctor Name:Tresore Kwabe","Hospital Adress:Sunnisyde","Exp : 5yrs","Mobile No :6532741524","683"},
            {"Doctor Name:Norbert Nzazi","Hospital Adress:Arcadia","Exp : 10yrs","Mobile No :8798623625","962"},
            {"Doctor Name:Enock Lubaya","Hospital Adress:town","Exp : 9yrs","Mobile No :3265987414","365"},
            {"Doctor Name:David Ebula","Hospital Adress:Arcadia","Exp : 6yrs","Mobile No :574989898","500"},
            {"Doctor Name:cedrick kihilu","Hospital Adress:hamilton","Exp : 7yrs","Mobile No :8563241878","875"}
    };
    private String [][] doctorDetails4={
            {"Doctor Name:Arnold kelani","Hospital Adress:sandton","Exp : 5yrs","Mobile No :9685743652","852"},
            {"Doctor Name:Ladi Katabe","Hospital Adress:Menlyn","Exp : 14yrs","Mobile No :3214789562","965"},
            {"Doctor Name:Chris Jonas","Hospital Adress:wonderboob","Exp : 8yrs","Mobile No :8898989898","956"},
            {"Doctor Name:Samis Mukadi","Hospital Adress:Atterbury","Exp : 12yrs","Mobile No :9865347814","582"},
            {"Doctor Name:Glody Ngoy","Hospital Adress:soshanguve","Exp : 4yrs","Mobile No :857425698","564"}
    };

    private String [][] doctorDetails5={
            {"Doctor Name:Rosalie","Hospital Adress:germiston","Exp : 16rs","Mobile No :8745263214","965"},
            {"Doctor Name:Nebia Ngoki ","Hospital Adress:joburg","Exp : 6yrs","Mobile No :9764312839","584"},
            {"Doctor Name:Nana ketchup","Hospital Adress:North PTA","Exp : 8yrs","Mobile No :8898985498","325"},
            {"Doctor Name:tshaisa","Hospital Adress:Arcadia","Exp : 3yrs","Mobile No :5749865498","478"},
            {"Doctor Name:thembai","Hospital Adress:hatfield","Exp : 7yrs","Mobile No :6988989898","854"}
    };
//    //declare variable and nd initialise variables
    TextView tv;
    Button btn;
        String [][] doctor_Details={};
    ArrayList list;
    SimpleAdapter sa;
    HashMap item;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        lst=(ListView) findViewById(R.id.ListViewBM);
        tv=(TextView) findViewById(R.id.TextViewBMTitle);
        Intent it =getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        btn=(Button) findViewById(R.id.buttonBMBack);
            //if the doctor is the family physiscian
            if (title.compareTo("family physician") ==0) {
                doctor_Details = doctorDetails;
            }else
            //if the doctor is dietician
            if (title.compareTo("Dietician") ==0) {
                doctor_Details = doctorDetails2;
            } else
                //if the doctor is the dentist
            if (title.compareTo("Dentist") ==0) {
                doctor_Details = doctorDetails3;
            }else
                //if the doctor is the surgeon
            if (title.compareTo("Surgeon") ==0) {
                doctor_Details = doctorDetails4;
            }else {
                //if the doctor is the cardiologiste
                doctor_Details = doctorDetails5;
            }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list=new ArrayList<>();
        for(int i=0; i<doctor_Details.length;i++){
            item=new HashMap<String,String>();
            item.put("Line1",doctor_Details[i][0]);
            item.put("Line2",doctor_Details[i][1]);
            item.put("Line3",doctor_Details[i][2]);
            item.put("Line4",doctor_Details[i][3]);
            item.put("Line5","Cons Fees :" + doctor_Details[i][4] +"/-");
            list.add(item);
        }
        sa =new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.Line_a,R.id.Line_b,R.id.Line_c,R.id.Line_d,R.id.Line_e}
        );

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointementActivity.class);
                it.putExtra("text",title);
                it.putExtra("text2",doctor_Details[i][0]);
                it.putExtra("text3",doctor_Details[i][1]);
                it.putExtra("text4",doctor_Details[i][3]);
                it.putExtra("text5",doctor_Details[i][4]);
                 startActivity(it);
            }
        });
    }
}