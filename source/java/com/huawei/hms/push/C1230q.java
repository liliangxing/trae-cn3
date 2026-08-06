package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ReceiverThreadPoolExecutor.java */
/* renamed from: com.huawei.hms.push.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1230q {

    /* renamed from: a */
    private static final Object f1735a = new Object();

    /* renamed from: b */
    private static ThreadPoolExecutor f1736b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public static ThreadPoolExecutor m2031a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f1735a) {
            threadPoolExecutor = f1736b;
        }
        return threadPoolExecutor;
    }
}
