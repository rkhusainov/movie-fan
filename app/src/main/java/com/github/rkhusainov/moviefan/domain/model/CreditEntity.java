package com.github.rkhusainov.moviefan.domain.model;

import java.util.List;
import java.util.Objects;

public class CreditEntity {
    private Integer mId;
    private List<CastEntity> mCast;
    private List<CrewEntity> mCrew;

    public CreditEntity(Integer id,
                        List<CastEntity> cast,
                        List<CrewEntity> crew) {
        mId = id;
        mCast = cast;
        mCrew = crew;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public List<CastEntity> getCast() {
        return mCast;
    }

    public void setCast(List<CastEntity> cast) {
        mCast = cast;
    }

    public List<CrewEntity> getCrew() {
        return mCrew;
    }

    public void setCrew(List<CrewEntity> crew) {
        mCrew = crew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditEntity entity = (CreditEntity) o;
        return Objects.equals(mId, entity.mId) &&
                Objects.equals(mCast, entity.mCast) &&
                Objects.equals(mCrew, entity.mCrew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mCast, mCrew);
    }

    @Override
    public String toString() {
        return "CreditEntity{" +
                "mId=" + mId +
                ", mCast=" + mCast +
                ", mCrew=" + mCrew +
                '}';
    }
}
