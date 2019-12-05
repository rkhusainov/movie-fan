package com.github.rkhusainov.moviefan.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.ui.top.TopViewModel;
import com.github.rkhusainov.moviefan.ui.upcoming.UpcomingViewModel;

public class UpcomingMovieFactory extends ViewModelProvider.NewInstanceFactory {

    private OnItemClickListener mOnItemClickListener;
    private int mViewType;

    public UpcomingMovieFactory(OnItemClickListener onItemClickListener, int viewType) {
        mOnItemClickListener = onItemClickListener;
        mViewType = viewType;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

            return (T) new UpcomingViewModel(mOnItemClickListener, mViewType);
    }
}
