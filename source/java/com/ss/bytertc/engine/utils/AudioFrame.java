package com.ss.bytertc.engine.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;

/* loaded from: classes7.dex */
public class AudioFrame {
    public byte[] buffer;
    public AudioChannel channel;
    public byte[] extraInfo;
    public AudioSampleRate sampleRate;
    public int samples;

    public AudioFrame() {
    }

    public AudioFrame(byte[] buffer, int samples, AudioSampleRate sampleRate, AudioChannel channel) {
        this.buffer = buffer;
        this.samples = samples;
        this.sampleRate = sampleRate;
        this.channel = channel;
        this.extraInfo = null;
    }

    public AudioFrame(byte[] buffer, int samples, AudioSampleRate sampleRate, AudioChannel channel, byte[] extraInfo) {
        this.buffer = buffer;
        this.samples = samples;
        this.sampleRate = sampleRate;
        this.channel = channel;
        this.extraInfo = extraInfo;
    }
}
