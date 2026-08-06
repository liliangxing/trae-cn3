package com.bytedance.framwork.core.sdklib.thread;

import android.os.Message;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public class AsyncEventManager {
    public static final String ASYNC_EVENT_MANAGER_THREAD = "AsyncEventManager-Thread";
    private static long WAIT_INTERVAL = 30000;
    private ThreadWithHandler mEventHandler;
    private final Runnable mTimerRunnable;
    private volatile boolean mTimerTaskSwitchOn;
    CopyOnWriteArraySet<IMonitorTimeTask> monitorTimeTaskList;

    private AsyncEventManager() {
        this.mTimerTaskSwitchOn = true;
        this.mTimerRunnable = new Runnable() { // from class: com.bytedance.framwork.core.sdklib.thread.AsyncEventManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator<IMonitorTimeTask> it = AsyncEventManager.this.monitorTimeTaskList.iterator();
                    while (it.hasNext()) {
                        it.next().onTimeEvent(System.currentTimeMillis());
                    }
                    if (AsyncEventManager.this.mTimerTaskSwitchOn) {
                        AsyncEventManager.this.mEventHandler.postDelayed(this, AsyncEventManager.WAIT_INTERVAL);
                    }
                } catch (OutOfMemoryError unused) {
                }
            }
        };
        this.monitorTimeTaskList = new CopyOnWriteArraySet<>();
        ThreadWithHandler threadWithHandler = new ThreadWithHandler("AsyncEventManager-Thread");
        this.mEventHandler = threadWithHandler;
        threadWithHandler.start();
    }

    /* loaded from: classes2.dex */
    private static final class Holder {
        static final AsyncEventManager INSTANCE = new AsyncEventManager();

        private Holder() {
        }
    }

    public static AsyncEventManager getInstance() {
        return Holder.INSTANCE;
    }

    public void sendMessage(Message message) {
        this.mEventHandler.sendMessage(message);
    }

    public void post(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.mEventHandler.post(runnable);
    }

    public void postDelay(Runnable runnable, long j) {
        if (runnable == null) {
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
                this.monitorTimeTaskList.add(iMonitorTimeTask);
                if (this.mTimerTaskSwitchOn) {
                    this.mEventHandler.removeCallbacks(this.mTimerRunnable);
                    this.mEventHandler.postDelayed(this.mTimerRunnable, WAIT_INTERVAL);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
