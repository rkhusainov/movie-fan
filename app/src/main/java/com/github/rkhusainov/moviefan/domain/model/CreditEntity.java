package com.github.rkhusainov.moviefan.domain.model;

import java.util.List;

public class CreditEntity {
    private Integer id;
    private List<CastEntity> cast;
    private List<CrewEntity> crew;

    public CreditEntity(Integer id,
                        List<CastEntity> cast,
                        List<CrewEntity> crew) {
        this.id = id;
        this.cast = cast;
        this.crew = crew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CastEntity> getCast() {
        return cast;
    }

    public void setCast(List<CastEntity> cast) {
        this.cast = cast;
    }

    public List<CrewEntity> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewEntity> crew) {
        this.crew = crew;
    }
}
