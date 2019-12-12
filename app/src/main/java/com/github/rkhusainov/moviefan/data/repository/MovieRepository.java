package com.github.rkhusainov.moviefan.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.data.model.credit.Credit;
import com.github.rkhusainov.moviefan.data.model.detail.Detail;
import com.github.rkhusainov.moviefan.data.model.movie.MovieResponse;
import com.github.rkhusainov.moviefan.domain.mapper.IMapper;
import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.domain.repository.IMovieRepository;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.utils.ApiUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;

import static android.content.ContentValues.TAG;

/**
 * Реализация репозитория с методами для получения данных
 */

public class MovieRepository implements IMovieRepository {

    private IMapper mMapper;

    /**
     * @param mapper используется для маппинга данных из pojo класса в entity
     */
    public MovieRepository(@NonNull IMapper mapper) {
        mMapper = mapper;
    }

    /**
     * Получение популярных фильмов
     *
     * @return возвращает Single список с фильмами
     */
    @NotNull
    @Override
    public Single<List<MovieEntity>> getPopularMovies() {
        return ApiUtils.getApi().getPopularMovies(Constants.LANGUAGE, Constants.REGION)
                .map(new Function<MovieResponse, List<MovieEntity>>() {
                    @Override
                    public List<MovieEntity> apply(MovieResponse movieResponse) throws Exception {
                        return (List<MovieEntity>) mMapper.convert(movieResponse.getResults());
                    }
                });
    }

    /**
     * Получение фильмов, которые сегодня показывают в кинотеатрах
     *
     * @return возвращает Single список с фильмами
     */
    @NotNull
    @Override
    public Single<List<MovieEntity>> getTodayMovies() {
        return ApiUtils.getApi().getTodayMovies(Constants.LANGUAGE, Constants.REGION)
                .map(new Function<MovieResponse, List<MovieEntity>>() {
                    @Override
                    public List<MovieEntity> apply(MovieResponse movieResponse) throws Exception {
                        return (List<MovieEntity>) mMapper.convert(movieResponse.getResults());
                    }
                });
    }

    /**
     * Получение топ фильмов
     *
     * @return возвращает Single список с фильмами
     */
    @NotNull
    @Override
    public Single<List<MovieEntity>> getTopMovies() {
        return ApiUtils.getApi().getTopMovies(Constants.LANGUAGE, Constants.REGION)
                .map(new Function<MovieResponse, List<MovieEntity>>() {
                    @Override
                    public List<MovieEntity> apply(MovieResponse movieResponse) throws Exception {
                        return (List<MovieEntity>) mMapper.convert(movieResponse.getResults());
                    }
                });
    }

    /**
     * Получение фильмов, которые в скором будущем покажут в кинотеатрах
     *
     * @return возвращает Single список с фильмами
     */
    @NotNull
    @Override
    public Single<List<MovieEntity>> getUpcomingMovies() {
        return ApiUtils.getApi().getUpcomingMovies(Constants.LANGUAGE, Constants.REGION)
                .map(new Function<MovieResponse, List<MovieEntity>>() {
                    @Override
                    public List<MovieEntity> apply(MovieResponse movieResponse) throws Exception {
                        return (List<MovieEntity>) mMapper.convert(movieResponse.getResults());
                    }
                });
    }

    /**
     * Получение детальной информации о фильме
     *
     * @param movie_id ид фильма
     * @return возвращает Single данные с детальной информацией о фильме
     */
    @NotNull
    @Override
    public Single<DetailEntity> getDetail(int movie_id) {
        return ApiUtils.getApi().getDetail(movie_id, Constants.LANGUAGE, Constants.REGION)
                .map(new Function<Detail, DetailEntity>() {
                    @Override
                    public DetailEntity apply(Detail detail) throws Exception {
                        return (DetailEntity) mMapper.convert(detail);
                    }
                });
    }

    /**
     * Получение актёров, снявшихся в фильме
     *
     * @param movie_id ид фильма
     * @return возвращает Single данные с детальной информацией о фильме
     */
    @NotNull
    @Override
    public Single<List<CastEntity>> getCasts(int movie_id) {
        return ApiUtils.getApi().getCredits(movie_id)
                .map(new Function<Credit, List<CastEntity>>() {
                    @Override
                    public List<CastEntity> apply(Credit credit) throws Exception {
                        Log.d(TAG, "apply: " + credit.getCast().size());
                        return (List<CastEntity>) mMapper.convert(credit.getCast());
                    }
                });
    }
}
