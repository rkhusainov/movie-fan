package com.github.rkhusainov.moviefan.data.model.credit;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Pojo класс, содержащий информацию о других участниках съемок, кроме актеров
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class Crew {
    @SerializedName("credit_id")
    private String mCreditId;
    @SerializedName("department")
    private String mDepartment;
    @SerializedName("gender")
    private Integer mGender;
    @SerializedName("id")
    private Integer mId;
    @SerializedName("job")
    private String mJob;
    @SerializedName("name")
    private String mName;
    @SerializedName("profile_path")
    private String mProfilePath;

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

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
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
        Crew crew = (Crew) o;
        return Objects.equals(mCreditId, crew.mCreditId) &&
                Objects.equals(mDepartment, crew.mDepartment) &&
                Objects.equals(mGender, crew.mGender) &&
                Objects.equals(mId, crew.mId) &&
                Objects.equals(mJob, crew.mJob) &&
                Objects.equals(mName, crew.mName) &&
                Objects.equals(mProfilePath, crew.mProfilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mCreditId, mDepartment, mGender, mId, mJob, mName, mProfilePath);
    }

    @Override
    public String toString() {
        return "Crew{" +
                "mCreditId='" + mCreditId + '\'' +
                ", mDepartment='" + mDepartment + '\'' +
                ", mGender=" + mGender +
                ", mId=" + mId +
                ", mJob='" + mJob + '\'' +
                ", mName='" + mName + '\'' +
                ", mProfilePath='" + mProfilePath + '\'' +
                '}';
    }
}
