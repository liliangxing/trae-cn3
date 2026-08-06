package com.bytedance.sdk.account.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.sdk.account.INetWork;
import com.bytedance.sdk.account.bpea.BpeaManager;
import com.ss.android.TTHeader;
import com.ss.android.TTResponse;
import com.ss.android.account.TTAccountInit;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class NetworkUtils {
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

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum NetworkType {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        WIFI_MOBILE(6);

        final int nativeInt;

        NetworkType(int i) {
            this.nativeInt = i;
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public static NetworkType getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    if (isMobileNetOpen(context)) {
                        return NetworkType.WIFI_MOBILE;
                    }
                    return NetworkType.WIFI;
                }
                if (type == 0) {
                    int i = 0;
                    try {
                        i = ((Integer) BpeaManager.invokeDeviceInfoApi(context, "phone", "getNetworkType", new Object[0])).intValue();
                    } catch (Throwable unused) {
                    }
                    switch (i) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return NetworkType.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return NetworkType.MOBILE;
                        case 13:
                            return NetworkType.MOBILE_4G;
                    }
                }
                return NetworkType.MOBILE;
            }
            return NetworkType.NONE;
        } catch (Throwable unused2) {
            return NetworkType.MOBILE;
        }
    }

    public static TTResponse executeGet(int i, String str, List<TTHeader> list) throws Exception {
        INetWork network = TTAccountInit.getConfig().getNetwork();
        if (network != null) {
            return network.executeGet(i, str, list);
        }
        return null;
    }

    public static TTResponse executePost(int i, String str, Map<String, String> map, List<TTHeader> list) throws Exception {
        INetWork network = TTAccountInit.getConfig().getNetwork();
        if (network != null) {
            return network.executePost(i, str, map, list);
        }
        return null;
    }

    public static TTResponse postFile(int i, String str, Map<String, String> map, String str2, String str3, List<TTHeader> list) throws Exception {
        INetWork network = TTAccountInit.getConfig().getNetwork();
        if (network != null) {
            return network.postFile(i, str, map, str2, str3, list);
        }
        return null;
    }

    private static boolean isMobileNetOpen(Context context) {
        Method declaredMethod;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (declaredMethod = connectivityManager.getClass().getDeclaredMethod("getMobileDataEnabled", new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
