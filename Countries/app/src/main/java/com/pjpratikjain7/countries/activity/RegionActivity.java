package com.pjpratikjain7.countries.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pjpratikjain7.countries.R;
import com.pjpratikjain7.countries.adpater.RegionListAdapter;
import com.pjpratikjain7.countries.api.CountryService;
import com.pjpratikjain7.countries.api.RetrofitClient;
import com.pjpratikjain7.countries.model.Country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RegionActivity extends AppCompatActivity implements RegionListAdapter.ViewHolder.OnRegionListener {

    Set<String> regionsSet = new HashSet<>();
    List<String> regionsList = new ArrayList<>();
    RecyclerView regionRecyclerView;
    HashMap<String, ArrayList<String>> regionsAndCountries = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CountryService service = RetrofitClient.getRetrofitInstance().create(CountryService.class);
        Call<List<Country>> call = service.getCountries();


        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                List<Country> countries = response.body();
                Log.e("Regions", " " + countries.toString());
                for (Country country : countries) {
                    regionsSet.add(country.getRegion());
                }
                for (String region : regionsSet) {
                    if (region.length() > 0)
                        regionsList.add(region);
                }

                for (String region : regionsSet) {
                    ArrayList<String> countryArrayList = new ArrayList<>();
                    for (Country country : countries) {
                        if (region.equals(country.getRegion()))
                                countryArrayList.add(country.getName());
                    }
                    regionsAndCountries.put(region, countryArrayList);
                }


                RegionListAdapter adapter = new RegionListAdapter(RegionActivity.this, regionsList, RegionActivity.this);
                regionRecyclerView = findViewById(R.id.region_recycler_view);
                regionRecyclerView.setAdapter(adapter);
                regionRecyclerView.setLayoutManager(new LinearLayoutManager(RegionActivity.this));

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Toast.makeText(RegionActivity.this, "Error while fetching", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();


    }


    @Override
    public void onRegionClick(int position) {
            regionsList.get(position);
            Toast.makeText(this, "Clicked on : " + regionsList.get(position), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, CountryActivity.class);
        ArrayList<String> countries = regionsAndCountries.get(regionsList.get(position));

        intent.putExtra("countries", countries );
        startActivity(intent);
    }
}
