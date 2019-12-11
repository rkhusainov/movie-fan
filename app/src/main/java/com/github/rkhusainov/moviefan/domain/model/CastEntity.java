package com.github.rkhusainov.moviefan.domain.model;

import java.util.Objects;

public class CastEntity {
    private Integer mId;
    private Integer mCastId;
    private String mCharacter;
    private String mCreditId;
    private Integer mGender;
    private String mName;
    private Integer mOrder;
    private String mProfilePath;

    public CastEntity(Integer id,
                      Integer castId,
                      String character,
                      String creditId,
                      Integer gender,
                      String name,
                      Integer order,
                      String profilePath) {
        mId = id;
        mCastId = castId;
        mCharacter = character;
        mCreditId = creditId;
        mGender = gender;
        mName = name;
        mOrder = order;
        mProfilePath = profilePath;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

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
        CastEntity that = (CastEntity) o;
        return Objects.equals(mId, that.mId) &&
                Objects.equals(mCastId, that.mCastId) &&
                Objects.equals(mCharacter, that.mCharacter) &&
                Objects.equals(mCreditId, that.mCreditId) &&
                Objects.equals(mGender, that.mGender) &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(mOrder, that.mOrder) &&
                Objects.equals(mProfilePath, that.mProfilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mCastId, mCharacter, mCreditId, mGender, mName, mOrder, mProfilePath);
    }

    @Override
    public String toString() {
        return "CastEntity{" +
                "mId=" + mId +
                ", mCastId=" + mCastId +
                ", mCharacter='" + mCharacter + '\'' +
                ", mCreditId='" + mCreditId + '\'' +
                ", mGender=" + mGender +
                ", mName='" + mName + '\'' +
                ", mOrder=" + mOrder +
                ", mProfilePath='" + mProfilePath + '\'' +
                '}';
    }
}
