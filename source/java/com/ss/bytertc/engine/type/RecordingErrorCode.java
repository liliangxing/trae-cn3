package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RecordingErrorCode {
    RECORDING_ERROR_CODE_OK(0),
    RECORDING_ERROR_CODE_NO_PERMISSION(-1),
    RECORDING_ERROR_CODE_NOT_SUPPORT(-2),
    RECORDING_ERROR_CODE_NO_OTHER(-3);

    private int value;

    RecordingErrorCode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RecordingErrorCode fromId(int id) {
        for (RecordingErrorCode recordingErrorCode : values()) {
            if (recordingErrorCode.value() == id) {
                return recordingErrorCode;
            }
        }
        return RECORDING_ERROR_CODE_OK;
    }
}
