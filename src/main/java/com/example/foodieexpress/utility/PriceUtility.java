package com.example.foodieexpress.utility;

public class PriceUtility {

    // Siparişin toplam fiyatını hesaplama
    public static double calculateTotalPrice(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }

    // Ürün fiyatlarına KDV ekleme
    public static double addTax(double price) {
        double taxRate = 0.18; // %18 KDV oranı
        return price + (price * taxRate);
    }
}
