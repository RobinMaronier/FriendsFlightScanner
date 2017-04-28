package com.rmaro.friendsflightscanner.Common;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by rmaro on 22/04/2017.
 */

abstract public class MyActivity extends AppCompatActivity {

    private FrameLayout fullScreenFrame = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFullscreenFrame();
    }

    public void addFragmentFullscreen(MyFragment fragment, FragmentReturn fragmentReturn) {
        fragment.setFragmentReturn(fragmentReturn);
        fullScreenFrame.setVisibility(View.VISIBLE);
        addContentView(fullScreenFrame, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(fullScreenFrame.getId(), fragment).commit();
    }

    public void fragmentReturn(MyFragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        fullScreenFrame.setVisibility(View.INVISIBLE);
        ((ViewGroup) fullScreenFrame.getParent()).removeView(fullScreenFrame);
    }

    private void initFullscreenFrame() {
        @IdRes int idFrame = 99589790;
        fullScreenFrame = new FrameLayout(this);
        fullScreenFrame.setId(idFrame);
        fullScreenFrame.setBackgroundColor(0);
        fullScreenFrame.getBackground().setAlpha(0);
        fullScreenFrame.setClickable(true); // Make under not clickable
    }
}
