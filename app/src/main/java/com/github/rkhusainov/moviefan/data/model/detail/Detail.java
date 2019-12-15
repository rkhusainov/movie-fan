package com.github.rkhusainov.moviefan.data.model.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Pojo класс, содержащий детальную информацию о фильме
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class Detail {
    @SerializedName("adult")
    private Boolean mAdult;
    @SerializedName("backdrop_path")
    private String mBackdropPath;
    @SerializedName("belongs_to_collection")
    private Object mBelongsToCollection;
    @SerializedName("budget")
    private Integer mBudget;
    @SerializedName("genres")
    private List<Genre> mGenres = null;
    @SerializedName("homepage")
    private String mHomepage;
    @SerializedName("id")
    private Integer mId;
    @SerializedName("imdb_id")
    private String mImdbId;
    @SerializedName("original_language")
    private String mOriginalLanguage;
    @SerializedName("original_title")
    private String mOriginalTitle;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("popularity")
    private Double mPopularity;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("production_companies")
    private List<ProductionCompany> mProductionCompanies = null;
    @SerializedName("production_countries")
    private List<ProductionCountry> mProductionCountries = null;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("revenue")
    private Integer mRevenue;
    @SerializedName("runtime")
    private Integer mRuntime;
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> mSpokenLanguages = null;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("tagline")
    private String mTagline;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("video")
    private Boolean mVideo;
    @SerializedName("vote_average")
    private Double mVoteAverage;
    @SerializedName("vote_count")
    private Integer mVoteCount;

    public Boolean getAdult() {
        return mAdult;
    }

    public void setAdult(Boolean adult) {
        mAdult = adult;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public Object getBelongsToCollection() {
        return mBelongsToCollection;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        mBelongsToCollection = belongsToCollection;
    }

    public Integer getBudget() {
        return mBudget;
    }

    public void setBudget(Integer budget) {
        mBudget = budget;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
    }

    public String getHomepage() {
        return mHomepage;
    }

    public void setHomepage(String homepage) {
        mHomepage = homepage;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public void setImdbId(String imdbId) {
        mImdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        mOriginalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public Double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(Double popularity) {
        mPopularity = popularity;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return mProductionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        mProductionCompanies = productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return mProductionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        mProductionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public Integer getRevenue() {
        return mRevenue;
    }

    public void setRevenue(Integer revenue) {
        mRevenue = revenue;
    }

    public Integer getRuntime() {
        return mRuntime;
    }

    public void setRuntime(Integer runtime) {
        mRuntime = runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return mSpokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        mSpokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTagline() {
        return mTagline;
    }

    public void setTagline(String tagline) {
        mTagline = tagline;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Boolean getVideo() {
        return mVideo;
    }

    public void setVideo(Boolean video) {
        mVideo = video;
    }

    public Double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(Integer voteCount) {
        mVoteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return Objects.equals(mAdult, detail.mAdult) &&
                Objects.equals(mBackdropPath, detail.mBackdropPath) &&
                Objects.equals(mBelongsToCollection, detail.mBelongsToCollection) &&
                Objects.equals(mBudget, detail.mBudget) &&
                Objects.equals(mGenres, detail.mGenres) &&
                Objects.equals(mHomepage, detail.mHomepage) &&
                Objects.equals(mId, detail.mId) &&
                Objects.equals(mImdbId, detail.mImdbId) &&
                Objects.equals(mOriginalLanguage, detail.mOriginalLanguage) &&
                Objects.equals(mOriginalTitle, detail.mOriginalTitle) &&
                Objects.equals(mOverview, detail.mOverview) &&
                Objects.equals(mPopularity, detail.mPopularity) &&
                Objects.equals(mPosterPath, detail.mPosterPath) &&
                Objects.equals(mProductionCompanies, detail.mProductionCompanies) &&
                Objects.equals(mProductionCountries, detail.mProductionCountries) &&
                Objects.equals(mReleaseDate, detail.mReleaseDate) &&
                Objects.equals(mRevenue, detail.mRevenue) &&
                Objects.equals(mRuntime, detail.mRuntime) &&
                Objects.equals(mSpokenLanguages, detail.mSpokenLanguages) &&
                Objects.equals(mStatus, detail.mStatus) &&
                Objects.equals(mTagline, detail.mTagline) &&
                Objects.equals(mTitle, detail.mTitle) &&
                Objects.equals(mVideo, detail.mVideo) &&
                Objects.equals(mVoteAverage, detail.mVoteAverage) &&
                Objects.equals(mVoteCount, detail.mVoteCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                mAdult,
                mBackdropPath,
                mBelongsToCollection,
                mBudget,
                mGenres,
                mHomepage,
                mId,
                mImdbId,
                mOriginalLanguage,
                mOriginalTitle,
                mOverview,
                mPopularity,
                mPosterPath,
                mProductionCompanies,
                mProductionCountries,
                mReleaseDate,
                mRevenue,
                mRuntime,
                mSpokenLanguages,
                mStatus,
                mTagline,
                mTitle,
                mVideo,
                mVoteAverage,
                mVoteCount);
    }

    @Override
    public String toString() {
        return "Detail{" +
                "mAdult=" + mAdult +
                ", mBackdropPath='" + mBackdropPath + '\'' +
                ", mBelongsToCollection=" + mBelongsToCollection +
                ", mBudget=" + mBudget +
                ", mGenres=" + mGenres +
                ", mHomepage='" + mHomepage + '\'' +
                ", mId=" + mId +
                ", mImdbId='" + mImdbId + '\'' +
                ", mOriginalLanguage='" + mOriginalLanguage + '\'' +
                ", mOriginalTitle='" + mOriginalTitle + '\'' +
                ", mOverview='" + mOverview + '\'' +
                ", mPopularity=" + mPopularity +
                ", mPosterPath='" + mPosterPath + '\'' +
                ", mProductionCompanies=" + mProductionCompanies +
                ", mProductionCountries=" + mProductionCountries +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                ", mRevenue=" + mRevenue +
                ", mRuntime=" + mRuntime +
                ", mSpokenLanguages=" + mSpokenLanguages +
                ", mStatus='" + mStatus + '\'' +
                ", mTagline='" + mTagline + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mVideo=" + mVideo +
                ", mVoteAverage=" + mVoteAverage +
                ", mVoteCount=" + mVoteCount +
                '}';
    }
}
