package com.bytedance.apm6.memory.config;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public final class MemoryConfig {
    public static final double BENCHMARK_RATE = 0.8d;
    public static final long MEM_MONITOR_INTERVAL_SECONDS = 120;
    public static final double REACH_TOP_MIN_RATE = 0.5d;
    private boolean isApm6SampleEnable;
    private boolean isRealTimeMemEnable;
    private boolean isStopWhenBackground;
    private boolean isUploadEnable;
    private long memoryCollectionInterval;
    private double memoryTopCheckThreshold;

    public MemoryConfig(long j, double d, boolean z, boolean z2, boolean z3, boolean z4) {
        if (j <= 0) {
            this.memoryCollectionInterval = 120L;
        } else {
            this.memoryCollectionInterval = j;
        }
        this.memoryTopCheckThreshold = d;
        this.isApm6SampleEnable = z4;
        this.isStopWhenBackground = z;
        this.isRealTimeMemEnable = z2;
        this.isUploadEnable = z3;
    }

    public boolean isApm6SampleEnable() {
        return this.isApm6SampleEnable;
    }

    public double memoryTopCheckThreshold() {
        double d = this.memoryTopCheckThreshold;
        if (d > 0.5d) {
            return d;
        }
        return 0.8d;
    }

    public long memoryCollectionInterval() {
        return this.memoryCollectionInterval;
    }

    public boolean isStopWhenBackground() {
        return this.isStopWhenBackground;
    }

    public boolean isRealTimeMemEnable() {
        return this.isRealTimeMemEnable;
    }

    public boolean isUploadEnable() {
        return this.isUploadEnable;
    }

    public void setRealTimeMemEnable(boolean z) {
        this.isRealTimeMemEnable = z;
    }

    public void setStopWhenBackground(boolean z) {
        this.isStopWhenBackground = z;
    }

    public String toString() {
        return "MemoryConfig{memoryCollectionInterval=" + this.memoryCollectionInterval + ", memoryTopCheckThreshold=" + this.memoryTopCheckThreshold + ", isStopWhenBackground=" + this.isStopWhenBackground + ", isRealTimeMemEnable=" + this.isRealTimeMemEnable + ", isUploadEnable=" + this.isUploadEnable + ", isApm6SampleEnable=" + this.isApm6SampleEnable + AbstractJsonLexerKt.END_OBJ;
    }
}
