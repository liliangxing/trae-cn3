package com.facebook.imagepipeline.common;

import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class SimplayerImageStrategy {
    public static final int OPTION_OPEN_LOG = 1001;
    public static final int OPTION_SKIP_POST_PROCESSOR = 1000;
    public static final int OPTION_UPLOAD_LOG = 1002;
    public static final String PARAM_IMAGE_FORMAT = "imageFormat";
    public static final String PARAM_VIEW_HEIGHT = "viewHeight";
    public static final String PARAM_VIEW_WIDTH = "viewWidth";
    public static final int PRIORITY_HIGH = 3;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MEDIUM = 2;
    public static final String RESULT_BITMAP = "bitmap";
    public static final String RESULT_PRIORITY = "priority";
    public static final String RESULT_USE_SYSTEM_API_FIRST = "useSystemApiFirst";
    public static final int STRATEGY_DECODE_BITMAP = 1;
    public static final int STRATEGY_DECODE_USE_SYSTEM_API_FIRST = 2;
    public static final String TAG = "SimplayerImageStrategy";
    private static boolean mOpenLog;
    private static boolean mUploadLog;
    private static SimplayerImageStrategy sStrategy;

    public abstract int getIntValue(int i, String str, int i2);

    public abstract JSONObject getResult(int i, String str, JSONObject jSONObject);

    public static SimplayerImageStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(SimplayerImageStrategy simplayerImageStrategy) {
        sStrategy = simplayerImageStrategy;
    }

    public static synchronized boolean isOpenLog() {
        boolean z;
        synchronized (SimplayerImageStrategy.class) {
            z = mOpenLog;
        }
        return z;
    }

    public static synchronized void setOpenLog(boolean z) {
        synchronized (SimplayerImageStrategy.class) {
            mOpenLog = z;
        }
    }

    public static synchronized boolean isUploadLog() {
        boolean z;
        synchronized (SimplayerImageStrategy.class) {
            z = mUploadLog;
        }
        return z;
    }

    public static synchronized void setUploadLog(boolean z) {
        synchronized (SimplayerImageStrategy.class) {
            mUploadLog = z;
        }
    }
}
