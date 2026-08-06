package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public enum VideoDecoderConfig {
    VIDEO_DECODER_CONFIG_RAW(0),
    VIDEO_DECODER_CONFIG_ENCODE(1),
    VIDEO_DECODER_CONFIG_BOTH(2);

    private int value;

    VideoDecoderConfig(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static VideoDecoderConfig fromId(int id) {
        for (VideoDecoderConfig videoDecoderConfig : values()) {
            if (videoDecoderConfig.value() == id) {
                return videoDecoderConfig;
            }
        }
        return null;
    }
}
