package com.bytedance.realx.video;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.agfx.RXGPUCacheCtrl;
import com.bytedance.realx.video.memory.NativeRXOpenGLMemory;
import com.bytedance.realx.video.memory.NativeRXVideoFrame;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SurfaceTextureHelper {
    private static final String TAG = "SurfaceTextureHelper";
    private static float[] TEX_MATRIX = new float[16];
    private boolean capture2DTexture;
    private final EglBase eglBase;
    private boolean enableOutsideControlTextureMemory;
    private boolean enableTextureMemoryReuse;
    private final int frameBufferId;
    private int frameRotation;
    private Object frameSyncObject;
    private final GlRectDrawer glRectDrawer;
    private final Handler handler;
    private boolean hasPendingTexture;
    private boolean isAvaliable;
    private boolean isQuitting;
    private volatile boolean isTextureInUse;
    private long lastBindTimestamp;
    private long lastDeliverTime;
    private VideoSink listener;
    private int maxDeliverTimerInternal;
    private NativeRXOpenGLMemory memory;
    private int oesTextureId;
    private VideoSink pendingListener;
    private int prevOesTextureId;
    private int prevTextureHeight;
    private int prevTextureWidth;
    final Runnable setListenerRunnable;
    private final SurfaceTexture surfaceTexture;
    private int textureHeight;
    private int textureWidth;
    final Runnable timedDeliverRunnable;
    private final TimestampAligner timestampAligner;
    private final int twoDTextureId;
    private boolean useAgfx;
    private RXVideoFrameHelperInterface videoFrameHelperOpenGL;

    public static SurfaceTextureHelper createWithAGFX(final String threadName, boolean alignTimestamps) {
        return null;
    }

    /* synthetic */ SurfaceTextureHelper(EglBase.Context context, Handler handler, boolean z, boolean z2, boolean z3, CallableC07081 callableC07081) {
        this(context, handler, z, z2, z3);
    }

    public static SurfaceTextureHelper create(final String threadName, final EglBase.Context sharedContext, boolean alignTimestamps) {
        return create(threadName, sharedContext, alignTimestamps, false, false);
    }

    public static SurfaceTextureHelper create(final String threadName, final EglBase.Context sharedContext) {
        return create(threadName, sharedContext, false, false, false);
    }

    public static SurfaceTextureHelper createWithAGFX(final String threadName) {
        return createWithAGFX(threadName, false);
    }

    public static SurfaceTextureHelper create(final String threadName, final EglBase.Context sharedContext, boolean alignTimestamps, boolean capture2DTexture, boolean useAgfx) {
        HandlerThread handlerThread = new HandlerThread(threadName);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<SurfaceTextureHelper>() { // from class: com.bytedance.realx.video.SurfaceTextureHelper.1
            final /* synthetic */ boolean val$alignTimestamps;
            final /* synthetic */ boolean val$capture2DTexture;
            final /* synthetic */ Handler val$handler;
            final /* synthetic */ String val$threadName;
            final /* synthetic */ boolean val$useAgfx;

            CallableC07081(Handler handler2, boolean alignTimestamps2, boolean capture2DTexture2, boolean useAgfx2, final String threadName2) {
                val$handler = handler2;
                val$alignTimestamps = alignTimestamps2;
                val$capture2DTexture = capture2DTexture2;
                val$useAgfx = useAgfx2;
                val$threadName = threadName2;
            }

            @Override // java.util.concurrent.Callable
            public SurfaceTextureHelper call() {
                try {
                    return new SurfaceTextureHelper(EglBase.Context.this, val$handler, val$alignTimestamps, val$capture2DTexture, val$useAgfx);
                } catch (RuntimeException e) {
                    RXLogging.m284e(SurfaceTextureHelper.TAG, val$threadName + " create failure", e);
                    return null;
                }
            }
        });
    }

    /* renamed from: com.bytedance.realx.video.SurfaceTextureHelper$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class CallableC07081 implements Callable<SurfaceTextureHelper> {
        final /* synthetic */ boolean val$alignTimestamps;
        final /* synthetic */ boolean val$capture2DTexture;
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ String val$threadName;
        final /* synthetic */ boolean val$useAgfx;

        CallableC07081(Handler handler2, boolean alignTimestamps2, boolean capture2DTexture2, boolean useAgfx2, final String threadName2) {
            val$handler = handler2;
            val$alignTimestamps = alignTimestamps2;
            val$capture2DTexture = capture2DTexture2;
            val$useAgfx = useAgfx2;
            val$threadName = threadName2;
        }

        @Override // java.util.concurrent.Callable
        public SurfaceTextureHelper call() {
            try {
                return new SurfaceTextureHelper(EglBase.Context.this, val$handler, val$alignTimestamps, val$capture2DTexture, val$useAgfx);
            } catch (RuntimeException e) {
                RXLogging.m284e(SurfaceTextureHelper.TAG, val$threadName + " create failure", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.video.SurfaceTextureHelper$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class RunnableC07092 implements Runnable {
        RunnableC07092() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RXLogging.m285i(SurfaceTextureHelper.TAG, "Setting listener to " + SurfaceTextureHelper.this.pendingListener);
            SurfaceTextureHelper surfaceTextureHelper = SurfaceTextureHelper.this;
            surfaceTextureHelper.listener = surfaceTextureHelper.pendingListener;
            SurfaceTextureHelper.this.pendingListener = null;
            if (SurfaceTextureHelper.this.hasPendingTexture) {
                SurfaceTextureHelper.this.updateTexImage();
                SurfaceTextureHelper.this.hasPendingTexture = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.video.SurfaceTextureHelper$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class RunnableC07103 implements Runnable {
        RunnableC07103() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SurfaceTextureHelper.this.maxDeliverTimerInternal <= 0 || SurfaceTextureHelper.this.handler == null || SurfaceTextureHelper.this.listener == null) {
                return;
            }
            if (!SurfaceTextureHelper.this.hasPendingTexture && System.currentTimeMillis() - SurfaceTextureHelper.this.lastDeliverTime >= SurfaceTextureHelper.this.maxDeliverTimerInternal) {
                SurfaceTextureHelper.this.hasPendingTexture = true;
                if (!SurfaceTextureHelper.this.enableOutsideControlTextureMemory) {
                    SurfaceTextureHelper.this.tryDeliverTextureFrame();
                }
            }
            long currentTimeMillis = SurfaceTextureHelper.this.maxDeliverTimerInternal - (System.currentTimeMillis() - SurfaceTextureHelper.this.lastDeliverTime);
            Handler handler = SurfaceTextureHelper.this.handler;
            if (currentTimeMillis < 0) {
                currentTimeMillis = SurfaceTextureHelper.this.maxDeliverTimerInternal;
            }
            handler.postDelayed(this, currentTimeMillis);
        }
    }

    public boolean isAvaliable() {
        boolean z;
        synchronized (this.frameSyncObject) {
            z = this.isAvaliable;
        }
        return z;
    }

    public void setEnableOutsideControlTextureMemory(boolean value) {
        this.enableOutsideControlTextureMemory = value;
    }

    private SurfaceTextureHelper(EglBase.Context sharedContext, Handler handler, boolean alignTimestamps, boolean capture2DTexture, boolean useAgfx) {
        this.oesTextureId = 0;
        this.prevOesTextureId = 0;
        this.textureWidth = 0;
        this.textureHeight = 0;
        this.prevTextureWidth = 0;
        this.prevTextureHeight = 0;
        this.capture2DTexture = false;
        this.useAgfx = false;
        this.lastBindTimestamp = 0L;
        this.memory = null;
        this.enableTextureMemoryReuse = false;
        this.enableOutsideControlTextureMemory = false;
        this.frameSyncObject = new Object();
        this.isAvaliable = false;
        this.setListenerRunnable = new Runnable() { // from class: com.bytedance.realx.video.SurfaceTextureHelper.2
            RunnableC07092() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RXLogging.m285i(SurfaceTextureHelper.TAG, "Setting listener to " + SurfaceTextureHelper.this.pendingListener);
                SurfaceTextureHelper surfaceTextureHelper = SurfaceTextureHelper.this;
                surfaceTextureHelper.listener = surfaceTextureHelper.pendingListener;
                SurfaceTextureHelper.this.pendingListener = null;
                if (SurfaceTextureHelper.this.hasPendingTexture) {
                    SurfaceTextureHelper.this.updateTexImage();
                    SurfaceTextureHelper.this.hasPendingTexture = false;
                }
            }
        };
        this.lastDeliverTime = 0L;
        this.maxDeliverTimerInternal = -1;
        this.timedDeliverRunnable = new Runnable() { // from class: com.bytedance.realx.video.SurfaceTextureHelper.3
            RunnableC07103() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SurfaceTextureHelper.this.maxDeliverTimerInternal <= 0 || SurfaceTextureHelper.this.handler == null || SurfaceTextureHelper.this.listener == null) {
                    return;
                }
                if (!SurfaceTextureHelper.this.hasPendingTexture && System.currentTimeMillis() - SurfaceTextureHelper.this.lastDeliverTime >= SurfaceTextureHelper.this.maxDeliverTimerInternal) {
                    SurfaceTextureHelper.this.hasPendingTexture = true;
                    if (!SurfaceTextureHelper.this.enableOutsideControlTextureMemory) {
                        SurfaceTextureHelper.this.tryDeliverTextureFrame();
                    }
                }
                long currentTimeMillis = SurfaceTextureHelper.this.maxDeliverTimerInternal - (System.currentTimeMillis() - SurfaceTextureHelper.this.lastDeliverTime);
                Handler handler2 = SurfaceTextureHelper.this.handler;
                if (currentTimeMillis < 0) {
                    currentTimeMillis = SurfaceTextureHelper.this.maxDeliverTimerInternal;
                }
                handler2.postDelayed(this, currentTimeMillis);
            }
        };
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
        if (useAgfx) {
            throw new IllegalStateException("non agfx package not support SurfaceTextureHelper with AGFX");
        }
        this.handler = handler;
        this.timestampAligner = alignTimestamps ? new TimestampAligner() : null;
        this.capture2DTexture = capture2DTexture;
        this.useAgfx = useAgfx;
        if (!useAgfx) {
            EglBase create = EglBase.create(sharedContext, EglBase.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_PIXEL_BUFFER));
            this.eglBase = create;
            this.videoFrameHelperOpenGL = RXVideoFrameHelper.createRXVideoFrameHelperOpenGL(create.getEglBaseContext().getEgl14Context());
            try {
                create.createDummyPbufferSurface();
                create.makeCurrent();
            } catch (RuntimeException e) {
                this.eglBase.release();
                handler.getLooper().quit();
                throw e;
            }
        } else {
            this.eglBase = null;
            bind();
            this.videoFrameHelperOpenGL = RXVideoFrameHelper.createRXVideoFrameHelperOpenGL(EGL14.eglGetCurrentContext());
        }
        if (capture2DTexture) {
            this.glRectDrawer = new GlRectDrawer();
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.frameBufferId = iArr[0];
            Matrix.setIdentityM(TEX_MATRIX, 0);
            this.twoDTextureId = GlUtil.generateTexture(3553);
        } else {
            this.glRectDrawer = null;
            this.frameBufferId = 0;
            this.twoDTextureId = 0;
        }
        this.oesTextureId = GlUtil.generateTexture(36197);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.oesTextureId);
        this.surfaceTexture = surfaceTexture;
        setOnFrameAvailableListener(surfaceTexture, new SurfaceTexture.OnFrameAvailableListener() { // from class: com.bytedance.realx.video.SurfaceTextureHelper$$ExternalSyntheticLambda2
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                SurfaceTextureHelper.this.m804lambda$new$0$combytedancerealxvideoSurfaceTextureHelper(surfaceTexture2);
            }
        }, handler);
        if (useAgfx) {
            surfaceTexture.detachFromGLContext();
            this.oesTextureId = 0;
            unbind();
        }
    }

    /* renamed from: lambda$new$0$com-bytedance-realx-video-SurfaceTextureHelper */
    public /* synthetic */ void m804lambda$new$0$combytedancerealxvideoSurfaceTextureHelper(SurfaceTexture surfaceTexture) {
        if (this.enableOutsideControlTextureMemory) {
            synchronized (this.frameSyncObject) {
                this.isAvaliable = true;
                this.frameSyncObject.notifyAll();
            }
            return;
        }
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    private void bind() {
        if (this.useAgfx) {
            RXGPUCacheCtrl.getInstance().bind();
            this.lastBindTimestamp = System.currentTimeMillis();
        }
    }

    private void unbind() {
        if (this.useAgfx) {
            RXGPUCacheCtrl.getInstance().unbind();
            if (this.lastBindTimestamp == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastBindTimestamp > 1000) {
                RXLogging.m287w(TAG, "AGFX bind time: " + (currentTimeMillis - this.lastBindTimestamp));
            }
            this.lastBindTimestamp = 0L;
        }
    }

    private static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener listener, Handler handler) {
        surfaceTexture.setOnFrameAvailableListener(listener, handler);
    }

    public void startListening(final VideoSink listener) {
        if (this.listener != null || this.pendingListener != null) {
            throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
        this.pendingListener = listener;
        this.handler.post(this.setListenerRunnable);
        if (this.enableOutsideControlTextureMemory) {
            return;
        }
        this.handler.post(this.timedDeliverRunnable);
    }

    public void stopListening() {
        RXLogging.m285i(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: com.bytedance.realx.video.SurfaceTextureHelper$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceTextureHelper.this.m297x96971baa();
            }
        });
    }

    /* renamed from: lambda$stopListening$1$com-bytedance-realx-video-SurfaceTextureHelper */
    public /* synthetic */ void m297x96971baa() {
        this.listener = null;
        this.pendingListener = null;
    }

    public void setTextureSize(final int textureWidth, final int textureHeight, boolean enableTextureSizeCheck) {
        if (enableTextureSizeCheck && textureWidth == this.textureWidth && textureHeight == this.textureHeight) {
            return;
        }
        if (textureWidth <= 0) {
            throw new IllegalArgumentException("Texture width must be positive, but was " + textureWidth);
        }
        if (textureHeight <= 0) {
            throw new IllegalArgumentException("Texture height must be positive, but was " + textureHeight);
        }
        this.surfaceTexture.setDefaultBufferSize(textureWidth, textureHeight);
        this.handler.post(new Runnable() { // from class: com.bytedance.realx.video.SurfaceTextureHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceTextureHelper.this.m296xbdeec32e(textureWidth, textureHeight);
            }
        });
    }

    /* renamed from: lambda$setTextureSize$2$com-bytedance-realx-video-SurfaceTextureHelper */
    public /* synthetic */ void m296xbdeec32e(int i, int i2) {
        this.textureWidth = i;
        this.textureHeight = i2;
        if (this.capture2DTexture) {
            bind();
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.twoDTextureId);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
            GLES20.glBindTexture(3553, 0);
            unbind();
        }
    }

    public void setTextureSize(int textureWidth, int textureHeight) {
        setTextureSize(textureWidth, textureHeight, false);
    }

    public void setTextureMemoryReuse(boolean enableTextureMemReuse) {
        RXLogging.m285i(TAG, "enableTextureMemReuse is: " + enableTextureMemReuse);
        this.enableTextureMemoryReuse = enableTextureMemReuse;
    }

    /* renamed from: lambda$setFrameRotation$3$com-bytedance-realx-video-SurfaceTextureHelper */
    public /* synthetic */ void m295x6eca575e(int i) {
        this.frameRotation = i;
    }

    public void setFrameRotation(final int rotation) {
        this.handler.post(new Runnable() { // from class: com.bytedance.realx.video.SurfaceTextureHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceTextureHelper.this.m295x6eca575e(rotation);
            }
        });
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public void onFrame(MediaCodecTextureBufferHelper task) {
        NativeRXOpenGLMemory createRXOpenGLMemory;
        if (this.textureHeight <= 0 || this.textureWidth <= 0) {
            task.runTask(false);
            return;
        }
        long timestamp = this.surfaceTexture.getTimestamp();
        float[] fArr = new float[16];
        if (this.capture2DTexture) {
            GLES20.glBindFramebuffer(36160, this.frameBufferId);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.twoDTextureId, 0);
            GlRectDrawer glRectDrawer = this.glRectDrawer;
            int i = this.oesTextureId;
            float[] fArr2 = TEX_MATRIX;
            int i2 = this.textureWidth;
            int i3 = this.textureHeight;
            glRectDrawer.drawOes(i, fArr2, i2, i3, 0, 0, i2, i3);
            GLES20.glBindFramebuffer(36160, 0);
            int i4 = this.textureWidth;
            int i5 = this.textureHeight;
            createRXOpenGLMemory = NativeRXOpenGLMemory.createRXOpenGLMemory(i4, i5, i4, i5, this.twoDTextureId, RXPixelFormat.kTexture2D, fArr, this.eglBase.getEglBaseContext().getEgl14Context(), RXVideoScaleFilter.kOpenGLOrigin, RXVideoRotation.fromId(this.frameRotation), new SurfaceTextureHelper$$ExternalSyntheticLambda3(this));
        } else {
            int i6 = this.textureWidth;
            int i7 = this.textureHeight;
            createRXOpenGLMemory = NativeRXOpenGLMemory.createRXOpenGLMemory(i6, i7, i6, i7, this.oesTextureId, RXPixelFormat.kTextureOES, fArr, this.eglBase.getEglBaseContext().getEgl14Context(), RXVideoScaleFilter.kOpenGLOrigin, RXVideoRotation.fromId(this.frameRotation), new SurfaceTextureHelper$$ExternalSyntheticLambda3(this));
        }
        task.setSurfaceTextureHelper(this);
        createRXOpenGLMemory.setRenderHelper(task);
        NativeRXVideoFrame createRXVideoFrame = NativeRXVideoFrame.createRXVideoFrame(createRXOpenGLMemory, this.videoFrameHelperOpenGL, timestamp, (ByteBuffer) null, RXColorSpace.kYCbCrBT601LimitedRange);
        this.listener.onFrame(createRXVideoFrame);
        createRXOpenGLMemory.release();
        createRXVideoFrame.release();
    }

    public void returnTextureFrame() {
        this.handler.post(new Runnable() { // from class: com.bytedance.realx.video.SurfaceTextureHelper$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceTextureHelper.this.m294x3b9bf204();
            }
        });
    }

    /* renamed from: lambda$returnTextureFrame$4$com-bytedance-realx-video-SurfaceTextureHelper */
    public /* synthetic */ void m294x3b9bf204() {
        if (this.useAgfx) {
            this.surfaceTexture.detachFromGLContext();
            this.oesTextureId = 0;
            unbind();
        }
        this.isTextureInUse = false;
        if (this.isQuitting) {
            release();
        } else {
            if (this.enableOutsideControlTextureMemory) {
                return;
            }
            tryDeliverTextureFrame();
        }
    }

    public boolean isTextureInUse() {
        return this.isTextureInUse;
    }

    public void setMinFps(int fps) {
        if (fps > 0) {
            this.maxDeliverTimerInternal = (int) (1000.0f / fps);
        } else {
            this.maxDeliverTimerInternal = 0;
        }
    }

    public void dispose() {
        RXLogging.m285i(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: com.bytedance.realx.video.SurfaceTextureHelper$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceTextureHelper.this.m803lambda$dispose$5$combytedancerealxvideoSurfaceTextureHelper();
            }
        });
    }

    /* renamed from: lambda$dispose$5$com-bytedance-realx-video-SurfaceTextureHelper */
    public /* synthetic */ void m803lambda$dispose$5$combytedancerealxvideoSurfaceTextureHelper() {
        this.isQuitting = true;
        if (this.isTextureInUse) {
            return;
        }
        if (this.enableTextureMemoryReuse && !this.capture2DTexture && !this.useAgfx) {
            RXLogging.m285i(TAG, "memory.release() in dispose()");
            this.memory.release();
        } else {
            release();
        }
    }

    public void updateTexImage() {
        synchronized (EglBase.lock) {
            this.surfaceTexture.updateTexImage();
        }
        synchronized (this.frameSyncObject) {
            this.isAvaliable = false;
        }
    }

    public boolean updateTexImageAndWait(int timeout) {
        synchronized (this.frameSyncObject) {
            do {
                if (!this.isAvaliable) {
                    try {
                        this.frameSyncObject.wait(timeout);
                    } catch (InterruptedException e) {
                        RXLogging.m283e(TAG, "updateTexImage exception: " + e.getMessage());
                        return false;
                    }
                } else {
                    synchronized (EglBase.lock) {
                        this.surfaceTexture.updateTexImage();
                    }
                    this.isAvaliable = false;
                    return true;
                }
            } while (this.isAvaliable);
            return false;
        }
    }

    public float[] getTexMatrix() {
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        return fArr;
    }

    public void tryDeliverTextureFrame() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isQuitting || !this.hasPendingTexture || this.isTextureInUse || this.listener == null) {
            return;
        }
        if (this.textureWidth == 0 || this.textureHeight == 0) {
            RXLogging.m287w(TAG, "Texture size has not been set.");
            return;
        }
        if (this.useAgfx) {
            bind();
            int generateTexture = GlUtil.generateTexture(36197);
            this.oesTextureId = generateTexture;
            this.surfaceTexture.attachToGLContext(generateTexture);
        }
        this.isTextureInUse = true;
        this.hasPendingTexture = false;
        try {
            updateTexImage();
            float[] fArr = new float[16];
            this.surfaceTexture.getTransformMatrix(fArr);
            long timestamp = this.surfaceTexture.getTimestamp();
            TimestampAligner timestampAligner = this.timestampAligner;
            if (timestampAligner != null) {
                timestamp = timestampAligner.translateTimestamp(timestamp);
            }
            long j = timestamp;
            this.lastDeliverTime = System.currentTimeMillis();
            if (this.capture2DTexture) {
                GLES20.glBindFramebuffer(36160, this.frameBufferId);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.twoDTextureId, 0);
                GlRectDrawer glRectDrawer = this.glRectDrawer;
                int i = this.oesTextureId;
                float[] fArr2 = TEX_MATRIX;
                int i2 = this.textureWidth;
                int i3 = this.textureHeight;
                glRectDrawer.drawOes(i, fArr2, i2, i3, 0, 0, i2, i3);
                GLES20.glBindFramebuffer(36160, 0);
                int i4 = this.textureWidth;
                int i5 = this.textureHeight;
                this.memory = NativeRXOpenGLMemory.createRXOpenGLMemory(i4, i5, i4, i5, this.twoDTextureId, RXPixelFormat.kTexture2D, fArr, EGL14.eglGetCurrentContext(), RXVideoScaleFilter.kOpenGLOrigin, RXVideoRotation.fromId(this.frameRotation), new SurfaceTextureHelper$$ExternalSyntheticLambda3(this));
            } else if (this.enableTextureMemoryReuse && !this.useAgfx) {
                NativeRXOpenGLMemory nativeRXOpenGLMemory = this.memory;
                if (nativeRXOpenGLMemory == null || this.oesTextureId != this.prevOesTextureId || this.textureWidth != this.prevTextureWidth || this.textureHeight != this.prevTextureHeight) {
                    this.prevOesTextureId = this.oesTextureId;
                    this.prevTextureWidth = this.textureWidth;
                    this.prevTextureHeight = this.textureHeight;
                    if (nativeRXOpenGLMemory != null) {
                        RXLogging.m285i(TAG, "memory.release() in tryDeliverTextureFrame");
                        this.memory.release();
                    }
                    int i6 = this.textureWidth;
                    int i7 = this.textureHeight;
                    this.memory = NativeRXOpenGLMemory.createRXOpenGLMemory(i6, i7, i6, i7, this.oesTextureId, RXPixelFormat.kTextureOES, fArr, EGL14.eglGetCurrentContext(), RXVideoScaleFilter.kOpenGLOrigin, RXVideoRotation.fromId(this.frameRotation), new SurfaceTextureHelper$$ExternalSyntheticLambda3(this));
                }
            } else {
                int i8 = this.textureWidth;
                int i9 = this.textureHeight;
                this.memory = NativeRXOpenGLMemory.createRXOpenGLMemory(i8, i9, i8, i9, this.oesTextureId, RXPixelFormat.kTextureOES, fArr, EGL14.eglGetCurrentContext(), RXVideoScaleFilter.kOpenGLOrigin, RXVideoRotation.fromId(this.frameRotation), new SurfaceTextureHelper$$ExternalSyntheticLambda3(this));
            }
            NativeRXVideoFrame createRXVideoFrame = NativeRXVideoFrame.createRXVideoFrame(this.memory, this.videoFrameHelperOpenGL, j, (ByteBuffer) null, RXColorSpace.kYCbCrBT601LimitedRange);
            this.listener.onFrame(createRXVideoFrame);
            if (this.enableTextureMemoryReuse && !this.capture2DTexture && !this.useAgfx) {
                returnTextureFrame();
            } else {
                this.memory.release();
            }
            createRXVideoFrame.release();
        } catch (Exception e) {
            RXLogging.m284e(TAG, " updateTexImage failure", e);
            this.isTextureInUse = false;
            this.hasPendingTexture = true;
        }
    }

    private void release() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isTextureInUse || !this.isQuitting) {
            throw new IllegalStateException("Unexpected release.");
        }
        bind();
        int i = this.oesTextureId;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.oesTextureId = 0;
        }
        if (this.capture2DTexture) {
            GLES20.glDeleteTextures(1, new int[]{this.twoDTextureId}, 0);
            GLES20.glDeleteFramebuffers(1, new int[]{this.frameBufferId}, 0);
            this.glRectDrawer.release();
        }
        this.surfaceTexture.release();
        EglBase eglBase = this.eglBase;
        if (eglBase != null) {
            eglBase.release();
        }
        unbind();
        RXVideoFrameHelperInterface rXVideoFrameHelperInterface = this.videoFrameHelperOpenGL;
        if (rXVideoFrameHelperInterface != null) {
            rXVideoFrameHelperInterface.release();
            this.videoFrameHelperOpenGL = null;
        }
        this.handler.getLooper().quit();
        TimestampAligner timestampAligner = this.timestampAligner;
        if (timestampAligner != null) {
            timestampAligner.dispose();
        }
    }
}
