package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalLocalAudioStats;

/* loaded from: classes7.dex */
public class LocalAudioStats {
    public int audioDeviceLoopDelay;
    public float audioLossRate;
    public int jitter;
    public int numChannels;
    public int recordSampleRate;
    public int rtt;
    public float sendKBitrate;
    public int sentSampleRate;
    public int statsInterval;

    public LocalAudioStats() {
    }

    public LocalAudioStats(InternalLocalAudioStats internalStats) {
        this.audioLossRate = internalStats.audioLossRate;
        this.sendKBitrate = internalStats.sendKBitrate;
        this.recordSampleRate = internalStats.recordSampleRate;
        this.statsInterval = internalStats.statsInterval;
        this.rtt = internalStats.rtt;
        this.numChannels = internalStats.numChannels;
        this.sentSampleRate = internalStats.sentSampleRate;
        this.jitter = internalStats.jitter;
        this.audioDeviceLoopDelay = internalStats.audioDeviceLoopDelay;
    }

    public String toString() {
        return "LocalAudioStats{audioLossRate='" + this.audioLossRate + "', sendKBitrate='" + this.sendKBitrate + "', recordSampleRate='" + this.recordSampleRate + "', statsInterval='" + this.statsInterval + "', rtt='" + this.rtt + "', numChannels='" + this.numChannels + "', sentSampleRate='" + this.sentSampleRate + "', jitter='" + this.jitter + "', audioDeviceLoopDelay='" + this.audioDeviceLoopDelay + "'}";
    }
}
