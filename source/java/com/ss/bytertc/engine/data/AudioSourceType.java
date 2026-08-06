package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioSourceType {
    AUDIO_SOURCE_TYPE_EXTERNAL(0),
    AUDIO_SOURCE_TYPE_INTERNAL(1);

    private int value;

    AudioSourceType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == AUDIO_SOURCE_TYPE_EXTERNAL ? "AUDIO_SOURCE_TYPE_EXTERNAL" : "AUDIO_SOURCE_TYPE_INTERNAL";
    }

    public static AudioSourceType fromId(int id) {
        for (AudioSourceType audioSourceType : values()) {
            if (audioSourceType.value() == id) {
                return audioSourceType;
            }
        }
        return null;
    }
}
