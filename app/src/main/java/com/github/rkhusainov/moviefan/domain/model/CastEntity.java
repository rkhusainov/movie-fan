package com.github.rkhusainov.moviefan.domain.model;

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
}
