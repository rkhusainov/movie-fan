package com.github.rkhusainov.moviefan.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.ui.credit.CastViewModel;
import com.github.rkhusainov.moviefan.ui.top.TopViewModel;

public class CastFactory extends ViewModelProvider.NewInstanceFactory {

    private int mViewType;
    private int mMovieId;

    public CastFactory(int viewType, int movieId) {
        mViewType = viewType;
        mMovieId = movieId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new CastViewModel(mViewType, mMovieId);
    }
}
