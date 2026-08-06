package com.bytedance.realx.video;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.EglRenderer;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SurfaceViewRenderer extends SurfaceView implements SurfaceHolder.Callback, VideoSink, RendererCommon.RendererEvents {
    private static final String TAG = "SurfaceViewRenderer";
    private final SurfaceEglRenderer eglRenderer;
    private boolean enableFixedSize;
    private float radius;
    private RendererCommon.RendererEvents rendererEvents;
    private final String resourceName;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private int surfaceHeight;
    private int surfaceWidth;
    private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    public SurfaceViewRenderer(Context context) {
        super(context);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        SurfaceEglRenderer surfaceEglRenderer = new SurfaceEglRenderer(resourceName);
        this.eglRenderer = surfaceEglRenderer;
        getHolder().addCallback(this);
        getHolder().addCallback(surfaceEglRenderer);
        this.radius = 0.0f;
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
    }

    public SurfaceViewRenderer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        SurfaceEglRenderer surfaceEglRenderer = new SurfaceEglRenderer(resourceName);
        this.eglRenderer = surfaceEglRenderer;
        getHolder().addCallback(this);
        getHolder().addCallback(surfaceEglRenderer);
        this.radius = 0.0f;
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
    }

    public void init(EglBase.Context sharedContext, RendererCommon.RendererEvents rendererEvents) {
        init(sharedContext, rendererEvents, EglBase.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_PLAIN), new GlRectDrawer());
    }

    public void init(final EglBase.Context sharedContext, RendererCommon.RendererEvents rendererEvents, final int[] configAttributes, RendererCommon.GlDrawer drawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(sharedContext, this, configAttributes, drawer);
    }

    public void release() {
        this.eglRenderer.release();
    }

    public void addFrameListener(EglRenderer.FrameListener listener, float scale, RendererCommon.GlDrawer drawerParam) {
        this.eglRenderer.addFrameListener(listener, scale, drawerParam);
    }

    public void addFrameListener(EglRenderer.FrameListener listener, float scale) {
        this.eglRenderer.addFrameListener(listener, scale);
    }

    public void removeFrameListener(EglRenderer.FrameListener listener) {
        this.eglRenderer.removeFrameListener(listener);
    }

    public void setEnableHardwareScaler(boolean enabled) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = enabled;
        updateSurfaceSize();
    }

    public void setMirror(final boolean mirror) {
        this.eglRenderer.setMirror(mirror);
    }

    public void setScalingType(RendererCommon.ScalingType scalingType) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType);
        requestLayout();
        this.eglRenderer.setRenderModel(scalingType);
    }

    public void setScalingType(RendererCommon.ScalingType scalingTypeMatchOrientation, RendererCommon.ScalingType scalingTypeMismatchOrientation) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingTypeMatchOrientation, scalingTypeMismatchOrientation);
        requestLayout();
    }

    public void setFpsReduction(float fps) {
        this.eglRenderer.setFpsReduction(fps);
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    @Override // com.bytedance.realx.video.VideoSink
    public void onFrame(RXVideoFrameInterface frame) {
        this.eglRenderer.onFrame(frame);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int widthSpec, int heightSpec) {
        ThreadUtils.checkIsOnMainThread();
        Point measure = this.videoLayoutMeasure.measure(widthSpec, heightSpec, this.rotatedFrameWidth, this.rotatedFrameHeight);
        setMeasuredDimension(measure.x, measure.y);
        logD("onMeasure(). New size: " + measure.x + "x" + measure.y);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.setLayoutAspectRatio((right - left) / (bottom - top));
        updateSurfaceSize();
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (this.enableFixedSize && this.rotatedFrameWidth != 0 && this.rotatedFrameHeight != 0 && getWidth() != 0 && getHeight() != 0) {
            float width = getWidth() / getHeight();
            int i = this.rotatedFrameWidth;
            int i2 = this.rotatedFrameHeight;
            if (i / i2 > width) {
                i = (int) (i2 * width);
            } else {
                i2 = (int) (i / width);
            }
            int min = Math.min(getWidth(), i);
            int min2 = Math.min(getHeight(), i2);
            logD("updateSurfaceSize. Layout size: " + getWidth() + "x" + getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + min + "x" + min2 + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
            if (min == this.surfaceWidth && min2 == this.surfaceHeight) {
                return;
            }
            this.surfaceWidth = min;
            this.surfaceHeight = min2;
            getHolder().setFixedSize(min, min2);
            return;
        }
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        getHolder().setSizeFromLayout();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(final SurfaceHolder holder) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        updateSurfaceSize();
    }

    private String getResourceName() {
        try {
            return getResources().getResourceEntryName(getId());
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    @Override // com.bytedance.realx.video.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFirstFrameRendered();
        }
    }

    @Override // com.bytedance.realx.video.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(final int videoWidth, int videoHeight, int rotation) {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFrameResolutionChanged(videoWidth, videoHeight, rotation);
        }
        final int i = (rotation == 0 || rotation == 180) ? videoWidth : videoHeight;
        if (rotation == 0 || rotation == 180) {
            videoWidth = videoHeight;
        }
        postOrRun(new Runnable() { // from class: com.bytedance.realx.video.SurfaceViewRenderer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceViewRenderer.this.m298x8447cfe1(i, videoWidth);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onFrameResolutionChanged$0$com-bytedance-realx-video-SurfaceViewRenderer */
    public /* synthetic */ void m298x8447cfe1(int i, int i2) {
        this.rotatedFrameWidth = i;
        this.rotatedFrameHeight = i2;
        updateSurfaceSize();
        requestLayout();
    }

    private void postOrRun(Runnable r) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r.run();
        } else {
            post(r);
        }
    }

    private void logD(String string) {
        RXLogging.m285i(TAG, this.resourceName + ": " + string);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        if (this.radius > 0.0f) {
            Path path = new Path();
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            float f = this.radius;
            path.addRoundRect(rectF, f, f, Path.Direction.CCW);
            canvas.clipPath(path, Region.Op.REPLACE);
        }
        super.draw(canvas);
    }

    public void setRadius(float radius) {
        this.radius = Math.max(0.0f, radius);
    }
}
