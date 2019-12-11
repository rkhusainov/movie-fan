package com.github.rkhusainov.moviefan.presentation.utils;

import android.graphics.PorterDuff;
import android.widget.ImageView;
import android.widget.TextView;

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

public class CustomBindingAdapter {

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String urlImage) {

        Picasso.get().
                load(urlImage)
                .placeholder(R.drawable.ic_movie_placeholder)
                .into(imageView);
    }

    @BindingAdapter({"bind:viewType", "bind:dataPopular", "bind:clickHandler"})
    public static void configurePopularRecyclerView(RecyclerView recyclerView, int viewType, List<MovieEntity> movies, OnItemClickListener listener) {

        PopularMovieAdapter adapter = new PopularMovieAdapter(viewType, movies, listener);

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

    @BindingAdapter({"bind:viewType", "bind:dataUpcoming", "bind:clickHandler"})
    public static void configureUpcomingRecyclerView(RecyclerView recyclerView, int viewType, List<MovieEntity> movies, OnItemClickListener listener) {

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

    @BindingAdapter({"bind:data", "bind:clickHandler"})
    public static void configureTodayRecyclerView(RecyclerView recyclerView, List<MovieEntity> movies, OnItemClickListener listener) {
        TodayMovieAdapter adapter = new TodayMovieAdapter(movies, listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"bind:viewType", "bind:dataCast"})
    public static void configureCastRecyclerView(RecyclerView recyclerView, int viewType, List<CastEntity> casts) {

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

    @BindingAdapter("bind:genres")
    public static void formatGenres(TextView textView, List<Genre> genres) {
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
