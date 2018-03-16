package com.iko.android.weather.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Aigerim on 3/16/2018.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
