package com.github.rkhusainov.moviefan.data.mapper;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.data.model.credit.Cast;
import com.github.rkhusainov.moviefan.domain.mapper.IMapper;
import com.github.rkhusainov.moviefan.domain.model.CastEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация маппинга из pojo класса в entity
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class CastMapper implements IMapper<List<Cast>, List<CastEntity>> {

    @NonNull
    @Override
    public List<CastEntity> convert(@NonNull List<Cast> casts) {
        List<CastEntity> entityList = new ArrayList<>();
        for (Cast cast : casts) {
            entityList.add(new CastEntity(
                    cast.getId(),
                    cast.getCastId(),
                    cast.getCharacter(),
                    cast.getCreditId(),
                    cast.getGender(),
                    cast.getName(),
                    cast.getOrder(),
                    cast.getProfilePath()
            ));
        }
        return entityList;
    }
}
