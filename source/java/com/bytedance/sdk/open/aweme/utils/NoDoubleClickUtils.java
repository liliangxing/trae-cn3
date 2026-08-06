package com.bytedance.sdk.open.aweme.utils;

import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public class NoDoubleClickUtils {
    private static final int DEFAULT_SPACE_TIME = 1200;
    private static final WeakHashMap<View, Long> lastClickTimeMap = new WeakHashMap<>();

    public static void clear() {
        lastClickTimeMap.clear();
    }

    public static boolean isDoubleClick(View view) {
        return isDoubleClick(view, 1200L);
    }

    public static boolean isDoubleClick(View view, long j) {
        if (view == null) {
            return false;
        }
        WeakHashMap<View, Long> weakHashMap = lastClickTimeMap;
        Long l = weakHashMap.get(view);
        long nanoTime = System.nanoTime() / 1000000;
        if (l == null) {
            weakHashMap.put(view, Long.valueOf(nanoTime));
            return false;
        }
        boolean z = nanoTime - l.longValue() <= j;
        if (!z) {
            weakHashMap.put(view, Long.valueOf(nanoTime));
        }
        return z;
    }
}
