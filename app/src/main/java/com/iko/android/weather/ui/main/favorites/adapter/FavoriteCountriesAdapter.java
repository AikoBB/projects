package com.iko.android.weather.ui.main.favorites.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.iko.android.weather.R;
import com.iko.android.weather.data.model.ForeCast;
import com.iko.android.weather.databinding.ItemEmptyListBinding;
import com.iko.android.weather.databinding.ItemFavoriteCountryBinding;
import com.iko.android.weather.ui.base.BaseViewHolder;
import com.iko.android.weather.ui.base.EmptyViewHolder;

import java.util.List;

import static com.iko.android.weather.ui.base.BaseViewHolder.VIEW_TYPE_EMPTY;
import static com.iko.android.weather.ui.base.BaseViewHolder.VIEW_TYPE_NORMAL;

/**
 * Created by Aigerim on 4/8/2018.
 */

public class FavoriteCountriesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ForeCast> foreCastList;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public FavoriteCountriesAdapter(List<ForeCast> foreCastList) {
        this.foreCastList = foreCastList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_NORMAL:
                ItemFavoriteCountryBinding ui = ItemFavoriteCountryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, true);
                return new FavoriteCountryViewHolder(ui);
            case VIEW_TYPE_EMPTY:
            default:
                ItemEmptyListBinding emptyUi = ItemEmptyListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, true);
                return new EmptyFavoriteCountryViewHolder(emptyUi);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(isListNotEmpty())return VIEW_TYPE_NORMAL;
        return VIEW_TYPE_EMPTY;
    }

    private boolean isListNotEmpty(){
        return foreCastList != null && foreCastList.size() > 0;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if(isListNotEmpty())return foreCastList.size();
        return VIEW_TYPE_NORMAL;
    }

    public void addItems(List<ForeCast> foreCasts){
        this.foreCastList.addAll(foreCasts);
        notifyDataSetChanged();
    }

    public void clearItems(){
        foreCastList.clear();
    }

    private class FavoriteCountryViewHolder extends BaseViewHolder{

        private FavoriteCountryViewModel viewModel;
        private ItemFavoriteCountryBinding ui;

        public FavoriteCountryViewHolder(ItemFavoriteCountryBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
        }

        @Override
        public void onBind(int position) {
            final ForeCast foreCast = foreCastList.get(position);
            viewModel = new FavoriteCountryViewModel(foreCast);
            ui.setViewModel(viewModel);
            ui.executePendingBindings();
        }
    }

    private class EmptyFavoriteCountryViewHolder extends EmptyViewHolder{

        public EmptyFavoriteCountryViewHolder(ItemEmptyListBinding ui) {
            super(ui);
        }

        @Override
        public String getEmptyListMessage() {
            return context.getString(R.string.warning_empty_list);
        }
    }
}
