package com.bytedance.apm.entity;

/* loaded from: classes3.dex */
public class TraceTimeEntity {
    public long endTimestamp;
    public long startTimestamp;
    public String threadName;

    public TraceTimeEntity(long j) {
        this.startTimestamp = j;
    }

    public void appendEndTimeAndThread(long j, String str) {
        this.endTimestamp = j;
        this.threadName = str;
    }
}
