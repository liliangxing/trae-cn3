package com.ss.ttm.player;

import android.media.AudioTrack;

/* compiled from: AudioTrackPool.java */
/* loaded from: classes7.dex */
class AudioTrackBuffer {
    AudioTrack AudioTrack;
    int audioFormat;
    int channelsLayout;
    int frameSamples;
    long mFreeTimePoint;
    int sampleRate;
    int streamType;
    int usedCount;

    public AudioTrackBuffer(AudioTrack audioTrack, int streamType, int sampleRate, int channelsLayout, int audioFormat, int frameSamples, int usedCount) {
        this.AudioTrack = audioTrack;
        this.streamType = streamType;
        this.sampleRate = sampleRate;
        this.channelsLayout = channelsLayout;
        this.audioFormat = audioFormat;
        this.frameSamples = frameSamples;
        this.usedCount = usedCount;
    }

    public void resetFreeTimePoint() {
        this.mFreeTimePoint = System.currentTimeMillis();
    }
}
