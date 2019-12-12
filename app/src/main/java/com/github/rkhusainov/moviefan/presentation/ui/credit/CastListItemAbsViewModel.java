package com.github.rkhusainov.moviefan.presentation.ui.credit;

import androidx.annotation.NonNull;

import com.github.rkhusainov.moviefan.domain.model.CastEntity;

public class CastListItemAbsViewModel {

    private int mId;
    private String mActorNameTextView;
    private String mActorCharacterTextView;

    /**
     * @param cast данные текущего актёра
     */
    public CastListItemAbsViewModel(@NonNull CastEntity cast) {
        mId = cast.getId();
        mActorNameTextView = cast.getName();
        mActorCharacterTextView = cast.getCharacter();
    }

    /**
     * Getter для ид фильма
     */
    public int getId() {
        return mId;
    }

    /**
     * Getter для строки с ФИО актёра
     */
    @NonNull
    public String getActorNameTextView() {
        return mActorNameTextView;
    }

    /**
     * Getter для строки с ролью актёра
     */
    @NonNull
    public String getActorCharacterTextView() {
        return mActorCharacterTextView;
    }
}
