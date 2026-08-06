package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamMediaType {
    MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO(0),
    MIXED_STREAM_MEDIA_TYPE_AUDIO_ONLY(1),
    MIXED_STREAM_MEDIA_TYPE_VIDEO_ONLY(2);

    private int contentControlType;

    MixedStreamMediaType(int value) {
        this.contentControlType = value;
    }

    public int getValue() {
        return this.contentControlType;
    }
}
