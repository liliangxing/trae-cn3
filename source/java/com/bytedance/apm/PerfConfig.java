package com.bytedance.apm;

import android.util.Log;

/* loaded from: classes3.dex */
public class PerfConfig {
    static boolean reportMessage;

    public static void setReportMessage() {
        Log.e("PerfConfig", "setReportMessage set true");
        reportMessage = true;
    }

    public static boolean isReportMessage() {
        return reportMessage;
    }
}
