package com.bytedance.geckox.task;

/* loaded from: classes3.dex */
public class HandlerTimerTaskManager {
    private final HandlerTimerTask mHandlerTimerTask;

    private HandlerTimerTaskManager() {
        this.mHandlerTimerTask = new HandlerTimerTask("gecko-timer-task", 3);
    }

    /* loaded from: classes3.dex */
    private static class SingletonHolder {
        private static HandlerTimerTaskManager instance = new HandlerTimerTaskManager();

        private SingletonHolder() {
        }
    }

    public static HandlerTimerTaskManager inst() {
        return SingletonHolder.instance;
    }

    public void schedule(HandlerTask handlerTask, long j) {
        this.mHandlerTimerTask.schedule(handlerTask, j);
    }

    public void schedule(HandlerTask handlerTask, long j, long j2) {
        this.mHandlerTimerTask.schedule(handlerTask, j, j2);
    }

    public void cancel(int i) {
        this.mHandlerTimerTask.cancel(i);
    }

    public void quit() {
        this.mHandlerTimerTask.quit();
    }
}
