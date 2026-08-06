package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class NetworkTypeHelper {
    public static final String CARRIER_UNKNOWN = "carrier unknown";
    private static final String GET_CARRIER_INNER_EVENT = "one_click_get_carrier_inner_event";
    public static final int INVALID_SUBSCRIPTION_ID = -1;
    public static final String SIM_CARD_NOT_READY = "sim card not ready";
    private static final String TAG = "NetworkTypeHelper";
    static volatile String carrierType = "";
    private static IOnekeyMonitor sMonitor = null;
    public static volatile int subscriptionId = -1;

    public static boolean isMobileEnabled(int i) {
        return i == 1 || i == 3;
    }

    private NetworkTypeHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerReceiver(Context context) {
        SimStateReceive.register(context);
        DefaultDataSubscriptionReceiver.register(context);
    }

    static void unregisterReceiver(Context context) {
        SimStateReceive.unregister(context);
        DefaultDataSubscriptionReceiver.unregister(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCarrierType(Context context) {
        if (TextUtils.isEmpty(carrierType)) {
            carrierType = getCarrierTypeInner(context);
        }
        return carrierType;
    }

    public static void setMonitor(IOnekeyMonitor iOnekeyMonitor) {
        sMonitor = iOnekeyMonitor;
    }

    static String getCarrierTypeInner(Context context) {
        String str = "others";
        String str2 = "";
        try {
            Logger.d("TimeValueData", "call getCarrierTypeInner");
        } catch (Throwable th) {
            th = th;
        }
        if (!CommonUtils.isSimCardReady(context)) {
            return SIM_CARD_NOT_READY;
        }
        String str3 = CommonUtils.getCarrierOperator(context);
        try {
            String carrierType2 = CommonUtils.getCarrierType(str3);
            if (TextUtils.isEmpty(carrierType2)) {
                str = CARRIER_UNKNOWN;
            } else if ("1".equals(carrierType2)) {
                str = "mobile";
            } else if (OnekeyLoginConstants.TELECOM_TYPE.equals(carrierType2)) {
                str = OnekeyLoginConstants.TELECOM;
            } else if (OnekeyLoginConstants.UNICOM_TYPE.equals(carrierType2)) {
                str = OnekeyLoginConstants.UNICOM;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = str3;
            String str4 = th.getMessage() + " ==== " + Log.getStackTraceString(th);
            str3 = str2;
            str2 = str4;
            onGetCarrierEvent(context, str3, str, str2);
            return str;
        }
        onGetCarrierEvent(context, str3, str, str2);
        return str;
    }

    private static void onGetCarrierEvent(Context context, String str, String str2, String str3) {
        if (sMonitor != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mccmnc", str);
                jSONObject.put("carrier", str2);
                jSONObject.put("carrier_log", getCarrierLog(context));
                jSONObject.put("error_msg", str3);
                jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
                jSONObject.put("params_for_special", "uc_login");
                sMonitor.onEvent(GET_CARRIER_INNER_EVENT, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getNetworkStatus(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return -1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                boolean hasTransport = networkCapabilities.hasTransport(0);
                boolean hasTransport2 = networkCapabilities.hasTransport(1);
                if (isDataMobileEnabled(context, connectivityManager) && hasTransport2) {
                    return 3;
                }
                if (hasTransport2) {
                    return 2;
                }
                if (hasTransport) {
                    return 1;
                }
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return isDataMobileEnabled(context, connectivityManager) ? 3 : 2;
                }
                if (type == 0) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static boolean isDataMobileEnabled(Context context, ConnectivityManager connectivityManager) {
        Method declaredMethod;
        try {
            if (CommonUtils.isSimCardReady(context) && (declaredMethod = connectivityManager.getClass().getDeclaredMethod("getMobileDataEnabled", new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getCarrierLog(Context context) {
        String str;
        try {
            str = (String) BpeaManager.invokeDeviceInfoApi(context, "phone", BpeaManager.getNetworkOperatorName, new Object[0]);
        } catch (Throwable unused) {
            str = null;
        }
        return !TextUtils.isEmpty(str) ? str : "";
    }

    public static String getNetTypeLog(Context context) {
        return getNetworkAccessType(context);
    }

    public static String getNetworkAccessType(Context context) {
        return getNetworkAccessType(getNetworkType(context));
    }

    public static String getNetworkAccessType(NetworkType networkType) {
        return networkType == NetworkType.WIFI ? OnekeyLoginConstants.NETWORK_TYPE_WIFI_STR : networkType == NetworkType.MOBILE_2G ? "2g" : networkType == NetworkType.MOBILE_3G ? "3g" : networkType == NetworkType.MOBILE_4G ? "4g" : networkType == NetworkType.MOBILE ? "mobile" : "";
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
                    int i = 0;
                    try {
                        i = ((Integer) BpeaManager.invokeDeviceInfoApi(context, "phone", "getNetworkType", new Object[0])).intValue();
                    } catch (Exception e) {
                        e.printStackTrace();
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
        } catch (Throwable unused) {
            return NetworkType.MOBILE;
        }
    }

    public static int getDefaultDataSubscriptionId(Context context) {
        if (subscriptionId == -1) {
            subscriptionId = innerGetDefaultDataSubscriptionId(context);
        }
        return subscriptionId;
    }

    private static int innerGetDefaultDataSubscriptionId(Context context) {
        if (context != null && !CommonUtils.isSimCardReady(context)) {
            return -1;
        }
        int defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
        Log.d(TAG, "getDefaultDataSubscriptionId, way 1, value=" + defaultDataSubscriptionId);
        IServiceContainer iServiceContainer = (IServiceContainer) AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (defaultDataSubscriptionId <= 0 && iServiceContainer != null) {
            iServiceContainer.onEvent(OnekeyDataHelper.GET_SUBSCRIPTION_ID_FAIL_EVENT, new JSONObject());
        }
        return defaultDataSubscriptionId;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum NetworkType {
        UNKNOWN(-1),
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

        public boolean is2G() {
            return this == MOBILE || this == MOBILE_2G;
        }

        public boolean isWifi() {
            return this == WIFI;
        }

        public boolean isAvailable() {
            return (this == UNKNOWN || this == NONE) ? false : true;
        }
    }
}
