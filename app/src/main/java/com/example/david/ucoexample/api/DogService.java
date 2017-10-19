package com.example.david.ucoexample.api;

import com.example.david.ucoexample.entities.BreedWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by david on 1/10/17.
 */

public interface DogService {
    @GET("breeds/list")
    Call<BreedWrapper> getBreeds();
}
