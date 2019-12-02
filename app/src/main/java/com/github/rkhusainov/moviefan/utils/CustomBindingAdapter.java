package com.github.rkhusainov.moviefan.utils;

import android.graphics.PorterDuff;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.ui.popular.PopularAdapter;
import com.github.rkhusainov.moviefan.ui.today.TodayAdapter;
import com.github.rkhusainov.moviefan.ui.top.TopAdapter;
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
    public static void configureMainPopularRecyclerView(RecyclerView recyclerView, int viewType, List<Movie> movies, OnItemClickListener listener) {
        PopularAdapter adapter = new PopularAdapter(viewType, movies, listener);
        if (viewType == 0) {
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
    public static void configureMainTopRecyclerView(RecyclerView recyclerView, int viewType, List<Movie> movies, OnItemClickListener listener) {
        TopAdapter adapter = new TopAdapter(viewType, movies, listener);
        if (viewType == 0) {
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
}
