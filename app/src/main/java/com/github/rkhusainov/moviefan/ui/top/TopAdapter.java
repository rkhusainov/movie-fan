package com.github.rkhusainov.moviefan.ui.top;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.databinding.MainTopMovieBinding;
import com.github.rkhusainov.moviefan.databinding.TopMovieBinding;

import java.util.List;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.TopViewHolderAbs> {

    private List<Movie> mMovies;
    private int mItemViewType;

    private OnItemClickListener mOnItemClickListener;

    public TopAdapter(int itemViewType, List<Movie> movies, OnItemClickListener listener) {
        mItemViewType = itemViewType;
        mMovies = movies;
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public TopViewHolderAbs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (mItemViewType == Constants.MAIN) {
            MainTopMovieBinding binding = MainTopMovieBinding.inflate(inflater, parent, false);
            return new MainTopViewHolder(binding);

        } else {
            TopMovieBinding binding = TopMovieBinding.inflate(inflater, parent, false);
            return new TopViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull TopViewHolderAbs holder, int position) {

        Movie currentMovie = mMovies.get(position);

        if (mItemViewType == Constants.MAIN) {
            ((MainTopViewHolder) holder).bind(currentMovie);
        } else {
            ((TopViewHolder) holder).bind(currentMovie);
        }
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    abstract class TopViewHolderAbs extends RecyclerView.ViewHolder {

        public TopViewHolderAbs(@NonNull View itemView) {
            super(itemView);
        }
    }

    class MainTopViewHolder extends TopViewHolderAbs {

        private MainTopMovieBinding mBinding;

        public MainTopViewHolder(MainTopMovieBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }

        private void bind(Movie movie) {
            mBinding.setMovie(new MainTopMovieListItemViewModel(movie));
            mBinding.executePendingBindings();
            mBinding.setOnItemClickListener(mOnItemClickListener);
        }
    }

    class TopViewHolder extends TopViewHolderAbs {

        private TopMovieBinding mBinding;

        public TopViewHolder(TopMovieBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }

        private void bind(Movie movie) {
            mBinding.setMovie(new TopMovieListItemViewModel(movie, format(getAdapterPosition() + 1)));
            mBinding.executePendingBindings();
            mBinding.setOnItemClickListener(mOnItemClickListener);
        }

        private String format(int position) {
            return String.format(itemView.getResources().getString(R.string.number_prefix), position);
        }
    }
}
