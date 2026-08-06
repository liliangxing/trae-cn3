package com.bytedance.common.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.common.util.HoneyCombMR2V13Compat;
import com.bytedance.common.utility.device.SystemPropertiesUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.huawei.hms.android.SystemUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

@Deprecated
/* loaded from: classes3.dex */
public final class DeviceUtils {
    private static final int DEFAULT_CACHE_SIZE = 1024;
    private static final String IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW = "navigationbar_is_min";
    private static final String IMMERSION_MIUI_NAVIGATION_BAR_HIDE_SHOW = "force_fsg_nav_bar";
    static final String IMMERSION_NAVIGATION_BAR_HEIGHT = "navigation_bar_height";
    private static final String KEY_SYSTEM_PROPERTIES_CACHE = "system_properties_cache";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    private static final String KEY_VERSION_LENOVO = "ro.lenovo.lvp.version";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_GIONEE = "QIONEE";
    public static final String ROM_LENOVO = "LENOVO";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SAMSUNG = "samsung";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    public static final String ROM_ZTE = "zte";
    private static final String TAG = "DeviceUtils";
    public static boolean deviceDataHasInit = false;
    public static int displayMetricsHeightPixels = 0;
    public static int displayMetricsWidthPixels = 0;
    private static Boolean isCoolpad = null;
    private static Boolean isEmui = null;
    private static int mIsFoldableScreen = -1;
    private static int sEmuiLevel = -1;
    private static boolean sIsMiui;
    private static boolean sIsMiuiInited;
    private static String sMiuiVersion;
    private static String sName;
    private static int sStatusBarHeight;
    private static String sVersion;
    private static final Map<String, String> SYSTEM_PROPERTIES_CACHE = new HashMap();
    private static volatile Properties properties = null;

