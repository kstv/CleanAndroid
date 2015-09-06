package com.github.promeg.doubanmovie.ui.main;

import com.github.promeg.doubanmovie.R;
import com.github.promeg.doubanmovie.ui.main.di.DaggerMainComponent;
import com.github.promeg.doubanmovie.ui.main.di.MainComponent;
import com.promeg.github.doubanmovie.common.base.BaseActivity;
import com.promeg.github.doubanmovie.common.di.HasComponent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {
    MainComponent mMainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initializeInjector() {
        mMainComponent = DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        mMainComponent.inject(this);
    }
    @Override
    public MainComponent getComponent() {
        return mMainComponent;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
