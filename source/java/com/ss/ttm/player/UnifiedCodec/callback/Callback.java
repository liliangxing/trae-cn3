package com.ss.ttm.player.UnifiedCodec.callback;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.ss.ttm.player.UnifiedCodec.UnifiedMediaCodec;

/* loaded from: classes7.dex */
public abstract class Callback {
    public abstract void onError(UnifiedMediaCodec unifiedMediaCodec, MediaCodec.CodecException codecException);

    public abstract void onInputBufferAvailable(UnifiedMediaCodec unifiedMediaCodec, int index);

    public abstract void onOutputBufferAvailable(UnifiedMediaCodec unifiedMediaCodec, int index, MediaCodec.BufferInfo bufferInfo);

    public abstract void onOutputFormatChanged(UnifiedMediaCodec unifiedMediaCodec, MediaFormat mediaFormat);
}
