package com.iko.android.weather.ui.main.favorites;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.iko.android.weather.data.DataManager;
import com.iko.android.weather.ui.main.favorites.adapter.FavoriteCountriesAdapter;
import com.iko.android.weather.utils.ViewModelProviderFactory;
import com.iko.android.weather.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aigerim on 4/8/2018.
 */

@Module
public class FavoritesModule {

    @Provides
    FavoritesViewModel provideFavoritesViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new FavoritesViewModel(dataManager, schedulerProvider);
    }

    @Provides
    FavoriteCountriesAdapter provideFavoriteCountriesAdapter(){
        return new FavoriteCountriesAdapter(new ArrayList());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(FavoritesFragment fragment){
        return new LinearLayoutManager(fragment.getContext());
    }

    @Provides
    ViewModelProvider.Factory provideFavoritesViewModelFactory(FavoritesViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }
}
