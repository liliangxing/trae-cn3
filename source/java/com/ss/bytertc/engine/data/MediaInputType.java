package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum MediaInputType {
    MEDIA_INPUT_TYPE_EXTERNAL(0),
    MEDIA_INPUT_TYPE_INTERNAL(1);

    private int value;

    MediaInputType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static MediaInputType fromId(int id) {
        for (MediaInputType mediaInputType : values()) {
            if (mediaInputType.value() == id) {
                return mediaInputType;
            }
        }
        return null;
    }
}
