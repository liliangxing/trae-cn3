package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RecordingType {
    RECORD_AUDIO_ONLY(0),
    RECORD_VIDEO_ONLY(1),
    RECORD_VIDEO_AND_AUDIO(2);

    private int value;

    RecordingType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RecordingType fromId(int id) {
        for (RecordingType recordingType : values()) {
            if (recordingType.value() == id) {
                return recordingType;
            }
        }
        return null;
    }
}
