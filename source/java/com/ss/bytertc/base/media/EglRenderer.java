package com.ss.bytertc.base.media;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.GlClearWorkaround;
import com.bytedance.realx.video.GlTextureFrameBuffer;
import com.bytedance.realx.video.GlUtil;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class EglRenderer implements VideoSink {
    private static final long LOG_INTERVAL_SEC = 4;
    private static final String TAG = "EglRenderer";
    private static GlClearWorkaround.WORKAROUND_STATUS enableGLWorkaround = GlClearWorkaround.WORKAROUND_STATUS.kStatusUnknown;
    protected static int mDestroyTimeoutMs = -1;
    private RendererCommon.GlDrawer drawer;
    private EglBase eglBase;
    private int framesDropped;
    private int framesReceived;
    private int framesRendered;
    private float layoutAspectRatio;
    private long minRenderPeriodNs;
    private boolean mirrorHorizontally;
    private boolean mirrorVertically;
    protected final String name;
    private long nextFrameTimeNs;
    private VideoFrame pendingFrame;
    private long renderSwapBufferTimeNs;
    private Handler renderThreadHandler;
    private long renderTimeNs;
    private long statisticsStartTimeNs;
    private boolean usePresentationTimeStamp;
    private final GlClearWorkaround glClearWorkaround = new GlClearWorkaround();
    private final Object handlerLock = new Object();
    private final ArrayList<FrameListenerAndParams> frameListeners = new ArrayList<>();
    private final ArrayList<FirstVideoFrameRenderListener> firstVideoFrameListeners = new ArrayList<>();
    private final Object fpsReductionLock = new Object();
    private final VideoFrameDrawer frameDrawer = new VideoFrameDrawer();
    private final Matrix drawMatrix = new Matrix();
    private final Object frameLock = new Object();
    private final Object firstRenderLock = new Object();
    private final Object layoutLock = new Object();
    private final Object statisticsLock = new Object();
    private final GlTextureFrameBuffer bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
    private volatile RendererCommon.ScalingType renderModel = RendererCommon.ScalingType.SCALE_ASPECT_FILL;
    private final Runnable logStatisticsRunnable = new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer.1
        @Override // java.lang.Runnable
        public void run() {
            EglRenderer.this.logStatistics();
            synchronized (EglRenderer.this.handlerLock) {
                if (EglRenderer.this.renderThreadHandler != null) {
                    EglRenderer.this.renderThreadHandler.removeCallbacks(EglRenderer.this.logStatisticsRunnable);
                    EglRenderer.this.renderThreadHandler.postDelayed(EglRenderer.this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
                }
            }
        }
    };
    private final EglSurfaceCreation eglSurfaceCreationRunnable = new EglSurfaceCreation();
    private boolean haveRenderFirstVideoFrame = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface FirstVideoFrameRenderListener {
        void onFirstVideoFrameRender();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface FrameListener {
        void onFrame(Bitmap frame);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class FrameListenerAndParams {
        public final boolean applyFpsReduction;
        public final RendererCommon.GlDrawer drawer;
        public final FrameListener listener;
        public final float scale;

        public FrameListenerAndParams(FrameListener listener, float scale, RendererCommon.GlDrawer drawer, boolean applyFpsReduction) {
            this.listener = listener;
            this.scale = scale;
            this.drawer = drawer;
            this.applyFpsReduction = applyFpsReduction;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class EglSurfaceCreation implements Runnable {
        private Object surface;

        private EglSurfaceCreation() {
        }

        public synchronized void setSurface(Object surface) {
            this.surface = surface;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            if (this.surface != null && EglRenderer.this.eglBase != null && !EglRenderer.this.eglBase.hasSurface()) {
                Object obj = this.surface;
                if (obj instanceof Surface) {
                    EglRenderer.this.eglBase.createSurface((Surface) this.surface);
                } else if (obj instanceof SurfaceTexture) {
                    EglRenderer.this.eglBase.createSurface((SurfaceTexture) this.surface);
                } else {
                    throw new IllegalStateException("Invalid surface: " + this.surface);
                }
                EglRenderer.this.eglBase.makeCurrent();
                GLES20.glPixelStorei(3317, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class HandlerWithExceptionCallback extends Handler {
        private final Runnable exceptionCallback;

        public HandlerWithExceptionCallback(Looper looper, Runnable exceptionCallback) {
            super(looper);
            this.exceptionCallback = exceptionCallback;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message msg) {
            try {
                super.dispatchMessage(msg);
            } catch (Exception e) {
                RXLogging.e(EglRenderer.TAG, "Exception on EglRenderer thread", e);
                this.exceptionCallback.run();
                throw e;
            }
        }
    }

    public EglRenderer(String name) {
        this.name = name;
    }

    public void init(final EglBase.Context sharedContext, final int[] configAttributes, RendererCommon.GlDrawer drawer, boolean usePresentationTimeStamp) {
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler != null) {
                throw new IllegalStateException(this.name + "Already initialized");
            }
            logD("Initializing EglRenderer");
            this.drawer = drawer;
            this.usePresentationTimeStamp = usePresentationTimeStamp;
            HandlerThread handlerThread = new HandlerThread(this.name + TAG);
            handlerThread.start();
            HandlerWithExceptionCallback handlerWithExceptionCallback = new HandlerWithExceptionCallback(handlerThread.getLooper(), new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (EglRenderer.this.handlerLock) {
                        EglRenderer.this.renderThreadHandler = null;
                    }
                }
            });
            this.renderThreadHandler = handlerWithExceptionCallback;
            ThreadUtils.invokeAtFrontUninterruptibly(handlerWithExceptionCallback, new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.this.m4155lambda$init$0$comssbytertcbasemediaEglRenderer(sharedContext, configAttributes);
                }
            });
            this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
            resetStatistics(System.nanoTime());
            this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$0$com-ss-bytertc-base-media-EglRenderer, reason: not valid java name */
    public /* synthetic */ void m4155lambda$init$0$comssbytertcbasemediaEglRenderer(EglBase.Context context, int[] iArr) {
        if (context == null) {
            logD("EglBase10.create context");
            this.eglBase = EglBase.createEgl10(iArr);
        } else {
            logD("EglBase.create shared context");
            this.eglBase = EglBase.create(context, iArr);
        }
        this.glClearWorkaround.init();
    }

    public void init(final EglBase.Context sharedContext, final int[] configAttributes, RendererCommon.GlDrawer drawer) {
        init(sharedContext, configAttributes, drawer, false);
    }

    public void createEglSurface(Surface surface) {
        createEglSurfaceInternal(surface);
    }

    public void createEglSurface(SurfaceTexture surfaceTexture) {
        createEglSurfaceInternal(surfaceTexture);
    }

    private void createEglSurfaceInternal(Object surface) {
        this.eglSurfaceCreationRunnable.setSurface(surface);
        postToRenderThread(this.eglSurfaceCreationRunnable);
    }

    public void release() {
        logD("Releasing.");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                logD("Already released");
                return;
            }
            handler.removeCallbacks(this.logStatisticsRunnable);
            this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.this.m4156lambda$release$1$comssbytertcbasemediaEglRenderer(countDownLatch);
                }
            });
            final Looper looper = this.renderThreadHandler.getLooper();
            this.renderThreadHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.this.m4157lambda$release$2$comssbytertcbasemediaEglRenderer(looper);
                }
            });
            this.renderThreadHandler = null;
            int i = mDestroyTimeoutMs;
            if (i <= 0) {
                ThreadUtils.awaitUninterruptibly(countDownLatch);
            } else {
                ThreadUtils.awaitUninterruptibly(countDownLatch, i);
            }
            synchronized (this.frameLock) {
                VideoFrame videoFrame = this.pendingFrame;
                if (videoFrame != null) {
                    videoFrame.release();
                    this.pendingFrame = null;
                }
            }
            logD("Releasing done.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$1$com-ss-bytertc-base-media-EglRenderer, reason: not valid java name */
    public /* synthetic */ void m4156lambda$release$1$comssbytertcbasemediaEglRenderer(CountDownLatch countDownLatch) {
        this.glClearWorkaround.release();
        GLES20.glUseProgram(0);
        RendererCommon.GlDrawer glDrawer = this.drawer;
        if (glDrawer != null) {
            glDrawer.release();
            this.drawer = null;
        }
        this.frameDrawer.release();
        this.bitmapTextureFramebuffer.release();
        if (this.eglBase != null) {
            logD("eglBase detach and release.");
            this.eglBase.detachCurrent();
            this.eglBase.release();
            this.eglBase = null;
        }
        this.frameListeners.clear();
        synchronized (this.firstRenderLock) {
            this.firstVideoFrameListeners.clear();
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$2$com-ss-bytertc-base-media-EglRenderer, reason: not valid java name */
    public /* synthetic */ void m4157lambda$release$2$comssbytertcbasemediaEglRenderer(Looper looper) {
        logD("Quitting render thread.");
        looper.quit();
    }

    private void resetStatistics(long currentTimeNs) {
        synchronized (this.statisticsLock) {
            this.statisticsStartTimeNs = currentTimeNs;
            this.framesReceived = 0;
            this.framesDropped = 0;
            this.framesRendered = 0;
            this.renderTimeNs = 0L;
            this.renderSwapBufferTimeNs = 0L;
        }
    }

    public void printStackTrace() {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            Thread thread = handler == null ? null : handler.getLooper().getThread();
            if (thread != null) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace.length > 0) {
                    logW("EglRenderer stack trace:");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        logW(stackTraceElement.toString());
                    }
                }
            }
        }
    }

    public void setMirror(final boolean mirror) {
        logD("setMirrorHorizontally: " + mirror);
        synchronized (this.layoutLock) {
            this.mirrorHorizontally = mirror;
        }
    }

    public void setMirrorVertically(final boolean mirrorVertically) {
        logD("setMirrorVertically: " + mirrorVertically);
        synchronized (this.layoutLock) {
            this.mirrorVertically = mirrorVertically;
        }
    }

    public void setLayoutAspectRatio(float layoutAspectRatio) {
        logD("setLayoutAspectRatio: " + layoutAspectRatio);
        synchronized (this.layoutLock) {
            this.layoutAspectRatio = layoutAspectRatio;
        }
    }

    public void setFpsReduction(float fps) {
        logD("setFpsReduction: " + fps);
        synchronized (this.fpsReductionLock) {
            long j = this.minRenderPeriodNs;
            if (fps <= 0.0f) {
                this.minRenderPeriodNs = Long.MAX_VALUE;
            } else {
                this.minRenderPeriodNs = ((float) TimeUnit.SECONDS.toNanos(1L)) / fps;
            }
            if (this.minRenderPeriodNs != j) {
                this.nextFrameTimeNs = System.nanoTime();
            }
        }
    }

    public void disableFpsReduction() {
        setFpsReduction(Float.POSITIVE_INFINITY);
    }

    public void pauseVideo() {
        setFpsReduction(0.0f);
    }

    public void addFrameListener(final FrameListener listener, final float scale) {
        addFrameListener(listener, scale, null, false);
    }

    public void addFrameListener(final FrameListener listener, final float scale, final RendererCommon.GlDrawer drawerParam) {
        addFrameListener(listener, scale, drawerParam, false);
    }

    public void addFrameListener(final FrameListener listener, final float scale, final RendererCommon.GlDrawer drawerParam, final boolean applyFpsReduction) {
        postToRenderThread(new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                EglRenderer.this.m4153lambda$addFrameListener$3$comssbytertcbasemediaEglRenderer(drawerParam, listener, scale, applyFpsReduction);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$addFrameListener$3$com-ss-bytertc-base-media-EglRenderer, reason: not valid java name */
    public /* synthetic */ void m4153lambda$addFrameListener$3$comssbytertcbasemediaEglRenderer(RendererCommon.GlDrawer glDrawer, FrameListener frameListener, float f, boolean z) {
        if (glDrawer == null) {
            glDrawer = this.drawer;
        }
        this.frameListeners.add(new FrameListenerAndParams(frameListener, f, glDrawer, z));
    }

    public void addFristFrameListener(FirstVideoFrameRenderListener listener) {
        synchronized (this.firstRenderLock) {
            this.firstVideoFrameListeners.add(listener);
        }
    }

    public void removeFrameListener(final FrameListener listener) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                return;
            }
            if (Thread.currentThread() == this.renderThreadHandler.getLooper().getThread()) {
                throw new RuntimeException("removeFrameListener must not be called on the render thread.");
            }
            postToRenderThread(new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.this.m178xc225efc9(countDownLatch, listener);
                }
            });
            ThreadUtils.awaitUninterruptibly(countDownLatch);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$removeFrameListener$4$com-ss-bytertc-base-media-EglRenderer */
    public /* synthetic */ void m178xc225efc9(CountDownLatch countDownLatch, FrameListener frameListener) {
        countDownLatch.countDown();
        Iterator<FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            if (it.next().listener == frameListener) {
                it.remove();
            }
        }
    }

    @Override // com.ss.bytertc.base.media.VideoSink
    public void onFrame(VideoFrame frame) {
        boolean z;
        synchronized (this.statisticsLock) {
            this.framesReceived++;
        }
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                logD("Dropping frame - Not initialized or already released.");
                return;
            }
            synchronized (this.frameLock) {
                VideoFrame videoFrame = this.pendingFrame;
                z = videoFrame != null;
                if (z) {
                    videoFrame.release();
                }
                this.pendingFrame = frame;
                frame.retain();
                this.renderThreadHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        EglRenderer.this.renderFrameOnRenderThread();
                    }
                });
            }
            if (z) {
                synchronized (this.statisticsLock) {
                    this.framesDropped++;
                }
            }
        }
    }

    public void releaseEglSurface(final Runnable completionCallback) {
        this.eglSurfaceCreationRunnable.setSurface(null);
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                handler.removeCallbacks(this.eglSurfaceCreationRunnable);
                this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        EglRenderer.this.m4158lambda$releaseEglSurface$5$comssbytertcbasemediaEglRenderer(completionCallback);
                    }
                });
            } else {
                completionCallback.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$releaseEglSurface$5$com-ss-bytertc-base-media-EglRenderer, reason: not valid java name */
    public /* synthetic */ void m4158lambda$releaseEglSurface$5$comssbytertcbasemediaEglRenderer(Runnable runnable) {
        EglBase eglBase = this.eglBase;
        if (eglBase != null) {
            eglBase.detachCurrent();
            this.eglBase.releaseSurface();
        }
        runnable.run();
    }

    private void postToRenderThread(Runnable runnable) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearSurfaceOnRenderThread, reason: merged with bridge method [inline-methods] */
    public void m4154lambda$clearImage$6$comssbytertcbasemediaEglRenderer(float r, float g, float b, float a) {
        EglBase eglBase = this.eglBase;
        if (eglBase == null || !eglBase.hasSurface()) {
            return;
        }
        logD("clearSurface");
        glClear(this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight(), 16384, r, g, b, a);
        this.eglBase.swapBuffers();
    }

    public void clearImage() {
        clearImage(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void clearImage(final float r, final float g, final float b, final float a) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                return;
            }
            handler.postAtFrontOfQueue(new Runnable() { // from class: com.ss.bytertc.base.media.EglRenderer$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.this.m4154lambda$clearImage$6$comssbytertcbasemediaEglRenderer(r, g, b, a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void renderFrameOnRenderThread() {
        boolean z;
        float f;
        int i;
        int surfaceWidth;
        int i2;
        int i3;
        float f2;
        float f3;
        boolean z2;
        boolean z3;
        synchronized (this.frameLock) {
            VideoFrame videoFrame = this.pendingFrame;
            if (videoFrame == null) {
                return;
            }
            this.pendingFrame = null;
            EglBase eglBase = this.eglBase;
            if (eglBase == null || !eglBase.hasSurface()) {
                logD("Dropping frame - No surface");
                videoFrame.release();
                return;
            }
            synchronized (this.fpsReductionLock) {
                long j = this.minRenderPeriodNs;
                if (j != Long.MAX_VALUE) {
                    if (j > 0) {
                        long nanoTime = System.nanoTime();
                        long j2 = this.nextFrameTimeNs;
                        if (nanoTime < j2) {
                            logD("Skipping frame rendering - fps reduction is active.");
                        } else {
                            long j3 = j2 + this.minRenderPeriodNs;
                            this.nextFrameTimeNs = j3;
                            this.nextFrameTimeNs = Math.max(j3, nanoTime);
                        }
                    }
                    z = true;
                }
                z = false;
            }
            long nanoTime2 = System.nanoTime();
            if (videoFrame.getRotatedHeight() <= 0) {
                return;
            }
            float rotatedWidth = videoFrame.getRotatedWidth() / videoFrame.getRotatedHeight();
            synchronized (this.layoutLock) {
                f = this.layoutAspectRatio;
                if (f == 0.0f) {
                    f = rotatedWidth;
                }
            }
            int surfaceWidth2 = this.eglBase.surfaceWidth();
            int surfaceHeight = this.eglBase.surfaceHeight();
            int i4 = C08163.$SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType[this.renderModel.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (rotatedWidth > f) {
                        f3 = f / rotatedWidth;
                        i = surfaceWidth2;
                        i2 = surfaceHeight;
                        surfaceWidth = 0;
                        i3 = 0;
                        f2 = 1.0f;
                    } else {
                        f2 = rotatedWidth / f;
                        i = surfaceWidth2;
                        i2 = surfaceHeight;
                        surfaceWidth = 0;
                        i3 = 0;
                        f3 = 1.0f;
                    }
                    this.drawMatrix.reset();
                    this.drawMatrix.preTranslate(0.5f, 0.5f);
                    this.drawMatrix.preScale(!this.mirrorHorizontally ? -1.0f : 1.0f, this.mirrorVertically ? -1.0f : 1.0f);
                    this.drawMatrix.preScale(f3, f2);
                    this.drawMatrix.preTranslate(-0.5f, -0.5f);
                    if (z) {
                        z2 = z;
                        z3 = true;
                    } else {
                        glClear(this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight(), 16384, 0.0f, 0.0f, 0.0f, 0.0f);
                        z2 = z;
                        z3 = true;
                        this.frameDrawer.drawFrame(videoFrame, this.drawer, this.drawMatrix, surfaceWidth, i3, i, i2);
                        long nanoTime3 = System.nanoTime();
                        if (this.usePresentationTimeStamp) {
                            this.eglBase.swapBuffers(videoFrame.getTimestampNs());
                        } else {
                            this.eglBase.swapBuffers();
                        }
                        long nanoTime4 = System.nanoTime();
                        synchronized (this.statisticsLock) {
                            this.framesRendered++;
                            this.renderTimeNs += nanoTime4 - nanoTime2;
                            this.renderSwapBufferTimeNs += nanoTime4 - nanoTime3;
                        }
                    }
                    notifyCallbacks(videoFrame, z2);
                    if (!this.haveRenderFirstVideoFrame) {
                        notifyFristRenderCallback();
                        this.haveRenderFirstVideoFrame = z3;
                    }
                    videoFrame.release();
                }
                i = surfaceWidth2;
                i2 = surfaceHeight;
                surfaceWidth = 0;
                i3 = 0;
            } else if (rotatedWidth > f) {
                int surfaceWidth3 = (int) (this.eglBase.surfaceWidth() / rotatedWidth);
                i2 = surfaceWidth3;
                i = surfaceWidth2;
                i3 = (this.eglBase.surfaceHeight() - surfaceWidth3) / 2;
                surfaceWidth = 0;
            } else {
                int surfaceHeight2 = (int) (this.eglBase.surfaceHeight() * rotatedWidth);
                i = surfaceHeight2;
                surfaceWidth = (this.eglBase.surfaceWidth() - surfaceHeight2) / 2;
                i2 = surfaceHeight;
                i3 = 0;
            }
            f2 = 1.0f;
            f3 = 1.0f;
            this.drawMatrix.reset();
            this.drawMatrix.preTranslate(0.5f, 0.5f);
            this.drawMatrix.preScale(!this.mirrorHorizontally ? -1.0f : 1.0f, this.mirrorVertically ? -1.0f : 1.0f);
            this.drawMatrix.preScale(f3, f2);
            this.drawMatrix.preTranslate(-0.5f, -0.5f);
            if (z) {
            }
            notifyCallbacks(videoFrame, z2);
            if (!this.haveRenderFirstVideoFrame) {
            }
            videoFrame.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.bytertc.base.media.EglRenderer$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C08163 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType;

        static {
            int[] iArr = new int[RendererCommon.ScalingType.values().length];
            $SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType = iArr;
            try {
                iArr[RendererCommon.ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType[RendererCommon.ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType[RendererCommon.ScalingType.SCALE_ASPECT_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void notifyCallbacks(VideoFrame frame, boolean wasRendered) {
        if (this.frameListeners.isEmpty()) {
            return;
        }
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        this.drawMatrix.preScale(this.mirrorHorizontally ? -1.0f : 1.0f, this.mirrorVertically ? -1.0f : 1.0f);
        this.drawMatrix.preScale(1.0f, -1.0f);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        Iterator<FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            FrameListenerAndParams next = it.next();
            if (wasRendered || !next.applyFpsReduction) {
                it.remove();
                int rotatedWidth = (int) (next.scale * frame.getRotatedWidth());
                int rotatedHeight = (int) (next.scale * frame.getRotatedHeight());
                if (rotatedWidth == 0 || rotatedHeight == 0) {
                    next.listener.onFrame(null);
                } else {
                    this.bitmapTextureFramebuffer.setSize(rotatedWidth, rotatedHeight);
                    GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
                    glClear(rotatedWidth, rotatedHeight, 16384, 0.0f, 0.0f, 0.0f, 0.0f);
                    this.frameDrawer.drawFrame(frame, next.drawer, this.drawMatrix, 0, 0, rotatedWidth, rotatedHeight);
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rotatedWidth * rotatedHeight * 4);
                    GLES20.glViewport(0, 0, rotatedWidth, rotatedHeight);
                    GLES20.glReadPixels(0, 0, rotatedWidth, rotatedHeight, 6408, 5121, allocateDirect);
                    GLES20.glBindFramebuffer(36160, 0);
                    GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
                    Bitmap createBitmap = Bitmap.createBitmap(rotatedWidth, rotatedHeight, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(allocateDirect);
                    next.listener.onFrame(createBitmap);
                }
            }
        }
    }

    private void notifyFristRenderCallback() {
        synchronized (this.firstRenderLock) {
            Iterator<FirstVideoFrameRenderListener> it = this.firstVideoFrameListeners.iterator();
            while (it.hasNext()) {
                it.next().onFirstVideoFrameRender();
            }
        }
    }

    private String averageTimeAsString(long sumTimeNs, int count) {
        return count <= 0 ? "NA" : TimeUnit.NANOSECONDS.toMicros(sumTimeNs / count) + " us";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logStatistics() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        long nanoTime = System.nanoTime();
        synchronized (this.statisticsLock) {
            long j = nanoTime - this.statisticsStartTimeNs;
            if (j <= 0) {
                return;
            }
            logD("Duration: " + TimeUnit.NANOSECONDS.toMillis(j) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". Render fps: " + decimalFormat.format(((float) (this.framesRendered * TimeUnit.SECONDS.toNanos(1L))) / ((float) j)) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");
            resetStatistics(nanoTime);
        }
    }

    private void logD(String string) {
        RXLogging.i(TAG, this.name + string);
    }

    private void logW(String string) {
        RXLogging.w(TAG, this.name + string);
    }

    public void setRenderModel(RendererCommon.ScalingType renderModel) {
        this.renderModel = renderModel;
    }

    private void glClear(int width, int height, int mask, float r, float g, float b, float a) {
        if (enableGLWorkaround == GlClearWorkaround.WORKAROUND_STATUS.kStatusUnknown) {
            enableGLWorkaround = GlClearWorkaround.isNeedWorkaround();
        }
        if (enableGLWorkaround == GlClearWorkaround.WORKAROUND_STATUS.kStatusEnable) {
            this.glClearWorkaround.clear(width, height, mask, r, g, b, a, 1.0f, 8);
        } else {
            GLES20.glClearColor(r, g, b, a);
            GLES20.glClear(16384);
        }
    }
}
