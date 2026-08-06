package com.bytedance.crash.npth_repair;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.crash.npth_repair.utils.RepairLog;
import com.bytedance.librarian.Librarian;

/* loaded from: classes3.dex */
public class NpthRepair {
    private static final String TAG = "NpthRepair";
    public static Context applicationContext = null;
    private static int initErrno = -1;
    private static boolean inited;
    private static boolean soLoaded;

    private static native boolean nGetDebuggable();

    private static native int nInit(int i, boolean z);

    private static native void nSetDebuggable(boolean z);

    public static synchronized int init(Context context, boolean z) {
        synchronized (NpthRepair.class) {
            if (inited) {
                if (z) {
                    Log.d(TAG, "already do init");
                }
                return initErrno;
            }
            RepairLog.setDebuggable(z);
            inited = true;
            applicationContext = context;
            if (loadLibrary()) {
                try {
                    setDebuggable(z);
                    initErrno = nInit(Build.VERSION.SDK_INT, z);
                } catch (Throwable unused) {
                    initErrno = -3;
                }
            } else {
                initErrno = -5;
            }
            return initErrno;
        }
    }

    public static boolean isInited() {
        return initErrno == 0;
    }

    public static void setDebuggable(boolean z) {
        RepairLog.setDebuggable(z);
        if (soLoaded) {
            nSetDebuggable(z);
        }
    }

    public static boolean getDebuggable() {
        if (soLoaded) {
            return nGetDebuggable();
        }
        return false;
    }

    public static boolean loadLibrary() {
        if (!soLoaded) {
            try {
                Librarian.loadLibraryForModule("npth_repair", applicationContext);
                soLoaded = true;
            } catch (Throwable unused) {
                Log.d(TAG, "load so fail");
            }
        }
        return soLoaded;
    }
}
