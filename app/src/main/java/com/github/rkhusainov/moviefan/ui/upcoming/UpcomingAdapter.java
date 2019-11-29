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

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolderAbs> {
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
    public UpcomingViewHolderAbs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (mItemViewType == MAIN) {
            View view = inflater.inflate(R.layout.li_movies_main_upcoming, parent, false);
            return new UpcomingMainViewHolder(view);

        } else {
            View view = inflater.inflate(R.layout.li_movies_upcoming, parent, false);
            return new UpcomingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingViewHolderAbs holder, int position) {
        Movie currentMovie = mMovies.get(position);

        // биндим общие элементы
        holder.bind(currentMovie);

        // биндим отличающиеся элементы
        if (mItemViewType == MAIN) {
            ((UpcomingMainViewHolder) holder).bind(currentMovie);
        } else {
            ((UpcomingViewHolder) holder).bind(currentMovie);
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


    abstract class UpcomingViewHolderAbs extends RecyclerView.ViewHolder {

        private TextView mTitleTextView;

        public UpcomingViewHolderAbs(@NonNull View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.tv_title);
        }

        private void bind(Movie movie) {

            mTitleTextView.setText(movie.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(movie.getId());
                }
            });
        }
    }

    class UpcomingMainViewHolder extends UpcomingViewHolderAbs {

        private ImageView mPosterImageView;
        private TextView mReleaseDateTextView;

        public UpcomingMainViewHolder(@NonNull View itemView) {
            super(itemView);

            mPosterImageView = itemView.findViewById(R.id.iv_poster);
            mReleaseDateTextView = itemView.findViewById(R.id.tv_release_date);
        }

        void bind(Movie movie) {

            Picasso.get()
                    .load(IMAGE_BASE_URL + CARD_IMAGE_SIZE + movie.getPosterPath())
                    .placeholder(R.drawable.ic_movie_placeholder)
                    .into(mPosterImageView);

            mReleaseDateTextView.setText(DateUtils.shortReleaseDateFormat(movie.getReleaseDate()));
        }
    }

    class UpcomingViewHolder extends UpcomingViewHolderAbs {

        private ImageView mPosterImageView;
        private TextView mReleaseDateTextView;
        private TextView mVoteTextView;

        public UpcomingViewHolder(@NonNull View itemView) {
            super(itemView);

            mPosterImageView = itemView.findViewById(R.id.iv_poster);
            mReleaseDateTextView = itemView.findViewById(R.id.tv_release_date);
            mVoteTextView = itemView.findViewById(R.id.tv_vote);
        }

        void bind(Movie movie) {

            Picasso.get()
                    .load(IMAGE_BASE_URL + LIST_IMAGE_SIZE + movie.getPosterPath())
                    .placeholder(R.drawable.ic_movie_placeholder)
                    .into(mPosterImageView);

            mReleaseDateTextView.setText(DateUtils.shortReleaseDateFormat(movie.getReleaseDate()));
            mVoteTextView.setText(String.valueOf(movie.getVoteAverage()));
        }
    }
}
