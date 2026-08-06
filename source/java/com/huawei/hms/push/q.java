package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ReceiverThreadPoolExecutor.java */
/* loaded from: classes6.dex */
public class q {
    private static final Object a = new Object();
    private static ThreadPoolExecutor b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (a) {
            threadPoolExecutor = b;
        }
        return threadPoolExecutor;
    }
}
