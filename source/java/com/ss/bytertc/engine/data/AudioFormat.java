package com.ss.bytertc.engine.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class AudioFormat {
    public AudioChannel channel;
    public AudioSampleRate sampleRate;
    public int samplesPerCall;

    public AudioFormat(AudioSampleRate sampleRate, AudioChannel channel) {
        this.sampleRate = sampleRate;
        this.channel = channel;
        this.samplesPerCall = 0;
    }

    public AudioFormat(AudioSampleRate sampleRate, AudioChannel channel, int samplesPerCall) {
        this.sampleRate = sampleRate;
        this.channel = channel;
        this.samplesPerCall = samplesPerCall;
    }

    public String toString() {
        return "AudioFormat{sampleRate='" + this.sampleRate + "', channel='" + this.channel + "', samplesPerCall=" + this.samplesPerCall + AbstractJsonLexerKt.END_OBJ;
    }
}
