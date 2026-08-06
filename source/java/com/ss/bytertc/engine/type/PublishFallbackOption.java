package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum PublishFallbackOption {
    DISABLE(0),
    SIMULCAST_SMALL_VIDEO_ONLY(1);

    private int value;

    PublishFallbackOption(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static PublishFallbackOption fromId(int id) {
        for (PublishFallbackOption publishFallbackOption : values()) {
            if (publishFallbackOption.value() == id) {
                return publishFallbackOption;
            }
        }
        return null;
    }
}
