package com.bytedance.monitor.collector;

import android.content.Context;

/* loaded from: classes4.dex */
public interface IProfilerMonitor {
    String dumpStack(long j, long j2);

    void enableEvilMethodCollect(boolean z);

    void init(Context context, long j);

    void start();

    void stop();
}
