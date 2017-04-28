package com.rmaro.friendsflightscanner.Networking;

import android.content.Context;

import com.rmaro.friendsflightscanner.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;

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
                                   @Field("country") String country,
                                   @Field("currency") String currency,
                                   @Field("locale") String local,
                                   @Field("originPlace") String originPlace,
                                   @Field("destinationPlace") String destinationPlace,
                                   @Field("outboundPartialDate") String departureDate,
                                   @Field("apiKey") String apiKey);
    }
}
