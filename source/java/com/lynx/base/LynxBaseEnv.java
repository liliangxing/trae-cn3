package com.lynx.base;

import android.util.Log;
import com.lynx.base.log.LynxLog;

/* loaded from: classes6.dex */
public class LynxBaseEnv {
    private static LynxBaseEnv sInstance;
    private volatile boolean mIsNativeLibraryLoaded = false;

    public static LynxBaseEnv inst() {
        if (sInstance == null) {
            synchronized (LynxBaseEnv.class) {
                if (sInstance == null) {
                    sInstance = new LynxBaseEnv();
                }
            }
        }
        return sInstance;
    }

    private LynxBaseEnv() {
    }

    public boolean isNativeLibraryLoaded() {
        return this.mIsNativeLibraryLoaded;
    }

    public boolean init(IBaseNativeLibraryLoader iBaseNativeLibraryLoader, boolean z) {
        if (!this.mIsNativeLibraryLoaded) {
            this.mIsNativeLibraryLoaded = loadNativeTraceLibrary(iBaseNativeLibraryLoader);
        }
        LynxLog.initLynxLog(z);
        LynxBaseTrace.init();
        return true;
    }

    public synchronized boolean loadNativeTraceLibrary(IBaseNativeLibraryLoader iBaseNativeLibraryLoader) {
        if (this.mIsNativeLibraryLoaded) {
            return this.mIsNativeLibraryLoaded;
        }
        try {
            if (iBaseNativeLibraryLoader != null) {
                iBaseNativeLibraryLoader.loadLibrary("lynxbase");
            } else {
                System.loadLibrary("lynxbase");
            }
            return true;
        } catch (Exception unused) {
            Log.e("lynx base env init", "failed to load liblynxbase.so");
            return false;
        }
    }
}
