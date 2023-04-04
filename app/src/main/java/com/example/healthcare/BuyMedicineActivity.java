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

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][]packages ={
            {"Uprise-03 1000IU Capsule","","","","50"},
            {"HealthVit Chronium Picolinate 200mcg Capsule","","","","305"},
            {"Vitamin B Complex Capsules","","","","448"},
            {"InLife Vitamine E Wheat Germ Dil Capsule","","","","539"},
            {"Dolo 650 Tablet","","","","30"},
            {"Crocin 650 Advance Tablet","","","","50"},
            {"Strepsills Medicated Lozenges for Sore Throat","","","","40"},
            {"Tata 1mg Calcium + Vitamin D3","","","","30"},
            {"Feronia -XT Tablet","","","","130"},

    };

    private String[] package_details={
           "Building and Keeping the bones & teeth strong\n" +
                   "Reducing Fatigue/stress and muscular pains\n" +
                   "Boosting immunity and increasing resistance against infections",
            "Chronium is an essential trace minerale that plays an important role it helping insulin regulate blood glucose",
            "Provides relief from vitamin B deficiencies\n" +
                    "Helps in formation of red blood cells\n" +
                    "Maintains healthy nervous system",
            "It promotes health as weel as skin benefits.\n" +
                    "It helps reduce skin blemish and pigmentation.\n" +
                    "It act as safeguard the skin from the harsh UVA and UV3 sun rays.",
            "Dolo 650 Tablet helps reliave pain and fever by blocking the release of the certain chemical messenger responsible for fever and pain",
            "Helps relieve fever and bring down a high temperature\n"+
                    "Suitable for people with heart condition or high blood  pressure ",
            "Relieve the symptoms of bacterials throat infections and sootnes the recovery process\n" +
                    "Provide a warm and comforting feeling during sore throat",
            "Reduce the risk of calcium deficiency, Ricket,and Dsteaporosis\n"+
                    "Promote mobility and flexibility of joints",
            "Helps to reduce the iron deficiency due to chronic blood lossor low intake of iron"

    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    Button btnBack,btnGoToTheCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToTheCard = findViewById(R.id.GotoCardBMbutton);
        listView = findViewById(R.id.ListViewBM);

        btnGoToTheCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, Home_activity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", packages[i][0]);
            item.put("Line2", packages[i][1]);
            item.put("Line3", packages[i][2]);
            item.put("Line4", packages[i][3]);
            item.put("Line5", "Total Cons: " + packages[i][4] + "/-");
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
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }


}