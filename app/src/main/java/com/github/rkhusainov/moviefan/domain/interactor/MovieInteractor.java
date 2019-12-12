package com.github.rkhusainov.moviefan.domain.interactor;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.domain.repository.IMovieRepository;

import java.util.List;

import io.reactivex.Single;

/**
 * Реализация интерактора, отвечающего за получением данных из репозитория
 */
public class MovieInteractor implements IMovieInteractor {

    @NonNull
    private final IMovieRepository mRepository;

    public MovieInteractor(@NonNull IMovieRepository repository) {
        mRepository = repository;
    }

    /**
     * Получение популярных фильмов
     *
     * @return возвращает Single список с фильмами
     */
    @NonNull
    @Override
    public Single<List<MovieEntity>> getPopularMovies() {
        return mRepository.getPopularMovies();
    }

    /**
     * Получение фильмов, которые сегодня показывают в кинотеатрах
     *
     * @return возвращает Single список с фильмами
     */
    @NonNull
    @Override
    public Single<List<MovieEntity>> getTodayMovies() {
        return mRepository.getTodayMovies();
    }

    /**
     * Получение топ фильмов
     *
     * @return возвращает Single список с фильмами
     */
    @NonNull
    @Override
    public Single<List<MovieEntity>> getTopMovies() {
        return mRepository.getTopMovies();
    }

    /**
     * Получение фильмов, которые в скором будущем покажут в кинотеатрах
     *
     * @return возвращает Single список с фильмами
     */
    @NonNull
    @Override
    public Single<List<MovieEntity>> getUpcomingMovies() {
        return mRepository.getUpcomingMovies();
    }

    /**
     * Получение детальной информации о фильме
     *
     * @param movie_id ид фильма
     * @return возвращает Single данные с детальной информацией о фильме
     */
    @NonNull
    @Override
    public Single<DetailEntity> getDetail(int movie_id) {
        return mRepository.getDetail(movie_id);
    }

    /**
     * Получение актёров, снявшихся в фильме
     *
     * @param movie_id ид фильма
     * @return возвращает Single данные с детальной информацией о фильме
     */
    @NonNull
    @Override
    public Single<List<CastEntity>> getCasts(int movie_id) {
        return mRepository.getCasts(movie_id);
    }
}
