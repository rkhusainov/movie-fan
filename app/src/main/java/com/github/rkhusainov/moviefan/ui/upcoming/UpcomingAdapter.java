package com.github.rkhusainov.moviefan.ui.upcoming;

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

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder> {
    public static final int MAIN = 0;
    public static final int UPCOMING = 1;
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String LIST_IMAGE_SIZE = "w154/";
    public static final String CARD_IMAGE_SIZE = "w342/";
    private List<Movie> mMovies = new ArrayList<>();
    private int mItemViewType;

    private OnItemClickListener mOnItemClickListener;

    public UpcomingAdapter(int viewType, OnItemClickListener onItemClickListener) {
        mItemViewType = viewType;
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public UpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        if (mItemViewType == MAIN) {
            view = inflater.inflate(R.layout.li_movies_main, parent, false);
        } else if (mItemViewType == UPCOMING) {
            view = inflater.inflate(R.layout.li_popular_movies, parent, false);
        }
        return new UpcomingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingViewHolder holder, int position) {
        Movie currentMovie = mMovies.get(position);
        holder.bind(currentMovie);
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

    class UpcomingViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPosterImageView;
        private TextView mTitleTextView;
        private TextView mYearTextView;
        private TextView mNumberTextView;
        private TextView mVoteTextView;
        private ImageView mStarImageView;

        public UpcomingViewHolder(@NonNull View itemView) {
            super(itemView);

            mPosterImageView = itemView.findViewById(R.id.iv_poster);
            mTitleTextView = itemView.findViewById(R.id.tv_title);
            mYearTextView = itemView.findViewById(R.id.tv_release_year);
            mNumberTextView = itemView.findViewById(R.id.tv_number);
            mVoteTextView = itemView.findViewById(R.id.tv_vote);
            mStarImageView = itemView.findViewById(R.id.iv_star);

            mNumberTextView.setVisibility(View.GONE);
            if (mItemViewType == MAIN) {
                mStarImageView.setVisibility(View.GONE);
                mVoteTextView.setVisibility(View.GONE);
            } else {
                mVoteTextView.setVisibility(View.VISIBLE);
            }
        }


        void bind(Movie movie) {
            if (mItemViewType == MAIN) {
                Picasso.get()
                        .load(IMAGE_BASE_URL + CARD_IMAGE_SIZE + movie.getPosterPath())
                        .into(mPosterImageView);

                mYearTextView.setText(DateUtils.shortReleaseDateFormat(movie.getReleaseDate()));
            } else if (mItemViewType == UPCOMING) {
                Picasso.get()
                        .load(IMAGE_BASE_URL + LIST_IMAGE_SIZE + movie.getPosterPath())
                        .into(mPosterImageView);

                mYearTextView.setText(DateUtils.longReleaseDateFormat(movie.getReleaseDate()));
            }

            mTitleTextView.setText(movie.getTitle());

            mNumberTextView.setText(format(getAdapterPosition() + 1));
            mVoteTextView.setText(String.valueOf(movie.getVoteAverage()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(movie.getId());
                }
            });

        }

        private String format(int position) {
            return String.format(itemView.getResources().getString(R.string.number_prefix), position);
        }
    }
}
