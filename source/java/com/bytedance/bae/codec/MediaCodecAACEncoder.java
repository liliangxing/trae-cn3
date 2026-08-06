package com.bytedance.bae.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.bytedance.realx.base.RXLogging;
import com.ss.ttm.player.UnifiedCodec.util.MimeTypes;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class MediaCodecAACEncoder {
    private static final int MAX_WAITING_TIME = 300;
    private static final String TAG = "MediaCodecAACEncoder";
    private MediaCodec.BufferInfo mBufferInfo;
    private byte[] mEncodedData;
    private ByteBuffer[] mInputBuffers;
    private ByteBuffer[] mOutputBuffers;
    private String mMimeType = MimeTypes.AUDIO_AAC;
    private int mSampleRate = 44100;
    private int mChannels = 1;
    private int mProfile = 2;
    private int mBitrate = 64000;
    private int mFrameSize = 1024;
    private MediaCodec mAACEncoder = null;

    MediaCodecAACEncoder() {
        RXLogging.e(TAG, "MediaCodecAAC Encoder Created");
    }

    public boolean openEncoder() {
        try {
            this.mAACEncoder = MediaCodec.createEncoderByType(this.mMimeType);
            RXLogging.e(TAG, "open AAC encoder success");
            return this.mAACEncoder != null;
        } catch (Exception e) {
            e.printStackTrace();
            this.mAACEncoder = null;
            RXLogging.e(TAG, "Open AAC encoder failed");
            return false;
        }
    }

    public void closeEncoder() {
        try {
            MediaCodec mediaCodec = this.mAACEncoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mAACEncoder.release();
                this.mAACEncoder = null;
                RXLogging.e(TAG, "close AAC encoder success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "close AAC encoder failed");
        }
    }

    public void setProfileValue(String profile) {
        if (profile.equals("he_aac")) {
            this.mProfile = 5;
            this.mFrameSize = 2048;
        } else if (profile.equals("he_aac_v2")) {
            this.mProfile = 29;
            this.mFrameSize = 2048;
        } else {
            this.mProfile = 2;
            this.mFrameSize = 1024;
        }
    }

    public int getFrameSize() {
        return this.mFrameSize;
    }

    public void setSampeRateValue(int sr) {
        this.mSampleRate = sr;
    }

    public void setChannelsValue(int ch) {
        this.mChannels = ch;
    }

    public void setBitRateValue(int bitrate) {
        this.mBitrate = bitrate;
    }

    public byte[] getEncodedData() {
        return this.mEncodedData;
    }

    public boolean configAndStartEncoder() {
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);
            createAudioFormat.setInteger(com.ss.ttm.player.MediaFormat.KEY_BIT_RATE, this.mBitrate);
            createAudioFormat.setInteger("aac-profile", this.mProfile);
            createAudioFormat.setInteger("profile", this.mProfile);
            createAudioFormat.setInteger("max-input-size", this.mChannels * this.mFrameSize * 100);
            this.mAACEncoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mAACEncoder.start();
            this.mBufferInfo = new MediaCodec.BufferInfo();
            RXLogging.e(TAG, "config AAC encoder success");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Config and Start Encoder Error");
            return false;
        }
    }

    public boolean setBitrate(int bitrate) {
        try {
            MediaCodec mediaCodec = this.mAACEncoder;
            if (mediaCodec == null) {
                return false;
            }
            mediaCodec.stop();
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);
            createAudioFormat.setInteger(com.ss.ttm.player.MediaFormat.KEY_BIT_RATE, bitrate);
            createAudioFormat.setInteger("aac-profile", this.mProfile);
            this.mAACEncoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mAACEncoder.start();
            this.mBitrate = bitrate;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Config and Start Encoder Error");
            return false;
        }
    }

    public boolean encodeProcess(byte[] data) {
        try {
            MediaCodec mediaCodec = this.mAACEncoder;
            if (mediaCodec == null) {
                return false;
            }
            this.mEncodedData = null;
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(300L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer inputBuffer = this.mAACEncoder.getInputBuffer(dequeueInputBuffer);
                inputBuffer.clear();
                inputBuffer.put(data);
                this.mAACEncoder.queueInputBuffer(dequeueInputBuffer, 0, data.length, 0L, 0);
            }
            int dequeueOutputBuffer = this.mAACEncoder.dequeueOutputBuffer(this.mBufferInfo, 0L);
            int i = this.mBufferInfo.size;
            int i2 = this.mBufferInfo.flags & 2;
            if (i > 0 && dequeueOutputBuffer >= 0) {
                if (i2 == 2) {
                    this.mAACEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return true;
                }
                ByteBuffer outputBuffer = this.mAACEncoder.getOutputBuffer(dequeueOutputBuffer);
                byte[] bArr = new byte[i];
                this.mEncodedData = bArr;
                outputBuffer.get(bArr, this.mBufferInfo.offset, i);
                outputBuffer.clear();
                this.mAACEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "AAC Encoder Encode failed");
            return false;
        }
    }
}
