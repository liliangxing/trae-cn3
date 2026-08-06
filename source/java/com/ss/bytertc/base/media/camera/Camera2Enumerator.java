package com.ss.bytertc.base.media.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.SystemClock;
import android.util.AndroidException;
import android.util.Range;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.base.media.Size;
import com.ss.bytertc.base.media.camera.CameraEnumerationAndroid;
import com.ss.bytertc.base.media.camera.CameraVideoCapturer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class Camera2Enumerator implements CameraEnumerator {
    private static final double NANO_SECONDS_PER_SECOND = 1.0E9d;
    private static final String TAG = "Camera2Enumerator";
    private static final Map<String, List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats = new HashMap();
    final CameraManager cameraManager;
    final Context context;

    public Camera2Enumerator(Context context) {
        this.context = context;
        this.cameraManager = (CameraManager) context.getSystemService("camera");
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public String[] getDeviceNames() {
        try {
            CameraManager cameraManager = this.cameraManager;
            if (cameraManager != null) {
                return cameraManager.getCameraIdList();
            }
        } catch (AndroidException e) {
            RXLogging.e(TAG, "Camera access exception: " + e);
        }
        return new String[0];
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public boolean isFrontFacing(String deviceName) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(deviceName);
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public boolean isBackFacing(String deviceName) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(deviceName);
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String deviceName) {
        return getSupportedFormats(this.context, deviceName);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public CameraVideoCapturer createCapturer(String deviceName, CameraVideoCapturer.CameraEventsHandler eventsHandler) {
        return new Camera2Capturer(this.context, deviceName, eventsHandler);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public int getDeviceOrientation(String deviceName) {
        return ((Integer) getCameraCharacteristics(deviceName).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }

    private CameraCharacteristics getCameraCharacteristics(String deviceName) {
        try {
            CameraManager cameraManager = this.cameraManager;
            if (cameraManager != null) {
                return cameraManager.getCameraCharacteristics(deviceName);
            }
            return null;
        } catch (AndroidException e) {
            RXLogging.e(TAG, "Camera access exception: " + e);
            return null;
        }
    }

    public static boolean isSupported(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        try {
            for (String str : cameraManager.getCameraIdList()) {
                if (((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                    return false;
                }
            }
            return true;
        } catch (AndroidException e) {
            RXLogging.e(TAG, "Camera access exception: " + e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getFpsUnitFactor(Range<Integer>[] fpsRanges) {
        return (fpsRanges.length != 0 && fpsRanges[0].getUpper().intValue() >= 1000) ? 1 : 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Size> getSupportedSizes(CameraCharacteristics cameraCharacteristics) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (outputSizes == null) {
            return null;
        }
        return convertSizes(outputSizes);
    }

    static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(Context context, String cameraId) {
        return getSupportedFormats((CameraManager) context.getSystemService("camera"), cameraId);
    }

    static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager cameraManager, String cameraId) {
        long j;
        Map<String, List<CameraEnumerationAndroid.CaptureFormat>> map = cachedSupportedFormats;
        synchronized (map) {
            if (map.containsKey(cameraId)) {
                return map.get(cameraId);
            }
            RXLogging.i(TAG, "Get supported formats for camera index " + cameraId + ".");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraId);
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates = convertFramerates(rangeArr, getFpsUnitFactor(rangeArr));
                List<Size> supportedSizes = getSupportedSizes(cameraCharacteristics);
                Iterator<CameraEnumerationAndroid.CaptureFormat.FramerateRange> it = convertFramerates.iterator();
                int i = 0;
                while (it.hasNext()) {
                    i = Math.max(i, it.next().max);
                }
                ArrayList arrayList = new ArrayList();
                for (Size size : supportedSizes) {
                    try {
                        j = streamConfigurationMap.getOutputMinFrameDuration(SurfaceTexture.class, new android.util.Size(size.width, size.height));
                    } catch (Exception unused) {
                        j = 0;
                    }
                    int round = j == 0 ? i : ((int) Math.round(1.0E9d / j)) * 1000;
                    arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, 0, round));
                    RXLogging.i(TAG, "Format: " + size.width + "x" + size.height + "@" + round);
                }
                cachedSupportedFormats.put(cameraId, arrayList);
                RXLogging.i(TAG, "Get supported formats for camera index " + cameraId + " done. Time spent: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms.");
                return arrayList;
            } catch (Exception e) {
                RXLogging.e(TAG, "getCameraCharacteristics(): " + e);
                return new ArrayList();
            }
        }
    }

    private static List<Size> convertSizes(android.util.Size[] cameraSizes) {
        ArrayList arrayList = new ArrayList();
        for (android.util.Size size : cameraSizes) {
            arrayList.add(new Size(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(Range<Integer>[] arrayRanges, int unitFactor) {
        ArrayList arrayList = new ArrayList();
        for (Range<Integer> range : arrayRanges) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(range.getLower().intValue() * unitFactor, range.getUpper().intValue() * unitFactor));
        }
        return arrayList;
    }
}
