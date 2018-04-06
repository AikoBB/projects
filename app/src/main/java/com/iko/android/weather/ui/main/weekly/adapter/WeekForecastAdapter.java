package com.iko.android.weather.ui.main.weekly.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.iko.android.weather.data.model.ForeCast;
import com.iko.android.weather.databinding.ItemDayForecastBinding;
import com.iko.android.weather.databinding.ItemEmptyListBinding;
import com.iko.android.weather.ui.base.BaseViewHolder;

import java.util.List;

import static com.iko.android.weather.ui.base.BaseViewHolder.VIEW_TYPE_EMPTY;
import static com.iko.android.weather.ui.base.BaseViewHolder.VIEW_TYPE_NORMAL;

/**
 * Created by Aigerim on 4/6/2018.
 */

public class WeekForecastAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ForeCast> foreCastList;

    public WeekForecastAdapter(List<ForeCast> foreCasts){
        foreCastList = foreCasts;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_NORMAL:
                ItemDayForecastBinding ui = ItemDayForecastBinding.inflate(LayoutInflater.from(parent.getContext()), parent, true);
                return new ForecastViewHolder(ui);
            case VIEW_TYPE_EMPTY:
            default:
                ItemEmptyListBinding emptyUi = ItemEmptyListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, true);
                return new EmptyViewHolder(emptyUi);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        if(foreCastList != null && foreCastList.size() > 0){
            return VIEW_TYPE_NORMAL;
        }
        return VIEW_TYPE_EMPTY;
    }

    @Override
    public int getItemCount() {
        if(foreCastList != null && foreCastList.size() > 0){
            return foreCastList.size();
        }
        return VIEW_TYPE_NORMAL;
    }

    public void addItems(List<ForeCast> foreCasts){
        this.foreCastList.addAll(foreCasts);
        notifyDataSetChanged();
    }

    public void clearItems(){
        foreCastList.clear();
    }

    public class ForecastViewHolder extends BaseViewHolder{
        private ItemDayForecastBinding ui;
        private DayForecastItemViewModel viewModel;

        public ForecastViewHolder(ItemDayForecastBinding ui){
            super(ui.getRoot());
            this.ui = ui;
        }

        @Override
        public void onBind(int position) {
            final ForeCast foreCast = foreCastList.get(position);
            viewModel = new DayForecastItemViewModel(foreCast);
            ui.setViewModel(viewModel);
            ui.executePendingBindings();
        }
    }

    public class EmptyViewHolder extends BaseViewHolder{
        private ItemEmptyListBinding ui;

        public EmptyViewHolder(ItemEmptyListBinding ui){
            super(ui.getRoot());
            this.ui = ui;
        }

        @Override
        public void onBind(int position) {

        }
    }
}
