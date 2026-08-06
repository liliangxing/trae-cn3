package com.bytedance.frameworks.baselib.network.asynctask;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes2.dex */
public class NetworkAsyncTaskManager {
    private static final String TAG = "NetworkAsyncTaskManager";
    private static final ConcurrentHashMap<NetworkAsyncTaskType, NetworkAsyncTaskManager> mExecutorMap = new ConcurrentHashMap<>();
    private final ScheduledThreadPoolExecutor mExecutor;
    private final NetworkAsyncTaskType mExecutorTaskType;
    private final ConcurrentHashMap<NetworkAsyncTask, ScheduledFuture> mFutureList = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<NetworkAsyncTask, Runnable> mRunnableList = new ConcurrentHashMap<>();

    public static NetworkAsyncTaskManager inst(NetworkAsyncTaskType networkAsyncTaskType) {
        if (networkAsyncTaskType == null) {
            throw new IllegalArgumentException("unsupported async task type");
        }
        ConcurrentHashMap<NetworkAsyncTaskType, NetworkAsyncTaskManager> concurrentHashMap = mExecutorMap;
        if (concurrentHashMap.get(networkAsyncTaskType) == null) {
            synchronized (NetworkAsyncTaskManager.class) {
                if (concurrentHashMap.get(networkAsyncTaskType) == null) {
                    concurrentHashMap.put(networkAsyncTaskType, new NetworkAsyncTaskManager(networkAsyncTaskType));
                }
            }
        }
        return concurrentHashMap.get(networkAsyncTaskType);
    }

    private NetworkAsyncTaskManager(NetworkAsyncTaskType networkAsyncTaskType) {
        this.mExecutorTaskType = networkAsyncTaskType;
        this.mExecutor = new ScheduledThreadPoolExecutor(1, new NetworkThreadFactory(networkAsyncTaskType.name()));
    }

    public ConcurrentHashMap<?, ?> getRunnableList() {
        return this.mRunnableList;
    }

    public ConcurrentHashMap<?, ?> getFutureList() {
        return this.mFutureList;
    }

    public void postTask(NetworkAsyncTask networkAsyncTask) {
        ScheduledFuture<?> schedule;
        if (networkAsyncTask == null) {
            return;
        }
        networkAsyncTask.setTaskType(this.mExecutorTaskType);
        try {
            InnerRunnable innerRunnable = new InnerRunnable(networkAsyncTask);
            if (networkAsyncTask.isLoop()) {
                schedule = this.mExecutor.scheduleWithFixedDelay(innerRunnable, networkAsyncTask.getInitialDelay(), networkAsyncTask.getLoopInterval(), networkAsyncTask.getTimeUnit());
            } else {
                schedule = this.mExecutor.schedule(innerRunnable, networkAsyncTask.getInitialDelay(), networkAsyncTask.getTimeUnit());
            }
            this.mRunnableList.put(networkAsyncTask, innerRunnable);
            this.mFutureList.put(networkAsyncTask, schedule);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeTask(NetworkAsyncTask networkAsyncTask) {
        try {
            Runnable remove = this.mRunnableList.remove(networkAsyncTask);
            if (remove != null) {
                this.mExecutor.remove(remove);
            }
            ScheduledFuture remove2 = this.mFutureList.remove(networkAsyncTask);
            if (remove2 != null) {
                remove2.cancel(true);
            }
        } catch (Throwable th) {
            Logger.e(TAG, "removeTask failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class InnerRunnable implements Runnable {
        private final NetworkAsyncTask mTask;

        private InnerRunnable(NetworkAsyncTask networkAsyncTask) {
            this.mTask = networkAsyncTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.mTask.run();
                if (Logger.debug()) {
                    Logger.d(NetworkAsyncTaskManager.TAG, "Task execute time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Throwable th) {
                try {
                    Logger.e(NetworkAsyncTaskManager.TAG, "thread " + Thread.currentThread().getName() + " exception", th);
                    if (this.mTask.isLoop()) {
                    }
                } finally {
                    if (!this.mTask.isLoop()) {
                        NetworkAsyncTaskManager.inst(this.mTask.getTaskType()).getRunnableList().remove(this.mTask);
                        NetworkAsyncTaskManager.inst(this.mTask.getTaskType()).getFutureList().remove(this.mTask);
                    }
                }
            }
        }
    }
}
