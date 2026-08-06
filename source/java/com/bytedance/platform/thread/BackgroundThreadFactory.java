package com.bytedance.platform.thread;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public final class BackgroundThreadFactory implements ThreadFactory {
    private static final int DEFAULT_PRIORITY = 10;
    private final String name;
    private int threadNum;
    final UncaughtThrowableStrategy uncaughtThrowableStrategy;

    public BackgroundThreadFactory(String str) {
        this(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this.name = str;
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public synchronized Thread newThread(Runnable runnable) {
        Thread thread;
        thread = new Thread(runnable, this.name + "-thread-" + this.threadNum) { // from class: com.bytedance.platform.thread.BackgroundThreadFactory.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                if (BackgroundThreadFactory.this.uncaughtThrowableStrategy != null) {
                    try {
                        super.run();
                        return;
                    } catch (Throwable th) {
                        BackgroundThreadFactory.this.uncaughtThrowableStrategy.handle(th);
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
