package com.bytedance.frameworks.baselib.network.http.util;

import android.os.Process;
import com.bytedance.common.utility.Logger;

/* loaded from: classes2.dex */
public class ThreadFactory implements java.util.concurrent.ThreadFactory {
    private static final String TAG = "ThreadFactory";
    private final String mThreadName;

    public ThreadFactory(String str) {
        this.mThreadName = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        if (Logger.debug()) {
            Logger.d(TAG, "creating newThread " + this.mThreadName);
        }
        return new Thread(new Runnable() { // from class: com.bytedance.frameworks.baselib.network.http.util.ThreadFactory.1
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                try {
                    runnable.run();
                } catch (Throwable th) {
                    Logger.e(ThreadFactory.TAG, "WsThreadFactory error when running in thread " + ThreadFactory.this.mThreadName, th);
                }
            }
        }, this.mThreadName);
    }
}
