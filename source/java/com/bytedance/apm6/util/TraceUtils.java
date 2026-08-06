package com.bytedance.apm6.util;

import android.os.Trace;

/* loaded from: classes3.dex */
public class TraceUtils {
    public static void beginSection(String str) {
        if (ApmBaseContext.isSystraceMode()) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (ApmBaseContext.isSystraceMode()) {
            Trace.endSection();
        }
    }
}
