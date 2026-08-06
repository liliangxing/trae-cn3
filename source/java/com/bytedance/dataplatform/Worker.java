package com.bytedance.dataplatform;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Worker {
    static ScheduledExecutorService singleThreadPool = Executors.newSingleThreadScheduledExecutor();

    public static Future run(Runnable runnable) {
        return singleThreadPool.submit(runnable);
    }

    public static Future run(Runnable runnable, long ms2) {
        return singleThreadPool.schedule(runnable, ms2, TimeUnit.MILLISECONDS);
    }

    public static Future scheduleWithFixedDelay(Runnable command, long initialDelay, long delay) {
        return singleThreadPool.scheduleWithFixedDelay(command, initialDelay, delay, TimeUnit.MILLISECONDS);
    }
}
