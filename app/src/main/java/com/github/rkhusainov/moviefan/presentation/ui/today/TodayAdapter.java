package com.github.rkhusainov.moviefan.presentation.ui.today;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.databinding.MainTodayMovieBinding;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;

import java.util.List;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.MainTodayViewHolder> {

    private List<MovieEntity> mMovies;
    private OnItemClickListener mOnItemClickListener;

    public TodayAdapter(List<MovieEntity> movies, OnItemClickListener onItemClickListener) {
        mMovies = movies;
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MainTodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        MainTodayMovieBinding binding = MainTodayMovieBinding.inflate(inflater, parent, false);
        return new MainTodayViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainTodayViewHolder holder, int position) {
        MovieEntity movie = mMovies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class MainTodayViewHolder extends RecyclerView.ViewHolder {

        private MainTodayMovieBinding mMainTodayMovieBinding;

        public MainTodayViewHolder(MainTodayMovieBinding binding) {
            super(binding.getRoot());

            mMainTodayMovieBinding = binding;
        }

        private void bind(MovieEntity movie) {

            mMainTodayMovieBinding.setMovie(new MainTodayMovieListItemViewModel(movie));
            mMainTodayMovieBinding.executePendingBindings();
            mMainTodayMovieBinding.setOnItemClickListener(mOnItemClickListener);
        }
    }
}
