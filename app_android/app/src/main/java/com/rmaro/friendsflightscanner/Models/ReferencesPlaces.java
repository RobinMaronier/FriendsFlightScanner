package com.rmaro.friendsflightscanner.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rmaro on 24/04/2017.
 */

public class ReferencesPlaces {

    @SerializedName("PlaceId")
    public String placeId;

    @SerializedName("PlaceName")
    public String placeName;

    @SerializedName("CountryId")
    public String countryId;

    @SerializedName("CityId")
    public String cityId;

    @SerializedName("CountryName")
    public String countryName;
}
