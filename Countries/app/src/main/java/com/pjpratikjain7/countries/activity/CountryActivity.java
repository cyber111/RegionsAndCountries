package com.pjpratikjain7.countries.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pjpratikjain7.countries.R;
import com.pjpratikjain7.countries.adpater.CountryListAdapter;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {


    RecyclerView countryRecyclerView;

    ArrayList<String> countries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        countries = (ArrayList<String>) getIntent().getSerializableExtra("countries");

        CountryListAdapter adapter = new CountryListAdapter(this, countries);

        countryRecyclerView = findViewById(R.id.country_recycler_view);
        countryRecyclerView.setAdapter(adapter);
        countryRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
