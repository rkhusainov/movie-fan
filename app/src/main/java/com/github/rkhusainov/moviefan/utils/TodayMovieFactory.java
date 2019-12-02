package com.github.rkhusainov.moviefan.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.ui.today.TodayViewModel;

public class TodayMovieFactory extends ViewModelProvider.NewInstanceFactory {
    private OnItemClickListener mOnItemClickListener;

    public TodayMovieFactory(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TodayViewModel(mOnItemClickListener);
    }
}
