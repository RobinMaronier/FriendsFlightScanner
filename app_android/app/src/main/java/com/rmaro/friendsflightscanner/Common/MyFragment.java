package com.rmaro.friendsflightscanner.Common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by rmaro on 22/04/2017.
 */


public abstract class MyFragment<R> extends Fragment {
        protected Context context = null;
        protected MyActivity activity = null;
        protected FragmentReturn fragmentReturn = null;
        protected MyFragment thisFragment = this;

        private FrameLayout fullScreenFrame = null;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            context = getActivity().getApplicationContext();
            activity = (MyActivity) getActivity();
            initFullscreenFrame();

            return null;
        }

        public void setFragmentReturn(FragmentReturn fragmentReturn) {
            this.fragmentReturn = fragmentReturn;
        }

        private void initFullscreenFrame() {
            @IdRes int idFrame = 99988999;
            fullScreenFrame = new FrameLayout(activity);
            fullScreenFrame.setId(idFrame);
            fullScreenFrame.setBackgroundColor(0);
            fullScreenFrame.getBackground().setAlpha(100);
            fullScreenFrame.setClickable(true); // Make under not clickable
        }

        protected void finish() {
            if (fragmentReturn != null) {
                fragmentReturn.fragmentReturn(this);
            }
        }

        public R getResult() {
            return null;
        }
}
