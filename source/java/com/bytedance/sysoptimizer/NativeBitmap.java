package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;

/* loaded from: classes5.dex */
public class NativeBitmap {
    private static final String TAG = "NativeBitmap";
    private static boolean mEnabled;
    private static boolean mStarted;

    private static native boolean start(int i);

    static /* synthetic */ double access$100() {
        return getJavaHeapUtilizaiton();
    }

    private NativeBitmap() {
    }

    public static synchronized boolean enable(Context context) {
        synchronized (NativeBitmap.class) {
            if (Build.VERSION.SDK_INT > 25) {
                return false;
            }
            return realStart(context);
        }
    }

    public static synchronized boolean enable(final Context context, final long j, final double d, long j2) {
        synchronized (NativeBitmap.class) {
            if (Build.VERSION.SDK_INT > 25) {
                return false;
            }
            if (Runtime.getRuntime().maxMemory() > j2) {
                Log.e(TAG, "disabled: The java heap is big enough. ");
                return false;
            }
            if (!mStarted && !mEnabled) {
                mStarted = true;
                new Thread(null, new Runnable() { // from class: com.bytedance.sysoptimizer.NativeBitmap.1
                    @Override // java.lang.Runnable
                    public void run() {
                        while (true) {
                            try {
                                Thread.sleep(j);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (NativeBitmap.mEnabled) {
                                return;
                            }
                            if (NativeBitmap.access$100() >= d) {
                                NativeBitmap.realStart(context);
                                return;
                            }
                            continue;
                        }
                    }
                }, TAG, PlaybackStateCompat.ACTION_SET_REPEAT_MODE).start();
                return true;
            }
            return true;
        }
    }

    private static double getJavaHeapUtilizaiton() {
        return (Runtime.getRuntime().totalMemory() * 1.0d) / Runtime.getRuntime().maxMemory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized boolean realStart(Context context) {
        synchronized (NativeBitmap.class) {
            if (mEnabled) {
                return true;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    mEnabled = start(Build.VERSION.SDK_INT);
                    Log.d(TAG, "NativeBitmap.enable: " + mEnabled);
                    return mEnabled;
                } catch (UnsatisfiedLinkError e) {
                    Log.e(TAG, "UnsatisfiedLinkError", e);
                }
            }
            return false;
        }
    }
}
