package com.bytedance.common.wschannel.utils;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class WsAsyncIOTaskManager {
    private static final String TAG = "WsAsyncIOTaskManager";
    private static WsAsyncIOTaskManager sInstance;
    private ConcurrentHashMap<WsAsyncTask, ScheduledFuture> mFutureTasks = new ConcurrentHashMap<>();
    private ConcurrentHashMap<WsAsyncTask, Runnable> mRunnableTasks = new ConcurrentHashMap<>();
    private ScheduledThreadPoolExecutor mTaskExecutor = new ScheduledThreadPoolExecutor(1, new WsThreadFactory("frontier"));

    private WsAsyncIOTaskManager() {
    }

    public static WsAsyncIOTaskManager getInstance() {
        if (sInstance == null) {
            synchronized (WsAsyncIOTaskManager.class) {
                if (sInstance == null) {
                    sInstance = new WsAsyncIOTaskManager();
                }
            }
        }
        return sInstance;
    }

    public void postTask(WsAsyncTask wsAsyncTask) {
        ScheduledFuture<?> schedule;
        if (wsAsyncTask == null) {
            return;
        }
        try {
            InnerRunnable innerRunnable = new InnerRunnable(wsAsyncTask);
            if (wsAsyncTask.isLoop()) {
                schedule = this.mTaskExecutor.scheduleWithFixedDelay(innerRunnable, wsAsyncTask.getInitialDelay(), wsAsyncTask.getLoopInterval(), TimeUnit.MILLISECONDS);
            } else {
                schedule = this.mTaskExecutor.schedule(innerRunnable, wsAsyncTask.getInitialDelay(), TimeUnit.MILLISECONDS);
            }
            this.mRunnableTasks.put(wsAsyncTask, innerRunnable);
            this.mFutureTasks.put(wsAsyncTask, schedule);
        } catch (Throwable th) {
            Logger.e(TAG, "sendTask failed.", th);
        }
    }

    public void removeTask(WsAsyncTask wsAsyncTask) {
        try {
            this.mTaskExecutor.remove(this.mRunnableTasks.remove(wsAsyncTask));
            ScheduledFuture remove = this.mFutureTasks.remove(wsAsyncTask);
            if (remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            Logger.e(TAG, "removeTask failed", th);
        }
    }

    /* loaded from: classes3.dex */
    private class InnerRunnable implements Runnable {
        private WsAsyncTask task;

        private InnerRunnable(WsAsyncTask wsAsyncTask) {
            this.task = wsAsyncTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.task.run();
                if (Logger.debug()) {
                    Logger.d(WsAsyncIOTaskManager.TAG, "Task execute time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Throwable th) {
                try {
                    Logger.e(WsAsyncIOTaskManager.TAG, "thread " + Thread.currentThread().getName() + " exception", th);
                    if (this.task.isLoop()) {
                    }
                } finally {
                    if (!this.task.isLoop()) {
                        WsAsyncIOTaskManager.this.mFutureTasks.remove(this.task);
                        WsAsyncIOTaskManager.this.mRunnableTasks.remove(this.task);
                    }
                }
            }
        }
    }
}
