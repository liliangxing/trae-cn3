package com.bytedance.platform.thread;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public final class DefaultThreadFactory implements ThreadFactory {
    private final String name;
    private int threadNum;
    final UncaughtThrowableStrategy uncaughtThrowableStrategy;

    public DefaultThreadFactory(String str) {
        this(str, null);
    }

    public DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this.name = str;
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public synchronized Thread newThread(Runnable runnable) {
        Thread thread;
        thread = new Thread(runnable, this.name + "-thread-" + this.threadNum) { // from class: com.bytedance.platform.thread.DefaultThreadFactory.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (DefaultThreadFactory.this.uncaughtThrowableStrategy != null) {
                    try {
                        super.run();
                        return;
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.uncaughtThrowableStrategy.handle(th);
                        return;
                    }
                }
                super.run();
            }
        };
        this.threadNum++;
        return thread;
    }
}
