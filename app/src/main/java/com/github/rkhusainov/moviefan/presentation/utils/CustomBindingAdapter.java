package com.github.rkhusainov.moviefan.presentation.utils;

import android.graphics.PorterDuff;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.data.model.detail.Genre;
import com.github.rkhusainov.moviefan.domain.model.CastEntity;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.presentation.ui.credit.CastAdapter;
import com.github.rkhusainov.moviefan.presentation.ui.popular.PopularMovieAdapter;
import com.github.rkhusainov.moviefan.presentation.ui.today.TodayMovieAdapter;
import com.github.rkhusainov.moviefan.presentation.ui.top.TopMovieAdapter;
import com.github.rkhusainov.moviefan.presentation.ui.upcoming.UpcomingMovieAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Вспомогательный класс с биндинг адаптерами
 */
public class CustomBindingAdapter {

    /**
     * @param imageView экземпляр ImageView
     * @param urlImage  url изображения для скачивания
     */
    @BindingAdapter("bind:imageUrl")
    public static void loadImage(@NonNull ImageView imageView,
                                 @NonNull String urlImage) {

        Picasso.get().
                load(urlImage)
                .placeholder(R.drawable.ic_movie_placeholder)
                .into(imageView);
    }

    /**
     * Binding adapter для PopularMovie
     *
     * @param recyclerView экземпляр RecyclerView
     * @param viewType     тип ViewHolder'a
     * @param movies       список фильмов
     * @param listener     экземпляр OnItemClickListener'a
     */
    @BindingAdapter({"bind:viewType", "bind:dataPopular", "bind:clickHandler"})
    public static void configurePopularRecyclerView(@NonNull RecyclerView recyclerView,
                                                    int viewType,
                                                    @NonNull List<MovieEntity> movies,
                                                    @NonNull OnItemClickListener listener) {

        PopularMovieAdapter adapter = new PopularMovieAdapter(viewType, movies, listener);

        Log.d(TAG, "configurePopularRecyclerView: " + listener.toString());

        if (viewType == Constants.MAIN) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
            dividerItemDecoration.getDrawable().setColorFilter(recyclerView.getContext().getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN);
            recyclerView.addItemDecoration(dividerItemDecoration);
        }

        recyclerView.setAdapter(adapter);
    }

    /**
     * Binding adapter для TopMovie
     *
     * @param recyclerView экземпляр RecyclerView
     * @param viewType     тип ViewHolder'a
     * @param movies       список фильмов
     * @param listener     экземпляр OnItemClickListener'a
     */
    @BindingAdapter({"bind:viewType", "bind:dataTop", "bind:clickHandler"})
    public static void configureTopRecyclerView(RecyclerView recyclerView, int viewType, List<MovieEntity> movies, OnItemClickListener listener) {

        TopMovieAdapter adapter = new TopMovieAdapter(viewType, movies, listener);

        if (viewType == Constants.MAIN) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
            dividerItemDecoration.getDrawable().setColorFilter(recyclerView.getContext().getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN);
            recyclerView.addItemDecoration(dividerItemDecoration);
        }

        recyclerView.setAdapter(adapter);
    }

    /**
     * Binding adapter для UpcomingMovie
     *
     * @param recyclerView экземпляр RecyclerView
     * @param viewType     тип ViewHolder'a
     * @param movies       список фильмов
     * @param listener     экземпляр OnItemClickListener'a
     */
    @BindingAdapter({"bind:viewType", "bind:dataUpcoming", "bind:clickHandler"})
    public static void configureUpcomingRecyclerView(@NonNull RecyclerView recyclerView,
                                                     int viewType,
                                                     @NonNull List<MovieEntity> movies,
                                                     @NonNull OnItemClickListener listener) {

        UpcomingMovieAdapter adapter = new UpcomingMovieAdapter(viewType, movies, listener);

        if (viewType == Constants.MAIN) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
            dividerItemDecoration.getDrawable().setColorFilter(recyclerView.getContext().getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN);
            recyclerView.addItemDecoration(dividerItemDecoration);
        }

        recyclerView.setAdapter(adapter);
    }

    /**
     * Binding adapter для TodayMovie
     *
     * @param recyclerView экземпляр RecyclerView
     * @param movies       список фильмов
     * @param listener     экземпляр OnItemClickListener'a
     */
    @BindingAdapter({"bind:data", "bind:clickHandler"})
    public static void configureTodayRecyclerView(@NonNull RecyclerView recyclerView,
                                                  @NonNull List<MovieEntity> movies,
                                                  @NonNull OnItemClickListener listener) {
        TodayMovieAdapter adapter = new TodayMovieAdapter(movies, listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    /**
     * Binding adapter для Cast
     *
     * @param recyclerView экземпляр RecyclerView
     * @param viewType     тип ViewHolder'a
     * @param casts        список актёров
     */
    @BindingAdapter({"bind:viewType", "bind:dataCast"})
    public static void configureCastRecyclerView(@NonNull RecyclerView recyclerView,
                                                 int viewType,
                                                 @NonNull List<CastEntity> casts) {

        CastAdapter adapter = new CastAdapter(viewType, casts);

        if (viewType == Constants.DETAIL) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
            dividerItemDecoration.getDrawable().setColorFilter(recyclerView.getContext().getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN);
            recyclerView.addItemDecoration(dividerItemDecoration);
        }

        recyclerView.setAdapter(adapter);
    }

    /**
     * Binding adapter для Genres
     *
     * @param textView экземпляр textView
     * @param genres   список жанров
     */
    @BindingAdapter("bind:genres")
    public static void formatGenres(@Nullable TextView textView,
                                    @Nullable List<Genre> genres) {
        if (genres != null) {

            StringBuilder builder = new StringBuilder();
            String separator = "";
            for (Genre genre : genres) {
                builder.append(separator + genre.getName());
                separator = ",";
            }
            textView.setText(builder);
        }
    }
}
