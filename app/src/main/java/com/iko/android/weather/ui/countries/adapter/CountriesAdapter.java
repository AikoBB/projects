package com.iko.android.weather.ui.countries.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iko.android.weather.R;
import com.iko.android.weather.data.model.Country;
import com.iko.android.weather.databinding.ItemCountryBinding;
import com.iko.android.weather.databinding.ItemEmptyListBinding;
import com.iko.android.weather.ui.base.BaseViewHolder;
import com.iko.android.weather.ui.base.EmptyViewHolder;

import java.util.List;

import static com.iko.android.weather.ui.base.BaseViewHolder.VIEW_TYPE_EMPTY;
import static com.iko.android.weather.ui.base.BaseViewHolder.VIEW_TYPE_NORMAL;

/**
 * Created by Aigerim on 4/10/2018.
 */

public class CountriesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Country> countryList;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public CountriesAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_NORMAL:
                ItemCountryBinding ui = ItemCountryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, true);
                return new CountryViewHolder(ui);
            case VIEW_TYPE_EMPTY:
            default:
                ItemEmptyListBinding emptyUi = ItemEmptyListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, true);
                return new EmptyCountryViewHolder(emptyUi);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(isListNotEmpty())return VIEW_TYPE_NORMAL;
        return VIEW_TYPE_EMPTY;
    }

    private boolean isListNotEmpty(){
        return countryList != null && countryList.size() > 0;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if(isListNotEmpty())return countryList.size();
        return VIEW_TYPE_NORMAL;
    }

    public void addItems(List<Country> countries){
        countryList.addAll(countries);
        notifyDataSetChanged();
    }

    public void clearItems(){
        countryList.clear();
    }

    private class CountryViewHolder extends BaseViewHolder{
        private CountryViewModel viewModel;
        private ItemCountryBinding ui;

        public CountryViewHolder(ItemCountryBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
        }

        @Override
        public void onBind(int position) {
            final Country country = countryList.get(position);
            viewModel = new CountryViewModel(country);
            ui.setViewModel(viewModel);
            ui.executePendingBindings();
        }
    }

    private class EmptyCountryViewHolder extends EmptyViewHolder{

        public EmptyCountryViewHolder(ItemEmptyListBinding ui) {
            super(ui);
        }

        @Override
        public String getEmptyListMessage() {
            return context.getString(R.string.warning_empty_list);
        }
    }
}
