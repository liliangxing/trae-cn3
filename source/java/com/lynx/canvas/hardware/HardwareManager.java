package com.lynx.canvas.hardware;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonSensorService;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HardwareManager implements KryptonSensorService.Listener {
    private static final ArrayList<Integer> MONITOR_GYROSCOPE_TYPE_LIST = monitorGyroscopeSensorTypeList();
    private static final String TAG = "KryptonHardwareManager";
    private final long mNativePtr;
    private boolean mReleased;
    private KryptonSensorService mSensorService;

    private static native void nativeNotifyGyroscopeData(long j, float f, float f2, float f3, long j2);

    private static native void nativeNotifyOrientationData(long j, float f, float f2, float f3, long j2);

    public HardwareManager(long j, KryptonApp kryptonApp) {
        this.mNativePtr = j;
        KryptonSensorService kryptonSensorService = (KryptonSensorService) kryptonApp.getService(KryptonSensorService.class);
        this.mSensorService = kryptonSensorService;
        if (kryptonSensorService != null) {
            kryptonSensorService.setListener(this);
        } else {
            KryptonLLog.m2560e(TAG, "no sensor service found");
        }
    }

    private static HardwareManager createInstance(long j, KryptonApp kryptonApp) {
        return new HardwareManager(j, kryptonApp);
    }

    private void release() {
        stopMonitorGyroscope();
        synchronized (this) {
            this.mReleased = true;
            KryptonSensorService kryptonSensorService = this.mSensorService;
            if (kryptonSensorService != null) {
                kryptonSensorService.setListener(null);
            }
        }
    }

    private void startMonitorGyroscope(int i) {
        KryptonSensorService kryptonSensorService = this.mSensorService;
        if (kryptonSensorService == null) {
            KryptonLLog.m2560e(TAG, "startMonitorGyroscope error: no sensor service");
        } else {
            kryptonSensorService.start(MONITOR_GYROSCOPE_TYPE_LIST, i);
        }
    }

    private void stopMonitorGyroscope() {
        KryptonSensorService kryptonSensorService = this.mSensorService;
        if (kryptonSensorService != null) {
            kryptonSensorService.stop();
        }
    }

    private static ArrayList<Integer> monitorGyroscopeSensorTypeList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(new Integer(4));
        arrayList.add(new Integer(15));
        return arrayList;
    }

    @Override // com.lynx.canvas.KryptonSensorService.Listener
    public void notifyGyroscopeData(float f, float f2, float f3, long j) {
        synchronized (this) {
            if (!this.mReleased) {
                nativeNotifyGyroscopeData(this.mNativePtr, f, f2, f3, j);
            }
        }
    }

    @Override // com.lynx.canvas.KryptonSensorService.Listener
    public void notifyOrientationData(float f, float f2, float f3, long j) {
        synchronized (this) {
            if (!this.mReleased) {
                nativeNotifyOrientationData(this.mNativePtr, f, f2, f3, j);
            }
        }
    }
}
