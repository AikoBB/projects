package com.iko.android.weather.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.iko.android.weather.BR;
import com.iko.android.weather.R;
import com.iko.android.weather.databinding.ActivitySplashBinding;
import com.iko.android.weather.ui.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by Aigerim on 3/16/2018.
 */

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return viewModel;
    }
}
