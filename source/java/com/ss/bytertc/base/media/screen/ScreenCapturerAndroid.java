package com.ss.bytertc.base.media.screen;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.util.Log;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.base.media.VideoSink;
import com.ss.bytertc.base.media.camera.CameraSession;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ScreenCapturerAndroid implements VideoCapturer, VideoSink {
    private static final String TAG = "ScreenCaptureAndroid";
    private CapturerObserver capturerObserver;
    private Context mContext;
    private CountDownLatch mCountDownLatch;
    private boolean needStartService;

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableCameraAutoExposureFaceMode(boolean enable) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableFollowGravity(boolean enable) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public float getCameraZoomMaxRatio() {
        return 1.0f;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraExposurePointSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraFocusPointSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraTorchSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraZoomSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isScreencast() {
        return true;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposureCompensation(float val) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposurePoint(float x, float y) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraFocusPoint(float x, float y) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraZoomRatio(float zoom_val) {
        return 0;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOffFlashLight() {
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOnFlashLight() {
    }

    public ScreenCapturerAndroid(Intent mediaProjectionPermissionResultData, MediaProjection.Callback mediaProjectionCallback) {
        this(mediaProjectionPermissionResultData, mediaProjectionCallback, true);
    }

    public ScreenCapturerAndroid(Intent mediaProjectionPermissionResultData, MediaProjection.Callback mediaProjectionCallback, boolean needStartService) {
        this.mCountDownLatch = new CountDownLatch(1);
        this.needStartService = true;
        this.capturerObserver = null;
        ScreenCaptureAndroidManager.INSTANCE().addLock(this.mCountDownLatch.hashCode(), this.mCountDownLatch);
        ScreenCaptureAndroidManager.INSTANCE().setData(mediaProjectionPermissionResultData, mediaProjectionCallback);
        this.needStartService = needStartService;
    }

    public synchronized void initialize(final EglBase.Context sharedContext, final Context applicationContext, final CapturerObserver capturerObserver) {
        this.mContext = applicationContext;
        this.capturerObserver = capturerObserver;
        ScreenCaptureAndroidManager.INSTANCE().initialize(sharedContext, applicationContext, capturerObserver);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void initialize(final SurfaceTextureHelper surfaceTextureHelper, final Context applicationContext, final CapturerObserver capturerObserver) {
        this.mContext = applicationContext;
        this.capturerObserver = capturerObserver;
        ScreenCaptureAndroidManager.INSTANCE().initialize(surfaceTextureHelper, applicationContext, capturerObserver);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(final int width, final int height, final int ignoredFramerate, final int min_framerate) {
        if (this.needStartService && Build.VERSION.SDK_INT > 28) {
            Intent intent = new Intent();
            intent.putExtra("w", width);
            intent.putExtra(RXScreenCaptureService.KEY_HEIGHT, height);
            intent.putExtra(RXScreenCaptureService.KEY_IFRAMERATE, ignoredFramerate);
            if (min_framerate <= 0) {
                min_framerate = 4;
            }
            intent.putExtra(RXScreenCaptureService.KEY_MIN_FRAMERATE, min_framerate);
            int i = 20;
            while (true) {
                try {
                    if (!RXScreenCaptureService.serviceStarted.get()) {
                        int i2 = i - 1;
                        if (i <= 0) {
                            i = i2;
                            break;
                        }
                        try {
                            Thread.sleep(50L);
                        } catch (InterruptedException e) {
                            RXLogging.w(TAG, "[ScreenCapture] sleep exception");
                            e.printStackTrace();
                        }
                        i = i2;
                    } else {
                        break;
                    }
                } catch (ForegroundServiceStartNotAllowedException unused) {
                    CapturerObserver capturerObserver = this.capturerObserver;
                    if (capturerObserver != null) {
                        capturerObserver.onCapturerError("Start foreground service failed.");
                    }
                }
            }
            if (i > 0) {
                RXLogging.w(TAG, String.format("[ScreenCapture]  call RXScreenCaptureService.COMMAND_START success, wait times:%d ms", Integer.valueOf((3 - i) * 50)));
                Context context = this.mContext;
                context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 1, intent));
            } else {
                RXLogging.w(TAG, String.format("[ScreenCapture] wait start service timeout", new Object[0]));
            }
        }
        ScreenCaptureAndroidManager.INSTANCE().startCapture(width, height, ignoredFramerate, min_framerate);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(final int width, final int height, final int ignoredFramerate) {
        startCapture(width, height, ignoredFramerate, 4);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void stopCapture() {
        if (!this.needStartService || Build.VERSION.SDK_INT <= 28) {
            ScreenCaptureAndroidManager.INSTANCE().stopCapture();
        } else {
            try {
                if (RXScreenCaptureService.serviceStarted.get()) {
                    Context context = this.mContext;
                    context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 2, null));
                }
            } catch (ForegroundServiceStartNotAllowedException unused) {
                CapturerObserver capturerObserver = this.capturerObserver;
                if (capturerObserver != null) {
                    capturerObserver.onCapturerError("Start foreground service failed.");
                }
            }
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void dispose() {
        if (this.needStartService && Build.VERSION.SDK_INT > 28) {
            Intent intent = new Intent();
            intent.putExtra(RXScreenCaptureService.KEY_HASHCODE, this.mCountDownLatch.hashCode());
            try {
                if (RXScreenCaptureService.serviceStarted.get()) {
                    Context context = this.mContext;
                    context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 5, intent));
                }
            } catch (ForegroundServiceStartNotAllowedException unused) {
                CapturerObserver capturerObserver = this.capturerObserver;
                if (capturerObserver != null) {
                    capturerObserver.onCapturerError("Start foreground service failed.");
                }
            }
            try {
                this.mCountDownLatch.await(1500L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "dispose finish");
        }
        ScreenCaptureAndroidManager.INSTANCE().dispose();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void changeCaptureFormat(final int width, final int height, final int ignoredFramerate) {
        if (this.needStartService && Build.VERSION.SDK_INT > 28) {
            Intent intent = new Intent();
            intent.putExtra("w", width);
            intent.putExtra(RXScreenCaptureService.KEY_HEIGHT, height);
            intent.putExtra(RXScreenCaptureService.KEY_IFRAMERATE, ignoredFramerate);
            try {
                if (RXScreenCaptureService.serviceStarted.get()) {
                    Context context = this.mContext;
                    context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 3, intent));
                }
            } catch (ForegroundServiceStartNotAllowedException unused) {
                CapturerObserver capturerObserver = this.capturerObserver;
                if (capturerObserver != null) {
                    capturerObserver.onCapturerError("Start foreground service failed.");
                }
            }
        }
        ScreenCaptureAndroidManager.INSTANCE().changeCaptureFormat(width, height, ignoredFramerate);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int getDeviceOrientation() {
        return CameraSession.getDeviceUIOrientation(ContextUtils.getApplicationContext());
    }

    @Override // com.ss.bytertc.base.media.VideoSink
    public void onFrame(VideoFrame frame) {
        if (!this.needStartService || Build.VERSION.SDK_INT <= 28) {
            ScreenCaptureAndroidManager.INSTANCE().onFrame(frame);
            return;
        }
        int addFrame = ScreenCaptureAndroidManager.INSTANCE().addFrame(frame);
        Intent intent = new Intent();
        intent.putExtra(RXScreenCaptureService.KEY_INDEX, addFrame);
        try {
            if (RXScreenCaptureService.serviceStarted.get()) {
                Context context = this.mContext;
                context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 4, intent));
            }
        } catch (ForegroundServiceStartNotAllowedException unused) {
            CapturerObserver capturerObserver = this.capturerObserver;
            if (capturerObserver != null) {
                capturerObserver.onCapturerError("Start foreground service failed.");
            }
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void disableDoOrientation() {
        ScreenCaptureAndroidManager.INSTANCE().disableDoOrientation();
    }

    public MediaProjection getMediaProjection() {
        return ScreenCaptureAndroidManager.INSTANCE().getMediaProjection();
    }
}
