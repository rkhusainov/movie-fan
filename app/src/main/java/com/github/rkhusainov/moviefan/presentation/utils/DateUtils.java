package com.github.rkhusainov.moviefan.presentation.utils;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Утилитный класс для форматирования даты и времени
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class DateUtils {

    /**
     * Метод для получения года выхода фильма в формате "yyyy"
     *
     * @param oldFormatDate дата выхода фильма полученная от web api
     * @return отформатированная дата
     */
    public static String yearFormat(@NonNull String oldFormatDate) {

        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
        String formattedDate = null;
        try {
            formattedDate = newFormat.format(oldFormat.parse(oldFormatDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    /**
     * Метод для получения даты выхода фильма в формате "dd MMM"
     *
     * @param oldFormatDate дата выхода фильма полученная от web api
     * @return отформатированная дата
     */
    public static String shortReleaseDateFormat(@NonNull String oldFormatDate) {

        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat newFormat = new SimpleDateFormat("dd MMM", Locale.getDefault());
        String formattedDate = null;
        try {
            formattedDate = newFormat.format(oldFormat.parse(oldFormatDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    /**
     * Метод для получения даты выхода фильма в формате "dd MMMM yyyy"
     *
     * @param oldFormatDate дата выхода фильма полученная от web api
     * @return отформатированная дата
     */
    public static String longReleaseDateFormat(@NonNull String oldFormatDate) {

        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat newFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String formattedDate = null;
        try {
            formattedDate = newFormat.format(oldFormat.parse(oldFormatDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    /**
     * Метод для получения продолжительности фильма в формате "%dч %02dмин"
     *
     * @param min продолжительность фильма в минутах, полученная от web api
     * @return отформатированное время
     */
    public static String runtimeFormat(int min) {
        int hours = min / 60;
        int minutes = min % 60;
        return String.format(Locale.getDefault(), "%dч %02dмин", hours, minutes);
    }
}
