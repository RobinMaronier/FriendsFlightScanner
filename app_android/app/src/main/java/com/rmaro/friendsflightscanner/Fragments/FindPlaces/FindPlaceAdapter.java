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

    public FindPlaceAdapter(ArrayList<ReferencesPlaces> listPlaces) {
        this.listPlaces = listPlaces;
        Log.i("INFO", "" + listPlaces.size());
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(FindPlaceHolder holder, int position) {
        final ReferencesPlaces contentItem = listPlaces.get(position);
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
        return new FindPlaceHolder(itemView);
    }
}
