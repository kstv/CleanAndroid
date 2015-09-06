package com.promeg.github.doubanmovie.common.utils;

import android.content.Context;

/**
 * Created by guyacong on 2015/4/17.
 */
public class Utility {

    protected static Context mContext = null;

    public static void setContext(Context context) {
        mContext = context;
    }

    private Utility() {
        //no instance
    }

    public static Context getAppContext() {
        return mContext;
    }

    public static boolean isUnderRoboletricTest() {
        boolean isUnderUnitTest;
        try {
            Class<?> robolectric = Class.forName("org.robolectric.Robolectric");
            isUnderUnitTest = (robolectric != null);
        } catch (ClassNotFoundException e) {
            isUnderUnitTest = false;
        }
        return isUnderUnitTest;
    }

}
