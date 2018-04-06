package com.iko.android.weather.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.iko.android.weather.BR;
import com.iko.android.weather.R;
import com.iko.android.weather.databinding.ActivityMainBinding;
import com.iko.android.weather.ui.base.BaseActivity;
import com.iko.android.weather.ui.main.daily.DailyForecastFragment;
import com.iko.android.weather.ui.main.weekly.WeeklyForecastFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Aigerim on 4/3/2018.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector{

    @Inject
    MainViewModel viewModel;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    private ActivityMainBinding ui;

    public static Intent getStartIntent(Context context){
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        ui = getDataBinding();
        setUpBottomNavigation();
        showFragment(DailyForecastFragment.newInstance(), DailyForecastFragment.TAG);
    }

    private void setUpBottomNavigation(){
        ui.bottomNavigation.setSelectedItemId(R.id.menu_today);
        ui.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_today:
                        showFragment(DailyForecastFragment.newInstance(), DailyForecastFragment.TAG);
                        return true;
                    case R.id.menu_weekly:
                        showFragment(WeeklyForecastFragment.newInstance(), WeeklyForecastFragment.TAG);
                        return true;
                    case R.id.menu_favs:
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void showFragment(Fragment fragment, String tag){
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.fl_main_container, fragment, tag)
                .commit();
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
