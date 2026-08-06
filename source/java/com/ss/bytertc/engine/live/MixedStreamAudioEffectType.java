package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamAudioEffectType {
    MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE(0),
    MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE(1);

    private int type;

    MixedStreamAudioEffectType(int value) {
        this.type = value;
    }

    public int value() {
        return this.type;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type == 0 ? "MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE" : "MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE";
    }
}
