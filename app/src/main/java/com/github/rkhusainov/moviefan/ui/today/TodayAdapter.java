package com.github.rkhusainov.moviefan.ui.today;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.databinding.MainTodayMovieBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.TodayViewHolder> {

    private List<Movie> mMovies;

    private OnItemClickListener mOnItemClickListener;

    public TodayAdapter(List<Movie> movies, OnItemClickListener onItemClickListener) {
        mMovies = movies;
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MainTodayMovieBinding binding = MainTodayMovieBinding.inflate(inflater, parent, false);
        return new TodayViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class TodayViewHolder extends RecyclerView.ViewHolder {

        private MainTodayMovieBinding mMainTodayMovieBinding;

        public TodayViewHolder(MainTodayMovieBinding binding) {
            super(binding.getRoot());

            mMainTodayMovieBinding = binding;
        }

        private void bind(Movie movie) {

            mMainTodayMovieBinding.setMovie(new MainTodayMovieListItemViewModel(movie));
            mMainTodayMovieBinding.executePendingBindings();
            mMainTodayMovieBinding.setOnItemClickListener(mOnItemClickListener);
        }
    }
}
