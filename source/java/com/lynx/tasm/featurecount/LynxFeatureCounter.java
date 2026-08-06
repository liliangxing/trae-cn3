package com.lynx.tasm.featurecount;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxFeatureCounter {
    public static final int JAVA_ASYNC_REDIRECT = 74;
    public static final int JAVA_DISABLE_FOLDVIEW_STOP_TOUCH_STOP_FLING = 73;
    public static final int JAVA_DISABLE_REUSE_ANIMATION_STATE = 72;
    public static final int JAVA_ENABLE_ASYNC_LIST = 78;
    public static final int JAVA_ENABLE_ASYNC_REQUEST_IMAGE = 75;
    public static final int JAVA_ENABLE_FONT_SCALING = 80;
    public static final int JAVA_ENTER_TRANSITION_NAME_ANDROID = 67;
    public static final int JAVA_EXIT_TRANSITION_NAME_ANDROID = 68;
    public static final int JAVA_GET_THEME_ANDROID = 77;
    public static final int JAVA_HARDWARE_LAYER = 62;
    public static final int JAVA_LAYOUT_ANIMATION_CREATE_ANDROID = 64;
    public static final int JAVA_LAYOUT_ANIMATION_DELETE_ANDROID = 66;
    public static final int JAVA_LAYOUT_ANIMATION_UPDATE_ANDROID = 65;
    public static final int JAVA_NEW_SWIPER_NOT_ENABLED = 63;
    public static final int JAVA_PAUSE_TRANSITION_NAME_ANDROID = 69;
    public static final int JAVA_RESUME_TRANSITION_NAME_ANDROID = 70;
    public static final int JAVA_SET_THEME_ANDROID = 76;
    public static final int JAVA_UPDATE_FONT_SCALE = 71;
    public static final int JAVA_USE_LEGACY_ELEMENTS = 79;
    private static volatile boolean sEnable = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_FEATURE_COUNTER, false);
    private static volatile boolean sIsNativeLibraryLoaded;

    public static native void nativeFeatureCount(int i, int i2);

    public static void setEnable(boolean z) {
        sEnable = z;
    }

    public static void count(int i, int i2) {
        if (sEnable) {
            if (!sIsNativeLibraryLoaded) {
                sIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
            }
            if (sIsNativeLibraryLoaded) {
                nativeFeatureCount(i, i2);
            }
        }
    }
}
