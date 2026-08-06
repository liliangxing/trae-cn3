package com.ss.bytertc.engine;

import com.ss.bytertc.engine.adapter.VideoSinkAdapter;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.NativeWTNStreamEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IVideoSink;
import com.ss.bytertc.engine.video.RemoteVideoSinkConfig;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class WTNStream implements IWTNStream {
    private static final String TAG = "WTNStream";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    NativeWTNStreamEventHandler mNativeHandler;
    private long mNativeWTNStream;
    private final ReentrantReadWriteLock mReadWriteLock;
    private WeakReference<IWTNStreamEventHandler> mWTNStreamEventHandler;

    public WTNStream(long nativeWTNStream) {
        this.mNativeWTNStream = 0L;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeWTNStream = nativeWTNStream;
        this.mNativeHandler = new NativeWTNStreamEventHandler(this);
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int subscribeWTNVideoStream(String streamId, boolean subscribe) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeWTNStream == 0) {
                LogUtil.m216e(TAG, "native WTNStream is invalid, subscribeWTNVideoStream failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            LogUtil.m215d(TAG, "subscribeWTNVideoStream...public stream id: " + streamId + ", subscribe: " + subscribe);
            return NativeWTNStreamFunctions.nativeSubscribeWTNVideoStream(this.mNativeWTNStream, streamId, subscribe);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int subscribeWTNAudioStream(String streamId, boolean subscribe) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeWTNStream == 0) {
                LogUtil.m216e(TAG, "native WTNStream is invalid, subscribeWTNAudioStream failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            LogUtil.m215d(TAG, "subscribeWTNAudioStream...public stream id: " + streamId + ", subscribe: " + subscribe);
            return NativeWTNStreamFunctions.nativeSubscribeWTNAudioStream(this.mNativeWTNStream, streamId, subscribe);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int setWTNRemoteVideoCanvas(String streamId, VideoCanvas canvas) {
        int nativeSetWTNRemoteVideoCanvas;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeWTNStream == 0) {
                LogUtil.m216e(TAG, "native engine is invalid, setWTNRemoteVideoCanvas failed.");
                nativeSetWTNRemoteVideoCanvas = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                LogUtil.m215d(TAG, "setWTNRemoteVideoCanvas...public stream id: " + streamId);
                nativeSetWTNRemoteVideoCanvas = NativeWTNStreamFunctions.nativeSetWTNRemoteVideoCanvas(this.mNativeWTNStream, streamId, canvas.renderView, canvas.renderMode, canvas.backgroundColor, canvas.renderRotation.value());
            }
            return nativeSetWTNRemoteVideoCanvas;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int setWTNRemoteVideoSink(String streamId, IVideoSink videoSink, RemoteVideoSinkConfig config) {
        int nativeSetWTNRemoteVideoSink;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeWTNStream == 0) {
                LogUtil.m216e(TAG, "native engine is invalid, setWTNRemoteVideoSink failed.");
                nativeSetWTNRemoteVideoSink = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                LogUtil.m215d(TAG, "setWTNRemoteVideoSink...public stream id: " + streamId);
                nativeSetWTNRemoteVideoSink = NativeWTNStreamFunctions.nativeSetWTNRemoteVideoSink(this.mNativeWTNStream, streamId, videoSink != null ? new VideoSinkAdapter(videoSink) : null, config.pixelFormat.value(), config.position.getValue(), config.applyRotation.getValue(), config.mirrorType.getValue());
            }
            return nativeSetWTNRemoteVideoSink;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int setWTNRemoteAudioPlaybackVolume(String streamId, int volume) {
        int nativeSetWTNRemoteAudioPlaybackVolume;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeWTNStream == 0) {
                LogUtil.m216e(TAG, "native engine is invalid, setWTNRemoteAudioPlaybackVolume failed.");
                nativeSetWTNRemoteAudioPlaybackVolume = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                LogUtil.m215d(TAG, "setWTNRemoteAudioPlaybackVolume...public stream id: " + streamId + ", volume: " + volume);
                nativeSetWTNRemoteAudioPlaybackVolume = NativeWTNStreamFunctions.nativeSetWTNRemoteAudioPlaybackVolume(this.mNativeWTNStream, streamId, volume);
            }
            return nativeSetWTNRemoteAudioPlaybackVolume;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int setWTNStreamEventHandler(IWTNStreamEventHandler handler) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeWTNStream == 0) {
                LogUtil.m216e(TAG, "native WTNStream is invalid, setWTNStreamEventHandler failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            this.mWTNStreamEventHandler = new WeakReference<>(handler);
            if (handler == null) {
                return NativeWTNStreamFunctions.nativeSetWTNStreamEventHandler(this.mNativeWTNStream, null);
            }
            return NativeWTNStreamFunctions.nativeSetWTNStreamEventHandler(this.mNativeWTNStream, this.mNativeHandler);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public IWTNStreamEventHandler getWTNStreamEventHandler() {
        return this.mWTNStreamEventHandler.get();
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int registerWTNAudioFrameObserver(IWTNAudioFrameObserver observer) {
        int nativeRegisterWTNAudioFrameObserver;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeWTNStream == 0) {
                LogUtil.m216e(TAG, "native engine is invalid, registerWTNAudioFrameObserver failed.");
                nativeRegisterWTNAudioFrameObserver = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                LogUtil.m215d(TAG, "registerWTNAudioFrameObserver...");
                nativeRegisterWTNAudioFrameObserver = NativeWTNStreamFunctions.nativeRegisterWTNAudioFrameObserver(this.mNativeWTNStream, observer);
            }
            return nativeRegisterWTNAudioFrameObserver;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public void enableWTNRemoteAudioFrameCallback(boolean enable) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeWTNStream == 0) {
                LogUtil.m216e(TAG, "native engine is invalid, enableWTNRemoteAudioFrameCallback failed.");
            }
            LogUtil.m215d(TAG, "enableWTNRemoteAudioFrameCallback...");
            NativeWTNStreamFunctions.nativeEnableWTNRemoteAudioFrameCallback(this.mNativeWTNStream, enable);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            NativeWTNStreamFunctions.nativeDestroy(this.mNativeWTNStream);
            this.mNativeWTNStream = 0L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }
}
