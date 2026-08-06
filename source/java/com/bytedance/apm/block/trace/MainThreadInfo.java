package com.bytedance.apm.block.trace;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public class MainThreadInfo {
    private static final int DEAL_INPUT_EVENT = 0;
    private static final int INPUT_EVENT_COUNT = 1;
    private static final int NEWEST_INPUT_EVENT = 3;
    private static final int OLDEST_INPUT_EVENT = 2;
    public long[] mainThreadInfo = new long[4];
    public boolean isValid = false;

    public void reset() {
        long[] jArr = this.mainThreadInfo;
        jArr[0] = 0;
        jArr[1] = 0;
        jArr[2] = Long.MAX_VALUE;
        jArr[3] = 0;
        this.isValid = false;
    }

    public boolean isInputDelayed() {
        long[] jArr = this.mainThreadInfo;
        return jArr[0] - jArr[2] > 100;
    }

    public void addInputEventInfo(long j) {
        long[] jArr = this.mainThreadInfo;
        if (jArr[0] == 0) {
            jArr[0] = SystemClock.uptimeMillis();
        }
        long[] jArr2 = this.mainThreadInfo;
        jArr2[1] = jArr2[1] + 1;
        if (j < jArr2[2]) {
            jArr2[2] = j;
        }
        if (j > jArr2[3]) {
            jArr2[3] = j;
        }
        this.isValid = true;
    }
}
