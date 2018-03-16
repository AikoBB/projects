package com.iko.android.weather.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iko.android.weather.data.AppDataManager;
import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.data.local.db.AppDbHelper;
import com.iko.android.weather.data.local.db.DbHelper;
import com.iko.android.weather.data.local.prefs.AppPreferenceHelper;
import com.iko.android.weather.data.local.prefs.PreferenceHelper;
import com.iko.android.weather.data.remote.ApiHelper;
import com.iko.android.weather.data.remote.AppApiHelper;
import com.iko.android.weather.utils.rx.AppSchedulerProvider;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aigerim on 3/16/2018.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideCondext(Application application){
        return application;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(){
        return new AppApiHelper();
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(){
        return new AppDbHelper();
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(){
        return new AppPreferenceHelper();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
