package com.bytedance.perf.monitor;

import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.thread.ThreadWithHandler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public class AsyncEventManager {
    public static final String ASYNC_EVENT_MANAGER_THREAD = "AsyncEventManager-Thread";
    private static final long MIN_POLLING_INTERVAL_LIMIT_MS = 5000;
    public static long WAIT_INTERVAL_MS = 30000;
    private static long sPollingIntervalMs = 30000;
    private final Runnable mControlledTimerRunnable;
    private ThreadWithHandler mEventHandler;
    private volatile ExecutorService mExecutors;
    private volatile boolean mTaskSwitchOn;
    private final Runnable mTimerRunnable;
    CopyOnWriteArraySet<IMonitorTimeTask> monitorControlledTimeTaskList;
    CopyOnWriteArraySet<IMonitorTimeTask> monitorTimeTaskList;

    /* loaded from: classes4.dex */
    public interface IMonitorTimeTask {
        void onTimeEvent(long j);
    }

    private AsyncEventManager() {
        this.mTaskSwitchOn = true;
        this.mTimerRunnable = new Runnable() { // from class: com.bytedance.perf.monitor.AsyncEventManager.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator<IMonitorTimeTask> it = AsyncEventManager.this.monitorTimeTaskList.iterator();
                while (it.hasNext()) {
                    it.next().onTimeEvent(System.currentTimeMillis());
                }
                if (AsyncEventManager.this.mTaskSwitchOn) {
                    AsyncEventManager.this.mEventHandler.postDelayed(this, AsyncEventManager.WAIT_INTERVAL_MS);
                }
            }
        };
        this.mControlledTimerRunnable = new Runnable() { // from class: com.bytedance.perf.monitor.AsyncEventManager.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<IMonitorTimeTask> it = AsyncEventManager.this.monitorControlledTimeTaskList.iterator();
                while (it.hasNext()) {
                    it.next().onTimeEvent(System.currentTimeMillis());
                }
                if (AsyncEventManager.this.mTaskSwitchOn) {
                    AsyncEventManager.this.mEventHandler.postDelayed(this, AsyncEventManager.sPollingIntervalMs);
                }
            }
        };
        this.monitorTimeTaskList = new CopyOnWriteArraySet<>();
        this.monitorControlledTimeTaskList = new CopyOnWriteArraySet<>();
        ThreadWithHandler threadWithHandler = new ThreadWithHandler("AsyncEventManager-Thread");
        this.mEventHandler = threadWithHandler;
        threadWithHandler.start();
    }

    /* loaded from: classes4.dex */
    private static final class Holder {
        static final AsyncEventManager INSTANCE = new AsyncEventManager();

        private Holder() {
        }
    }

    public static AsyncEventManager getInstance() {
        return Holder.INSTANCE;
    }

    public static void setPollingIntervalMs(long j) {
        sPollingIntervalMs = Math.max(j, 5000L);
    }

    public Looper getLooper() {
        ThreadWithHandler threadWithHandler = this.mEventHandler;
        if (threadWithHandler != null) {
            return threadWithHandler.getLooper();
        }
        return null;
    }

    public void sendMessage(Message message) {
        this.mEventHandler.sendMessage(message);
    }

    public void post(Runnable runnable) {
        if (runnable == null || !this.mTaskSwitchOn) {
            return;
        }
        this.mEventHandler.post(runnable);
    }

    public void postDelay(Runnable runnable, long j) {
        if (runnable == null || !this.mTaskSwitchOn) {
            return;
        }
        this.mEventHandler.postDelayed(runnable, j);
    }

    public void removeCallbacks(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.mEventHandler.removeCallbacks(runnable);
    }

    public void addTimeTask(IMonitorTimeTask iMonitorTimeTask) {
        if (iMonitorTimeTask != null) {
            try {
                if (!this.mTaskSwitchOn || this.monitorTimeTaskList.contains(iMonitorTimeTask)) {
                    return;
                }
                this.monitorTimeTaskList.add(iMonitorTimeTask);
                this.mEventHandler.removeCallbacks(this.mTimerRunnable);
                this.mEventHandler.postDelayed(this.mTimerRunnable, WAIT_INTERVAL_MS);
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
                    this.mEventHandler.removeCallbacks(this.mControlledTimerRunnable);
                    this.mEventHandler.postDelayed(this.mControlledTimerRunnable, sPollingIntervalMs);
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
                    this.mEventHandler.removeCallbacks(this.mControlledTimerRunnable);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void stopTimer() {
        this.mTaskSwitchOn = false;
        ThreadWithHandler threadWithHandler = this.mEventHandler;
        if (threadWithHandler != null) {
            threadWithHandler.removeCallbacks(this.mTimerRunnable);
            this.mEventHandler.removeCallbacks(this.mControlledTimerRunnable);
        }
    }

    public void resumeTimer() {
        this.mTaskSwitchOn = true;
        if (this.mEventHandler != null && !this.monitorTimeTaskList.isEmpty()) {
            this.mEventHandler.removeCallbacks(this.mTimerRunnable);
            this.mEventHandler.postDelayed(this.mTimerRunnable, WAIT_INTERVAL_MS);
        }
        if (this.mEventHandler == null || this.monitorControlledTimeTaskList.isEmpty()) {
            return;
        }
        this.mEventHandler.removeCallbacks(this.mControlledTimerRunnable);
        this.mEventHandler.postDelayed(this.mControlledTimerRunnable, sPollingIntervalMs);
    }

    public void injectExecutor(ExecutorService executorService) {
        this.mExecutors = executorService;
    }

    public void submitTask(Runnable runnable) {
        if (this.mExecutors == null) {
            synchronized (this) {
                if (this.mExecutors == null) {
                    this.mExecutors = Executors.newFixedThreadPool(1, new ThreadFactory() { // from class: com.bytedance.perf.monitor.AsyncEventManager.3
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable2) {
                            return new Thread(runnable2, "Apm_Normal");
                        }
                    });
                }
            }
        }
        this.mExecutors.submit(runnable);
    }
}
