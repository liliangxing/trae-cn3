package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConcurrentUtils.java */
/* loaded from: classes7.dex */
public final class g {
    private static final int a;
    private static final int b;
    private static final int c;
    private static ExecutorService d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        b = max;
        int i = (availableProcessors * 2) + 1;
        c = i;
        d = new ThreadPoolExecutor(max, i, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new h("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService a() {
        return d;
    }
}
