package com.bytedance.sdk.account.bpea;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.CookieManager;

/* loaded from: classes5.dex */
public class BpeaManager {
    private static final String ACCOUNT_SDK_BPEA_CERT_NAME = "bpea-account_request_api";
    public static final String SERVICE_CookieManager = "CookieManager";
    public static final String getCookie = "getCookie";
    public static final String getNetworkType = "getNetworkType";
    private static IBpeaAPI iBpeaAPI = null;
    private static boolean open = true;

    private static IBpeaAPI getInstance() {
        if (iBpeaAPI == null) {
            synchronized (BpeaManager.class) {
                if (iBpeaAPI == null) {
                    try {
                        iBpeaAPI = (IBpeaAPI) Class.forName("com.bytedance.sdk.account.adapter.bpea.AccountSdkBpeaAdapter").newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return iBpeaAPI;
    }

    public static boolean isUsable() {
        return getInstance() != null;
    }

    public static void setOpen(boolean z) {
        open = z;
    }

    public static Object invokeDeviceInfoApi(Context context, String str, String str2, Object... objArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (isUsable() && open) {
            return getInstance().invokeDeviceInfoApi(context, str, str2, ACCOUNT_SDK_BPEA_CERT_NAME, objArr);
        }
        return directInvoke(context, str, str2, objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object directInvoke(Context context, String str, String str2, Object... objArr) {
        boolean z;
        TelephonyManager telephonyManager;
        CookieManager cookieManager;
        try {
            int hashCode = str.hashCode();
            char c = 65535;
            if (hashCode != -854125431) {
                if (hashCode == 106642798 && str.equals("phone")) {
                    z = false;
                    if (z) {
                        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService(str)) != null) {
                            if (str2.hashCode() == 1714085202 && str2.equals("getNetworkType")) {
                                c = 0;
                            }
                            return Integer.valueOf(telephonyManager.getNetworkType());
                        }
                        return null;
                    }
                    if (z && (cookieManager = CookieManager.getInstance()) != null) {
                        if (str2.hashCode() == 341257562 && str2.equals(getCookie)) {
                            c = 0;
                        }
                        return cookieManager.getCookie((String) objArr[0]);
                    }
                    return null;
                }
                z = -1;
                if (z) {
                }
            } else {
                if (str.equals(SERVICE_CookieManager)) {
                    z = true;
                    if (z) {
                    }
                }
                z = -1;
                if (z) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
