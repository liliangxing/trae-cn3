package com.lynx.config;

import com.lynx.BuildConfig;

/* loaded from: classes6.dex */
public class LynxLiteConfigs {
    public static boolean supportCustomEmojiInInput() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean supportCustomEmojiInText() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean enablePrimJSTrail() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean enableNewGesture() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean requireQuickSharedLibrary() {
        return !BuildConfig.enable_lite.booleanValue();
    }

    public static boolean enableNewFresco() {
        return !BuildConfig.enable_lite.booleanValue();
    }
}
