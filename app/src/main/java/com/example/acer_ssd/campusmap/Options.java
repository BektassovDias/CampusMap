package com.example.acer_ssd.campusmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class Options extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;

    String[] countryNames = {"Library", "Post Office", "North Stadium", "Theater", "Hospital", "Supermarket", "Third Canteen", "Taobao",
            "East Stadium", "ATM", "China Mobile", "School Suguo", "Second Canteen", "Barbershop", "HotDog Bar", "First Canteen", "CS Building"};
    int[] countryFlags = {
            R.drawable.place1,
            R.drawable.place2,
            R.drawable.place3,
            R.drawable.place4,
            R.drawable.place5,
            R.drawable.place6,
            R.drawable.place7,
            R.drawable.place8,
            R.drawable.place9,
            R.drawable.place10,
            R.drawable.place11,
            R.drawable.place12,
            R.drawable.place13,
            R.drawable.place14,
            R.drawable.place15,
            R.drawable.place16,
            R.drawable.place17};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        mListView = (ListView) findViewById(R.id.list);
        MyAdapter myAdapter = new MyAdapter(Options.this, countryNames, countryFlags);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*Intent mIntent = new Intent(Options.this, MapsActivity.class);
                mIntent.putExtra("countryName", countryNames[i]);
//                mIntent.putExtra("countryFlag", countryFlags[i]);
                startActivity(mIntent);*/

                Intent intent = new Intent();
                intent.putExtra("countryName", countryNames[i]);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
