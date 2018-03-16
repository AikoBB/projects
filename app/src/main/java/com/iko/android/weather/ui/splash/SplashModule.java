package com.iko.android.weather.ui.splash;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aigerim on 3/16/2018.
 */

@Module
public class SplashModule {

    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new SplashViewModel(dataManager, schedulerProvider);
    }
}
