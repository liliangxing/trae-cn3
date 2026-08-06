package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* loaded from: classes3.dex */
public class NetworkUtils {
    public static boolean isNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static NetworkType getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return NetworkType.WIFI;
                }
                if (type == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        return NetworkType.MOBILE;
                    }
                    if (telephonyManager.getNetworkType() != 3 && telephonyManager.getNetworkType() != 5 && telephonyManager.getNetworkType() != 6 && telephonyManager.getNetworkType() != 8 && telephonyManager.getNetworkType() != 9 && telephonyManager.getNetworkType() != 10 && telephonyManager.getNetworkType() != 12 && telephonyManager.getNetworkType() != 14 && telephonyManager.getNetworkType() != 15) {
                        if (telephonyManager.getNetworkType() == 13) {
                            return NetworkType.MOBILE_4G;
                        }
                        return NetworkType.MOBILE;
                    }
                    return NetworkType.MOBILE_3G;
                }
                return NetworkType.MOBILE;
            }
            return NetworkType.NONE;
        } catch (Throwable unused) {
            return NetworkType.MOBILE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getNetworkState(Context context) {
        boolean isNetworkAvailable = isNetworkAvailable(context);
        NetworkType networkType = getNetworkType(context);
        if (!isNetworkAvailable) {
            return 2;
        }
        if (NetworkType.WIFI == networkType) {
            return 3;
        }
        return NetworkType.NONE != networkType ? 4 : 1;
    }

    /* loaded from: classes3.dex */
    public enum NetworkType {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        final int nativeInt;

        NetworkType(int i) {
            this.nativeInt = i;
        }

        public int getValue() {
            return this.nativeInt;
        }
    }
}
