package com.ss.bytertc.engine;

import android.util.Pair;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class VideoStreamDescription {
    public EncoderPreference encodePreference;
    public int frameRate;
    public int maxKbps;
    public int minKbps;
    public Pair<Integer, Integer> videoSize;

    /* loaded from: classes7.dex */
    public enum CodecMode {
        CODEC_MODE_AUTO(0),
        CODEC_MODE_HARDWARE(1),
        CODEC_MODE_SOFTWARE(2);

        private int value;

        CodecMode(int v) {
            this.value = v;
        }

        public static CodecMode convertFromInt(int v) {
            return values()[v];
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public enum VideoCodecType {
        CODEC_TYPE_AUTO(0),
        CODEC_TYPE_H264(1),
        CODEC_TYPE_BYTEVC1(2);

        private int value;

        VideoCodecType(int v) {
            this.value = v;
        }

        public static VideoCodecType convertFromInt(int v) {
            return values()[v];
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public enum EncoderPreference {
        Disabled(0),
        MaintainFramerate(1),
        MaintainQuality(2),
        Balance(3);

        private int value;

        EncoderPreference(int v) {
            this.value = v;
        }

        public static EncoderPreference convertFromInt(int v) {
            return values()[v];
        }

        public int getValue() {
            return this.value;
        }
    }

    private static VideoStreamDescription create(int width, int height, int frameRate, int maxKbps, int minKbps) {
        return new VideoStreamDescription(width, height, frameRate, maxKbps, minKbps);
    }

    public VideoStreamDescription() {
        this.minKbps = 0;
        this.encodePreference = EncoderPreference.MaintainFramerate;
    }

    public VideoStreamDescription(int width, int height, int frameRate, int maxKbps, int minKbps) {
        this.minKbps = 0;
        this.encodePreference = EncoderPreference.MaintainFramerate;
        this.videoSize = new Pair<>(Integer.valueOf(width), Integer.valueOf(height));
        this.frameRate = frameRate;
        this.maxKbps = maxKbps;
        this.minKbps = minKbps;
    }

    public VideoStreamDescription(int width, int height, int frameRate, int maxKbps, int minKbps, int codecName, int codecMode, int encodePrefer) {
        this.minKbps = 0;
        this.encodePreference = EncoderPreference.MaintainFramerate;
        this.videoSize = new Pair<>(Integer.valueOf(width), Integer.valueOf(height));
        this.frameRate = frameRate;
        this.maxKbps = maxKbps;
        this.minKbps = minKbps;
        this.encodePreference = EncoderPreference.convertFromInt(encodePrefer);
    }

    public boolean isValid() {
        Pair<Integer, Integer> pair = this.videoSize;
        if (pair == null || ((Integer) pair.first).intValue() <= 0 || ((Integer) this.videoSize.second).intValue() <= 0 || this.frameRate <= 0) {
            return false;
        }
        int i = this.maxKbps;
        return i <= 0 || this.minKbps <= i;
    }

    public String toString() {
        return "VideoStreamDescription{videoSize=" + this.videoSize + ", frameRate=" + this.frameRate + ", maxKbps=" + this.maxKbps + ", minKbps=" + this.minKbps + ", encodePreference=" + this.encodePreference + AbstractJsonLexerKt.END_OBJ;
    }
}
