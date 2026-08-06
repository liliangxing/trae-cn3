package com.ss.android.deviceregister.core;

import com.bytedance.common.utility.StringUtils;

/* loaded from: classes7.dex */
public class DeviceRegisterConfig {
    public static boolean sAntiCheatingSwitch = false;
    private static IConfigEncrypt sConfigEncrypt = null;
    private static String[] sDerviceActiveUrls = null;
    private static String[] sDerviceRegisterUrls = null;
    private static String sHostI = "ib.snssdk.com";
    private static boolean sInitWithActivity;

    /* loaded from: classes7.dex */
    public interface IConfigEncrypt {
        boolean getEncryptSwitch();
    }

    public static void setEncryptInstance(IConfigEncrypt iConfigEncrypt) {
        if (iConfigEncrypt != null) {
            sConfigEncrypt = iConfigEncrypt;
        }
    }

    public static String[] URL_DEVICE_REGISTER() {
        String[] strArr = sDerviceRegisterUrls;
        return (strArr == null || strArr.length <= 0 || StringUtils.isEmpty(strArr[0])) ? new String[]{"https://" + sHostI + "/service/2/device_register/", "https://" + sHostI + "/service/2/device_register/"} : sDerviceRegisterUrls;
    }

    public static boolean isAntiCheatingSwitchOpen() {
        return sAntiCheatingSwitch;
    }

    public static void setAntiCheatingSwitch(boolean z) {
        sAntiCheatingSwitch = z;
    }

    public static void setDeviceRegisterURL(String[] strArr) {
        if (strArr == null || strArr.length <= 0 || StringUtils.isEmpty(strArr[0])) {
            return;
        }
        sDerviceRegisterUrls = strArr;
    }

    public static void setDeviceActiveURL(String[] strArr) {
        if (strArr == null || strArr.length <= 0 || StringUtils.isEmpty(strArr[0])) {
            return;
        }
        sDerviceActiveUrls = strArr;
    }

    public static void setInitWithActivity(boolean z) {
        sInitWithActivity = z;
    }

    public static boolean isInitWithActivity() {
        return sInitWithActivity;
    }

    public static boolean isEncrypt() {
        IConfigEncrypt iConfigEncrypt = sConfigEncrypt;
        if (iConfigEncrypt != null) {
            return iConfigEncrypt.getEncryptSwitch();
        }
        return true;
    }
}
