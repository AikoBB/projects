package com.iko.android.weather.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.iko.android.weather.data.model.ForeCast;
import com.iko.android.weather.ui.main.weekly.adapter.WeekForecastAdapter;

import java.util.ArrayList;

/**
 * Created by Aigerim on 4/6/2018.
 */

public final class BindingUtils {

    @BindingAdapter({"adapter"})
    public static void addWeekForecastItems(RecyclerView recyclerView, ArrayList<ForeCast> foreCasts){
        WeekForecastAdapter adapter = (WeekForecastAdapter) recyclerView.getAdapter();
        if(adapter != null){
            adapter.clearItems();
            adapter.addItems(foreCasts);
        }
    }
}
