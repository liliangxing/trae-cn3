package com.bytedance.crash.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.crash.general.RomInfoHelper;
import java.util.Locale;

@Deprecated
/* loaded from: classes3.dex */
public class RomUtils {
    public static final String COLOROS = "coloros";
    public static final String EMUI = "emotionui";
    private static final String EUI = "eui";
    public static final String FLYME = "flyme";
    private static final String FOUTOUCH_OS_SOFTWARE_VERSION = "ro.vivo.product.version";
    private static final String FUNTOUCH_OS_VERSION = "ro.vivo.os.build.display.id";
    private static final String KEY_360OS = "ro.build.uiversion";
    public static final String MIUI = "miui";
    private static final String MODEL_LETV = "ro.letv.release.version";
    public static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    public static final String RUNTIME_OPPO = "ro.build.version.opporom";
    public static final String SEPARATOR = "_";
    private static int sIsHmOs = -1;
    private static final CharSequence SONY = "sony";
    private static final CharSequence AMIGO = "amigo";
    private static final CharSequence FUNTOUCHOS = "funtouch";

    private RomUtils() {
    }

    public static String getRomInfo() {
        if (Device.isMiui()) {
            return getMIUIVersion();
        }
        if (Device.isFlyme()) {
            return getFlymeVersion();
        }
        if (isColorOS()) {
            return getColorOsVersion();
        }
        String eMUVersion = getEMUVersion();
        if (!TextUtils.isEmpty(eMUVersion)) {
            return eMUVersion;
        }
        if (isFunTouchOS()) {
            return getFuntouchOSVersion();
        }
        if (isAmigo()) {
            return getAmigoVersion();
        }
        if (is360OS()) {
            return get360OSVersion();
        }
        String eUIVersion = getEUIVersion();
        return !TextUtils.isEmpty(eUIVersion) ? eUIVersion : Build.DISPLAY;
    }

    public static String get360OSVersion() {
        return getSystemProperty(KEY_360OS) + "_" + Build.DISPLAY;
    }

    public static boolean isHarmonyOs() {
        int i = sIsHmOs;
        if (i != -1) {
            return i == 1;
        }
        try {
            if (Class.forName("ohos.utils.system.SystemCapability") != null) {
                sIsHmOs = 1;
            } else {
                sIsHmOs = 0;
            }
        } catch (Throwable unused) {
            sIsHmOs = 0;
        }
        return sIsHmOs == 1;
    }

    public static boolean is360OS() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String getFuntouchOSVersion() {
        return getSystemProperty(FUNTOUCH_OS_VERSION) + "_" + getSystemProperty(FOUTOUCH_OS_SOFTWARE_VERSION);
    }

    public static boolean isFunTouchOS() {
        String systemProperty = getSystemProperty(FUNTOUCH_OS_VERSION);
        return !TextUtils.isEmpty(systemProperty) && systemProperty.toLowerCase(Locale.getDefault()).contains(FUNTOUCHOS);
    }

    public static boolean isAmigo() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(AMIGO);
    }

    public static String getAmigoVersion() {
        return Build.DISPLAY + "_" + getSystemProperty("ro.gn.sv.version");
    }

    public static String getEUIVersion() {
        return isEUI() ? "eui_" + getSystemProperty(MODEL_LETV) + "_" + Build.DISPLAY : "";
    }

    public static boolean isEUI() {
        return !TextUtils.isEmpty(getSystemProperty(MODEL_LETV));
    }

    public static boolean isSony() {
        String str = Build.BRAND + Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) || str.toLowerCase(Locale.getDefault()).contains(SONY);
    }

    public static String getMIUIVersion() {
        return Device.isMiui() ? "miui_" + getSystemProperty("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String getEMUVersion() {
        String emuiInfo = Device.getEmuiInfo();
        return (emuiInfo == null || !emuiInfo.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : emuiInfo + "_" + Build.DISPLAY;
    }

    public static String getFlymeVersion() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean isColorOS() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String getColorOsVersion() {
        return isColorOS() ? "coloros_" + getSystemProperty("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    public static String getSystemProperty(String str) {
        return RomInfoHelper.getSystemProperty(str, "");
    }
}
