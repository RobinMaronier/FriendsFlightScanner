package com.rmaro.friendsflightscanner.Networking;

import android.content.Context;

import com.rmaro.friendsflightscanner.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by rmaro on 24/04/2017.
 */

public class SkyScannerObservable extends ObservableTask {

    private final static String getCachePricesCheapest = "browsequotes/v1.0";

    public SkyScannerObservable(Context context) {
        super(context);
    }

    public void getCachePricesCheapest(String country, String currency, String originPlace,
                                       String destinationPlace, String departureDate, Callback<ResponseBody> callback) {
        GetCachePricesCheapestServices profil = retrofitRequest.create(GetCachePricesCheapestServices.class);
        Call<ResponseBody> call = profil.request(this.headerForm,
                country,
                currency,
                context.getString(R.string.local),
                originPlace,
                destinationPlace,
                departureDate,
                context.getString(R.string.APIKEY_SKYSCANNER));
        call.enqueue(callback);
    }
    private interface GetCachePricesCheapestServices {
        @GET(getCachePricesCheapest)
        Call<ResponseBody> request(@Header("Accept") String accept,
                                   @Query("country") String country,
                                   @Query("currency") String currency,
                                   @Query("locale") String local,
                                   @Query("originPlace") String originPlace,
                                   @Query("destinationPlace") String destinationPlace,
                                   @Query("outboundPartialDate") String departureDate,
                                   @Query("apiKey") String apiKey);
    }
}
