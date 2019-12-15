package com.github.rkhusainov.moviefan.presentation.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.data.mapper.CastMapper;
import com.github.rkhusainov.moviefan.data.repository.MovieRepository;
import com.github.rkhusainov.moviefan.domain.interactor.IMovieInteractor;
import com.github.rkhusainov.moviefan.domain.interactor.MovieInteractor;
import com.github.rkhusainov.moviefan.domain.repository.IMovieRepository;
import com.github.rkhusainov.moviefan.presentation.ui.credit.viewmodel.CastViewModel;

/**
 * Фабрика для {@link CastViewModel}
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class CastFactory extends ViewModelProvider.NewInstanceFactory {

    private int mViewType;
    private int mMovieId;

    /**
     * @param viewType тип viewHolder'а
     * @param movieId  ид фильма
     */
    public CastFactory(int viewType,
                       int movieId) {
        mViewType = viewType;
        mMovieId = movieId;
    }

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IMovieRepository movieRepository = new MovieRepository(new CastMapper());
        IMovieInteractor movieInteractor = new MovieInteractor(movieRepository);
        return (T) new CastViewModel(
                mViewType,
                mMovieId,
                movieInteractor);
    }
}
