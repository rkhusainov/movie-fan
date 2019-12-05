package com.github.rkhusainov.moviefan.ui.upcoming;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.databinding.MainUpcomingMovieBinding;
import com.github.rkhusainov.moviefan.databinding.UpcomingMovieBinding;

import java.util.List;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolderAbs> {

    private List<Movie> mMovies;
    private int mItemViewType;

    private OnItemClickListener mOnItemClickListener;

    public UpcomingAdapter(int itemViewType, List<Movie> movies, OnItemClickListener listener) {
        mItemViewType = itemViewType;
        mMovies = movies;
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public UpcomingViewHolderAbs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (mItemViewType == Constants.MAIN) {
            MainUpcomingMovieBinding binding = MainUpcomingMovieBinding.inflate(inflater, parent, false);
            return new MainUpcomingViewHolder(binding);

        } else {
            UpcomingMovieBinding binding = UpcomingMovieBinding.inflate(inflater, parent, false);
            return new UpcomingViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingViewHolderAbs holder, int position) {

        Movie currentMovie = mMovies.get(position);

        if (mItemViewType == Constants.MAIN) {
            ((MainUpcomingViewHolder) holder).bind(currentMovie);
        } else {
            ((UpcomingViewHolder) holder).bind(currentMovie);
        }
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }


    abstract class UpcomingViewHolderAbs extends RecyclerView.ViewHolder {

        public UpcomingViewHolderAbs(@NonNull View itemView) {
            super(itemView);
        }
    }

    class MainUpcomingViewHolder extends UpcomingViewHolderAbs {

        private MainUpcomingMovieBinding mBinding;

        public MainUpcomingViewHolder(MainUpcomingMovieBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }

        void bind(Movie movie) {
            mBinding.setMovie(new MainUpcomingMovieListItemViewModel(movie));
            mBinding.executePendingBindings();
            mBinding.setOnItemClickListener(mOnItemClickListener);
        }
    }

    class UpcomingViewHolder extends UpcomingViewHolderAbs {

        private UpcomingMovieBinding mBinding;

        public UpcomingViewHolder(UpcomingMovieBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }

        void bind(Movie movie) {
            mBinding.setMovie(new UpcomingMovieListItemViewModel(movie));
            mBinding.executePendingBindings();
            mBinding.setOnItemClickListener(mOnItemClickListener);
        }
    }
}
