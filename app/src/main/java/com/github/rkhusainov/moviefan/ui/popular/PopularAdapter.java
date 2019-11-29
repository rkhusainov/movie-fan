package com.github.rkhusainov.moviefan.ui.popular;

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
import com.github.rkhusainov.moviefan.utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolderAbs> {

    public static final int MAIN = 0;
    public static final int POPULAR = 1;
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String LIST_IMAGE_SIZE = "w154/";
    public static final String CARD_IMAGE_SIZE = "w342/";
    private List<Movie> mMovies = new ArrayList<>();
    private int mItemViewType;

    private OnItemClickListener mOnItemClickListener;

    public PopularAdapter(int itemViewType, OnItemClickListener onItemClickListener) {
        mItemViewType = itemViewType;
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PopularViewHolderAbs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (mItemViewType == MAIN) {
            View view = inflater.inflate(R.layout.li_movies_main_top, parent, false);
            return new PopularMainViewHolder(view);

        } else {
            View view = inflater.inflate(R.layout.li_movies_top, parent, false);
            return new PopularViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolderAbs holder, int position) {
        Movie currentMovie = mMovies.get(position);

        // биндим общие элементы
        holder.bind(currentMovie);

        // биндим отличающиеся элементы
        if (mItemViewType == MAIN) {
            ((PopularMainViewHolder) holder).bind(currentMovie);
        } else {
            ((PopularViewHolder) holder).bind(currentMovie);
        }
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void addData(List<Movie> movies) {
        mMovies.clear();
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    abstract class PopularViewHolderAbs extends RecyclerView.ViewHolder {

        private TextView mTitleTextView;
        private TextView mVoteTextView;

        public PopularViewHolderAbs(@NonNull View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.tv_title);
            mVoteTextView = itemView.findViewById(R.id.tv_vote);
        }

        private void bind(Movie movie) {
            mTitleTextView.setText(movie.getTitle());
            mVoteTextView.setText(String.valueOf(movie.getVoteAverage()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(movie.getId());
                }
            });
        }
    }

    class PopularMainViewHolder extends PopularViewHolderAbs {

        private ImageView mPosterImageView;

        public PopularMainViewHolder(@NonNull View itemView) {
            super(itemView);

            mPosterImageView = itemView.findViewById(R.id.iv_poster);
        }

        private void bind(Movie movie) {
            Picasso.get().
                    load(IMAGE_BASE_URL + CARD_IMAGE_SIZE + movie.getPosterPath())
                    .placeholder(R.drawable.ic_movie_placeholder)
                    .into(mPosterImageView);
        }
    }

    class PopularViewHolder extends PopularViewHolderAbs {

        private ImageView mPosterImageView;
        private TextView mYearTextView;
        private TextView mNumberTextView;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            mPosterImageView = itemView.findViewById(R.id.iv_poster);
            mYearTextView = itemView.findViewById(R.id.tv_release_year);
            mNumberTextView = itemView.findViewById(R.id.tv_number);
        }

        private void bind(Movie movie) {
            Picasso.get().
                    load(IMAGE_BASE_URL + LIST_IMAGE_SIZE + movie.getPosterPath())
                    .placeholder(R.drawable.ic_movie_placeholder)
                    .into(mPosterImageView);

            mYearTextView.setText(DateUtils.yearFormat(movie.getReleaseDate()));
            mNumberTextView.setText(format(getAdapterPosition() + 1));
        }

        private String format(int position) {
            return String.format(itemView.getResources().getString(R.string.number_prefix), position);
        }
    }
}
