package com.ss.bytertc.base.media;

import android.content.Context;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface VideoCapturer {
    void changeCaptureFormat(int width, int height, int framerate);

    void disableDoOrientation();

    void dispose();

    int enableCameraAutoExposureFaceMode(boolean enable);

    int enableFollowGravity(boolean enable);

    float getCameraZoomMaxRatio();

    int getDeviceOrientation();

    void initialize(SurfaceTextureHelper surfaceTextureHelper, Context applicationContext, CapturerObserver capturerObserver);

    boolean isCameraExposurePointSupported();

    boolean isCameraFocusPointSupported();

    boolean isCameraTorchSupported();

    boolean isCameraZoomSupported();

    boolean isScreencast();

    int setCameraExposureCompensation(float val);

    int setCameraExposurePoint(float x, float y);

    int setCameraFocusPoint(float x, float y);

    int setCameraZoomRatio(float zoom_val);

    void startCapture(int width, int height, int framerate);

    void startCapture(int width, int height, int framerate, int min_framerate);

    void stopCapture() throws InterruptedException;

    void turnOffFlashLight();

    void turnOnFlashLight();
}
