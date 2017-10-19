package com.example.david.ucoexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.ucoexample.OnClickOnItem;
import com.example.david.ucoexample.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by david on 15/10/17.
 */

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.ViewHolder> {

    private List<String> dogBreeds;
    private OnClickOnItem onClick;

    public DogListAdapter(OnClickOnItem onClick) {
        this.dogBreeds = new ArrayList<>();
        this.onClick = onClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dogBreedName.setText(this.dogBreeds.get(position));
        holder.setOnClickListener(onClick);
    }

    @Override
    public int getItemCount() {
        return this.dogBreeds.size();
    }

    public void setDogBreeds(List<String> dogBreedsArray) {
        this.dogBreeds = dogBreedsArray;
        this.notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dogBreedName)
        TextView dogBreedName;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }

        public void setOnClickListener(final OnClickOnItem onClick){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.onClickBreed();
                }
            });
        }
    }
}
