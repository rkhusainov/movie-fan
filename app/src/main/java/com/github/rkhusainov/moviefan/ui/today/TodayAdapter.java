package com.github.rkhusainov.moviefan.ui.today;

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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.TodayViewHolder> {

    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String CARD_IMAGE_SIZE = "w342/";
    private List<Movie> mMovies = new ArrayList<>();

    private OnItemClickListener mOnItemClickListener;

    public TodayAdapter(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_today, parent, false);
        return new TodayViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void addData(List<Movie> movies) {
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    class TodayViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPosterImageView;
        private TextView mTitleTextView;
        private TextView mVoteTextView;

        public TodayViewHolder(@NonNull View itemView) {
            super(itemView);

            mPosterImageView = itemView.findViewById(R.id.iv_poster);
            mTitleTextView = itemView.findViewById(R.id.tv_title);
            mVoteTextView = itemView.findViewById(R.id.tv_vote);
        }

        private void bind(Movie movie) {

            Picasso.get()
                    .load(IMAGE_BASE_URL + CARD_IMAGE_SIZE + movie.getPosterPath())
                    .into(mPosterImageView);

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
}
