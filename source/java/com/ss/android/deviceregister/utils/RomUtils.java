package com.ss.android.deviceregister.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.common.util.TLog;
import com.ss.android.common.util.ToolUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: classes7.dex */
public class RomUtils {
    public static final String COLOROS = "coloros";
    public static final String EMUI = "emotionui";
    private static final String EUI = "eui";
    public static final String FLYME = "flyme";
    private static final String FOUTOUCH_OS_SOFTWARE_VERSION = "ro.vivo.product.version";
    private static final String FUNTOUCH_OS_VERSION = "ro.vivo.os.build.display.id";
    private static final String HARMONY_UI = "harmony";
    private static volatile Boolean IS_GMS_INSTALLED = null;
    private static final String KEY_360OS = "ro.build.uiversion";
    private static final String MAGIC_UI = "magicui";
    public static final String MIUI = "miui";
    private static final String MODEL_LETV = "ro.letv.release.version";
    public static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    public static final String RUNTIME_OPPO = "ro.build.version.opporom";
    public static final String SEPARATOR = "_";
    private static final CharSequence SONY = "sony";
    private static final CharSequence AMIGO = "amigo";
    private static final CharSequence FUNTOUCHOS = "funtouch";
    private static final Singleton<Boolean> sIsHarmony = new Singleton<Boolean>() { // from class: com.ss.android.deviceregister.utils.RomUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ss.android.deviceregister.utils.Singleton
        public Boolean create(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return false;
            }
        }
    };

    public static boolean isGmsInstalled(Context context) {
        return false;
    }

    public static String getRomInfo() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (ToolUtils.isMiui()) {
            return getMIUIVersion();
        }
        if (ToolUtils.isFlyme()) {
            return getFlymeVersion();
        }
        if (isColorOS()) {
            return getColorOsVersion();
        }
        String eMUVersion = getEMUVersion();
        if (!TextUtils.isEmpty(eMUVersion)) {
            return eMUVersion;
        }
        if (isVIVO()) {
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
        return Build.DISPLAY;
    }

    private static boolean isVIVO() {
        try {
            return !TextUtils.isEmpty((String) SystemPropertiesWithCache.get(FUNTOUCH_OS_VERSION));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String get360OSVersion() {
        return getSystemProperty(KEY_360OS) + "_" + Build.DISPLAY;
    }

    public static boolean is360OS() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String getFuntouchOSVersion() {
        return SystemPropertiesWithCache.get(FUNTOUCH_OS_VERSION) + "_" + SystemPropertiesWithCache.get(FOUTOUCH_OS_SOFTWARE_VERSION);
    }

    @Deprecated
    public static boolean isFunTouchOS() {
        String systemProperty = getSystemProperty(FUNTOUCH_OS_VERSION);
        return !StringUtils.isEmpty(systemProperty) && systemProperty.toLowerCase().contains(FUNTOUCHOS);
    }

    public static boolean isAmigo() {
        return !StringUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(AMIGO);
    }

    public static boolean isHwOrHonor(String str) {
        if (TextUtils.isEmpty(str)) {
            str = ToolUtils.getEmuiInfo();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains(MAGIC_UI))) || isHuaweiDevice() || isHonorDevice();
    }

    public static String getAmigoVersion() {
        return Build.DISPLAY + "_" + getSystemProperty("ro.gn.sv.version");
    }

    public static String getEUIVersion() {
        return isEUI() ? "eui_" + getSystemProperty(MODEL_LETV) + "_" + Build.DISPLAY : "";
    }

    public static boolean isEUI() {
        return !StringUtils.isEmpty(getSystemProperty(MODEL_LETV));
    }

    public static boolean isHuaweiDevice() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
    }

    public static boolean isHonorDevice() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("honor")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean hasHWVersion() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                TLog.d("Honor# oldHonor device, version is" + str);
                return true;
            }
        } catch (Exception e) {
            TLog.e("Honor# " + e.getMessage(), e);
        }
        return false;
    }

    public static boolean isSony() {
        String str = Build.BRAND + Build.MANUFACTURER;
        return !StringUtils.isEmpty(str) || str.toLowerCase().contains(SONY);
    }

    public static String getMIUIVersion() {
        return ToolUtils.isMiui() ? "miui_" + getSystemProperty("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String getEMUVersion() {
        String emuiInfo = ToolUtils.getEmuiInfo();
        return emuiInfo != null ? (emuiInfo.toLowerCase().contains("emotionui") || emuiInfo.toLowerCase().contains(MAGIC_UI)) ? emuiInfo + "_" + Build.DISPLAY : "" : "";
    }

    public static String getFlymeVersion() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean isColorOS() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo");
    }

    public static String getColorOsVersion() {
        return isColorOS() ? "coloros_" + getSystemProperty("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    private static String getSystemProperty(String str) {
        Process exec;
        BufferedReader bufferedReader;
        String str2 = "";
        BufferedReader bufferedReader2 = null;
        try {
            exec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
        } catch (Throwable th) {
            th = th;
        }
        try {
            str2 = bufferedReader.readLine();
            exec.destroy();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                TLog.e("Exception while closing InputStream", e);
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            try {
                TLog.e("Unable to read sysprop " + str, th);
                return str2;
            } finally {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e2) {
                        TLog.e("Exception while closing InputStream", e2);
                    }
                }
            }
        }
    }

    public static boolean isMeizu() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean isOnePlus() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isSamsung() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isZTE() {
        return getManufacturer().toUpperCase().contains(com.ss.android.socialbase.appdownloader.util.RomUtils.ROM_ZTE);
    }

    private static String getManufacturer() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean isLenovo() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String systemProperty = getSystemProperty("ro.build.version.incremental");
        return !TextUtils.isEmpty(systemProperty) && systemProperty.contains("VIBEUI_V2");
    }

    public static boolean isNubia() {
        return getManufacturer().toUpperCase().contains(com.ss.android.socialbase.appdownloader.util.RomUtils.ROM_NUBIA);
    }

    public static boolean isASUS() {
        return getManufacturer().toUpperCase().contains("ASUS");
    }

    public static boolean isHarmonyUI() {
        return sIsHarmony.get(new Object[0]).booleanValue();
    }

    public static boolean isTargetROrHigher(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 30;
    }

    public static boolean isAndroidROrHigher() {
        return Build.VERSION.SDK_INT >= 30 || (Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }

    public static boolean isAndroidQOrHigher() {
        return Build.VERSION.SDK_INT >= 29 || (Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }

    public static boolean isTargetQOrHigher(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 29;
    }
}
