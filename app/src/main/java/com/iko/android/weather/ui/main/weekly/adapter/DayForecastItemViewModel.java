package com.iko.android.weather.ui.main.weekly.adapter;

import android.databinding.ObservableField;

import com.iko.android.weather.R;
import com.iko.android.weather.data.model.ForeCast;

/**
 * Created by Aigerim on 4/6/2018.
 */

public class DayForecastItemViewModel {

    private ForeCast foreCast;
    public ObservableField<String> weekDay;
    public ObservableField<String> maxDegree;
    public ObservableField<String> minDegree;
    public ObservableField<Integer> iconId;

    public DayForecastItemViewModel(ForeCast foreCast) {
        this.foreCast = foreCast;
        weekDay = new ObservableField<>(foreCast.getDay());
        maxDegree = new ObservableField<>(foreCast.getHigh());
        minDegree = new ObservableField<>(foreCast.getLow());
        iconId = new ObservableField<>(R.drawable.weather_cloudy);
    }
}
