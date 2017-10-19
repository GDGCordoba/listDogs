package com.example.david.ucoexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.david.ucoexample.adapter.DogListAdapter;
import com.example.david.ucoexample.api.DogClient;
import com.example.david.ucoexample.entities.BreedWrapper;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnClickOnItem {

    @BindView(R.id.dogList)
    RecyclerView dogList;

    private DogClient client;
    private DogListAdapter adapter;

    public MainActivity() {
        client = new DogClient();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setAdapter();
        setRecyclerView();
        getDogBreeds();
    }

    private void setAdapter() {
        adapter = new DogListAdapter(this);
    }

    private void setRecyclerView() {
        dogList.setLayoutManager(new LinearLayoutManager(this));
        dogList.setAdapter(adapter);
    }

    private void getDogBreeds() {
        client.getDogService().getBreeds().enqueue(new Callback<BreedWrapper>() {
            @Override
            public void onResponse(Call<BreedWrapper> call, Response<BreedWrapper> response) {
                adapter.setDogBreeds(response.body().getBreeds());
            }

            @Override
            public void onFailure(Call<BreedWrapper> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClickBreed() {
        Intent intent = new Intent(this, DogDetailsActivity.class);
        startActivity(intent);
    }
}
