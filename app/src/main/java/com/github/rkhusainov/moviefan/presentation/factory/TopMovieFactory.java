package com.github.rkhusainov.moviefan.presentation.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.data.mapper.MovieMapper;
import com.github.rkhusainov.moviefan.data.repository.MovieRepository;
import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.interactor.MovieInteractor;
import com.github.rkhusainov.moviefan.domain.repository.IMovieRepository;
import com.github.rkhusainov.moviefan.presentation.ui.top.TopMovieViewModel;

/**
 * Фабрика для TopMovieViewModel
 */
public class TopMovieFactory extends ViewModelProvider.NewInstanceFactory {

    private int mViewType;

    /**
     * @param viewType тип viewHolder'а
     */
    public TopMovieFactory(int viewType) {
        mViewType = viewType;
    }

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IMovieRepository movieRepository = new MovieRepository(new MovieMapper());
        IMovieInteractor movieInteractor = new MovieInteractor(movieRepository);
        return (T) new TopMovieViewModel(
                mViewType,
                movieInteractor);
    }
}
