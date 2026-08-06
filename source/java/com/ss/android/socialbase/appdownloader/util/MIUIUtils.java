package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Base64;
import com.ss.ttm.player.C;

/* loaded from: classes7.dex */
public class MIUIUtils {
    private static final String BASIC_PURE_MODE_ACTIVITY = "bWl1aV9wYWNrYWdlaW5zdGFsbGVyOi8vY29tLm1pdWkucGFja2FnZWluc3RhbGxlci9zYWZlX21vZGU/c2FmZV9tb2RlX3R5cGU9c2V0dGluZyZzYWZlX21vZGVfcmVmPXNldHRpbmdfZW50cnk=";
    private static final String MIUI_VERSION_PROPERTY = "ro.miui.ui.version.name";
    private static final String SAFE_MODE_ENABLE = "miui_safe_mode";

    public static boolean isPureModeOpened(Context context) {
        return context != null && readPureModeState(context) == 1;
    }

    public static boolean checkPureModeEnabled(Context context) {
        return (context == null || readPureModeState(context) == -1) ? false : true;
    }

    public static boolean jumpPureModeActivity(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(new String(Base64.decode(BASIC_PURE_MODE_ACTIVITY, 0), "UTF-8"), 0);
            parseUri.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(parseUri);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int readPureModeState(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), SAFE_MODE_ENABLE, -1);
        }
        return 0;
    }

    public static String getMiuiVersion() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, "ro.miui.ui.version.name");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
