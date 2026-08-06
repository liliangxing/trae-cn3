package com.bytedance.bdinstall.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.huawei.hms.android.SystemUtils;
import java.util.Locale;

/* loaded from: classes3.dex */
public class RomUtils {
    public static final String COLOROS = "coloros";
    public static final String EMUI = "emotionui";
    private static final String EUI = "eui";
    public static final String FLYME = "flyme";
    private static final String FOUTOUCH_OS_SOFTWARE_VERSION = "ro.vivo.product.version";
    private static final String FUNTOUCH_OS_VERSION = "ro.vivo.os.build.display.id";
    private static final String HARMONY_UI = "harmony";
    private static final String KEY_360OS = "ro.build.uiversion";
    private static final String MAGIC_UI = "magicui";
    public static final String MIUI = "miui";
    private static final String MODEL_LETV = "ro.letv.release.version";
    public static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    public static final String RUNTIME_OPPO = "ro.build.version.opporom";
    public static final String SEPARATOR = "_";
    private static final CharSequence SONY = "sony";
    private static final CharSequence AMIGO = "amigo";
    private static final Singleton<Boolean> sIsHarmony = new Singleton<Boolean>() { // from class: com.bytedance.bdinstall.util.RomUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public Boolean create(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                DrLog.v("isn't harmony");
                return false;
            }
        }
    };

    public static String getEmuiInfo() {
        return getSystemPropertyV2("ro.build.version.emui");
    }

    public static String getRomInfo() {
        if (isMiui()) {
            return getMIUIVersion();
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
        if (isFlyme()) {
            return getFlymeVersion();
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

    public static String getProductName() {
        String systemProperty = getSystemProperty("persist.pxr.product.forcename", "");
        if (TextUtils.isEmpty(systemProperty)) {
            systemProperty = getSystemProperty("pxr.vendorhw.product.name", "");
        }
        return TextUtils.isEmpty(systemProperty) ? Build.PRODUCT : systemProperty;
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String get360OSVersion() {
        return getSystemPropertyV2(KEY_360OS) + "_" + Build.DISPLAY;
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
        return getSystemPropertyV2(FUNTOUCH_OS_VERSION) + "_" + getSystemPropertyV2(FOUTOUCH_OS_SOFTWARE_VERSION);
    }

    public static boolean isHwOrHonor(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getEmuiInfo();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains(MAGIC_UI))) || isHuaweiDevice() || isHonorDevice();
    }

    public static boolean isFlyme() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean isVIVO() {
        return !TextUtils.isEmpty(getSystemPropertyV2(FUNTOUCH_OS_VERSION));
    }

    public static boolean isAmigo() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(AMIGO);
    }

    public static String getAmigoVersion() {
        return Build.DISPLAY + "_" + getSystemPropertyV2("ro.gn.sv.version");
    }

    public static String getEUIVersion() {
        return isEUI() ? "eui_" + getSystemPropertyV2(MODEL_LETV) + "_" + Build.DISPLAY : "";
    }

    public static boolean isEUI() {
        return !TextUtils.isEmpty(getSystemPropertyV2(MODEL_LETV));
    }

    private static boolean isHuaweiDevice() {
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
                DrLog.d("honor# oldHonor device, version is" + str);
                return true;
            }
        } catch (Exception e) {
            DrLog.e("Honor# " + e.getMessage(), e);
        }
        return false;
    }

    public static boolean isMiui() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getMIUIVersion() {
        return isMiui() ? "miui_" + getSystemPropertyV2("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static boolean isSony() {
        String str = Build.BRAND + Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) || str.toLowerCase().contains(SONY);
    }

    public static String getEMUVersion() {
        String emuiInfo = getEmuiInfo();
        return emuiInfo != null ? (emuiInfo.toLowerCase().contains("emotionui") || emuiInfo.toLowerCase().contains(MAGIC_UI)) ? emuiInfo + "_" + Build.DISPLAY : "" : "";
    }

    public static String getFlymeVersion() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean isColorOS() {
        return "oppo".equalsIgnoreCase(Build.MANUFACTURER) || "oppo".equalsIgnoreCase(Build.BRAND) || "realme".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean isXiaomi() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI");
    }

    public static boolean isBlackShark() {
        return "BlackShark".equalsIgnoreCase(Build.MANUFACTURER) || "BlackShark".equalsIgnoreCase(Build.BRAND);
    }

    public static String getColorOsVersion() {
        return isColorOS() ? "coloros_" + getSystemPropertyV2("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    private static String getSystemPropertyV2(String str) {
        return (String) SystemPropertiesWithCache.get(str);
    }

    public static boolean isMeizu() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean isOnePlus() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER) || "OnePlus".equalsIgnoreCase(Build.BRAND);
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
        String systemPropertyV2 = getSystemPropertyV2("ro.build.version.incremental");
        return !TextUtils.isEmpty(systemPropertyV2) && systemPropertyV2.contains("VIBEUI_V2");
    }

    public static boolean isNubia() {
        return getManufacturer().toUpperCase().contains(com.ss.android.socialbase.appdownloader.util.RomUtils.ROM_NUBIA);
    }

    public static boolean isASUS() {
        return getManufacturer().toUpperCase().contains("ASUS");
    }

    public static boolean isHuawei() {
        return SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER);
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
