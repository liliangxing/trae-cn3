package com.bytedance.bae.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.bytedance.realx.base.RXLogging;
import com.ss.ttm.player.UnifiedCodec.util.CodecUtils;
import com.ss.ttm.player.UnifiedCodec.util.MimeTypes;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class MediaCodecAACDecoder {
    private static final int MAX_WAITING_TIME = 300;
    private static final String TAG = "MediaCodecAACDecoder";
    private byte[] mAsc;
    private MediaCodec.BufferInfo mBufferInfo;
    private byte[] mDecodedData;
    private ByteBuffer[] mInputBuffers;
    private ByteBuffer[] mOutputBuffers;
    private MediaFormat mOutputFormat;
    private String mMimeType = MimeTypes.AUDIO_AAC;
    private int mSampleRate = 44100;
    private int mChannels = 1;
    private int mProfile = 2;
    private int mHasADTS = 0;
    private long input_ts = 0;
    private long output_ts = 0;
    private MediaCodec mAACDecoder = null;

    MediaCodecAACDecoder() {
        RXLogging.e(TAG, "MediaCodecAAC Decoder Created");
    }

    public boolean openEncoder() {
        try {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.mMimeType);
            this.mAACDecoder = createDecoderByType;
            return createDecoderByType != null;
        } catch (Exception e) {
            e.printStackTrace();
            this.mAACDecoder = null;
            RXLogging.e(TAG, "Open AAC Decoder failed");
            return false;
        }
    }

    public void closeDecoder() {
        try {
            MediaCodec mediaCodec = this.mAACDecoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mAACDecoder.release();
                this.mAACDecoder = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "close AAC decoder failed");
        }
    }

    public void setProfileValue(String profile) {
        if (profile.equals("he_aac")) {
            this.mProfile = 5;
        } else if (profile.equals("he_aac_v2")) {
            this.mProfile = 29;
        } else {
            this.mProfile = 2;
        }
    }

    public void setSampeRateValue(int sr) {
        this.mSampleRate = sr;
    }

    public void setChannelsValue(int ch) {
        this.mChannels = ch;
    }

    public void setADTSValue(int has_adts) {
        this.mHasADTS = has_adts;
    }

    public byte[] getDecodedData() {
        return this.mDecodedData;
    }

    public int getOutputChannels() {
        return this.mOutputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);
    }

    public int getOutputSampleRate() {
        return this.mOutputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);
    }

    public void setInputTs(long ts) {
        this.input_ts = ts;
    }

    public long getOutputTs() {
        return this.output_ts;
    }

    private void genAsc() {
        int i;
        int i2 = this.mProfile;
        int i3 = 4;
        if (i2 == 2) {
            this.mAsc = new byte[2];
        } else {
            this.mAsc = new byte[4];
        }
        int i4 = this.mSampleRate;
        if (48000 == i4) {
            i = 6;
            i3 = 3;
        } else if (44100 == i4) {
            i = 7;
        } else if (32000 == i4) {
            i3 = 5;
            i = 8;
        } else {
            i3 = 0;
            i = 0;
        }
        int i5 = this.mChannels;
        int i6 = 1 == i5 ? 1 : 2 == i5 ? 2 : 0;
        byte b = (byte) i2;
        if (2 == i2) {
            byte[] bArr = this.mAsc;
            bArr[0] = (byte) ((b << 3) | (i3 >> 1));
            bArr[1] = (byte) ((i3 << 7) | (i6 << 3));
        } else {
            if (5 == i2) {
                byte[] bArr2 = this.mAsc;
                bArr2[0] = (byte) ((b << 3) | (i >> 1));
                bArr2[1] = (byte) ((i << 7) | (i6 << 3) | (i3 >> 1));
                bArr2[2] = (byte) ((i3 << 7) | 8);
                bArr2[3] = 0;
                return;
            }
            if (29 == i2) {
                byte[] bArr3 = this.mAsc;
                bArr3[0] = (byte) ((b << 3) | (i >> 1));
                bArr3[1] = (byte) ((i << 7) | 8 | (i3 >> 1));
                bArr3[2] = (byte) ((i3 << 7) | 8);
                bArr3[3] = 0;
            }
        }
    }

    public boolean configAndStartDecoder() {
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);
            createAudioFormat.setInteger("aac-profile", this.mProfile);
            createAudioFormat.setInteger("is-adts", this.mHasADTS);
            createAudioFormat.setInteger("aac-max-output-channel_count", this.mChannels);
            genAsc();
            createAudioFormat.setByteBuffer(CodecUtils.CSD_0, ByteBuffer.wrap(this.mAsc));
            this.mAACDecoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 0);
            this.mAACDecoder.start();
            this.mBufferInfo = new MediaCodec.BufferInfo();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            closeDecoder();
            RXLogging.e(TAG, "Config and Start Decoder Error");
            return false;
        }
    }

    public boolean decodeProcess(byte[] data) {
        try {
            MediaCodec mediaCodec = this.mAACDecoder;
            if (mediaCodec == null) {
                return false;
            }
            this.mDecodedData = null;
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(300L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer inputBuffer = this.mAACDecoder.getInputBuffer(dequeueInputBuffer);
                inputBuffer.clear();
                inputBuffer.put(data);
                this.mAACDecoder.queueInputBuffer(dequeueInputBuffer, 0, data.length, (this.input_ts * 1000000) / this.mSampleRate, 0);
            }
            int dequeueOutputBuffer = this.mAACDecoder.dequeueOutputBuffer(this.mBufferInfo, 0L);
            int i = this.mBufferInfo.size;
            if (i > 0 && dequeueOutputBuffer >= 0) {
                this.output_ts = (this.mBufferInfo.presentationTimeUs * this.mSampleRate) / 1000000;
                ByteBuffer outputBuffer = this.mAACDecoder.getOutputBuffer(dequeueOutputBuffer);
                byte[] bArr = new byte[i];
                this.mDecodedData = bArr;
                outputBuffer.get(bArr, this.mBufferInfo.offset, this.mBufferInfo.size);
                outputBuffer.clear();
                this.mOutputFormat = this.mAACDecoder.getOutputFormat(dequeueOutputBuffer);
                this.mAACDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "AAC Decoder Decode failed");
            return false;
        }
    }
}
