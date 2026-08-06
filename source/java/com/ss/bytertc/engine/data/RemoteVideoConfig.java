package com.ss.bytertc.engine.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class RemoteVideoConfig {
    public int framerate;
    public int height;
    public int width;

    public RemoteVideoConfig(int width, int height, int framerate) {
        this.width = width;
        this.height = height;
        this.framerate = framerate;
    }

    public String toString() {
        return "RemoteVideoConfig{width=" + this.width + ", height=" + this.height + ", framerate=" + this.framerate + AbstractJsonLexerKt.END_OBJ;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getFrameRate() {
        return this.framerate;
    }
}
