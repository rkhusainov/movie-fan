package com.github.rkhusainov.moviefan.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.ui.detail.DetailViewModel;

public class DetailFactory extends ViewModelProvider.NewInstanceFactory {

    private int mMovieId;
    private Application mApplication;

    public DetailFactory(int movieId, Application application) {
        mMovieId = movieId;
        mApplication = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

            return (T) new DetailViewModel(mMovieId,mApplication);
    }
}
