package com.github.rkhusainov.moviefan.presentation.common;

/**
 * листенер нажатий на элемент списка
 */
public interface OnItemClickListener {

    /**
     * @param movie_id ид фильма
     */
    void onClick(int movie_id);
}
