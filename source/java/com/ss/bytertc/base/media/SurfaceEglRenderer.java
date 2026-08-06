package com.ss.bytertc.base.media;

import android.view.SurfaceHolder;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
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

    @Override // com.ss.bytertc.base.media.EglRenderer
    public void init(final EglBase.Context sharedContext, final int[] configAttributes, RendererCommon.GlDrawer drawer) {
        init(sharedContext, (RendererCommon.RendererEvents) null, configAttributes, drawer);
    }

    @Override // com.ss.bytertc.base.media.EglRenderer
    public void setFpsReduction(float fps) {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = fps == 0.0f;
        }
        super.setFpsReduction(fps);
    }

    @Override // com.ss.bytertc.base.media.EglRenderer
    public void disableFpsReduction() {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = false;
        }
        super.disableFpsReduction();
    }

    @Override // com.ss.bytertc.base.media.EglRenderer
    public void pauseVideo() {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = true;
        }
        super.pauseVideo();
    }

    @Override // com.ss.bytertc.base.media.EglRenderer, com.ss.bytertc.base.media.VideoSink
    public void onFrame(VideoFrame frame) {
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

    private void updateFrameDimensionsAndReportEvents(VideoFrame frame) {
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
            if (this.rotatedFrameWidth != frame.getRotatedWidth() || this.rotatedFrameHeight != frame.getRotatedHeight() || this.frameRotation != frame.getRotation()) {
                logD("Reporting frame resolution changed to " + frame.getBuffer().getWidth() + "x" + frame.getBuffer().getHeight() + " with rotation " + frame.getRotation());
                RendererCommon.RendererEvents rendererEvents2 = this.rendererEvents;
                if (rendererEvents2 != null) {
                    rendererEvents2.onFrameResolutionChanged(frame.getBuffer().getWidth(), frame.getBuffer().getHeight(), frame.getRotation());
                }
                this.rotatedFrameWidth = frame.getRotatedWidth();
                this.rotatedFrameHeight = frame.getRotatedHeight();
                this.frameRotation = frame.getRotation();
            }
        }
    }

    @Override // com.ss.bytertc.base.media.EglRenderer
    public void release() {
        super.release();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Objects.requireNonNull(countDownLatch);
        releaseEglSurface(new SurfaceEglRenderer$$ExternalSyntheticLambda0(countDownLatch));
        ThreadUtils.awaitUninterruptibly(countDownLatch);
    }

    private void logD(String string) {
        RXLogging.i(TAG, this.name + ": " + string);
    }
}
