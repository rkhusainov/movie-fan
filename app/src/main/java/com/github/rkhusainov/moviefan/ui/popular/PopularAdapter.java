package com.github.rkhusainov.moviefan.ui.popular;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.databinding.MainPopularMovieBinding;
import com.github.rkhusainov.moviefan.databinding.PopularMovieBinding;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolderAbs> {

    public static final int MAIN = 0;

    private List<Movie> mMovies;
    private int mItemViewType;

    private OnItemClickListener mOnItemClickListener;

    public PopularAdapter(int itemViewType, List<Movie> movies, OnItemClickListener onItemClickListener) {
        mItemViewType = itemViewType;
        mMovies = movies;
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PopularViewHolderAbs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (mItemViewType == MAIN) {
            MainPopularMovieBinding binding = MainPopularMovieBinding.inflate(inflater, parent, false);
            return new MainPopularViewHolder(binding);

        } else {
            PopularMovieBinding binding = PopularMovieBinding.inflate(inflater, parent, false);
            return new PopularViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolderAbs holder, int position) {

        Movie currentMovie = mMovies.get(position);

        // биндим отличающиеся элементы
        if (mItemViewType == MAIN) {
            ((MainPopularViewHolder) holder).bind(currentMovie);
        } else {
            ((PopularViewHolder) holder).bind(currentMovie);
        }
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }


    abstract class PopularViewHolderAbs extends RecyclerView.ViewHolder {

        public PopularViewHolderAbs(@NonNull View itemView) {
            super(itemView);
        }
    }

    class MainPopularViewHolder extends PopularViewHolderAbs {

        private MainPopularMovieBinding mMainPopularMovieBinding;

        public MainPopularViewHolder(MainPopularMovieBinding binding) {
            super(binding.getRoot());

            mMainPopularMovieBinding = binding;
        }

        private void bind(Movie movie) {

            mMainPopularMovieBinding.setMovie(new MainPopularMovieListItemViewModel(movie));
            mMainPopularMovieBinding.executePendingBindings();
            mMainPopularMovieBinding.setOnItemClickListener(mOnItemClickListener);
        }
    }

    class PopularViewHolder extends PopularViewHolderAbs {

        private PopularMovieBinding mPopularMovieBinding;

        public PopularViewHolder(PopularMovieBinding binding) {
            super(binding.getRoot());

            mPopularMovieBinding = binding;
        }

        private void bind(Movie movie) {

            mPopularMovieBinding.setMovie(new PopularMovieListItemViewModel(movie, format(getAdapterPosition() + 1)));
            mPopularMovieBinding.executePendingBindings();
            mPopularMovieBinding.setOnItemClickListener(mOnItemClickListener);
        }

        private String format(int position) {
            return String.format(itemView.getResources().getString(R.string.number_prefix), position);
        }
    }
}
