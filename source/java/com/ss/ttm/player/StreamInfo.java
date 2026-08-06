package com.ss.ttm.player;

import com.ss.ttm.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class StreamInfo {
    private int mBitrate;
    private int mChannels;
    private String mCodecName;
    private long mDuration;
    private int mFrameRate;
    private int mHeight;
    private int mRotation;
    private int mSampleRate;
    private int mStreamIndex;
    private int mStreamType;
    private int mWidth;

    public StreamInfo(int streamType, int streamIndex, String codecName, int frameRate, int bitrate, int width, int height, int sampleRate, int channels, long duration, int rotation) {
        this.mStreamType = streamType;
        this.mStreamIndex = streamIndex;
        this.mCodecName = codecName;
        this.mFrameRate = frameRate;
        this.mBitrate = bitrate;
        this.mWidth = width;
        this.mHeight = height;
        this.mSampleRate = sampleRate;
        this.mChannels = channels;
        this.mDuration = duration;
        this.mRotation = rotation;
    }

    public MediaPlayer.TrackInfo convertToTrackInfo() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger(MediaFormat.KEY_TRACK_ID, this.mStreamIndex);
        mediaFormat.setInteger(MediaFormat.KEY_FRAME_RATE, this.mFrameRate);
        mediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, this.mBitrate);
        mediaFormat.setInteger("width", this.mWidth);
        mediaFormat.setInteger("height", this.mHeight);
        mediaFormat.setInteger(MediaFormat.KEY_SAMPLE_RATE, this.mSampleRate);
        mediaFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, this.mChannels);
        mediaFormat.setLong("duration", this.mDuration);
        mediaFormat.setLong(MediaFormat.KEY_ROTATION, this.mRotation);
        mediaFormat.setString(MediaFormat.KEY_CODEC_NAME, this.mCodecName);
        return new MediaPlayer.TrackInfo(this.mStreamType, mediaFormat);
    }

    public String toString() {
        return "StreamInfo{mStreamType=" + this.mStreamType + ", mStreamIndex=" + this.mStreamIndex + ", mCodecName='" + this.mCodecName + "', mFrameRate=" + this.mFrameRate + ", mBitrate=" + this.mBitrate + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mSampleRate=" + this.mSampleRate + ", mChannels=" + this.mChannels + ", mDuration=" + this.mDuration + ", mRotation=" + this.mRotation + AbstractJsonLexerKt.END_OBJ;
    }
}
