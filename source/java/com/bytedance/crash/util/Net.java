package com.bytedance.crash.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.crash.Global;
import com.bytedance.crash.diagnose.NpthMonitor;

/* loaded from: classes3.dex */
public final class Net {
    private static final int NETWORK_TYPE_2G = 3;
    private static final int NETWORK_TYPE_3G = 4;
    private static final int NETWORK_TYPE_4G = 5;
    private static final int NETWORK_TYPE_5G = 6;
    private static final int NETWORK_TYPE_MAX = 7;
    private static final int NETWORK_TYPE_MOBILE = 2;
    private static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_WIFI = 1;
    private static final String[] TYPE_NAMES = {"unknown", "wifi", "mobile", "2g", "3g", "4g", "5g"};

    public static String getNetworkAccessTypeName() {
        int networkType = getNetworkType();
        if (networkType >= 7) {
            networkType = 0;
        }
        return TYPE_NAMES[networkType];
    }

    private static int getNetworkType() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            Context context = Global.getContext();
            if (context != null && (connectivityManager = getConnectivityManager(context)) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return 1;
                }
                if (type != 0) {
                    return 2;
                }
                switch (getTelephonyManager(context).getNetworkType()) {
                    case 2:
                        return 3;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 4;
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    default:
                        return 2;
                    case 13:
                        return 5;
                    case 20:
                        return 6;
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo;
        Context context = Global.getContext();
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = getConnectivityManager(context);
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception e) {
            NpthMonitor.reportInnerException(e);
        }
        return false;
    }
}
