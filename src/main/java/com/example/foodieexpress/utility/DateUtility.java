package com.example.foodieexpress.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Geçerli tarihi formatlanmış olarak almak
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }

    // Belirtilen tarihe dönüştürme
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }
}
