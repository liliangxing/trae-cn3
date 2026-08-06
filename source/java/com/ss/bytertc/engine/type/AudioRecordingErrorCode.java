package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioRecordingErrorCode {
    AUDIO_RECORDING_ERROR_CODE_OK(0),
    AUDIO_RECORDING_ERROR_CODE_NO_PERMISSION(-1),
    AUDIO_RECORDING_ERROR_CODE_NOT_IN_ROOM(-2),
    AUDIO_RECORDING_ERROR_CODE_ALREADY_STARTED(-3),
    AUDIO_RECORDING_ERROR_CODE_NOT_STARTED(-4),
    AUDIO_RECORDING_ERROR_CODE_NOT_SUPPORT(-5),
    AUDIO_RECORDING_ERROR_CODE_OTHER(-6);

    private int value;

    AudioRecordingErrorCode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static AudioRecordingErrorCode fromId(int id) {
        for (AudioRecordingErrorCode audioRecordingErrorCode : values()) {
            if (audioRecordingErrorCode.value() == id) {
                return audioRecordingErrorCode;
            }
        }
        return AUDIO_RECORDING_ERROR_CODE_OTHER;
    }
}
