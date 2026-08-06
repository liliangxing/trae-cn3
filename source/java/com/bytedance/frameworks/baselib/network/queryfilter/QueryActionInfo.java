package com.bytedance.frameworks.baselib.network.queryfilter;

/* loaded from: classes2.dex */
final class QueryActionInfo {
    private boolean mActionHit = false;
    private int mActionPriority = -1;
    private long mActionStartTime = -1;
    private long mActionEndTime = -1;

    public long getDispatchActionDuration() {
        long j = this.mActionStartTime;
        if (j < 0) {
            return -1L;
        }
        long j2 = this.mActionEndTime;
        if (j2 < 0 || j > j2) {
            return -1L;
        }
        return j2 - j;
    }

    public boolean isActionHit() {
        return this.mActionHit;
    }

    public void setActionHit(boolean z) {
        this.mActionHit = z;
    }

    public int getActionPriority() {
        return this.mActionPriority;
    }

    public void setActionPriority(int i) {
        this.mActionPriority = i;
    }

    public void setActionStartTime(long j) {
        this.mActionStartTime = j;
    }

    public void setActionEndTime(long j) {
        this.mActionEndTime = j;
    }
}
