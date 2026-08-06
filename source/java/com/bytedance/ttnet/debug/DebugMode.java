package com.bytedance.ttnet.debug;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.ttnet.TTNetInit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DebugMode {
    private static String TTNET_DEBUG_MODE = "ttnet_debug_mode";

    private static boolean isOpenDebugMode() {
        return TTNetInit.ENV.RELEASE != TTNetInit.getEnv();
    }

    public static void openIfDebug(Context context) {
        if (!isOpenDebugMode()) {
            Logger.d(TTNET_DEBUG_MODE, "debug_mode close");
        } else {
            run(context);
        }
    }

    private static void run(Context context) {
        Logger.d(TTNET_DEBUG_MODE, "debug_mode open");
        if (DebugSetting.isLogOpen(context)) {
            openLogger();
        }
    }

    public static boolean x86Support() {
        if (isOpenDebugMode()) {
            return DebugSetting.isX86Support(TTNetInit.getTTNetDepend().getContext());
        }
        return false;
    }

    public static void openLogger() {
        Logger.setLogLevel(2);
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
    }
}
