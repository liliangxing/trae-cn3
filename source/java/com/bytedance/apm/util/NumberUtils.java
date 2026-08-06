package com.bytedance.apm.util;

import java.util.Random;

/* loaded from: classes3.dex */
public class NumberUtils {
    private static Random sRandom;

    public static long safeUnbox(Long l) {
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public static String uuid() {
        if (sRandom == null) {
            sRandom = new Random(System.currentTimeMillis());
        }
        return Long.toHexString(sRandom.nextLong());
    }
}
