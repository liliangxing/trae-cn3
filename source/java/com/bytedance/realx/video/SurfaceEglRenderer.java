package com.bytedance.realx.video;

import android.view.SurfaceHolder;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SurfaceEglRenderer extends EglRenderer implements SurfaceHolder.Callback {
    private static final String TAG = "SurfaceEglRenderer";
    private int frameRotation;
    private boolean isFirstFrameRendered;
    private boolean isRenderingPaused;
    private final Object layoutLock;
    private RendererCommon.RendererEvents rendererEvents;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;

    public SurfaceEglRenderer(String name) {
        super(name);
        this.layoutLock = new Object();
    }

    public void init(final EglBase.Context sharedContext, RendererCommon.RendererEvents rendererEvents, final int[] configAttributes, RendererCommon.GlDrawer drawer) {
        ThreadUtils.checkIsOnMainThread();
        synchronized (this.layoutLock) {
            this.rendererEvents = rendererEvents;
            this.isFirstFrameRendered = false;
            this.rotatedFrameWidth = 0;
            this.rotatedFrameHeight = 0;
            this.frameRotation = 0;
        }
        super.init(sharedContext, configAttributes, drawer);
    }

    @Override // com.bytedance.realx.video.EglRenderer
    public void init(final EglBase.Context sharedContext, final int[] configAttributes, RendererCommon.GlDrawer drawer) {
        init(sharedContext, (RendererCommon.RendererEvents) null, configAttributes, drawer);
    }

    @Override // com.bytedance.realx.video.EglRenderer
    public void setFpsReduction(float fps) {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = fps == 0.0f;
        }
        super.setFpsReduction(fps);
    }

    @Override // com.bytedance.realx.video.EglRenderer
    public void disableFpsReduction() {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = false;
        }
        super.disableFpsReduction();
    }

    @Override // com.bytedance.realx.video.EglRenderer
    public void pauseVideo() {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = true;
        }
        super.pauseVideo();
    }

    @Override // com.bytedance.realx.video.EglRenderer, com.bytedance.realx.video.VideoSink
    public void onFrame(RXVideoFrameInterface frame) {
        updateFrameDimensionsAndReportEvents(frame);
        super.onFrame(frame);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(final SurfaceHolder holder) {
        ThreadUtils.checkIsOnMainThread();
        createEglSurface(holder.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        ThreadUtils.checkIsOnMainThread();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Objects.requireNonNull(countDownLatch);
        releaseEglSurface(new SurfaceEglRenderer$$ExternalSyntheticLambda0(countDownLatch));
        ThreadUtils.awaitUninterruptibly(countDownLatch);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        ThreadUtils.checkIsOnMainThread();
        logD("surfaceChanged: format: " + format + " size: " + width + "x" + height);
    }

    private void updateFrameDimensionsAndReportEvents(RXVideoFrameInterface frame) {
        synchronized (this.layoutLock) {
            if (this.isRenderingPaused) {
                return;
            }
            if (!this.isFirstFrameRendered) {
                this.isFirstFrameRendered = true;
                logD("Reporting first rendered frame.");
                RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
                if (rendererEvents != null) {
                    rendererEvents.onFirstFrameRendered();
                }
            }
            if (this.rotatedFrameWidth != frame.getRotatedWidth() || this.rotatedFrameHeight != frame.getRotatedHeight() || this.frameRotation != frame.getRotation().value()) {
                logD("Reporting frame resolution changed to " + frame.getRotatedWidth() + "x" + frame.getHeight() + " with rotation " + frame.getRotation());
                RendererCommon.RendererEvents rendererEvents2 = this.rendererEvents;
                if (rendererEvents2 != null) {
                    rendererEvents2.onFrameResolutionChanged(frame.getWidth(), frame.getHeight(), frame.getRotation().value());
                }
                this.rotatedFrameWidth = frame.getRotatedWidth();
                this.rotatedFrameHeight = frame.getRotatedHeight();
                this.frameRotation = frame.getRotation().value();
            }
        }
    }

    @Override // com.bytedance.realx.video.EglRenderer
    public void release() {
        super.release();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Objects.requireNonNull(countDownLatch);
        releaseEglSurface(new SurfaceEglRenderer$$ExternalSyntheticLambda0(countDownLatch));
        ThreadUtils.awaitUninterruptibly(countDownLatch);
    }

    private void logD(String string) {
        RXLogging.m285i(TAG, this.name + ": " + string);
    }
}
