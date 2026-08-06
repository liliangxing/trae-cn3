package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioRenderType {
    AUDIO_RENDER_TYPE_EXTERNAL(0),
    AUDIO_RENDER_TYPE_INTERNAL(1);

    private int value;

    AudioRenderType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == AUDIO_RENDER_TYPE_EXTERNAL ? "AUDIO_RENDER_TYPE_EXTERNAL" : "AUDIO_RENDER_TYPE_INTERNAL";
    }

    public static AudioRenderType fromId(int id) {
        for (AudioRenderType audioRenderType : values()) {
            if (audioRenderType.value() == id) {
                return audioRenderType;
            }
        }
        return null;
    }
}
