package com.lynx.canvas.camera;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonCamera;
import com.lynx.canvas.KryptonCameraService;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.SurfaceTextureWrapper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CameraContext {
    private static final String TAG = "CameraContext";
    private KryptonCamera mCamera;

    protected static native void nativeOnCameraCallback(long j, CameraContext cameraContext, int i, int i2);

    static native void nativeOnCameraErrorCallback(long j, String str);

    protected CameraContext(KryptonCamera kryptonCamera) {
        this.mCamera = kryptonCamera;
    }

    static void requestCamera(KryptonApp kryptonApp, long j, String str, String str2, String str3, boolean z) {
        requestCameraWithCustomSize(kryptonApp, j, str, str2, str3, z, 0, 0);
    }

    static void requestCameraWithCustomSize(KryptonApp kryptonApp, long j, String str, String str2, String str3, boolean z, int i, int i2) {
        KryptonCamera.Config config = new KryptonCamera.Config();
        config.faceMode = str;
        config.resolution = str2;
        config.extraJson = str3;
        config.size = new KryptonCamera.CustomSize(i, i2);
        config.autoFocus = z;
        KryptonCameraService kryptonCameraService = (KryptonCameraService) kryptonApp.getService(KryptonCameraService.class);
        if (kryptonCameraService == null) {
            errorCallback(j, "camera service not found");
            return;
        }
        KryptonCamera createCamera = kryptonCameraService.createCamera();
        if (createCamera == null) {
            errorCallback(j, "service create camera return null");
            return;
        }
        if (!createCamera.requestWithConfig(config)) {
            errorCallback(j, "camera request error with config: " + str + " " + str2 + " " + str3);
            return;
        }
        CameraContext cameraContext = new CameraContext(createCamera);
        int width = createCamera.getWidth();
        int height = createCamera.getHeight();
        if (width == 0 || height == 0) {
            KryptonLLog.m2561i(TAG, "downgrade size origin w: " + width + " h: " + height + " resolution: " + str2);
            if (str2.equals("low")) {
                width = CameraSize.lowWidth;
                height = CameraSize.lowHeight;
            } else if (!str2.equals(KryptonCamera.Config.RESOLUTION_MEDIUM) && str2.equals("high")) {
                width = CameraSize.highWidth;
                height = CameraSize.highHeight;
            } else {
                height = 640;
                width = 480;
            }
        }
        nativeOnCameraCallback(j, cameraContext, width, height);
        KryptonLLog.m2561i(TAG, "request camera success with config: " + str + " " + str2 + " " + str3);
    }

    void setupPreviewTexture(SurfaceTextureWrapper surfaceTextureWrapper) {
        this.mCamera.setupPreviewTexture(surfaceTextureWrapper.getSurfaceTexture());
    }

    void play() {
        this.mCamera.play();
    }

    void pause() {
        this.mCamera.pause();
    }

    void release() {
        KryptonLLog.m2561i(TAG, "CameraContext release");
        this.mCamera.release();
        this.mCamera = null;
    }

    protected static void errorCallback(long j, String str) {
        KryptonLLog.m2560e(TAG, str);
        nativeOnCameraErrorCallback(j, str);
    }
}
