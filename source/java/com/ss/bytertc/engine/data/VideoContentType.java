package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoContentType {
    NORMAL_FRAME(0),
    BLACK_FRAME(1);

    private int value;

    VideoContentType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == NORMAL_FRAME ? "kVideoContentTypeNormalFrame" : "kVideoContentTypeBlackFrame";
    }

    public static VideoContentType fromId(int id) {
        for (VideoContentType videoContentType : values()) {
            if (videoContentType.value() == id) {
                return videoContentType;
            }
        }
        return null;
    }
}
