package com.cmic.sso.sdk.p009e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.bytedance.webx.addr.AddressParam;
import com.cmic.sso.sdk.C0088a;
import com.huawei.hms.android.SystemUtils;
import java.lang.reflect.Method;

/* compiled from: TelephonyUtils.java */
/* renamed from: com.cmic.sso.sdk.e.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0143m {

    /* renamed from: a */
    private static final String f325a = Build.BRAND;

    /* renamed from: b */
    private static final String f326b = Build.MODEL;

    /* renamed from: c */
    private static final String f327c = "android" + Build.VERSION.RELEASE;

    /* renamed from: d */
    private static final boolean f328d;

    /* renamed from: e */
    private static final String f329e;

    static {
        f328d = Build.VERSION.SDK_INT <= 28;
        f329e = Build.MANUFACTURER;
    }

    /* renamed from: a */
    public static int m383a(Context context, boolean z, C0088a c0088a) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = activeNetworkInfo.getType();
            if (type != 1) {
                if (type == 0) {
                    C0133c.m328b("TelephonyUtils", "流量");
                    return 1;
                }
                return 0;
            }
            C0133c.m328b("TelephonyUtils", "WIFI");
            boolean m339a = C0137g.m339a(context, "android.permission.CHANGE_NETWORK_STATE");
            C0133c.m326a("TelephonyUtils", "CHANGE_NETWORK_STATE=" + m339a);
            if (!m339a || !z || !m386a(connectivityManager, context, c0088a)) {
                return 2;
            }
            C0133c.m328b("TelephonyUtils", "流量数据 WIFI 同开");
            return 3;
        }
        return 0;
    }

    /* renamed from: a */
    private static boolean m386a(ConnectivityManager connectivityManager, Context context, C0088a c0088a) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            C0133c.m328b("TelephonyUtils", "data is on ---------" + booleanValue);
            if (Build.VERSION.SDK_INT >= 26) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && C0137g.m339a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    if (telephonyManager.createForSubscriptionId(SubscriptionManager.getDefaultSubscriptionId()).isDataEnabled()) {
                        c0088a.m60a("networkTypeByAPI", "1");
                    } else {
                        c0088a.m60a("networkTypeByAPI", AddressParam.TYPE_DISAPPROVE);
                    }
                }
            } else {
                c0088a.m60a("networkTypeByAPI", "-1");
            }
            return booleanValue;
        } catch (Exception unused) {
            C0133c.m326a("TelephonyUtils", "isMobileEnabled ----反射出错-----");
            return false;
        }
    }

    /* renamed from: a */
    public static String m384a() {
        return f325a;
    }

    /* renamed from: b */
    public static String m387b() {
        return f326b;
    }

    /* renamed from: c */
    public static String m388c() {
        return f327c;
    }

    /* renamed from: d */
    public static boolean m389d() {
        return f328d;
    }

    /* renamed from: e */
    public static boolean m390e() {
        String str = f329e;
        C0133c.m326a("brand", str);
        return SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(str);
    }

    /* renamed from: a */
    public static boolean m385a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || 1 != telephonyManager.getSimState();
    }
}
