package com.bytedance.sdk.account.platform.onekey.bpea;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;

/* loaded from: classes5.dex */
public class BpeaManager {
    private static final String ONEKEY_SDK_BPEA_CERT_NAME = "bpea-account_onekey_request_api";
    public static final String getConnectionInfo = "getConnectionInfo";
    public static final String getNetworkOperatorName = "getNetworkOperatorName";
    public static final String getNetworkType = "getNetworkType";
    public static final String getSimOperator = "getSimOperator";
    private static IBpeaAPI iBpeaAPI = null;
    private static boolean open = true;

    private static String com_bytedance_sdk_account_platform_onekey_bpea_BpeaManager_android_telephony_TelephonyManager_getSimOperator(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102021, "android/telephony/TelephonyManager", getSimOperator, telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", getSimOperator, telephonyManager, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String simOperator = telephonyManager.getSimOperator();
        heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", getSimOperator, telephonyManager, objArr, simOperator, extraInfo, true);
        return simOperator;
    }

    private static IBpeaAPI getInstance() {
        if (iBpeaAPI == null) {
            synchronized (BpeaManager.class) {
                if (iBpeaAPI == null) {
                    try {
                        iBpeaAPI = (IBpeaAPI) Class.forName("com.bytedance.sdk.account.adapter.bpea.OnekeyBpeaAdapter").newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return iBpeaAPI;
    }

    public static void setOpen(boolean z) {
        open = z;
    }

    public static boolean isUsable() {
        return getInstance() != null;
    }

    public static Object invokeDeviceInfoApi(Context context, String str, String str2, Object... objArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (isUsable() && open) {
            return getInstance().invokeDeviceInfoApi(context, str, str2, ONEKEY_SDK_BPEA_CERT_NAME, objArr);
        }
        return directInvoke(context, str, str2, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055 A[Catch: all -> 0x00b3, TryCatch #0 {all -> 0x00b3, blocks: (B:2:0x0000, B:16:0x0033, B:20:0x003d, B:27:0x0055, B:29:0x0047, B:35:0x005d, B:39:0x0066, B:52:0x00a0, B:54:0x00a5, B:56:0x00aa, B:58:0x007b, B:61:0x0084, B:64:0x008e, B:67:0x0012, B:70:0x001d), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00aa A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #0 {all -> 0x00b3, blocks: (B:2:0x0000, B:16:0x0033, B:20:0x003d, B:27:0x0055, B:29:0x0047, B:35:0x005d, B:39:0x0066, B:52:0x00a0, B:54:0x00a5, B:56:0x00aa, B:58:0x007b, B:61:0x0084, B:64:0x008e, B:67:0x0012, B:70:0x001d), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object directInvoke(Context context, String str, String str2, Object... objArr) {
        boolean z;
        TelephonyManager telephonyManager;
        WifiManager wifiManager;
        try {
            int hashCode = str.hashCode();
            char c = 0;
            if (hashCode != 3649301) {
                if (hashCode == 106642798 && str.equals("phone")) {
                    z = false;
                    if (!z) {
                        if (z && context != null && (wifiManager = (WifiManager) context.getSystemService(str)) != null) {
                            if (str2.hashCode() == 977831330 && str2.equals(getConnectionInfo)) {
                                if (c == 0) {
                                    return null;
                                }
                                return wifiManager.getConnectionInfo();
                            }
                            c = 65535;
                            if (c == 0) {
                            }
                        }
                        return null;
                    }
                    if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService(str)) != null) {
                        int hashCode2 = str2.hashCode();
                        if (hashCode2 == -332211353) {
                            if (str2.equals(getNetworkOperatorName)) {
                                c = 2;
                                if (c != 0) {
                                }
                            }
                            c = 65535;
                            if (c != 0) {
                            }
                        } else if (hashCode2 != -170276507) {
                            if (hashCode2 == 1714085202 && str2.equals("getNetworkType")) {
                                if (c != 0) {
                                    return Integer.valueOf(telephonyManager.getNetworkType());
                                }
                                if (c == 1) {
                                    return com_bytedance_sdk_account_platform_onekey_bpea_BpeaManager_android_telephony_TelephonyManager_getSimOperator(telephonyManager);
                                }
                                if (c != 2) {
                                    return null;
                                }
                                return telephonyManager.getNetworkOperatorName();
                            }
                            c = 65535;
                            if (c != 0) {
                            }
                        } else {
                            if (str2.equals(getSimOperator)) {
                                c = 1;
                                if (c != 0) {
                                }
                            }
                            c = 65535;
                            if (c != 0) {
                            }
                        }
                    }
                    return null;
                }
                z = -1;
                if (!z) {
                }
            } else {
                if (str.equals("wifi")) {
                    z = true;
                    if (!z) {
                    }
                }
                z = -1;
                if (!z) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
