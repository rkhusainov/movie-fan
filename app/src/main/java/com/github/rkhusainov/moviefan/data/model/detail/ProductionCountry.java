package com.github.rkhusainov.moviefan.data.model.detail;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Pojo класс, содержащий информацию о стране, где снят фильм
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class ProductionCountry {
    @SerializedName("iso_3166_1")
    private String mIso31661;
    @SerializedName("name")
    private String mName;

    public String getIso31661() {
        return mIso31661;
    }

    public void setIso31661(String iso31661) {
        mIso31661 = iso31661;
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
        ProductionCountry that = (ProductionCountry) o;
        return Objects.equals(mIso31661, that.mIso31661) &&
                Objects.equals(mName, that.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mIso31661, mName);
    }

    @Override
    public String toString() {
        return "ProductionCountry{" +
                "mIso31661='" + mIso31661 + '\'' +
                ", mName='" + mName + '\'' +
                '}';
    }
}
