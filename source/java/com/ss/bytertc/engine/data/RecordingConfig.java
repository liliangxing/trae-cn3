package com.ss.bytertc.engine.data;

import com.ss.bytertc.engine.type.RecordingFileType;

/* loaded from: classes7.dex */
public class RecordingConfig {
    public String dirPath;
    public RecordingFileType recordingFileType;

    public RecordingConfig(String dirPath, RecordingFileType recordingFileType) {
        RecordingFileType recordingFileType2 = RecordingFileType.MP4;
        this.dirPath = dirPath;
        this.recordingFileType = recordingFileType;
    }

    public RecordingConfig() {
        this.recordingFileType = RecordingFileType.MP4;
    }
}
