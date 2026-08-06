package com.bytedance.apm.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AsyncEventManager {
    public static long WAIT_INTERVAL_MS = 30000;
    private static long sPollingIntervalMs = 30000;
    private IAsyncTaskManager mAsyncTaskManager;
    private final TaskRunnable mControlledTimerRunnable;
    private volatile ExecutorService mExecutors;
    private volatile boolean mTaskSwitchOn;
    private final TaskRunnable mTimerRunnable;
    CopyOnWriteArraySet<IMonitorTimeTask> monitorControlledTimeTaskList;
    CopyOnWriteArraySet<IMonitorTimeTask> monitorTimeTaskList;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IMonitorTimeTask {
        void onTimeEvent(long j);
    }

    private Handler getHandler() {
        return null;
    }

    private AsyncEventManager() {
        this.mTaskSwitchOn = true;
        this.mTimerRunnable = new TaskRunnable() { // from class: com.bytedance.apm.thread.AsyncEventManager.1
            public String getTaskName() {
                return "AsyncEventManager-mTimerRunnable";
            }

            public AsyncTaskType getTaskType() {
                return AsyncTaskType.LIGHT_WEIGHT;
            }

            public void run() {
                Iterator<IMonitorTimeTask> it = AsyncEventManager.this.monitorTimeTaskList.iterator();
                while (it.hasNext()) {
                    it.next().onTimeEvent(System.currentTimeMillis());
                }
                if (AsyncEventManager.this.mTaskSwitchOn) {
                    AsyncEventManager.this.postDelay(this, AsyncEventManager.WAIT_INTERVAL_MS);
                }
            }
        };
        this.mControlledTimerRunnable = new TaskRunnable() { // from class: com.bytedance.apm.thread.AsyncEventManager.2
            public String getTaskName() {
                return "AsyncEventManager-mControlledTimerRunnable";
            }

            public AsyncTaskType getTaskType() {
                return AsyncTaskType.LIGHT_WEIGHT;
            }

            public void run() {
                Iterator<IMonitorTimeTask> it = AsyncEventManager.this.monitorControlledTimeTaskList.iterator();
                while (it.hasNext()) {
                    it.next().onTimeEvent(System.currentTimeMillis());
                }
                if (AsyncEventManager.this.mTaskSwitchOn) {
                    AsyncEventManager.this.postDelay(this, AsyncEventManager.sPollingIntervalMs);
                }
            }
        };
        this.monitorTimeTaskList = new CopyOnWriteArraySet<>();
        this.monitorControlledTimeTaskList = new CopyOnWriteArraySet<>();
        this.mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class Holder {
        static final AsyncEventManager INSTANCE = new AsyncEventManager();

        private Holder() {
        }
    }

    public static AsyncEventManager getInstance() {
        return Holder.INSTANCE;
    }

    public static void setPollingIntervalMs(long j) {
        sPollingIntervalMs = Math.max(j, ReportConsts.MIN_POLLING_INTERVAL_LIMIT_MS);
    }

    public boolean inWorkThread() {
        return this.mAsyncTaskManager != null && Thread.currentThread().getId() == this.mAsyncTaskManager.getWorkThreadId(AsyncTaskType.LIGHT_WEIGHT);
    }

    public Looper getLooper() {
        if (getHandler() != null) {
            return getHandler().getLooper();
        }
        return null;
    }

    public void sendMessage(Message message) {
        if (getHandler() != null) {
            getHandler().sendMessage(message);
        }
    }

    public void post(Runnable runnable) {
        if (this.mAsyncTaskManager == null || runnable == null || !this.mTaskSwitchOn) {
            return;
        }
        this.mAsyncTaskManager.post(wrapLightWeightTaskRunnable(runnable, "post"));
    }

    public void forcePost(Runnable runnable) {
        IAsyncTaskManager iAsyncTaskManager = this.mAsyncTaskManager;
        if (iAsyncTaskManager == null || runnable == null) {
            return;
        }
        iAsyncTaskManager.post(wrapLightWeightTaskRunnable(runnable, "post"));
    }

    public void postDelay(Runnable runnable, long j) {
        if (this.mAsyncTaskManager == null || runnable == null || !this.mTaskSwitchOn) {
            return;
        }
        this.mAsyncTaskManager.postDelayed(wrapLightWeightTaskRunnable(runnable, "postDelayed"), j);
    }

    public void postDelay(TaskRunnable taskRunnable, long j) {
        if (this.mAsyncTaskManager == null || taskRunnable == null || !this.mTaskSwitchOn) {
            return;
        }
        this.mAsyncTaskManager.postDelayed(taskRunnable, j);
    }

    public void forcePostDelay(TaskRunnable taskRunnable, long j) {
        IAsyncTaskManager iAsyncTaskManager = this.mAsyncTaskManager;
        if (iAsyncTaskManager == null || taskRunnable == null) {
            return;
        }
        iAsyncTaskManager.postDelayed(taskRunnable, j);
    }

    public void removeCallbacks(TaskRunnable taskRunnable) {
        IAsyncTaskManager iAsyncTaskManager = this.mAsyncTaskManager;
        if (iAsyncTaskManager == null || taskRunnable == null) {
            return;
        }
        iAsyncTaskManager.removeTask(taskRunnable);
    }

    public void addTimeTask(IMonitorTimeTask iMonitorTimeTask) {
        if (iMonitorTimeTask != null) {
            try {
                if (!this.mTaskSwitchOn || this.monitorTimeTaskList.contains(iMonitorTimeTask)) {
                    return;
                }
                this.monitorTimeTaskList.add(iMonitorTimeTask);
                removeCallbacks(this.mTimerRunnable);
                postDelay(this.mTimerRunnable, WAIT_INTERVAL_MS);
            } catch (Throwable unused) {
            }
        }
    }

    public void removeTimeTask(IMonitorTimeTask iMonitorTimeTask) {
        if (iMonitorTimeTask != null) {
            try {
                this.monitorTimeTaskList.remove(iMonitorTimeTask);
            } catch (Throwable unused) {
            }
        }
    }

    public void addControlledTimeTask(IMonitorTimeTask iMonitorTimeTask) {
        if (iMonitorTimeTask != null) {
            try {
                if (this.mTaskSwitchOn) {
                    this.monitorControlledTimeTaskList.add(iMonitorTimeTask);
                    removeCallbacks(this.mControlledTimerRunnable);
                    postDelay(this.mControlledTimerRunnable, sPollingIntervalMs);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void removeControlledTimeTask(IMonitorTimeTask iMonitorTimeTask) {
        if (iMonitorTimeTask != null) {
            try {
                this.monitorControlledTimeTaskList.remove(iMonitorTimeTask);
                if (this.monitorControlledTimeTaskList.isEmpty()) {
                    removeCallbacks(this.mControlledTimerRunnable);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void stopTimer() {
        this.mTaskSwitchOn = false;
        removeCallbacks(this.mTimerRunnable);
        removeCallbacks(this.mControlledTimerRunnable);
    }

    public void resumeTimer() {
        this.mTaskSwitchOn = true;
        if (!this.monitorTimeTaskList.isEmpty()) {
            removeCallbacks(this.mTimerRunnable);
            postDelay(this.mTimerRunnable, WAIT_INTERVAL_MS);
        }
        if (this.monitorControlledTimeTaskList.isEmpty()) {
            return;
        }
        removeCallbacks(this.mControlledTimerRunnable);
        postDelay(this.mControlledTimerRunnable, sPollingIntervalMs);
    }

    public void injectExecutor(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        synchronized (this) {
            this.mExecutors = executorService;
            IAsyncTaskManager iAsyncTaskManager = this.mAsyncTaskManager;
            if (iAsyncTaskManager != null) {
                iAsyncTaskManager.setIOExecutor(executorService);
            }
        }
    }

    public void submitTask(Runnable runnable) {
        if (this.mExecutors == null) {
            synchronized (this) {
                if (this.mExecutors == null) {
                    IAsyncTaskManager iAsyncTaskManager = this.mAsyncTaskManager;
                    if (iAsyncTaskManager != null) {
                        this.mExecutors = iAsyncTaskManager.getIOExecutor();
                    } else {
                        this.mExecutors = Executors.newFixedThreadPool(1, new ThreadFactory() { // from class: com.bytedance.apm.thread.AsyncEventManager.3
                            @Override // java.util.concurrent.ThreadFactory
                            public Thread newThread(Runnable runnable2) {
                                return new Thread(runnable2, "Apm_Normal");
                            }
                        });
                    }
                }
            }
        }
        this.mExecutors.submit(runnable);
    }

    private TaskRunnable wrapLightWeightTaskRunnable(Runnable runnable, String str) {
        return AsyncTaskUtil.wrapLightWeightTask("AsyncEventManager-" + str, runnable);
    }
}
