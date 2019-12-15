package com.github.rkhusainov.moviefan.data.model.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Pojo класс, содержащий список фильмов и номер страницы
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class MovieResponse {
    @SerializedName("page")
    private Integer mPage;
    @SerializedName("total_results")
    private Integer mTotalResults;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("results")
    private List<Movie> mMovies;

    public MovieResponse(Integer page, Integer totalResults, Integer totalPages, List<Movie> movies) {
        mPage = page;
        mTotalResults = totalResults;
        this.totalPages = totalPages;
        mMovies = movies;
    }

    public Integer getPage() {
        return mPage;
    }

    public void setPage(Integer page) {
        mPage = page;
    }

    public Integer getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Integer totalResults) {
        mTotalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getResults() {
        return mMovies;
    }

    public void setResults(List<Movie> movies) {
        mMovies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieResponse that = (MovieResponse) o;
        return Objects.equals(mPage, that.mPage) &&
                Objects.equals(mTotalResults, that.mTotalResults) &&
                Objects.equals(totalPages, that.totalPages) &&
                Objects.equals(mMovies, that.mMovies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mPage, mTotalResults, totalPages, mMovies);
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "mPage=" + mPage +
                ", mTotalResults=" + mTotalResults +
                ", totalPages=" + totalPages +
                ", mMovies=" + mMovies +
                '}';
    }
}
