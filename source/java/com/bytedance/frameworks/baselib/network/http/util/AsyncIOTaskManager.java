package com.bytedance.frameworks.baselib.network.http.util;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AsyncIOTaskManager {
    private static final String TAG = "AsyncIOTaskManager";
    private static AsyncIOTaskManager sInstance;
    private ConcurrentHashMap<AsyncTask, ScheduledFuture> mFutureTasks = new ConcurrentHashMap<>();
    private ConcurrentHashMap<AsyncTask, Runnable> mRunnableTasks = new ConcurrentHashMap<>();
    private ScheduledThreadPoolExecutor mTaskExecutor;

    private AsyncIOTaskManager() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactory("ttnet-io"));
        this.mTaskExecutor = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
    }

    public static AsyncIOTaskManager getInstance() {
        if (sInstance == null) {
            synchronized (AsyncIOTaskManager.class) {
                if (sInstance == null) {
                    sInstance = new AsyncIOTaskManager();
                }
            }
        }
        return sInstance;
    }

    public void postTask(AsyncTask asyncTask) {
        ScheduledFuture<?> schedule;
        if (asyncTask == null) {
            return;
        }
        try {
            InnerRunnable innerRunnable = new InnerRunnable(asyncTask);
            if (asyncTask.isLoop()) {
                schedule = this.mTaskExecutor.scheduleWithFixedDelay(innerRunnable, asyncTask.getInitialDelay(), asyncTask.getLoopInterval(), TimeUnit.MILLISECONDS);
            } else {
                schedule = this.mTaskExecutor.schedule(innerRunnable, asyncTask.getInitialDelay(), TimeUnit.MILLISECONDS);
            }
            this.mRunnableTasks.put(asyncTask, innerRunnable);
            this.mFutureTasks.put(asyncTask, schedule);
        } catch (Throwable th) {
            Logger.e(TAG, "sendTask failed.", th);
        }
    }

    public void removeTask(AsyncTask asyncTask) {
        try {
            this.mTaskExecutor.remove(this.mRunnableTasks.remove(asyncTask));
            ScheduledFuture remove = this.mFutureTasks.remove(asyncTask);
            if (remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            Logger.e(TAG, "removeTask failed", th);
        }
    }

    public void removeTaskById(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Iterator<Map.Entry<AsyncTask, Runnable>> it = this.mRunnableTasks.entrySet().iterator();
            while (it.hasNext()) {
                AsyncTask key = it.next().getKey();
                if (str.equals(key.getTaskIdentifier())) {
                    it.remove();
                    this.mTaskExecutor.remove(key);
                }
            }
            Iterator<Map.Entry<AsyncTask, ScheduledFuture>> it2 = this.mFutureTasks.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<AsyncTask, ScheduledFuture> next = it2.next();
                if (str.equals(next.getKey().getTaskIdentifier())) {
                    ScheduledFuture value = next.getValue();
                    if (value != null) {
                        value.cancel(true);
                    }
                    it2.remove();
                }
            }
        } catch (Throwable th) {
            Logger.e(TAG, "removeTask failed", th);
        }
    }

    /* loaded from: classes2.dex */
    private class InnerRunnable implements Runnable {
        private AsyncTask task;

        private InnerRunnable(AsyncTask asyncTask) {
            this.task = asyncTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.task.run();
                if (Logger.debug()) {
                    Logger.d(AsyncIOTaskManager.TAG, "Task execute time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Throwable th) {
                try {
                    Logger.e(AsyncIOTaskManager.TAG, "thread " + Thread.currentThread().getName() + " exception", th);
                    if (this.task.isLoop()) {
                    }
                } finally {
                    if (!this.task.isLoop()) {
                        AsyncIOTaskManager.this.mFutureTasks.remove(this.task);
                        AsyncIOTaskManager.this.mRunnableTasks.remove(this.task);
                    }
                }
            }
        }
    }
}
