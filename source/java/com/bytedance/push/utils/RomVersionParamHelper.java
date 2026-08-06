package com.bytedance.push.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.standard.tools.device.DeviceUtils;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.common.util.ToolUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class RomVersionParamHelper {
    public static final String COLOROS = "coloros";
    private static final String EMPTY;
    private static final String FUNTOUCHOS = "funtouch";
    public static final String HARMONY_API_VERSION = "hw_sc.build.os.apiversion";
    private static final String HARMONY_OS_SYSTEM_VERSION = "ohos.system.version.SystemVersion";
    public static final String HARMONY_RELEASE_TYPE = "hw_sc.build.os.releasetype";
    private static final String HARMONY_UI = "harmony";
    public static final String HARMONY_VERSION = "hw_sc.build.platform.version";
    public static final String MIUI = "miui";
    private static final String OP = "oppo";
    private static final String ORIGINOS = "origin";
    public static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    public static final String RUNTIME_OP = "ro.build.version.opporom";
    public static final String RUNTIME_OPLUS = "ro.build.version.oplusrom";
    public static final String SEPARATOR = "_";
    private static final String TAG = "RomVersionParamHelper";
    private static final String VERSION_EMUI = "ro.build.version.emui";
    private static final String VERSION_MAGIC = "ro.build.version.magic";
    private static final String VV_OS_SOFTWARE_VERSION = "ro.vivo.product.version";
    private static final String VV_OS_VERSION = "ro.vivo.os.build.display.id";
    private static final JSONObject mHarmonyOsVersion;
    private static boolean mHasInitEdHarmonyOsVersion;
    private static boolean mIsHarmonyOs;
    private static String sEmuiVersion;
    private static Boolean sIsHarmonyOs;
    private static String sMagicVersion;
    private static final SystemPropertiesProxy sPropertiesProxy;
    private static String sRomVersion;

    static {
        String str;
        String valueOf = String.valueOf(Build.VERSION.SDK);
        EMPTY = valueOf;
        sPropertiesProxy = new SystemPropertiesProxy();
        sRomVersion = valueOf;
        try {
            str = getRomVersion();
        } catch (Throwable th) {
            th.printStackTrace();
            str = null;
        }
        if (StringUtils.isEmpty(str)) {
            str = EMPTY;
        }
        sRomVersion = str;
        mHarmonyOsVersion = new JSONObject();
        sIsHarmonyOs = null;
    }

    public static String getParameter() {
        return sRomVersion;
    }

    private static String getRomVersion() {
        if (isEMUI()) {
            return getEMUIVersion();
        }
        if (isMagic()) {
            return getMagicVersion();
        }
        if (isFunTouchOS()) {
            return getFuntouchOSVersion();
        }
        if (isOriginOS()) {
            return getOriginOSVersion();
        }
        if (isOpBrand()) {
            return getColorOsVersion();
        }
        if (ToolUtils.isMiui()) {
            return getMIUIVersion();
        }
        return EMPTY;
    }

    public static boolean isHwRom() {
        return isEMUI() || isHarmonyOs();
    }

    public static boolean isHonorRom() {
        return isMagic();
    }

    public static boolean isXmRom() {
        return ToolUtils.isMiui();
    }

    public static boolean isOpRom() {
        return isOpBrand();
    }

    public static boolean isVvRom() {
        return isFunTouchOS() || isOriginOS();
    }

    private static boolean isOpBrand() {
        String str = Build.MANUFACTURER;
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(OP);
    }

    private static String getColorOsVersion() {
        if (isOpBrand()) {
            String systemProperty = getSystemProperty("ro.build.version.opporom");
            if (TextUtils.isEmpty(systemProperty)) {
                systemProperty = getSystemProperty(RUNTIME_OPLUS);
            }
            return ("coloros_" + systemProperty + "_" + Build.DISPLAY).toLowerCase();
        }
        return EMPTY;
    }

    private static boolean isFunTouchOS() {
        String systemProperty = getSystemProperty(VV_OS_VERSION);
        return !StringUtils.isEmpty(systemProperty) && systemProperty.toLowerCase().contains(FUNTOUCHOS);
    }

    public static boolean isOriginOS() {
        String systemProperty = getSystemProperty(VV_OS_VERSION);
        return !StringUtils.isEmpty(systemProperty) && systemProperty.toLowerCase().contains("origin");
    }

    private static String getFuntouchOSVersion() {
        return (getSystemProperty(VV_OS_VERSION) + "_" + getSystemProperty(VV_OS_SOFTWARE_VERSION)).toLowerCase();
    }

    private static String getOriginOSVersion() {
        return (getSystemProperty(VV_OS_VERSION) + "_" + getSystemProperty(VV_OS_SOFTWARE_VERSION)).toLowerCase();
    }

    private static String getMIUIVersion() {
        return ("miui_" + getSystemProperty("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL).toLowerCase();
    }

    public static boolean isMiui12() {
        if (!ToolUtils.isMiui()) {
            return false;
        }
        try {
            return Integer.parseInt(getSystemProperty("ro.miui.ui.version.name").substring(1)) >= 12;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getSystemProperty(String str) {
        return sPropertiesProxy.get(str);
    }

    public static boolean isMagic() {
        try {
            return !TextUtils.equals(getMagicVersion(), EMPTY);
        } catch (Exception e) {
            Logger.e(e.getMessage());
            return false;
        }
    }

    public static boolean isHarmonyOs() {
        try {
            Boolean bool = sIsHarmonyOs;
            if (bool != null) {
                return bool.booleanValue();
            }
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Boolean valueOf = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            sIsHarmonyOs = valueOf;
            return valueOf.booleanValue();
        } catch (Throwable unused) {
            Logger.v("isn't harmony");
            return false;
        }
    }

    public static String getHarmonyOsVersion() {
        JSONObject jSONObject = mHarmonyOsVersion;
        synchronized (jSONObject) {
            if (!mHasInitEdHarmonyOsVersion) {
                initHarmonyOsVersion();
            }
            if (!jSONObject.keys().hasNext()) {
                return "";
            }
            return jSONObject.toString();
        }
    }

    public static boolean isGreaterThanHarmonyOs4() {
        getHarmonyOsVersion();
        try {
            String optString = mHarmonyOsVersion.optString("version", "");
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            return Integer.parseInt(optString.split("\\.")[0]) >= 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void initHarmonyOsVersion() {
        if (mHasInitEdHarmonyOsVersion) {
            return;
        }
        try {
            boolean isHarmonyOs = isHarmonyOs();
            mIsHarmonyOs = isHarmonyOs;
            if (isHarmonyOs) {
                String systemProperty = getSystemProperty(HARMONY_API_VERSION);
                String systemProperty2 = getSystemProperty(HARMONY_RELEASE_TYPE);
                String systemProperty3 = getSystemProperty(HARMONY_VERSION);
                JSONObject jSONObject = mHarmonyOsVersion;
                jSONObject.put("api_version", systemProperty);
                jSONObject.put("release_type", systemProperty2);
                jSONObject.put("version", systemProperty3);
                Log.d(TAG, "initHarmonyOsVersion: apiVersion is " + systemProperty + " releaseType is " + systemProperty2 + " version is " + systemProperty3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        mHasInitEdHarmonyOsVersion = true;
    }

    private static boolean isEMUI() {
        try {
            String systemProperty = getSystemProperty(VERSION_EMUI);
            sEmuiVersion = systemProperty;
            boolean isEmpty = StringUtils.isEmpty(systemProperty);
            if (!isEmpty) {
                if (sEmuiVersion.toLowerCase().startsWith(DeviceUtils.ROM_MAGIC)) {
                    sMagicVersion = sEmuiVersion.toLowerCase();
                    return false;
                }
                sEmuiVersion = sEmuiVersion.toLowerCase();
            }
            return !isEmpty;
        } catch (Exception e) {
            Logger.e(e.getMessage());
            return false;
        }
    }

    private static String getMagicVersion() {
        if (StringUtils.isEmpty(sMagicVersion)) {
            sMagicVersion = getSystemProperty(VERSION_EMUI);
        }
        if (StringUtils.isEmpty(sMagicVersion)) {
            sMagicVersion = getSystemProperty(VERSION_MAGIC);
        }
        if (!StringUtils.isEmpty(sMagicVersion)) {
            String lowerCase = (sMagicVersion + "_" + Build.DISPLAY).toLowerCase();
            if (!StringUtils.isEmpty(lowerCase)) {
                return lowerCase.toLowerCase();
            }
        }
        return EMPTY;
    }

    private static String getEMUIVersion() {
        if (StringUtils.isEmpty(sEmuiVersion)) {
            sEmuiVersion = getSystemProperty(VERSION_EMUI);
        }
        String lowerCase = (sEmuiVersion + "_" + Build.DISPLAY).toLowerCase();
        if (!StringUtils.isEmpty(lowerCase)) {
            return lowerCase.toLowerCase();
        }
        return EMPTY;
    }

    public static boolean isColorOS() {
        try {
            if (TextUtils.isEmpty(getSystemProperty("ro.build.version.opporom"))) {
                if (TextUtils.isEmpty(getSystemProperty(RUNTIME_OPLUS))) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
