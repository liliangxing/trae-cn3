package com.bytedance.android.standard.tools.device;

import com.bytedance.android.standard.tools.logging.Logger;

/* loaded from: classes3.dex */
public final class SystemPropertiesUtils {
    private static final String TAG = "SystemPropertiesUtils";
    public static volatile boolean hasProxy = true;
    private static SystemPropertiesProxy proxy = new SystemPropertiesProxy();

    private SystemPropertiesUtils() {
    }

    public static String getSystemProperty(String str) {
        if (hasProxy) {
            try {
                return proxy.get(str);
            } catch (Throwable th) {
                Logger.e(TAG, "android.os.SystemProperties reflect fail.", th);
                return CmdSystemProperties.getSystemProperty(str);
            }
        }
        return CmdSystemProperties.getSystemProperty(str);
    }
}
