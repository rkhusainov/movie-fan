package com.github.rkhusainov.moviefan.data.model.detail;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Genre {
    @SerializedName("id")
    private Integer mId;
    @SerializedName("name")
    private String mName;

    public Genre(Integer id, String name) {
        mId = id;
        mName = name;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(mId, genre.mId) &&
                Objects.equals(mName, genre.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }
}
