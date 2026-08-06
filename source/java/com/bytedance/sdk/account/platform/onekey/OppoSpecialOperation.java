package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import java.net.URL;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OppoSpecialOperation {
    private static final String DEFAULT_REQUEST_URL = "https://security.snssdk.com/passport/token/beat/v2/";
    private static final String PURE_DATA_REQUESTED = "pure_data_requested";
    private static final String SHARED_NAME = "bd_onekey_special_operate";
    private static final String SPECIAL_DEVICE_BRAND = "OPPO";

    public static void optOppoGetPhone(Context context, final boolean z) {
        final Context applicationContext = context.getApplicationContext();
        if (isSpecialOppoDevices()) {
            if ((NetworkTypeHelper.getNetworkStatus(applicationContext) == 3) && !hasPureDataRequested(applicationContext)) {
                new Thread(new Runnable() { // from class: com.bytedance.sdk.account.platform.onekey.OppoSpecialOperation.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            OppoSpecialOperation.pureDataRequest(applicationContext, z);
                        } catch (Exception unused) {
                        }
                    }
                }).start();
            }
        }
    }

    private static boolean isSpecialOppoDevices() {
        return SPECIAL_DEVICE_BRAND.equalsIgnoreCase(Build.BRAND) && Build.VERSION.SDK_INT <= 28;
    }

    private static boolean hasPureDataRequested(Context context) {
        return context.getSharedPreferences(SHARED_NAME, 0).getBoolean(PURE_DATA_REQUESTED, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pureDataRequest(Context context, boolean z) {
        WifiManager wifiManager;
        WifiInfo wifiInfo;
        if (context == null || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(OnekeyLoginConstants.NETWORK_TYPE_WIFI_STR)) == null) {
            return;
        }
        try {
            wifiInfo = (WifiInfo) BpeaManager.invokeDeviceInfoApi(context, OnekeyLoginConstants.NETWORK_TYPE_WIFI_STR, BpeaManager.getConnectionInfo, new Object[0]);
        } catch (Throwable unused) {
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            return;
        }
        int networkId = wifiInfo.getNetworkId();
        wifiManager.disableNetwork(networkId);
        wifiManager.disconnect();
        try {
            if (z) {
                Thread.sleep(50L);
                new URL(DEFAULT_REQUEST_URL).openConnection().connect();
                setHasPureDataRequested(context);
            } else {
                Thread.sleep(500L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        wifiManager.enableNetwork(networkId, true);
        wifiManager.reconnect();
    }

    private static void setHasPureDataRequested(Context context) {
        context.getSharedPreferences(SHARED_NAME, 0).edit().putBoolean(PURE_DATA_REQUESTED, true).commit();
    }
}
