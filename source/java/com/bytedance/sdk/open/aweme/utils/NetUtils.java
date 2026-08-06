package com.bytedance.sdk.open.aweme.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes5.dex */
public class NetUtils {

    /* loaded from: classes5.dex */
    public enum NetworkType {
        MOBILE(0),
        WIFI(1),
        NONE(2);

        final int nativeInt;

        NetworkType(int i) {
            this.nativeInt = i;
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public static NetworkType getNetWorkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                return 1 == type ? NetworkType.WIFI : type == 0 ? NetworkType.MOBILE : NetworkType.NONE;
            }
            return NetworkType.NONE;
        } catch (Exception unused) {
            return NetworkType.MOBILE;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return true;
        }
        try {
            NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.isAvailable() && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