    private static String com_bytedance_common_utility_DeviceUtils_android_net_wifi_WifiInfo_getMacAddress(WifiInfo wifiInfo) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String macAddress = wifiInfo.getMacAddress();
        heliosApiHook.postInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, macAddress, extraInfo, true);
        return macAddress;
    }

    private static String com_bytedance_common_utility_DeviceUtils_android_telephony_TelephonyManager_getDeviceId(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String deviceId = telephonyManager.getDeviceId();
        heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, deviceId, extraInfo, true);
        return deviceId;
    }

    private DeviceUtils() {
    }

    public static boolean isEmui() {
        Boolean bool = isEmui;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, KEY_VERSION_EMUI);
            if ((invoke instanceof String) && !StringUtils.isEmpty((String) invoke)) {
                if (!"unknown".equals((String) invoke)) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        isEmui = Boolean.valueOf(z);
        return z;
    }

    public static boolean isCoolpad() {
        Boolean bool = isCoolpad;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str)) {
            isCoolpad = Boolean.valueOf(str.toLowerCase(Locale.getDefault()).contains("coolpad"));
        } else {
            isCoolpad = false;
        }
        return isCoolpad.booleanValue();
    }

    public static boolean isWifiProxy(Context context) {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
    }

    public static boolean isInstallXposed() {
        try {
            throw new Exception("hook");
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().contains("de.robv.android.xposed")) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void setNoScreenCap(Activity activity) {
        activity.getWindow().setFlags(8192, 8192);
    }

    private static boolean checkHuaweiFoldableList(String str) {
        return TextUtils.equals(str, "HWTAH") || TextUtils.equals(str, "unknownRLI") || TextUtils.equals(str, "unknownRHA") || TextUtils.equals(str, "HWTAH-C") || TextUtils.equals(str, "unknownTXL");
    }

    private static boolean isHwFoldableDevice(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager() != null) {
                return context.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture");
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static boolean checkHonorFoldableList(String str) {
        return "DIA-AN00".equalsIgnoreCase(str) || "MGI-AN00".equalsIgnoreCase(str);
    }

    private static boolean isHonorFoldableDevice(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager() != null) {
                return context.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture");
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static boolean checkSamsungFoldableList() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("SM-F9") || str.startsWith("SM-W202") || str.startsWith("SM-W90");
    }

    public static boolean isFoldableScreen() {
        int i = mIsFoldableScreen;
        if (i > -1) {
            return i > 0;
        }
        mIsFoldableScreen = 0;
        if (isSamsung() && checkSamsungFoldableList()) {
            mIsFoldableScreen = 1;
        } else if (isHuawei() && checkHuaweiFoldableList(Build.DEVICE)) {
            mIsFoldableScreen = 1;
        }
        return mIsFoldableScreen > 0;
    }

    public static boolean isFoldableScreenV2(Context context) {
        int i = mIsFoldableScreen;
        if (i > -1) {
            return i > 0;
        }
        mIsFoldableScreen = 0;
        if (isSamsung() && checkSamsungFoldableList()) {
            mIsFoldableScreen = 1;
        } else if (isHuawei() && (checkHuaweiFoldableList(Build.DEVICE) || isHwFoldableDevice(context))) {
            mIsFoldableScreen = 1;
        } else if (context.getPackageManager().hasSystemFeature("oplus.feature.largescreen")) {
            mIsFoldableScreen = 1;
        } else if (isHonor() && (checkHonorFoldableList(Build.DEVICE) || isHonorFoldableDevice(context))) {
            mIsFoldableScreen = 1;
        }
        return mIsFoldableScreen > 0;
    }

    public static boolean isMiui() {
        if (!sIsMiuiInited) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    sIsMiui = true;
                }
            } catch (Exception unused) {
            }
            sIsMiuiInited = true;
        }
        return sIsMiui;
    }

    public static void setMiuiStatusBarDarkMode(boolean z, Window window) {
        try {
            Class<?> cls = window.getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean isMiuiV6() {
        initMiuiVersion();
        return "V6".equals(sMiuiVersion);
    }

    public static boolean isMiuiV7() {
        initMiuiVersion();
        return "V7".equals(sMiuiVersion);
    }

    public static boolean isMiuiV8() {
        initMiuiVersion();
        return "V8".equals(sMiuiVersion);
    }

    public static boolean isMiuiV9() {
        initMiuiVersion();
        return "V9".equals(sMiuiVersion);
    }

    private static void initMiuiVersion() {
        if (sMiuiVersion == null) {
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    sMiuiVersion = getSystemProperty("ro.miui.ui.version.name");
                } else {
                    sMiuiVersion = getProperty("ro.miui.ui.version.name");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String str = sMiuiVersion;
            if (str == null) {
                str = "";
            }
            sMiuiVersion = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getEmuiLevel() {
        String property;
        FileInputStream fileInputStream;
        int i = sEmuiLevel;
        if (i > -1) {
            return i;
        }
        sEmuiLevel = 0;
        if (Build.VERSION.SDK_INT >= 29) {
            property = getSystemProperty("ro.build.hw_emui_api_level");
        } else {
            Properties properties2 = new Properties();
            File file = new File(Environment.getRootDirectory(), "build.prop");
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e) {
                    e = e;
                }
                try {
                    properties2.load(fileInputStream);
                    fileInputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (!properties2.containsKey("ro.build.hw_emui_api_level")) {
                    }
                    sEmuiLevel = Integer.parseInt(property);
                    return sEmuiLevel;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            property = !properties2.containsKey("ro.build.hw_emui_api_level") ? properties2.getProperty("ro.build.hw_emui_api_level") : "0";
        }
        try {
            sEmuiLevel = Integer.parseInt(property);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return sEmuiLevel;
    }

    public static boolean isHuawei() {
        return Build.MANUFACTURER != null && Build.MANUFACTURER.toUpperCase(Locale.getDefault()).contains(SystemUtils.PRODUCT_HUAWEI);
    }

    public static boolean isSumsungV4_4_4() {
        if (!isSamsung()) {
            return false;
        }
        if (Build.VERSION.RELEASE.startsWith("4.4.4")) {
            return true;
        }
        return Build.VERSION.RELEASE.startsWith("4.4.2") && Build.DEVICE.startsWith("klte");
    }

    public static boolean isSumsungV5() {
        return isSamsung();
    }

    public static boolean isSumsungCorePrime() {
        return isSamsung() && Build.DISPLAY.contains("G3608ZMU1AOA4");
    }

    public static boolean isFlyme() {
        return Build.DISPLAY.startsWith("Flyme");
    }

    public static boolean isFlyme2() {
        return Build.DISPLAY.startsWith("Flyme 2");
    }

    public static boolean isFlyme4() {
        return Build.DISPLAY.startsWith("Flyme OS 4");
    }

    public static boolean isFlyme5() {
        return Build.DISPLAY.startsWith("Flyme 5");
    }

    public static boolean isFlyme6() {
        return Build.DISPLAY.startsWith("Flyme 6");
    }

    public static boolean isFlyme7() {
        return Build.DISPLAY.startsWith("Flyme 7");
    }

    public static boolean isOnePlusLOLLIPOP() {
        return Build.BRAND.equals(RomUtils.ROM_ONEPLUS);
    }

    public static boolean isSamsung() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isLG() {
        return ("lge".equalsIgnoreCase(Build.BRAND) || "lge".equalsIgnoreCase(Build.MANUFACTURER)) && Build.MODEL != null && Build.MODEL.toLowerCase(Locale.getDefault()).contains("lg");
    }

    public static boolean isMeizuMx3() {
        if (isMeizu()) {
            return "mx3".equalsIgnoreCase(Build.DEVICE);
        }
        return false;
    }

    public static boolean isHtcOs() {
        return Build.BRAND != null && Build.BRAND.toLowerCase(Locale.getDefault()).contains("htc") && Build.MANUFACTURER != null && Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains("htc") && Build.MODEL != null && Build.MODEL.toLowerCase(Locale.getDefault()).contains("htc");
    }

    public static boolean isMeizu() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase(Locale.ENGLISH).indexOf("meizu") > -1;
    }

    public static boolean isVivo() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains("vivo")) {
            return true;
        }
        String str2 = Build.MODEL;
        if (!TextUtils.isEmpty(str2) && str2.toLowerCase(Locale.getDefault()).contains("vivo")) {
            return true;
        }
        String str3 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str3) && str3.toLowerCase(Locale.getDefault()).contains("vivo");
    }

    public static boolean isHonor() {
        return Build.MANUFACTURER != null && Build.MANUFACTURER.toUpperCase(Locale.getDefault()).contains("HONOR");
    }

    public static boolean isOppo() {
        return check("OPPO");
    }

    public static boolean isQiku() {
        return check("QIKU") || check("360");
    }

    public static boolean isSmartisan() {
        return check("SMARTISAN");
    }

    public static String getName() {
        if (sName == null) {
            check("");
        }
        return sName;
    }

    public static String getVersion() {
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean check(String str) {
        String str2 = sName;
        if (str2 != null) {
            return str2.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        sVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sName = "MIUI";
        } else {
            String prop2 = getProp(KEY_VERSION_EMUI);
            sVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sName = "EMUI";
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                sVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sName = "OPPO";
                } else {
                    String prop4 = getProp(KEY_VERSION_VIVO);
                    sVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sName = "VIVO";
                    } else {
                        String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sName = "SMARTISAN";
                        } else {
                            String prop6 = getProp(KEY_VERSION_GIONEE);
                            sVersion = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                sName = "QIONEE";
                            } else {
                                String prop7 = getProp(KEY_VERSION_LENOVO);
                                sVersion = prop7;
                                if (!TextUtils.isEmpty(prop7)) {
                                    sName = "LENOVO";
                                } else if (getManufacturer().toLowerCase(Locale.getDefault()).contains("samsung")) {
                                    sName = "samsung";
                                } else if (getManufacturer().toLowerCase(Locale.getDefault()).contains("zte")) {
                                    sName = "zte";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    sVersion = str3;
                                    if (str3.toUpperCase(Locale.getDefault()).contains("FLYME")) {
                                        sName = "FLYME";
                                    } else {
                                        sVersion = "unknown";
                                        sName = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sName.equals(str);
    }

    public static String getProp(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream(), "UTF-8"), 1024);
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return readLine;
        } catch (IOException unused2) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static String getSystemPropertyInSp(Context context, String str) {
        String str2;
        Map<String, String> map = SYSTEM_PROPERTIES_CACHE;
        synchronized (map) {
            str2 = map.get(str);
            if (StringUtils.isEmpty(str2)) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_SYSTEM_PROPERTIES_CACHE, 0);
                    str2 = sharedPreferences.getString(str, null);
                    if (StringUtils.isEmpty(str2)) {
                        str2 = getSystemProperty(str);
                        if (!StringUtils.isEmpty(str2)) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(str, str2);
                            edit.apply();
                        }
                    }
                } catch (Exception e) {
                    Logger.e(TAG, "getSystemProperties in sp error", e);
                }
            }
        }
        return str2;
    }

    public static String getSystemProperty(String str) {
        return SystemPropertiesUtils.getSystemProperty(str);
    }

    public static double getEmuiVersion() {
        try {
            String systemProperty = getSystemProperty(KEY_VERSION_EMUI);
            return Double.parseDouble(systemProperty.substring(systemProperty.indexOf("_") + 1));
        } catch (Exception e) {
            e.printStackTrace();
            return 4.0d;
        }
    }

    public static boolean hasSmartBar() {
        if (!isMeizu()) {
            return false;
        }
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) ? false : true;
        }
    }

    public static boolean hasVirtualButtons(Context context) {
        return !ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public static String getDeviceId(Context context) {
        String com_bytedance_common_utility_DeviceUtils_android_telephony_TelephonyManager_getDeviceId = com_bytedance_common_utility_DeviceUtils_android_telephony_TelephonyManager_getDeviceId((TelephonyManager) context.getSystemService("phone"));
        return (TextUtils.isEmpty(com_bytedance_common_utility_DeviceUtils_android_telephony_TelephonyManager_getDeviceId) || "000000000000000".equals(com_bytedance_common_utility_DeviceUtils_android_telephony_TelephonyManager_getDeviceId)) ? com_bytedance_common_utility_DeviceUtils_android_net_wifi_WifiInfo_getMacAddress(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo()) : com_bytedance_common_utility_DeviceUtils_android_telephony_TelephonyManager_getDeviceId;
    }

    public static boolean isLenovo() {
        return "lenovo".equalsIgnoreCase(Build.BRAND) || "lenovo".equalsIgnoreCase(Build.MANUFACTURER) || "motorola".equalsIgnoreCase(Build.BRAND) || "motorola".equalsIgnoreCase(Build.MANUFACTURER);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getTotalMemory() {
        Throwable th;
        BufferedReader bufferedReader;
        Exception e;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            try {
                try {
                    long parseInt = Integer.parseInt(bufferedReader.readLine().split("\\s+")[1]) * 1024;
                    try {
                        bufferedReader.close();
                        return parseInt;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return parseInt;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return 0L;
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public static int getStatusBarHeight(Context context) {
        int i = sStatusBarHeight;
        if (i > 0) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        if (dimensionPixelSize == 0) {
            dimensionPixelSize = (int) UIUtils.dip2Px(context, 25.0f);
        }
        sStatusBarHeight = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static void initDeviceData(Context context) {
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation == 1 || orientation == 3) {
            displayMetricsWidthPixels = displayMetrics.heightPixels;
            displayMetricsHeightPixels = displayMetrics.widthPixels;
        } else {
            displayMetricsWidthPixels = displayMetrics.widthPixels;
            displayMetricsHeightPixels = displayMetrics.heightPixels;
        }
        deviceDataHasInit = true;
    }

    public static int getEquipmentWidth(Context context) {
        if (!deviceDataHasInit || isFoldableScreenV2(context)) {
            initDeviceData(context);
        }
        return displayMetricsWidthPixels;
    }

    public static int getEquipmentHeight(Context context) {
        if (!deviceDataHasInit || isFoldableScreenV2(context)) {
            initDeviceData(context);
        }
        return displayMetricsHeightPixels;
    }

    public static boolean isLargeScreenPad(Context context, int i, int i2) {
        if (isFoldableScreenV2(context)) {
            return false;
        }
        Resources resources = context.getResources();
        return i >= resources.getDimensionPixelSize(R.dimen.mohist_utility_large_pad_min_width) && i2 >= resources.getDimensionPixelSize(R.dimen.mohist_utility_large_pad_min_height);
    }

    public static boolean isLargeScreenPad(Display display, Context context) {
        Point point = new Point();
        HoneyCombMR2V13Compat.getDisplaySize(display, point);
        return isLargeScreenPad(context, point.x, point.y);
    }

    public static boolean isPad(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return false;
        }
        return "tablet".equals(getDeviceType(context));
    }

    public static boolean isPad(Context context, Resources resources) {
        if (context == null || resources == null || resources.getConfiguration() == null) {
            return false;
        }
        return "tablet".equals(getDeviceType(context));
    }

    public static boolean isHuawei_Os_3x() {
        if (!isHuawei()) {
            return false;
        }
        String systemProperty = getSystemProperty(KEY_VERSION_EMUI);
        return "EmotionUI 3".equals(systemProperty) || "EmotionUI_3.1".contains(systemProperty) || "EmotionUI_3.0".contains(systemProperty);
    }

    public static int getNavigationBarHeight(Context context) {
        if (hasNavBar((Activity) context)) {
            return getInternalDimensionSize(context, IMMERSION_NAVIGATION_BAR_HEIGHT);
        }
        return 0;
    }

    public static boolean hasNavBar(Activity activity) {
        if (Settings.Global.getInt(activity.getContentResolver(), IMMERSION_MIUI_NAVIGATION_BAR_HIDE_SHOW, 0) != 0) {
            return false;
        }
        if (isEmui()) {
            if (isHuawei_Os_3x()) {
                if (Settings.System.getInt(activity.getContentResolver(), IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW, 0) != 0) {
                    return false;
                }
            } else if (Settings.Global.getInt(activity.getContentResolver(), IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW, 0) != 0) {
                return false;
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }

    public static int getInternalDimensionSize(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                return Math.round((dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    private static String getDeviceType(Context context) {
        String systemPropertyInSp = getSystemPropertyInSp(context, "ro.build.characteristics");
        return (TextUtils.isEmpty(systemPropertyInSp) || !systemPropertyInSp.equals("tablet")) ? "phone" : systemPropertyInSp;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation == 1 || orientation == 3) {
            return displayMetrics.heightPixels;
        }
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation == 1 || orientation == 3) {
            return displayMetrics.widthPixels;
        }
        return displayMetrics.heightPixels;
    }

    @Deprecated
    private static String getProperty(String str) throws IOException {
        if (properties == null) {
            synchronized (DeviceUtils.class) {
                if (properties == null) {
                    properties = new Properties();
                    properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
                }
            }
        }
        return properties.getProperty(str);
    }
}
