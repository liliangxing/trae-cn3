package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum SubscribeFallbackOptions {
    SUBSCRIBE_FALLBACK_OPTIONS_DISABLED(0),
    SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW(1),
    SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY(2);

    private int value;

    SubscribeFallbackOptions(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static SubscribeFallbackOptions fromId(int id) {
        for (SubscribeFallbackOptions subscribeFallbackOptions : values()) {
            if (subscribeFallbackOptions.value() == id) {
                return subscribeFallbackOptions;
            }
        }
        return null;
    }
}
