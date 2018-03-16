package com.iko.android.weather.data;

import com.iko.android.weather.data.local.db.DbHelper;
import com.iko.android.weather.data.local.prefs.PreferenceHelper;
import com.iko.android.weather.data.remote.ApiHelper;

/**
 * Created by Aigerim on 3/16/2018.
 */

public interface DataManager extends ApiHelper, DbHelper, PreferenceHelper {
}
