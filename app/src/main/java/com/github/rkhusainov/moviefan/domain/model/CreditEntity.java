package com.github.rkhusainov.moviefan.domain.model;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Objects;

/**
 * Domain сущность, содержащая информацию о всех участниках съёмок фильма
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class CreditEntity {
    @NonNull
    private Integer mId;
    @NonNull
    private List<CastEntity> mCast;
    @NonNull
    private List<CrewEntity> mCrew;

    public CreditEntity(@NonNull Integer id,
                        @NonNull List<CastEntity> cast,
                        @NonNull List<CrewEntity> crew) {
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
