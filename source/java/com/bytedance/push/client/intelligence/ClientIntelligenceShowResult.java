package com.bytedance.push.client.intelligence;

/* loaded from: classes4.dex */
public class ClientIntelligenceShowResult {
    public static String REASON_APP_IN_FOREGROUND = "app_in_foreground";
    public static String REASON_BACK_UP = "back up show notification";
    public static String REASON_BACK_UP_V2 = "back up show notification v2";
    public static String REASON_DEVICE_IS_SCREEN_ON = "device_is_screen_on";
    public static String REASON_NOT_ENABLE_CLIENT_INTELLIGENCE = "enableClientIntelligencePushShow is false";
    public static String REASON_NO_LEGAL_SUB_MODE = "no legal client intelligence sub mode";
    public static String REASON_REACHED_MAX_CACHE_NUMBER = "reached_max_cache_number";
    public static String REASON_SHOW_MODE_IS_INVALID = "client intelligence show mode of pushBody is invalid";
    public static String REASON_SHOW_SUB_MODE_IS_INVALID = "client intelligence show sub mode of pushBody is invalid";
    public static String REASON_SUCCESS = "success";
    public static String REASON_USE_INTELLIGENCE_IS_FALSE_ON_PUSH_BODY = "use client intelligence of pushBody is false";
    public String reason;
    public boolean successShow = true;
    public boolean showByClientIntelligence = true;
}
