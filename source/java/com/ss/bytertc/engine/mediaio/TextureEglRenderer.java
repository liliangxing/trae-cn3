package com.ss.bytertc.engine.mediaio;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.EglRenderer;
import com.ss.bytertc.engine.p006ui.VideoFrameRender;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextureEglRenderer extends EglRenderer implements TextureView.SurfaceTextureListener {
    private static final String TAG = "TextureEglRenderer";
    private final AtomicBoolean mHasBindAtomic;
    private final AtomicBoolean mHasInitAtomic;
    private VideoFrameRender.SurfaceLifecycleCallback mSurfaceLifecycleCallback;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private final Object mSurfaceTextureListenerLock;
    private volatile WeakReference<TextureView> mTextureViewRef;
    private final Handler mainHandler;

    public TextureEglRenderer(final String name) {
        super(name);
        this.mSurfaceTextureListenerLock = new Object();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mHasInitAtomic = new AtomicBoolean(false);
        this.mHasBindAtomic = new AtomicBoolean(false);
        this.mTextureViewRef = new WeakReference<>(null);
    }

    @Override // com.ss.bytertc.base.media.EglRenderer
    public void init(EglBase.Context sharedContext, int[] configAttributes, RendererCommon.GlDrawer drawer) {
        if (this.mHasInitAtomic.compareAndSet(false, true)) {
            LogUtil.m215d(TAG, "init");
            super.init(sharedContext, configAttributes, drawer);
            return;
        }
        throw new IllegalStateException("TextureEglRenderer has already init!!!!!!");
    }

    public void bind(final TextureView textureView, VideoFrameRender.SurfaceLifecycleCallback callback) {
        if (!this.mHasInitAtomic.get()) {
            throw new IllegalStateException("TextureEglRenderer has not init!!!!!!");
        }
        if (!this.mHasBindAtomic.compareAndSet(false, true)) {
            throw new IllegalStateException("Called bind functions multiple times!!!!!!");
        }
        LogUtil.m215d(TAG, "bind");
        this.mTextureViewRef = new WeakReference<>(textureView);
        this.mSurfaceLifecycleCallback = callback;
        runOnUIThread(new Runnable() { // from class: com.ss.bytertc.engine.mediaio.TextureEglRenderer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                TextureEglRenderer.this.m4170lambda$bind$0$comssbytertcenginemediaioTextureEglRenderer(textureView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$bind$0$com-ss-bytertc-engine-mediaio-TextureEglRenderer, reason: not valid java name */
    public /* synthetic */ void m4170lambda$bind$0$comssbytertcenginemediaioTextureEglRenderer(TextureView textureView) {
        if (textureView.getSurfaceTexture() != null) {
            createEglSurface(textureView.getSurfaceTexture());
            VideoFrameRender.SurfaceLifecycleCallback surfaceLifecycleCallback = this.mSurfaceLifecycleCallback;
            if (surfaceLifecycleCallback != null) {
                surfaceLifecycleCallback.onCreated();
            }
        }
        textureView.setSurfaceTextureListener(this);
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener listener) {
        synchronized (this.mSurfaceTextureListenerLock) {
            this.mSurfaceTextureListener = listener;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(final SurfaceTexture surface, final int width, final int height) {
        ThreadUtils.checkIsOnMainThread();
        LogUtil.m215d(TAG, "onSurfaceTextureAvailable");
        createEglSurface(surface);
        VideoFrameRender.SurfaceLifecycleCallback surfaceLifecycleCallback = this.mSurfaceLifecycleCallback;
        if (surfaceLifecycleCallback != null) {
            surfaceLifecycleCallback.onCreated();
        }
        synchronized (this.mSurfaceTextureListenerLock) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureAvailable(surface, width, height);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(final SurfaceTexture surface, final int width, final int height) {
        LogUtil.m215d(TAG, "onSurfaceTextureSizeChanged");
        synchronized (this.mSurfaceTextureListenerLock) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureSizeChanged(surface, width, height);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(final SurfaceTexture surface) {
        ThreadUtils.checkIsOnMainThread();
        LogUtil.m215d(TAG, "onSurfaceTextureDestroyed");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Objects.requireNonNull(countDownLatch);
        releaseEglSurface(new Runnable() { // from class: com.ss.bytertc.engine.mediaio.TextureEglRenderer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                countDownLatch.countDown();
            }
        });
        if (mDestroyTimeoutMs <= 0) {
            ThreadUtils.awaitUninterruptibly(countDownLatch);
        } else {
            ThreadUtils.awaitUninterruptibly(countDownLatch, mDestroyTimeoutMs);
        }
        VideoFrameRender.SurfaceLifecycleCallback surfaceLifecycleCallback = this.mSurfaceLifecycleCallback;
        if (surfaceLifecycleCallback != null) {
            surfaceLifecycleCallback.onDestroy();
        }
        synchronized (this.mSurfaceTextureListenerLock) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureDestroyed(surface);
            }
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(final SurfaceTexture surface) {
        synchronized (this.mSurfaceTextureListenerLock) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureUpdated(surface);
            }
        }
    }

    @Override // com.ss.bytertc.base.media.EglRenderer, com.ss.bytertc.base.media.VideoSink
    public void onFrame(final VideoFrame frame) {
        if (this.mHasInitAtomic.get() && this.mHasBindAtomic.get() && this.mTextureViewRef != null) {
            TextureView textureView = this.mTextureViewRef.get();
            if (frame == null || textureView == null || !textureView.isShown()) {
                return;
            }
            if (frame.getBuffer() instanceof CountDownLatchI420Buffer) {
                final CountDownLatchI420Buffer buffer = frame.getBuffer();
                buffer.retain();
                if (postOnMainThreadAndLock(new Runnable() { // from class: com.ss.bytertc.engine.mediaio.TextureEglRenderer$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextureEglRenderer.this.m213x750fe1d1(frame, buffer);
                    }
                }, buffer.getLatch())) {
                    return;
                }
                buffer.release();
                return;
            }
            super.onFrame(frame);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onFrame$1$com-ss-bytertc-engine-mediaio-TextureEglRenderer */
    public /* synthetic */ void m213x750fe1d1(VideoFrame videoFrame, CountDownLatchI420Buffer countDownLatchI420Buffer) {
        super.onFrame(videoFrame);
        countDownLatchI420Buffer.release();
    }

    @Override // com.ss.bytertc.base.media.EglRenderer
    public void release() {
        TextureView textureView;
        if (!this.mHasInitAtomic.compareAndSet(true, false)) {
            throw new IllegalStateException("TextureEglRenderer has not init or already released!!!!!");
        }
        LogUtil.m215d(TAG, "release");
        super.release();
        this.mHasBindAtomic.compareAndSet(true, false);
        if (this.mTextureViewRef == null || (textureView = this.mTextureViewRef.get()) == null) {
            return;
        }
        textureView.setSurfaceTextureListener(null);
    }

    private void runOnUIThread(Runnable r) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            r.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r);
        }
    }

    private boolean postOnMainThreadAndLock(final Runnable runnable, final CountDownLatch latch) {
        return this.mainHandler.post(new Runnable() { // from class: com.ss.bytertc.engine.mediaio.TextureEglRenderer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TextureEglRenderer.lambda$postOnMainThreadAndLock$2(runnable, latch);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$postOnMainThreadAndLock$2(Runnable runnable, CountDownLatch countDownLatch) {
        runnable.run();
        try {
            if (countDownLatch.getCount() != 0) {
                countDownLatch.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
