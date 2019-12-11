package com.github.rkhusainov.moviefan.data.model.detail;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SpokenLanguage {
    @SerializedName("iso_639_1")
    private String mIso6391;
    @SerializedName("name")
    private String mName;

    public String getIso6391() {
        return mIso6391;
    }

    public void setIso6391(String iso6391) {
        mIso6391 = iso6391;
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
        SpokenLanguage that = (SpokenLanguage) o;
        return Objects.equals(mIso6391, that.mIso6391) &&
                Objects.equals(mName, that.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mIso6391, mName);
    }

    @Override
    public String toString() {
        return "SpokenLanguage{" +
                "mIso6391='" + mIso6391 + '\'' +
                ", mName='" + mName + '\'' +
                '}';
    }
}
