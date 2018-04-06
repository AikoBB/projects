package com.iko.android.weather.ui.main.weekly;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.iko.android.weather.BR;
import com.iko.android.weather.R;
import com.iko.android.weather.data.model.ForeCast;
import com.iko.android.weather.databinding.FragmentWeeklyForecastBinding;
import com.iko.android.weather.ui.base.BaseFragment;
import com.iko.android.weather.ui.main.weekly.adapter.WeekForecastAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Aigerim on 4/6/2018.
 */

public class WeeklyForecastFragment extends BaseFragment<FragmentWeeklyForecastBinding, WeeklyForecastViewModel>
                                    implements WeeklyForecastNavigator {
    public static final String TAG = "WeeklyForecastFragment";

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    LinearLayoutManager layoutManager;
    @Inject
    WeekForecastAdapter adapter;

    private WeeklyForecastViewModel viewModel;
    private FragmentWeeklyForecastBinding ui;

    public static WeeklyForecastFragment newInstance(){
        Bundle args = new Bundle();
        WeeklyForecastFragment fragment = new WeeklyForecastFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        viewModel.fetchForecastForWeek();
        Log.i(TAG, "onCreate: " + viewModel.getForecastLive().getValue().size());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ui = getDataBinding();
        setUpViews();
        subscribeToLiveData();
    }

    private void setUpViews(){
        RecyclerView rvWeekDays = ui.rvWeekDays;
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvWeekDays.setLayoutManager(layoutManager);
        rvWeekDays.setItemAnimator(new DefaultItemAnimator());
        rvWeekDays.setAdapter(adapter);
    }

    private void subscribeToLiveData(){
        viewModel.getForecastLive()
                .observe(this, new Observer<List<ForeCast>>() {
                    @Override
                    public void onChanged(@Nullable List<ForeCast> foreCasts) {
                        Log.i(TAG, "subscribeToLiveData: " + foreCasts.size());
                        viewModel.addForecastsToList(foreCasts);
                    }
                });
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_weekly_forecast;
    }

    @Override
    public WeeklyForecastViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WeeklyForecastViewModel.class);
        return viewModel;
    }
}
