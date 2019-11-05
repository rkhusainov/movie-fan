package com.github.rkhusainov.moviefan.ui.popular;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.data.model.Movie;
import com.github.rkhusainov.moviefan.utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String IMAGE_SIZE = "w154/";
    private List<Movie> mMovies = new ArrayList<>();

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.li_movies, parent, false);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
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

    protected static class PopularViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPosterImageView;
        private TextView mTitleTextView;
        private TextView mYearTextView;
        private TextView mNumberTextView;
        private TextView mVoteTextView;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            mPosterImageView = itemView.findViewById(R.id.iv_poster);
            mTitleTextView = itemView.findViewById(R.id.tv_title);
            mYearTextView = itemView.findViewById(R.id.tv_release_year);
            mNumberTextView = itemView.findViewById(R.id.tv_number);
            mVoteTextView = itemView.findViewById(R.id.tv_vote);
        }

        private void bind(Movie movie) {
            Picasso.get()
                    .load(IMAGE_BASE_URL + IMAGE_SIZE + movie.getPosterPath())
                    .into(mPosterImageView);

            mTitleTextView.setText(movie.getTitle());
            mYearTextView.setText(DateUtils.format(movie.getReleaseDate()));
            mNumberTextView.setText(format(getAdapterPosition() + 1));
            mVoteTextView.setText(String.valueOf(movie.getVoteAverage()));
        }

        private String format(int position) {
            return String.format(itemView.getResources().getString(R.string.number_prefix), position);
        }
    }
}
