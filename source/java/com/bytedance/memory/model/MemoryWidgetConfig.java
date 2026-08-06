package com.bytedance.memory.model;

import java.io.File;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class MemoryWidgetConfig implements Serializable {
    private static final long serialVersionUID = 2435829043493095963L;
    private DumpShrinkConfig mDumpShrinkConfig;
    private String mFilePath;
    private boolean mIsDebug;
    private ShrinkConfig mShrinkConfig;
    private boolean mClientAnalyse = false;
    private int mNumAnalyse = 200;
    private int mMemoryRate = 90;
    private int mRunStrategy = 1;
    private boolean mDeepShrink = false;

    /* loaded from: classes4.dex */
    public interface DumpShrinkConfig {
        boolean dumpAndShrinkHprof(File file);
    }

    /* loaded from: classes4.dex */
    public interface ShrinkConfig {
        boolean shrinkHprof(File file, File file2);
    }

    public void setRunStrategy(int i) {
        this.mRunStrategy = i;
    }

    public int getRunStrategy() {
        return this.mRunStrategy;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public boolean clientAnalyse() {
        return this.mClientAnalyse;
    }

    public void setClientAnalyse(boolean z) {
        this.mClientAnalyse = z;
    }

    public void setNumAnalyse(int i) {
        this.mNumAnalyse = i;
    }

    public void setMemoryRate(int i) {
        this.mMemoryRate = i;
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public int getNumAnalyse() {
        return this.mNumAnalyse;
    }

    public int getMemoryRate() {
        return this.mMemoryRate;
    }

    public ShrinkConfig getShrinkConfig() {
        return this.mShrinkConfig;
    }

    public DumpShrinkConfig getDumpAndShrinkConfig() {
        return this.mDumpShrinkConfig;
    }

    public boolean isDeepShrink() {
        return this.mDeepShrink;
    }

    public String toString() {
        return "MemoryWidgetConfig{ mIsDebug:" + this.mIsDebug + ", mClientAnalyse:" + this.mClientAnalyse + ", mMemoryRate:" + this.mMemoryRate + ", mRunStrategy:" + this.mRunStrategy + ", mFilePath:" + this.mFilePath + ", mShrinkConfig:" + this.mShrinkConfig + ", mDumpShrinkConfig:" + this.mDumpShrinkConfig + ", mDeepShrink:" + this.mDeepShrink + " }";
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* loaded from: classes4.dex */
    public static class Builder implements Serializable {
        private static final long serialVersionUID = 2629625684428405094L;
        private DumpShrinkConfig mDumpShrinkConfig;
        private String mFilePath;
        private boolean mIsDebug;
        private ShrinkConfig mShrinkConfig;
        private boolean mClientAnalyse = false;
        private int mNumAnalyse = 200;
        private int mMemoryRate = 90;
        private int mRunStrategy = 1;
        private boolean mDeepShrink = false;

        public Builder buildRunStrategy(int i) {
            this.mRunStrategy = i;
            return this;
        }

        public Builder buildClientAnalyse(boolean z) {
            this.mClientAnalyse = z;
            return this;
        }

        public Builder buildDebug(boolean z) {
            this.mIsDebug = z;
            return this;
        }

        public Builder buildFilePath(String str) {
            this.mFilePath = str;
            return this;
        }

        public Builder buildNumAnalyse(int i) {
            this.mNumAnalyse = i;
            return this;
        }

        public Builder buildMemoryRate(int i) {
            this.mMemoryRate = i;
            return this;
        }

        public Builder shrinkConfig(ShrinkConfig shrinkConfig) {
            this.mShrinkConfig = shrinkConfig;
            return this;
        }

        public Builder dumpAndShrinkConfig(DumpShrinkConfig dumpShrinkConfig) {
            this.mDumpShrinkConfig = dumpShrinkConfig;
            return this;
        }

        public Builder deepShrink(boolean z) {
            this.mDeepShrink = z;
            return this;
        }

        public MemoryWidgetConfig build() {
            MemoryWidgetConfig memoryWidgetConfig = new MemoryWidgetConfig();
            memoryWidgetConfig.mIsDebug = this.mIsDebug;
            memoryWidgetConfig.mClientAnalyse = this.mClientAnalyse;
            memoryWidgetConfig.mNumAnalyse = this.mNumAnalyse;
            memoryWidgetConfig.mMemoryRate = this.mMemoryRate;
            memoryWidgetConfig.mRunStrategy = this.mRunStrategy;
            memoryWidgetConfig.mShrinkConfig = this.mShrinkConfig;
            memoryWidgetConfig.mDumpShrinkConfig = this.mDumpShrinkConfig;
            memoryWidgetConfig.mFilePath = this.mFilePath;
            memoryWidgetConfig.mDeepShrink = this.mDeepShrink;
            return memoryWidgetConfig;
        }
    }
}
