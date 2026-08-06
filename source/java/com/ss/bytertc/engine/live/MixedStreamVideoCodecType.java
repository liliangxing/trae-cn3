package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamVideoCodecType {
    MIXED_STREAM_VIDEO_CODEC_TYPE_H264("H264"),
    MIXED_STREAM_VIDEO_CODEC_TYPE_BYTEVC1("ByteVC1");

    private String videoCodecType;

    MixedStreamVideoCodecType(String value) {
        this.videoCodecType = value;
    }

    public String getValue() {
        return this.videoCodecType;
    }
}
