package com.iko.android.weather.di.component;

import android.app.Application;

import com.iko.android.weather.WeatherApp;
import com.iko.android.weather.di.builder.ActivityBuilder;
import com.iko.android.weather.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Aigerim on 3/16/2018.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, ActivityBuilder.class, AppModule.class})
public interface AppComponent {

    void inject(WeatherApp app);

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
