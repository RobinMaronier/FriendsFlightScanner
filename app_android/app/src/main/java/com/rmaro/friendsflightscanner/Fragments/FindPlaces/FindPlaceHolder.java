package com.rmaro.friendsflightscanner.Fragments.FindPlaces;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rmaro.friendsflightscanner.R;

/**
 * Created by rmaro on 28/04/2017.
 */

public class FindPlaceHolder extends RecyclerView.ViewHolder {

    private TextView aiportName;
    private TextView countryName;

    public FindPlaceHolder(View view) {
        super(view);
        aiportName = (TextView) view.findViewById(R.id.holder_airport_name);
        countryName = (TextView) view.findViewById(R.id.holder_country_name);
    }

    public void setTextAirport(String text) {
        aiportName.setText(text);
    }

    public void setTextCountry(String text) {
        countryName.setText(text);
    }
}
