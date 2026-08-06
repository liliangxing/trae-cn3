package com.bytedance.crash.util;

import java.io.Closeable;

/* loaded from: classes3.dex */
public final class IoUtil {
    private IoUtil() {
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
