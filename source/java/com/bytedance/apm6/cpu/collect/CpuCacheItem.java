package com.bytedance.apm6.cpu.collect;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class CpuCacheItem {
    private long firstTs;
    private double metricCpuStats;
    private double metricMaxCpuStats;
    private double metricMaxRate;
    private double metricRate;
    private String sceneString;
    private int times = 0;
    private CpuDataType type;

    /* loaded from: classes3.dex */
    public enum CpuDataType {
        MIX,
        FRONT,
        BACK
    }

    public CpuCacheItem(CpuDataType cpuDataType, long j) {
        this.type = cpuDataType;
        this.firstTs = j;
    }

    public CpuCacheItem injectScene(String str) {
        this.sceneString = str;
        return this;
    }

    public CpuDataType getType() {
        return this.type;
    }

    public double getMetricRate() {
        return this.metricRate;
    }

    public double getMetricMaxRate() {
        return this.metricMaxRate;
    }

    public double getMetricCpuSpeed() {
        return this.metricCpuStats;
    }

    public double getMetricMaxCpuSpeed() {
        return this.metricMaxCpuStats;
    }

    public String getSceneString() {
        return this.sceneString;
    }

    public long getFirstTs() {
        return this.firstTs;
    }

    public int getTimes() {
        return this.times;
    }

    public void addTimes() {
        this.times++;
    }

    public void addRate(double d) {
        if (d < 0.0d) {
            return;
        }
        this.metricRate += d;
    }

    public void refreshMaxRate(double d) {
        if (this.metricMaxRate < d) {
            this.metricMaxRate = d;
        }
    }

    public void addSpeed(double d) {
        if (d < 0.0d) {
            return;
        }
        this.metricCpuStats += d;
    }

    public void refreshMaxSpeed(double d) {
        if (this.metricMaxCpuStats < d) {
            this.metricMaxCpuStats = d;
        }
    }

    public String toString() {
        return "CpuCacheItem{type=" + this.type + ", metricRate=" + this.metricRate + ", metricMaxRate=" + this.metricMaxRate + ", metricCpuStats=" + this.metricCpuStats + ", metricMaxCpuStats=" + this.metricMaxCpuStats + ", sceneString='" + this.sceneString + "', firstTs=" + this.firstTs + ", times=" + this.times + AbstractJsonLexerKt.END_OBJ;
    }
}
