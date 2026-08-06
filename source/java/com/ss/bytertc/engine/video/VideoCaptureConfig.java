package com.ss.bytertc.engine.video;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class VideoCaptureConfig {
    public CapturePreference capturePreference;
    public int frameRate;
    public int height;
    public int width;

    /* loaded from: classes7.dex */
    public enum CapturePreference {
        AUTO(0),
        MANUAL(1),
        AUTO_PERFORMANCE(2);

        private int value;

        CapturePreference(int v) {
            this.value = v;
        }

        public static CapturePreference convertFromInt(int v) {
            return values()[v];
        }

        public int getValue() {
            return this.value;
        }
    }

    public VideoCaptureConfig() {
        this.capturePreference = CapturePreference.AUTO;
    }

    public VideoCaptureConfig(int w, int h, int fps) {
        this.capturePreference = CapturePreference.AUTO;
        this.capturePreference = CapturePreference.MANUAL;
        this.width = w;
        this.height = h;
        this.frameRate = fps;
    }

    public String toString() {
        return "VideoCaptureConfig{capturePreference=" + this.capturePreference + "width=" + this.width + ", height=" + this.height + ", frameRate=" + this.frameRate + AbstractJsonLexerKt.END_OBJ;
    }
}
