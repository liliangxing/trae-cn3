package com.bytedance.monitor.util.thread.inner;

import android.os.Process;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.ThreadLogListener;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public class ApmInnerThreadFactory implements ThreadFactory {
    public final String TAG = getClass().getSimpleName();
    private ThreadLogListener mLogListener;
    private IThreadIdCallback mThreadIdCallback;
    private final String mThreadName;

    /* loaded from: classes4.dex */
    public interface IThreadIdCallback {
        void onTid(long j);
    }

    public ApmInnerThreadFactory(String str) {
        this.mThreadName = "APM_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable() { // from class: com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory.1
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                if (ApmInnerThreadFactory.this.mThreadIdCallback != null) {
                    ApmInnerThreadFactory.this.mThreadIdCallback.onTid(Thread.currentThread().getId());
                }
                try {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                } catch (Throwable th) {
                    AsyncTaskUtil.getAsyncTaskManagerInstance().directReportError(th, "APM_INNER_ERROR_async_task");
                    if (ApmInnerThreadFactory.this.mLogListener != null) {
                        ApmInnerThreadFactory.this.mLogListener.onError(ApmInnerThreadFactory.this.TAG, th.getMessage());
                    }
                }
            }
        }, this.mThreadName);
    }

    public void setLogListener(ThreadLogListener threadLogListener) {
        this.mLogListener = threadLogListener;
    }

    public void setThreadIdCallback(IThreadIdCallback iThreadIdCallback) {
        this.mThreadIdCallback = iThreadIdCallback;
    }
}
