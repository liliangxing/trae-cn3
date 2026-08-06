package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes7.dex */
public class RomUtils {
    public static final String BRAND_HONOR = "honor";
    public static final String BRAND_HUAWEI = "huawei";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    private static final String KEY_VERSION_LENOVO = "ro.lenovo.lvp.version";
    private static final String KEY_VERSION_MAGICUI = "ro.build.version.magic";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_ONEPLUS = "ro.rom.version";
    private static String KEY_VERSION_OPPO = "";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String MARKET_PKG_NAME_EMUI = "com.huawei.appmarket";
    public static final String MARKET_PKG_NAME_GIONEE = "com.gionee.aora.market";
    public static final String MARKET_PKG_NAME_LENOVO = "com.lenovo.leos.appstore";
    public static final String MARKET_PKG_NAME_MAGICUI = "com.hihonor.appmarket";
    public static final String MARKET_PKG_NAME_MEIZU = "com.meizu.mstore";
    public static final String MARKET_PKG_NAME_MIUI = "com.xiaomi.market";
    public static final String MARKET_PKG_NAME_NUBIA = "cn.nubia.neostore";
    public static String MARKET_PKG_NAME_OPPO = "";
    public static final String MARKET_PKG_NAME_OPPO1 = "com.heytap.market";
    public static final String MARKET_PKG_NAME_QIKU = "";
    public static final String MARKET_PKG_NAME_SAMSUNG = "com.sec.android.app.samsungapps";
    public static final String MARKET_PKG_NAME_SMARTISAN = "com.smartisanos.appstore";
    public static final String MARKET_PKG_NAME_VIVO = "com.bbk.appstore";
    public static final String MARKET_PKG_NAME_ZTE = "zte.com.market";
    public static final String OS_ANDROID = "android";
    public static final String OS_HARMONY = "harmony";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_GIONEE = "QIONEE";
    public static final String ROM_LENOVO = "LENOVO";
    public static final String ROM_MAGICUI = "MAGICUI";
    public static final String ROM_MEIZU = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_NUBIA = "NUBIA";
    public static final String ROM_ONEPLUS = "ONEPLUS";
    public static String ROM_OPPO = null;
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SAMSUNG = "SAMSUNG";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    public static final String ROM_ZTE = "ZTE";
    public static String sMarketPackageName;
    private static String sMiuiVersion;
    private static String sName;
    private static String sPackageInstaller;
    private static String sVersion;
    public static final String PACKAGE_INSTALLER_GOOGLE = "com.google.android.packageinstaller";
    public static final String PACKAGE_INSTALLER_ANDROID = "com.android.packageinstaller";
    public static final String PACKAGE_INSTALLER_SAMSUNG = "com.samsung.android.packageinstaller";
    public static final String PACKAGE_INSTALLER_XIAOMI = "com.miui.packageinstaller";
    public static final String[] PACKAGE_INSTALLERS = {PACKAGE_INSTALLER_GOOGLE, PACKAGE_INSTALLER_ANDROID, PACKAGE_INSTALLER_SAMSUNG, PACKAGE_INSTALLER_XIAOMI};
    private static Boolean isHarmony = null;

    public static boolean isEmui() {
        return check("EMUI") || check(ROM_MAGICUI);
    }

    public static boolean isMagicui() {
        return check(ROM_MAGICUI);
    }

    public static boolean isMiui() {
        return check("MIUI");
    }

    public static boolean isVivo() {
        return check("VIVO");
    }

    public static boolean isOppo() {
        ensureOPPO();
        return check(ROM_OPPO);
    }

    public static boolean isFlyme() {
        return check("FLYME");
    }

    public static boolean isQiku() {
        return check("QIKU") || check("360");
    }

    public static boolean isSmartisan() {
        return check("SMARTISAN");
    }

    public static boolean isGionee() {
        return check("QIONEE");
    }

    public static boolean isSamsung() {
        return check("SAMSUNG");
    }

    public static boolean isLenovo() {
        return check("LENOVO");
    }

    public static boolean isZTE() {
        return check(ROM_ZTE);
    }

    public static boolean isNubia() {
        return check(ROM_NUBIA);
    }

