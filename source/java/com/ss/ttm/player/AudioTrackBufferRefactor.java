package com.ss.ttm.player;

import android.media.AudioTrack;

/* compiled from: AudioTrackPoolRefactor.java */
/* loaded from: classes7.dex */
class AudioTrackBufferRefactor {
    AudioTrack AudioTrack;
    int audioFormat;
    int channelsLayout;
    int frameSamples;
    long mFreeTimePoint;
    int reuseFailReason = -1;
    int sampleRate;
    int streamType;
    int trackBufferSize;
    int usedCount;

    public AudioTrackBufferRefactor(AudioTrack audioTrack, int streamType, int sampleRate, int channelsLayout, int audioFormat, int frameSamples, int trackBufferSize, int usedCount) {
        this.AudioTrack = audioTrack;
        this.streamType = streamType;
        this.sampleRate = sampleRate;
        this.channelsLayout = channelsLayout;
        this.audioFormat = audioFormat;
        this.frameSamples = frameSamples;
        this.trackBufferSize = trackBufferSize;
        this.usedCount = usedCount;
    }

    public void resetFreeTimePoint() {
        this.mFreeTimePoint = System.currentTimeMillis();
    }

    public void updateReuseFailReason(int reason) {
        this.reuseFailReason = reason;
    }
}
