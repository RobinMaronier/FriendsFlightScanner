package com.rmaro.friendsflightscanner.Networking;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.rmaro.friendsflightscanner.R;

import java.util.Observable;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Robin on 25/11/2016.
 */

public class ObservableTask extends Observable {
    protected Context context;
    protected final String BASEURL;
    protected Retrofit retrofitRequest;
    private SharedPreferences sharedPref;
    protected final String headerForm = "application/json";

    protected ObservableTask(Context context) {
        this.context = context;
        this.BASEURL = this.context.getString(R.string.PREFIX_SCYSCANNER_URL);
        this.retrofitRequest = new Retrofit.Builder()
                .baseUrl(this.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.sharedPref = this.context.getSharedPreferences("storage", Context.MODE_PRIVATE);
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void updateHeaderInformations(okhttp3.Headers headers) {
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString("access-token", headers.get("access-token"));
        editor.putString("client", headers.get("client"));
        editor.putString("uid", headers.get("uid"));
        editor.apply();
    }

    protected String getHeaderInformation(String info) {
        return sharedPref.getString(info, "default");
    }
}
