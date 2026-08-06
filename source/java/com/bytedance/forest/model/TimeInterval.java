package com.bytedance.forest.model;

import android.os.SystemClock;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;

/* compiled from: TimeInterval.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/forest/model/TimeInterval;", "", "()V", PerfConsts.KEY_CURRENT_GALVANIC, "", "preTime", "startTime", "getTimeInterval", "getTotalTime", "updatePre", "", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class TimeInterval {
    private long current;
    private long preTime;
    private final long startTime;

    public TimeInterval() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.startTime = uptimeMillis;
        this.current = uptimeMillis;
        this.preTime = uptimeMillis;
    }

    public final long getTimeInterval() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.current = uptimeMillis;
        long j = uptimeMillis - this.preTime;
        this.preTime = uptimeMillis;
        return j;
    }

    public final long getTotalTime() {
        return SystemClock.uptimeMillis() - this.startTime;
    }

    public final void updatePre() {
        this.preTime = SystemClock.uptimeMillis();
    }
}
