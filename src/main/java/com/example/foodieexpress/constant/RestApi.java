package com.example.foodieexpress.constant;

public class RestApi {

    private static final String VERSION = "/v1";
    private static final String DEVELOPER = "/dev";
    private static final String ROOT = VERSION + DEVELOPER;

    // Genel API uç noktaları
    public static final String ADMIN = ROOT + "/admin";
    public static final String USER = ROOT + "/user";

    // Kullanıcı ve Admin giriş
    public static final String ADMIN_LOGIN = ADMIN + "/login";
    public static final String USER_LOGIN = USER + "/login";

    // Kullanıcı işlemleri
    public static final String USER_REGISTER = USER + "/register";
    public static final String USER_PROFILE = USER + "/profile";

    // Restoran işlemleri
    public static final String RESTAURANT = ROOT + "/restaurant";
    public static final String RESTAURANT_LIST = RESTAURANT + "/list";
    public static final String RESTAURANT_CREATE = RESTAURANT + "/create";

    // Menü işlemleri
    public static final String MENU = ROOT + "/menu";
    public static final String MENU_LIST = MENU + "/list";
    public static final String MENU_CREATE = MENU + "/create";

    // Sipariş işlemleri
    public static final String ORDER = ROOT + "/order";
    public static final String ORDER_LIST = ORDER + "/list";
    public static final String ORDER_CREATE = ORDER + "/create";

    // Yorum işlemleri
    public static final String REVIEW = ROOT + "/review";
    public static final String REVIEW_CREATE = REVIEW + "/create";
}
