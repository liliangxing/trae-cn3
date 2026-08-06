package com.ss.bytertc.base.media.camera;

import android.content.Context;
import android.graphics.Matrix;
import android.view.WindowManager;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.camera.CameraEnumerationAndroid;
import com.ss.bytertc.base.media.camera.CameraVideoCapturer;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface CameraSession {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface CreateSessionCallback {
        void onDone(CameraSession session);

        void onFailure(FailureType failureType, String error);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Events {
        void onCameraClosed(CameraSession session);

        void onCameraConfig(int width, int height, CameraEnumerationAndroid.CaptureFormat.FramerateRange framerateRange);

        void onCameraDisconnected(CameraSession session);

        void onCameraError(CameraSession session, String error);

        void onCameraOpening();

        void onFrameCaptured(CameraSession session, VideoFrame frame);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum FailureType {
        ERROR,
        DISCONNECTED
    }

    int enableCameraAutoExposureFaceMode(boolean enable);

    int enableFollowGravity(boolean enable);

    float getCameraZoomMaxRatio();

    int getDeviceOrientation();

    boolean isCameraExposurePointSupported();

    boolean isCameraFocusPointSupported();

    boolean isCameraTorchSupported();

    boolean isCameraZoomSupported();

    int setCameraExposureCompensation(float val);

    int setCameraExposurePoint(float x, float y);

    int setCameraFocusPoint(float x, float y);

    int setCameraZoomRatio(float zoom_val);

    void setOrientationMode(CameraVideoCapturer.ORIENTATION_MODE orientation);

    void stop();

    void turnOffFlashLight();

    void turnOnFlashLight();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum UIDeviceOrientation {
        Portrait(0),
        LandscapeLeft(90),
        PortraitUpsideDown(180),
        LandscapeRight(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME);

        private int value;

        public int value() {
            return this.value;
        }

        UIDeviceOrientation(int value) {
            this.value = value;
        }
    }

    static int getDeviceUIOrientation(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return UIDeviceOrientation.LandscapeRight.value();
        }
        if (rotation == 2) {
            return UIDeviceOrientation.PortraitUpsideDown.value();
        }
        if (rotation == 3) {
            return UIDeviceOrientation.LandscapeLeft.value();
        }
        return UIDeviceOrientation.Portrait.value();
    }

    static VideoFrame.TextureBuffer createTextureBufferWithModifiedTransformMatrix(TextureBufferImpl buffer, boolean mirror, int rotation) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        if (mirror) {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.preRotate(rotation);
        matrix.preTranslate(-0.5f, -0.5f);
        return buffer.applyTransformMatrix(matrix, buffer.getWidth(), buffer.getHeight());
    }
}
