package com.ss.bytertc.engine.live;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class MixedStreamAudioConfig {
    public MixedStreamAudioCodecType audioCodec = MixedStreamAudioCodecType.MIXED_STREAM_AUDIO_CODEC_TYPE_AAC;
    public int bitrate = 64;
    public int sampleRate = 48000;
    public int channels = 2;
    public MixedStreamAudioProfile audioProfile = MixedStreamAudioProfile.MIXED_STREAM_AUDIO_PROFILE_LC;

    public String toString() {
        return "MixedStreamAudioConfig{audioProfile='" + this.audioProfile + "', channels=" + this.channels + ", sampleRate=" + this.sampleRate + ", bitrate=" + this.bitrate + ", audioCodec=" + this.audioCodec + AbstractJsonLexerKt.END_OBJ;
    }
}
