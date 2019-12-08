package com.github.rkhusainov.moviefan.utils;

import android.graphics.PorterDuff;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.credit.Cast;
import com.github.rkhusainov.moviefan.data.model.detail.Genre;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.ui.credit.CastAdapter;
import com.github.rkhusainov.moviefan.ui.popular.PopularAdapter;
import com.github.rkhusainov.moviefan.ui.today.TodayAdapter;
import com.github.rkhusainov.moviefan.ui.top.TopAdapter;
import com.github.rkhusainov.moviefan.ui.upcoming.UpcomingAdapter;
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
    public static void configurePopularRecyclerView(RecyclerView recyclerView, int viewType, List<Movie> movies, OnItemClickListener listener) {

        PopularAdapter adapter = new PopularAdapter(viewType, movies, listener);

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
    public static void configureTopRecyclerView(RecyclerView recyclerView, int viewType, List<Movie> movies, OnItemClickListener listener) {

        TopAdapter adapter = new TopAdapter(viewType, movies, listener);

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
    public static void configureUpcomingRecyclerView(RecyclerView recyclerView, int viewType, List<Movie> movies, OnItemClickListener listener) {

        UpcomingAdapter adapter = new UpcomingAdapter(viewType, movies, listener);

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
    public static void configureTodayRecyclerView(RecyclerView recyclerView, List<Movie> movies, OnItemClickListener listener) {
        TodayAdapter adapter = new TodayAdapter(movies, listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"bind:viewType", "bind:dataCast"})
    public static void configureCastRecyclerView(RecyclerView recyclerView, int viewType, List<Cast> casts) {

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
