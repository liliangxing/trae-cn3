package com.ss.bytertc.engine.mediaio;

import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.SurfaceEglRenderer;
import com.ss.bytertc.engine.p006ui.VideoFrameRender;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.SoftReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SurfaceEglRender extends SurfaceEglRenderer {
    private static final String TAG = "SurfaceEglRender";
    private SurfaceHolder.Callback mCallback;
    private final AtomicBoolean mHasBindAtomic;
    private final AtomicBoolean mHasInitAtomic;
    private final Object mSurfaceCallbackLock;
    private VideoFrameRender.SurfaceLifecycleCallback mSurfaceLifecycleCallback;
    private final Object mSurfaceLifecycleCallbackLock;
    private SoftReference<SurfaceView> surfaceViewSoftReference;

    public SurfaceEglRender(final String name) {
        super(name);
        this.mHasInitAtomic = new AtomicBoolean(false);
        this.mHasBindAtomic = new AtomicBoolean(false);
        this.mSurfaceLifecycleCallbackLock = new Object();
        this.mSurfaceCallbackLock = new Object();
        this.surfaceViewSoftReference = new SoftReference<>(null);
    }

    public void setSurfaceHolderCallback(SurfaceHolder.Callback callback) {
        synchronized (this.mSurfaceCallbackLock) {
            this.mCallback = callback;
        }
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, com.ss.bytertc.base.media.EglRenderer
    public void init(EglBase.Context sharedContext, int[] configAttributes, RendererCommon.GlDrawer drawer) {
        ThreadUtils.checkIsOnMainThread();
        if (this.mHasInitAtomic.compareAndSet(false, true)) {
            LogUtil.m215d(TAG, "init");
            super.init(sharedContext, configAttributes, drawer);
            return;
        }
        throw new IllegalStateException("SurfaceEglRender has already init!!!!!!");
    }

    public void setSurfaceLifecycleLisenter(final VideoFrameRender.SurfaceLifecycleCallback surfaceLifecycleCallback) {
        synchronized (this.mSurfaceLifecycleCallbackLock) {
            this.mSurfaceLifecycleCallback = surfaceLifecycleCallback;
        }
    }

    public void bind(final SurfaceView surfaceView) {
        if (!this.mHasInitAtomic.get()) {
            throw new IllegalStateException("TextureEglRenderer has not init!!!!!!");
        }
        if (!this.mHasBindAtomic.compareAndSet(false, true)) {
            throw new IllegalStateException("Called bind functions multiple times!!!!!!");
        }
        LogUtil.m215d(TAG, "bind");
        runOnUIThread(new Runnable() { // from class: com.ss.bytertc.engine.mediaio.SurfaceEglRender$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceEglRender.this.m4168lambda$bind$0$comssbytertcenginemediaioSurfaceEglRender(surfaceView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$bind$0$com-ss-bytertc-engine-mediaio-SurfaceEglRender, reason: not valid java name */
    public /* synthetic */ void m4168lambda$bind$0$comssbytertcenginemediaioSurfaceEglRender(SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView.getHolder();
        synchronized (this.mSurfaceCallbackLock) {
            SurfaceHolder.Callback callback = this.mCallback;
            if (callback != null) {
                holder.addCallback(callback);
            }
        }
        this.surfaceViewSoftReference = new SoftReference<>(surfaceView);
        if (holder.getSurface() != null && holder.getSurface().isValid()) {
            setLayoutAspectRatio(surfaceView.getMeasuredWidth() / surfaceView.getMeasuredHeight());
            surfaceCreated(holder);
        }
        holder.addCallback(this);
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, com.ss.bytertc.base.media.EglRenderer, com.ss.bytertc.base.media.VideoSink
    public void onFrame(VideoFrame frame) {
        if (this.mHasInitAtomic.get() && this.mHasBindAtomic.get()) {
            super.onFrame(frame);
        }
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, com.ss.bytertc.base.media.EglRenderer
    public void release() {
        SurfaceView surfaceView;
        if (!this.mHasInitAtomic.compareAndSet(true, false)) {
            throw new IllegalStateException("TextureEglRenderer has not init or already released!!!!!");
        }
        LogUtil.m215d(TAG, "release");
        super.release();
        this.mHasBindAtomic.compareAndSet(true, false);
        SoftReference<SurfaceView> softReference = this.surfaceViewSoftReference;
        if (softReference == null || (surfaceView = softReference.get()) == null) {
            return;
        }
        surfaceView.getHolder().removeCallback(this);
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, android.view.SurfaceHolder.Callback
    public void surfaceCreated(final SurfaceHolder holder) {
        super.surfaceCreated(holder);
        LogUtil.m215d(TAG, "surfaceCreated");
        synchronized (this.mSurfaceLifecycleCallbackLock) {
            VideoFrameRender.SurfaceLifecycleCallback surfaceLifecycleCallback = this.mSurfaceLifecycleCallback;
            if (surfaceLifecycleCallback != null) {
                surfaceLifecycleCallback.onCreated();
            }
        }
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(final SurfaceHolder holder) {
        super.surfaceDestroyed(holder);
        LogUtil.m215d(TAG, "surfaceDestroyed");
        synchronized (this.mSurfaceLifecycleCallbackLock) {
            VideoFrameRender.SurfaceLifecycleCallback surfaceLifecycleCallback = this.mSurfaceLifecycleCallback;
            if (surfaceLifecycleCallback != null) {
                surfaceLifecycleCallback.onDestroy();
            }
        }
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, android.view.SurfaceHolder.Callback
    public void surfaceChanged(final SurfaceHolder holder, final int format, final int width, final int height) {
        super.surfaceChanged(holder, format, width, height);
        LogUtil.m215d(TAG, "surfaceChanged");
    }

    private void runOnUIThread(Runnable r) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            r.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r);
        }
    }
}
