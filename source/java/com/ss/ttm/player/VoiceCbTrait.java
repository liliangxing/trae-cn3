package com.ss.ttm.player;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public abstract class VoiceCbTrait extends TraitObject {
    public static final int Version0 = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes7.dex */
    public @interface Ver {
    }

    public abstract void voiceClose();

    public abstract int voiceOpen(AudioMediaInfo info);

    public abstract int voiceWrite(ByteBuffer data, int size, long pts, int sampleNB, int sampleRate, int channels, int format);

    /* loaded from: classes7.dex */
    public static class AudioMediaInfo {
        public int mBytePerSample;
        public int mChannels;
        public int mDuration;
        public int mFormat;
        public int mFrameSampleNB;
        public int mIsPacked;
        public int mSampleRate;

        public AudioMediaInfo(int sampleRate, int frameSampleNB, int bytePerSample, int channels, int format, int isPacked, int duration) {
            this.mSampleRate = sampleRate;
            this.mFrameSampleNB = frameSampleNB;
            this.mBytePerSample = bytePerSample;
            this.mChannels = channels;
            this.mFormat = format;
            this.mIsPacked = isPacked;
            this.mDuration = duration;
        }
    }

    public VoiceCbTrait(int version) {
        super(11, version, 0L);
    }
}
