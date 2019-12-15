package com.github.rkhusainov.moviefan.presentation.common;

/**
 * Слушатель нажатий на элемент списка
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public interface OnItemClickListener {

    /**
     * @param movie_id ид фильма
     */
    void onClick(int movie_id);
}
