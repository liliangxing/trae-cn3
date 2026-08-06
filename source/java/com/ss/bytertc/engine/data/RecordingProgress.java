package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class RecordingProgress {
    public long duration;
    public long fileSize;

    public RecordingProgress(long duration, long fileSize) {
        this.duration = duration;
        this.fileSize = fileSize;
    }

    public static RecordingProgress create(long duration, long fileSize) {
        return new RecordingProgress(duration, fileSize);
    }
}
