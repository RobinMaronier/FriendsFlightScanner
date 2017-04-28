package com.rmaro.friendsflightscanner.Networking;

import android.content.Context;

import com.rmaro.friendsflightscanner.Models.ReferencesCountries;
import com.rmaro.friendsflightscanner.R;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by rmaro on 24/04/2017.
 */

public class SkyScannerReferencesObservable extends ObservableTask {

    private final static String baseReferenceSkyScanner = "reference/v0.1/";
    private final static String getCountry = baseReferenceSkyScanner + "countries";

    public SkyScannerReferencesObservable(Context context) {
        super(context);
    }

    public void getCountries(Callback<List<ReferencesCountries>> callback) {
        SkyScannerReferencesObservable.GetCountriesServices profil = retrofitRequest.create(SkyScannerReferencesObservable.GetCountriesServices.class);
        Call<List<ReferencesCountries>> call = profil.request(this.headerForm,
                context.getString(R.string.local),
                context.getString(R.string.APIKEY_SKYSCANNER));
        call.enqueue(callback);
    }
    private interface GetCountriesServices {
        @GET(getCountry)
        Call<List<ReferencesCountries>> request(@Header("Accept") String accept,
                                                @Field("locale") String country,
                                                @Field("apiKey") String apiKey);
    }
}
