package com.github.rkhusainov.moviefan.presentation.ui.upcoming.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.databinding.MainUpcomingMovieBinding;
import com.github.rkhusainov.moviefan.databinding.UpcomingMovieBinding;
import com.github.rkhusainov.moviefan.domain.model.MovieEntity;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.presentation.ui.upcoming.viewmodel.MainUpcomingMovieListItemViewModel;
import com.github.rkhusainov.moviefan.presentation.ui.upcoming.viewmodel.UpcomingMovieListItemViewModel;

import java.util.List;

/**
 * Адаптер для списка фильмов, которые скоро покажут в кинотеатрах
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class UpcomingMovieAdapter extends RecyclerView.Adapter<UpcomingMovieAdapter.UpcomingViewHolderAbs> {

    private List<MovieEntity> mMovies;
    private int mItemViewType;

    private OnItemClickListener mOnItemClickListener;

    /**
     * Конструктор для адаптера
     *
     * @param itemViewType тип ViewHolder'a
     * @param movies       список фильмов
     * @param listener     экземпляр OnItemClickListener'a
     */
    public UpcomingMovieAdapter(int itemViewType, @NonNull List<MovieEntity> movies, @NonNull OnItemClickListener listener) {
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

        MovieEntity currentMovie = mMovies.get(position);

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

    /**
     * Абстрактный ViewHolder
     */
    abstract class UpcomingViewHolderAbs extends RecyclerView.ViewHolder {

        public UpcomingViewHolderAbs(@NonNull View itemView) {
            super(itemView);
        }
    }

    /**
     * ViewHolder для списка в MainFragment
     */
    class MainUpcomingViewHolder extends UpcomingViewHolderAbs {

        private MainUpcomingMovieBinding mBinding;

        public MainUpcomingViewHolder(MainUpcomingMovieBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }

        void bind(@NonNull MovieEntity movie) {
            mBinding.setMovie(new MainUpcomingMovieListItemViewModel(movie));
            mBinding.executePendingBindings();
            mBinding.setOnItemClickListener(mOnItemClickListener);
        }
    }

    /**
     * ViewHolder для списка в UpcomingFragment
     */
    class UpcomingViewHolder extends UpcomingViewHolderAbs {

        private UpcomingMovieBinding mBinding;

        public UpcomingViewHolder(UpcomingMovieBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }

        void bind(@NonNull MovieEntity movie) {
            mBinding.setMovie(new UpcomingMovieListItemViewModel(movie));
            mBinding.executePendingBindings();
            mBinding.setOnItemClickListener(mOnItemClickListener);
        }
    }
}
