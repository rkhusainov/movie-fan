package com.github.rkhusainov.moviefan.domain.model;

import java.util.Objects;

public class CrewEntity {
    private Integer mId;
    private String mCreditId;
    private String mDepartment;
    private Integer mGender;
    private String mJob;
    private String mName;
    private String mProfilePath;

    public CrewEntity(Integer id,
                      String creditId,
                      String department,
                      Integer gender,
                      String job,
                      String name,
                      String profilePath) {
        mId = id;
        mCreditId = creditId;
        mDepartment = department;
        mGender = gender;
        mJob = job;
        mName = name;
        mProfilePath = profilePath;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getCreditId() {
        return mCreditId;
    }

    public void setCreditId(String creditId) {
        mCreditId = creditId;
    }

    public String getDepartment() {
        return mDepartment;
    }

    public void setDepartment(String department) {
        mDepartment = department;
    }

    public Integer getGender() {
        return mGender;
    }

    public void setGender(Integer gender) {
        mGender = gender;
    }

    public String getJob() {
        return mJob;
    }

    public void setJob(String job) {
        mJob = job;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
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
        CrewEntity that = (CrewEntity) o;
        return Objects.equals(mId, that.mId) &&
                Objects.equals(mCreditId, that.mCreditId) &&
                Objects.equals(mDepartment, that.mDepartment) &&
                Objects.equals(mGender, that.mGender) &&
                Objects.equals(mJob, that.mJob) &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(mProfilePath, that.mProfilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mCreditId, mDepartment, mGender, mJob, mName, mProfilePath);
    }

    @Override
    public String toString() {
        return "CrewEntity{" +
                "mId=" + mId +
                ", mCreditId='" + mCreditId + '\'' +
                ", mDepartment='" + mDepartment + '\'' +
                ", mGender=" + mGender +
                ", mJob='" + mJob + '\'' +
                ", mName='" + mName + '\'' +
                ", mProfilePath='" + mProfilePath + '\'' +
                '}';
    }
}
