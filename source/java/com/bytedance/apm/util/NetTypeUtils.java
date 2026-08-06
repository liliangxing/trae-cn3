package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.common.utility.NetworkUtils;

/* loaded from: classes3.dex */
public class NetTypeUtils {
    public static final boolean DEBUG_MOBILE = false;

    public static NetworkUtils.NetworkType getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return NetworkUtils.NetworkType.WIFI;
                }
                if (type == 0) {
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return NetworkUtils.NetworkType.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return NetworkUtils.NetworkType.MOBILE;
                        case 13:
                            return NetworkUtils.NetworkType.MOBILE_4G;
                    }
                }
                return NetworkUtils.NetworkType.MOBILE;
            }
            return NetworkUtils.NetworkType.NONE;
        } catch (Throwable unused) {
            return NetworkUtils.NetworkType.MOBILE;
        }
    }
}
