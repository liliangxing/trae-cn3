package com.bytedance.platform.thread;

import android.text.TextUtils;
import com.bytedance.platform.thread.monitor.ExecuteTimeoutTask;
import com.bytedance.platform.thread.monitor.ThreadMonitor;
import com.bytedance.platform.thread.monitor.WaitTimeoutTask;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
class PlatformPoolExecutor extends ThreadPoolExecutor implements IPoolName {
    private static final String TAG = "PlatformScheduleExecutor";
    private ThreadLocal<ExecuteTimeoutTask> mExecuteTimeoutTaskThreadLocal;
    private Map<Runnable, WaitTimeoutTask> mWaitTimeoutTaskMap;
    private String name;

    public PlatformPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, String str) {
        super(i, i2, j, timeUnit, blockingQueue);
        this.mExecuteTimeoutTaskThreadLocal = new ThreadLocal<>();
        this.mWaitTimeoutTaskMap = new ConcurrentHashMap();
        this.name = str;
    }

    public PlatformPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, String str) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.mExecuteTimeoutTaskThreadLocal = new ThreadLocal<>();
        this.mWaitTimeoutTaskMap = new ConcurrentHashMap();
        this.name = str;
    }

    public PlatformPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler, String str) {
        super(i, i2, j, timeUnit, blockingQueue, rejectedExecutionHandler);
        this.mExecuteTimeoutTaskThreadLocal = new ThreadLocal<>();
        this.mWaitTimeoutTaskMap = new ConcurrentHashMap();
        this.name = str;
    }

    public PlatformPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, String str) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.mExecuteTimeoutTaskThreadLocal = new ThreadLocal<>();
        this.mWaitTimeoutTaskMap = new ConcurrentHashMap();
        this.name = str;
    }

    @Override // com.bytedance.platform.thread.IPoolName
    public String getName() {
        return !TextUtils.isEmpty(this.name) ? this.name : TAG;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
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
