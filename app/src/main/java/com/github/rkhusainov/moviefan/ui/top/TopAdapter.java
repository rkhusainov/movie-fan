package com.github.rkhusainov.moviefan.ui.top;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.Movie;
import com.github.rkhusainov.moviefan.utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.TopViewHolder> {
    public static final int MAIN = 0;
    public static final int TOP = 1;
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String LIST_IMAGE_SIZE = "w154/";
    public static final String CARD_IMAGE_SIZE = "w342/";
    private List<Movie> mMovies = new ArrayList<>();
    private int mItemViewType;

    private OnItemClickListener mOnItemClickListener;

    public TopAdapter(int itemViewType, OnItemClickListener onItemClickListener) {
        mItemViewType = itemViewType;
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (mItemViewType == MAIN) {
            view = inflater.inflate(R.layout.li_movies_main, parent, false);
        } else {
            view = inflater.inflate(R.layout.li_popular_movies, parent, false);
        }
        return new TopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopViewHolder holder, int position) {
        Movie currentMovie = mMovies.get(position);
        holder.bind(currentMovie);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void addData(List<Movie> movies) {
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    class TopViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPosterImageView;
        private TextView mTitleTextView;
        private TextView mYearTextView;
        private TextView mNumberTextView;
        private TextView mVoteTextView;

        public TopViewHolder(@NonNull View itemView) {
            super(itemView);
            mPosterImageView = itemView.findViewById(R.id.iv_poster);
            mTitleTextView = itemView.findViewById(R.id.tv_title);
            mYearTextView = itemView.findViewById(R.id.tv_release_year);
            mNumberTextView = itemView.findViewById(R.id.tv_number);
            mVoteTextView = itemView.findViewById(R.id.tv_vote);

            if (mItemViewType == MAIN) {
                mYearTextView.setVisibility(View.GONE);
            } else {
                mYearTextView.setVisibility(View.VISIBLE);
            }
        }

        private void bind(Movie movie) {
            if (mItemViewType == MAIN) {
                Picasso.get()
                        .load(IMAGE_BASE_URL + CARD_IMAGE_SIZE + movie.getPosterPath())
                        .into(mPosterImageView);
            } else {
                Picasso.get()
                        .load(IMAGE_BASE_URL + LIST_IMAGE_SIZE + movie.getPosterPath())
                        .into(mPosterImageView);
            }

            mTitleTextView.setText(movie.getTitle());
            mYearTextView.setText(DateUtils.format(movie.getReleaseDate()));
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
