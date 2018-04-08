package com.iko.android.weather.ui.main.weekly;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.data.model.ForeCast;
import com.iko.android.weather.ui.base.BaseViewModel;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aigerim on 4/6/2018.
 */

public class WeeklyForecastViewModel extends BaseViewModel<WeeklyForecastNavigator> {

    private final ObservableArrayList<ForeCast> forecastList = new ObservableArrayList<>();
    private final MutableLiveData<List<ForeCast>> forecastLive;

    public WeeklyForecastViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        forecastLive = new MutableLiveData<>();
    }

    public void fetchForecastForWeek(){
        ForeCast monday = new ForeCast("Monday", "18\u00B0", "10\u00B0", "Partly Cloudy");
        ForeCast tuesday = new ForeCast("Tuesday", "28\u00B0", "15\u00B0", "Partly Cloudy");
        ForeCast wednesday = new ForeCast("Wednesday", "20\u00B0", "14\u00B0", "Partly Cloudy");
        ForeCast thursday = new ForeCast("Thursday", "22\u00B0", "18\u00B0", "Partly Cloudy");
        ForeCast friday = new ForeCast("Friday", "24\u00B0", "12\u00B0", "Partly Cloudy");
        ForeCast saturday = new ForeCast("Saturday", "26\u00B0", "16\u00B0", "Partly Cloudy");
        ForeCast sunday = new ForeCast("Sunday", "26\u00B0", "16\u00B0", "Partly Cloudy");
        List<ForeCast> foreCasts = new ArrayList<>();
        foreCasts.add(monday);
        foreCasts.add(tuesday);
        foreCasts.add(wednesday);
        foreCasts.add(thursday);
        foreCasts.add(friday);
        foreCasts.add(saturday);
        foreCasts.add(sunday);
        forecastLive.setValue(foreCasts);
    }

    public void addForecastsToList(List<ForeCast> foreCasts){
        forecastList.clear();
        forecastList.addAll(foreCasts);
    }
    public ObservableArrayList<ForeCast> getForecastList() {
        return forecastList;
    }

    public MutableLiveData<List<ForeCast>> getForecastLive() {
        return forecastLive;
    }
}
