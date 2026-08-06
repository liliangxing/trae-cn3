package com.ss.ttm.player.UnifiedCodec.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.ss.ttm.player.UnifiedCodec.UnifiedMediaCodec;
import com.ss.ttm.player.UnifiedCodec.callback.Callback;
import com.ss.ttm.player.UnifiedCodec.callback.CallbackWrapper;
import com.ss.ttm.player.UnifiedCodec.callback.CodecCallback;
import com.ss.ttm.player.UnifiedCodec.reuse.ReuseHelper;
import com.ss.ttm.player.UnifiedCodec.util.DeviceUtils;
import com.ss.vcbkit.VLog;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class DirectCodecAdapter implements CodecAdapter {
    public static final String TAG = "DirectCodecAdapter";
    private static AtomicInteger sCodecNum = new AtomicInteger(0);
    private CallbackWrapper mCallbackWrapper;
    private final MediaCodec mCodec;
    private boolean mErrorHappened = false;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void setReusable(boolean reuse) {
    }

    public DirectCodecAdapter(MediaCodec mediaCodec) {
        this.mCodec = mediaCodec;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public ReuseHelper.ReuseResult canReuseType(FormatWrapper formatWrapper) {
        return ReuseHelper.ReuseResult.CODEC_RESULT_NO;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int flags) {
        try {
            this.mCodec.configure(mediaFormat, surface, mediaCrypto, flags);
        } catch (Exception e) {
            this.mErrorHappened = true;
            throw e;
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public int dequeueInputBuffer(long timeoutUs) {
        return this.mCodec.dequeueInputBuffer(timeoutUs);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long timeoutUs) {
        return this.mCodec.dequeueOutputBuffer(bufferInfo, timeoutUs);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void flush() {
        this.mCodec.flush();
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public MediaCodec getMediaCodec() {
        return this.mCodec;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void prepareReuse() {
        VLog.m251w(TAG, "DirectCodecAdapter prepareReuse ignore...");
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags) {
        this.mCodec.queueInputBuffer(index, offset, size, presentationTimeUs, flags);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void release() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.mCodec.release();
        sCodecNum.decrementAndGet();
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void releaseOutputBuffer(int index, boolean render) {
        this.mCodec.releaseOutputBuffer(index, render);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void reset() {
        if (DeviceUtils.SDK_INT >= 21) {
            this.mCodec.reset();
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void setCodecCallback(CodecCallback codecCallback) {
        VLog.m251w(TAG, "DirectCodecAdapter setCodecCallback not implemented");
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void setCallback(UnifiedMediaCodec codec, Callback callback) {
        if (DeviceUtils.SDK_INT < 21) {
            return;
        }
        CallbackWrapper callbackWrapper = this.mCallbackWrapper;
        if (callbackWrapper == null) {
            CallbackWrapper callbackWrapper2 = new CallbackWrapper(codec, callback);
            this.mCallbackWrapper = callbackWrapper2;
            this.mCodec.setCallback(callbackWrapper2);
            return;
        }
        callbackWrapper.setCallback(callback);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void setCallback(UnifiedMediaCodec codec, Callback callback, Handler handler) {
        if (DeviceUtils.SDK_INT < 23) {
            return;
        }
        CallbackWrapper callbackWrapper = this.mCallbackWrapper;
        if (callbackWrapper == null) {
            HandlerThread handlerThread = new HandlerThread("mc2_async_direct");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mCallbackWrapper = new CallbackWrapper(codec, callback);
            Handler handler2 = new Handler(this.mHandlerThread.getLooper());
            this.mHandler = handler2;
            this.mCodec.setCallback(this.mCallbackWrapper, handler2);
            return;
        }
        callbackWrapper.setCallback(callback);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void setOutputSurface(Surface surface) {
        if (DeviceUtils.SDK_INT >= 23) {
            this.mCodec.setOutputSurface(surface);
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void start() {
        this.mCodec.start();
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void stop() {
        this.mCodec.stop();
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public boolean checkCodecError() {
        return this.mErrorHappened;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void configure(MediaFormat mediaFormat, Surface surface, int flags, MediaDescrambler mediaDescrambler) {
        if (DeviceUtils.SDK_INT >= 26) {
            try {
                this.mCodec.configure(mediaFormat, surface, flags, mediaDescrambler);
            } catch (Exception e) {
                VLog.m246e(TAG, "DirectCodecAdapter configure exception:" + e);
                this.mErrorHappened = true;
                throw e;
            }
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void releaseOutputBuffer(int index, long renderTimestampNs) {
        if (DeviceUtils.SDK_INT >= 21) {
            this.mCodec.releaseOutputBuffer(index, renderTimestampNs);
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public Handler getCodecHandler() {
        return this.mHandler;
    }
}
