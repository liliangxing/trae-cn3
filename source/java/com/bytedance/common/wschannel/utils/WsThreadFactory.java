package com.bytedance.common.wschannel.utils;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public class WsThreadFactory implements ThreadFactory {
    private static final String TAG = "WsThreadFactory";
    private final String mThreadName;

    public WsThreadFactory(String str) {
        this.mThreadName = "WsChannel-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        if (Logger.debug()) {
            Logger.d(TAG, "creating newThread " + this.mThreadName);
        }
        return new Thread(new Runnable() { // from class: com.bytedance.common.wschannel.utils.WsThreadFactory.1
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                try {
                    runnable.run();
                } catch (Throwable th) {
                    Logger.e(WsThreadFactory.TAG, "WsThreadFactory error when running in thread " + WsThreadFactory.this.mThreadName, th);
                }
            }
        }, this.mThreadName);
    }
}
