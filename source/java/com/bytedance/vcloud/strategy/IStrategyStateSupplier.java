package com.bytedance.vcloud.strategy;

/* loaded from: classes6.dex */
public interface IStrategyStateSupplier {
    public static final String AUDIO_BITRATE = "audio";
    public static final String BITRATE_BEFORE_FIT_SCREEN = "bitrate_before_fit_screen";
    public static final String DOWNGRADE_TYPE = "downgrade_type";
    public static final String MAX_CACHE_BITRATE = "max_cache_bitrate";
    public static final String SR_INFO = "sr_info";
    public static final String STARTUP_AVERAGE_SPEED = "startup_average_speed";
    public static final String STARTUP_INFO = "startup_info";
    public static final String STARTUP_PREDICT_SPEED = "startup_predict_speed";
    public static final String STARTUP_SPEED = "startup_speed";
    public static final String USER_ENTER_FULL_SCREEN = "user_enter_full_screen";
    public static final String USER_QUALITY_SENSITIVITY = "user_quality_sen";
    public static final String USE_AUDIO_LABEL = "use_audio_lab";
    public static final String VIDEO_BITRATE = "video";
    public static final String VIDEO_BITRATE_ORIGIN = "video_bitrate_origin";

    default String downloadSourceJsonString(String str) {
        return null;
    }

    default double getNetworkScore() {
        return -1.0d;
    }

    double getNetworkSpeed();

    int getNetworkType();

    String mediaInfoJsonString(String str);

    default String onAfterSelect(String str, String str2, int i, Object obj) {
        return str2;
    }

    default String onBeforeSelect(String str, String str2, int i, Object obj) {
        return str2;
    }

    String selectBitrateJsonString(String str, int i);

    default String selectBitrateJsonString(String str, String str2, int i) {
        return "";
    }
}
