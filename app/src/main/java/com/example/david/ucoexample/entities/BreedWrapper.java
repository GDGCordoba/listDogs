package com.example.david.ucoexample.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by david on 1/10/17.
 */

public class BreedWrapper {
    @SerializedName("message")
    private List<String> breeds;

    public List<String> getBreeds() {
        return breeds;
    }
}
