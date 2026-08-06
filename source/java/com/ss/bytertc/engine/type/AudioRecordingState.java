package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioRecordingState {
    AUDIO_RECORDING_STATE_ERROR(0),
    AUDIO_RECORDING_STATE_PROCESSING(1),
    AUDIO_RECORDING_STATE_SUCCESS(2);

    private int value;

    AudioRecordingState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static AudioRecordingState fromId(int id) {
        for (AudioRecordingState audioRecordingState : values()) {
            if (audioRecordingState.value() == id) {
                return audioRecordingState;
            }
        }
        return AUDIO_RECORDING_STATE_ERROR;
    }
}
