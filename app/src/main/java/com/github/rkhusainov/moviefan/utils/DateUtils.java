package com.github.rkhusainov.moviefan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtils {
    public static String yearFormat(String oldFormatDate) {

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

    public static String shortReleaseDateFormat(String oldFormatDate) {

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

    public static String longReleaseDateFormat(String oldFormatDate) {

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

    public static String runtimeFormat(int min) {
        int hours = min / 60;
        int minutes = min % 60;
        return String.format(Locale.getDefault(), "%dч %02dмин", hours, minutes);
    }
}
