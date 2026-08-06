package com.bytedance.apm6.cpu.config;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class CpuConfig {
    private static final long DEFAULT_BACK_COLLECT_INTERVAL = 600;
    private static final long DEFAULT_BACK_THREAD_INTERVAL = 600;
    private static final long DEFAULT_FRONT_COLLECT_INTERVAL = 120;
    private static final long DEFAULT_FRONT_THREAD_INTERVAL = 120;
    private static final long DEFAULT_MONITOR_INTERVAL = 1200;
    private boolean mEnableUpload = false;
    private boolean mCollectAllProcess = false;
    private long mFrontCollectInterval = 120;
    private long mBackCollectInterval = 600;
    private long mMonitorInterval = 1200;
    private long mFrontThreadCollectInterval = 120;
    private long mBackThreadCollectInterval = 600;

    public long getFrontCollectInterval() {
        return this.mFrontCollectInterval * 1000;
    }

    public void setFrontCollectInterval(long j) {
        this.mFrontCollectInterval = j;
    }

    public long getBackCollectInterval() {
        return this.mBackCollectInterval * 1000;
    }

    public void setBackCollectInterval(long j) {
        this.mBackCollectInterval = j;
    }

    public long getMonitorInterval() {
        return this.mMonitorInterval * 1000;
    }

    public void setMonitorInterval(long j) {
        this.mMonitorInterval = j;
    }

    public boolean isEnableUpload() {
        return this.mEnableUpload;
    }

    public void setEnableUpload(boolean z) {
        this.mEnableUpload = z;
    }

    public long getBackThreadCollectInterval() {
        return this.mBackThreadCollectInterval * 1000;
    }

    public void setBackThreadCollectInterval(long j) {
        this.mBackThreadCollectInterval = j;
    }

    public long getFrontThreadCollectInterval() {
        return this.mFrontThreadCollectInterval * 1000;
    }

    public void setFrontThreadCollectInterval(long j) {
        this.mFrontThreadCollectInterval = j;
    }

    public boolean isCollectAllProcess() {
        return this.mCollectAllProcess;
    }

    public void setCollectAllProcess(boolean z) {
        this.mCollectAllProcess = z;
    }

    public String toString() {
        return "CpuConfig{mEnableUpload=" + this.mEnableUpload + ", mCollectAllProcess=" + this.mCollectAllProcess + ", mFrontCollectInterval=" + this.mFrontCollectInterval + ", mBackCollectInterval=" + this.mBackCollectInterval + ", mMonitorInterval=" + this.mMonitorInterval + ", mFrontThreadCollectInterval=" + this.mFrontThreadCollectInterval + ", mBackThreadCollectInterval=" + this.mBackThreadCollectInterval + AbstractJsonLexerKt.END_OBJ;
    }
}
