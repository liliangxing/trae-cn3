package com.bytedance.apm6.util.timetask;

import com.bytedance.apm6.util.TraceUtils;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class AsyncTaskManager {
    private static Map<AsyncTaskManagerType, AsyncTaskManager> map = new HashMap();
    private ScheduledThreadPoolExecutor taskExecutor;
    private ConcurrentHashMap<AsyncTask, ScheduledFuture> futureTasks = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<AsyncTask, Runnable> runnableTasks = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<AsyncTask, Runnable> pauseTasks = new ConcurrentHashMap<>();

    private AsyncTaskManager(String str) {
        this.taskExecutor = new ScheduledThreadPoolExecutor(1, new SingleThreadFactory(str));
    }

    public static synchronized AsyncTaskManager getInstance(AsyncTaskManagerType asyncTaskManagerType) {
        AsyncTaskManager asyncTaskManager;
        synchronized (AsyncTaskManager.class) {
            if (asyncTaskManagerType == null) {
                throw new IllegalArgumentException("AsyncTaskManagerType must be not null!");
            }
            asyncTaskManager = map.get(asyncTaskManagerType);
            if (asyncTaskManager == null) {
                asyncTaskManager = new AsyncTaskManager(asyncTaskManagerType.name());
                map.put(asyncTaskManagerType, asyncTaskManager);
            }
        }
        return asyncTaskManager;
    }

    public void sendTask(AsyncTask asyncTask) {
        ScheduledFuture<?> schedule;
        if (asyncTask == null) {
            return;
        }
        try {
            InnerRunnable innerRunnable = new InnerRunnable(asyncTask);
            if (asyncTask.isLoop()) {
                schedule = this.taskExecutor.scheduleWithFixedDelay(innerRunnable, asyncTask.getInitialDelay(), asyncTask.getLoopInterval(), TimeUnit.MILLISECONDS);
            } else {
                schedule = this.taskExecutor.schedule(innerRunnable, asyncTask.getInitialDelay(), TimeUnit.MILLISECONDS);
            }
            this.runnableTasks.put(asyncTask, innerRunnable);
            this.futureTasks.put(asyncTask, schedule);
        } catch (Throwable th) {
            Logger.e(Constant.TAG, "sendTask failed.", th);
        }
    }

    public void pauseLoopTasks() {
        ConcurrentHashMap<AsyncTask, Runnable> concurrentHashMap = this.runnableTasks;
        if (concurrentHashMap == null || this.futureTasks == null) {
            return;
        }
        synchronized (concurrentHashMap) {
            try {
                for (AsyncTask asyncTask : this.runnableTasks.keySet()) {
                    if (asyncTask.isLoop()) {
                        this.taskExecutor.remove(this.runnableTasks.get(asyncTask));
                        ScheduledFuture remove = this.futureTasks.remove(asyncTask);
                        if (remove != null) {
                            remove.cancel(true);
                        }
                        this.pauseTasks.put(asyncTask, this.runnableTasks.get(asyncTask));
                    }
                }
            } finally {
            }
        }
    }

    public void resumeTasks() {
        synchronized (this.pauseTasks) {
            try {
                for (AsyncTask asyncTask : this.pauseTasks.keySet()) {
                    ScheduledFuture<?> scheduleWithFixedDelay = this.taskExecutor.scheduleWithFixedDelay(this.pauseTasks.get(asyncTask), asyncTask.getInitialDelay(), asyncTask.getLoopInterval(), TimeUnit.MILLISECONDS);
                    this.runnableTasks.put(asyncTask, this.pauseTasks.get(asyncTask));
                    this.futureTasks.put(asyncTask, scheduleWithFixedDelay);
                }
                this.pauseTasks.clear();
            } finally {
            }
        }
    }

    public void removeTask(AsyncTask asyncTask) {
        try {
            Runnable remove = this.runnableTasks.remove(asyncTask);
            if (remove != null) {
                this.taskExecutor.remove(remove);
            }
            ScheduledFuture remove2 = this.futureTasks.remove(asyncTask);
            if (remove2 != null) {
                remove2.cancel(true);
            }
        } catch (Throwable th) {
            Logger.e(Constant.TAG, "removeTask failed", th);
        }
    }

    /* loaded from: classes3.dex */
    private class InnerRunnable implements Runnable {
        private AsyncTask task;

        private InnerRunnable(AsyncTask asyncTask) {
            this.task = asyncTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceUtils.beginSection("APM-Task");
            try {
                this.task.run();
            } catch (Throwable th) {
                Logger.e(Constant.TAG, "thread " + Thread.currentThread().getName() + " exception", th);
            }
            TraceUtils.endSection();
        }
    }
}
