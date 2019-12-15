package com.github.rkhusainov.moviefan.data.mapper;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.data.model.detail.Detail;
import com.github.rkhusainov.moviefan.domain.mapper.IMapper;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;

/**
 * Реализация маппинга из pojo класса в entity
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class DetailMapper implements IMapper<Detail, DetailEntity> {
    @NonNull
    @Override
    public DetailEntity convert(@NonNull Detail detail) {
        return new DetailEntity(
                detail.getId(),
                detail.getAdult(),
                detail.getBackdropPath(),
                detail.getBelongsToCollection(),
                detail.getBudget(),
                detail.getGenres(),
                detail.getHomepage(),
                detail.getImdbId(),
                detail.getOriginalLanguage(),
                detail.getOriginalTitle(),
                detail.getOverview(),
                detail.getPopularity(),
                detail.getPosterPath(),
                detail.getReleaseDate(),
                detail.getRevenue(),
                detail.getRuntime(),
                detail.getStatus(),
                detail.getTagline(),
                detail.getTitle(),
                detail.getVideo(),
                detail.getVoteAverage(),
                detail.getVoteCount()
        );
    }
}
