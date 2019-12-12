package com.github.rkhusainov.moviefan.data.mapper;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.data.model.credit.Crew;
import com.github.rkhusainov.moviefan.domain.mapper.IMapper;
import com.github.rkhusainov.moviefan.domain.model.CrewEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация маппинга из pojo класса в entity
 */
public class CrewMapper implements IMapper<List<Crew>, List<CrewEntity>> {
    @NonNull
    @Override
    public List<CrewEntity> convert(@NonNull List<Crew> crews) {
        List<CrewEntity> entityList = new ArrayList<>();

        for (Crew crew : crews) {
            entityList.add(new CrewEntity(
                    crew.getId(),
                    crew.getCreditId(),
                    crew.getDepartment(),
                    crew.getGender(),
                    crew.getJob(),
                    crew.getName(),
                    crew.getProfilePath()
            ));
        }
        return entityList;
    }
}
