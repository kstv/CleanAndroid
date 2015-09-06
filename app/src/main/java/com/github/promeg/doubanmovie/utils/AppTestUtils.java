package com.github.promeg.doubanmovie.utils;

import com.promeg.github.doubanmovie.common.utils.Utility;
import com.promeg.github.doubanmovie.common.utils.test.RetrofitRxAndroidSchedulersHook;
import com.promeg.github.doubanmovie.common.utils.test.RetrofitRxJavaSchedulersHook;

import rx.android.plugins.RxAndroidPlugins;
import rx.plugins.RxJavaPlugins;

/**
 * Created by guyacong on 2015/9/4.
 */
public class AppTestUtils {
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

}
