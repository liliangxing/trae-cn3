package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.push.utils.RomVersionParamHelper;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class HarmonyUtils {
    private static String sHarmonyApiVersion;
    private static String sHarmonyBuildVersion;
    private static String sHarmonyReleaseType;
    private static String sHarmonyVersion;
    private static Boolean sPureModeEnabled;

    public static boolean isPureModeOpened(Context context) {
        return context != null && readPureModeState(context) == 0 && checkPureModeEnabled();
    }

    public static boolean isPureEnhancedModeOpened(Context context) {
        return context != null && readPureEnhancedModeState(context) == 0 && checkPureEnhancedModeEnabled();
    }

    public static String getHarmonyApiVersion() {
        if (sHarmonyApiVersion == null) {
            sHarmonyApiVersion = getHarmonySystemVersion("getApiVersion");
        }
        return sHarmonyApiVersion;
    }

    public static String getHarmonyVersion() {
        try {
            if (sHarmonyVersion == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                sHarmonyVersion = cls.getDeclaredMethod("get", String.class).invoke(cls, RomVersionParamHelper.HARMONY_VERSION).toString();
            }
        } catch (Throwable unused) {
        }
        return sHarmonyVersion;
    }

    public static String getHarmonyReleaseType() {
        if (sHarmonyReleaseType == null) {
            sHarmonyReleaseType = getHarmonySystemVersion("getReleaseType");
        }
        return sHarmonyReleaseType;
    }

    public static String getHarmonyBuildVersion() {
        if (sHarmonyBuildVersion == null) {
            sHarmonyBuildVersion = getHarmonySystemVersion("getBuildVersion");
        }
        return sHarmonyBuildVersion;
    }

    public static int readPureModeState(Context context) {
        if (context == null) {
            return 1;
        }
        if (isHarmonyOs3(getHarmonyVersion(), getHarmonyApiVersion())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int readPureEnhancedModeState(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static boolean checkPureModeEnabled() {
        if (sPureModeEnabled == null) {
            boolean z = false;
            sPureModeEnabled = false;
            try {
                if ("156".equals(systemPropertiesExGet("ro.config.hw_optb", "0")) && RouterConstants.TRUE.equals(systemPropertiesExGet("hw_mc.pure_mode.enable", "false"))) {
                    z = true;
                }
                sPureModeEnabled = Boolean.valueOf(z);
            } catch (Exception unused) {
            }
        }
        return sPureModeEnabled.booleanValue();
    }

    public static boolean checkPureEnhancedModeEnabled() {
        return checkPureModeEnabled() && isHarmonyOs3(getHarmonyVersion(), getHarmonyApiVersion()) && userHandleExGet(Process.myUid()) == 0;
    }

    public static String getOsBrand() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String systemPropertiesExGet(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int userHandleExGet(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    private static String getHarmonySystemVersion(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean isHarmonyOs3(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (Integer.parseInt(str.split("\\.")[0]) >= 3) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String getHarmonyDisplayVersion() {
        String str = Build.DISPLAY;
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(" ")) {
                if (Pattern.matches("[0-9].*", str2)) {
                    char[] charArray = str2.toCharArray();
                    for (int i = 0; i < charArray.length; i++) {
                        if (charArray[i] == '(') {
                            return str2.substring(0, i);
                        }
                    }
                }
            }
        }
        return str;
    }
}
