package com.bytedance.platform.settingsx.api.internal;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public DefaultThreadFactory(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + POOL_NUMBER.getAndIncrement() + "-Thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L) { // from class: com.bytedance.platform.settingsx.api.internal.DefaultThreadFactory.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Exception unused) {
                }
            }
        };
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
