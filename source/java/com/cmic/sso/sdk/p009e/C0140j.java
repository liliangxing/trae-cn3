package com.cmic.sso.sdk.p009e;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.webx.addr.AddressParam;
import com.cmic.sso.sdk.p002b.C0105a;

/* compiled from: SIMUtils.java */
/* renamed from: com.cmic.sso.sdk.e.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0140j {

    /* renamed from: b */
    private static C0140j f321b;

    /* renamed from: a */
    private final Context f322a;

    /* renamed from: com_cmic_sso_sdk_e_j_android_telephony_TelephonyManager_getSimOperator */
    private static String m359x876967f7(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String simOperator = telephonyManager.getSimOperator();
        heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, simOperator, extraInfo, true);
        return simOperator;
    }

    /* renamed from: a */
    public static void m357a(Context context) {
        f321b = new C0140j(context);
    }

    private C0140j(Context context) {
        this.f322a = context;
    }

    /* renamed from: a */
    public static C0140j m356a() {
        return f321b;
    }

    /* renamed from: b */
    public String m361b() {
        try {
            int m179a = C0105a.m170a().m174b().m179a();
            return m179a >= 0 ? Integer.toString(m179a) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private String m358b(String str) {
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
                C0133c.m326a("SIMUtils", "中国移动");
                return "1";
            case 1:
            case 6:
            case '\b':
                C0133c.m326a("SIMUtils", "中国联通");
                return "2";
            case 3:
            case 5:
            case '\t':
                C0133c.m326a("SIMUtils", "中国电信");
                return "3";
            default:
                return AddressParam.TYPE_DISAPPROVE;
        }
    }

    /* renamed from: a */
    public String m360a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = m362c();
        }
        return m358b(str);
    }

    /* renamed from: c */
    public String m362c() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f322a.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        String m359x876967f7 = m359x876967f7(telephonyManager);
        C0133c.m328b("SIMUtils", "SysOperator= " + m359x876967f7);
        return m359x876967f7;
    }
}
