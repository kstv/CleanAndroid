package com.promeg.github.doubanmovie.common.base;

import com.promeg.github.doubanmovie.common.di.ApplicationComponent;

import android.app.Service;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;

/**
 * Created by guyacong on 2015/4/19.
 */
public abstract class BaseService extends Service {
    @Inject
    protected EventBus mBus;

    @Override
    public void onCreate() {
        super.onCreate();
        this.getApplicationComponent().inject(this);
        if(!mBus.isRegistered(this)) {
            try {
                mBus.register(this);
            } catch (EventBusException e) {
                // ignore
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mBus.isRegistered(this)) {
            mBus.unregister(this);
        }
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((IApplication)getApplication()).component();
    }

}
