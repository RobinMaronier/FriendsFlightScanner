package com.rmaro.friendsflightscanner.Networking;

import android.content.Context;

import com.rmaro.friendsflightscanner.Models.ListReferencesPlaces;
import com.rmaro.friendsflightscanner.Models.ReferencesCountries;
import com.rmaro.friendsflightscanner.Models.ReferencesPlaces;
import com.rmaro.friendsflightscanner.R;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by rmaro on 28/04/2017.
 */

public class SkyScannerPlacesObservable extends ObservableTask {

    private final static String basePlaceAutoSuggest = "autosuggest/v1.0/";
    private final static String findPlaceByQuery = basePlaceAutoSuggest + "FR/EUR/fr-FR";

    public SkyScannerPlacesObservable(Context context) {
        super(context);
    }

    public void getPlaceByQuery(String query, Callback<ListReferencesPlaces> callback) {
        GetPlaceByQueryService profil = retrofitRequest.create(GetPlaceByQueryService.class);
        Call<ListReferencesPlaces> call = profil.request(this.headerForm, query, context.getString(R.string.APIKEY_SKYSCANNER));
        call.enqueue(callback);
    }

    private interface GetPlaceByQueryService {
        @GET(findPlaceByQuery)
        Call<ListReferencesPlaces> request(@Header("Accept") String accept,
                                           @Query("query") String query,
                                           @Query("apiKey") String apikey);
    }

}
