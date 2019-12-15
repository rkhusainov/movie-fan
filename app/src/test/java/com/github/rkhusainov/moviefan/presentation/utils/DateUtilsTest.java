package com.github.rkhusainov.moviefan.presentation.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class DateUtilsTest {

    public static final String RELEASE_DATE = "2020-01-01";
    public static final int MOVIE_RUNTIME = 130;

    @Test
    public void yearFormat() {

        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
        String formattedDate = null;
        try {
            formattedDate = newFormat.format(oldFormat.parse(RELEASE_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertEquals("2020", formattedDate);
    }

    @Test
    public void shortReleaseDateFormat() {
        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat newFormat = new SimpleDateFormat("dd MMM", Locale.getDefault());
        String formattedDate = null;
        try {
            formattedDate = newFormat.format(oldFormat.parse(RELEASE_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertEquals("01 янв", formattedDate);
    }

    @Test
    public void longReleaseDateFormat() {
        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat newFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String formattedDate = null;
        try {
            formattedDate = newFormat.format(oldFormat.parse(RELEASE_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertEquals("01 января 2020", formattedDate);
    }

    @Test
    public void runtimeFormat() {
        int hours = MOVIE_RUNTIME / 60;
        int minutes = MOVIE_RUNTIME % 60;
        String formattedRuntime = String.format(Locale.getDefault(), "%dч %02dмин", hours, minutes);
        assertEquals("2ч 10мин", formattedRuntime);
    }
}