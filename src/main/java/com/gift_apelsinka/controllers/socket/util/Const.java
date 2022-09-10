package com.gift_apelsinka.controllers.socket.util;

public class Const {
    public static String LINK_API = "/api";
    public static String LINK_API_V1 = LINK_API + "/v1";

    public static String TOPIC = "/topic";
    public static String NOTIFICATIONS = "notifications";
    public static String NOTIFICATIONS_TOPIC = TOPIC + "/" + NOTIFICATIONS;
    public static String LINK_CHAT = LINK_API_V1 + "/" + NOTIFICATIONS;
}
