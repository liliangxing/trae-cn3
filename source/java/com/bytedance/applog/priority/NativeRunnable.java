package com.bytedance.applog.priority;

import com.bytedance.applog.log.LoggerImpl;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class NativeRunnable implements Runnable {
    private static final List<String> loggerTags = Collections.singletonList("PriorityNativeRunnable");
    private final long nativeTaskPtr;

    public native void nativeRun(long j);

    public NativeRunnable(long j) {
        this.nativeTaskPtr = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        LoggerImpl.global().info(loggerTags, "run with native ptr: " + this.nativeTaskPtr, new Object[0]);
        nativeRun(this.nativeTaskPtr);
    }
}
