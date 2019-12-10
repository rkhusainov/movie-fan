package com.github.rkhusainov.moviefan.data.mapper;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.data.model.credit.Cast;
import com.github.rkhusainov.moviefan.data.model.credit.Credit;
import com.github.rkhusainov.moviefan.data.model.credit.Crew;
import com.github.rkhusainov.moviefan.domain.mapper.IMapper;
import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.domain.model.CreditEntity;
import com.github.rkhusainov.moviefan.domain.model.CrewEntity;

import java.util.ArrayList;
import java.util.List;

public class CreditMapper implements IMapper<Credit, CreditEntity> {
    @NonNull
    @Override
    public CreditEntity convert(@NonNull Credit credit) {

        List<CastEntity> casts = new ArrayList<>();

        for (Cast cast : credit.getCast()) {
            casts.add(new CastEntity(
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

        List<CrewEntity> crews = new ArrayList<>();

        for (Crew crew : credit.getCrew()) {
            crews.add(new CrewEntity(
                    crew.getId(),
                    crew.getCreditId(),
                    crew.getDepartment(),
                    crew.getGender(),
                    crew.getJob(),
                    crew.getName(),
                    crew.getProfilePath()
            ));
        }

        return new CreditEntity(
                credit.getId(),
                casts,
                crews
        );
    }
}
