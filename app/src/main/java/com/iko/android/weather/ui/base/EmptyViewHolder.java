package com.iko.android.weather.ui.base;

import com.iko.android.weather.databinding.ItemEmptyListBinding;

/**
 * Created by Aigerim on 4/8/2018.
 */

public abstract class EmptyViewHolder extends BaseViewHolder{
    private ItemEmptyListBinding ui;

    public EmptyViewHolder(ItemEmptyListBinding ui){
        super(ui.getRoot());
        this.ui = ui;
    }

    @Override
    public void onBind(int position) {
        ui.tvEmpty.setText(getEmptyListMessage());
    }

    public abstract String getEmptyListMessage();
}
