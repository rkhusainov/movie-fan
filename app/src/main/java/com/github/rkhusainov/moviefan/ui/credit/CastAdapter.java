package com.github.rkhusainov.moviefan.ui.credit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.data.model.credit.Cast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    public static final int DETAIL = 0;
    public static final int CAST = 1;
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String LIST_IMAGE_SIZE = "w154/";
    public static final String CARD_IMAGE_SIZE = "w342/";

    private List<Cast> mCasts = new ArrayList<>();
    private int mItemViewType;

    public CastAdapter(int itemViewType) {
        mItemViewType = itemViewType;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (mItemViewType == DETAIL) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_cast_detail, parent, false);
        } else if (mItemViewType == CAST) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_cast, parent, false);
        }
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
        Cast cast = mCasts.get(position);
        holder.bind(cast);
    }

    @Override
    public int getItemCount() {
        return mCasts.size();
    }

    public void addData(List<Cast> casts) {
        mCasts.clear();
        mCasts.addAll(casts);
        notifyDataSetChanged();
    }

    class CastViewHolder extends RecyclerView.ViewHolder {

        private ImageView mActorPhotoImageView;
        private TextView mActorNameTextView;
        private TextView mActorCharacterTextView;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            mActorPhotoImageView = itemView.findViewById(R.id.iv_actor_photo);
            mActorNameTextView = itemView.findViewById(R.id.tv_actor_name);
            mActorCharacterTextView = itemView.findViewById(R.id.tv_actor_character);
        }

        private void bind(Cast cast) {

            if (mItemViewType == DETAIL) {
                Picasso.get()
                        .load(IMAGE_BASE_URL + CARD_IMAGE_SIZE + cast.getProfilePath())
                        .into(mActorPhotoImageView);
            } else if (mItemViewType == CAST) {
                Picasso.get()
                        .load(IMAGE_BASE_URL + LIST_IMAGE_SIZE + cast.getProfilePath())
                        .into(mActorPhotoImageView);
            }

            mActorNameTextView.setText(cast.getName());
            mActorCharacterTextView.setText(cast.getCharacter());
        }
    }
}
