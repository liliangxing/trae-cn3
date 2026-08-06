package com.bytedance.monitor.util.thread;

/* loaded from: classes4.dex */
public interface TaskRunnable extends Runnable {
    String getTaskName();

    AsyncTaskType getTaskType();
}
