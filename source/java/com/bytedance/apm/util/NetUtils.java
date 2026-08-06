package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.net.IHttpUrlConnectionInterceptor;
import com.bytedance.common.utility.NetworkUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes3.dex */
public class NetUtils {
    public static final boolean DEBUG_MOBILE = false;
    public static final int NET_DEFAULT = -10000;
    private static NetworkUtils.NetworkType sNetworkType = NetworkUtils.NetworkType.UNKNOWN;
    private static NetworkUtils.NetworkTypeInterceptor sNetworkTypeInterceptor;
    private static IHttpUrlConnectionInterceptor sUrlConnectionInterceptor;

    static void setNetworkType(NetworkUtils.NetworkType networkType) {
        sNetworkType = networkType;
    }

    public static void setNetworkTypeInterceptor(NetworkUtils.NetworkTypeInterceptor networkTypeInterceptor) {
        sNetworkTypeInterceptor = networkTypeInterceptor;
    }

    public static int getMobileNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ContextCompat.checkSelfPermission(ApmContext.getContext(), "android.permission.ACCESS_NETWORK_STATE") == 0 ? ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0) {
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
            }
        } catch (Throwable unused) {
        }
        return -10000;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                NetworkUtils.NetworkTypeInterceptor networkTypeInterceptor = sNetworkTypeInterceptor;
                return (networkTypeInterceptor == null || networkTypeInterceptor.getNetworkType() == NetworkUtils.NetworkType.NONE) ? 1 == activeNetworkInfo.getType() : sNetworkTypeInterceptor.getNetworkType() == NetworkUtils.NetworkType.WIFI;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void setUrlConnectionInterceptor(IHttpUrlConnectionInterceptor iHttpUrlConnectionInterceptor) {
        sUrlConnectionInterceptor = iHttpUrlConnectionInterceptor;
    }

    public static HttpURLConnection getUrlConnection(String str) throws IOException {
        IHttpUrlConnectionInterceptor iHttpUrlConnectionInterceptor = sUrlConnectionInterceptor;
        return iHttpUrlConnectionInterceptor == null ? (HttpURLConnection) new URL(str).openConnection() : iHttpUrlConnectionInterceptor.getUrlConnection(str);
    }
}
