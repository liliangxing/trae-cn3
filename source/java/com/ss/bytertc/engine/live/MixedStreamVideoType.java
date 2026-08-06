package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamVideoType {
    MIXED_STREAM_VIDEO_TYPE_MAIN(0),
    MIXED_STREAM_VIDEO_TYPE_SCREEN(1),
    MIXED_STREAM_VIDEO_TYPE_3RD(2),
    MIXED_STREAM_VIDEO_TYPE_4TH(3),
    MIXED_STREAM_VIDEO_TYPE_5TH(4),
    MIXED_STREAM_VIDEO_TYPE_6TH(5),
    MIXED_STREAM_VIDEO_TYPE_7TH(6),
    MIXED_STREAM_VIDEO_TYPE_8TH(7);

    private int videoType;

    MixedStreamVideoType(int value) {
        this.videoType = value;
    }

    public int getValue() {
        return this.videoType;
    }
}
