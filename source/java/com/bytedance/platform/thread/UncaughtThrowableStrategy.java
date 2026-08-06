package com.bytedance.platform.thread;

import android.util.Log;

/* loaded from: classes4.dex */
public interface UncaughtThrowableStrategy {
    public static final UncaughtThrowableStrategy DEFAULT;
    public static final UncaughtThrowableStrategy IGNORE = new UncaughtThrowableStrategy() { // from class: com.bytedance.platform.thread.UncaughtThrowableStrategy.1
        @Override // com.bytedance.platform.thread.UncaughtThrowableStrategy
        public void handle(Throwable th) {
        }
    };
    public static final UncaughtThrowableStrategy LOG;
    public static final String TAG = "PlatformExecutor";
    public static final UncaughtThrowableStrategy THROW;

    void handle(Throwable th);

    static {
        UncaughtThrowableStrategy uncaughtThrowableStrategy = new UncaughtThrowableStrategy() { // from class: com.bytedance.platform.thread.UncaughtThrowableStrategy.2
            @Override // com.bytedance.platform.thread.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                if (th == null || !Log.isLoggable(UncaughtThrowableStrategy.TAG, 6)) {
                    return;
                }
                Log.e(UncaughtThrowableStrategy.TAG, "Request threw uncaught throwable", th);
            }
        };
        LOG = uncaughtThrowableStrategy;
        THROW = new UncaughtThrowableStrategy() { // from class: com.bytedance.platform.thread.UncaughtThrowableStrategy.3
            @Override // com.bytedance.platform.thread.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };
        DEFAULT = uncaughtThrowableStrategy;
    }
}
