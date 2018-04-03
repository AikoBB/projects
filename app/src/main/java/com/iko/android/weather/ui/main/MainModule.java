package com.iko.android.weather.ui.main;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aigerim on 4/3/2018.
 */

@Module
public class MainModule {

    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new MainViewModel(dataManager, schedulerProvider);
    }

}
