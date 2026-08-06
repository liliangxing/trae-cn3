package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoSourceType {
    VIDEO_SOURCE_TYPE_EXTERNAL(0),
    VIDEO_SOURCE_TYPE_INTERNAL(1),
    VIDEO_SOURCE_TYPE_ENCODED_WITH_SIMULCAST(2),
    VIDEO_SOURCE_TYPE_ENCODED_WITHOUT_SIMULCAST(3);

    private int value;

    VideoSourceType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static VideoSourceType fromId(int id) {
        for (VideoSourceType videoSourceType : values()) {
            if (videoSourceType.value() == id) {
                return videoSourceType;
            }
        }
        return null;
    }
}
