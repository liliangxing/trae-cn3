package com.bytedance.applog.compress;

import java.io.Closeable;

/* loaded from: classes3.dex */
public class Utils {
    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
