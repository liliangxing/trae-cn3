package com.huawei.hms.hatool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.huawei.hms.android.SystemUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.r0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1175r0 {

    /* renamed from: a */
    private static final int[] f1545a = {1, 6, 7, 9};

    /* renamed from: b */
    private static final int[] f1546b = {0, 2, 3, 4, 5};

    /* renamed from: c */
    private static final Map<Integer, String> f1547c = new a();

    /* renamed from: com.huawei.hms.hatool.r0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    static class a extends HashMap<Integer, String> {
        a() {
            put(1, "2G");
            put(2, "2G");
            put(4, "2G");
            put(7, "2G");
            put(11, "2G");
            put(3, "3G");
            put(8, "3G");
            put(9, "3G");
            put(10, "3G");
            put(15, "3G");
            put(5, "3G");
            put(6, "3G");
            put(12, "3G");
            put(14, "3G");
            put(13, "4G");
            if (Build.VERSION.SDK_INT >= 29) {
                put(20, "5G");
            }
        }
    }

    /* renamed from: a */
    private static NetworkInfo m1716a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            C1182v.m1778b("hmsSdk", "cannot get network state, ensure permission android.permission.ACCESS_NETWORK_STATE in the manifest: " + th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static String m1717a(int i) {
        Map<Integer, String> map = f1547c;
        String str = map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : SystemUtils.UNKNOWN;
        return (!SystemUtils.UNKNOWN.equals(str) || Build.VERSION.SDK_INT < 25) ? str : i != 16 ? i != 17 ? SystemUtils.UNKNOWN : "3G" : "2G";
    }

    /* renamed from: a */
    private static boolean m1718a(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f1546b, networkInfo.getType()) == -1) ? false : true;
    }

    /* renamed from: b */
    public static String m1719b(Context context) {
        NetworkInfo m1716a;
        if (context == null) {
            return SystemUtils.UNKNOWN;
        }
        try {
            m1716a = m1716a(context);
        } catch (Throwable unused) {
        }
        if (!m1720b(m1716a)) {
            return "none";
        }
        if (m1721c(m1716a)) {
            return "WIFI";
        }
        if (m1718a(m1716a)) {
            return m1717a(m1716a.getSubtype());
        }
        return SystemUtils.UNKNOWN;
    }

    /* renamed from: b */
    private static boolean m1720b(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    /* renamed from: c */
    private static boolean m1721c(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f1545a, networkInfo.getType()) == -1) ? false : true;
    }
}
