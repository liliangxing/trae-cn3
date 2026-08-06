package com.huawei.hms.opendevice;

import java.util.concurrent.ThreadFactory;

/* compiled from: AsyncThreadFactory.java */
/* renamed from: com.huawei.hms.opendevice.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ThreadFactoryC1195c implements ThreadFactory {

    /* renamed from: a */
    private final ThreadGroup f1595a;

    /* renamed from: b */
    private int f1596b = 1;

    /* renamed from: c */
    private final String f1597c;

    public ThreadFactoryC1195c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f1595a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f1597c = str + "-pool-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            this.f1596b++;
        }
        Thread thread = new Thread(this.f1595a, runnable, this.f1597c + this.f1596b, 0L);
        thread.setUncaughtExceptionHandler(null);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
