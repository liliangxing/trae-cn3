package com.bytedance.apm.entity;

/* loaded from: classes3.dex */
public class CpuMonitorItem {
    public long firstMonitorTime;
    public double maxCpuRate;
    public double maxStatSpeed;
    public double totalCpuRate;
    public double totalStatSpeed;
    public long totalTimes = 1;

    public CpuMonitorItem(long j, double d, double d2, double d3, double d4) {
        this.firstMonitorTime = j;
        this.maxCpuRate = d;
        this.totalCpuRate = d2;
        this.maxStatSpeed = d3;
        this.totalStatSpeed = d4;
    }

    public void reset() {
        this.firstMonitorTime = 0L;
        this.maxCpuRate = 0.0d;
        this.totalTimes = 0L;
        this.totalCpuRate = 0.0d;
        this.maxStatSpeed = 0.0d;
        this.totalStatSpeed = 0.0d;
    }
}
