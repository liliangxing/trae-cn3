package com.bytedance.apm.logging;

import com.bytedance.apm6.foundation.UnSampleListener;

/* loaded from: classes3.dex */
public class ApmAlogHelper {
    private static IApmAlog sApmLogger = null;
    private static boolean sEnable = true;
    private static boolean sFeedbackALogEnabled;
    private static IApmAlog sInnerLogger;
    private static volatile UnSampleListener unSampleListener;

    public static void setEnable(boolean z) {
        sEnable = z;
    }

    public static void setFeedbackALogEnabled(boolean z) {
        sFeedbackALogEnabled = z;
    }

    public static boolean isFeedbackALogEnabled() {
        return sFeedbackALogEnabled;
    }

    public static void setApmLogger(IApmAlog iApmAlog) {
        sApmLogger = iApmAlog;
        if (iApmAlog != null) {
            sEnable = true;
        }
    }

    public static void setUnSampleListener(UnSampleListener unSampleListener2) {
        unSampleListener = unSampleListener2;
    }

    public static IApmAlog getApmLogger() {
        return sApmLogger;
    }

    public static void d(String str, String str2) {
        IApmAlog iApmAlog;
        if (!sEnable || (iApmAlog = sApmLogger) == null) {
            return;
        }
        iApmAlog.d(str, str2);
    }

    public static void e(String str, String str2) {
        IApmAlog iApmAlog;
        if (!sEnable || (iApmAlog = sApmLogger) == null) {
            return;
        }
        iApmAlog.e(str, str2);
    }

    public static void i(String str, String str2) {
        IApmAlog iApmAlog;
        if (!sEnable || (iApmAlog = sApmLogger) == null) {
            return;
        }
        iApmAlog.i(str, str2);
    }

    public static void feedbackI(String str, String str2) {
        IApmAlog iApmAlog;
        if (!sFeedbackALogEnabled || (iApmAlog = sApmLogger) == null) {
            return;
        }
        iApmAlog.i(str, str2);
    }

    public static void onUnSampleLog(String str, String str2) {
        if (unSampleListener != null) {
            unSampleListener.onLog(str, str2);
        }
    }

    public static boolean isUnSampleEnable() {
        return unSampleListener != null;
    }

    public static void setApmInnerAlog(IApmAlog iApmAlog) {
        sInnerLogger = iApmAlog;
    }

    public static IApmAlog getInnerLogger() {
        return sInnerLogger;
    }
}
