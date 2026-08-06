package com.ss.bytertc.engine.video;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class VideoEncoderConfiguration {
    public VideoDimensions dimensions;
    public FrameRate frameRate;
    public int kBitrate;
    public int kMinBitrate;
    public OrientationMode orientationMode;

    public VideoEncoderConfiguration(VideoDimensions dimensions, FrameRate frameRate, int kBitrate, int kMinBitrate, OrientationMode orientationMode) {
        this.dimensions = dimensions;
        this.frameRate = frameRate;
        this.kBitrate = kBitrate;
        this.kMinBitrate = kMinBitrate;
        this.orientationMode = orientationMode;
    }

    /* loaded from: classes7.dex */
    public enum OrientationMode {
        ORIENTATION_MODE_ADAPTIVE(0),
        ORIENTATION_MODE_FIXED_LANDSCAPE(1),
        ORIENTATION_MODE_FIXED_PORTRAIT(2);

        private int value;

        OrientationMode(int v) {
            this.value = v;
        }

        public int getValue() {
            return this.value;
        }
    }

    public String toString() {
        return "VideoEncoderConfiguration{dimensions=" + this.dimensions + ", frameRate=" + this.frameRate + ", bitrate=" + this.kBitrate + ", minBitrate=" + this.kMinBitrate + ", orienttationMode=" + this.orientationMode + AbstractJsonLexerKt.END_OBJ;
    }
}
