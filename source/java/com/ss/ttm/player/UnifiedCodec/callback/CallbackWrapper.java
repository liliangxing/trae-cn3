package com.ss.ttm.player.UnifiedCodec.callback;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.ss.ttm.player.UnifiedCodec.UnifiedMediaCodec;

/* loaded from: classes7.dex */
public final class CallbackWrapper extends MediaCodec.Callback {
    private Callback mCallback;
    private UnifiedMediaCodec mUnifiedMediaCodec;

    public CallbackWrapper(UnifiedMediaCodec unifiedMediaCodec, Callback callback) {
        this.mUnifiedMediaCodec = unifiedMediaCodec;
        this.mCallback = callback;
    }

    public final void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setMediaCodec(UnifiedMediaCodec unifiedMediaCodec) {
        this.mUnifiedMediaCodec = unifiedMediaCodec;
    }

    public final Callback getCallback() {
        return this.mCallback;
    }

    public final UnifiedMediaCodec getMediaCodec() {
        return this.mUnifiedMediaCodec;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onError(this.mUnifiedMediaCodec, codecException);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int index) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onInputBufferAvailable(this.mUnifiedMediaCodec, index);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int index, MediaCodec.BufferInfo bufferInfo) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onOutputBufferAvailable(this.mUnifiedMediaCodec, index, bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onOutputFormatChanged(this.mUnifiedMediaCodec, mediaFormat);
        }
    }
}
