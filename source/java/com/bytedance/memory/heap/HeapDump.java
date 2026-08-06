package com.bytedance.memory.heap;

import com.bytedance.memory.common.Preconditions;
import java.io.File;
import java.io.Serializable;

/* loaded from: classes4.dex */
public final class HeapDump implements Serializable {
    public boolean computeRetainedHeapSize;
    public long currentTime;
    public final long gcDurationMs;
    public final long heapDumpDurationMs;
    public File heapDumpFile;
    public long heapDumpFileSize;
    public boolean isDebug;
    public String referenceClassName;
    public final String referenceKey;
    public final String referenceName;
    public String shrinkFilePath;
    public final long watchDurationMs;

    public static Builder newBuilder() {
        return new Builder();
    }

    @Deprecated
    public HeapDump(File file, String str, String str2, long j, long j2, long j3, boolean z) {
        this(new Builder().heapDumpFile(file).referenceKey(str).referenceName(str2).debug(z).computeRetainedHeapSize(true).watchDurationMs(j).gcDurationMs(j2).heapDumpDurationMs(j3));
    }

    private HeapDump(Builder builder) {
        this.isDebug = true;
        this.computeRetainedHeapSize = true;
        this.isDebug = builder.isDebug;
        this.currentTime = builder.currentTime;
        this.heapDumpFile = builder.heapDumpFile;
        this.referenceKey = builder.referenceKey;
        this.referenceName = builder.referenceName;
        this.computeRetainedHeapSize = builder.computeRetainedHeapSize;
        this.watchDurationMs = builder.watchDurationMs;
        this.shrinkFilePath = builder.shrinkFilePath;
        this.gcDurationMs = builder.gcDurationMs;
        this.heapDumpDurationMs = builder.heapDumpDurationMs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" heapDumpFilePath ");
        sb.append(this.heapDumpFile.getPath()).append("\n heapDumpFileSize ").append(this.heapDumpFile.length()).append("\n referenceName ").append(this.referenceName).append("\n isDebug ").append(this.isDebug).append("\n currentTime ").append(this.currentTime).append("\n watchDurationMs ").append(this.watchDurationMs).append("ms\n gcDurationMs ").append(this.gcDurationMs).append("ms\n shrinkFilePath ").append(this.shrinkFilePath).append("\n heapDumpDurationMs ").append(this.heapDumpDurationMs).append("ms\n");
        return sb.toString();
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        long currentTime;
        long heapDumpFileSize;
        String referenceClassName;
        String shrinkFilePath;
        File heapDumpFile = null;
        String referenceKey = null;
        boolean isDebug = true;
        String referenceName = "";
        long watchDurationMs = 0;
        long gcDurationMs = 0;
        long heapDumpDurationMs = 0;
        boolean computeRetainedHeapSize = true;

        Builder() {
        }

        public Builder currentTime(long j) {
            this.currentTime = j;
            return this;
        }

        public Builder debug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder heapDumpFile(File file) {
            this.heapDumpFile = (File) Preconditions.checkNotNull(file, "heapDumpFile");
            return this;
        }

        public Builder shrinkFilePath(String str) {
            this.shrinkFilePath = str;
            return this;
        }

        public Builder heapDumpFileSize(long j) {
            this.heapDumpFileSize = j;
            return this;
        }

        public Builder isDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder referenceClassName(String str) {
            this.referenceClassName = (String) Preconditions.checkNotNull(str, "heapDumpFile");
            return this;
        }

        public Builder referenceKey(String str) {
            this.referenceKey = (String) Preconditions.checkNotNull(str, "referenceKey");
            return this;
        }

        public Builder referenceName(String str) {
            this.referenceName = (String) Preconditions.checkNotNull(str, "referenceName");
            return this;
        }

        public Builder watchDurationMs(long j) {
            this.watchDurationMs = j;
            return this;
        }

        public Builder gcDurationMs(long j) {
            this.gcDurationMs = j;
            return this;
        }

        public Builder heapDumpDurationMs(long j) {
            this.heapDumpDurationMs = j;
            return this;
        }

        public Builder computeRetainedHeapSize(boolean z) {
            this.computeRetainedHeapSize = z;
            return this;
        }

        public HeapDump build() {
            Preconditions.checkNotNull(this.heapDumpFile, "heapDumpFile");
            return new HeapDump(this);
        }
    }
}
