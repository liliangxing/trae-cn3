package com.ss.bytertc.base.media.camera;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.camera.CameraEnumerationAndroid;
import com.ss.bytertc.base.media.camera.CameraSession;
import com.ss.bytertc.base.media.camera.CameraVideoCapturer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class CameraCapturer implements CameraVideoCapturer {
    private static final int MAX_OPEN_CAMERA_ATTEMPTS = 3;
    private static final int OPEN_CAMERA_DELAY_MS = 500;
    private static final int OPEN_CAMERA_TIMEOUT = 10000;
    private static final String TAG = "CameraCapturer";
    private Context applicationContext;
    private final CameraEnumerator cameraEnumerator;
    private String cameraName;
    private CameraVideoCapturer.CameraStatistics cameraStatistics;
    private Handler cameraThreadHandler;
    private CapturerObserver capturerObserver;
    private CameraSession currentSession;
    private final CameraVideoCapturer.CameraEventsHandler eventsHandler;
    private boolean firstFrameObserved;
    private int framerate;
    private int height;
    private int openAttemptsRemaining;
    private boolean sessionOpening;
    private SurfaceTextureHelper surfaceHelper;
    private CameraVideoCapturer.CameraSwitchHandler switchEventsHandler;
    private final Handler uiThreadHandler;
    private int width;
    private CameraVideoCapturer.ORIENTATION_MODE mOrientationMode = CameraVideoCapturer.ORIENTATION_MODE.ORIENTATION_MODE_ADAPTIVE;
    private final CameraSession.CreateSessionCallback createSessionCallback = new CameraSession.CreateSessionCallback() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer.1
        @Override // com.ss.bytertc.base.media.camera.CameraSession.CreateSessionCallback
        public void onDone(CameraSession session) {
            CameraCapturer.this.checkIsOnCameraThread();
            CameraCapturer.this.uiThreadHandler.removeCallbacks(CameraCapturer.this.openCameraTimeoutRunnable);
            synchronized (CameraCapturer.this.stateLock) {
                RXLogging.w(CameraCapturer.TAG, "Create session done. Switch state: " + CameraCapturer.this.switchState);
                if (session != null) {
                    session.setOrientationMode(CameraCapturer.this.mOrientationMode);
                }
                CameraCapturer.this.capturerObserver.onCapturerStarted(true);
                CameraCapturer.this.sessionOpening = false;
                CameraCapturer.this.currentSession = session;
                CameraCapturer.this.cameraStatistics = new CameraVideoCapturer.CameraStatistics(CameraCapturer.this.surfaceHelper, CameraCapturer.this.eventsHandler);
                CameraCapturer.this.firstFrameObserved = false;
                CameraCapturer.this.stateLock.notifyAll();
                if (CameraCapturer.this.switchState != SwitchState.IN_PROGRESS) {
                    if (CameraCapturer.this.switchState == SwitchState.PENDING) {
                        CameraCapturer.this.switchState = SwitchState.IDLE;
                        CameraCapturer cameraCapturer = CameraCapturer.this;
                        cameraCapturer.switchCameraInternal(cameraCapturer.switchEventsHandler);
                    }
                } else {
                    CameraCapturer.this.switchState = SwitchState.IDLE;
                    if (CameraCapturer.this.switchEventsHandler != null) {
                        CameraCapturer.this.switchEventsHandler.onCameraSwitchDone(CameraCapturer.this.cameraEnumerator.isFrontFacing(CameraCapturer.this.cameraName));
                        CameraCapturer.this.switchEventsHandler = null;
                    }
                }
            }
        }

        @Override // com.ss.bytertc.base.media.camera.CameraSession.CreateSessionCallback
        public void onFailure(CameraSession.FailureType failureType, String error) {
            CameraCapturer.this.checkIsOnCameraThread();
            CameraCapturer.this.uiThreadHandler.removeCallbacks(CameraCapturer.this.openCameraTimeoutRunnable);
            synchronized (CameraCapturer.this.stateLock) {
                CameraCapturer.this.capturerObserver.onCapturerStarted(false);
                CameraCapturer.access$1710(CameraCapturer.this);
                if (CameraCapturer.this.openAttemptsRemaining <= 0) {
                    RXLogging.e(CameraCapturer.TAG, "Opening camera failed, passing: " + error);
                    CameraCapturer.this.sessionOpening = false;
                    CameraCapturer.this.stateLock.notifyAll();
                    if (CameraCapturer.this.switchState != SwitchState.IDLE) {
                        if (CameraCapturer.this.switchEventsHandler != null) {
                            CameraCapturer.this.switchEventsHandler.onCameraSwitchError(error);
                            CameraCapturer.this.switchEventsHandler = null;
                        }
                        CameraCapturer.this.switchState = SwitchState.IDLE;
                    }
                    if (failureType == CameraSession.FailureType.DISCONNECTED) {
                        CameraCapturer.this.eventsHandler.onCameraDisconnected();
                    } else {
                        CameraCapturer.this.eventsHandler.onCameraError(error);
                    }
                } else {
                    RXLogging.e(CameraCapturer.TAG, "Opening camera failed, retry: " + error);
                    CameraCapturer.this.createSessionInternal(500);
                }
            }
        }
    };
    private final CameraSession.Events cameraSessionEventsHandler = new CameraSession.Events() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer.2
        @Override // com.ss.bytertc.base.media.camera.CameraSession.Events
        public void onCameraOpening() {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (CameraCapturer.this.currentSession == null) {
                    CameraCapturer.this.eventsHandler.onCameraOpening(CameraCapturer.this.cameraName);
                } else {
                    RXLogging.e(CameraCapturer.TAG, "onCameraOpening while session was open.");
                }
            }
        }

        @Override // com.ss.bytertc.base.media.camera.CameraSession.Events
        public void onCameraError(CameraSession session, String error) {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (session == CameraCapturer.this.currentSession) {
                    CameraCapturer.this.eventsHandler.onCameraError(error);
                    CameraCapturer.this.capturerObserver.onCapturerError(error);
                    CameraCapturer.this.stopCapture();
                    return;
                }
                RXLogging.e(CameraCapturer.TAG, "onCameraError from another session: " + error);
            }
        }

        @Override // com.ss.bytertc.base.media.camera.CameraSession.Events
        public void onCameraDisconnected(CameraSession session) {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (session == CameraCapturer.this.currentSession) {
                    CameraCapturer.this.eventsHandler.onCameraDisconnected();
                    CameraCapturer.this.capturerObserver.onCapturerError("CameraDisconnected");
                    CameraCapturer.this.stopCapture();
                    return;
                }
                RXLogging.e(CameraCapturer.TAG, "onCameraDisconnected from another session.");
            }
        }

        @Override // com.ss.bytertc.base.media.camera.CameraSession.Events
        public void onCameraClosed(CameraSession session) {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (session == CameraCapturer.this.currentSession || CameraCapturer.this.currentSession == null) {
                    CameraCapturer.this.eventsHandler.onCameraClosed();
                } else {
                    RXLogging.e(CameraCapturer.TAG, "onCameraClosed from another session.");
                }
            }
        }

        @Override // com.ss.bytertc.base.media.camera.CameraSession.Events
        public void onFrameCaptured(CameraSession session, VideoFrame frame) {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                if (session == CameraCapturer.this.currentSession) {
                    if (!CameraCapturer.this.firstFrameObserved) {
                        CameraCapturer.this.eventsHandler.onFirstFrameAvailable();
                        CameraCapturer.this.firstFrameObserved = true;
                    }
                    if (CameraCapturer.this.cameraStatistics != null) {
                        CameraCapturer.this.cameraStatistics.addFrame();
                    }
                    CameraCapturer.this.capturerObserver.onFrameCaptured(frame);
                    return;
                }
                RXLogging.e(CameraCapturer.TAG, "onFrameCaptured from another session.");
            }
        }

        @Override // com.ss.bytertc.base.media.camera.CameraSession.Events
        public void onCameraConfig(int width, int height, CameraEnumerationAndroid.CaptureFormat.FramerateRange framerateRange) {
            CameraCapturer.this.checkIsOnCameraThread();
            synchronized (CameraCapturer.this.stateLock) {
                CameraCapturer.this.eventsHandler.onCameraConfig(width, height, framerateRange);
                CameraCapturer.this.capturerObserver.onCapturerFormatSelected(width, height, framerateRange.min / 1000, framerateRange.max / 1000, RXPixelFormat.kUnknown.value());
            }
        }
    };
    private final Runnable openCameraTimeoutRunnable = new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer.3
        @Override // java.lang.Runnable
        public void run() {
            CameraCapturer.this.eventsHandler.onCameraError("Camera failed to start within timeout.");
        }
    };
    private final Object stateLock = new Object();
    private SwitchState switchState = SwitchState.IDLE;
    private String nativeLibraryName = "bytertc";
    protected boolean mEnableFollowGravity = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum SwitchState {
        IDLE,
        PENDING,
        IN_PROGRESS
    }

    protected abstract void createCameraSession(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context applicationContext, SurfaceTextureHelper surfaceTextureHelper, String cameraName, int width, int height, int framerate);

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void disableDoOrientation() {
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    static /* synthetic */ int access$1710(CameraCapturer cameraCapturer) {
        int i = cameraCapturer.openAttemptsRemaining;
        cameraCapturer.openAttemptsRemaining = i - 1;
        return i;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer
    public void setOrientationMode(CameraVideoCapturer.ORIENTATION_MODE orientationMode) {
        this.mOrientationMode = orientationMode;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraTorchSupported() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m195x48db900f(atomicBoolean);
            }
        });
        return atomicBoolean.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isCameraTorchSupported$0$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m195x48db900f(AtomicBoolean atomicBoolean) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            atomicBoolean.set(cameraSession.isCameraTorchSupported());
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOnFlashLight() {
        this.cameraThreadHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m202xdc05f611();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$turnOnFlashLight$1$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m202xdc05f611() {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            cameraSession.turnOnFlashLight();
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOffFlashLight() {
        this.cameraThreadHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m201x595e2f2e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$turnOffFlashLight$2$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m201x595e2f2e() {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            cameraSession.turnOffFlashLight();
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraZoomSupported() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m196xba443fc3(atomicBoolean);
            }
        });
        return atomicBoolean.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isCameraZoomSupported$3$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m196xba443fc3(AtomicBoolean atomicBoolean) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            atomicBoolean.set(cameraSession.isCameraZoomSupported());
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraZoomRatio(final float zoom_val) {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m200x21ad2d43(zoom_val, atomicInteger);
            }
        });
        return atomicInteger.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setCameraZoomRatio$4$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m200x21ad2d43(float f, AtomicInteger atomicInteger) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            cameraSession.setCameraZoomRatio(f);
            atomicInteger.set(0);
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraFocusPoint(final float x, final float y) {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m199x9b909178(x, y, atomicInteger);
            }
        });
        return atomicInteger.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setCameraFocusPoint$5$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m199x9b909178(float f, float f2, AtomicInteger atomicInteger) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            cameraSession.setCameraFocusPoint(f, f2);
            atomicInteger.set(0);
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposurePoint(final float x, final float y) {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m198x33e9fcd6(x, y, atomicInteger);
            }
        });
        return atomicInteger.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setCameraExposurePoint$6$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m198x33e9fcd6(float f, float f2, AtomicInteger atomicInteger) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            cameraSession.setCameraExposurePoint(f, f2);
            atomicInteger.set(0);
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraFocusPointSupported() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m194x70c65de2(atomicBoolean);
            }
        });
        return atomicBoolean.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isCameraFocusPointSupported$7$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m194x70c65de2(AtomicBoolean atomicBoolean) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            atomicBoolean.set(cameraSession.isCameraFocusPointSupported());
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraExposurePointSupported() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m193x5be50f2a(atomicBoolean);
            }
        });
        return atomicBoolean.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isCameraExposurePointSupported$8$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m193x5be50f2a(AtomicBoolean atomicBoolean) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            atomicBoolean.set(cameraSession.isCameraExposurePointSupported());
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposureCompensation(final float val) {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m197x12f5ac25(atomicInteger, val);
            }
        });
        return atomicInteger.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setCameraExposureCompensation$9$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m197x12f5ac25(AtomicInteger atomicInteger, float f) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            atomicInteger.set(cameraSession.setCameraExposureCompensation(f));
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableCameraAutoExposureFaceMode(final boolean enable) {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m189x784f428d(atomicInteger, enable);
            }
        });
        return atomicInteger.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$enableCameraAutoExposureFaceMode$10$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m189x784f428d(AtomicInteger atomicInteger, boolean z) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            atomicInteger.set(cameraSession.enableCameraAutoExposureFaceMode(z));
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public float getCameraZoomMaxRatio() {
        final AtomicReference atomicReference = new AtomicReference(Float.valueOf(1.0f));
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m191xfeddf251(atomicReference);
            }
        });
        return ((Float) atomicReference.get()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getCameraZoomMaxRatio$11$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m191xfeddf251(AtomicReference atomicReference) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            atomicReference.set(Float.valueOf(cameraSession.getCameraZoomMaxRatio()));
        }
    }

    public CameraCapturer(String cameraName, CameraVideoCapturer.CameraEventsHandler eventsHandler, CameraEnumerator cameraEnumerator) {
        this.eventsHandler = eventsHandler == null ? new CameraVideoCapturer.CameraEventsHandler() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer.4
            @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraEventsHandler
            public void onCameraError(String errorDescription) {
                RXLogging.e(CameraCapturer.TAG, "CameraEventsHandler onCameraError: " + errorDescription);
            }

            @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraEventsHandler
            public void onCameraDisconnected() {
                RXLogging.e(CameraCapturer.TAG, "CameraEventsHandler onCameraDisconnected");
            }

            @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraEventsHandler
            public void onCameraFreezed(String errorDescription) {
                RXLogging.e(CameraCapturer.TAG, "CameraEventsHandler onCameraFreezed: " + errorDescription);
            }

            @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraEventsHandler
            public void onCameraOpening(String cameraName2) {
                RXLogging.w(CameraCapturer.TAG, "CameraEventsHandler onCameraOpening" + cameraName2);
            }

            @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraEventsHandler
            public void onFirstFrameAvailable() {
                RXLogging.w(CameraCapturer.TAG, "CameraEventsHandler onFirstFrameAvailable");
            }

            @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraEventsHandler
            public void onCameraClosed() {
                RXLogging.w(CameraCapturer.TAG, "CameraEventsHandler onCameraClosed");
            }

            @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraEventsHandler
            public void onCameraConfig(int width, int height, CameraEnumerationAndroid.CaptureFormat.FramerateRange framerateRange) {
                RXLogging.w(CameraCapturer.TAG, "CameraEventsHandler onCameraClosed");
            }
        } : eventsHandler;
        this.cameraEnumerator = cameraEnumerator;
        this.cameraName = cameraName;
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        if (deviceNames.length == 0) {
            throw new RuntimeException("No cameras attached.");
        }
        if (!Arrays.asList(deviceNames).contains(this.cameraName)) {
            throw new IllegalArgumentException("Camera name " + this.cameraName + " does not match any known camera device.");
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context applicationContext, CapturerObserver capturerObserver) {
        this.applicationContext = applicationContext;
        synchronized (this.stateLock) {
            this.capturerObserver = capturerObserver;
        }
        this.surfaceHelper = surfaceTextureHelper;
        this.cameraThreadHandler = surfaceTextureHelper == null ? null : surfaceTextureHelper.getHandler();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void startCapture(int width, int height, int framerate, int min_framerate) {
        startCapture(width, height, framerate);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void startCapture(int width, int height, int framerate) {
        RXLogging.w(TAG, "startCapture: " + width + "x" + height + "@" + framerate);
        if (this.applicationContext == null) {
            throw new RuntimeException("CameraCapturer must be initialized before calling startCapture.");
        }
        synchronized (this.stateLock) {
            if (!this.sessionOpening && this.currentSession == null) {
                this.width = width;
                this.height = height;
                this.framerate = framerate;
                this.sessionOpening = true;
                this.openAttemptsRemaining = 3;
                createSessionInternal(0);
                return;
            }
            RXLogging.w(TAG, "Session already open");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSessionInternal(int delayMs) {
        this.uiThreadHandler.postDelayed(this.openCameraTimeoutRunnable, delayMs + 10000);
        Handler handler = this.cameraThreadHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (CameraCapturer.this.stateLock) {
                        CameraCapturer cameraCapturer = CameraCapturer.this;
                        cameraCapturer.createCameraSession(cameraCapturer.createSessionCallback, CameraCapturer.this.cameraSessionEventsHandler, CameraCapturer.this.applicationContext, CameraCapturer.this.surfaceHelper, CameraCapturer.this.cameraName, CameraCapturer.this.width, CameraCapturer.this.height, CameraCapturer.this.framerate);
                    }
                } catch (IllegalArgumentException e) {
                    if (CameraCapturer.this.capturerObserver != null) {
                        CameraCapturer.this.capturerObserver.onCapturerError("Create VideoCapture Session fail : " + e.getMessage());
                    }
                }
            }
        }, delayMs);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void stopCapture() {
        RXLogging.w(TAG, "Stop capture");
        synchronized (this.stateLock) {
            while (this.sessionOpening) {
                RXLogging.w(TAG, "Stop capture: Waiting for session to open");
                try {
                    this.stateLock.wait();
                } catch (InterruptedException unused) {
                    RXLogging.e(TAG, "Stop capture interrupted while waiting for the session to open.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (this.currentSession != null) {
                RXLogging.w(TAG, "Stop capture: Nulling session");
                CameraVideoCapturer.CameraStatistics cameraStatistics = this.cameraStatistics;
                if (cameraStatistics != null) {
                    cameraStatistics.release();
                    this.cameraStatistics = null;
                }
                final CameraSession cameraSession = this.currentSession;
                this.cameraThreadHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer.6
                    @Override // java.lang.Runnable
                    public void run() {
                        cameraSession.stop();
                    }
                });
                this.currentSession = null;
                this.capturerObserver.onCapturerStopped();
            } else {
                RXLogging.w(TAG, "Stop capture: No session open");
            }
        }
        RXLogging.w(TAG, "Stop capture done");
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void changeCaptureFormat(int width, int height, int framerate) {
        RXLogging.w(TAG, "changeCaptureFormat: " + width + "x" + height + "@" + framerate);
        synchronized (this.stateLock) {
            stopCapture();
            startCapture(width, height, framerate);
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void dispose() {
        RXLogging.w(TAG, "dispose");
        stopCapture();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraVideoCapturer
    public void switchCamera(final CameraVideoCapturer.CameraSwitchHandler switchEventsHandler) {
        RXLogging.w(TAG, "switchCamera");
        Handler handler = this.cameraThreadHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer.7
                @Override // java.lang.Runnable
                public void run() {
                    CameraCapturer.this.switchCameraInternal(switchEventsHandler);
                }
            });
        }
    }

    public void printStackTrace() {
        Handler handler = this.cameraThreadHandler;
        Thread thread = handler != null ? handler.getLooper().getThread() : null;
        if (thread != null) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace.length > 0) {
                RXLogging.w(TAG, "CameraCapturer stack trace:");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    RXLogging.w(TAG, stackTraceElement.toString());
                }
            }
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableFollowGravity(final boolean enable) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m190x6be8aa8d(enable, atomicInteger);
            }
        });
        int i = atomicInteger.get();
        if (i == 0) {
            this.mEnableFollowGravity = enable;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$enableFollowGravity$12$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m190x6be8aa8d(boolean z, AtomicInteger atomicInteger) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            atomicInteger.set(cameraSession.enableFollowGravity(z));
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int getDeviceOrientation() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        ThreadUtils.invokeAtFrontUninterruptibly(this.cameraThreadHandler, new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                CameraCapturer.this.m192xbe0a14aa(atomicInteger);
            }
        });
        return atomicInteger.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDeviceOrientation$13$com-ss-bytertc-base-media-camera-CameraCapturer */
    public /* synthetic */ void m192xbe0a14aa(AtomicInteger atomicInteger) {
        CameraSession cameraSession = this.currentSession;
        if (cameraSession != null) {
            atomicInteger.set(cameraSession.getDeviceOrientation());
        }
    }

    private void reportCameraSwitchError(String error, CameraVideoCapturer.CameraSwitchHandler switchEventsHandler) {
        RXLogging.e(TAG, error);
        if (switchEventsHandler != null) {
            switchEventsHandler.onCameraSwitchError(error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchCameraInternal(final CameraVideoCapturer.CameraSwitchHandler switchEventsHandler) {
        RXLogging.w(TAG, "switchCamera internal");
        String[] deviceNames = this.cameraEnumerator.getDeviceNames();
        if (deviceNames.length < 2) {
            if (switchEventsHandler != null) {
                switchEventsHandler.onCameraSwitchError("No camera to switch to.");
                return;
            }
            return;
        }
        synchronized (this.stateLock) {
            if (this.switchState != SwitchState.IDLE) {
                reportCameraSwitchError("Camera switch already in progress.", switchEventsHandler);
                return;
            }
            boolean z = this.sessionOpening;
            if (!z && this.currentSession == null) {
                reportCameraSwitchError("switchCamera: camera is not running.", switchEventsHandler);
                return;
            }
            this.switchEventsHandler = switchEventsHandler;
            if (z) {
                this.switchState = SwitchState.PENDING;
                return;
            }
            this.switchState = SwitchState.IN_PROGRESS;
            RXLogging.w(TAG, "switchCamera: Stopping session");
            CameraVideoCapturer.CameraStatistics cameraStatistics = this.cameraStatistics;
            if (cameraStatistics != null) {
                cameraStatistics.release();
                this.cameraStatistics = null;
            }
            final CameraSession cameraSession = this.currentSession;
            Handler handler = this.cameraThreadHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraCapturer.8
                    @Override // java.lang.Runnable
                    public void run() {
                        cameraSession.stop();
                    }
                });
            }
            this.currentSession = null;
            this.cameraName = deviceNames[(Arrays.asList(deviceNames).indexOf(this.cameraName) + 1) % deviceNames.length];
            this.sessionOpening = true;
            this.openAttemptsRemaining = 1;
            createSessionInternal(0);
            RXLogging.w(TAG, "switchCamera done");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIsOnCameraThread() {
        if (this.cameraThreadHandler == null || Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread()) {
            RXLogging.e(TAG, "Check is on camera thread failed.");
            throw new RuntimeException("Not on camera thread.");
        }
    }

    protected String getCameraName() {
        String str;
        synchronized (this.stateLock) {
            str = this.cameraName;
        }
        return str;
    }
}
