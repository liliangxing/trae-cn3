package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioDumpStatus {
    AUDIO_DUMP_START_FAILURE(0),
    AUDIO_DUMP_START_SUCCESS(1),
    AUDIO_DUMP_STOP_FAILURE(2),
    AUDIO_DUMP_STOP_SUCCESS(3),
    AUDIO_DUMP_RUNNING_FAILURE(4),
    AUDIO_DUMP_RUNNING_SUCCESS(5);

    private int value;

    AudioDumpStatus(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static AudioDumpStatus fromId(int id) {
        for (AudioDumpStatus audioDumpStatus : values()) {
            if (audioDumpStatus.value() == id) {
                return audioDumpStatus;
            }
        }
        return AUDIO_DUMP_START_FAILURE;
    }
}
