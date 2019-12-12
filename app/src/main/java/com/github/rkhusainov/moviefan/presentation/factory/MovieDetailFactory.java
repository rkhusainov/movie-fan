package com.github.rkhusainov.moviefan.presentation.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.data.mapper.DetailMapper;
import com.github.rkhusainov.moviefan.data.repository.MovieRepository;
import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.interactor.MovieInteractor;
import com.github.rkhusainov.moviefan.domain.repository.IMovieRepository;
import com.github.rkhusainov.moviefan.presentation.ui.detail.MovieDetailViewModel;

/**
 * Фабрика для MovieDetailViewModel
 */
public class MovieDetailFactory extends ViewModelProvider.NewInstanceFactory {

    private int mMovieId;

    /**
     * @param movieId ид фильма
     */
    public MovieDetailFactory(int movieId) {
        mMovieId = movieId;
    }

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IMovieRepository repository = new MovieRepository(new DetailMapper());
        IMovieInteractor interactor = new MovieInteractor(repository);
        return (T) new MovieDetailViewModel(
                mMovieId,
                interactor);
    }
}
