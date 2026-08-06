package com.bytedance.crash.npth_repair.monitor;

import android.os.Build;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.utils.RepairPortrait;
import com.bytedance.crash.npth_repair.utils.RepairState;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class SignalMonitor {
    private static final String TAG = "SignalMonitor: ";
    private static SignalMonitor sInstance;
    private RepairPortrait mMonitorPortriait;
    private int mMonitorState = RepairState.STATE_RAW;

    private native int nDumpSignalMonitor(String str);

    private native int nStartSignalMonitorWithSigType(int[] iArr);

    private native void nStopSignalMonitor();

    private SignalMonitor() {
    }

    public static SignalMonitor getInstance() {
        if (sInstance == null) {
            synchronized (SignalMonitor.class) {
                if (sInstance == null) {
                    sInstance = new SignalMonitor();
                }
            }
        }
        return sInstance;
    }

    private boolean shouldMonitor(RepairPortrait repairPortrait) {
        return repairPortrait == null || (repairPortrait.checkApiLevel(Build.VERSION.SDK_INT) && repairPortrait.checkBrand(Build.BRAND));
    }

    private static int[] getSigTypesFromPortrait(RepairPortrait repairPortrait) {
        int[] iArr = null;
        if (repairPortrait == null) {
            return null;
        }
        JSONArray customConfigArray = repairPortrait.getCustomConfigArray("sigTypes");
        if (customConfigArray != null && customConfigArray.length() > 0) {
            iArr = new int[customConfigArray.length()];
            for (int i = 0; i < customConfigArray.length(); i++) {
                iArr[i] = customConfigArray.optInt(i);
            }
        }
        return iArr;
    }

    public synchronized int startMonitor(RepairPortrait repairPortrait) {
        int i;
        int i2 = this.mMonitorState;
        if (i2 != 1110 && i2 != 1113) {
            return -2;
        }
        if (!NpthRepair.isInited()) {
            return -1;
        }
        this.mMonitorPortriait = repairPortrait;
        if (shouldMonitor(repairPortrait)) {
            try {
                i = nStartSignalMonitorWithSigType(getSigTypesFromPortrait(repairPortrait));
            } catch (Throwable unused) {
                i = -4;
            }
        } else {
            i = -6;
        }
        if (i == 0) {
            this.mMonitorState = 1111;
        } else {
            this.mMonitorState = RepairState.STATE_FAIL;
        }
        return i;
    }

    public synchronized void stopMonitor() {
        if (this.mMonitorState == 1111) {
            this.mMonitorState = RepairState.STATE_STOPPED;
            nStopSignalMonitor();
        }
    }

    public synchronized int dumpSignalMonitor(String str) {
        int i = this.mMonitorState;
        if (i != 1111 && i != 1113) {
            return -1;
        }
        this.mMonitorState = RepairState.STATE_DUMPED;
        return nDumpSignalMonitor(str);
    }
}
