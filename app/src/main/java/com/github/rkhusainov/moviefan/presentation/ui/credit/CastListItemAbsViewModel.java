package com.github.rkhusainov.moviefan.presentation.ui.credit;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;

public class CastListItemAbsViewModel {

    private int mId;
    private String mActorNameTextView;
    private String mActorCharacterTextView;

    public CastListItemAbsViewModel(CastEntity cast) {
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
