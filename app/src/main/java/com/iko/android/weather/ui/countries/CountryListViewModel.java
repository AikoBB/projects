package com.iko.android.weather.ui.countries;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.data.model.Country;
import com.iko.android.weather.ui.base.BaseViewModel;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aigerim on 4/10/2018.
 */

public class CountryListViewModel extends BaseViewModel<CountryListNavigator> {

    private ObservableArrayList<Country> countryList = new ObservableArrayList<>();
    private final MutableLiveData<List<Country>> countriesLive;

    public CountryListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        countriesLive = new MutableLiveData<>();
    }

    public void fetchCountries(){
        Country bish = new Country();
        bish.setName("Bishkek");
        Country moscow = new Country();
        bish.setName("Moscow");
        Country london = new Country();
        bish.setName("London");
        List<Country> countries = new ArrayList<>();
        countries.add(bish);
        countries.add(moscow);
        countries.add(london);
        countriesLive.setValue(countries);
    }

    public ObservableArrayList<Country> getCountryList() {
        return countryList;
    }

    public void addCountryList(List<Country> countries) {
        countryList.clear();
        countryList.addAll(countries);
    }

    public MutableLiveData<List<Country>> getCountriesLive() {
        return countriesLive;
    }
}
