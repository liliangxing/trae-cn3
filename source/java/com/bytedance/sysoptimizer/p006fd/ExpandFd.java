package com.bytedance.sysoptimizer.p006fd;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ExpandFd {
    private static final int SHADOWHOOK_ERRNO_OK = 0;
    private static final int SHADOWHOOK_ERRNO_UNINIT = 2;
    private static final String TAG = "ExpandFd";
    private static final AtomicBoolean mInitFlag = new AtomicBoolean(false);

    private static native boolean addExpandFdSetTarget(String str, String str2);

    private static native int expandKernelFdLimitNative();

    private static native boolean expandLibcFdLimitNative(int i);

    private static native boolean is64BitNative();

    public static synchronized boolean apply(Context context, boolean z, String str) {
        synchronized (ExpandFd.class) {
            if (mInitFlag.get()) {
                return true;
            }
            if (Build.VERSION.SDK_INT > 28) {
                Log.d(TAG, "unsupported android api:" + Build.VERSION.SDK_INT);
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
                if (!is64BitNative()) {
                    Log.d(TAG, "unsupported 32bit");
                    return false;
                }
                int expandKernelFdLimitNative = expandKernelFdLimitNative();
                mInitFlag.set(true);
                if (expandKernelFdLimitNative == 0) {
                    Log.e(TAG, "expand kernel fd limit fail");
                    return false;
                }
                if (z) {
                    Log.d(TAG, "expand kernel limit only, skip libc expand");
                    return true;
                }
                if (!expandLibcFdLimitNative(expandKernelFdLimitNative)) {
                    Log.e(TAG, "expand libc apply fail");
                    return false;
                }
                boolean applyJavaCryptoExpandFdSet = DefaultFdSetExpandHelper.applyJavaCryptoExpandFdSet();
                boolean applyLibcExpand = DefaultFdSetExpandHelper.applyLibcExpand();
                Log.i(TAG, "apply result: java crypto=" + applyJavaCryptoExpandFdSet + ", libc=" + applyLibcExpand + ", qti boost=" + DefaultFdSetExpandHelper.applyQtiBoostFrameworkExpand());
                if (!processTargetList(str)) {
                    Log.w(TAG, "processTargetList fail");
                }
                return applyJavaCryptoExpandFdSet && applyLibcExpand;
            } catch (Throwable th2) {
                Log.e(TAG, "apply fail", th2);
                return false;
            }
        }
    }

    private static synchronized boolean processTargetList(String str) {
        synchronized (ExpandFd.class) {
            if (str != null) {
                if (str.trim().length() != 0) {
                    if (!str.endsWith(";")) {
                        Log.w(TAG, "expandFdSetTargetList check fail");
                        return false;
                    }
                    String[] split = str.split(";");
                    for (int i = 0; i < split.length; i++) {
                        String[] split2 = split[i].split(":");
                        if (split2.length != 2) {
                            Log.w(TAG, "keyValues format error:" + split[i]);
                            return false;
                        }
                        String str2 = split2[0];
                        String str3 = split2[1];
                        if (!str2.endsWith(".so")) {
                            Log.w(TAG, "lib name format error:" + str2);
                            return false;
                        }
                        addExpandFdSetTarget(str2, str3);
                    }
                    return true;
                }
            }
            return true;
        }
    }
}
