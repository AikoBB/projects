package com.iko.android.weather.ui.countries.adapter;

import android.databinding.ObservableField;

import com.iko.android.weather.data.model.Country;

/**
 * Created by Aigerim on 4/10/2018.
 */

public class CountryViewModel {
    private Country country;
    public ObservableField<String> name;

    public CountryViewModel(Country country) {
        this.country = country;
        name = new ObservableField<>(country.getName());
    }
}
