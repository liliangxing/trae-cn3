package com.ss.bytertc.engine.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class VideoFrameInfo {
    public int height;
    public VideoRotation rotation;
    public int width;

    public VideoFrameInfo(int width, int height, int rotation) {
        this.width = 0;
        this.height = 0;
        this.rotation = VideoRotation.VIDEO_ROTATION_0;
        this.width = width;
        this.height = height;
        this.rotation = VideoRotation.fromId(rotation);
    }

    public String toString() {
        return "VideoFrameInfo{width=" + this.width + ", height=" + this.height + ", rotation=" + this.rotation + AbstractJsonLexerKt.END_OBJ;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }
}
