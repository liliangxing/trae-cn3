package com.lynx.animax.player;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import com.lynx.animax.player.CodecManager;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.UIThreadUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class VideoPlayerImpl extends AbsVideoPlayer implements SurfaceTexture.OnFrameAvailableListener, CodecManager.CodecErrorReporter {
    private static final long DESTROY_TIMEOUT_MS = 1000;
    private static final long FRAME_AVAILABLE_TIMEOUT_MS = 20;
    private static final String TAG = "VideoPlayerImpl";
    private Handler mCallingThreadHandler;
    private CodecManager mCodecManager;
    private volatile boolean mIsDestroyed;
    private boolean mSurfaceTextureAvailable;
    private Condition mSurfaceTextureCondition;
    private Lock mSurfaceTextureLock;

    public VideoPlayerImpl(long j, VideoPlayerConfig videoPlayerConfig) {
        super(j, videoPlayerConfig);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mSurfaceTextureLock = reentrantLock;
        this.mSurfaceTextureCondition = reentrantLock.newCondition();
        this.mIsDestroyed = false;
        initCodecThread();
        postToCodecThread(new Runnable() { // from class: com.lynx.animax.player.VideoPlayerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                VideoPlayerImpl.this.mCodecManager = new CodecManager(VideoPlayerImpl.this);
                VideoPlayerImpl.this.mCodecManager.resetDecoderState();
            }
        });
        if (this.mConfig.getVideoFrameTimeout() <= 0) {
            this.mConfig.setVideoFrameTimeout(FRAME_AVAILABLE_TIMEOUT_MS);
        }
        if (this.mConfig.getSurfaceDestroyTimeout() <= 0) {
            this.mConfig.setSurfaceDestroyTimeout(1000L);
        }
    }

    @Override // com.lynx.animax.player.AbsVideoPlayer, com.lynx.animax.player.IVideoPlayer
    public void attachAsset(final VideoAsset videoAsset) {
        super.attachAsset(videoAsset);
        postToCodecThreadWhenCodecReady(new Runnable() { // from class: com.lynx.animax.player.VideoPlayerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                VideoPlayerImpl.this.mCodecManager.attachAsset(videoAsset);
            }
        });
    }

    @Override // com.lynx.animax.player.AbsVideoPlayer, com.lynx.animax.player.IVideoPlayer
    public void setSurface(int i) {
        super.setSurface(i);
        this.mSurfaceTextureAvailable = false;
        this.mSurfaceTexture.setOnFrameAvailableListener(this, UIThreadUtils.getUiThreadHandler());
        if (this.mAsset == null) {
            AnimaXLog.m2540e(TAG, "setSurface error: mAsset is null");
        } else {
            postToCodecThreadWhenCodecReady(new Runnable() { // from class: com.lynx.animax.player.VideoPlayerImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoPlayerImpl.this.mCodecManager.attachSurface(VideoPlayerImpl.this.mSurface);
                    VideoPlayerImpl.this.mCodecManager.initDecoder();
                }
            });
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mSurfaceTextureLock.lock();
        this.mSurfaceTextureAvailable = true;
        try {
            this.mSurfaceTextureCondition.signalAll();
        } finally {
            this.mSurfaceTextureLock.unlock();
        }
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public boolean updateSurface(final int i) {
        if (this.mIsDestroyed) {
            return false;
        }
        postToCodecThreadWhenCodecReady(new Runnable() { // from class: com.lynx.animax.player.VideoPlayerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                VideoPlayerImpl.this.mCodecManager.decodeAndUploadFrame(i);
            }
        });
        return updateTexImageIfNecessary();
    }

    @Override // com.lynx.animax.player.AbsVideoPlayer, com.lynx.animax.player.IVideoPlayer
    public void destroy() {
        if (this.mIsDestroyed) {
            return;
        }
        this.mIsDestroyed = true;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CodecThreadManager.getInstance().postAtFrontAndClearQueue(new Runnable() { // from class: com.lynx.animax.player.VideoPlayerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayerImpl.this.mCodecManager != null) {
                    VideoPlayerImpl.this.mCodecManager.setReporter(null);
                    VideoPlayerImpl.this.mCodecManager.releaseDecoder();
                }
                countDownLatch.countDown();
            }
        });
        try {
            long surfaceDestroyTimeout = this.mConfig.getSurfaceDestroyTimeout();
            AnimaXLog.m2541i(TAG, "destroy: wait for codec thread to complete destroy tasks with " + surfaceDestroyTimeout + "ms");
            if (!countDownLatch.await(surfaceDestroyTimeout, TimeUnit.MILLISECONDS)) {
                AnimaXLog.m2543w(TAG, "Timeout waiting for codec thread to complete destroy tasks");
            }
        } catch (InterruptedException unused) {
            AnimaXLog.m2543w(TAG, "Interrupted while waiting for codec thread to complete destroy tasks");
            Thread.currentThread().interrupt();
        }
        super.destroy();
    }

    @Override // com.lynx.animax.player.CodecManager.CodecErrorReporter
    public void reportError(final String str) {
        runNowOrPostToGLThread(new Runnable() { // from class: com.lynx.animax.player.VideoPlayerImpl.6
            @Override // java.lang.Runnable
            public void run() {
                VideoPlayerImpl.this.reportErrorOnce(str);
            }
        });
    }

    @Override // com.lynx.animax.player.CodecManager.CodecErrorReporter
    public void markDrawnOnce() {
        runNowOrPostToGLThread(new Runnable() { // from class: com.lynx.animax.player.VideoPlayerImpl.7
            @Override // java.lang.Runnable
            public void run() {
                VideoPlayerImpl.this.hasDrewOnce();
            }
        });
    }

    private boolean updateTexImageIfNecessary() {
        boolean z;
        ensureCurrentThreadIsGLThread();
        this.mSurfaceTextureLock.lock();
        try {
            if (!this.mSurfaceTextureAvailable) {
                try {
                    this.mSurfaceTextureCondition.await(this.mConfig.getVideoFrameTimeout(), TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    AnimaXLog.m2540e(TAG, "await onFrameAvailable error: " + e);
                }
                z = this.mSurfaceTextureAvailable;
            } else {
                this.mSurfaceTextureAvailable = false;
                this.mSurfaceTextureLock.unlock();
                z = true;
            }
            if (!z) {
                AnimaXLog.m2540e(TAG, "await onFrameAvailable time out");
                return false;
            }
            this.mSurfaceTexture.updateTexImage();
            return true;
        } finally {
            this.mSurfaceTextureAvailable = false;
            this.mSurfaceTextureLock.unlock();
        }
    }

    private void initCodecThread() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mCallingThreadHandler = new Handler(myLooper);
        }
    }

    private void postToCodecThread(Runnable runnable) {
        if (this.mIsDestroyed) {
            return;
        }
        CodecThreadManager.getInstance().runNowOrPostToCodecThread(runnable);
    }

    private void postToCodecThreadWhenCodecReady(final Runnable runnable) {
        postToCodecThread(new Runnable() { // from class: com.lynx.animax.player.VideoPlayerImpl.8
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayerImpl.this.mCodecManager != null) {
                    runnable.run();
                }
            }
        });
    }

    private void runNowOrPostToGLThread(Runnable runnable) {
        if (this.mCallingThreadHandler != null) {
            if (Looper.myLooper() == this.mCallingThreadHandler.getLooper()) {
                runnable.run();
                return;
            } else {
                this.mCallingThreadHandler.post(runnable);
                return;
            }
        }
        AnimaXLog.m2540e(TAG, "Attempted to post to GL thread after it was released or not alive.");
    }

    private void ensureCurrentThreadIsGLThread() {
        if (this.mCallingThreadHandler == null || Looper.myLooper() != this.mCallingThreadHandler.getLooper()) {
            throw new IllegalStateException("Must be called on GL thread, current: " + Thread.currentThread().getName());
        }
    }

    private void ensureCurrentThreadIsCodecThread() {
        CodecThreadManager.getInstance().ensureOnCodecThread();
    }
}
