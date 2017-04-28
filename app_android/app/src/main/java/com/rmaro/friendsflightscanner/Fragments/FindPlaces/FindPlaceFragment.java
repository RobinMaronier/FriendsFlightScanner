package com.rmaro.friendsflightscanner.Fragments.FindPlaces;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.rmaro.friendsflightscanner.Common.MyFragment;
import com.rmaro.friendsflightscanner.Models.ListReferencesPlaces;
import com.rmaro.friendsflightscanner.Models.ReferencesPlaces;
import com.rmaro.friendsflightscanner.Networking.SkyScannerPlacesObservable;
import com.rmaro.friendsflightscanner.Networking.SkyScannerReferencesObservable;
import com.rmaro.friendsflightscanner.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rmaro on 24/04/2017.
 */

public class FindPlaceFragment extends MyFragment<ReferencesPlaces> implements SearchView.OnQueryTextListener, FindPlaceReturn {

    private SkyScannerPlacesObservable requestPlaces;
    private SearchView searchText;
    private RecyclerView listPlaces;

    private ReferencesPlaces result = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.find_place_fragment, container, false);
        getAllView(view);

        requestPlaces = new SkyScannerPlacesObservable(context);

        return view;
    }

    private void getAllView(View view) {
        searchText = (SearchView) view.findViewById(R.id.search_place_text);
        searchText.setOnQueryTextListener(this);
        listPlaces = (RecyclerView) view.findViewById(R.id.recycler_view_list_places);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        listPlaces.setLayoutManager(mLayoutManager);
        listPlaces.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onQueryTextChange(String query) {
        if (query.length() >= 2) {
            final FindPlaceReturn This = this;
            requestPlaces.getPlaceByQuery(query, new Callback<ListReferencesPlaces>() {
                @Override
                public void onResponse(Call<ListReferencesPlaces> call, Response<ListReferencesPlaces> response) {
                    if (response.isSuccessful()) {
                        listPlaces.setAdapter(new FindPlaceAdapter(new ArrayList<ReferencesPlaces>(response.body().listPlace), This));
                    } else {
                        // TODO
                        Log.i("ERROR", "error here 1");
                        Log.i("ERROR", response.message());
                    }
                }

                @Override
                public void onFailure(Call<ListReferencesPlaces> call, Throwable t) {
                    // TODO
                    Log.i("ERROR", "error here 2");
                    Log.i("ERROR", t.getMessage());
                }
            });
        }
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

   @Override
    public ReferencesPlaces getResult() {
       return result;
   }

    public void setPlaceChose(ReferencesPlaces place) {
        result = place;
        finish();
    }
}
