package com.example.foodieexpress.utility;

public class StringUtility {

    // String'in boş olup olmadığını kontrol etme
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // String'i büyük harfe dönüştürme
    public static String toUpperCase(String str) {
        return str != null ? str.toUpperCase() : null;
    }

    // String'i küçük harfe dönüştürme
    public static String toLowerCase(String str) {
        return str != null ? str.toLowerCase() : null;
    }
}
