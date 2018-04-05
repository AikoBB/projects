package com.iko.android.weather.ui.main.daily;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.ui.base.BaseViewModel;
import com.iko.android.weather.utils.rx.SchedulerProvider;

/**
 * Created by Aigerim on 4/4/2018.
 */

public class DailyForecastViewModel extends BaseViewModel<DailyForecastNavigator> {

    public DailyForecastViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

}
