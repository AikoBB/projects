package com.iko.android.weather.data;

import android.content.Context;

import com.iko.android.weather.data.local.db.DbHelper;
import com.iko.android.weather.data.local.prefs.PreferenceHelper;
import com.iko.android.weather.data.remote.ApiHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Aigerim on 3/16/2018.
 */

@Singleton
public class AppDataManager implements DataManager {
    private  final Context context;
    private  final ApiHelper apiHelper;
    private final DbHelper dbHelper;
    private final PreferenceHelper preferenceHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferenceHelper preferenceHelper, ApiHelper apiHelper){
        this.context = context;
        this.apiHelper = apiHelper;
        this.dbHelper = dbHelper;
        this.preferenceHelper = preferenceHelper;
    }
}
