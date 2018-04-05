package com.iko.android.weather.ui.main.daily;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Aigerim on 4/4/2018.
 */

@Module
public abstract class DailyForecastProvider {

    @ContributesAndroidInjector(modules = DailyForecastModule.class)
    abstract DailyForecastFragment provideDailyForecastFragment();
}
