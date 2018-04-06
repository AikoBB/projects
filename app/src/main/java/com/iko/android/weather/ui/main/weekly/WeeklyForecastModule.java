package com.iko.android.weather.ui.main.weekly;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.data.model.ForeCast;
import com.iko.android.weather.ui.main.weekly.adapter.WeekForecastAdapter;
import com.iko.android.weather.utils.ViewModelProviderFactory;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aigerim on 4/6/2018.
 */

@Module
public class WeeklyForecastModule {

    @Provides
    WeeklyForecastViewModel provideWeeklyForecastViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new WeeklyForecastViewModel(dataManager, schedulerProvider);
    }

    @Provides
    WeekForecastAdapter provideWeekForecastAdapter(){
        return new WeekForecastAdapter(new ArrayList<ForeCast>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(WeeklyForecastFragment forecastFragment){
        return new LinearLayoutManager(forecastFragment.getContext());
    }

    @Provides
    ViewModelProvider.Factory provideWeeklyForecastViewModelFactory(WeeklyForecastViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }
}
