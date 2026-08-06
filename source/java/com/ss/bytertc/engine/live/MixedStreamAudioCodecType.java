package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamAudioCodecType {
    MIXED_STREAM_AUDIO_CODEC_TYPE_AAC("AAC");

    private String audioCodecType;

    MixedStreamAudioCodecType(String value) {
        this.audioCodecType = value;
    }

    public String getValue() {
        return this.audioCodecType;
    }
}
