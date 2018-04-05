package com.iko.android.weather.ui.main.daily;

import android.arch.lifecycle.ViewModelProvider;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.utils.ViewModelProviderFactory;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aigerim on 4/4/2018.
 */

@Module
public class DailyForecastModule {

    @Provides
    DailyForecastViewModel provideDailyForecastViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new DailyForecastViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory provideDailyForecastViewModelFactory(DailyForecastViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }
}
