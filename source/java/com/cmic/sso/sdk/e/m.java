package com.cmic.sso.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.huawei.hms.android.SystemUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;

/* compiled from: TelephonyUtils.java */
/* loaded from: classes6.dex */
public class m {
    private static final String a = Build.BRAND;
    private static final String b = Build.MODEL;
    private static final String c = "android" + Build.VERSION.RELEASE;
    private static final boolean d;
    private static final String e;

    static {
        d = Build.VERSION.SDK_INT <= 28;
        e = Build.MANUFACTURER;
    }

    public static int a(Context context, boolean z, com.cmic.sso.sdk.a aVar) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = activeNetworkInfo.getType();
            if (type != 1) {
                if (type == 0) {
                    c.b("TelephonyUtils", "流量");
                    return 1;
                }
                return 0;
            }
            c.b("TelephonyUtils", "WIFI");
            boolean a2 = g.a(context, "android.permission.CHANGE_NETWORK_STATE");
            c.a("TelephonyUtils", "CHANGE_NETWORK_STATE=" + a2);
            if (!a2 || !z || !a(connectivityManager, context, aVar)) {
                return 2;
            }
            c.b("TelephonyUtils", "流量数据 WIFI 同开");
            return 3;
        }
        return 0;
    }

    private static boolean a(ConnectivityManager connectivityManager, Context context, com.cmic.sso.sdk.a aVar) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            c.b("TelephonyUtils", "data is on ---------" + booleanValue);
            if (Build.VERSION.SDK_INT >= 26) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && g.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    if (telephonyManager.createForSubscriptionId(SubscriptionManager.getDefaultSubscriptionId()).isDataEnabled()) {
                        aVar.a("networkTypeByAPI", "1");
                    } else {
                        aVar.a("networkTypeByAPI", "0");
                    }
                }
            } else {
                aVar.a("networkTypeByAPI", "-1");
            }
            return booleanValue;
        } catch (Exception unused) {
            c.a("TelephonyUtils", "isMobileEnabled ----反射出错-----");
            return false;
        }
    }

    public static String a() {
        return a;
    }

    public static String b() {
        return b;
    }

    public static String c() {
        return c;
    }

    public static boolean d() {
        return d;
    }

    public static boolean e() {
        String str = e;
        c.a(Constants.PHONE_BRAND, str);
        return SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(str);
    }

    public static boolean a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || 1 != telephonyManager.getSimState();
    }
}
