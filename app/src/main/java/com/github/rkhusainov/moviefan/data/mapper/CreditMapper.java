package com.github.rkhusainov.moviefan.data.mapper;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.data.model.credit.Credit;
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

        List<CastEntity> casts = new ArrayList(credit.getCast());
        List<CrewEntity> crews = new ArrayList(credit.getCrew());

//        for (int i = 0; i < credit.getCast().size(); i++) {
//            casts.add(new CastEntity(
//                    credit.getCast().get(i).getId(),
//                    credit.getCast().get(i).
//            ));
//        }

        return new CreditEntity(
                credit.getId(),
                casts,
                crews
        );
    }
}
