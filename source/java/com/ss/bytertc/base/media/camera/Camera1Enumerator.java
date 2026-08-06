package com.ss.bytertc.base.media.camera;

import android.hardware.Camera;
import android.os.SystemClock;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.base.media.Size;
import com.ss.bytertc.base.media.camera.CameraEnumerationAndroid;
import com.ss.bytertc.base.media.camera.CameraVideoCapturer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class Camera1Enumerator implements CameraEnumerator {
    private static final String TAG = "Camera1Enumerator";
    private static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
    private final boolean captureToTexture;
    private final boolean isDesktopMode;

    public Camera1Enumerator() {
        this(true, false);
    }

    public Camera1Enumerator(boolean captureToTexture, boolean isDesktopMode) {
        this.captureToTexture = captureToTexture;
        this.isDesktopMode = isDesktopMode;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public String[] getDeviceNames() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            String deviceName = getDeviceName(i);
            if (deviceName != null) {
                arrayList.add(deviceName);
                RXLogging.w(TAG, "Index: " + i + ". " + deviceName);
            } else {
                RXLogging.e(TAG, "Index: " + i + ". Failed to query camera name.");
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public boolean isFrontFacing(String deviceName) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(deviceName));
        return cameraInfo != null && cameraInfo.facing == 1;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public boolean isBackFacing(String deviceName) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(deviceName));
        return cameraInfo != null && cameraInfo.facing == 0;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String deviceName) {
        return getSupportedFormats(getCameraIndex(deviceName));
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public CameraVideoCapturer createCapturer(String deviceName, CameraVideoCapturer.CameraEventsHandler eventsHandler) {
        return new Camera1Capturer(deviceName, eventsHandler, this.captureToTexture, this.isDesktopMode);
    }

    private static Camera.CameraInfo getCameraInfo(int index) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(index, cameraInfo);
            return cameraInfo;
        } catch (Exception e) {
            RXLogging.e(TAG, "getCameraInfo failed on index " + index, e);
            return null;
        }
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public int getDeviceOrientation(String deviceName) {
        return getCameraInfo(getCameraIndex(deviceName)).orientation;
    }

    static synchronized List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int cameraId) {
        List<CameraEnumerationAndroid.CaptureFormat> list;
        synchronized (Camera1Enumerator.class) {
            if (cachedSupportedFormats == null) {
                cachedSupportedFormats = new ArrayList();
                for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                    cachedSupportedFormats.add(enumerateFormats(i));
                }
            }
            list = cachedSupportedFormats.get(cameraId);
        }
        return list;
    }

    private static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int cameraId) {
        int i;
        RXLogging.w(TAG, "Get supported formats for camera index " + cameraId + LibrarianImpl.Constants.DOT);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Camera camera = null;
        try {
            try {
                RXLogging.w(TAG, "Opening camera with index " + cameraId);
                camera = Camera.open(cameraId);
                Camera.Parameters parameters = camera.getParameters();
                if (camera != null) {
                    camera.release();
                }
                ArrayList arrayList = new ArrayList();
                if (parameters != null) {
                    try {
                        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                        int i2 = 0;
                        if (supportedPreviewFpsRange != null) {
                            int[] iArr = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
                            i2 = iArr[0];
                            i = iArr[1];
                        } else {
                            i = 0;
                        }
                        for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
                            arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, i2, i));
                        }
                    } catch (Exception e) {
                        RXLogging.e(TAG, "getSupportedFormats() failed on camera index " + cameraId, e);
                    }
                }
                RXLogging.w(TAG, "Get supported formats for camera index " + cameraId + " done. Time spent: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms.");
                return arrayList;
            } catch (RuntimeException e2) {
                RXLogging.e(TAG, "Open camera failed on camera index " + cameraId, e2);
                ArrayList arrayList2 = new ArrayList();
                if (camera != null) {
                    camera.release();
                }
                return arrayList2;
            }
        } catch (Throwable th) {
            if (camera != null) {
                camera.release();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Size> convertSizes(List<Camera.Size> cameraSizes) {
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : cameraSizes) {
            arrayList.add(new Size(size.width, size.height));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> arrayRanges) {
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : arrayRanges) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(iArr[0], iArr[1]));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getCameraIndex(String deviceName) {
        RXLogging.w(TAG, "getCameraIndex: " + deviceName);
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            if (deviceName.equals(getDeviceName(i))) {
                return i;
            }
        }
        throw new IllegalArgumentException("No such camera: " + deviceName);
    }

    static String getDeviceName(int index) {
        Camera.CameraInfo cameraInfo = getCameraInfo(index);
        if (cameraInfo == null) {
            return null;
        }
        return "Camera " + index + ", Facing " + (cameraInfo.facing == 1 ? "front" : "back") + ", Orientation " + cameraInfo.orientation;
    }
}
