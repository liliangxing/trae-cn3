package com.ss.ttm.player;

/* loaded from: classes7.dex */
public class TTVersion {
    public static final boolean ENABLE_AUDIO_EFFECT = false;
    public static final boolean ENABLE_BORINGSSL = true;
    public static final boolean ENABLE_EXT_LIBYUV = false;
    public static final boolean ENABLE_EXT_SSL = false;
    public static final boolean ENABLE_SHARED_FFMPEG = true;
    public static final int VERSION = 1;
    public static final String VERSION_INFO = "2026-07-21 11:58:28";
    public static final String VERSION_NAME = "2.10.272.190-trae";

    public static void saveVersionInfo() {
        TTPlayerConfiger.setValue(15, "2026-07-21 11:58:28");
        TTPlayerConfiger.setValue(13, 1);
        TTPlayerConfiger.setValue(14, "2.10.272.190-trae");
    }
}
