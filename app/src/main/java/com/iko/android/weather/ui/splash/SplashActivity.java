package com.iko.android.weather.ui.splash;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.util.Log;

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
    private ActivitySplashBinding dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        dataBinding = getDataBinding();
    }

    @Override
    protected void onResume() {
        super.onResume();
        animatedDrawable();
    }

    private void animatedDrawable(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)dataBinding.ivSun.getDrawable();
            drawable.registerAnimationCallback(new Animatable2.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    openMainActivity();
                }
            });
            drawable.start();
        }else {
            AnimatedVectorDrawableCompat drawable = (AnimatedVectorDrawableCompat) dataBinding.ivSun.getDrawable();
            drawable.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    openMainActivity();
                }
            });
            drawable.start();
        }

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

    private void openMainActivity(){
        Log.i("TAG", "openMainActivity: ");
    }
}
