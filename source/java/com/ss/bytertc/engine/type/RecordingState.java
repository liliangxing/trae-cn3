package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RecordingState {
    RECORDING_STATE_ERROE(0),
    RECORDING_STATE_PROCESSING(1),
    RECORDING_STATE_SUCCESS(2);

    private int value;

    RecordingState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RecordingState fromId(int id) {
        for (RecordingState recordingState : values()) {
            if (recordingState.value() == id) {
                return recordingState;
            }
        }
        return RECORDING_STATE_ERROE;
    }
}
