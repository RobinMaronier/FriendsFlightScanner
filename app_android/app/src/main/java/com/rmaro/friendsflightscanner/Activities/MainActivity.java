package com.rmaro.friendsflightscanner.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rmaro.friendsflightscanner.Common.FragmentReturn;
import com.rmaro.friendsflightscanner.Common.MyActivity;
import com.rmaro.friendsflightscanner.Common.MyFragment;
import com.rmaro.friendsflightscanner.Fragments.FindPlaces.FindPlaceFragment;
import com.rmaro.friendsflightscanner.Models.ReferencesPlaces;
import com.rmaro.friendsflightscanner.Networking.SkyScannerObservable;
import com.rmaro.friendsflightscanner.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends MyActivity implements FragmentReturn {

    private Button departurePlaceButton;
    private Button arrivalPlaceButton;
    private Button searchButton;

    private TextView departurePlaceText;
    private TextView arrivalPlaceText;

    private ReferencesPlaces departureChose = null;
    private ReferencesPlaces arrivalChose = null;

    private boolean departureInChoosing = false;

    private SkyScannerObservable requestSkyScanner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        requestSkyScanner = new SkyScannerObservable(getApplicationContext());

        getAllView();
        settingsAllView();
    }

    private void getAllView() {
        departurePlaceButton = (Button) findViewById(R.id.find_place_depart_button);
        arrivalPlaceButton = (Button) findViewById(R.id.find_place_arrival_button);
        searchButton = (Button) findViewById(R.id.search_button);
        departurePlaceText = (TextView) findViewById(R.id.city_depart_text);
        arrivalPlaceText = (TextView) findViewById(R.id.city_arrival_text);
    }

    private void pushFindPlaceFragment() {
        FindPlaceFragment fragment = new FindPlaceFragment();
        addFragmentFullscreen(fragment, this);
    }

    private void settingsAllView() {
        departurePlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushFindPlaceFragment();
                departureInChoosing = true;
            }
        });

        arrivalPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushFindPlaceFragment();
                departureInChoosing = false;
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestSkyScanner.getCachePricesCheapest("FR", "EUR", departureChose.placeId, arrivalChose.placeId, "2017-07-14", new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            // TODO
                        } else {
                            // TODO
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // TODO
                    }
                });
            }
        });
    }

    @Override
    public void fragmentReturn(MyFragment fragment) {
        ReferencesPlaces result = (ReferencesPlaces) fragment.getResult();
        if (departureInChoosing) {
            departureChose = result;
        } else {
            arrivalChose = result;
        }
        super.fragmentReturn(fragment);
        setTextChose();
    }

    private void setTextChose() {
        if (departureChose != null) {
            departurePlaceText.setText(departureChose.placeName);
        }
        if (arrivalChose != null) {
            arrivalPlaceText.setText(arrivalChose.placeName);
        }
    }
}
