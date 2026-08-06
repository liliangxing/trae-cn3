package com.bytedance.vcloud.strategy;

/* loaded from: classes6.dex */
public interface IAppService {
    public static final String KEY_WIFI_SIGNAL_STRENGTH = "wifi_signal_strength";
    public static final String KEY_WWAN_SIGNAL_STRENGTH = "wwan_signal_strength";
    public static final String SOURCE_ENGINE = "engine";
    public static final String SOURCE_SMART = "smart";
    public static final String SOURCE_VIDEO = "video";

    default void addGroupConfig(String str, String str2, String str3) {
    }

    String getMediaPortrait(String str, String str2, String str3);

    String getMediaPortraits(String str, String str2, String str3);

    String getPortrait(String str, String str2);

    String getPortraits(String str, String str2);
}
