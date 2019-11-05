package com.github.rkhusainov.moviefan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtils {
    public static String format(String oldFormatDate) {

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
}
