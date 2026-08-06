package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamLayoutRegionType {
    MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM(0),
    MIXED_STREAM_LAYOUT_REGION_TYPE_IMAGE(1);

    private int regionType;

    MixedStreamLayoutRegionType(int value) {
        this.regionType = value;
    }

    public int getValue() {
        return this.regionType;
    }
}
