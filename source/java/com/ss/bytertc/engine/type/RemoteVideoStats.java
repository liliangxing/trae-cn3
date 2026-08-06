package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRemoteVideoStats;

/* loaded from: classes7.dex */
public class RemoteVideoStats {
    public int codecType;
    public int decoderOutputFrameRate;
    public long e2eDelay;
    public int frozenRate;
    public int height;
    public boolean isScreen;
    public int jitter;
    public float receivedKBitrate;
    public int rendererOutputFrameRate;
    public int rtt;
    public int stallCount;
    public int stallDuration;
    public int statsInterval;
    public int superResolutionMode;
    public int videoIndex;
    public float videoLossRate;
    public int width;

    public RemoteVideoStats() {
    }

    public RemoteVideoStats(InternalRemoteVideoStats internalStats) {
        this.width = internalStats.width;
        this.height = internalStats.height;
        this.videoLossRate = internalStats.videoLossRate;
        this.receivedKBitrate = internalStats.receivedKBitrate;
        this.decoderOutputFrameRate = internalStats.decoderOutputFrameRate;
        this.rendererOutputFrameRate = internalStats.rendererOutputFrameRate;
        this.stallCount = internalStats.stallCount;
        this.stallDuration = internalStats.stallDuration;
        this.e2eDelay = internalStats.e2eDelay;
        this.isScreen = internalStats.isScreen;
        this.statsInterval = internalStats.statsInterval;
        this.rtt = internalStats.rtt;
        this.frozenRate = internalStats.frozenRate;
        this.codecType = internalStats.codecType;
        this.videoIndex = internalStats.videoIndex;
        this.jitter = internalStats.jitter;
        this.superResolutionMode = internalStats.superResolutionMode;
    }

    public String toString() {
        return "RemoteVideoStats{width='" + this.width + "', height='" + this.height + "', videoLossRate='" + this.videoLossRate + "', receivedKBitrate='" + this.receivedKBitrate + "', decoderOutputFrameRate='" + this.decoderOutputFrameRate + "', rendererOutputFrameRate='" + this.rendererOutputFrameRate + "', stallCount='" + this.stallCount + "', stallDuration='" + this.stallDuration + "', e2eDelay='" + this.e2eDelay + "', isScreen='" + this.isScreen + "', rtt='" + this.rtt + "', frozenRate='" + this.frozenRate + "', videoIndex='" + this.videoIndex + "', jitter='" + this.jitter + "', codecType='" + this.codecType + "', superResolutionMode='" + this.superResolutionMode + "'}";
    }
}
