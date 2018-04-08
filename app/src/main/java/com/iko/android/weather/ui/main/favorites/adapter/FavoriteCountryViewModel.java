package com.iko.android.weather.ui.main.favorites.adapter;

import android.databinding.ObservableField;

import com.iko.android.weather.data.model.ForeCast;

/**
 * Created by Aigerim on 4/8/2018.
 */

public class FavoriteCountryViewModel {

    private ForeCast foreCast;
    public ObservableField<String> country;
    public ObservableField<String> temperature;
    public ObservableField<String> weatherState;

    public FavoriteCountryViewModel(ForeCast foreCast){
        this.foreCast = foreCast;
        country = new ObservableField<>(foreCast.getDay());
        temperature = new ObservableField<>(foreCast.getHigh());
        weatherState = new ObservableField<>(foreCast.getText());
    }
}
