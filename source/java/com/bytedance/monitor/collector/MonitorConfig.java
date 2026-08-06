package com.bytedance.monitor.collector;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class MonitorConfig {
    private long alogRef = 0;
    private long atraceTag;
    private boolean enableAtrace;
    private boolean enableBinder;
    private boolean enableLooperMonitor;
    private boolean enableStackSampling;
    private int runMode;

    public MonitorConfig(Builder builder) {
        this.enableAtrace = builder.enableAtrace;
        this.enableBinder = builder.enableBinder;
        this.enableLooperMonitor = builder.enableLooperMonitor;
        this.atraceTag = builder.atraceTag;
        this.runMode = builder.runMode;
        this.enableStackSampling = builder.enableStackSampling;
    }

    public boolean isEnableAtrace() {
        return this.enableAtrace;
    }

    public boolean isEnableBinder() {
        return this.enableBinder;
    }

    public boolean isEnableLooperMonitor() {
        return this.enableLooperMonitor;
    }

    public boolean isEnableStackSampling() {
        return this.enableStackSampling;
    }

    public long getAtraceTag() {
        return this.atraceTag;
    }

    public int getRunMode() {
        return this.runMode;
    }

    public long getAlogRef() {
        return this.alogRef;
    }

    public String toString() {
        return "MonitorConfig{enableAtrace=" + this.enableAtrace + ", enableBinder=" + this.enableBinder + ", enableLooperMonitor=" + this.enableLooperMonitor + ", enableStackSampling=" + this.enableStackSampling + ", atraceTag=" + this.atraceTag + ", runMode=" + this.runMode + ", alogRef=" + this.alogRef + AbstractJsonLexerKt.END_OBJ;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private long alogRef;
        private long atraceTag;
        private boolean enableAtrace;
        private boolean enableBinder;
        private boolean enableLock;
        private boolean enableLooperMonitor;
        private boolean enableStackSampling;
        private int runMode;

        @Deprecated
        public Builder enableLock(boolean z) {
            return this;
        }

        public Builder enableAtrace(boolean z) {
            this.enableAtrace = z;
            return this;
        }

        public Builder enableBinder(boolean z) {
            this.enableBinder = z;
            return this;
        }

        public Builder enableLooperMonitor(boolean z) {
            this.enableLooperMonitor = z;
            return this;
        }

        public Builder enableStackSampling(boolean z) {
            this.enableStackSampling = z;
            return this;
        }

        public Builder atraceTag(long j) {
            this.atraceTag = j;
            return this;
        }

        public Builder runMode(int i) {
            this.runMode = i;
            return this;
        }

        public Builder alogRef(long j) {
            this.alogRef = j;
            return this;
        }

        public MonitorConfig build() {
            return new MonitorConfig(this);
        }
    }
}
