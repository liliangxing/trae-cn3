package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoPictureType {
    VIDEO_PICTURE_TYPE_UNKNOWN(0),
    VIDEO_PICTURE_TYPE_I(1),
    VIDEO_PICTURE_TYPE_P(2),
    VIDEO_PICTURE_TYPE_B(3);

    int value;

    VideoPictureType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static VideoPictureType fromId(int id) {
        for (VideoPictureType videoPictureType : values()) {
            if (videoPictureType.value() == id) {
                return videoPictureType;
            }
        }
        return null;
    }
}
