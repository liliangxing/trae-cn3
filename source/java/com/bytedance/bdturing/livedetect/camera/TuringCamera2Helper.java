package com.bytedance.bdturing.livedetect.camera;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Size;
import android.view.OrientationEventListener;
import android.view.Surface;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.livedetect.view.AutoFixTextureView;
import com.bytedance.forest.model.Timing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringCamera2Helper {
    private static final int MAX_PREVIEW_HEIGHT = 1080;
    private static final int MAX_PREVIEW_WIDTH = 1920;
    private static final int PREVIEW_HEIGHT = 640;
    private static final int PREVIEW_WIDTH = 480;
    private static final String TAG = "TuringCamera2Helper";
    private Activity mActivity;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private CameraDevice mCameraDevice;
    private CameraFrameDataCallBack mCameraFrameDataCallBack;
    private CameraFrameDataReader mCameraFrameDataReader;
    private String mCameraId;
    private CaptureRequest.Builder mCaptureRequestBuilder;
    private CameraCaptureSession mCaptureSession;
    private ImageReader mImageReader;
    private OrientationEventListener mOrientationListener;
    private Size mPreviewSize;
    private int mSensorOrientation;
    private AutoFixTextureView mTextureView;
    private final CameraDevice.StateCallback mDeviceStateCallback = new CameraDevice.StateCallback() { // from class: com.bytedance.bdturing.livedetect.camera.TuringCamera2Helper.2
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            LogUtil.m160d(TuringCamera2Helper.TAG, "====>Camera onOpened");
            CameraStateMonitor.getInstance().recordCameraState("onOpened", null);
            TuringCamera2Helper.this.mCameraDevice = cameraDevice;
            TuringCamera2Helper.this.createCameraPreviewSession();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            super.onClosed(cameraDevice);
            CameraStateMonitor.getInstance().recordCameraState("onClosed", null);
            LogUtil.m160d(TuringCamera2Helper.TAG, "====>Camera onClosed");
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            LogUtil.m160d(TuringCamera2Helper.TAG, "====>Camera onDisconnected");
            CameraStateMonitor.getInstance().recordCameraState("onDisconnected", null);
            TuringCamera2Helper.this.mCameraDevice = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            TuringCamera2Helper.this.mCameraDevice = null;
            CameraStateMonitor.getInstance().recordCameraState("onError", null);
            TuringCamera2Helper.this.noticeException(CameraErrorCode.ERROR_CODE_CAMERA_IN_USE, new IllegalStateException("camera onError:error_code=" + i));
        }
    };
    private CameraCaptureSession.StateCallback mCaptureStateCallBack = new CameraCaptureSession.StateCallback() { // from class: com.bytedance.bdturing.livedetect.camera.TuringCamera2Helper.3
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            if (TuringCamera2Helper.this.mCameraDevice == null) {
                return;
            }
            TuringCamera2Helper.this.mCaptureSession = cameraCaptureSession;
            try {
                TuringCamera2Helper.this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                TuringCamera2Helper.this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 2);
                TuringCamera2Helper.this.mCaptureSession.setRepeatingRequest(TuringCamera2Helper.this.mCaptureRequestBuilder.build(), new CameraCaptureSession.CaptureCallback() { // from class: com.bytedance.bdturing.livedetect.camera.TuringCamera2Helper.3.1
                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession2, CaptureRequest captureRequest, long j, long j2) {
                        if (TuringCamera2Helper.this.mOrientationHelper != null) {
                            TuringCamera2Helper.this.mOrientationHelper.computeRotateDegree();
                        }
                    }

                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession2, CaptureRequest captureRequest, CaptureFailure captureFailure) {
                        CameraStateMonitor.getInstance().recordCameraState("onCaptureFailed", "captureFailed: reason=" + captureFailure.getReason() + ":" + captureFailure);
                        TuringCamera2Helper.this.noticeException(CameraErrorCode.ERROR_CODE_CAMERA_CONFIG_ERROR, new IllegalStateException("captureFailed: reason=" + captureFailure.getReason() + ":" + captureFailure.toString()));
                    }
                }, TuringCamera2Helper.this.mBackgroundHandler);
            } catch (Exception e) {
                e.printStackTrace();
                TuringCamera2Helper.this.noticeException(CameraErrorCode.ERROR_CODE_CAMERA_CONFIG_ERROR, e);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            CameraStateMonitor.getInstance().recordCameraState("onConfigureFailed", "CameraCaptureSession:" + cameraCaptureSession);
            TuringCamera2Helper.this.noticeException(CameraErrorCode.ERROR_CODE_CAMERA_CONFIG_ERROR, new IllegalStateException("camera configureFailed:"));
        }
    };
    private final OrientationHelper mOrientationHelper = new OrientationHelper();

    public TuringCamera2Helper(Activity activity, AutoFixTextureView autoFixTextureView) {
        this.mActivity = activity;
        this.mTextureView = autoFixTextureView;
        registerOrientationListener(activity);
    }

    private void registerOrientationListener(Activity activity) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(activity) { // from class: com.bytedance.bdturing.livedetect.camera.TuringCamera2Helper.1
            private int mScreenOrientation;

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                int i2 = 0;
                if ((i < 0 || i > 45) && i <= 315) {
                    if (i > 45 && i <= 135) {
                        i2 = 90;
                    } else if (i > 135 && i <= 225) {
                        i2 = 180;
                    } else if (i > 225 && i <= 315) {
                        i2 = 270;
                    }
                }
                if (i2 != this.mScreenOrientation) {
                    this.mScreenOrientation = i2;
                    TuringCamera2Helper.this.mOrientationHelper.setScreenOrientation(this.mScreenOrientation);
                }
            }
        };
        this.mOrientationListener = orientationEventListener;
        orientationEventListener.enable();
    }

    public void setCamaraFrameDataCallBack(CameraFrameDataCallBack cameraFrameDataCallBack) {
        this.mCameraFrameDataCallBack = cameraFrameDataCallBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCameraPreviewSession() {
        try {
            SurfaceTexture surfaceTexture = this.mTextureView.getSurfaceTexture();
            surfaceTexture.setDefaultBufferSize(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight());
            Surface surface = new Surface(surfaceTexture);
            CaptureRequest.Builder createCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
            this.mCaptureRequestBuilder = createCaptureRequest;
            createCaptureRequest.addTarget(surface);
            this.mCaptureRequestBuilder.addTarget(this.mImageReader.getSurface());
            this.mCameraDevice.createCaptureSession(Arrays.asList(surface, this.mImageReader.getSurface()), this.mCaptureStateCallBack, this.mBackgroundHandler);
        } catch (Exception e) {
            e.printStackTrace();
            noticeException(CameraErrorCode.ERROR_CODE_CREATE_SESSION, e);
        }
    }

    private void openCameraInner(int i, int i2) {
        CameraStateMonitor.getInstance().clearEvent();
        CameraStateMonitor.getInstance().recordCameraState("openCameraInner", "start");
        this.mOrientationListener.enable();
        CameraManager cameraManager = (CameraManager) this.mActivity.getSystemService("camera");
        try {
            setUpCameraOutputs(i, i2);
            this.mImageReader = ImageReader.newInstance(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight(), 35, 2);
            CameraFrameDataReader cameraFrameDataReader = this.mCameraFrameDataReader;
            if (cameraFrameDataReader != null) {
                cameraFrameDataReader.release();
            }
            startBackGroundThread();
            CameraFrameDataReader cameraFrameDataReader2 = new CameraFrameDataReader(this.mCameraFrameDataCallBack, this.mOrientationHelper);
            this.mCameraFrameDataReader = cameraFrameDataReader2;
            this.mImageReader.setOnImageAvailableListener(cameraFrameDataReader2, this.mBackgroundHandler);
            if (TextUtils.isEmpty(this.mCameraId)) {
                throw new IllegalStateException("no available camera");
            }
            cameraManager.openCamera(this.mCameraId, this.mDeviceStateCallback, this.mBackgroundHandler);
            CameraStateMonitor.getInstance().recordCameraState("openCameraInner", Timing.SUFFIX_FINISH);
        } catch (Exception e) {
            e.printStackTrace();
            noticeException(CameraErrorCode.ERROR_CODE_CAMARA_OPEN_FAILED, e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
    
        if (r1 != 270) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b8 A[Catch: Exception -> 0x0137, TryCatch #0 {Exception -> 0x0137, blocks: (B:3:0x000a, B:5:0x0014, B:7:0x0024, B:10:0x002a, B:56:0x0037, B:12:0x003d, B:14:0x0047, B:21:0x0075, B:22:0x00a0, B:24:0x00b8, B:31:0x00cf, B:33:0x0102, B:36:0x0114, B:41:0x008c, B:47:0x0095, B:51:0x0126, B:52:0x012e, B:53:0x012f, B:54:0x0136), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0102 A[Catch: Exception -> 0x0137, TryCatch #0 {Exception -> 0x0137, blocks: (B:3:0x000a, B:5:0x0014, B:7:0x0024, B:10:0x002a, B:56:0x0037, B:12:0x003d, B:14:0x0047, B:21:0x0075, B:22:0x00a0, B:24:0x00b8, B:31:0x00cf, B:33:0x0102, B:36:0x0114, B:41:0x008c, B:47:0x0095, B:51:0x0126, B:52:0x012e, B:53:0x012f, B:54:0x0136), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0114 A[Catch: Exception -> 0x0137, TryCatch #0 {Exception -> 0x0137, blocks: (B:3:0x000a, B:5:0x0014, B:7:0x0024, B:10:0x002a, B:56:0x0037, B:12:0x003d, B:14:0x0047, B:21:0x0075, B:22:0x00a0, B:24:0x00b8, B:31:0x00cf, B:33:0x0102, B:36:0x0114, B:41:0x008c, B:47:0x0095, B:51:0x0126, B:52:0x012e, B:53:0x012f, B:54:0x0136), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setUpCameraOutputs(int i, int i2) {
        int i3;
        int i4;
        CameraManager cameraManager = (CameraManager) this.mActivity.getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            int length = cameraIdList.length;
            boolean z = false;
            CameraCharacteristics cameraCharacteristics = null;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                String str = cameraIdList[i5];
                CameraCharacteristics cameraCharacteristics2 = cameraManager.getCameraCharacteristics(str);
                Integer num = (Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING);
                if (num != null && num.intValue() == 0) {
                    this.mCameraId = str;
                    this.mOrientationHelper.setCameraFacing(num.intValue());
                    cameraCharacteristics = cameraCharacteristics2;
                    break;
                }
                i5++;
                cameraCharacteristics = cameraCharacteristics2;
            }
            if (cameraCharacteristics != null) {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    throw new IllegalStateException("streamCfgMap is null");
                }
                int rotation = this.mActivity.getWindowManager().getDefaultDisplay().getRotation();
                int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                this.mSensorOrientation = intValue;
                this.mOrientationHelper.setCameraSensorOrientation(intValue);
                if (rotation != 0) {
                    if (rotation != 1) {
                        if (rotation != 2) {
                            if (rotation != 3) {
                                LogUtil.m161e(TAG, "Display rotation is invalid: " + rotation);
                                Point point = new Point();
                                this.mActivity.getWindowManager().getDefaultDisplay().getSize(point);
                                int i6 = point.x;
                                int i7 = point.y;
                                if (z) {
                                    i3 = i;
                                    i4 = i2;
                                } else {
                                    i6 = point.y;
                                    i7 = point.x;
                                    i4 = i;
                                    i3 = i2;
                                }
                                this.mPreviewSize = chooseOptimalSize(streamConfigurationMap.getOutputSizes(SurfaceTexture.class), i3, i4, i6 <= MAX_PREVIEW_WIDTH ? MAX_PREVIEW_WIDTH : i6, i7 <= MAX_PREVIEW_HEIGHT ? MAX_PREVIEW_HEIGHT : i7);
                                LogUtil.m160d(TAG, "====>mPreviewSize:" + this.mPreviewSize);
                                if (this.mActivity.getResources().getConfiguration().orientation != 2) {
                                    this.mTextureView.setAspectRatio(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight());
                                    return;
                                } else {
                                    this.mTextureView.setAspectRatio(this.mPreviewSize.getHeight(), this.mPreviewSize.getWidth());
                                    return;
                                }
                            }
                        }
                    }
                    int i8 = this.mSensorOrientation;
                    if (i8 != 0) {
                        if (i8 == 180) {
                        }
                        Point point2 = new Point();
                        this.mActivity.getWindowManager().getDefaultDisplay().getSize(point2);
                        int i62 = point2.x;
                        int i72 = point2.y;
                        if (z) {
                        }
                        this.mPreviewSize = chooseOptimalSize(streamConfigurationMap.getOutputSizes(SurfaceTexture.class), i3, i4, i62 <= MAX_PREVIEW_WIDTH ? MAX_PREVIEW_WIDTH : i62, i72 <= MAX_PREVIEW_HEIGHT ? MAX_PREVIEW_HEIGHT : i72);
                        LogUtil.m160d(TAG, "====>mPreviewSize:" + this.mPreviewSize);
                        if (this.mActivity.getResources().getConfiguration().orientation != 2) {
                        }
                    }
                    z = true;
                    Point point22 = new Point();
                    this.mActivity.getWindowManager().getDefaultDisplay().getSize(point22);
                    int i622 = point22.x;
                    int i722 = point22.y;
                    if (z) {
                    }
                    this.mPreviewSize = chooseOptimalSize(streamConfigurationMap.getOutputSizes(SurfaceTexture.class), i3, i4, i622 <= MAX_PREVIEW_WIDTH ? MAX_PREVIEW_WIDTH : i622, i722 <= MAX_PREVIEW_HEIGHT ? MAX_PREVIEW_HEIGHT : i722);
                    LogUtil.m160d(TAG, "====>mPreviewSize:" + this.mPreviewSize);
                    if (this.mActivity.getResources().getConfiguration().orientation != 2) {
                    }
                }
                int i9 = this.mSensorOrientation;
                if (i9 != 90) {
                }
                z = true;
                Point point222 = new Point();
                this.mActivity.getWindowManager().getDefaultDisplay().getSize(point222);
                int i6222 = point222.x;
                int i7222 = point222.y;
                if (z) {
                }
                this.mPreviewSize = chooseOptimalSize(streamConfigurationMap.getOutputSizes(SurfaceTexture.class), i3, i4, i6222 <= MAX_PREVIEW_WIDTH ? MAX_PREVIEW_WIDTH : i6222, i7222 <= MAX_PREVIEW_HEIGHT ? MAX_PREVIEW_HEIGHT : i7222);
                LogUtil.m160d(TAG, "====>mPreviewSize:" + this.mPreviewSize);
                if (this.mActivity.getResources().getConfiguration().orientation != 2) {
                }
            } else {
                throw new IllegalStateException("front camera is disAvailable");
            }
        } catch (Exception e) {
            noticeException(CameraErrorCode.ERROR_CODE_CAMERA_CONFIG_ERROR, e);
        }
    }

    private Size chooseOptimalSize(Size[] sizeArr, int i, int i2, int i3, int i4) {
        Size size;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder("[");
        for (Size size2 : sizeArr) {
            sb.append("[").append(size2.getWidth()).append("x").append(size2.getHeight()).append("],");
            if (size2.getWidth() <= i3 && size2.getHeight() <= i4 && size2.getHeight() == (size2.getWidth() * i2) / i) {
                if (size2.getWidth() >= i && size2.getHeight() >= i2) {
                    arrayList.add(size2);
                } else {
                    arrayList2.add(size2);
                }
            }
        }
        sb.append("]");
        if (arrayList.size() > 0) {
            size = (Size) Collections.min(arrayList, new CompareSizesByArea());
        } else if (arrayList2.size() > 0) {
            size = (Size) Collections.max(arrayList2, new CompareSizesByArea());
        } else {
            LogUtil.m160d(TAG, "Couldn't find any suitable preview size");
            size = new Size(i, i2);
        }
        LogUtil.m160d(TAG, "=====>chooseOptimalSize:finalChooseSize=" + size + ":" + ((Object) sb));
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noticeException(int i, Exception exc) {
        CameraFrameDataCallBack cameraFrameDataCallBack = this.mCameraFrameDataCallBack;
        if (cameraFrameDataCallBack == null || exc == null) {
            return;
        }
        cameraFrameDataCallBack.onCameraException(i, exc);
    }

    private void startBackGroundThread() {
        if (this.mBackgroundThread != null) {
            stopBackGroundThread();
        }
        HandlerThread handlerThread = new HandlerThread("BdTuring_Camera_Thread");
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackGroundThread() {
        try {
            HandlerThread handlerThread = this.mBackgroundThread;
            if (handlerThread != null) {
                handlerThread.quit();
                this.mBackgroundThread.join();
            }
            this.mBackgroundThread = null;
            this.mBackgroundHandler = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startCamera() {
        if (this.mTextureView == null) {
            return;
        }
        openCameraInner(PREVIEW_WIDTH, PREVIEW_HEIGHT);
    }

    public void stopCamera() {
        try {
            if (this.mCameraDevice == null) {
                return;
            }
            CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.mCaptureSession = null;
            }
            this.mCameraDevice.close();
            this.mCameraDevice = null;
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.close();
                this.mImageReader = null;
            }
            OrientationEventListener orientationEventListener = this.mOrientationListener;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
            stopBackGroundThread();
            CameraStateMonitor.getInstance().reportCameraState();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        stopCamera();
        this.mActivity = null;
        this.mTextureView = null;
        CameraFrameDataReader cameraFrameDataReader = this.mCameraFrameDataReader;
        if (cameraFrameDataReader != null) {
            cameraFrameDataReader.release();
            this.mCameraFrameDataReader = null;
        }
        this.mCameraFrameDataCallBack = null;
        CameraStateMonitor.getInstance().clearEvent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class CompareSizesByArea implements Comparator<Size> {
        CompareSizesByArea() {
        }

        @Override // java.util.Comparator
        public int compare(Size size, Size size2) {
            return Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        }
    }
}
