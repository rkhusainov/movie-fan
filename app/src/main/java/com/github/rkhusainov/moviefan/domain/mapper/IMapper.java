package com.github.rkhusainov.moviefan.domain.mapper;

import androidx.annotation.NonNull;

/**
 * Интерфейс для маппинга данных
 * @param <From>   маппинг в entity
 * @param <To>   маппинг в data
 */

public interface IMapper<From, To> {
    @NonNull
    To convert(@NonNull From from);
}
