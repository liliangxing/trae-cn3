package com.bytedance.sync;

import com.bytedance.sync.logger.LogUtils;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class DelayTaskExecutor {
    private final int mMaxSize;
    private final Deque<Runnable> mPendingJobs;
    private final AtomicBoolean mPluginLaunchFlag;

    public DelayTaskExecutor() {
        this(200);
    }

    public DelayTaskExecutor(int i) {
        this.mPendingJobs = new LinkedList();
        this.mPluginLaunchFlag = new AtomicBoolean(false);
        this.mMaxSize = i;
    }

    public void runAfterReady(Runnable runnable) {
        synchronized (this) {
            if (this.mPluginLaunchFlag.get()) {
                runnable.run();
            } else if (this.mPendingJobs.size() < this.mMaxSize) {
                this.mPendingJobs.add(runnable);
            } else {
                LogUtils.e("throw task " + runnable + ", because there are too many tasks in queue");
            }
        }
    }

    public void runAfterReadyFirst(Runnable runnable) {
        synchronized (this) {
            if (this.mPluginLaunchFlag.get()) {
                runnable.run();
            } else if (this.mPendingJobs.size() < this.mMaxSize) {
                this.mPendingJobs.addFirst(runnable);
            } else {
                LogUtils.e("throw task " + runnable + ", because there are too many tasks in queue");
            }
        }
    }

    public void onReady() {
        synchronized (this) {
            this.mPluginLaunchFlag.set(true);
            while (this.mPendingJobs.size() > 0) {
                this.mPendingJobs.pop().run();
            }
        }
    }

    public boolean hasDelayTask() {
        return this.mPendingJobs.size() > 0;
    }
}
