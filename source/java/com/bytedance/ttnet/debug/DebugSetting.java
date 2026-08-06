package com.bytedance.ttnet.debug;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.ies.bullet.service.router.RouterConstants;

/* loaded from: classes4.dex */
public class DebugSetting {
    private static String KEY_LOG_SWITCHER = "log_switcher";
    private static String KEY_X86_SWITCHER = "x86_support";
    private static String TTNET_DEBUG_SETTING = "ttnet_debug_setting";

    private static String getSharePref(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(TTNET_DEBUG_SETTING, 0).getString(str, null);
        }
        return null;
    }

    private static void putSharePref(Context context, String str, String str2) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(TTNET_DEBUG_SETTING, 0).edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public static void logSwitcher(Context context, boolean z) {
        putSharePref(context, KEY_LOG_SWITCHER, String.valueOf(z));
    }

    public static boolean isLogOpen(Context context) {
        return RouterConstants.TRUE.equals(getSharePref(context, KEY_LOG_SWITCHER));
    }

    public static void x86Support(Context context, boolean z) {
        putSharePref(context, KEY_X86_SWITCHER, String.valueOf(z));
    }

    public static boolean isX86Support(Context context) {
        return RouterConstants.TRUE.equals(getSharePref(context, KEY_X86_SWITCHER));
    }
}
