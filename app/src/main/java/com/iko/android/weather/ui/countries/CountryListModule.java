package com.iko.android.weather.ui.countries;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.ui.countries.adapter.CountriesAdapter;
import com.iko.android.weather.utils.ViewModelProviderFactory;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aigerim on 4/10/2018.
 */

@Module
public class CountryListModule {

    @Provides
    CountryListViewModel provideCountryListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new CountryListViewModel(dataManager, schedulerProvider);
    }

    @Provides
    CountriesAdapter provideCountriesAdapter(){
        return new CountriesAdapter(new ArrayList<>());
    }
    @Provides
    LinearLayoutManager provideLinearLayoutManager(CountryListActivity activity){
        return new LinearLayoutManager(activity);
    }

    @Provides
    ViewModelProvider.Factory provideCountryListViewModelFactory(CountryListViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }
}
