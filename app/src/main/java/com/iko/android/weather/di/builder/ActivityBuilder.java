package com.iko.android.weather.di.builder;

import com.iko.android.weather.ui.main.MainActivity;
import com.iko.android.weather.ui.main.MainModule;
import com.iko.android.weather.ui.main.daily.DailyForecastProvider;
import com.iko.android.weather.ui.splash.SplashActivity;
import com.iko.android.weather.ui.splash.SplashModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Aigerim on 3/16/2018.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = {MainModule.class, DailyForecastProvider.class})
    abstract MainActivity bindMainActivity();

}
