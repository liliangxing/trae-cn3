package com.bytedance.apm6.util.timetask;

import android.os.Process;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public class SingleThreadFactory implements ThreadFactory {
    private final String threadName;

    public SingleThreadFactory(String str) {
        this.threadName = "APM6-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        if (ApmBaseContext.isDebugMode()) {
            Logger.d(Constant.TAG, "creating newThread " + this.threadName);
        }
        return new Thread(new Runnable() { // from class: com.bytedance.apm6.util.timetask.SingleThreadFactory.1
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                try {
                    runnable.run();
                } catch (Throwable th) {
                    Logger.e(Constant.TAG, "SingleThreadFactory error when running in thread " + SingleThreadFactory.this.threadName, th);
                }
            }
        }, this.threadName);
    }
}
