package com.bytedance.platform.thread;

import android.text.TextUtils;
import com.bytedance.platform.thread.monitor.ExecuteTimeoutTask;
import com.bytedance.platform.thread.monitor.ThreadMonitor;
import com.bytedance.platform.thread.monitor.WaitTimeoutTask;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
class PlatformScheduleExecutor extends ScheduledThreadPoolExecutor implements IPoolName {
    private static final String TAG = "PlatformScheduleExecutor";
    private ThreadLocal<ExecuteTimeoutTask> mExecuteTimeoutTaskThreadLocal;
    private Map<Runnable, WaitTimeoutTask> mWaitTimeoutTaskMap;
    private String name;

    public PlatformScheduleExecutor(int i, String str) {
        super(i);
        this.mExecuteTimeoutTaskThreadLocal = new ThreadLocal<>();
        this.mWaitTimeoutTaskMap = new ConcurrentHashMap();
        this.name = str;
    }

    public PlatformScheduleExecutor(int i, ThreadFactory threadFactory, String str) {
        super(i, threadFactory);
        this.mExecuteTimeoutTaskThreadLocal = new ThreadLocal<>();
        this.mWaitTimeoutTaskMap = new ConcurrentHashMap();
        this.name = str;
    }

    public PlatformScheduleExecutor(int i, RejectedExecutionHandler rejectedExecutionHandler, String str) {
        super(i, rejectedExecutionHandler);
        this.mExecuteTimeoutTaskThreadLocal = new ThreadLocal<>();
        this.mWaitTimeoutTaskMap = new ConcurrentHashMap();
        this.name = str;
    }

    public PlatformScheduleExecutor(int i, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, String str) {
        super(i, threadFactory, rejectedExecutionHandler);
        this.mExecuteTimeoutTaskThreadLocal = new ThreadLocal<>();
        this.mWaitTimeoutTaskMap = new ConcurrentHashMap();
        this.name = str;
    }

    @Override // com.bytedance.platform.thread.IPoolName
    public String getName() {
        return !TextUtils.isEmpty(this.name) ? this.name : TAG;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ThreadMonitor.isEnable()) {
            WaitTimeoutTask waitTimeoutTask = new WaitTimeoutTask(this, runnable);
            this.mWaitTimeoutTaskMap.put(runnable, waitTimeoutTask);
            ThreadMonitor.monitorWaitTimeOut(waitTimeoutTask);
        }
        super.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (ThreadMonitor.isEnable()) {
            ThreadMonitor.removeMonitorWaitTimeOut(this.mWaitTimeoutTaskMap.remove(runnable));
            ExecuteTimeoutTask executeTimeoutTask = new ExecuteTimeoutTask(this, thread, runnable);
            this.mExecuteTimeoutTaskThreadLocal.set(executeTimeoutTask);
            ThreadMonitor.monitorExecuteTimeOut(executeTimeoutTask);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (ThreadMonitor.isEnable()) {
            ThreadMonitor.removeMonitorExecuteTimeOut(this.mExecuteTimeoutTaskThreadLocal.get());
        }
    }
}
