package com.github.rkhusainov.moviefan.presentation.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.data.mapper.MovieMapper;
import com.github.rkhusainov.moviefan.data.repository.MovieRepository;
import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.interactor.MovieInteractor;
import com.github.rkhusainov.moviefan.domain.repository.IMovieRepository;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.presentation.ui.today.TodayViewModel;

public class TodayMovieFactory extends ViewModelProvider.NewInstanceFactory {
    private OnItemClickListener mOnItemClickListener;

    public TodayMovieFactory(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IMovieRepository movieRepository = new MovieRepository(new MovieMapper());
        IMovieInteractor movieInteractor = new MovieInteractor(movieRepository);
        return (T) new TodayViewModel(mOnItemClickListener,
                movieInteractor);
    }
}
