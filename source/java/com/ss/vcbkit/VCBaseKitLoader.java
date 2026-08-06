package com.ss.vcbkit;

import android.util.Log;

/* loaded from: classes7.dex */
public class VCBaseKitLoader {
    private static final String TAG = "vcbasekit";
    private static volatile boolean isLibraryLoaded;

    private VCBaseKitLoader() {
    }

    public static synchronized boolean loadLibrary() {
        synchronized (VCBaseKitLoader.class) {
            if (isLibraryLoaded) {
                return true;
            }
            UnExpected.init();
            try {
                System.loadLibrary(TAG);
                isLibraryLoaded = true;
            } catch (UnsatisfiedLinkError e) {
                Log.e(TAG, "Can't link vcbasekit:" + e.getMessage());
            } catch (Throwable th) {
                Log.e(TAG, "Can't load vcbasekit:" + th.getMessage());
            }
            return isLibraryLoaded;
        }
    }
}
