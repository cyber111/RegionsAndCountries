package com.pjpratikjain7.countries.api;

import com.pjpratikjain7.countries.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryService {

@GET("all")
    Call<List<Country>> getCountries();

}
