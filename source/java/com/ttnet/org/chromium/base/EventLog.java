package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: classes7.dex */
public class EventLog {
    public static void writeEvent(int i, int i2) {
        android.util.EventLog.writeEvent(i, i2);
    }
}
