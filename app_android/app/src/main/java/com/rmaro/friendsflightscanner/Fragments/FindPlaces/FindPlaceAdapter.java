package com.rmaro.friendsflightscanner.Fragments.FindPlaces;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rmaro.friendsflightscanner.Models.ReferencesPlaces;
import com.rmaro.friendsflightscanner.R;

import java.util.ArrayList;

/**
 * Created by rmaro on 28/04/2017.
 */

public class FindPlaceAdapter extends RecyclerView.Adapter<FindPlaceHolder> {

    private ArrayList<ReferencesPlaces> listPlaces = new ArrayList<>();
    private FindPlaceReturn setter;

    public FindPlaceAdapter(ArrayList<ReferencesPlaces> listPlaces, FindPlaceReturn setter) {
        this.listPlaces = listPlaces;
        this.setter = setter;
        Log.i("INFO", "" + listPlaces.size());
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(FindPlaceHolder holder, int position) {
        ReferencesPlaces contentItem = listPlaces.get(position);
        holder.setTextAirport(contentItem.placeName);
        holder.setTextCountry(contentItem.countryName);
    }

    @Override
    public int getItemCount() {
        return listPlaces.size();
    }

    @Override
    public FindPlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_place, parent, false);
        final FindPlaceHolder cell = new FindPlaceHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickOnCell(cell);
            }
        });
        return cell;
    }

    private void clickOnCell(FindPlaceHolder cell) {
        setter.setPlaceChose(listPlaces.get(cell.getAdapterPosition()));
    }
}
