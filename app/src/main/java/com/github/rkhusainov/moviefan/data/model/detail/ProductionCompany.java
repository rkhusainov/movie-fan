package com.github.rkhusainov.moviefan.data.model.detail;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Pojo класс, содержащий информацию о компании, которая сняла фильм
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class ProductionCompany {
    @SerializedName("id")
    private Integer mId;
    @SerializedName("logo_path")
    private String mLogoPath;
    @SerializedName("name")
    private String mName;
    @SerializedName("origin_country")
    private String mOriginCountry;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getLogoPath() {
        return mLogoPath;
    }

    public void setLogoPath(String logoPath) {
        mLogoPath = logoPath;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOriginCountry() {
        return mOriginCountry;
    }

    public void setOriginCountry(String originCountry) {
        mOriginCountry = originCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionCompany that = (ProductionCompany) o;
        return Objects.equals(mId, that.mId) &&
                Objects.equals(mLogoPath, that.mLogoPath) &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(mOriginCountry, that.mOriginCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mLogoPath, mName, mOriginCountry);
    }

    @Override
    public String toString() {
        return "ProductionCompany{" +
                "mId=" + mId +
                ", mLogoPath='" + mLogoPath + '\'' +
                ", mName='" + mName + '\'' +
                ", mOriginCountry='" + mOriginCountry + '\'' +
                '}';
    }
}
