package com.ss.ttm.player.UnifiedCodec.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.ss.ttm.player.UnifiedCodec.UnifiedMediaCodec;
import com.ss.ttm.player.UnifiedCodec.callback.Callback;
import com.ss.ttm.player.UnifiedCodec.callback.CodecCallback;
import com.ss.ttm.player.UnifiedCodec.reuse.ReuseHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface CodecAdapter {
    ReuseHelper.ReuseResult canReuseType(FormatWrapper formatWrapper);

    boolean checkCodecError();

    void configure(MediaFormat mediaFormat, Surface surface, int flags, MediaDescrambler mediaDescrambler);

    void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int flags);

    int dequeueInputBuffer(long timeoutUs);

    int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long timeoutUs);

    void flush();

    Handler getCodecHandler();

    MediaCodec getMediaCodec();

    void prepareReuse();

    void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags);

    void release();

    void releaseOutputBuffer(int index, long renderTimestampNs);

    void releaseOutputBuffer(int index, boolean render);

    void reset();

    void setCallback(UnifiedMediaCodec codec, Callback callback);

    void setCallback(UnifiedMediaCodec codec, Callback callback, Handler handler);

    void setCodecCallback(CodecCallback codecCallback);

    void setOutputSurface(Surface surface);

    void setReusable(boolean reuse);

    void start();

    void stop();
}
