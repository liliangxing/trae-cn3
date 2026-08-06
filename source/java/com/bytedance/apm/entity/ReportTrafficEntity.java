package com.bytedance.apm.entity;

/* loaded from: classes3.dex */
public class ReportTrafficEntity extends TrafficLogEntity {
    private long endTime;

    public ReportTrafficEntity(long j, int i, int i2, int i3, long j2, long j3, long j4) {
        super(j, i, i2, i3, j2, j4);
        this.endTime = j3;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getStartTime() {
        return getTime();
    }
}
