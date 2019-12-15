package com.github.rkhusainov.moviefan.domain.mapper;

import androidx.annotation.NonNull;

/**
 * Интерфейс для маппинга данных
 *
 * @param <From> маппинг из entity
 * @param <To>   маппинг в data
 * @author Хусаинов Ринат on 2019-12-15
 */
public interface IMapper<From, To> {
    @NonNull
    To convert(@NonNull From from);
}