    public static boolean isOnePlus() {
        return check(ROM_ONEPLUS);
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

    public static String getMarketPackageName() {
        if (sMarketPackageName == null) {
            check("");
        }
        return sMarketPackageName;
    }

    public static String getSysPackageInstaller(Context context) {
        if (TextUtils.isEmpty(sPackageInstaller)) {
            sPackageInstaller = getValidPackageInstaller(context);
        }
        return sPackageInstaller;
    }

    public static String getOs() {
        return isHarmony() ? OS_HARMONY : "android";
    }

    private static void ensureOPPO() {
        if (TextUtils.isEmpty(ROM_OPPO)) {
            DownloadComponentManager.ensureOPPO();
            ROM_OPPO = DownloadConstants.UPPER_OPPO;
            KEY_VERSION_OPPO = "ro.build.version." + DownloadConstants.LOWER_OPPO + Api.KEY_ROM;
            MARKET_PKG_NAME_OPPO = "com." + DownloadConstants.LOWER_OPPO + ".market";
        }
    }

    public static boolean check(String str) {
        ensureOPPO();
        String str2 = sName;
        if (str2 != null) {
            return str2.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        sVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sName = "MIUI";
            sMarketPackageName = "com.xiaomi.market";
            sMiuiVersion = sVersion;
        } else {
            String prop2 = getProp(KEY_VERSION_EMUI);
            sVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                String str3 = isHonorDevice() ? ROM_MAGICUI : "EMUI";
                sName = str3;
                if (TextUtils.equals(str3, ROM_MAGICUI)) {
                    sMarketPackageName = MARKET_PKG_NAME_MAGICUI;
                } else {
                    sMarketPackageName = "com.huawei.appmarket";
                }
            } else {
                String prop3 = getProp(KEY_VERSION_MAGICUI);
                sVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sName = ROM_MAGICUI;
                    sMarketPackageName = MARKET_PKG_NAME_MAGICUI;
                } else {
                    String prop4 = getProp(KEY_VERSION_OPPO);
                    sVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sName = ROM_OPPO;
                        if (AppUtils.getAppVersionCode(MARKET_PKG_NAME_OPPO) > -1) {
                            sMarketPackageName = MARKET_PKG_NAME_OPPO;
                        } else {
                            sMarketPackageName = "com.heytap.market";
                        }
                    } else {
                        String prop5 = getProp(KEY_VERSION_VIVO);
                        sVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sName = "VIVO";
                            sMarketPackageName = "com.bbk.appstore";
                        } else {
                            String prop6 = getProp(KEY_VERSION_SMARTISAN);
                            sVersion = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                sName = "SMARTISAN";
                                sMarketPackageName = MARKET_PKG_NAME_SMARTISAN;
                            } else {
                                String prop7 = getProp(KEY_VERSION_GIONEE);
                                sVersion = prop7;
                                if (!TextUtils.isEmpty(prop7)) {
                                    sName = "QIONEE";
                                    sMarketPackageName = MARKET_PKG_NAME_GIONEE;
                                } else {
                                    String prop8 = getProp(KEY_VERSION_LENOVO);
                                    sVersion = prop8;
                                    if (!TextUtils.isEmpty(prop8)) {
                                        sName = "LENOVO";
                                        sMarketPackageName = MARKET_PKG_NAME_LENOVO;
                                    } else if (getManufacturer().toUpperCase().contains("SAMSUNG")) {
                                        sName = "SAMSUNG";
                                        sMarketPackageName = "com.sec.android.app.samsungapps";
                                    } else if (getManufacturer().toUpperCase().contains(ROM_ZTE)) {
                                        sName = ROM_ZTE;
                                        sMarketPackageName = MARKET_PKG_NAME_ZTE;
                                    } else if (getManufacturer().toUpperCase().contains(ROM_NUBIA)) {
                                        sName = ROM_NUBIA;
                                        sMarketPackageName = MARKET_PKG_NAME_NUBIA;
                                    } else if (getDisplay().toUpperCase().contains("FLYME")) {
                                        sName = "FLYME";
                                        sMarketPackageName = MARKET_PKG_NAME_MEIZU;
                                        sVersion = getDisplay();
                                    } else if (getManufacturer().toUpperCase().contains(ROM_ONEPLUS)) {
                                        sName = ROM_ONEPLUS;
                                        sVersion = getProp(KEY_VERSION_ONEPLUS);
                                        if (AppUtils.getAppVersionCode(MARKET_PKG_NAME_OPPO) > -1) {
                                            sMarketPackageName = MARKET_PKG_NAME_OPPO;
                                        } else {
                                            sMarketPackageName = "com.heytap.market";
                                        }
                                    } else {
                                        sName = getManufacturer().toUpperCase();
                                        sMarketPackageName = "";
                                        sVersion = "";
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

    public static String getPropByCmd(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            DownloadUtils.safeClose(bufferedReader);
            return readLine;
        } catch (Throwable unused2) {
            DownloadUtils.safeClose(bufferedReader);
            return null;
        }
    }

    public static String getPropByReflect(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String getProp(String str) {
        try {
            return getPropByReflect(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return getPropByCmd(str);
        }
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static String getDisplay() {
        return Build.DISPLAY == null ? "" : Build.DISPLAY.trim();
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

    public static boolean isMiuiV10() {
        initMiuiVersion();
        return "V10".equals(sMiuiVersion);
    }

    public static boolean isMiuiV11() {
        initMiuiVersion();
        return "V11".equals(sMiuiVersion);
    }

    public static boolean isMiuiV12() {
        initMiuiVersion();
        return "V12".equals(sMiuiVersion);
    }

    public static boolean aboveMiuiV12() {
        initMiuiVersion();
        if (isMiui()) {
            return TextUtils.isEmpty(sMiuiVersion) || "V12".compareTo(sMiuiVersion.toUpperCase()) <= 0;
        }
        return false;
    }

    private static void initMiuiVersion() {
        if (sMiuiVersion == null) {
            try {
                sMiuiVersion = getProp("ro.miui.ui.version.name");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str = sMiuiVersion;
            if (str == null) {
                str = "";
            }
            sMiuiVersion = str;
        }
    }

    public static boolean isHarmony() {
        if (isHarmony == null) {
            isHarmony = Boolean.valueOf(HarmonyUtils.getOsBrand().equals(OS_HARMONY));
        }
        return isHarmony.booleanValue();
    }

    public static boolean isHuaWeiDevice() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
    }

    public static boolean isHonorDevice() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("honor")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor"));
    }

    public static String getValidPackageInstaller(Context context) {
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            for (String str : PACKAGE_INSTALLERS) {
                if (packageManager != null) {
                    try {
                        if (packageManager.getPackageInfo(str, 0) != null) {
                            AppDownloadUtils.addStats("getValidPackageInstaller_1", "Get:" + str);
                            return str;
                        }
                        continue;
                    } catch (Exception e) {
                        AppDownloadUtils.addStats("getValidPackageInstaller_2", "Error:" + e);
                    }
                }
            }
        }
        AppDownloadUtils.addStats("getValidPackageInstaller_3", "Not get");
        return null;
    }
}
