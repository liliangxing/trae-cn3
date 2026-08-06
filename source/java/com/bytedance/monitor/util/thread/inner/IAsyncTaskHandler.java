package com.bytedance.monitor.util.thread.inner;

import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.monitor.util.thread.ThreadLogListener;

/* loaded from: classes4.dex */
public interface IAsyncTaskHandler {
    boolean isPending(TaskRunnable taskRunnable);

    void post(TaskRunnable taskRunnable);

    void postDelayed(TaskRunnable taskRunnable, long j);

    void release();

    void removeTask(TaskRunnable taskRunnable);

    void scheduleWithFixedDelay(TaskRunnable taskRunnable, long j, long j2);

    void setThreadLogListener(ThreadLogListener threadLogListener);
}
