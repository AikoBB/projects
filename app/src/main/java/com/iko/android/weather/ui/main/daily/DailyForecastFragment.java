package com.iko.android.weather.ui.main.daily;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.iko.android.weather.BR;
import com.iko.android.weather.R;
import com.iko.android.weather.databinding.FragmentDailyForecastBinding;
import com.iko.android.weather.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by Aigerim on 4/4/2018.
 */

public class DailyForecastFragment extends BaseFragment<FragmentDailyForecastBinding, DailyForecastViewModel>
                                    implements DailyForecastNavigator {

    public static final String TAG = "DailyForecastFragment";
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private DailyForecastViewModel viewModel;
    private FragmentDailyForecastBinding ui;

    public static DailyForecastFragment newInstance(){
        Bundle args = new Bundle();
        DailyForecastFragment fragment = new DailyForecastFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ui = getDataBinding();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_daily_forecast;
    }

    @Override
    public DailyForecastViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DailyForecastViewModel.class);
        return viewModel;
    }
}
