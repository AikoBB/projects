package com.iko.android.weather.ui.main;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.ui.base.BaseViewModel;
import com.iko.android.weather.utils.rx.SchedulerProvider;

/**
 * Created by Aigerim on 4/3/2018.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

}
