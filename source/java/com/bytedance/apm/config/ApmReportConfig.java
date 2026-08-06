package com.bytedance.apm.config;

import androidx.collection.SieveCacheKt;
import com.lynx.jsbridge.LynxResourceModule;

/* loaded from: classes3.dex */
public class ApmReportConfig {
    public static final int REPORT_SMALL_BATCH_ONCE_SIZE_BYTES = 512000;
    private long onceReportMaxSizeBytes;
    private int reportMode;

    public static Builder newBuilder() {
        return new Builder();
    }

    private ApmReportConfig(Builder builder) {
        this.reportMode = builder.reportMode;
        this.onceReportMaxSizeBytes = builder.onceReportMaxSizeBytes;
    }

    public int getReportMode() {
        return this.reportMode;
    }

    public long getOnceReportMaxSizeBytes() {
        return this.onceReportMaxSizeBytes;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private int reportMode = 0;
        private long onceReportMaxSizeBytes = SieveCacheKt.NodeLinkMask;

        Builder() {
        }

        public Builder setReportMode(int i) {
            this.reportMode = i;
            if (i == 1) {
                this.onceReportMaxSizeBytes = LynxResourceModule.DEFAULT_MEDIA_SIZE;
            }
            return this;
        }

        public Builder setOnceReportMaxSizeBytes(int i) {
            this.onceReportMaxSizeBytes = i;
            return this;
        }

        public ApmReportConfig build() {
            return new ApmReportConfig(this);
        }
    }
}
