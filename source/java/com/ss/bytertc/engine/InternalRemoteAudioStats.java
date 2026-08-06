package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalRemoteAudioStats {
    public float audioLossRate;
    public int concealedSamples;
    public int concealmentEvent;
    public int decDuration;
    public int decSampleRate;
    public long e2eDelay;
    public int frozenRate;
    public int jitter;
    public int jitterBufferDelay;
    public int numChannels;
    public int playoutSampleRate;
    public int quality;
    public int receivedKBitrate;
    public int receivedSampleRate;
    public int rtt;
    public int stallCount;
    public int stallDuration;
    public int statsInterval;
    public int totalRtt;

    public InternalRemoteAudioStats() {
    }

    public InternalRemoteAudioStats(float audioLossRate, int receivedKBitrate, int stallCount, int stallDuration, long e2eDelay, int playoutSampleRate, int statsInterval, int rtt, int total_rtt, int quality, int jitterBufferDelay, int numChannels, int receivedSampleRate, int frozenRate, int concealedSamples, int concealmentEvent, int decSampleRate, int decDuration, int jitter) {
        this.audioLossRate = audioLossRate;
        this.receivedKBitrate = receivedKBitrate;
        this.stallCount = stallCount;
        this.stallDuration = stallDuration;
        this.e2eDelay = e2eDelay;
        this.statsInterval = statsInterval;
        this.rtt = rtt;
        this.totalRtt = total_rtt;
        this.quality = quality;
        this.jitterBufferDelay = jitterBufferDelay;
        this.numChannels = numChannels;
        this.receivedSampleRate = receivedSampleRate;
        this.frozenRate = frozenRate;
        this.concealedSamples = concealedSamples;
        this.concealmentEvent = concealmentEvent;
        this.decSampleRate = decSampleRate;
        this.decDuration = decDuration;
        this.jitter = jitter;
    }

    private static InternalRemoteAudioStats create(float audioLossRate, int receivedKBitrate, int stallCount, int stallDuration, long e2eDelay, int playoutSampleRate, int statsInterval, int rtt, int total_rtt, int quality, int jitterBufferDelay, int numChannels, int receivedSampleRate, int frozenRate, int concealedSamples, int concealmentEvent, int decSampleRate, int decDuration, int jitter) {
        return new InternalRemoteAudioStats(audioLossRate, receivedKBitrate, stallCount, stallDuration, e2eDelay, playoutSampleRate, statsInterval, rtt, total_rtt, quality, jitterBufferDelay, numChannels, receivedSampleRate, frozenRate, concealedSamples, concealmentEvent, decSampleRate, decDuration, jitter);
    }
}
