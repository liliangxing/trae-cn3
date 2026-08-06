package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRemoteAudioStats;

/* loaded from: classes7.dex */
public class RemoteAudioStats {
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
    public float receivedKBitrate;
    public int receivedSampleRate;
    public int rtt;
    public int stallCount;
    public int stallDuration;
    public int statsInterval;
    public int totalRtt;

    public RemoteAudioStats() {
    }

    public RemoteAudioStats(InternalRemoteAudioStats internalStats) {
        this.audioLossRate = internalStats.audioLossRate;
        this.receivedKBitrate = internalStats.receivedKBitrate;
        this.stallCount = internalStats.stallCount;
        this.stallDuration = internalStats.stallDuration;
        this.e2eDelay = internalStats.e2eDelay;
        this.playoutSampleRate = internalStats.playoutSampleRate;
        this.statsInterval = internalStats.statsInterval;
        this.rtt = internalStats.rtt;
        this.totalRtt = internalStats.totalRtt;
        this.quality = internalStats.quality;
        this.jitterBufferDelay = internalStats.jitterBufferDelay;
        this.numChannels = internalStats.numChannels;
        this.receivedSampleRate = internalStats.receivedSampleRate;
        this.frozenRate = internalStats.frozenRate;
        this.concealedSamples = internalStats.concealedSamples;
        this.concealmentEvent = internalStats.concealmentEvent;
        this.decSampleRate = internalStats.decSampleRate;
        this.decDuration = internalStats.decDuration;
        this.jitter = internalStats.jitter;
    }

    public String toString() {
        return "RemoteAudioStats{audioLossRate='" + this.audioLossRate + "', receivedKBitrate='" + this.receivedKBitrate + "', stallCount='" + this.stallCount + "', stallDuration='" + this.stallDuration + "', playoutSampleRate='" + this.playoutSampleRate + "', e2eDelay='" + this.e2eDelay + "', rtt='" + this.rtt + "', quality='" + this.quality + "', jitterBufferDelay='" + this.jitterBufferDelay + "', numChannels='" + this.numChannels + "', receivedSampleRate='" + this.receivedSampleRate + "', frozenRate='" + this.frozenRate + "', concealedSamples='" + this.concealedSamples + "', concealmentEvent='" + this.concealmentEvent + "', decSampleRate='" + this.decSampleRate + "', decDuration='" + this.decDuration + "', total_rtt='" + this.totalRtt + "', jitter='" + this.jitter + "'}";
    }
}
