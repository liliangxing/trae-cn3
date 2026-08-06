package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CommonUtils {
    private static volatile String carrierOperator = "";
    private static volatile int simCardReady;
    private static TelephonyManager telephonyManager;

    public static String getNetStatusName(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? "" : OnekeyLoginConstants.NETWORK_TYPE_WIFI_AND_MOBILE_STR : OnekeyLoginConstants.NETWORK_TYPE_WIFI_STR : OnekeyLoginConstants.NETWORK_TYPE_MOBILE_STR : OnekeyLoginConstants.NETWORK_TYPE_NONE_STR : "error";
    }

    private CommonUtils() {
    }

    public static boolean hasPermission(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkSelfPermission(str) != 0) ? false : true;
    }

    public static String getCarrierType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 49679470:
                if (str.equals("46000")) {
                    c = 0;
                    break;
                }
                break;
            case 49679471:
                if (str.equals("46001")) {
                    c = 1;
                    break;
                }
                break;
            case 49679472:
                if (str.equals("46002")) {
                    c = 2;
                    break;
                }
                break;
            case 49679473:
                if (str.equals("46003")) {
                    c = 3;
                    break;
                }
                break;
            case 49679474:
                if (str.equals("46004")) {
                    c = 4;
                    break;
                }
                break;
            case 49679475:
                if (str.equals("46005")) {
                    c = 5;
                    break;
                }
                break;
            case 49679476:
                if (str.equals("46006")) {
                    c = 6;
                    break;
                }
                break;
            case 49679477:
                if (str.equals("46007")) {
                    c = 7;
                    break;
                }
                break;
            case 49679478:
                if (str.equals("46008")) {
                    c = '\b';
                    break;
                }
                break;
            case 49679479:
                if (str.equals("46009")) {
                    c = '\t';
                    break;
                }
                break;
            case 49679502:
                if (str.equals("46011")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
            case 7:
            case '\b':
                return "1";
            case 1:
            case 6:
            case '\t':
                return OnekeyLoginConstants.UNICOM_TYPE;
            case 3:
            case 5:
            case '\n':
                return OnekeyLoginConstants.TELECOM_TYPE;
            default:
                return null;
        }
    }

    public static String getCarrierOperator(Context context) {
        if (TextUtils.isEmpty(carrierOperator)) {
            carrierOperator = getCarrierOperatorInner(context);
        }
        return carrierOperator;
    }

    private static String getCarrierOperatorInner(Context context) {
        Logger.d("TimeValueData", "call getCarrierOperatorInner");
        if (context == null) {
            return null;
        }
        try {
            return (String) BpeaManager.invokeDeviceInfoApi(context, "phone", BpeaManager.getSimOperator, new Object[0]);
        } catch (Throwable th) {
            Log.e("CommonUtils", "getCarrierOperator: " + th);
            return null;
        }
    }

    public static boolean isSimCardReady(Context context) {
        if (simCardReady == 0) {
            simCardReady = isSimCardReadyInner(context) ? 1 : -1;
        }
        return simCardReady > 0;
    }

    private static boolean isSimCardReadyInner(Context context) {
        TelephonyManager telephonyManager2;
        try {
            Logger.d("TimeValueData", "call isSimCardReadyInner");
            if (context == null || (telephonyManager2 = getTelephonyManager(context)) == null) {
                return true;
            }
            return telephonyManager2.getSimState() == 5;
        } catch (Exception e) {
            Log.e("CommonUtils", "isSimCardReady: " + e);
            return true;
        }
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        if (telephonyManager == null) {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return telephonyManager;
    }

    public static void cleanSimCache() {
        simCardReady = 0;
        carrierOperator = "";
        NetworkTypeHelper.carrierType = "";
        NetworkTypeHelper.subscriptionId = -1;
        CarrierCacheInfoHelper.INSTANCE.cleanCarrierCacheInfo(-1);
    }
}
