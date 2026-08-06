package com.ss.bytertc.engine.p006ui;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.GlRectDrawer;
import com.bytedance.realx.video.JavaI420Buffer;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.ss.bytertc.base.media.EglRenderer;
import com.ss.bytertc.engine.adapter.VideoFrameConverter;
import com.ss.bytertc.engine.data.VideoBufferType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.mediaio.CountDownLatchI420Buffer;
import com.ss.bytertc.engine.mediaio.SurfaceEglRender;
import com.ss.bytertc.engine.mediaio.TextureEglRenderer;
import com.ss.bytertc.engine.utils.ByteBufferUtils;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IVideoFrame;
import com.ss.bytertc.engine.video.converter.WebRTCConverter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VideoFrameRender implements View.OnLayoutChangeListener, RendererCommon.RendererEvents, EglRenderer.FirstVideoFrameRenderListener {
    private static final String TAG = "VideoFrameRender";
    private boolean enableFixedSize;
    private volatile EglRenderer mEglRenderer;
    private final String mRenderName;
    private volatile Surface mSurface;
    private volatile SurfaceView mSurfaceView;
    private Looper mTextureProcessLooper;
    private volatile TextureView mTextureView;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private int surfaceHeight;
    private int surfaceWidth;
    private long mReceiveFirstTimeStampMs = 0;
    private boolean mHasReceivedFirstFrame = false;
    private final AtomicBoolean mHasInitAtomic = new AtomicBoolean(false);
    private final AtomicBoolean mHasRenderViewAtomic = new AtomicBoolean(false);
    private final AtomicBoolean mEglSurfaceCreatedAtomic = new AtomicBoolean(false);
    private final Object mRenderLock = new Object();
    private final Object mTextureProcessLock = new Object();
    private final Object mFirstFrameListenerLock = new Object();
    private final ArrayList<FirstVideoFrameRenderListener> mFirstVideoFrameListeners = new ArrayList<>();
    private final VideoFrameConverter frameConverter = new VideoFrameConverter(true);
    private final SurfaceLifecycleCallback mSurfaceLifecycleCallbackCallback = new SurfaceLifecycleCallback() { // from class: com.ss.bytertc.engine.ui.VideoFrameRender.1
        @Override // com.ss.bytertc.engine.ui.VideoFrameRender.SurfaceLifecycleCallback
        public void onCreated() {
            if (VideoFrameRender.this.mEglSurfaceCreatedAtomic.compareAndSet(false, true)) {
                return;
            }
            LogUtil.m216e(VideoFrameRender.TAG, "Already has an another surface created.");
        }

        @Override // com.ss.bytertc.engine.ui.VideoFrameRender.SurfaceLifecycleCallback
        public void onDestroy() {
            if (!VideoFrameRender.this.mHasInitAtomic.get()) {
                VideoFrameRender.this.mEglSurfaceCreatedAtomic.set(false);
            } else {
                if (VideoFrameRender.this.mEglSurfaceCreatedAtomic.compareAndSet(true, false)) {
                    return;
                }
                LogUtil.m216e(VideoFrameRender.TAG, "Already has an another surface destroyed.");
            }
        }
    };

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface FirstVideoFrameRenderListener {
        void onFirstVideoFrameRender(int elapse);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface SurfaceLifecycleCallback {
        void onCreated();

        void onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$renderTextureFrame$2() {
    }

    public void onFirstFrameRendered() {
    }

    public VideoFrameRender(String name) {
        this.mRenderName = name;
    }

    public void setRenderView(SurfaceView surfaceView, SurfaceHolder.Callback callback) {
        if (this.mEglSurfaceCreatedAtomic.get() || surfaceView == null || !this.mHasRenderViewAtomic.compareAndSet(false, true)) {
            return;
        }
        this.mSurfaceView = surfaceView;
        synchronized (this.mRenderLock) {
            SurfaceEglRender surfaceEglRender = new SurfaceEglRender(this.mRenderName);
            surfaceEglRender.setSurfaceHolderCallback(callback);
            surfaceEglRender.setSurfaceLifecycleLisenter(this.mSurfaceLifecycleCallbackCallback);
            this.mEglRenderer = surfaceEglRender;
            this.mEglRenderer.addFristFrameListener(this);
        }
    }

    public void setRenderView(Surface surface) {
        if (this.mEglSurfaceCreatedAtomic.get() || surface == null || !this.mHasRenderViewAtomic.compareAndSet(false, true)) {
            return;
        }
        synchronized (this.mRenderLock) {
            this.mSurface = surface;
            new EglRenderer(this.mRenderName).createEglSurface(surface);
        }
        this.mEglSurfaceCreatedAtomic.compareAndSet(false, true);
    }

    public void setRenderView(TextureView textureView, TextureView.SurfaceTextureListener listener) {
        if (this.mEglSurfaceCreatedAtomic.get() || textureView == null || !this.mHasRenderViewAtomic.compareAndSet(false, true)) {
            return;
        }
        synchronized (this.mRenderLock) {
            this.mTextureView = textureView;
            TextureEglRenderer textureEglRenderer = new TextureEglRenderer(this.mRenderName);
            textureEglRenderer.setSurfaceTextureListener(listener);
            this.mEglRenderer = textureEglRenderer;
            this.mEglRenderer.addFristFrameListener(this);
        }
    }

    private void initSurfaceView() {
        if (this.mSurfaceView == null || !this.mHasInitAtomic.get()) {
            return;
        }
        synchronized (this.mRenderLock) {
            if (this.mEglRenderer instanceof SurfaceEglRender) {
                ((SurfaceEglRender) this.mEglRenderer).bind(this.mSurfaceView);
                this.mSurfaceView.addOnLayoutChangeListener(this);
            }
        }
    }

    private void initTextureView() {
        if (this.mTextureView == null || this.mEglRenderer == null || !this.mHasInitAtomic.get()) {
            return;
        }
        synchronized (this.mRenderLock) {
            if (this.mEglRenderer instanceof TextureEglRenderer) {
                TextureEglRenderer textureEglRenderer = (TextureEglRenderer) this.mEglRenderer;
                textureEglRenderer.bind(this.mTextureView, this.mSurfaceLifecycleCallbackCallback);
                if (this.mTextureView.isShown()) {
                    textureEglRenderer.setLayoutAspectRatio(this.mTextureView.getMeasuredWidth() / this.mTextureView.getMeasuredHeight());
                }
                this.mTextureView.addOnLayoutChangeListener(this);
            }
        }
    }

    public void onStart() {
        if (this.mHasRenderViewAtomic.get() && this.mHasInitAtomic.get()) {
            if (this.mTextureView != null) {
                initTextureView();
            } else if (this.mSurfaceView != null) {
                initSurfaceView();
            }
        }
    }

    public void onDispose() {
        if (this.mHasInitAtomic.compareAndSet(true, false)) {
            synchronized (this.mRenderLock) {
                if (this.mEglRenderer != null) {
                    this.mEglRenderer.release();
                    this.mEglRenderer.createEglSurface((Surface) null);
                }
                if (this.mSurfaceView != null) {
                    this.mSurfaceView.removeOnLayoutChangeListener(this);
                } else if (this.mTextureView != null) {
                    this.mTextureView.setSurfaceTextureListener(null);
                    this.mTextureView.removeOnLayoutChangeListener(this);
                }
                this.mEglSurfaceCreatedAtomic.set(false);
            }
            synchronized (this.mFirstFrameListenerLock) {
                this.mFirstVideoFrameListeners.clear();
            }
            return;
        }
        throw new IllegalStateException("Try to dispose an not initialized VideoFrameRender");
    }

    public void init(final EglBase.Context sharedContext) {
        if (this.mHasInitAtomic.compareAndSet(false, true)) {
            synchronized (this.mRenderLock) {
                if (this.mSurfaceView == null && this.mSurface == null && this.mTextureView == null && this.mEglRenderer == null) {
                    return;
                }
                this.rotatedFrameWidth = 0;
                this.rotatedFrameHeight = 0;
                if (this.mEglRenderer instanceof SurfaceEglRender) {
                    ThreadUtils.invokeAtFrontUninterruptibly(new Handler(Looper.getMainLooper()), new Runnable() { // from class: com.ss.bytertc.engine.ui.VideoFrameRender$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoFrameRender.this.m4171lambda$init$0$comssbytertcengineuiVideoFrameRender(sharedContext);
                        }
                    });
                } else {
                    this.mEglRenderer.init(sharedContext, EglBase.CONFIG_PLAIN, new GlRectDrawer());
                }
                return;
            }
        }
        throw new IllegalStateException("Already initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$0$com-ss-bytertc-engine-ui-VideoFrameRender, reason: not valid java name */
    public /* synthetic */ void m4171lambda$init$0$comssbytertcengineuiVideoFrameRender(EglBase.Context context) {
        this.mEglRenderer.init(context, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    private void onVideoFrame(final VideoFrame frame) {
        synchronized (this.mRenderLock) {
            if (this.mEglSurfaceCreatedAtomic.get() && this.mEglRenderer != null) {
                if (!this.mHasReceivedFirstFrame) {
                    this.mReceiveFirstTimeStampMs = System.currentTimeMillis();
                    this.mHasReceivedFirstFrame = true;
                }
                this.mEglRenderer.onFrame(frame);
            }
        }
    }

    public void setScalingType(final RendererCommon.ScalingType scalingType) {
        synchronized (this.mRenderLock) {
            if (this.mEglRenderer != null) {
                this.mEglRenderer.setRenderModel(scalingType);
            }
        }
    }

    public void release() {
        onDispose();
    }

    public void setMirror(final boolean mirror) {
        synchronized (this.mRenderLock) {
            if (this.mEglRenderer != null) {
                this.mEglRenderer.setMirror(mirror);
            }
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(final View v, final int left, final int top, final int right, final int bottom, final int oldLeft, final int oldTop, final int oldRight, final int oldBottom) {
        ThreadUtils.checkIsOnMainThread();
        synchronized (this.mRenderLock) {
            if (this.mEglRenderer != null) {
                this.mEglRenderer.setLayoutAspectRatio((right - left) / (bottom - top));
            }
            if (this.mSurfaceView != null) {
                updateSurfaceSize();
            }
        }
    }

    public void onFrameResolutionChanged(final int videoWidth, final int videoHeight, final int rotation) {
        final int i = (rotation == 0 || rotation == 180) ? videoWidth : videoHeight;
        if (rotation == 0 || rotation == 180) {
            videoWidth = videoHeight;
        }
        postOrRun(new Runnable() { // from class: com.ss.bytertc.engine.ui.VideoFrameRender$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                VideoFrameRender.this.m214x27a318eb(i, videoWidth);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onFrameResolutionChanged$1$com-ss-bytertc-engine-ui-VideoFrameRender */
    public /* synthetic */ void m214x27a318eb(int i, int i2) {
        this.rotatedFrameWidth = i;
        this.rotatedFrameHeight = i2;
    }

    private void renderTextureFrame(int texId, VideoFrame.TextureBuffer.Type type, int width, int height, int rotation, long ts, float[] matrix, Looper looper) {
        VideoFrame videoFrame = new VideoFrame(new TextureBufferImpl(width, height, type, texId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(matrix), new Handler(looper), new YuvConverter(), new Runnable() { // from class: com.ss.bytertc.engine.ui.VideoFrameRender$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                VideoFrameRender.lambda$renderTextureFrame$2();
            }
        }), rotation, ts);
        onVideoFrame(videoFrame);
        videoFrame.release();
    }

    public void consumeByteBufferFrame(final ByteBuffer buffer, ByteBuffer extendedData, final int format, final int width, final int height, final int rotation, final long timestampNs) {
        if (format != VideoPixelFormat.I420.value()) {
            return;
        }
        renderI420Frame(buffer, width, height, rotation, timestampNs);
    }

    public void consumeByteArrayFrame(final byte[] data, ByteBuffer extendedData, final int format, final int width, final int height, final int rotation, final long timestampNs) {
        if (format != VideoPixelFormat.I420.value()) {
            return;
        }
        renderI420Frame(data, width, height, rotation, timestampNs);
    }

    public void consumeYUVByteArrayFrame(byte[] y, byte[] u, byte[] v, int ystride, int ustride, int vstride, int width, int height, int rotation, long timestampNs, ByteBuffer extendedData) {
        renderI420Frame(this.frameConverter.convertRawYUV2ByteArray(y, u, v, ystride, ustride, vstride, width, height), width, height, rotation, timestampNs);
    }

    public void consumeTextureFrame(final int textureId, ByteBuffer extendedData, final int format, final int width, final int height, final int rotation, final long timestampNs, final float[] matrix) {
        if (format != VideoPixelFormat.I420.value()) {
            return;
        }
        synchronized (this.mTextureProcessLock) {
            if (this.mTextureProcessLooper == null) {
                this.mTextureProcessLooper = Looper.getMainLooper();
            }
            renderTextureFrame(textureId, VideoFrame.TextureBuffer.Type.RGB, width, height, rotation, timestampNs, matrix, this.mTextureProcessLooper);
        }
    }

    public void consumeVideoFrame(IVideoFrame frame) {
        VideoFrame convertByteRGBAFrame2WebrtcI420Frame;
        if (frame.bufferType() == VideoBufferType.GL_TEXTURE) {
            convertByteRGBAFrame2WebrtcI420Frame = WebRTCConverter.convertByteTexFrame2WebrtcTexFrame(frame, this.mTextureProcessLooper);
        } else if (frame.pixelFormat() == VideoPixelFormat.I420) {
            convertByteRGBAFrame2WebrtcI420Frame = WebRTCConverter.convertByteI420Frame2WebrtcI420Frame(frame);
        } else {
            convertByteRGBAFrame2WebrtcI420Frame = frame.pixelFormat() == VideoPixelFormat.RGBA ? WebRTCConverter.convertByteRGBAFrame2WebrtcI420Frame(frame) : null;
        }
        if (convertByteRGBAFrame2WebrtcI420Frame != null) {
            onVideoFrame(convertByteRGBAFrame2WebrtcI420Frame);
            convertByteRGBAFrame2WebrtcI420Frame.release();
        }
    }

    private void renderI420Frame(ByteBuffer data, int width, int height, int rotation, long ts) {
        VideoFrameConverter videoFrameConverter;
        VideoFrame.I420Buffer convertToJavaI420Buffer;
        if (data == null || (videoFrameConverter = this.frameConverter) == null) {
            return;
        }
        if (this.mEglRenderer instanceof TextureEglRenderer) {
            convertToJavaI420Buffer = videoFrameConverter.convertToJavaI420Buffer(data, width, height, true);
        } else {
            convertToJavaI420Buffer = videoFrameConverter.convertToJavaI420Buffer(data, width, height, false);
        }
        if (convertToJavaI420Buffer != null) {
            VideoFrame videoFrame = new VideoFrame(convertToJavaI420Buffer, rotation, ts);
            onVideoFrame(videoFrame);
            videoFrame.release();
        }
    }

    private void renderI420Frame(byte[] data, int width, int height, int rotation, long ts) {
        VideoFrameConverter videoFrameConverter;
        VideoFrame.I420Buffer convertToJavaI420Buffer;
        if (data == null || data.length <= 0 || (videoFrameConverter = this.frameConverter) == null) {
            return;
        }
        if (this.mEglRenderer instanceof TextureEglRenderer) {
            convertToJavaI420Buffer = videoFrameConverter.convertToJavaI420Buffer(data, width, height, true);
        } else {
            convertToJavaI420Buffer = videoFrameConverter.convertToJavaI420Buffer(data, width, height, false);
        }
        if (convertToJavaI420Buffer != null) {
            VideoFrame videoFrame = new VideoFrame(convertToJavaI420Buffer, rotation, ts);
            onVideoFrame(videoFrame);
            videoFrame.release();
        }
    }

    private VideoFrame.Buffer createYUV(byte[] data, int width, int height) {
        if (data != null && data.length != 0) {
            int i = (width + 1) / 2;
            int i2 = width * height;
            int i3 = ((height + 1) / 2) * i;
            final ByteBuffer nativeAllocateBuffer = ByteBufferUtils.nativeAllocateBuffer(i2);
            final ByteBuffer nativeAllocateBuffer2 = ByteBufferUtils.nativeAllocateBuffer(i3);
            final ByteBuffer nativeAllocateBuffer3 = ByteBufferUtils.nativeAllocateBuffer(i3);
            if (nativeAllocateBuffer != null && nativeAllocateBuffer2 != null && nativeAllocateBuffer3 != null) {
                nativeAllocateBuffer.put(data, 0, i2);
                nativeAllocateBuffer2.put(data, i2, i3);
                nativeAllocateBuffer3.put(data, i2 + i3, i3);
                nativeAllocateBuffer.position(0);
                nativeAllocateBuffer2.position(0);
                nativeAllocateBuffer3.position(0);
                if (this.mEglRenderer instanceof TextureEglRenderer) {
                    return CountDownLatchI420Buffer.wrap(width, height, nativeAllocateBuffer, width, nativeAllocateBuffer2, i, nativeAllocateBuffer3, i, new Runnable() { // from class: com.ss.bytertc.engine.ui.VideoFrameRender$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoFrameRender.lambda$createYUV$3(nativeAllocateBuffer, nativeAllocateBuffer2, nativeAllocateBuffer3);
                        }
                    });
                }
                return JavaI420Buffer.wrap(width, height, nativeAllocateBuffer, width, nativeAllocateBuffer2, i, nativeAllocateBuffer3, i, new Runnable() { // from class: com.ss.bytertc.engine.ui.VideoFrameRender$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoFrameRender.lambda$createYUV$4(nativeAllocateBuffer, nativeAllocateBuffer2, nativeAllocateBuffer3);
                    }
                });
            }
            if (nativeAllocateBuffer != null) {
                ByteBufferUtils.nativeReleaseBuffer(nativeAllocateBuffer);
            }
            if (nativeAllocateBuffer2 != null) {
                ByteBufferUtils.nativeReleaseBuffer(nativeAllocateBuffer2);
            }
            if (nativeAllocateBuffer3 != null) {
                ByteBufferUtils.nativeReleaseBuffer(nativeAllocateBuffer3);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$createYUV$3(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        ByteBufferUtils.nativeReleaseBuffer(byteBuffer);
        ByteBufferUtils.nativeReleaseBuffer(byteBuffer2);
        ByteBufferUtils.nativeReleaseBuffer(byteBuffer3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$createYUV$4(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        ByteBufferUtils.nativeReleaseBuffer(byteBuffer);
        ByteBufferUtils.nativeReleaseBuffer(byteBuffer2);
        ByteBufferUtils.nativeReleaseBuffer(byteBuffer3);
    }

    public void setProcessTextureLopper(Looper looper) {
        synchronized (this.mTextureProcessLock) {
            this.mTextureProcessLooper = looper;
        }
    }

    public void setEnableHardwareScaler(boolean enabled) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = enabled;
        if (this.mSurfaceView != null) {
            updateSurfaceSize();
        }
    }

    public void setFpsReduction(float fps) {
        synchronized (this.mRenderLock) {
            if (this.mEglRenderer != null) {
                this.mEglRenderer.setFpsReduction(fps);
            }
        }
    }

    public void disableFpsReduction() {
        synchronized (this.mRenderLock) {
            if (this.mEglRenderer != null) {
                this.mEglRenderer.disableFpsReduction();
            }
        }
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (this.enableFixedSize && this.rotatedFrameWidth != 0 && this.rotatedFrameHeight != 0 && this.mSurfaceView.getWidth() != 0 && this.mSurfaceView.getHeight() != 0) {
            float width = this.mSurfaceView.getWidth() / this.mSurfaceView.getHeight();
            int i = this.rotatedFrameWidth;
            int i2 = this.rotatedFrameHeight;
            if (i / i2 > width) {
                i = (int) (i2 * width);
            } else {
                i2 = (int) (i / width);
            }
            int min = Math.min(this.mSurfaceView.getWidth(), i);
            int min2 = Math.min(this.mSurfaceView.getHeight(), i2);
            LogUtil.m215d(TAG, "updateSurfaceSize. Layout size: " + this.mSurfaceView.getWidth() + "x" + this.mSurfaceView.getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + min + "x" + min2 + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
            if (min == this.surfaceWidth && min2 == this.surfaceHeight) {
                return;
            }
            this.surfaceWidth = min;
            this.surfaceHeight = min2;
            this.mSurfaceView.getHolder().setFixedSize(min, min2);
            return;
        }
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        this.mSurfaceView.getHolder().setSizeFromLayout();
    }

    private void postOrRun(Runnable r) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r.run();
        }
    }

    private void runOnUIThread(Runnable r) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            r.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r);
        }
    }

    public void setFristVideoFrameRenderListener(FirstVideoFrameRenderListener listener) {
        synchronized (this.mFirstFrameListenerLock) {
            this.mFirstVideoFrameListeners.add(listener);
        }
    }

    @Override // com.ss.bytertc.base.media.EglRenderer.FirstVideoFrameRenderListener
    public void onFirstVideoFrameRender() {
        notifyFristRenderCallback();
    }

    private void notifyFristRenderCallback() {
        synchronized (this.mFirstFrameListenerLock) {
            if (this.mFirstVideoFrameListeners.isEmpty()) {
                return;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.mReceiveFirstTimeStampMs);
            Iterator<FirstVideoFrameRenderListener> it = this.mFirstVideoFrameListeners.iterator();
            while (it.hasNext()) {
                it.next().onFirstVideoFrameRender(currentTimeMillis);
            }
        }
    }
}
