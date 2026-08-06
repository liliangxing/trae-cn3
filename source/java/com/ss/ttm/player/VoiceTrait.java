package com.ss.ttm.player;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public abstract class VoiceTrait extends TraitObject {
    public static final int AV_PCM_FMT_DBL = 4;
    public static final int AV_PCM_FMT_DBLP = 9;
    public static final int AV_PCM_FMT_FLT = 3;
    public static final int AV_PCM_FMT_FLTP = 8;
    public static final int AV_PCM_FMT_NONE = -1;
    public static final int AV_PCM_FMT_S16 = 1;
    public static final int AV_PCM_FMT_S16P = 6;
    public static final int AV_PCM_FMT_S32 = 2;
    public static final int AV_PCM_FMT_S32P = 7;
    public static final int AV_PCM_FMT_U8 = 0;
    public static final int AV_PCM_FMT_U8P = 5;
    public static final int Version0 = 0;

    /* loaded from: classes7.dex */
    public static class AudioFrameInfo {
        public ByteBuffer[] mBuffers;
        public int mSamples;
        public long mTimestamp;
    }

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes7.dex */
    public @interface Ver {
    }

    public abstract void audioClose();

    public abstract void audioFlush();

    public abstract int audioOpen(AudioMediaInfo info);

    public abstract void audioPause();

    public abstract void audioResume();

    public abstract int audioWrite(AudioFrameInfo frame);

    public abstract int getLatency();

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

    @Deprecated
    public VoiceTrait(int type, long nativeObj) {
        super(type, nativeObj);
    }

    @Deprecated
    public VoiceTrait(int type, int version, long unused) {
        super(type, version, unused);
    }

    public VoiceTrait(int version) {
        super(1, version, 0L);
    }
}
