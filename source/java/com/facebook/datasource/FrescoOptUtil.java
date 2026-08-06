package com.facebook.datasource;

/* loaded from: classes6.dex */
public class FrescoOptUtil {
    public static final String OPT_ON_NEW_RESULT_MSG = "opt_on_new_result_msg";
    private static boolean mBitmapPrepareToDrawForPrefetch;
    private static boolean mDownsampleEnabled;
    private static boolean mIsOptOnNewResultMsg;
    private static boolean mOptFirstAvailableCache;
    private static boolean mUseBitmapPrepareToDraw;
    private static BizOptDecider sBizOptDecider;

    /* loaded from: classes6.dex */
    public interface BizOptDecider {
        boolean isOptEnabled(String str, Object obj);
    }

    public static void setOptOnNewResultMsg(boolean z) {
        mIsOptOnNewResultMsg = z;
    }

    public static boolean isOptOnNewResultMsg() {
        return mIsOptOnNewResultMsg;
    }

    public static void setOptFirstAvailableCache(boolean z) {
        mOptFirstAvailableCache = z;
    }

    public static boolean isOptFirstAvailableCache() {
        return mOptFirstAvailableCache;
    }

    public static boolean isUseBitmapPrepareToDraw() {
        return mUseBitmapPrepareToDraw;
    }

    public static void setUseBitmapPrepareToDraw(boolean z) {
        mUseBitmapPrepareToDraw = z;
    }

    public static boolean isBitmapPrepareToDrawForPrefetch() {
        return mBitmapPrepareToDrawForPrefetch;
    }

    public static void setBitmapPrepareToDrawForPrefetch(boolean z) {
        mBitmapPrepareToDrawForPrefetch = z;
    }

    public static boolean isDownsampleEnabled() {
        return mDownsampleEnabled;
    }

    public static void setDownsampleEnabled(boolean z) {
        mDownsampleEnabled = z;
    }

    public static void setBizOptDecider(BizOptDecider bizOptDecider) {
        sBizOptDecider = bizOptDecider;
    }

    public static boolean isOptEnabledForBiz(String str, Object obj) {
        BizOptDecider bizOptDecider = sBizOptDecider;
        return bizOptDecider != null && bizOptDecider.isOptEnabled(str, obj);
    }
}
