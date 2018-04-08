package com.iko.android.weather.ui.main.favorites;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.data.model.ForeCast;
import com.iko.android.weather.ui.base.BaseViewModel;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aigerim on 4/8/2018.
 */

public class FavoritesViewModel extends BaseViewModel<FavoritesNavigator> {

    private final ObservableArrayList<ForeCast> forecastList = new ObservableArrayList<>();
    private final MutableLiveData<List<ForeCast>> forecastLive;

    public FavoritesViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        forecastLive = new MutableLiveData<>();
    }

    public void fetchForecastForWeek(){
        ForeCast rome = new ForeCast("Rome, Italy", "18\u00B0", "10\u00B0", "Sunny");
        ForeCast paris = new ForeCast("Paris, France", "28\u00B0", "15\u00B0", "Partly Cloudy");
        ForeCast barcelona = new ForeCast("Barcelona, Spain", "20\u00B0", "14\u00B0", "Rain");
        List<ForeCast> foreCasts = new ArrayList<>();
        foreCasts.add(rome);
        foreCasts.add(paris);
        foreCasts.add(barcelona);
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
