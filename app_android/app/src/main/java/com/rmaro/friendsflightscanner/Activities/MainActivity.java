package com.rmaro.friendsflightscanner.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rmaro.friendsflightscanner.Common.FragmentReturn;
import com.rmaro.friendsflightscanner.Common.MyActivity;
import com.rmaro.friendsflightscanner.Common.MyFragment;
import com.rmaro.friendsflightscanner.Fragments.FindPlaceFragment;
import com.rmaro.friendsflightscanner.R;

public class MainActivity extends MyActivity implements FragmentReturn {

    private Button departurePlaceButton;
    private Button arrivalPlaceButton;
    private Button searchButton;

    private TextView departurePlaceText;
    private TextView arrivalPlaceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

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
                /**/
            }
        });

        arrivalPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushFindPlaceFragment();
                /**/
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**/
            }
        });
    }

    @Override
    public void fragmentReturn(MyFragment fragment) {
        super.fragmentReturn(fragment);
    }
}
