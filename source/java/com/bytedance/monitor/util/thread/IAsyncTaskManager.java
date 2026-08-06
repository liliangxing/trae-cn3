package com.bytedance.monitor.util.thread;

import com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public interface IAsyncTaskManager extends IAsyncTaskHandler {

    /* loaded from: classes4.dex */
    public interface ExceptionListener {
        void directReportError(Throwable th, String str);
    }

    void directReportError(Throwable th, String str);

    ExecutorService getIOExecutor();

    ThreadLogListener getThreadLogListener();

    long getWorkThreadId(AsyncTaskType asyncTaskType);

    void setExceptionListener(ExceptionListener exceptionListener);

    void setIOExecutor(ExecutorService executorService);

    void setTaskOverTime(AsyncTaskType asyncTaskType, int i);
}
