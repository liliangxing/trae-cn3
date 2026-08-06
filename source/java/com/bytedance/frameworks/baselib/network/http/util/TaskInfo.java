package com.bytedance.frameworks.baselib.network.http.util;

/* loaded from: classes2.dex */
public class TaskInfo {
    private volatile boolean mCanceled = false;

    public void setCanceled() {
        this.mCanceled = true;
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }
}
