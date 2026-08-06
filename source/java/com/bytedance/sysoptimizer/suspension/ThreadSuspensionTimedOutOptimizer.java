package com.bytedance.sysoptimizer.suspension;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class ThreadSuspensionTimedOutOptimizer {
    private static final int SHADOWHOOK_ERRNO_OK = 0;
    private static final int SHADOWHOOK_ERRNO_UNINIT = 2;
    private static final String TAG = "ThreadSusOptimizer";
    private static final AtomicBoolean mInitFlag = new AtomicBoolean(false);

    private static native void abortBlackListNative();

    private static native boolean addBlackListItemNative(String str, String str2);

    private static native boolean applyFakeThreadGetStackTraceNative(boolean z);

    private static synchronized boolean processBlackList(String str) {
        synchronized (ThreadSuspensionTimedOutOptimizer.class) {
            if (!str.endsWith(";")) {
                Log.w(TAG, "blackListString check fail");
                return false;
            }
            String[] split = str.split(";");
            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split(Constants.COLON_SEPARATOR);
                if (split2.length != 2) {
                    Log.w(TAG, "blacklist format error:" + split[i]);
                    return false;
                }
                addBlackListItemNative(split2[0], split2[1]);
            }
            return true;
        }
    }

    public static synchronized boolean applyFakeThreadGetStackTrace(Context context, String str) {
        boolean applyFakeThreadGetStackTrace;
        synchronized (ThreadSuspensionTimedOutOptimizer.class) {
            applyFakeThreadGetStackTrace = applyFakeThreadGetStackTrace(context, str, false);
        }
        return applyFakeThreadGetStackTrace;
    }

    public static synchronized boolean applyFakeThreadGetStackTrace(Context context, String str, boolean z) {
        synchronized (ThreadSuspensionTimedOutOptimizer.class) {
            if (str != null) {
                if (!str.isEmpty()) {
                    if (mInitFlag.get()) {
                        return true;
                    }
                    if (Build.VERSION.SDK_INT < 29) {
                        Log.d(TAG, "ignore android < 10");
                        return false;
                    }
                    int i = 2;
                    try {
                        if (SysOptimizer.loadOptimizerLibrary(context)) {
                            i = ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                        } else {
                            Log.e(TAG, "load sysopt native lib fail.");
                        }
                    } catch (Throwable th) {
                        Log.e(TAG, "init shadowhook fail", th);
                    }
                    if (i != 0) {
                        Log.e(TAG, "shadowhook errno=" + i);
                        return false;
                    }
                    try {
                        if (!processBlackList(str)) {
                            Log.e(TAG, "processBlackList fail");
                            abortBlackListNative();
                            return false;
                        }
                        return applyFakeThreadGetStackTraceNative(z);
                    } catch (Throwable th2) {
                        Log.e(TAG, "apply fail", th2);
                        return false;
                    }
                }
            }
            Log.d(TAG, "empty black list");
            return false;
        }
    }
}
