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

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolderAbs> {

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
    public CastViewHolderAbs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (mItemViewType == DETAIL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_cast_detail, parent, false);
            return new CastMainViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_cast, parent, false);
            return new CastViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolderAbs holder, int position) {
        Cast cast = mCasts.get(position);

        // биндим общие элементы
        holder.bind(cast);

        // биндим отличающиеся элементы
        if (mItemViewType == DETAIL) {
            ((CastMainViewHolder) holder).bind(cast);
        } else {
            ((CastViewHolder) holder).bind(cast);
        }
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

    abstract class CastViewHolderAbs extends RecyclerView.ViewHolder {

        private TextView mActorNameTextView;
        private TextView mActorCharacterTextView;

        public CastViewHolderAbs(@NonNull View itemView) {
            super(itemView);

            mActorNameTextView = itemView.findViewById(R.id.tv_actor_name);
            mActorCharacterTextView = itemView.findViewById(R.id.tv_actor_character);
        }

        private void bind(Cast cast) {
            mActorNameTextView.setText(cast.getName());
            mActorCharacterTextView.setText(cast.getCharacter());
        }
    }

    class CastMainViewHolder extends CastViewHolderAbs {

        private ImageView mActorPhotoImageView;

        public CastMainViewHolder(@NonNull View itemView) {
            super(itemView);

            mActorPhotoImageView = itemView.findViewById(R.id.iv_actor_photo);
        }

        void bind(Cast cast) {
            Picasso.get()
                    .load(IMAGE_BASE_URL + CARD_IMAGE_SIZE + cast.getProfilePath())
                    .placeholder(R.drawable.ic_actor_placeholder)
                    .into(mActorPhotoImageView);
        }
    }

    class CastViewHolder extends CastViewHolderAbs {

        private ImageView mActorPhotoImageView;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);

            mActorPhotoImageView = itemView.findViewById(R.id.iv_actor_photo);
        }

        void bind(Cast cast) {
            Picasso.get()
                    .load(IMAGE_BASE_URL + LIST_IMAGE_SIZE + cast.getProfilePath())
                    .placeholder(R.drawable.ic_actor_placeholder)
                    .into(mActorPhotoImageView);
        }
    }
}
