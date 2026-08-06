package com.ss.bytertc.base.media.screen;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.base.media.VideoSink;
import com.ss.bytertc.base.media.camera.CameraSession;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ScreenCaptureAndroidManager implements VideoCapturer, VideoSink {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_MIN_FRAME_RATE = 4;
    private static final int DISPLAY_FLAGS = 11;
    private static final String TAG = "ScreenCapture";
    private static final int VIRTUAL_DISPLAY_DPI = 400;
    private static final String VIRTUAL_DISPLAY_NAME = "RTCScreenCapture";
    private CapturerObserver capturerObserver;
    private int frameRate;
    private int height;
    private boolean isDisposed;
    private boolean isSurfaceDispose;
    private Context mContext;
    private DeviceOrientation mCurrentOrientation;
    private Display mDisplay;
    private boolean mEnableDoOrientation;
    private int mFrameIndex;
    private Map<Integer, CountDownLatch> mLocks;
    private boolean mPicoCapture2DTexture;
    private boolean mPicoCreateMediaProjection;
    private boolean mPicoNotCheckOrientation;
    private int mPicoVirtualDisplayDpi;
    private int mPicoVirtualDisplayFlag;
    private String mPicoVirtualDisplayName;
    private EglBase.Context mSharedContext;
    private Map<Integer, VideoFrame> mVideoFrames;
    private MediaProjection mediaProjection;
    private MediaProjection.Callback mediaProjectionCallback;
    private MediaProjectionManager mediaProjectionManager;
    private Intent mediaProjectionPermissionResultData;
    private long numCapturedFrames;
    private SurfaceTextureHelper surfaceTextureHelper;
    private VirtualDisplay virtualDisplay;
    private int width;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum DeviceOrientation {
        PORTRAIT,
        LANDSCAPE
    }

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

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static final class HOLDER {
        private static final ScreenCaptureAndroidManager INSTANCE = new ScreenCaptureAndroidManager();

        private HOLDER() {
        }
    }

    public static ScreenCaptureAndroidManager INSTANCE() {
        return HOLDER.INSTANCE;
    }

    private ScreenCaptureAndroidManager() {
        this.mFrameIndex = 0;
        this.mEnableDoOrientation = true;
        this.mPicoNotCheckOrientation = false;
        this.mPicoCreateMediaProjection = false;
        this.mPicoVirtualDisplayName = VIRTUAL_DISPLAY_NAME;
        this.mPicoVirtualDisplayDpi = 400;
        this.mPicoVirtualDisplayFlag = 11;
        this.mPicoCapture2DTexture = false;
        this.mVideoFrames = new HashMap();
        this.mLocks = new HashMap();
    }

    public void setData(Intent mediaProjectionPermissionResultData, MediaProjection.Callback mediaProjectionCallback) {
        this.isDisposed = false;
        this.mediaProjectionPermissionResultData = mediaProjectionPermissionResultData;
        this.mediaProjectionCallback = mediaProjectionCallback;
        this.mPicoNotCheckOrientation = mediaProjectionPermissionResultData.getBooleanExtra(RXScreenCaptureService.KEY_PICO_NOT_CHECK_ORIENTATION, false);
        this.mPicoCreateMediaProjection = mediaProjectionPermissionResultData.getBooleanExtra(RXScreenCaptureService.KEY_PICO_CREATE_MEDIA_PROJECTION, false);
        this.mPicoVirtualDisplayName = mediaProjectionPermissionResultData.getStringExtra(RXScreenCaptureService.KEY_PICO_VIRTUAL_DISPLAY_NAME);
        this.mPicoVirtualDisplayDpi = mediaProjectionPermissionResultData.getIntExtra(RXScreenCaptureService.KEY_PICO_VIRTUAL_DISPLAY_DPI, 400);
        this.mPicoVirtualDisplayFlag = mediaProjectionPermissionResultData.getIntExtra(RXScreenCaptureService.KEY_PICO_VIRTUAL_DISPLAY_FLAG, 11);
        this.mPicoCapture2DTexture = mediaProjectionPermissionResultData.getBooleanExtra(RXScreenCaptureService.KEY_PICO_NEED_CAPTURE_2D_TEXTURE, false);
    }

    private void checkNotDisposed() {
        if (this.isDisposed) {
            throw new RuntimeException("capturer is disposed.");
        }
    }

    public void addLock(int hashCode, CountDownLatch latch) {
        this.mLocks.put(Integer.valueOf(hashCode), latch);
    }

    public MediaProjection getMediaProjection() {
        return this.mediaProjection;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void initialize(final SurfaceTextureHelper surfaceTextureHelper, final Context applicationContext, final CapturerObserver capturerObserver) {
        checkNotDisposed();
        if (capturerObserver == null) {
            throw new RuntimeException("capturerObserver not set.");
        }
        this.capturerObserver = capturerObserver;
        if (surfaceTextureHelper == null) {
            if (capturerObserver != null) {
                capturerObserver.onCapturerError("surfaceTextureHelper not set.");
            }
            throw new RuntimeException("surfaceTextureHelper not set.");
        }
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.isSurfaceDispose = false;
        this.mCurrentOrientation = null;
        this.frameRate = 4;
        this.mContext = applicationContext;
        this.mediaProjectionManager = (MediaProjectionManager) applicationContext.getSystemService("media_projection");
        this.mDisplay = ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay();
    }

    public synchronized void initialize(final EglBase.Context sharedContext, final Context applicationContext, final CapturerObserver capturerObserver) {
        checkNotDisposed();
        if (capturerObserver == null) {
            throw new RuntimeException("capturerObserver not set.");
        }
        this.capturerObserver = capturerObserver;
        SurfaceTextureHelper create = SurfaceTextureHelper.create("RXLocalCapturer", sharedContext, false, this.mPicoCapture2DTexture);
        this.surfaceTextureHelper = create;
        this.isSurfaceDispose = true;
        this.mCurrentOrientation = null;
        if (create == null) {
            if (capturerObserver != null) {
                capturerObserver.onCapturerError("surfaceTextureHelper is null.");
            }
            throw new RuntimeException("surfaceTextureHelper is null.");
        }
        this.frameRate = 4;
        this.mSharedContext = sharedContext;
        this.mContext = applicationContext;
        this.mediaProjectionManager = (MediaProjectionManager) applicationContext.getSystemService("media_projection");
        this.mDisplay = ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(final int width, final int height, final int ignoredFramerate, final int min_framerate) {
        checkNotDisposed();
        RXLogging.w(TAG, String.format("[ScreenCapture] call |startCapture|,  width=%d, height=%d", Integer.valueOf(width), Integer.valueOf(height)));
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mDisplay.getRealMetrics(displayMetrics);
            this.width = displayMetrics.widthPixels;
            this.height = displayMetrics.heightPixels;
            RXLogging.w(TAG, String.format("[ScreenCapture] call |startCapture| , get screen real size, width=%d, height=%d", Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)));
        }
        maybeDoRotation();
        try {
            this.mediaProjection = this.mediaProjectionManager.getMediaProjection(-1, this.mediaProjectionPermissionResultData);
        } catch (Exception e) {
            Log.w("startCapture", "mediaProjectionManager.getMediaProjection failed", e);
            this.mediaProjection = null;
        }
        if (this.mediaProjection == null && this.mPicoCreateMediaProjection) {
            Log.i("startCapture", "mediaProjection is null, try to use pico private interface on pico os platform");
            try {
                this.mediaProjection = (MediaProjection) MediaProjectionManager.class.getMethod(RXScreenCaptureService.METHOD_PICO_CREATE_MEDIA_PROJECTION, new Class[0]).invoke(this.mediaProjectionManager, new Object[0]);
            } catch (Exception e2) {
                Log.w("startCapture", "mediaProjection is null, use pico private interface failed", e2);
                this.mediaProjection = null;
            }
        }
        MediaProjection mediaProjection = this.mediaProjection;
        if (mediaProjection == null) {
            CapturerObserver capturerObserver = this.capturerObserver;
            if (capturerObserver != null) {
                capturerObserver.onCapturerError("no permission to capture the screen video.");
            }
            return;
        }
        mediaProjection.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());
        createVirtualDisplay();
        this.capturerObserver.onCapturerStarted(true);
        SurfaceTextureHelper surfaceTextureHelper = this.surfaceTextureHelper;
        if (min_framerate <= 0) {
            min_framerate = 4;
        }
        surfaceTextureHelper.setMinFps(min_framerate);
        this.surfaceTextureHelper.startListening(this);
    }

    public synchronized void startCapture(final int width, final int height, final int ignoredFramerate, final int min_framerate, MediaProjection projection) {
        checkNotDisposed();
        RXLogging.w(TAG, String.format("[ScreenCapture] call |startCapture|,  width=%d, height=%d", Integer.valueOf(width), Integer.valueOf(height)));
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mDisplay.getRealMetrics(displayMetrics);
            this.width = displayMetrics.widthPixels;
            this.height = displayMetrics.heightPixels;
            RXLogging.w(TAG, String.format("[ScreenCapture] call |startCapture with MediaProjection| , get screen real size, width=%d, height=%d", Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)));
        }
        maybeDoRotation();
        this.mediaProjection = projection;
        if (projection == null) {
            CapturerObserver capturerObserver = this.capturerObserver;
            if (capturerObserver != null) {
                capturerObserver.onCapturerError("no permission to capture the screen video.");
            }
            return;
        }
        projection.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());
        createVirtualDisplay();
        this.capturerObserver.onCapturerStarted(true);
        if (min_framerate <= 0) {
            min_framerate = 4;
        }
        this.frameRate = min_framerate;
        this.surfaceTextureHelper.setMinFps(min_framerate);
        this.surfaceTextureHelper.startListening(this);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(final int width, final int height, final int ignoredFramerate) {
        startCapture(width, height, ignoredFramerate, 4);
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void stopCapture() {
        checkNotDisposed();
        ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable() { // from class: com.ss.bytertc.base.media.screen.ScreenCaptureAndroidManager.1
            @Override // java.lang.Runnable
            public void run() {
                ScreenCaptureAndroidManager.this.surfaceTextureHelper.stopListening();
                ScreenCaptureAndroidManager.this.capturerObserver.onCapturerStopped();
                if (ScreenCaptureAndroidManager.this.virtualDisplay != null) {
                    ScreenCaptureAndroidManager.this.virtualDisplay.release();
                    ScreenCaptureAndroidManager.this.virtualDisplay = null;
                }
                if (ScreenCaptureAndroidManager.this.mediaProjection != null) {
                    ScreenCaptureAndroidManager.this.mediaProjection.unregisterCallback(ScreenCaptureAndroidManager.this.mediaProjectionCallback);
                    ScreenCaptureAndroidManager.this.mediaProjection = null;
                }
                ScreenCaptureAndroidManager.this.mCurrentOrientation = null;
            }
        });
    }

    public synchronized void dispose(int hashCode) {
        CountDownLatch remove = this.mLocks.remove(Integer.valueOf(hashCode));
        if (remove != null) {
            remove.countDown();
            Log.i("ScreenCaptureAndroid", "stopCapture countDown finish");
        }
        dispose();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void dispose() {
        SurfaceTextureHelper surfaceTextureHelper;
        this.isDisposed = true;
        if (this.isSurfaceDispose && (surfaceTextureHelper = this.surfaceTextureHelper) != null) {
            surfaceTextureHelper.dispose();
            this.surfaceTextureHelper = null;
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void changeCaptureFormat(final int width, final int height, final int ignoredFramerate) {
        checkNotDisposed();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mDisplay.getRealMetrics(displayMetrics);
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        if (width == this.width && height == this.height) {
            RXLogging.w(TAG, "[ScreenCapture] call |changeCaptureFormat|, width & height are same as previous, ignore the request");
            return;
        }
        this.width = width;
        this.height = height;
        if (this.virtualDisplay == null) {
            return;
        }
        ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable() { // from class: com.ss.bytertc.base.media.screen.ScreenCaptureAndroidManager.2
            @Override // java.lang.Runnable
            public void run() {
                ScreenCaptureAndroidManager.this.mCurrentOrientation = null;
                ScreenCaptureAndroidManager.this.createVirtualDisplay();
            }
        });
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int getDeviceOrientation() {
        return CameraSession.getDeviceUIOrientation(ContextUtils.getApplicationContext());
    }

    private boolean updateVirtualDisplayConfig() {
        RXLogging.w(TAG, String.format("[ScreenCapture] updateVirtualDisplayConfig width=%d, height=%d", Integer.valueOf(this.width), Integer.valueOf(this.height)));
        if (Build.VERSION.SDK_INT < 34) {
            RXLogging.w(TAG, String.format("[ScreenCapture] recreate virtual display for android version:%d", Integer.valueOf(Build.VERSION.SDK_INT)));
            return false;
        }
        if (this.mediaProjection == null) {
            RXLogging.e(TAG, "updateVirtualDisplayConfig failed, mediaProjection is null");
            return false;
        }
        if (this.virtualDisplay == null) {
            RXLogging.e(TAG, "updateVirtualDisplayConfig failed, virtualDisplay is null");
            return false;
        }
        SurfaceTextureHelper surfaceTextureHelper = this.surfaceTextureHelper;
        if (surfaceTextureHelper != null) {
            surfaceTextureHelper.stopListening();
            this.surfaceTextureHelper.dispose();
            this.surfaceTextureHelper = null;
        }
        int i = this.mPicoVirtualDisplayName != null ? this.mPicoVirtualDisplayDpi : 400;
        this.virtualDisplay.setSurface(null);
        this.virtualDisplay.resize(this.width, this.height, i);
        SurfaceTextureHelper create = SurfaceTextureHelper.create("RXLocalCapturer", this.mSharedContext, false, this.mPicoCapture2DTexture);
        this.surfaceTextureHelper = create;
        if (create == null) {
            CapturerObserver capturerObserver = this.capturerObserver;
            if (capturerObserver != null) {
                capturerObserver.onCapturerError("surfaceTextureHelper is null.");
            }
            throw new RuntimeException("surfaceTextureHelper is null.");
        }
        create.setTextureSize(this.width, this.height);
        this.surfaceTextureHelper.setMinFps(this.frameRate);
        this.virtualDisplay.setSurface(new Surface(this.surfaceTextureHelper.getSurfaceTexture()));
        this.surfaceTextureHelper.startListening(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createVirtualDisplay() {
        CapturerObserver capturerObserver;
        if (updateVirtualDisplayConfig()) {
            RXLogging.w(TAG, String.format("[ScreenCapture] call updateVirtualDisplayConfig success, width=%d, height=%d", Integer.valueOf(this.width), Integer.valueOf(this.height)));
            return;
        }
        if (this.mediaProjection == null) {
            RXLogging.e(TAG, "createVirtualDisplay failed, mediaProjection is null");
            return;
        }
        if (this.virtualDisplay != null) {
            RXLogging.e(TAG, "[ScreenCapture] release current virtualdisplay");
            this.virtualDisplay.release();
            this.virtualDisplay = null;
        }
        this.surfaceTextureHelper.setTextureSize(this.width, this.height);
        try {
            RXLogging.w(TAG, String.format("[ScreenCapture] call |createVirtualDisplay|,  width=%d, height=%d", Integer.valueOf(this.width), Integer.valueOf(this.height)));
            String str = this.mPicoVirtualDisplayName;
            if (str != null) {
                this.virtualDisplay = this.mediaProjection.createVirtualDisplay(str, this.width, this.height, this.mPicoVirtualDisplayDpi, this.mPicoVirtualDisplayFlag, new Surface(this.surfaceTextureHelper.getSurfaceTexture()), null, null);
            } else {
                this.virtualDisplay = this.mediaProjection.createVirtualDisplay(VIRTUAL_DISPLAY_NAME, this.width, this.height, 400, 11, new Surface(this.surfaceTextureHelper.getSurfaceTexture()), null, null);
            }
            if (this.virtualDisplay != null || (capturerObserver = this.capturerObserver) == null) {
                return;
            }
            capturerObserver.onCapturerError("create virtual display failed.");
        } catch (SecurityException unused) {
            this.virtualDisplay = null;
            Log.i("ScreenCaptureAndroid", "Invalid media projection, no permission");
            CapturerObserver capturerObserver2 = this.capturerObserver;
            if (capturerObserver2 != null) {
                capturerObserver2.onCapturerError("create virtual display failed.");
            }
        }
    }

    @Override // com.ss.bytertc.base.media.VideoSink
    public void onFrame(VideoFrame frame) {
        if (!this.mPicoNotCheckOrientation && maybeDoRotation()) {
            createVirtualDisplay();
        } else {
            this.numCapturedFrames++;
            this.capturerObserver.onFrameCaptured(frame);
        }
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void disableDoOrientation() {
        RXLogging.w(TAG, "[ScreenCapture] call |disableDoOrientation|");
        this.mEnableDoOrientation = false;
    }

    public long getNumCapturedFrames() {
        return this.numCapturedFrames;
    }

    public int addFrame(VideoFrame frame) {
        int i = this.mFrameIndex;
        this.mVideoFrames.put(Integer.valueOf(i), frame);
        this.mFrameIndex++;
        return i;
    }

    public VideoFrame removeFrame(int index) {
        if (this.mVideoFrames.containsKey(Integer.valueOf(index))) {
            return this.mVideoFrames.remove(Integer.valueOf(index));
        }
        return null;
    }

    private int getDeviceRotation() {
        int rotation = this.mDisplay.getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation == 2) {
            return 180;
        }
        if (rotation != 3) {
            return 0;
        }
        return MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
    }

    private DeviceOrientation getDeviceOrientation(int rotation) {
        if (rotation != 0) {
            if (rotation != 90) {
                if (rotation != 180) {
                    if (rotation != 270) {
                        return DeviceOrientation.LANDSCAPE;
                    }
                }
            }
            return DeviceOrientation.LANDSCAPE;
        }
        return DeviceOrientation.PORTRAIT;
    }

    private DeviceOrientation getDisplayOrientation() {
        if (this.mContext.getResources().getConfiguration().orientation == 1) {
            return DeviceOrientation.PORTRAIT;
        }
        return DeviceOrientation.LANDSCAPE;
    }

    private boolean maybeDoRotation() {
        int deviceRotation = getDeviceRotation();
        DeviceOrientation deviceOrientation = getDeviceOrientation(deviceRotation);
        DeviceOrientation displayOrientation = getDisplayOrientation();
        if (displayOrientation == this.mCurrentOrientation) {
            return false;
        }
        this.mCurrentOrientation = displayOrientation;
        if (!this.mEnableDoOrientation) {
            RXLogging.w(TAG, "[ScreenCapture] DoRotation is disabled, ignore the request");
            return false;
        }
        RXLogging.w(TAG, String.format("[ScreenCapture] call |maybeDoRotation| and orientation != mCurrentOrientation, rotation:%d, orientation:%s, orientation1:%s", Integer.valueOf(deviceRotation), displayOrientation.toString(), deviceOrientation.toString()));
        rotateCaptureOrientation(displayOrientation);
        return true;
    }

    private void rotateCaptureOrientation(DeviceOrientation orientation) {
        if ((orientation != DeviceOrientation.LANDSCAPE || this.width >= this.height) && (orientation != DeviceOrientation.PORTRAIT || this.height >= this.width)) {
            return;
        }
        RXLogging.w(TAG, String.format("[ScreenCapture] call |rotateCaptureOrientation| before(orientation:%s, width:%d, height:%d)", orientation.toString(), Integer.valueOf(this.width), Integer.valueOf(this.height)));
        int i = this.width;
        int i2 = this.height;
        this.height = i;
        this.width = i + (i2 - i);
        RXLogging.w(TAG, String.format("[ScreenCapture] call |rotateCaptureOrientation| after(orientation:%s, width:%d, height:%d)", orientation.toString(), Integer.valueOf(this.width), Integer.valueOf(this.height)));
    }
}
