package com.bytedance.apm.block;

import android.view.FrameMetrics;

/* loaded from: classes3.dex */
public abstract class AbsLooperObserver {
    private boolean isDispatchBegin = false;

    public void doFrame(String str, long j, long j2) {
    }

    public void onFrameMetricsAvailable(String str, long j, int i) {
    }

    public void onFrameMetricsAvailable(String str, FrameMetrics frameMetrics, int i) {
    }

    public void dispatchBegin(String str) {
        this.isDispatchBegin = true;
    }

    public void dispatchEnd(long j, long j2, long j3, long j4, boolean z) {
        this.isDispatchBegin = false;
    }

    public boolean isDispatchBegin() {
        return this.isDispatchBegin;
    }
}
