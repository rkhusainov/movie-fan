package com.github.rkhusainov.moviefan.data.mapper;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.domain.mapper.IMapper;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация маппинга из pojo класса в entity
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class MovieMapper implements IMapper<List<Movie>, List<MovieEntity>> {

    @NonNull
    @Override
    public List<MovieEntity> convert(@NonNull List<Movie> movies) {
        List<MovieEntity> entityList = new ArrayList<>();
        for (Movie movie : movies) {
            entityList.add(new MovieEntity(
                    movie.getId(),
                    movie.getTitle(),
                    movie.getOriginalTitle(),
                    movie.getPopularity(),
                    movie.getPosterPath(),
                    movie.getVoteAverage(),
                    movie.getVoteCount(),
                    movie.getOverview(),
                    movie.getReleaseDate(),
                    movie.getVideo(),
                    movie.getAdult(),
                    movie.getBackdropPath(),
                    movie.getOriginalLanguage(),
                    movie.getGenreIds()
            ));
        }
        return entityList;
    }
}
