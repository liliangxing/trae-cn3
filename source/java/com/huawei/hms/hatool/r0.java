package com.huawei.hms.hatool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class r0 {
    private static final int[] a = {1, 6, 7, 9};
    private static final int[] b = {0, 2, 3, 4, 5};
    private static final Map<Integer, String> c = new a();

    /* loaded from: classes6.dex */
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

    private static NetworkInfo a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            v.b("hmsSdk", "cannot get network state, ensure permission android.permission.ACCESS_NETWORK_STATE in the manifest: " + th.getMessage());
            return null;
        }
    }

    private static String a(int i) {
        Map<Integer, String> map = c;
        String str = map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : "unknown";
        return (!"unknown".equals(str) || Build.VERSION.SDK_INT < 25) ? str : i != 16 ? i != 17 ? "unknown" : "3G" : "2G";
    }

    private static boolean a(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(b, networkInfo.getType()) == -1) ? false : true;
    }

    public static String b(Context context) {
        NetworkInfo a2;
        if (context == null) {
            return "unknown";
        }
        try {
            a2 = a(context);
        } catch (Throwable unused) {
        }
        if (!b(a2)) {
            return "none";
        }
        if (c(a2)) {
            return "WIFI";
        }
        if (a(a2)) {
            return a(a2.getSubtype());
        }
        return "unknown";
    }

    private static boolean b(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    private static boolean c(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(a, networkInfo.getType()) == -1) ? false : true;
    }
}
