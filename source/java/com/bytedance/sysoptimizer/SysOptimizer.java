package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.librarian.Librarian;
import java.lang.reflect.Method;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class SysOptimizer {
    private static final String TAG = "SYSOPTIMIZER";
    private static volatile boolean mOptimzerLibLoaded;
    private static ArrayList<UnsatisfiedLinkError> mLoadError = new ArrayList<>();
    private static boolean mHookRefreshed = false;

    private static native void refreshHook();

    private static native void reservedForJniOffset();

    public static boolean loadOptimizerLibrary(Context context) {
        if (mOptimzerLibLoaded) {
            return true;
        }
        synchronized (SysOptimizer.class) {
            if (mOptimzerLibLoaded) {
                return true;
            }
            try {
                if (context == null) {
                    System.loadLibrary("sysoptimizer");
                } else {
                    Librarian.loadLibraryForModule("sysoptimizer", context);
                }
                Log.d(TAG, "load SYSOPTIMIZER success");
                reservedForJniOffset();
                mOptimzerLibLoaded = true;
                return true;
            } catch (UnsatisfiedLinkError e) {
                Log.e(TAG, "failed to load SYSOPTIMIZER");
                Log.e(TAG, "", e);
                mLoadError.add(e);
                return false;
            } catch (OverlappingFileLockException e2) {
                Log.e(TAG, "failed to load so caused by OverlappingFileLockException:", e2);
                return false;
            }
        }
    }

    public static boolean activeMethod(Method method) {
        if ((method.getModifiers() & 8) != 0) {
            try {
                if (method.getParameterCount() == 0) {
                    method.setAccessible(true);
                    method.invoke(null, 0);
                } else {
                    method.setAccessible(true);
                    method.invoke(null, new Object[0]);
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static ArrayList<UnsatisfiedLinkError> getLoadLibraryError() {
        return mLoadError;
    }

    public static synchronized void hookOptimizerEnable() {
        synchronized (SysOptimizer.class) {
            if (!mOptimzerLibLoaded || mHookRefreshed) {
                return;
            }
            try {
                refreshHook();
                mHookRefreshed = true;
            } catch (UnsatisfiedLinkError unused) {
                Log.e(TAG, "refresh xhook failed.");
            }
        }
    }
}
