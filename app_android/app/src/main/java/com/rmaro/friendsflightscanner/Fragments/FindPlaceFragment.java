package com.rmaro.friendsflightscanner.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rmaro.friendsflightscanner.Common.MyFragment;
import com.rmaro.friendsflightscanner.Networking.SkyScannerReferencesObservable;
import com.rmaro.friendsflightscanner.R;

/**
 * Created by rmaro on 24/04/2017.
 */

public class FindPlaceFragment extends MyFragment {

    private SkyScannerReferencesObservable requestReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.find_place_fragment, container, false);
        getAllView(view);

        requestReference = new SkyScannerReferencesObservable(context);

        return view;
    }

    private void getAllView(View view) {

    }
}
