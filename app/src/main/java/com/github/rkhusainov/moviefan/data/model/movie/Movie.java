package com.github.rkhusainov.moviefan.data.model.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Pojo класс, содержащий информацию о фильмах
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class Movie {
    @SerializedName("id")
    private Integer mId;
    @SerializedName("popularity")
    private Double mPopularity;
    @SerializedName("vote_count")
    private Integer mVoteCount;
    @SerializedName("video")
    private Boolean mVideo;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("adult")
    private Boolean mAdult;
    @SerializedName("backdrop_path")
    private String mBackdropPath;
    @SerializedName("original_language")
    private String mOriginalLanguage;
    @SerializedName("original_title")
    private String mOriginalTitle;
    @SerializedName("genre_ids")
    private List<Integer> mGenreIds;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("vote_average")
    private Double mVoteAverage;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("release_date")
    private String mReleaseDate;

    public Movie(Integer id,
                 Double popularity,
                 Integer voteCount,
                 Boolean video,
                 String posterPath,
                 Boolean adult,
                 String backdropPath,
                 String originalLanguage,
                 String originalTitle,
                 List<Integer> genreIds,
                 String title,
                 Double voteAverage,
                 String overview,
                 String releaseDate) {
        mId = id;
        mPopularity = popularity;
        mVoteCount = voteCount;
        mVideo = video;
        mPosterPath = posterPath;
        mAdult = adult;
        mBackdropPath = backdropPath;
        mOriginalLanguage = originalLanguage;
        mOriginalTitle = originalTitle;
        mGenreIds = genreIds;
        mTitle = title;
        mVoteAverage = voteAverage;
        mOverview = overview;
        mReleaseDate = releaseDate;
    }

    public Double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(Double popularity) {
        mPopularity = popularity;
    }

    public Integer getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(Integer voteCount) {
        mVoteCount = voteCount;
    }

    public Boolean getVideo() {
        return mVideo;
    }

    public void setVideo(Boolean video) {
        mVideo = video;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

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

    public List<Integer> getGenreIds() {
        return mGenreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        mGenreIds = genreIds;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(mPopularity, movie.mPopularity) &&
                Objects.equals(mVoteCount, movie.mVoteCount) &&
                Objects.equals(mVideo, movie.mVideo) &&
                Objects.equals(mPosterPath, movie.mPosterPath) &&
                Objects.equals(mId, movie.mId) &&
                Objects.equals(mAdult, movie.mAdult) &&
                Objects.equals(mBackdropPath, movie.mBackdropPath) &&
                Objects.equals(mOriginalLanguage, movie.mOriginalLanguage) &&
                Objects.equals(mOriginalTitle, movie.mOriginalTitle) &&
                Objects.equals(mGenreIds, movie.mGenreIds) &&
                Objects.equals(mTitle, movie.mTitle) &&
                Objects.equals(mVoteAverage, movie.mVoteAverage) &&
                Objects.equals(mOverview, movie.mOverview) &&
                Objects.equals(mReleaseDate, movie.mReleaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mPopularity,
                mVoteCount,
                mVideo,
                mPosterPath,
                mId,
                mAdult,
                mBackdropPath,
                mOriginalLanguage,
                mOriginalTitle,
                mGenreIds,
                mTitle,
                mVoteAverage,
                mOverview,
                mReleaseDate);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mPopularity=" + mPopularity +
                ", mVoteCount=" + mVoteCount +
                ", mVideo=" + mVideo +
                ", mPosterPath='" + mPosterPath + '\'' +
                ", mId=" + mId +
                ", mAdult=" + mAdult +
                ", mBackdropPath='" + mBackdropPath + '\'' +
                ", mOriginalLanguage='" + mOriginalLanguage + '\'' +
                ", mOriginalTitle='" + mOriginalTitle + '\'' +
                ", mGenreIds=" + mGenreIds +
                ", mTitle='" + mTitle + '\'' +
                ", mVoteAverage=" + mVoteAverage +
                ", mOverview='" + mOverview + '\'' +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                '}';
    }
}
