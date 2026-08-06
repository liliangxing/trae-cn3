package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RecordingFileType {
    AAC(0),
    MP4(1);

    private int value;

    RecordingFileType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RecordingFileType fromId(int id) {
        for (RecordingFileType recordingFileType : values()) {
            if (recordingFileType.value() == id) {
                return recordingFileType;
            }
        }
        return AAC;
    }
}
