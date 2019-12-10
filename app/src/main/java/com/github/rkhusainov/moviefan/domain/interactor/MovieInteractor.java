package com.github.rkhusainov.moviefan.domain.interactor;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.domain.repository.IMovieRepository;

import java.util.List;

import io.reactivex.Single;

public class MovieInteractor implements IMovieInteractor {

    private final IMovieRepository mRepository;

    public MovieInteractor(IMovieRepository repository) {
        mRepository = repository;
    }

    @Override
    public Single<List<MovieEntity>> getPopularMovies() {
        return mRepository.getPopularMovies();
    }

    @Override
    public Single<List<MovieEntity>> getTodayMovies() {
        return mRepository.getTodayMovies();
    }

    @Override
    public Single<List<MovieEntity>> getTopMovies() {
        return mRepository.getTopMovies();
    }

    @Override
    public Single<List<MovieEntity>> getUpcomingMovies() {
        return mRepository.getUpcomingMovies();
    }

    @Override
    public Single<DetailEntity> getDetail(int movie_id) {
        return mRepository.getDetail(movie_id);
    }

    @Override
    public Single<List<CastEntity>> getCasts(int movie_id) {
        return mRepository.getCasts(movie_id);
    }
}
