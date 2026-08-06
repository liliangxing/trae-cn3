package com.bytedance.sysoptimizer;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class ValidateSuperClassDescriptorsOpt {
    private static final String TAG = "ValidateSuperClassDescriptorsOpt";
    private static final AtomicBoolean sInit = new AtomicBoolean(false);
    private static volatile ICallback sCallback = null;

    /* loaded from: classes5.dex */
    public interface ICallback {
        int d(String str, String str2);

        int e(String str, String str2);

        int e(String str, String str2, Throwable th);
    }

    private static native int nStart();

    public static synchronized ICallback getCallback() {
        ICallback iCallback;
        synchronized (ValidateSuperClassDescriptorsOpt.class) {
            iCallback = sCallback;
            if (iCallback == null) {
                iCallback = new ICallback() { // from class: com.bytedance.sysoptimizer.ValidateSuperClassDescriptorsOpt.1
                    @Override // com.bytedance.sysoptimizer.ValidateSuperClassDescriptorsOpt.ICallback
                    public int d(String str, String str2) {
                        System.out.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.ValidateSuperClassDescriptorsOpt.ICallback
                    public int e(String str, String str2) {
                        System.err.println(str + ", " + str2);
                        return 0;
                    }

                    @Override // com.bytedance.sysoptimizer.ValidateSuperClassDescriptorsOpt.ICallback
                    public int e(String str, String str2, Throwable th) {
                        System.err.println(str + ", " + str2 + ", " + th);
                        return 0;
                    }
                };
                updateCallback(iCallback);
            }
        }
        return iCallback;
    }

    private static synchronized void updateCallback(ICallback iCallback) {
        synchronized (ValidateSuperClassDescriptorsOpt.class) {
            sCallback = iCallback;
        }
    }

    public static boolean isEnable() {
        ICallback callback = getCallback();
        if (Build.VERSION.SDK_INT < 27 || Build.VERSION.SDK_INT > 34) {
            callback.e(TAG, "NOT SUPPORT API LEVEL " + Build.VERSION.SDK_INT);
            return false;
        }
        if (!Process.is64Bit()) {
            callback.e(TAG, "NOT SUPPORT 32Bit");
            return false;
        }
        for (String str : Build.SUPPORTED_ABIS) {
            if (!TextUtils.isEmpty(str) && str.startsWith("x86")) {
                callback.e(TAG, "ONLY SUPPORT arm64-v8a.But current are " + TextUtils.join(",", Build.SUPPORTED_ABIS));
                return false;
            }
        }
        return true;
    }

    public static void start(boolean z, boolean z2, ICallback iCallback) {
        if (sInit.getAndSet(true)) {
            getCallback().e(TAG, "Already init");
            return;
        }
        if (isEnable()) {
            updateCallback(iCallback);
            if (z) {
                LogVerbosityUtil.open();
            }
            if (z2) {
                Flipped.invokeHiddenApiRestrictions();
            }
            if (SysOptimizer.loadOptimizerLibrary(null)) {
                nStart();
            }
        }
    }
}
