package com.bytedance.android.standard.tools.digg;

/* loaded from: classes3.dex */
public final class DiggUtils {
    private DiggUtils() {
    }

    public static int getSafeCount(boolean z, int i) {
        int max = Math.max(0, i);
        return z ? max + 1 : Math.max(0, max - 1);
    }
}
