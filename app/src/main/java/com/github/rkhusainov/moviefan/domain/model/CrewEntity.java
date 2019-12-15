package com.github.rkhusainov.moviefan.domain.model;

import androidx.annotation.NonNull;

import java.util.Objects;

/**
 * Domain сущность, содержащая информацию о других участниках съемок, кроме актеров
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class CrewEntity {
    @NonNull
    private Integer mId;
    @NonNull
    private String mCreditId;
    @NonNull
    private String mDepartment;
    @NonNull
    private Integer mGender;
    @NonNull
    private String mJob;
    @NonNull
    private String mName;
    @NonNull
    private String mProfilePath;

    public CrewEntity(@NonNull Integer id,
                      @NonNull String creditId,
                      @NonNull String department,
                      @NonNull Integer gender,
                      @NonNull String job,
                      @NonNull String name,
                      @NonNull String profilePath) {
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
