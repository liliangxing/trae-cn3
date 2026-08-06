package com.ss.bytertc.base.media.camera;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.NV21Buffer;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.ss.android.update.UpdateEventUtils;
import com.ss.bytertc.base.media.Size;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoSink;
import com.ss.bytertc.base.media.camera.Camera1Session;
import com.ss.bytertc.base.media.camera.CameraEnumerationAndroid;
import com.ss.bytertc.base.media.camera.CameraSession;
import com.ss.bytertc.base.media.camera.CameraVideoCapturer;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class Camera1Session implements CameraSession, Camera.FaceDetectionListener {
    private static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
    private static final String TAG = "Camera1Session";
    private static int sMinFramerate;
    private final Context applicationContext;
    private final Camera camera;
    private final int cameraId;
    private final Handler cameraThreadHandler;
    private final CameraEnumerationAndroid.CaptureFormat captureFormat;
    private final boolean captureToTexture;
    private final long constructionTimeNs;
    private final CameraSession.Events events;
    private boolean firstFrameReported;
    private final Sensor gravitySensor;
    private final Camera.CameraInfo info;
    private boolean isDesktopMode;
    private int mDisplayRotationCheckCounter;
    private boolean mEnableFaceAE;
    private boolean mEnableFollowGravity;
    private boolean mFaceDetectStarted;
    private int mLastDisplayRotation;
    private int mLastValidDisplayRotation;
    private final int scaleHeight;
    private final int scaleWidth;
    private final SensorManager sensorManager;
    private SessionState state;
    private final SurfaceTextureHelper surfaceTextureHelper;
    private int gravityOrientation = 0;
    private final SensorEventListener gravityEventListener = new SensorEventListener() { // from class: com.ss.bytertc.base.media.camera.Camera1Session.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            float f = event.values[0];
            float f2 = event.values[1];
            float abs = Math.abs(f);
            float abs2 = Math.abs(f2);
            if (Math.abs(abs - abs2) < 4.0d) {
                return;
            }
            if (abs >= abs2) {
                if (f >= 0.0f) {
                    Camera1Session.this.gravityOrientation = CameraSession.UIDeviceOrientation.LandscapeRight.value();
                    return;
                } else {
                    Camera1Session.this.gravityOrientation = CameraSession.UIDeviceOrientation.LandscapeLeft.value();
                    return;
                }
            }
            if (f2 >= 0.0f) {
                Camera1Session.this.gravityOrientation = CameraSession.UIDeviceOrientation.Portrait.value();
            } else {
                Camera1Session.this.gravityOrientation = CameraSession.UIDeviceOrientation.PortraitUpsideDown.value();
            }
        }
    };
    private CameraVideoCapturer.ORIENTATION_MODE mOrientation = CameraVideoCapturer.ORIENTATION_MODE.ORIENTATION_MODE_ADAPTIVE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum SessionState {
        RUNNING,
        STOPPED
    }

    private int clamp(int x, int min, int max) {
        return x > max ? max : x < min ? min : x;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public int enableCameraAutoExposureFaceMode(boolean enable) {
        return 0;
    }

    public static void create(final CameraSession.CreateSessionCallback callback, final CameraSession.Events events, final boolean captureToTexture, final boolean isDesktopMode, final Context applicationContext, final SurfaceTextureHelper surfaceTextureHelper, final int cameraId, final int width, final int height, final int framerate, boolean faceae, boolean followGravity) {
        long nanoTime = System.nanoTime();
        RXLogging.w(TAG, "Open camera " + cameraId + " brand:" + Build.BRAND + ", modle:" + Build.MODEL + ", width:" + width + ", height:" + height + ", framerate:" + framerate + ", faceae:" + faceae + ", followGravity:" + followGravity + ", captureToTexture:" + captureToTexture);
        events.onCameraOpening();
        try {
            Camera open = Camera.open(cameraId);
            if (open == null) {
                callback.onFailure(CameraSession.FailureType.ERROR, "android.hardware.Camera.open returned null for camera id = " + cameraId);
                return;
            }
            try {
                open.setPreviewTexture(surfaceTextureHelper.getSurfaceTexture());
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(cameraId, cameraInfo);
                try {
                    Camera.Parameters parameters = open.getParameters();
                    CameraEnumerationAndroid.CaptureFormat findClosestCaptureFormat = findClosestCaptureFormat(parameters, width, height, framerate);
                    Size findClosestPictureSize = findClosestPictureSize(parameters, width, height);
                    events.onCameraConfig(findClosestPictureSize.width, findClosestPictureSize.height, findClosestCaptureFormat.framerate);
                    sMinFramerate = findClosestCaptureFormat.framerate.min / 1000;
                    updateCameraParameters(open, parameters, findClosestCaptureFormat, findClosestPictureSize, captureToTexture);
                    if (!captureToTexture) {
                        int frameSize = findClosestCaptureFormat.frameSize();
                        for (int i = 0; i < 3; i++) {
                            open.addCallbackBuffer(ByteBuffer.allocateDirect(frameSize).array());
                        }
                    }
                    try {
                        open.setDisplayOrientation(0);
                    } catch (RuntimeException unused) {
                        Log.w(TAG, "setDisplayOrientation failed");
                    }
                    callback.onDone(new Camera1Session(events, captureToTexture, isDesktopMode, applicationContext, surfaceTextureHelper, cameraId, open, cameraInfo, findClosestCaptureFormat, nanoTime, width, height, faceae, followGravity));
                } catch (RuntimeException e) {
                    open.release();
                    callback.onFailure(CameraSession.FailureType.ERROR, e.getMessage());
                }
            } catch (IOException | RuntimeException e2) {
                open.release();
                callback.onFailure(CameraSession.FailureType.ERROR, e2.getMessage());
            }
        } catch (RuntimeException e3) {
            callback.onFailure(CameraSession.FailureType.ERROR, e3.getMessage());
        }
    }

    private static void updateCameraParameters(Camera camera, Camera.Parameters parameters, CameraEnumerationAndroid.CaptureFormat captureFormat, Size pictureSize, boolean captureToTexture) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        parameters.setPreviewFpsRange(captureFormat.framerate.min, captureFormat.framerate.max);
        parameters.setPreviewSize(captureFormat.width, captureFormat.height);
        if (!Build.MODEL.equalsIgnoreCase("PEGM00") && !Build.MODEL.equalsIgnoreCase("PEGT00")) {
            parameters.setPictureSize(pictureSize.width, pictureSize.height);
        } else {
            Log.d(TAG, "updateCameraParameters: ignore pic size for model:" + Build.MODEL);
        }
        if (!captureToTexture) {
            Objects.requireNonNull(captureFormat);
            parameters.setPreviewFormat(17);
        }
        if (parameters.isVideoStabilizationSupported()) {
            parameters.setVideoStabilization(true);
        }
        RXLogging.w(TAG, "support FOCUS_MODE list: ");
        for (int i = 0; i < supportedFocusModes.size(); i++) {
            RXLogging.w(TAG, i + " : " + supportedFocusModes.get(i));
        }
        RXLogging.w(TAG, "start set FOCUS_MODE_CONTINUOUS_VIDEO");
        if (supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            RXLogging.w(TAG, "FOCUS_MODE_CONTINUOUS_VIDEO support and set success");
        }
        camera.setParameters(parameters);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public void setOrientationMode(CameraVideoCapturer.ORIENTATION_MODE orientation) {
        this.mOrientation = orientation;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public int enableFollowGravity(boolean enable) {
        SensorManager sensorManager;
        Sensor sensor = this.gravitySensor;
        if (sensor == null || (sensorManager = this.sensorManager) == null) {
            return -1;
        }
        try {
            if (enable) {
                sensorManager.registerListener(this.gravityEventListener, sensor, 2);
                this.mEnableFollowGravity = true;
            } else {
                sensorManager.unregisterListener(this.gravityEventListener);
                this.mEnableFollowGravity = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public int getDeviceOrientation() {
        if (!this.mEnableFollowGravity) {
            return CameraSession.getDeviceUIOrientation(ContextUtils.getApplicationContext());
        }
        return this.gravityOrientation;
    }

    private static CameraEnumerationAndroid.CaptureFormat findClosestCaptureFormat(Camera.Parameters parameters, int width, int height, int framerate) {
        CameraEnumerationAndroid.CaptureFormat.FramerateRange closestSupportedFramerateRange;
        if (parameters.getSupportedPreviewFpsRange() == null) {
            RXLogging.e(TAG, "camera parameters is null!");
            return null;
        }
        List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates = Camera1Enumerator.convertFramerates(parameters.getSupportedPreviewFpsRange());
        RXLogging.w(TAG, "Available fps ranges: " + convertFramerates);
        if (Build.MODEL.equalsIgnoreCase("PEGM00") && framerate == 15) {
            closestSupportedFramerateRange = new CameraEnumerationAndroid.CaptureFormat.FramerateRange(15000, 20000);
            RXLogging.w(TAG, "unsupported framerate for special device found, hardcode framerange to:" + closestSupportedFramerateRange.toString());
        } else {
            closestSupportedFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(convertFramerates, framerate);
        }
        RXLogging.w(TAG, "selected fps range :" + closestSupportedFramerateRange.toString());
        if (parameters == null) {
            RXLogging.e(TAG, "camera parameters is null!");
            return null;
        }
        List<Size> convertSizes = Camera1Enumerator.convertSizes(parameters.getSupportedPreviewSizes());
        RXLogging.w(TAG, "Available supportedPreviewSizes : " + convertSizes.toString());
        Size upClosestSupportedSize = CameraEnumerationAndroid.getUpClosestSupportedSize(convertSizes, width, height);
        RXLogging.w(TAG, "selected preview size" + upClosestSupportedSize.toString());
        return new CameraEnumerationAndroid.CaptureFormat(upClosestSupportedSize.width, upClosestSupportedSize.height, closestSupportedFramerateRange);
    }

    private static Size findClosestPictureSize(Camera.Parameters parameters, int width, int height) {
        if (parameters == null || parameters.getSupportedPictureSizes() == null) {
            RXLogging.e(TAG, "camera parameters is null!");
            return null;
        }
        return CameraEnumerationAndroid.getUpClosestSupportedSize(Camera1Enumerator.convertSizes(parameters.getSupportedPictureSizes()), width, height);
    }

    private Camera1Session(CameraSession.Events events, boolean captureToTexture, boolean isDesktopMode, Context applicationContext, SurfaceTextureHelper surfaceTextureHelper, int cameraId, Camera camera, Camera.CameraInfo info, CameraEnumerationAndroid.CaptureFormat captureFormat, long constructionTimeNs, int width, int height, boolean faceae, boolean followGravity) {
        this.mEnableFollowGravity = false;
        RXLogging.w(TAG, "Create new camera1 session on camera " + cameraId);
        this.cameraThreadHandler = new Handler();
        this.events = events;
        this.captureToTexture = captureToTexture;
        this.isDesktopMode = isDesktopMode;
        this.applicationContext = applicationContext;
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.cameraId = cameraId;
        this.camera = camera;
        this.info = info;
        this.captureFormat = captureFormat;
        this.constructionTimeNs = constructionTimeNs;
        this.scaleWidth = width;
        this.scaleHeight = height;
        this.mEnableFaceAE = faceae;
        SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
        this.sensorManager = sensorManager;
        this.gravitySensor = sensorManager.getDefaultSensor(9);
        this.mEnableFollowGravity = followGravity;
        surfaceTextureHelper.setTextureSize(captureFormat.width, captureFormat.height);
        startCapturing();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public void stop() {
        RXLogging.w(TAG, "Stop camera1 session on camera " + this.cameraId);
        checkIsOnCameraThread();
        if (this.state != SessionState.STOPPED) {
            long nanoTime = System.nanoTime();
            stopInternal();
            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        	at java.base/java.util.BitSet.or(BitSet.java:941)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public boolean isCameraTorchSupported() {
        /*
            r3 = this;
            r3.checkIsOnCameraThread()
            android.content.Context r0 = r3.applicationContext
            r1 = 0
            if (r0 == 0) goto L3e
            android.hardware.Camera r2 = r3.camera
            if (r2 != 0) goto Ld
            goto L3e
        Ld:
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L3e
            java.lang.String r2 = "android.hardware.camera.flash"
            boolean r0 = r0.hasSystemFeature(r2)     // Catch: java.lang.Exception -> L3e
            if (r0 != 0) goto L1a
            return r1
        L1a:
            android.hardware.Camera r0 = r3.camera     // Catch: java.lang.Exception -> L3e
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch: java.lang.Exception -> L3e
            java.util.List r0 = r0.getSupportedFlashModes()     // Catch: java.lang.Exception -> L3e
            if (r0 == 0) goto L3e
            boolean r2 = r0.isEmpty()     // Catch: java.lang.Exception -> L3e
            if (r2 != 0) goto L3e
            java.lang.String r2 = "torch"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Exception -> L3e
            if (r2 != 0) goto L3d
            java.lang.String r2 = "on"
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Exception -> L3e
            if (r0 == 0) goto L3e
        L3d:
            r1 = 1
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.bytertc.base.media.camera.Camera1Session.isCameraTorchSupported():boolean");
    }

    @Override // android.hardware.Camera.FaceDetectionListener
    public void onFaceDetection(Camera.Face[] faces, Camera camera) {
        Log.d(TAG, "onFaceDetection: face count=" + faces.length);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public void turnOnFlashLight() {
        RXLogging.w(TAG, "turn on flash light camera1, cameraId:" + this.cameraId);
        checkIsOnCameraThread();
        if (this.info.facing == 1) {
            RXLogging.w(TAG, "front camera not support flash light");
            return;
        }
        if (this.state != SessionState.STOPPED) {
            try {
                Camera camera = this.camera;
                if (camera == null) {
                    RXLogging.e(TAG, "Camera is null when trying to turn on flash light");
                    return;
                }
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFlashMode("torch");
                this.camera.setParameters(parameters);
                RXLogging.i(TAG, "Flash light turned on successfully");
            } catch (Exception e) {
                RXLogging.e(TAG, "Unexpected error when turning on flash light: " + e.getMessage(), e);
            }
        }
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public void turnOffFlashLight() {
        RXLogging.w(TAG, "turn on flash light camera1, cameraId:" + this.cameraId);
        checkIsOnCameraThread();
        if (this.info.facing == 1) {
            RXLogging.w(TAG, "front camera not support flash light");
            return;
        }
        if (this.state != SessionState.STOPPED) {
            try {
                Camera camera = this.camera;
                if (camera == null) {
                    RXLogging.e(TAG, "Camera is null when trying to turn off flash light");
                    return;
                }
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFlashMode("off");
                this.camera.setParameters(parameters);
                RXLogging.i(TAG, "Flash light turned off successfully");
            } catch (Exception e) {
                RXLogging.e(TAG, "Unexpected error when turning off flash light: " + e.getMessage(), e);
            }
        }
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public boolean isCameraZoomSupported() {
        checkIsOnCameraThread();
        if (this.state == SessionState.STOPPED) {
            return false;
        }
        Camera.Parameters parameters = this.camera.getParameters();
        return parameters.isZoomSupported() || parameters.isSmoothZoomSupported();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public boolean isCameraFocusPointSupported() {
        checkIsOnCameraThread();
        if (this.state != SessionState.STOPPED) {
            return isSupportedFocus(this.camera.getParameters());
        }
        return false;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public boolean isCameraExposurePointSupported() {
        checkIsOnCameraThread();
        if (this.state != SessionState.STOPPED) {
            return isSupportedMetering(this.camera.getParameters());
        }
        return false;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public int setCameraZoomRatio(float zoom) {
        RXLogging.w(TAG, "turn on flash light camera1, cameraId:" + this.cameraId);
        checkIsOnCameraThread();
        if (this.state != SessionState.STOPPED) {
            Camera.Parameters parameters = this.camera.getParameters();
            if (isCameraZoomSupported()) {
                int min = (int) Math.min(parameters.getMaxZoom(), zoom);
                if (parameters.isSmoothZoomSupported()) {
                    this.camera.startSmoothZoom(min);
                    return 0;
                }
                parameters.setZoom(min);
                this.camera.setParameters(parameters);
                return 0;
            }
        }
        return -1;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public int setCameraFocusPoint(float x, float y) {
        Camera camera;
        List<String> supportedFocusModes;
        String str;
        String str2;
        RXLogging.w(TAG, "set focus point, cameraId:" + this.cameraId + " x: " + x + " y: " + y);
        checkIsOnCameraThread();
        int i = -1;
        if (this.state != SessionState.STOPPED && (camera = this.camera) != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters == null || (supportedFocusModes = parameters.getSupportedFocusModes()) == null) {
                    return -1;
                }
                if (isSupportedMetering(parameters)) {
                    int i2 = this.scaleWidth;
                    int i3 = this.scaleHeight;
                    Rect calculateTapArea = calculateTapArea(i2, i3, 1.0f, 180.0f, (int) (i2 * x), (int) (i3 * y));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(calculateTapArea, 1000));
                    parameters.setMeteringAreas(arrayList);
                    i = 0;
                }
                if (!supportedFocusModes.contains(UpdateEventUtils.SOURCE_AUTO)) {
                    try {
                        this.camera.cancelAutoFocus();
                        try {
                            this.camera.setParameters(parameters);
                            try {
                                this.camera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.ss.bytertc.base.media.camera.Camera1Session.2
                                    @Override // android.hardware.Camera.AutoFocusCallback
                                    public void onAutoFocus(boolean success, Camera camera2) {
                                        RXLogging.i(Camera1Session.TAG, success ? "Camera Focus Succeed!" : "Camera Focus Failed!");
                                    }
                                });
                                return i;
                            } catch (RuntimeException e) {
                                RXLogging.e(TAG, "Failed to auto focus: " + e.getMessage(), e);
                                return i;
                            }
                        } catch (RuntimeException e2) {
                            RXLogging.e(TAG, "Failed to set parameters: " + e2.getMessage(), e2);
                            return i;
                        }
                    } catch (RuntimeException e3) {
                        RXLogging.e(TAG, "Failed to cancel auto focus: " + e3.getMessage(), e3);
                        return i;
                    }
                }
                if (isSupportedFocus(parameters)) {
                    int i4 = this.scaleWidth;
                    int i5 = this.scaleHeight;
                    str = "Failed to cancel auto focus: ";
                    str2 = "Failed to set parameters: ";
                    Rect calculateTapArea2 = calculateTapArea(i4, i5, 1.0f, 90.0f, (int) (i4 * x), (int) (i5 * y));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new Camera.Area(calculateTapArea2, 1000));
                    parameters.setFocusAreas(arrayList2);
                    i = 0;
                } else {
                    str = "Failed to cancel auto focus: ";
                    str2 = "Failed to set parameters: ";
                }
                try {
                    this.camera.cancelAutoFocus();
                    parameters.setFocusMode(UpdateEventUtils.SOURCE_AUTO);
                    try {
                        this.camera.setParameters(parameters);
                        try {
                            this.camera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.ss.bytertc.base.media.camera.Camera1Session.3
                                @Override // android.hardware.Camera.AutoFocusCallback
                                public void onAutoFocus(boolean success, Camera camera2) {
                                    RXLogging.i(Camera1Session.TAG, success ? "Camera Focus Succeed!" : "Camera Focus Failed!");
                                    try {
                                        Camera.Parameters parameters2 = camera2.getParameters();
                                        if (parameters2.getSupportedFocusModes().contains("continuous-video")) {
                                            parameters2.setFocusMode("continuous-video");
                                            RXLogging.w(Camera1Session.TAG, "FOCUS_MODE_CONTINUOUS_VIDEO support and set success");
                                            camera2.setParameters(parameters2);
                                        }
                                    } catch (Exception e4) {
                                        RXLogging.w(Camera1Session.TAG, "" + e4);
                                    }
                                }
                            });
                        } catch (RuntimeException e4) {
                            RXLogging.e(TAG, "Failed to auto focus: " + e4.getMessage(), e4);
                        }
                    } catch (RuntimeException e5) {
                        RXLogging.e(TAG, str2 + e5.getMessage(), e5);
                        return i;
                    }
                } catch (RuntimeException e6) {
                    RXLogging.e(TAG, str + e6.getMessage(), e6);
                    return i;
                }
            } catch (RuntimeException e7) {
                RXLogging.e(TAG, "Failed to get camera parameters: " + e7.getMessage(), e7);
            }
        }
        return i;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public int setCameraExposurePoint(float x, float y) {
        RXLogging.w(TAG, "set exposure point, cameraId:" + this.cameraId + " x: " + x + " y: " + y);
        checkIsOnCameraThread();
        int i = -1;
        if (this.state != SessionState.STOPPED) {
            Camera.Parameters parameters = this.camera.getParameters();
            if (isSupportedMetering(parameters)) {
                int i2 = this.scaleWidth;
                int i3 = this.scaleHeight;
                Rect calculateTapArea = calculateTapArea(i2, i3, 1.0f, 180.0f, (int) (i2 * x), (int) (i3 * y));
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(calculateTapArea, 1000));
                parameters.setMeteringAreas(arrayList);
                i = 0;
            }
            this.camera.setParameters(parameters);
        }
        return i;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public int setCameraExposureCompensation(float val) {
        if (val < -1.0f || val > 1.0f) {
            return -1;
        }
        checkIsOnCameraThread();
        if (this.state == SessionState.STOPPED) {
            return -1;
        }
        Camera.Parameters parameters = this.camera.getParameters();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        int minExposureCompensation = parameters.getMinExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        parameters.getExposureCompensation();
        if (maxExposureCompensation > minExposureCompensation && exposureCompensationStep > 0.001f) {
            RXLogging.w(TAG, "exposure compensation invalid, max:" + maxExposureCompensation + " min:" + minExposureCompensation + " step:" + exposureCompensationStep);
            return -1;
        }
        int ceil = val < 0.0f ? (int) Math.ceil(-Math.abs(minExposureCompensation * val)) : 0;
        if (val > 0.0f) {
            ceil = (int) Math.floor(Math.abs(maxExposureCompensation * val));
        }
        parameters.setExposureCompensation(ceil);
        this.camera.setParameters(parameters);
        RXLogging.w(TAG, "set exposure compensation ec:" + ceil + " val:" + val);
        return 0;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraSession
    public float getCameraZoomMaxRatio() {
        RXLogging.w(TAG, "turn on flash light camera1, cameraId:" + this.cameraId);
        checkIsOnCameraThread();
        if (this.state == SessionState.STOPPED || !isCameraZoomSupported()) {
            return 1.0f;
        }
        return this.camera.getParameters().getMaxZoom();
    }

    private void startCapturing() {
        RXLogging.w(TAG, "Start capturing");
        checkIsOnCameraThread();
        this.state = SessionState.RUNNING;
        this.camera.setErrorCallback(new Camera.ErrorCallback() { // from class: com.ss.bytertc.base.media.camera.Camera1Session.4
            @Override // android.hardware.Camera.ErrorCallback
            public void onError(int error, Camera camera) {
                String str;
                if (error == 100) {
                    str = "CAMERA_ERROR_SERVER_DIED";
                } else if (error == 2) {
                    str = "CAMERA_ERROR_EVICTED";
                } else {
                    str = error == 1 ? "CAMERA_ERROR_UNKNOWN" : "Camera error: " + error;
                }
                RXLogging.e(Camera1Session.TAG, str);
                Camera1Session.this.stopInternal();
                Camera1Session.this.events.onCameraError(Camera1Session.this, str);
            }
        });
        if (this.captureToTexture) {
            listenForTextureFrames();
        } else {
            listenForBytebufferFrames();
        }
        try {
            this.camera.startPreview();
            int maxNumDetectedFaces = this.camera.getParameters().getMaxNumDetectedFaces();
            RXLogging.i(TAG, "supportedFaces is " + maxNumDetectedFaces);
            boolean z = maxNumDetectedFaces > 0;
            if (this.mEnableFaceAE && z) {
                this.camera.setFaceDetectionListener(this);
                this.camera.startFaceDetection();
                this.mFaceDetectStarted = true;
            }
            if (this.mEnableFaceAE && !z) {
                RXLogging.w(TAG, "mEnableFaceAE is ture but camera not support faceae");
            }
            if (this.mEnableFollowGravity) {
                enableFollowGravity(true);
            }
        } catch (RuntimeException e) {
            stopInternal();
            this.events.onCameraError(this, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternal() {
        RXLogging.w(TAG, "Stop internal");
        checkIsOnCameraThread();
        if (this.state == SessionState.STOPPED) {
            RXLogging.w(TAG, "Camera is already stopped");
            return;
        }
        this.state = SessionState.STOPPED;
        this.surfaceTextureHelper.stopListening();
        try {
            if (this.mFaceDetectStarted) {
                this.camera.stopFaceDetection();
            }
            this.camera.stopPreview();
            if (this.mEnableFollowGravity) {
                enableFollowGravity(false);
            }
            if (this.captureToTexture) {
                this.camera.setPreviewTexture(null);
            }
            this.camera.release();
            this.events.onCameraClosed(this);
        } catch (Error e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        RXLogging.w(TAG, "Stop done");
    }

    private void listenForTextureFrames() {
        this.surfaceTextureHelper.startListening(new VideoSink() { // from class: com.ss.bytertc.base.media.camera.Camera1Session$$ExternalSyntheticLambda0
            @Override // com.ss.bytertc.base.media.VideoSink
            public final void onFrame(VideoFrame videoFrame) {
                Camera1Session.this.m185xda413406(videoFrame);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$listenForTextureFrames$0$com-ss-bytertc-base-media-camera-Camera1Session */
    public /* synthetic */ void m185xda413406(VideoFrame videoFrame) {
        VideoFrame.Buffer cropAndScale;
        int frameOrientation;
        checkIsOnCameraThread();
        if (this.state != SessionState.RUNNING) {
            RXLogging.w(TAG, "Texture frame captured but camera is no longer running.");
            return;
        }
        if (!this.firstFrameReported) {
            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.constructionTimeNs);
            this.firstFrameReported = true;
        }
        if (this.scaleWidth == 0 || this.scaleHeight == 0 || (this.captureFormat.width == this.scaleWidth && this.captureFormat.height == this.scaleHeight)) {
            if (this.scaleHeight != 0) {
                cropAndScale = videoFrame.getBuffer().cropAndScale(0, 0, (int) ((this.scaleWidth / this.scaleHeight) * this.captureFormat.height), this.captureFormat.height, this.scaleWidth, this.scaleHeight);
            } else {
                RXLogging.e(TAG, "scaleHeight is 0");
                return;
            }
        } else if (this.captureFormat.width / this.captureFormat.height > this.scaleWidth / this.scaleHeight) {
            cropAndScale = videoFrame.getBuffer().cropAndScale(((int) (this.captureFormat.width - ((this.scaleWidth / this.scaleHeight) * this.captureFormat.height))) / 2, 0, (int) ((this.scaleWidth / this.scaleHeight) * this.captureFormat.height), this.captureFormat.height, this.scaleWidth, this.scaleHeight);
        } else {
            cropAndScale = videoFrame.getBuffer().cropAndScale(0, ((int) (this.captureFormat.height - ((this.scaleHeight / this.scaleWidth) * this.captureFormat.width))) / 2, this.captureFormat.width, (int) ((this.scaleHeight / this.scaleWidth) * this.captureFormat.width), this.scaleWidth, this.scaleHeight);
        }
        if (cropAndScale == null) {
            RXLogging.e(TAG, "cropandscale return null buffer");
            return;
        }
        if (this.mEnableFollowGravity) {
            frameOrientation = getGravityOrientation();
        } else {
            frameOrientation = getFrameOrientation();
            this.gravityOrientation = CameraSession.getDeviceUIOrientation(this.applicationContext);
        }
        VideoFrame videoFrame2 = new VideoFrame(CameraSession.createTextureBufferWithModifiedTransformMatrix((TextureBufferImpl) cropAndScale, false, 0), frameOrientation, videoFrame.getTimestampNs(), false);
        cropAndScale.release();
        this.events.onFrameCaptured(this, videoFrame2);
        videoFrame2.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.bytertc.base.media.camera.Camera1Session$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C08255 implements Camera.PreviewCallback {
        C08255() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] data, Camera callbackCamera) {
            int frameOrientation;
            Camera1Session.this.checkIsOnCameraThread();
            if (callbackCamera == Camera1Session.this.camera) {
                if (Camera1Session.this.state != SessionState.RUNNING) {
                    RXLogging.w(Camera1Session.TAG, "Bytebuffer frame captured but camera is no longer running.");
                    return;
                }
                long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
                if (!Camera1Session.this.firstFrameReported) {
                    TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - Camera1Session.this.constructionTimeNs);
                    Camera1Session.this.firstFrameReported = true;
                }
                NV21Buffer nV21Buffer = new NV21Buffer(data, Camera1Session.this.captureFormat.width, Camera1Session.this.captureFormat.height, new Runnable() { // from class: com.ss.bytertc.base.media.camera.Camera1Session$5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Camera1Session.C08255.this.m187x83a7b41d(data);
                    }
                });
                if (Camera1Session.this.mEnableFollowGravity) {
                    frameOrientation = Camera1Session.this.getGravityOrientation();
                } else {
                    frameOrientation = Camera1Session.this.getFrameOrientation();
                    Camera1Session camera1Session = Camera1Session.this;
                    camera1Session.gravityOrientation = CameraSession.getDeviceUIOrientation(camera1Session.applicationContext);
                }
                VideoFrame videoFrame = new VideoFrame(nV21Buffer, frameOrientation, nanos, Camera1Session.this.info.facing == 1);
                Camera1Session.this.events.onFrameCaptured(Camera1Session.this, videoFrame);
                videoFrame.release();
                return;
            }
            RXLogging.e(Camera1Session.TAG, "Callback from a different camera. This should never happen.");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPreviewFrame$1$com-ss-bytertc-base-media-camera-Camera1Session$5 */
        public /* synthetic */ void m187x83a7b41d(final byte[] bArr) {
            Camera1Session.this.cameraThreadHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.camera.Camera1Session$5$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Camera1Session.C08255.this.m186x401c965c(bArr);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPreviewFrame$0$com-ss-bytertc-base-media-camera-Camera1Session$5 */
        public /* synthetic */ void m186x401c965c(byte[] bArr) {
            if (Camera1Session.this.state == SessionState.RUNNING) {
                Camera1Session.this.camera.addCallbackBuffer(bArr);
            }
        }
    }

    private void listenForBytebufferFrames() {
        this.camera.setPreviewCallbackWithBuffer(new C08255());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getGravityOrientation() {
        int i = this.gravityOrientation;
        if (this.info.facing == 1) {
            i = 360 - i;
        }
        return (this.info.orientation + i) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrameOrientation() {
        int deviceUIOrientation = CameraSession.getDeviceUIOrientation(this.applicationContext);
        int i = this.mLastValidDisplayRotation;
        int i2 = this.mDisplayRotationCheckCounter;
        if (i2 > 0) {
            this.mDisplayRotationCheckCounter = i2 - 1;
        } else if (i2 == 0) {
            i = !isInForeground(this.applicationContext) ? this.mLastValidDisplayRotation : deviceUIOrientation;
            this.mDisplayRotationCheckCounter = -1;
        } else if (deviceUIOrientation != this.mLastDisplayRotation) {
            int i3 = sMinFramerate;
            if (i3 > 0) {
                this.mDisplayRotationCheckCounter = i3;
            } else {
                this.mDisplayRotationCheckCounter = 5;
            }
        }
        this.mLastDisplayRotation = deviceUIOrientation;
        this.mLastValidDisplayRotation = i;
        if (this.info.facing != 0) {
            i = 360 - i;
        }
        return (this.info.orientation + i) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
    }

    private static boolean isInForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(RXScreenCaptureService.KEY_LAUNCH_ACTIVITY);
        String packageName = context.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if ((runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) || runningAppProcessInfo.importance == 125) {
                return true;
            }
        }
        return false;
    }

    private boolean isSupportedFocus(Camera.Parameters parameters) {
        return parameters != null && parameters.getMaxNumFocusAreas() > 0;
    }

    private boolean isSupportedMetering(Camera.Parameters parameters) {
        return parameters != null && parameters.getMaxNumMeteringAreas() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIsOnCameraThread() {
        if (Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread()) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    private Rect calculateTapArea(final int viewWidth, final int viewHeight, final float displayDensity, final float radius, final int x, final int y) {
        int i = ((int) (((x * 2000) * 1.0f) / viewWidth)) - 1000;
        int intValue = Float.valueOf((displayDensity * radius) + 0.5f).intValue() / 2;
        RectF rectF = new RectF(clamp(i - intValue, -1000, 1000), clamp((((int) (((y * 2000) * 1.0f) / viewHeight)) - 1000) - intValue, -1000, 1000), clamp(r3 + r5, -1000, 1000), clamp(r4 + r5, -1000, 1000));
        Rect rect = new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        Rect rect2 = new Rect(rect.left, rect.top, rect.right, rect.bottom);
        rect2.left = clamp(rect2.left, -1000, 1000);
        rect2.right = clamp(rect2.right, -1000, 1000);
        rect2.top = clamp(rect2.top, -1000, 1000);
        rect2.bottom = clamp(rect2.bottom, -1000, 1000);
        return rect2;
    }
}
