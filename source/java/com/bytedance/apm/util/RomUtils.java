package com.bytedance.apm.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

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
    private static String romInfo;
    public static boolean sIsInited;
    public static boolean sIsMiui;
    private static Method sSystemPropertiesGetMethod;
    private static final CharSequence SONY = "sony";
    private static final CharSequence AMIGO = "amigo";
    private static final CharSequence FUNTOUCHOS = "funtouch";

    private RomUtils() {
    }

    public static String getRomInfo() {
        if (sIsInited && !TextUtils.isEmpty(romInfo)) {
            return romInfo;
        }
        String rom = getRom();
        romInfo = rom;
        return rom;
    }

    private static String getRom() {
        if (isMiui()) {
            return getMIUIVersion();
        }
        if (isFlyme()) {
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
        if (!TextUtils.isEmpty(eUIVersion)) {
            return eUIVersion;
        }
        sIsInited = true;
        return Build.DISPLAY;
    }

    public static String get360OSVersion() {
        return getSystemProperty(KEY_360OS) + "_" + Build.DISPLAY;
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
        return isMiui() ? "miui_" + getSystemProperty("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String getEMUVersion() {
        String emuiInfo = getEmuiInfo();
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

    private static String getSystemProperty(String str) {
        String systemPropertyByReflect = getSystemPropertyByReflect(str);
        if (!TextUtils.isEmpty(systemPropertyByReflect)) {
            return systemPropertyByReflect;
        }
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            Process exec = Runtime.getRuntime().exec("getprop " + str);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader2.readLine();
                exec.destroy();
                IoUtil.safeClose(bufferedReader2);
                return str2;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                IoUtil.safeClose(bufferedReader);
                return str2;
            }
        } catch (Throwable unused2) {
        }
    }

    private static String getSystemPropertyByReflect(String str) {
        try {
            if (sSystemPropertiesGetMethod == null) {
                sSystemPropertiesGetMethod = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            }
            return (String) sSystemPropertiesGetMethod.invoke(null, str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isFlyme() {
        return Build.DISPLAY.contains("Flyme") || "flyme".equals(Build.USER);
    }

    public static boolean isHwDevice() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("hua")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith("hua")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isEmui(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getEmuiInfo();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || isHwDevice();
    }

    public static String getEmuiInfo() {
        return getSystemProperty("ro.build.version.emui");
    }

    public static String getEMUI() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, "ro.build.version.emui");
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean isMiui() {
        try {
            if (Class.forName("miui.os.Build") != null) {
                sIsMiui = true;
                return true;
            }
        } catch (Exception unused) {
        }
        return sIsMiui;
    }
}
