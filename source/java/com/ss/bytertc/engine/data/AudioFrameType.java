package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioFrameType {
    FRAME_TYPE_PCM16(0);

    private int value;

    AudioFrameType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == FRAME_TYPE_PCM16 ? "kFrameTypePCM16" : "kFrameTypeUnknown";
    }

    public static AudioFrameType fromId(int id) {
        for (AudioFrameType audioFrameType : values()) {
            if (audioFrameType.value() == id) {
                return audioFrameType;
            }
        }
        return null;
    }
}
