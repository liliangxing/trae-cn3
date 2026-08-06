package com.bytedance.apm6.fd.config;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class FdConfig {
    public static final long DEFAULT_COLLECT_INTERVAL_MINUTE = 10;
    public static final int DEFAULT_FD_COUNT_THRESHOLD = 800;
    private long collectIntervalMs;
    private long fdCountThreshold;
    private boolean isSampled;

    public FdConfig(long j, long j2, boolean z) {
        this.fdCountThreshold = j;
        this.collectIntervalMs = j2;
        this.isSampled = z;
    }

    public long getFdCountThreshold() {
        return this.fdCountThreshold;
    }

    public long getCollectIntervalMs() {
        return this.collectIntervalMs;
    }

    public boolean isSampled() {
        return this.isSampled;
    }

    public String toString() {
        return "FdConfig{fdCountThreshold=" + this.fdCountThreshold + ", collectIntervalMs=" + this.collectIntervalMs + ", isSampled=" + this.isSampled + AbstractJsonLexerKt.END_OBJ;
    }
}
