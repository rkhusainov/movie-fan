package com.github.rkhusainov.moviefan.domain.interactor;

import com.github.rkhusainov.moviefan.data.model.detail.Genre;
import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.domain.model.DetailEntity;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.domain.repository.IMovieRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class MovieInteractorTest {

    private MovieEntity mMovieEntity;
    private List<MovieEntity> mMovies = new ArrayList<>();

    private DetailEntity mDetailEntity;

    private CastEntity mCastEntity;
    private List<CastEntity> mCasts = new ArrayList<>();

    private MovieInteractor mMovieInteractor;
    private IMovieRepository mMovieRepository;

    @Before
    public void setUp() throws Exception {

        mMovieEntity = new MovieEntity(
                0,
                "Любовь и голуби",
                "Любовь и голуби",
                10.0,
                "/lubov_i_golubi.jpg",
                10.0,
                1000,
                "советская лирическая комедия",
                "1984-09-01",
                false,
                false,
                "/lubov_i_golubi.jpg",
                "ru",
                Arrays.asList(10, 20, 30)
        );

        mMovies.add(mMovieEntity);


        mDetailEntity = new DetailEntity(
                0,
                false,
                "/lubov_i_golubi.jpg",
                "",
                800000,
                Arrays.asList(new Genre(0, "dsfsd")),
                "",
                "2343",
                "ru",
                "Любовь и голуби",
                "советская лирическая комедия",
                45.5,
                "/sdafsadf.jpg",
                "1984-09-01",
                6546,
                130,
                "Released",
                "some tagline",
                "Любовь и голуби",
                false,
                10.0,
                2343
        );

        mCastEntity = new CastEntity(
                0,
                432,
                "Вася",
                "232",
                10,
                "Александр Михайлов",
                0,
                "/sdfsdf.jpg"
        );

        mCasts.add(mCastEntity);

        mMovieRepository = mock(IMovieRepository.class);
        mMovieInteractor = new MovieInteractor(mMovieRepository);
    }

    @Test
    public void getPopularMovies() {
        when(mMovieRepository.getPopularMovies()).thenReturn(Single.fromCallable(new Callable<List<MovieEntity>>() {
            @Override
            public List<MovieEntity> call() throws Exception {
                return mMovies;
            }
        }));

        TestObserver<List<MovieEntity>> observer = mMovieInteractor.getPopularMovies().test();
        observer.assertValue(mMovies);
        observer.dispose();
        verify(mMovieRepository).getPopularMovies();
        verifyZeroInteractions(mMovieRepository);
    }

    @Test
    public void getTodayMovies() {
        when(mMovieRepository.getTodayMovies()).thenReturn(Single.fromCallable(new Callable<List<MovieEntity>>() {
            @Override
            public List<MovieEntity> call() throws Exception {
                return mMovies;
            }
        }));

        TestObserver<List<MovieEntity>> observer = mMovieInteractor.getTodayMovies().test();
        observer.assertValue(mMovies);
        observer.dispose();
        verify(mMovieRepository).getTodayMovies();
        verifyZeroInteractions(mMovieRepository);
    }

    @Test
    public void getTopMovies() {
        when(mMovieRepository.getTopMovies()).thenReturn(Single.fromCallable(new Callable<List<MovieEntity>>() {
            @Override
            public List<MovieEntity> call() throws Exception {
                return mMovies;
            }
        }));

        TestObserver<List<MovieEntity>> observer = mMovieInteractor.getTopMovies().test();
        observer.assertValue(mMovies);
        observer.dispose();
        verify(mMovieRepository).getTopMovies();
        verifyZeroInteractions(mMovieRepository);
    }

    @Test
    public void getUpcomingMovies() {
        when(mMovieRepository.getUpcomingMovies()).thenReturn(Single.fromCallable(new Callable<List<MovieEntity>>() {
            @Override
            public List<MovieEntity> call() throws Exception {
                return mMovies;
            }
        }));

        TestObserver<List<MovieEntity>> observer = mMovieInteractor.getUpcomingMovies().test();
        observer.assertValue(mMovies);
        observer.dispose();
        verify(mMovieRepository).getUpcomingMovies();
        verifyZeroInteractions(mMovieRepository);
    }

    @Test
    public void getDetail() {
        when(mMovieRepository.getDetail(0)).thenReturn(Single.fromCallable(new Callable<DetailEntity>() {
            @Override
            public DetailEntity call() throws Exception {
                return mDetailEntity;
            }
        }));

        TestObserver<DetailEntity> observer = mMovieInteractor.getDetail(0).test();
        observer.assertValue(mDetailEntity);
        observer.dispose();
        verify(mMovieRepository).getDetail(0);
        verifyZeroInteractions(mMovieRepository);
    }

    @Test
    public void getCasts() {
        when(mMovieRepository.getCasts(0)).thenReturn(Single.fromCallable(new Callable<List<CastEntity>>() {
            @Override
            public List<CastEntity> call() throws Exception {
                return mCasts;
            }
        }));

        TestObserver<List<CastEntity>> observer = mMovieInteractor.getCasts(0).test();
        observer.assertValue(mCasts);
        observer.dispose();
        verify(mMovieRepository).getCasts(0);
        verifyZeroInteractions(mMovieRepository);
    }
}