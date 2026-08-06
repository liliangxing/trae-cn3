package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalLocalAudioStats {
    public int audioDeviceLoopDelay;
    public float audioLossRate;
    public int jitter;
    public int numChannels;
    public int recordSampleRate;
    public int rtt;
    public int sendKBitrate;
    public int sentSampleRate;
    public int statsInterval;

    public InternalLocalAudioStats() {
    }

    public InternalLocalAudioStats(float audioLossRate, int sendKBitrate, int recordSampleRate, int statsInterval, int rtt, int numChannels, int sentSampleRate, int jitter, int audioDeviceLoopDelay) {
        this.audioLossRate = audioLossRate;
        this.sendKBitrate = sendKBitrate;
        this.recordSampleRate = recordSampleRate;
        this.statsInterval = statsInterval;
        this.rtt = rtt;
        this.numChannels = numChannels;
        this.sentSampleRate = sentSampleRate;
        this.jitter = jitter;
        this.audioDeviceLoopDelay = audioDeviceLoopDelay;
    }

    private static InternalLocalAudioStats create(float audioLossRate, int sendKBitrate, int recordSampleRate, int statsInterval, int rtt, int numChannels, int sentSampleRate, int jitter, int audioDeviceLoopDelay) {
        return new InternalLocalAudioStats(audioLossRate, sendKBitrate, recordSampleRate, statsInterval, rtt, numChannels, sentSampleRate, jitter, audioDeviceLoopDelay);
    }
}
