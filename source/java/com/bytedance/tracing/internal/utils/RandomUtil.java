package com.bytedance.tracing.internal.utils;

import java.util.Random;

/* loaded from: classes5.dex */
public class RandomUtil {
    private static final ThreadLocal<Random> threadLocal = new ThreadLocal<Random>() { // from class: com.bytedance.tracing.internal.utils.RandomUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    };

    public static long uniqueId() {
        long j = 0;
        while (j == 0) {
            j = current().nextLong();
        }
        return Math.abs(j);
    }

    public static Random current() {
        return threadLocal.get();
    }
}
