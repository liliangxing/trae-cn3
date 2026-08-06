package com.ss.bytertc.base.media.camera;

import android.content.Intent;
import android.hardware.Camera;
import android.media.projection.MediaProjection;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.RXNativeFunctions;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.base.media.camera.CameraVideoCapturer;
import com.ss.bytertc.base.media.screen.ScreenCapturerAndroid;
import com.ss.bytertc.engine.type.ErrorCode;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RXVideoCaptureAndroid {
    private static final String TAG = "RXVideoCaptureAndroid";
    private int mCaptureBufferType;
    private boolean mIsCaptureScreen;
    private long mNativeCaptureObserver;
    private SurfaceTextureHelper mSurfaceTextureHelper;
    private EglBase.Context sharedEglGroup;
    private VideoCapturer mVideoCapturer = null;
    private CameraVideoCapturer.CameraEventsHandler mCameraEventsHandler = null;
    private boolean mIsFrontCamera = true;
    private boolean mIsVideoCaptureInited = false;
    private boolean mIsVideoCaptureWorking = false;
    private int mWidth = 0;
    private int mHeight = 0;
    private EglBase cameraEglBase = null;
    private Intent mCaptureScreenIntent = null;
    private final int UIDeviceOrientationPortrait = 0;
    private final int UIDeviceOrientationLandscapeLeft = 90;
    private final int UIDeviceOrientationPortraitUpsidedown = 180;
    private final int UIDeviceOrientationLandscapeRight = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
    private CapturerObserver localCapturerObserver = new CapturerObserver() { // from class: com.ss.bytertc.base.media.camera.RXVideoCaptureAndroid.1
        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onCapturerFormatSelected(int width, int height, int minFramerate, int maxFramerate, int pixelFormat) {
            RXLogging.w(RXVideoCaptureAndroid.TAG, "onCapturerFormatSelected...");
            RXNativeFunctions.nativeOnCapturerFormatSelected(RXVideoCaptureAndroid.this.mNativeCaptureObserver, width, height, minFramerate, maxFramerate, pixelFormat);
        }

        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onCapturerStarted(final boolean b) {
            if (!b) {
                RXNativeFunctions.nativeOnCapturerError(RXVideoCaptureAndroid.this.mNativeCaptureObserver, 0);
            } else {
                RXLogging.w(RXVideoCaptureAndroid.TAG, "onCapturerStarted...");
                RXNativeFunctions.nativeOnCapturerStarted(RXVideoCaptureAndroid.this.mNativeCaptureObserver, b);
            }
        }

        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onCapturerStopped() {
            RXLogging.w(RXVideoCaptureAndroid.TAG, "onCapturerStopped...");
            RXNativeFunctions.nativeOnCapturerStopped(RXVideoCaptureAndroid.this.mNativeCaptureObserver);
        }

        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onCapturerError(String errorMsg) {
            RXLogging.e(RXVideoCaptureAndroid.TAG, "onCapturerError: " + errorMsg);
            if (errorMsg.equals("CAMERA_ERROR_SERVER_DIED")) {
                RXNativeFunctions.nativeOnCapturerError(RXVideoCaptureAndroid.this.mNativeCaptureObserver, ErrorCode.ERROR_CODE_APP_ID_NULL);
            } else if (!errorMsg.equals("CAMERA_ERROR_EVICTED") && !errorMsg.equals("CAMERA_ERROR_UNKNOWN")) {
                RXNativeFunctions.nativeOnCapturerError(RXVideoCaptureAndroid.this.mNativeCaptureObserver, ErrorCode.ERROR_CODE_APP_ID_NULL);
            } else {
                RXNativeFunctions.nativeOnCapturerError(RXVideoCaptureAndroid.this.mNativeCaptureObserver, ErrorCode.ERROR_CODE_DUPLICATE_LOGIN);
            }
        }

        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onFrameCaptured(VideoFrame videoFrame) {
            RXNativeFunctions.nativeOnFrameCaptured(RXVideoCaptureAndroid.this.mNativeCaptureObserver, videoFrame);
        }
    };

    private boolean isCaptureToTextureSupported() {
        return true;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class BufferType {
        public static final int BYTE_BUFFER = 1;
        public static final int TEXTURE_BUFFER = 0;

        public BufferType() {
        }
    }

    RXVideoCaptureAndroid(boolean captureScreen, long nativeCaptureObserver, EglBase.Context ctx) {
        this.mIsCaptureScreen = false;
        this.sharedEglGroup = null;
        RXLogging.w(TAG, "RXVideoCaptureAndroid Created, CaptureScreen=" + captureScreen);
        this.mIsCaptureScreen = captureScreen;
        this.mNativeCaptureObserver = nativeCaptureObserver;
        this.sharedEglGroup = ctx;
    }

    public void startCapture(int width, int height, int frameRate, int captureBufferType, Intent intent, boolean faceae, int deviceUniqueId) {
        RXLogging.w(TAG, "startCapture...");
        this.mWidth = width;
        this.mHeight = height;
        this.mCaptureScreenIntent = intent;
        this.mCaptureBufferType = captureBufferType;
        if (ContextCompat.checkSelfPermission(ContextUtils.getApplicationContext(), "android.permission.CAMERA") != 0) {
            RXNativeFunctions.nativeOnCapturerError(this.mNativeCaptureObserver, -100);
            return;
        }
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null) {
            videoCapturer.dispose();
            this.mVideoCapturer = null;
            this.mIsVideoCaptureInited = false;
            this.mIsVideoCaptureWorking = false;
        }
        this.mVideoCapturer = createVideoCapturer(this.mIsCaptureScreen, this.mCaptureScreenIntent, deviceUniqueId);
        if (this.cameraEglBase == null) {
            this.cameraEglBase = EglBase.create(this.sharedEglGroup);
        }
        if (this.mVideoCapturer == null) {
            RXLogging.e(TAG, "mVideoCapturer is null...");
        }
        SurfaceTextureHelper create = SurfaceTextureHelper.create("RXLocalCapturer", this.cameraEglBase.getEglBaseContext());
        this.mSurfaceTextureHelper = create;
        if (this.mVideoCapturer != null && create != null) {
            create.setUsedByCamera(true);
            this.mVideoCapturer.initialize(this.mSurfaceTextureHelper, ContextUtils.getApplicationContext(), this.localCapturerObserver);
            this.mIsVideoCaptureInited = true;
            VideoCapturer videoCapturer2 = this.mVideoCapturer;
            if (videoCapturer2 instanceof Camera1Capturer) {
                ((Camera1Capturer) videoCapturer2).enableFaceAE(faceae);
            }
            startVideoCapture(width, height, frameRate);
            return;
        }
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
    }

    public void stopCapture() {
        RXLogging.w(TAG, "stopCapture...");
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            try {
                videoCapturer.stopCapture();
                this.mIsVideoCaptureWorking = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int enableFollowGravity(boolean enable) {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.enableFollowGravity(enable);
        }
        return 0;
    }

    public boolean isCameraTorchSupported() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.isCameraTorchSupported();
        }
        return false;
    }

    public void turnOnFlashLight() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            videoCapturer.turnOnFlashLight();
        }
    }

    public void turnOffFlashLight() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            videoCapturer.turnOffFlashLight();
        }
    }

    public boolean isCameraZoomSupported() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.isCameraZoomSupported();
        }
        return false;
    }

    public boolean isCameraFocusPointSupported() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.isCameraZoomSupported();
        }
        return false;
    }

    public int setCameraZoomRatio(float zoom) {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.setCameraZoomRatio(zoom);
        }
        return -1;
    }

    public float getCameraZoomMaxRatio() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.getCameraZoomMaxRatio();
        }
        return -1.0f;
    }

    public float setCameraFocusPoint(float x, float y) {
        if (this.mVideoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return r0.setCameraFocusPoint(x, y);
        }
        return -1.0f;
    }

    boolean isCameraExposurePointSupported() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.isCameraExposurePointSupported();
        }
        return false;
    }

    int setCameraExposurePoint(float x, float y) {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.setCameraExposurePoint(x, y);
        }
        return -1;
    }

    int setCameraExposureCompensation(float val) {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.setCameraExposureCompensation(val);
        }
        return -1;
    }

    int enableCameraAutoExposureFaceMode(boolean enable) {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.enableCameraAutoExposureFaceMode(enable);
        }
        return -1;
    }

    public void release() {
        if (this.mVideoCapturer != null) {
            stopCapture();
            this.mVideoCapturer.dispose();
            this.mVideoCapturer = null;
        }
        EglBase eglBase = this.cameraEglBase;
        if (eglBase != null) {
            eglBase.release();
            this.cameraEglBase = null;
        }
        SurfaceTextureHelper surfaceTextureHelper = this.mSurfaceTextureHelper;
        if (surfaceTextureHelper != null) {
            surfaceTextureHelper.dispose();
            this.mSurfaceTextureHelper = null;
        }
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
        this.sharedEglGroup = null;
        this.mCaptureScreenIntent = null;
    }

    public void switchCamera() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && (videoCapturer instanceof CameraVideoCapturer)) {
            this.mIsFrontCamera = !this.mIsFrontCamera;
            ((CameraVideoCapturer) videoCapturer).switchCamera(new CameraVideoCapturer.CameraSwitchHandler() { // from class: com.ss.bytertc.base.media.camera.RXVideoCaptureAndroid.2
                @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraSwitchHandler
                public void onCameraSwitchError(String errorDescription) {
                }

                @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraSwitchHandler
                public void onCameraSwitchDone(boolean isFrontFacing) {
                    RXVideoCaptureAndroid.this.mIsFrontCamera = isFrontFacing;
                }
            });
        }
    }

    public int getCameraFace() {
        return this.mIsFrontCamera ? 1 : 0;
    }

    int getUIOrientation() {
        int rotation = ((WindowManager) ContextUtils.getApplicationContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 90;
        }
        return 180;
    }

    int getDeviceOrientation() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            return videoCapturer.getDeviceOrientation();
        }
        return getUIOrientation();
    }

    static int[] getCameraSensorOrientations() {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras <= 0) {
            RXLogging.w(TAG, "getNumberOfCameras failed on count " + numberOfCameras);
            return null;
        }
        int[] iArr = new int[numberOfCameras];
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            try {
                Camera.getCameraInfo(i, cameraInfo);
                iArr[i] = cameraInfo.orientation;
            } catch (Exception e) {
                RXLogging.w(TAG, "getCameraInfo failed on index " + i + ',' + e.getMessage());
                return null;
            }
        }
        return iArr;
    }

    static boolean isFrontCamera(int index) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(index, cameraInfo);
            return cameraInfo.facing == 1;
        } catch (Exception e) {
            RXLogging.w(TAG, "getCameraInfo failed on index " + index + ',' + e.getMessage());
            return false;
        }
    }

    private VideoCapturer createVideoCapturer(boolean captureScreen, Intent mediaProjectionPermissionResultData, int deviceUniqueId) {
        CameraVideoCapturer createCapturer;
        try {
            if (captureScreen) {
                return new ScreenCapturerAndroid(mediaProjectionPermissionResultData, new MediaProjection.Callback() { // from class: com.ss.bytertc.base.media.camera.RXVideoCaptureAndroid.3
                    @Override // android.media.projection.MediaProjection.Callback
                    public void onStop() {
                        RXLogging.e(RXVideoCaptureAndroid.TAG, "User revoked permission to capture the screen.");
                    }
                });
            }
            boolean z = true;
            if (this.mCaptureBufferType == 1 || !isCaptureToTextureSupported()) {
                z = false;
            }
            Camera1Enumerator camera1Enumerator = new Camera1Enumerator(z, false);
            String[] deviceNames = camera1Enumerator.getDeviceNames();
            if (deviceNames.length > deviceUniqueId && deviceUniqueId >= 0 && (createCapturer = camera1Enumerator.createCapturer(deviceNames[deviceUniqueId], this.mCameraEventsHandler)) != null) {
                RXLogging.i(TAG, "createVideoCapturer, deviceUniqueId: " + deviceUniqueId);
                return createCapturer;
            }
            RXLogging.w(TAG, "enumerator camera but cannot find a match one, use default. deviceUniqueId: " + deviceUniqueId + ", deviceNames: " + deviceNames.length);
            if (deviceNames.length > 0) {
                String str = deviceNames[0];
                CameraVideoCapturer createCapturer2 = camera1Enumerator.createCapturer(str, this.mCameraEventsHandler);
                if (createCapturer2 != null) {
                    return createCapturer2;
                }
                RXLogging.e(TAG, "VideoCapturer first camera create null, name:" + str);
            } else {
                RXLogging.e(TAG, "num of camera in device is zero");
            }
            RXLogging.e(TAG, "cannot init VideoCapture: ");
            return null;
        } catch (IllegalArgumentException e) {
            RXLogging.e(TAG, "Create VideoCapture fail : " + e.getMessage());
            return null;
        }
    }

    private void startVideoCapture(int width, int height, int fps) {
        RXLogging.w(TAG, String.format("startVideoCapture: width: %d, height: &d, fps: &d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(fps)));
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null) {
            try {
                videoCapturer.startCapture(width, height, fps);
                this.mIsVideoCaptureWorking = true;
            } catch (IllegalArgumentException e) {
                RXLogging.e(TAG, "VideoCapture startCapture fail : " + e.getMessage());
            }
        }
    }
}
