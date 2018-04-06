package com.iko.android.weather.ui.main.weekly;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Aigerim on 4/6/2018.
 */

@Module
public abstract class WeeklyForecastProvider {

    @ContributesAndroidInjector(modules = WeeklyForecastModule.class)
    abstract WeeklyForecastFragment provideWeeklyForecastFragment();

}
