package com.promeg.github.doubanmovie.common.utils.test;

import com.promeg.github.doubanmovie.common.utils.Utility;

import android.view.View;
import android.widget.TextView;

import rx.android.plugins.RxAndroidPlugins;
import rx.plugins.RxJavaPlugins;

/**
 * Created by guyacong on 2015/5/25.
 */
public class TestUtils {

    private TestUtils() {
        //no instance
    }

    public static void setRxSchedulersForUnitTestsIfNeeded(){
        if(Utility.isUnderRoboletricTest()){
            try {
                RetrofitRxJavaSchedulersHook schedulersHook = new RetrofitRxJavaSchedulersHook();
                RxJavaPlugins.getInstance().registerSchedulersHook(schedulersHook);
            } catch(IllegalStateException e){
                //ignore
            }

            try {
                RetrofitRxAndroidSchedulersHook androidSchedulersHook = new RetrofitRxAndroidSchedulersHook();
                RxAndroidPlugins.getInstance().registerSchedulersHook(androidSchedulersHook);
            } catch(IllegalStateException e) {
                //ignore
            }
        }

    }

    public static int viewVisibility(View view, int id){
        if(view != null && view.findViewById(id) != null){
            return view.findViewById(id).getVisibility();
        }
        return -1;
    }

    public static void preformClick(View view, int id){
        if(view != null && view.findViewById(id) != null){
            view.findViewById(id).performClick();
        }
    }

    public static boolean viewEnabled(View rootView, int resId) {
        if (rootView != null && rootView.findViewById(resId) != null) {
            return rootView.findViewById(resId).isEnabled();
        }
        return false;
    }

    public static String viewText(View rootView, int resId) {
        if (rootView != null && rootView.findViewById(resId) != null &&
                rootView.findViewById(resId) instanceof TextView) {
            return ((TextView) rootView.findViewById(resId)).getText().toString();
        }
        return "";
    }


}
