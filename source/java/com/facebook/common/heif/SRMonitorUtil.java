package com.facebook.common.heif;

import android.text.TextUtils;

/* loaded from: classes6.dex */
public class SRMonitorUtil {
    private static String cacheDir;
    private static int mConcurrencyLimit;
    private static int maxHeight;
    private static int maxWidth;
    private static int optimizeLevel;
    private static int stageType;
    private static boolean useOpenGL;

    public static int getStageType() {
        return stageType;
    }

    public static void setStageType(int i) {
        stageType = i;
    }

    public static int getMaxWidth() {
        return maxWidth;
    }

    public static void setMaxWidth(int i) {
        maxWidth = i;
    }

    public static int getMaxHeight() {
        return maxHeight;
    }

    public static void setMaxHeight(int i) {
        maxHeight = i;
    }

    public static int getConcurrencyLimit() {
        return mConcurrencyLimit;
    }

    public static void setConcurrencyLimit(int i) {
        mConcurrencyLimit = i;
    }

    public static boolean isUseOpenGL() {
        return useOpenGL;
    }

    public static void setUseOpenGL(boolean z) {
        useOpenGL = z;
    }

    public static int getOptimizeLevel() {
        return optimizeLevel;
    }

    public static void setOptimizeLevel(int i) {
        optimizeLevel = i;
    }

    public static String getCacheDir() {
        return TextUtils.isEmpty(cacheDir) ? "" : cacheDir;
    }

    public static void setCacheDir(String str) {
        cacheDir = str;
    }
}
