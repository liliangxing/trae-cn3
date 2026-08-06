package com.ss.ttm.player.UnifiedCodec.codec;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.ss.ttm.player.DummySurface;
import com.ss.ttm.player.UnifiedCodec.MediaCodecManager;
import com.ss.ttm.player.UnifiedCodec.UnifiedMediaCodec;
import com.ss.ttm.player.UnifiedCodec.callback.Callback;
import com.ss.ttm.player.UnifiedCodec.callback.CallbackWrapper;
import com.ss.ttm.player.UnifiedCodec.callback.CodecCallback;
import com.ss.ttm.player.UnifiedCodec.reuse.ReuseHelper;
import com.ss.ttm.player.UnifiedCodec.surface.GLSurfaceTexture;
import com.ss.ttm.player.UnifiedCodec.util.CodecUtils;
import com.ss.ttm.player.UnifiedCodec.util.DeviceUtils;
import com.ss.ttm.player.UnifiedCodec.util.ThreadManager;
import com.ss.vcbkit.VLog;
import java.util.HashSet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class ReuseCodecAdapter implements CodecAdapter {
    private static final int DEQUEUE_INPUT = 0;
    private static final int DEQUEUE_OUTPUT = 1;
    private static final int sDefaultReuseCnt = 3;
    private static final int sMaxTryAgainCnt = 100;
    private final ReuseHelper.AdaptationWorkaroundMode mAdaptationMode;
    public boolean mAdaptive;
    private GLSurfaceTexture mBackupSurfaceTexture;
    public CodecCallback mCallback;
    private CallbackWrapper mCallbackWrapper;
    private MediaCodecInfo.CodecCapabilities mCapabilities;
    public final MediaCodec mCodec;
    public final CodecMaxValues mCodecMaxValues;
    public final String mCodecName;
    private boolean mConfigureCalled;
    private DummySurface mDummySurface;
    public final FormatWrapper mFormat;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mHasReused;
    public boolean mIsRecycled;
    private boolean mReleaseCalled;
    private final boolean mReleaseCodecWhenError;
    private boolean mReusable;
    public boolean mSecure;
    public Surface mSurface;
    public DecodeState mDecodeState = DecodeState.Started;
    public final String mTag = "ReuseCodecAdapter[" + hashCode() + "]";
    private final HashSet<Integer> mHoldBufferOutIndex = new HashSet<>();
    private final int[] mDequeTryAgainCnt = new int[2];
    private CodecState mState = CodecState.Uninitialized;
    private ReuseHelper.ReuseResult mReuseResult = ReuseHelper.ReuseResult.CODEC_RESULT_NO;
    private boolean mErrorHappened = false;
    private boolean mHasAlwaysTryAgainError = false;
    private int mMaxReuseCount = 0;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class CodecResultGroup {
        public static final int[] ResultArray = {ReuseHelper.ReuseResult.CODEC_RESULT_NO.ordinal(), ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITH_FLUSH.ordinal(), ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITH_RECONFIGURATION.ordinal(), ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITHOUT_RECONFIGURATION.ordinal()};
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum CodecState {
        Uninitialized,
        Configured,
        Error,
        Flushed,
        Running,
        EndOfStream,
        Released
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum DecodeState {
        Started,
        DequeueIn,
        QueueIn,
        DequeueOut,
        ReleaseOut
    }

    public abstract ReuseHelper.ReuseResult canReuse(FormatWrapper formatWrapper);

    public ReuseCodecAdapter(MediaCodec mediaCodec, FormatWrapper formatWrapper) {
        this.mCodec = mediaCodec;
        this.mFormat = formatWrapper;
        this.mCodecMaxValues = new CodecMaxValues(formatWrapper.mMaxWidth, formatWrapper.mMaxHeight, formatWrapper.mMaxInputSize);
        String codeName = CodecUtils.getCodeName(mediaCodec);
        this.mCodecName = codeName;
        this.mAdaptationMode = ReuseHelper.codecAdaptationWorkaroundMode(codeName);
        this.mAdaptive = true;
        this.mSecure = false;
        this.mReusable = true;
        this.mReleaseCodecWhenError = false;
    }

    private void bindingToBackupSurface() {
        if (this.mDummySurface == null) {
            this.mDummySurface = DummySurface.newInstanceV17(false);
        }
        internalSetSurface(this.mDummySurface, true, true);
    }

    private int checkSurfaceState(Surface surface) {
        if (surface == null) {
            return 1003;
        }
        return !surface.isValid() ? 1004 : 0;
    }

    public static CodecAdapter create(MediaCodec mediaCodec, String mime, FormatWrapper formatWrapper) {
        if (CodecUtils.isVideo(mime)) {
            return new VideoCodecAdapter(mediaCodec, formatWrapper);
        }
        return new AudioCodecAdapter(mediaCodec, formatWrapper);
    }

    private void handleCodecException(int errorCode, String msg, Throwable th) {
        handleCodecException(errorCode, msg, th, false, this.mSurface);
    }

    private void internalSetSurface(Surface surface) {
        internalSetSurface(surface, true, false);
    }

    private boolean isAlwaysTryAgain(int dequeueFrom, int index) {
        if (index == -1) {
            int[] iArr = this.mDequeTryAgainCnt;
            int i = iArr[dequeueFrom] + 1;
            iArr[dequeueFrom] = i;
            return i > 100;
        }
        this.mDequeTryAgainCnt[dequeueFrom] = 0;
        return false;
    }

    private void onReuseCodec(MediaFormat mediaFormat) {
        int[] iArr = this.mDequeTryAgainCnt;
        iArr[0] = 0;
        iArr[1] = 0;
    }

    private final void processInputBufferWithConfigData(int index, int offset, int size, long presentationTimeUs, int flags) {
        this.mCodec.queueInputBuffer(index, offset, size, presentationTimeUs, flags);
    }

    private final void queueInputBufferForAdaptation(int index, int offset, int size, long presentationTimeUs, int flags) {
        int i = CodecResultGroup.ResultArray[this.mReuseResult.ordinal()];
        if (i == ReuseHelper.ReuseResult.CODEC_RESULT_NO.ordinal()) {
            VLog.m251w(this.mTag, "queueInputBufferForAdaptation error for KEEP_CODEC_RESULT_NO");
        } else if (i == ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITH_RECONFIGURATION.ordinal()) {
            processInputBufferWithConfigData(index, offset, size, presentationTimeUs, flags);
        } else if (i == ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITHOUT_RECONFIGURATION.ordinal()) {
            this.mCodec.queueInputBuffer(index, offset, size, presentationTimeUs, flags);
        }
    }

    private void codecConfigure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int flags) {
        int i;
        try {
            this.mCodec.configure(mediaFormat, surface, mediaCrypto, flags);
            setSurface(surface);
            this.mState = CodecState.Configured;
        } catch (Throwable th) {
            if (th instanceof IllegalStateException) {
                i = 1000;
            } else {
                i = th instanceof MediaCodec.CryptoException ? 1001 : 0;
            }
            handleCodecException(i, null, th, true, surface);
            throw th;
        }
    }

    private void releaseCodecWhenError(int errorCode) {
        if (this.mReleaseCodecWhenError && errorCode < 2000) {
            VLog.m246e(this.mTag, this + " releaseCodecWhenError, errorCode:" + errorCode);
            release();
        }
    }

    private void resetParameter() {
        this.mHasAlwaysTryAgainError = false;
        this.mMaxReuseCount = 0;
    }

    private void setSurface(Surface surface) {
        this.mSurface = surface;
    }

    private void trackDecodeApi(int dequeueFrom, int index) {
        if (this.mHasAlwaysTryAgainError || !isAlwaysTryAgain(dequeueFrom, index)) {
            return;
        }
        this.mHasAlwaysTryAgainError = true;
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(", trackDecodeApi state:");
        sb.append(this.mState);
        sb.append("  surfaceState:");
        Surface surface = this.mSurface;
        sb.append(surface != null ? Boolean.valueOf(surface.isValid()) : null);
        String sb2 = sb.toString();
        if (dequeueFrom == 0) {
            handleCodecException(2002, sb2, null);
        } else if (dequeueFrom == 1) {
            handleCodecException(CodecError.DEQUEUE_OUTPUT_ALWAYS_TRY_AGAIN, sb2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unBindingBackupSurface() {
        DummySurface dummySurface = this.mDummySurface;
        if (dummySurface != null) {
            dummySurface.release();
        }
        this.mDummySurface = null;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public ReuseHelper.ReuseResult canReuseType(FormatWrapper formatWrapper) {
        ReuseHelper.ReuseResult canReuse = canReuse(formatWrapper);
        this.mReuseResult = canReuse;
        return canReuse;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int flags) {
        this.mConfigureCalled = true;
        this.mReleaseCalled = false;
        if (this.mState == CodecState.Uninitialized) {
            codecConfigure(mediaFormat, surface, mediaCrypto, flags);
        } else if (surface != null) {
            onReuseCodec(mediaFormat);
            internalSetSurface(surface);
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public int dequeueInputBuffer(long timeoutUs) {
        int i;
        try {
            int dequeueInputBuffer = this.mCodec.dequeueInputBuffer(timeoutUs);
            this.mDecodeState = DecodeState.DequeueIn;
            this.mState = CodecState.Running;
            return dequeueInputBuffer;
        } catch (Throwable th) {
            if (th instanceof IllegalStateException) {
                i = 2000;
            } else {
                i = th instanceof IllegalArgumentException ? 2001 : 0;
            }
            handleCodecException(i, null, th);
            throw th;
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long timeoutUs) {
        int i;
        try {
            int dequeueOutputBuffer = this.mCodec.dequeueOutputBuffer(bufferInfo, timeoutUs);
            this.mHoldBufferOutIndex.add(Integer.valueOf(dequeueOutputBuffer));
            this.mDecodeState = DecodeState.DequeueOut;
            return dequeueOutputBuffer;
        } catch (Throwable th) {
            if (DeviceUtils.SDK_INT >= 21) {
                if (th instanceof MediaCodec.CodecException) {
                    i = CodecError.DEQUEUE_OUTPUT_CODEC_EXCEPTION;
                } else if (th instanceof IllegalStateException) {
                    i = 3000;
                }
                handleCodecException(i, null, th);
                throw th;
            }
            i = 0;
            handleCodecException(i, null, th);
            throw th;
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void flush() {
        int i;
        try {
            this.mCodec.flush();
            this.mState = CodecState.Flushed;
        } catch (Throwable th) {
            if (DeviceUtils.SDK_INT >= 21) {
                if (th instanceof MediaCodec.CodecException) {
                    i = 4001;
                } else if (th instanceof IllegalStateException) {
                    i = 4000;
                }
                handleCodecException(i, null, th);
                throw th;
            }
            i = 0;
            handleCodecException(i, null, th);
            throw th;
        }
    }

    public final CodecCallback getCallback() {
        return this.mCallback;
    }

    public String getCodecName() {
        return this.mCodecName;
    }

    public final FormatWrapper getFormat() {
        return this.mFormat;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public MediaCodec getMediaCodec() {
        return this.mCodec;
    }

    public boolean isNeedRetain() {
        return !this.mErrorHappened && this.mReusable && MediaCodecManager.getInstance().isEnableGlobalReuse() && MediaCodecManager.getInstance().isEnablePersistPool();
    }

    public final boolean isReleaseCalled() {
        return this.mReleaseCalled;
    }

    public boolean needToRemove() {
        return this.mMaxReuseCount >= 3;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void prepareReuse() {
        resetParameter();
        if (this.mState == CodecState.Running) {
            try {
                flush();
            } catch (IllegalStateException e) {
                VLog.m246e(this.mTag, "flush failed in prepareToReUse with  exception: " + e);
            }
        }
        this.mHasReused = true;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags) {
        int i;
        try {
            if (this.mHasReused) {
                queueInputBufferForAdaptation(index, offset, size, presentationTimeUs, flags);
            } else {
                this.mCodec.queueInputBuffer(index, offset, size, presentationTimeUs, flags);
            }
            this.mDecodeState = DecodeState.QueueIn;
        } catch (Throwable th) {
            if (DeviceUtils.SDK_INT >= 21) {
                if (th instanceof MediaCodec.CodecException) {
                    i = 5001;
                } else if (th instanceof IllegalStateException) {
                    i = 5000;
                } else if (th instanceof MediaCodec.CryptoException) {
                    i = 5002;
                }
                handleCodecException(i, "index = " + index + " offset = " + offset + " size = " + size + " presentationTimeUs = " + presentationTimeUs + " flags = " + flags, th);
                throw th;
            }
            i = 0;
            handleCodecException(i, "index = " + index + " offset = " + offset + " size = " + size + " presentationTimeUs = " + presentationTimeUs + " flags = " + flags, th);
            throw th;
        }
    }

    public final void recycle() {
        if (this.mIsRecycled) {
            VLog.m251w(this.mTag, "ignore recycle for has isRecycled is true.");
            return;
        }
        this.mConfigureCalled = false;
        this.mIsRecycled = true;
        if (this.mState != CodecState.Uninitialized) {
            try {
                VLog.m251w(this.mTag, "stop codec, state =" + this.mState);
                this.mCodec.stop();
            } catch (Throwable th) {
                VLog.m251w(this.mTag, "stop codec error =" + th.getLocalizedMessage() + " exception: " + th);
            }
        }
        ThreadManager.runInSub(new Runnable() { // from class: com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VLog.m251w(ReuseCodecAdapter.this.mTag, "release codec");
                    if (ReuseCodecAdapter.this.mHandlerThread != null) {
                        ReuseCodecAdapter.this.mHandlerThread.quit();
                    }
                    ReuseCodecAdapter.this.mCodec.release();
                } catch (Throwable th2) {
                    VLog.m251w(ReuseCodecAdapter.this.mTag, "recycle codec ignore error, exception: + " + th2);
                }
                if (ReuseCodecAdapter.this.mCallback != null) {
                    ReuseCodecAdapter.this.mCallback.onRelease();
                }
                ReuseCodecAdapter.this.unBindingBackupSurface();
            }
        });
        this.mState = CodecState.Uninitialized;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void release() {
        this.mReleaseCalled = true;
        this.mConfigureCalled = false;
        if (isNeedRetain()) {
            try {
                flush();
            } catch (IllegalStateException e) {
                VLog.m246e(this.mTag, "flush failed for not in the Executing state. exception : " + e);
            }
            bindingToBackupSurface();
            MediaCodecManager.getInstance().recycleCodecFromRunning(this);
            return;
        }
        MediaCodecManager.getInstance().removeCodecFromRunningPool(this);
        recycle();
        this.mState = CodecState.Released;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void releaseOutputBuffer(int index, boolean render) {
        int i;
        try {
            this.mHoldBufferOutIndex.remove(Integer.valueOf(index));
            this.mCodec.releaseOutputBuffer(index, render);
        } catch (Throwable th) {
            if (this.mState != CodecState.Flushed) {
                VLog.m251w(this.mTag, this + ", releaseOutputBuffer failed, ignore e:" + th);
            }
            if (DeviceUtils.SDK_INT >= 21) {
                if (th instanceof MediaCodec.CodecException) {
                    i = CodecError.RELEASE_OUTPUT_CODEC_EXCEPTION;
                } else if (th instanceof IllegalStateException) {
                    i = CodecError.RELEASE_OUTPUT_ILLEGAL;
                }
                handleCodecException(i, this.mTag, th);
            }
            i = 0;
            handleCodecException(i, this.mTag, th);
        }
        this.mDecodeState = DecodeState.ReleaseOut;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void reset() {
        int i;
        try {
            if (isNeedRetain()) {
                return;
            }
            this.mCodec.reset();
            this.mState = CodecState.Uninitialized;
        } catch (Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                i = CodecError.RESET_CODEC_EXCEPTION;
            } else {
                i = th instanceof IllegalStateException ? CodecError.RESET_ILLEGAL : 0;
            }
            handleCodecException(i, null, th);
            throw th;
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void setCodecCallback(CodecCallback codecCallback) {
        this.mCallback = codecCallback;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void setOutputSurface(Surface surface) {
        internalSetSurface(surface, false, false);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void start() {
        int i;
        try {
            if (this.mState == CodecState.Configured || (this.mState == CodecState.Flushed && this.mCallbackWrapper != null)) {
                this.mCodec.start();
                this.mState = CodecState.Running;
            }
        } catch (Throwable th) {
            if (DeviceUtils.SDK_INT >= 21) {
                if (th instanceof MediaCodec.CodecException) {
                    i = CodecError.START_CODEC_EXCEPTION;
                } else if (th instanceof IllegalStateException) {
                    i = CodecError.START_ILLEGAL;
                }
                handleCodecException(i, null, th);
                throw th;
            }
            i = 0;
            handleCodecException(i, null, th);
            throw th;
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void stop() {
        if (isNeedRetain()) {
            return;
        }
        try {
            this.mCodec.stop();
            this.mState = CodecState.Uninitialized;
        } catch (IllegalStateException e) {
            this.mErrorHappened = true;
            this.mState = CodecState.Uninitialized;
            VLog.m246e(this.mTag, "stop failed with exception: " + e);
            throw e;
        }
    }

    public String toString() {
        return super.toString() + " mReleaseCalled:" + this.mReleaseCalled + " isRecycled:" + this.mIsRecycled;
    }

    public void trackReuseCnt() {
        this.mMaxReuseCount++;
    }

    private void handleCodecException(int erroCode, String msg, Throwable th, boolean checkSurface, Surface surface) {
        int checkSurfaceState;
        this.mErrorHappened = true;
        String str = msg + "exception:" + (th == null ? "" : th.getLocalizedMessage());
        if (checkSurface && (checkSurfaceState = checkSurfaceState(surface)) != 0) {
            erroCode = checkSurfaceState;
        }
        CodecCallback codecCallback = this.mCallback;
        if (codecCallback != null) {
            codecCallback.onCodecException(str, th);
        }
        VLog.m246e(this.mTag, "hasReused:" + this.mHasReused + "errorCode:" + erroCode + ", " + str + " e:" + th);
        releaseCodecWhenError(erroCode);
    }

    private void internalSetSurface(Surface surface, boolean innerCall, boolean bindingBackupSurface) {
        int i;
        try {
            setSurface(surface);
            this.mCodec.setOutputSurface(surface);
        } catch (Throwable th) {
            if (th instanceof IllegalStateException) {
                i = 8000;
            } else {
                i = th instanceof IllegalArgumentException ? 8001 : 0;
            }
            handleCodecException(i, null, th, true, surface);
            throw th;
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void configure(MediaFormat mediaFormat, Surface surface, int flags, MediaDescrambler mediaDescrambler) {
        this.mConfigureCalled = true;
        this.mReleaseCalled = false;
        if (this.mState == CodecState.Uninitialized) {
            codecConfigure(mediaFormat, surface, flags, mediaDescrambler);
        } else if (surface != null) {
            onReuseCodec(mediaFormat);
            internalSetSurface(surface);
        }
    }

    private void codecConfigure(MediaFormat mediaFormat, Surface surface, int flags, MediaDescrambler mediaDescrambler) {
        int i;
        try {
            this.mCodec.configure(mediaFormat, surface, flags, mediaDescrambler);
            setSurface(surface);
            this.mState = CodecState.Configured;
        } catch (Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                i = 1002;
            } else {
                i = !(th instanceof IllegalStateException) ? th instanceof MediaCodec.CryptoException ? 1001 : 0 : 1000;
            }
            handleCodecException(i, null, th, true, surface);
            throw th;
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void releaseOutputBuffer(int index, long renderTimestampNs) {
        int i;
        this.mHoldBufferOutIndex.remove(Integer.valueOf(index));
        try {
            this.mCodec.releaseOutputBuffer(index, renderTimestampNs);
            this.mDecodeState = DecodeState.ReleaseOut;
        } catch (Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                i = CodecError.RELEASE_OUTPUT_CODEC_EXCEPTION;
            } else {
                i = th instanceof IllegalStateException ? CodecError.RELEASE_OUTPUT_ILLEGAL : 0;
            }
            handleCodecException(i, this + ", releaseOutputBuffer index:" + index + " renderTimestampNs:" + renderTimestampNs, th);
            throw th;
        }
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
        } else {
            callbackWrapper.setCallback(callback);
            this.mCallbackWrapper.setMediaCodec(codec);
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void setCallback(UnifiedMediaCodec codec, Callback callback, Handler handler) {
        if (DeviceUtils.SDK_INT < 23) {
            return;
        }
        CallbackWrapper callbackWrapper = this.mCallbackWrapper;
        if (callbackWrapper == null) {
            this.mCallbackWrapper = new CallbackWrapper(codec, callback);
            HandlerThread handlerThread = new HandlerThread("mc2_async");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            Handler handler2 = new Handler(this.mHandlerThread.getLooper());
            this.mHandler = handler2;
            this.mCodec.setCallback(this.mCallbackWrapper, handler2);
            return;
        }
        callbackWrapper.setCallback(callback);
        this.mCallbackWrapper.setMediaCodec(codec);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public Handler getCodecHandler() {
        return this.mHandler;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public void setReusable(boolean reuse) {
        VLog.m251w(this.mTag, "setReusable =" + reuse);
        this.mReusable = reuse;
    }

    @Override // com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter
    public boolean checkCodecError() {
        return this.mErrorHappened;
    }
}
