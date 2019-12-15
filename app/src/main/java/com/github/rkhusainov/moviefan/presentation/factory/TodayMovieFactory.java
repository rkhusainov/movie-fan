package com.github.rkhusainov.moviefan.presentation.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.data.mapper.MovieMapper;
import com.github.rkhusainov.moviefan.data.repository.MovieRepository;
import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.interactor.MovieInteractor;
import com.github.rkhusainov.moviefan.domain.repository.IMovieRepository;
import com.github.rkhusainov.moviefan.presentation.ui.today.viewmodel.TodayMovieViewModel;

/**
 * Фабрика для {@link TodayMovieViewModel}
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class TodayMovieFactory extends ViewModelProvider.NewInstanceFactory {

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IMovieRepository movieRepository = new MovieRepository(new MovieMapper());
        IMovieInteractor movieInteractor = new MovieInteractor(movieRepository);
        return (T) new TodayMovieViewModel(movieInteractor);
    }
}
