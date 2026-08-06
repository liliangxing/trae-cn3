package com.bytedance.apm.util;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public class ThreadTimeItem {
    public long startDuration;
    public long startTime;
    public long stm;
    public int threadId;
    public String threadName;
    public long threadTime;
    public float threadUsage;
    public long utm;

    public ThreadTimeItem(int i, String str, long j) {
        this.threadId = i;
        this.threadName = str;
        this.threadTime = j;
        this.threadUsage = 0.0f;
    }

    public ThreadTimeItem(int i, String str, long j, long j2, long j3) {
        this.threadId = i;
        this.threadName = str;
        this.utm = j;
        this.stm = j2;
        this.threadTime = j + j2;
        this.startTime = j3;
        long elapsedRealtime = ((SystemClock.elapsedRealtime() * CommonMonitorUtil.getScClkTck(100L)) / 1000) - j3;
        this.startDuration = elapsedRealtime;
        this.threadUsage = (((float) this.threadTime) * 1.0f) / ((float) elapsedRealtime);
    }

    public void updateThreadTime(long j) {
        this.threadTime = j;
    }
}
