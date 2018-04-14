package com.iko.android.weather.ui.countries;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iko.android.weather.BR;
import com.iko.android.weather.R;
import com.iko.android.weather.data.model.Country;
import com.iko.android.weather.databinding.ActivityCountryListBinding;
import com.iko.android.weather.ui.base.BaseActivity;
import com.iko.android.weather.ui.countries.adapter.CountriesAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Aigerim on 4/10/2018.
 */

public class CountryListActivity extends BaseActivity<ActivityCountryListBinding, CountryListViewModel>
                                    implements CountryListNavigator{
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    LinearLayoutManager layoutManager;
    @Inject
    CountriesAdapter adapter;

    private CountryListViewModel viewModel;
    private ActivityCountryListBinding ui;

    public static Intent getStartIntent(Context context){
        return new Intent(context, CountryListActivity.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        viewModel.setNavigator(this);
        ui = getDataBinding();
        setUpViews();
        subscribeToLiveData();
        viewModel.fetchCountries();
    }

    private void setUpViews(){
        RecyclerView rvCountries = ui.rvCountries;
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCountries.setLayoutManager(layoutManager);
        rvCountries.setItemAnimator(new DefaultItemAnimator());
        rvCountries.setAdapter(adapter);
    }

    private void  subscribeToLiveData(){
        viewModel.getCountriesLive()
                .observe(this, new Observer<List<Country>>() {
                    @Override
                    public void onChanged(@Nullable List<Country> countries) {
                        viewModel.addCountryList(countries);
                    }
                });
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_country_list;
    }

    @Override
    public CountryListViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CountryListViewModel.class);
        return viewModel;
    }
}
