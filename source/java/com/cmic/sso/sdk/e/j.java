package com.cmic.sso.sdk.e;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;

/* compiled from: SIMUtils.java */
/* loaded from: classes6.dex */
public class j {
    private static j b;
    private final Context a;

    private static String com_cmic_sso_sdk_e_j_android_telephony_TelephonyManager_getSimOperator(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, telephonyManager, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String simOperator = telephonyManager.getSimOperator();
        heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, telephonyManager, objArr, simOperator, extraInfo, true);
        return simOperator;
    }

    public static void a(Context context) {
        b = new j(context);
    }

    private j(Context context) {
        this.a = context;
    }

    public static j a() {
        return b;
    }

    public String b() {
        try {
            int a = com.cmic.sso.sdk.b.a.a().b().a();
            return a >= 0 ? Integer.toString(a) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String b(String str) {
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
            case 49679479:
                if (str.equals("46009")) {
                    c = '\b';
                    break;
                }
                break;
            case 49679502:
                if (str.equals("46011")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
            case 7:
                c.a("SIMUtils", "中国移动");
                return "1";
            case 1:
            case 6:
            case '\b':
                c.a("SIMUtils", "中国联通");
                return "2";
            case 3:
            case 5:
            case '\t':
                c.a("SIMUtils", "中国电信");
                return "3";
            default:
                return "0";
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        return b(str);
    }

    public String c() {
        TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        String com_cmic_sso_sdk_e_j_android_telephony_TelephonyManager_getSimOperator = com_cmic_sso_sdk_e_j_android_telephony_TelephonyManager_getSimOperator(telephonyManager);
        c.b("SIMUtils", "SysOperator= " + com_cmic_sso_sdk_e_j_android_telephony_TelephonyManager_getSimOperator);
        return com_cmic_sso_sdk_e_j_android_telephony_TelephonyManager_getSimOperator;
    }
}
