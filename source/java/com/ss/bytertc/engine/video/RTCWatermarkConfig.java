package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public class RTCWatermarkConfig {
    public ByteWatermark positionInLandscapeMode;
    public ByteWatermark positionInPortraitMode;
    public boolean visibleInPreview;

    public RTCWatermarkConfig() {
        this.visibleInPreview = true;
    }

    public RTCWatermarkConfig(boolean visibleInPreview, ByteWatermark positionInLandscapeMode, ByteWatermark positionInPortraitMode) {
        this.visibleInPreview = visibleInPreview;
        this.positionInLandscapeMode = positionInLandscapeMode;
        this.positionInPortraitMode = positionInPortraitMode;
    }
}
