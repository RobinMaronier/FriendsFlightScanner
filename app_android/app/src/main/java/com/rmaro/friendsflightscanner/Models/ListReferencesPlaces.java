package com.rmaro.friendsflightscanner.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rmaro on 28/04/2017.
 */

public class ListReferencesPlaces {
    @SerializedName("Places")
    public List<ReferencesPlaces> listPlace;
}
