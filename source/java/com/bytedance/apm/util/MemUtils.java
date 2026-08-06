package com.bytedance.apm.util;

/* loaded from: classes3.dex */
public class MemUtils {
    public static long getJavaUsedMemBytes() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}
