package com.github.rkhusainov.moviefan.data.mapper;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.data.model.credit.Crew;
import com.github.rkhusainov.moviefan.domain.mapper.IMapper;
import com.github.rkhusainov.moviefan.domain.model.CrewEntity;

public class CrewMapper implements IMapper<Crew, CrewEntity> {
    @NonNull
    @Override
    public CrewEntity convert(@NonNull Crew crew) {
        return new CrewEntity(
                crew.getId(),
                crew.getCreditId(),
                crew.getDepartment(),
                crew.getGender(),
                crew.getJob(),
                crew.getName(),
                crew.getProfilePath()
        );
    }
}
