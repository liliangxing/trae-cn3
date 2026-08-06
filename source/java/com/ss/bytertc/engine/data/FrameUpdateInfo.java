package com.ss.bytertc.engine.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class FrameUpdateInfo {
    public int frameRate;
    public int pixel;

    public FrameUpdateInfo(int pixel, int frameRate) {
        this.pixel = pixel;
        this.frameRate = frameRate;
    }

    public String toString() {
        return "FrameUpdateInfo{pixel='" + this.pixel + "', frameRate='" + this.frameRate + AbstractJsonLexerKt.END_OBJ;
    }
}
