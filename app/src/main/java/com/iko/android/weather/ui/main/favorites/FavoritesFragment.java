package com.iko.android.weather.ui.main.favorites;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iko.android.weather.BR;
import com.iko.android.weather.R;
import com.iko.android.weather.data.model.ForeCast;
import com.iko.android.weather.databinding.FragmentFavoritesBinding;
import com.iko.android.weather.ui.base.BaseFragment;
import com.iko.android.weather.ui.main.favorites.adapter.FavoriteCountriesAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Aigerim on 4/8/2018.
 */

public class FavoritesFragment extends BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>
                                implements FavoritesNavigator {

    public static final String TAG = "FavoritesFragment";

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    FavoriteCountriesAdapter adapter;
    @Inject
    LinearLayoutManager layoutManager;

    private FavoritesViewModel viewModel;
    private FragmentFavoritesBinding ui;

    public static FavoritesFragment newInstance(){
        Bundle args = new Bundle();
        FavoritesFragment fragment = new FavoritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ui = getDataBinding();
        setUpViews();
        subscribeToLiveData();
        viewModel.fetchForecastForWeek();
    }

    private void setUpViews(){
        adapter.setContext(getContext());
        RecyclerView rvFavorites = ui.rvFavorites;
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavorites.setLayoutManager(layoutManager);
        rvFavorites.setItemAnimator(new DefaultItemAnimator());
        rvFavorites.setAdapter(adapter);
    }

    private void subscribeToLiveData(){
        viewModel.getForecastLive()
                .observe(this, new Observer<List<ForeCast>>() {
                    @Override
                    public void onChanged(@Nullable List<ForeCast> foreCasts) {
                        viewModel.addForecastsToList(foreCasts);
                    }
                });
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_favorites;
    }

    @Override
    public FavoritesViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FavoritesViewModel.class);
        return viewModel;
    }
}
