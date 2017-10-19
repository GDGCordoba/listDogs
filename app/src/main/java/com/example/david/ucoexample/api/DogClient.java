package com.example.david.ucoexample.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by david on 1/10/17.
 */

public class DogClient {
    private Retrofit retrofit;
    private final static String BASE_URL = "https://dog.ceo/api/";

    public DogClient(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public DogService getDogService(){
        return this.retrofit.create(DogService.class);
    }
}
