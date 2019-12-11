package com.github.rkhusainov.moviefan.data.model.credit;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Credit {
    @SerializedName("id")
    private Integer mId;
    @SerializedName("cast")
    private List<Cast> mCast = null;
    @SerializedName("crew")
    private List<Crew> mCrew = null;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public List<Cast> getCast() {
        return mCast;
    }

    public void setCast(List<Cast> cast) {
        mCast = cast;
    }

    public List<Crew> getCrew() {
        return mCrew;
    }

    public void setCrew(List<Crew> crew) {
        mCrew = crew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(mId, credit.mId) &&
                Objects.equals(mCast, credit.mCast) &&
                Objects.equals(mCrew, credit.mCrew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mCast, mCrew);
    }

    @Override
    public String toString() {
        return "Credit{" +
                "mId=" + mId +
                ", mCast=" + mCast +
                ", mCrew=" + mCrew +
                '}';
    }
}
