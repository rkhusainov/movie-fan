package com.github.rkhusainov.moviefan.ui.credit;

import com.github.rkhusainov.moviefan.data.model.credit.Cast;

public class CastListItemAbsViewModel {

    private int mId;
    private String mActorNameTextView;
    private String mActorCharacterTextView;

    public CastListItemAbsViewModel(Cast cast) {
        mId = cast.getId();
        mActorNameTextView = cast.getName();
        mActorCharacterTextView = cast.getCharacter();
    }

    public int getId() {
        return mId;
    }

    public String getActorNameTextView() {
        return mActorNameTextView;
    }

    public String getActorCharacterTextView() {
        return mActorCharacterTextView;
    }
}
