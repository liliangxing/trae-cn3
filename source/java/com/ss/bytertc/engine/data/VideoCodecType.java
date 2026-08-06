package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoCodecType {
    VIDEO_CODEC_TYPE_UNKNOWN(0),
    VIDEO_CODEC_TYPE_H264(1),
    VIDEO_CODEC_TYPE_BYTEVC1(2);

    int value;

    VideoCodecType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static VideoCodecType fromId(int id) {
        for (VideoCodecType videoCodecType : values()) {
            if (videoCodecType.value() == id) {
                return videoCodecType;
            }
        }
        return null;
    }
}
