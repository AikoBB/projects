package com.iko.android.weather.ui.main.favorites;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Aigerim on 4/8/2018.
 */

@Module
public abstract class FavoritesProvider {

    @ContributesAndroidInjector(modules = FavoritesModule.class)
    abstract FavoritesFragment provideFavoritesFragment();
}
