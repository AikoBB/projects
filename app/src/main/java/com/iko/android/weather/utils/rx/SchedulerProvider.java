package com.iko.android.weather.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Aigerim on 3/9/2018.
 */

public interface SchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();

}
