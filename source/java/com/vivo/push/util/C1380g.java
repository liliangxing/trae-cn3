package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConcurrentUtils.java */
/* renamed from: com.vivo.push.util.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1380g {

    /* renamed from: a */
    private static final int f689a;

    /* renamed from: b */
    private static final int f690b;

    /* renamed from: c */
    private static final int f691c;

    /* renamed from: d */
    private static ExecutorService f692d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f689a = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        f690b = max;
        int i = (availableProcessors * 2) + 1;
        f691c = i;
        f692d = new ThreadPoolExecutor(max, i, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new ThreadFactoryC1381h("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());
    }

    /* renamed from: a */
    public static ExecutorService m996a() {
        return f692d;
    }
}
