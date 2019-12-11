package com.github.rkhusainov.moviefan.data.model.credit;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Cast {
    @SerializedName("cast_id")
    private Integer mCastId;
    @SerializedName("character")
    private String mCharacter;
    @SerializedName("credit_id")
    private String mCreditId;
    @SerializedName("gender")
    private Integer mGender;
    @SerializedName("id")
    private Integer mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("order")
    private Integer mOrder;
    @SerializedName("profile_path")
    private String mProfilePath;

    public Integer getCastId() {
        return mCastId;
    }

    public void setCastId(Integer castId) {
        mCastId = castId;
    }

    public String getCharacter() {
        return mCharacter;
    }

    public void setCharacter(String character) {
        mCharacter = character;
    }

    public String getCreditId() {
        return mCreditId;
    }

    public void setCreditId(String creditId) {
        mCreditId = creditId;
    }

    public Integer getGender() {
        return mGender;
    }

    public void setGender(Integer gender) {
        mGender = gender;
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

    public Integer getOrder() {
        return mOrder;
    }

    public void setOrder(Integer order) {
        mOrder = order;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public void setProfilePath(String profilePath) {
        mProfilePath = profilePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cast cast = (Cast) o;
        return Objects.equals(mCastId, cast.mCastId) &&
                Objects.equals(mCharacter, cast.mCharacter) &&
                Objects.equals(mCreditId, cast.mCreditId) &&
                Objects.equals(mGender, cast.mGender) &&
                Objects.equals(mId, cast.mId) &&
                Objects.equals(mName, cast.mName) &&
                Objects.equals(mOrder, cast.mOrder) &&
                Objects.equals(mProfilePath, cast.mProfilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mCastId, mCharacter, mCreditId, mGender, mId, mName, mOrder, mProfilePath);
    }

    @Override
    public String toString() {
        return "Cast{" +
                "mCastId=" + mCastId +
                ", mCharacter='" + mCharacter + '\'' +
                ", mCreditId='" + mCreditId + '\'' +
                ", mGender=" + mGender +
                ", mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mOrder=" + mOrder +
                ", mProfilePath='" + mProfilePath + '\'' +
                '}';
    }
}
