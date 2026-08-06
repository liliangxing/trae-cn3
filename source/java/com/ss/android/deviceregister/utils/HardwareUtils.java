package com.ss.android.deviceregister.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.LogUtils;
import com.ss.android.deviceregister.SensitiveApiCallback;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HardwareUtils {
    private static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    private static final String ID_TYPE_IMEI = "imei";
    private static final String ID_TYPE_MEID = "meid";
    private static final String ID_TYPE_UNKNOWN = "unknown";
    private static final String TAG = "hwinfo";
    private static final Singleton<String> sWifiMacAddress = new Singleton<String>() { // from class: com.ss.android.deviceregister.utils.HardwareUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.ss.android.deviceregister.utils.Singleton
        public String create(Object... objArr) {
            Context context = (Context) objArr[0];
            return context != null ? HardwareUtils.getMAC(context) : "";
        }
    };

    /* renamed from: com_ss_android_deviceregister_utils_HardwareUtils_android_net_wifi_WifiInfo_getMacAddress */
    private static String m101x42be589e(WifiInfo wifiInfo) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String macAddress = wifiInfo.getMacAddress();
        heliosApiHook.postInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, macAddress, extraInfo, true);
        return macAddress;
    }

    /* renamed from: com_ss_android_deviceregister_utils_HardwareUtils_android_provider_Settings$Secure_getString */
    private static String m102x69f4487b(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }

    /* renamed from: com_ss_android_deviceregister_utils_HardwareUtils_android_telephony_TelephonyManager_getDeviceId */
    private static String m103x374897cd(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String deviceId = telephonyManager.getDeviceId();
        heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, deviceId, extraInfo, true);
        return deviceId;
    }

    /* renamed from: com_ss_android_deviceregister_utils_HardwareUtils_android_telephony_TelephonyManager_getImei */
    private static String m104x72f14c84(TelephonyManager telephonyManager, int i) throws JSONException {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {Integer.valueOf(i)};
        ExtraInfo extraInfo = new ExtraInfo(false, "(I)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101601, "android/telephony/TelephonyManager", "getImei", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101601, "android/telephony/TelephonyManager", "getImei", telephonyManager, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String imei = telephonyManager.getImei(i);
        heliosApiHook.postInvoke(101601, "android/telephony/TelephonyManager", "getImei", telephonyManager, objArr, imei, extraInfo, true);
        return imei;
    }

    /* renamed from: com_ss_android_deviceregister_utils_HardwareUtils_java_net_NetworkInterface_getHardwareAddress */
    private static byte[] m105xb0cde684(NetworkInterface networkInterface) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()[B");
        Result preInvoke = heliosApiHook.preInvoke(101701, "java/net/NetworkInterface", "getHardwareAddress", networkInterface, objArr, "byte[]", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101701, "java/net/NetworkInterface", "getHardwareAddress", networkInterface, objArr, (Object) null, extraInfo, false);
            return (byte[]) preInvoke.getReturnValue();
        }
        byte[] hardwareAddress = networkInterface.getHardwareAddress();
        heliosApiHook.postInvoke(101701, "java/net/NetworkInterface", "getHardwareAddress", networkInterface, objArr, hardwareAddress, extraInfo, true);
        return hardwareAddress;
    }

    public static String getSerialNumber(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && DeviceRegisterManager.checkPermissionBeforeCallSensitiveApi() && !InstallPmsUtils.checkReadPhoneStatePermission(context)) {
            return null;
        }
        SensitiveApiCallback bpeaApiCallback = DeviceRegisterManager.getBpeaApiCallback();
        boolean z = DeviceRegisterManager.isOpenBpe() && bpeaApiCallback != null;
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                str = z ? bpeaApiCallback.getSerial() : Build.getSerial();
            } catch (SecurityException unused) {
                LogUtils.m94v(TAG, "没有READ_PRIVILEGED_PHONE_STATE权限或者READ_PHONE_STATE权限,获取Build.SERIAL失败");
            }
        }
        if (StringUtils.isEmpty(str) || TextUtils.equals(str, ID_TYPE_UNKNOWN)) {
            str = Build.SERIAL;
        }
        return (StringUtils.isEmpty(str) || TextUtils.equals(str, ID_TYPE_UNKNOWN)) ? "" : str;
    }

    public static String[] getSimSerialNumbers(Context context) {
        String[] strArr = null;
        if (context != null && !RomUtils.isAndroidROrHigher()) {
            if ((DeviceRegisterManager.checkPermissionBeforeCallSensitiveApi() && !InstallPmsUtils.checkReadPhoneStatePermission(context)) || RomUtils.isGmsInstalled(context)) {
                return null;
            }
            SensitiveApiCallback bpeaApiCallback = DeviceRegisterManager.getBpeaApiCallback();
            boolean z = DeviceRegisterManager.isOpenBpe() && bpeaApiCallback != null;
            try {
                List<SubscriptionInfo> activeSubscriptionInfoList = z ? bpeaApiCallback.getActiveSubscriptionInfoList() : SubscriptionManager.from(context).getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList != null && !activeSubscriptionInfoList.isEmpty()) {
                    strArr = new String[activeSubscriptionInfoList.size()];
                    for (int i = 0; i < activeSubscriptionInfoList.size(); i++) {
                        strArr[i] = z ? bpeaApiCallback.getIccId(activeSubscriptionInfoList.get(i)) : activeSubscriptionInfoList.get(i).getIccId();
                    }
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return strArr;
    }

    public static String getSecureAndroidId(Context context) {
        try {
            return m102x69f4487b(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getMccMnc(Context context) {
        if (DeviceRegisterManager.isOpenBpe() && DeviceRegisterManager.getBpeaApiCallback() != null) {
            return DeviceRegisterManager.getBpeaApiCallback().getNetworkOperator();
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
    }

    public static String getCarrier(Context context) {
        if (DeviceRegisterManager.isOpenBpe() && DeviceRegisterManager.getBpeaApiCallback() != null) {
            return DeviceRegisterManager.getBpeaApiCallback().getNetworkOperatorName();
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    public static String getSimRegion(Context context) {
        if (DeviceRegisterManager.isOpenBpe() && DeviceRegisterManager.getBpeaApiCallback() != null) {
            return DeviceRegisterManager.getBpeaApiCallback().getSimCountryIso();
        }
        return ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
    }

    public static String getDeviceId(Context context) {
        Log.d("getDeviceId", "CHINA DEVICEID");
        if (context == null) {
            return null;
        }
        if ((DeviceRegisterManager.checkPermissionBeforeCallSensitiveApi() && !InstallPmsUtils.checkReadPhoneStatePermission(context)) || RomUtils.isGmsInstalled(context)) {
            return null;
        }
        try {
            if (DeviceRegisterManager.isOpenBpe() && DeviceRegisterManager.getBpeaApiCallback() != null) {
                return DeviceRegisterManager.getBpeaApiCallback().getDeviceId();
            }
            return m103x374897cd((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static WifiInfo getWifiInfo(Context context) {
        WifiInfo connectionInfo;
        String ssid;
        if (context == null) {
            return null;
        }
        try {
            SensitiveApiCallback bpeaApiCallback = DeviceRegisterManager.getBpeaApiCallback();
            if (DeviceRegisterManager.isOpenBpe() && bpeaApiCallback != null) {
                connectionInfo = bpeaApiCallback.getConnectionInfo();
                ssid = bpeaApiCallback.getSSID(connectionInfo);
            } else {
                connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                ssid = connectionInfo.getSSID();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED || ssid == null) {
            return null;
        }
        return connectionInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getMAC(Context context) {
        String str = "";
        if (RomUtils.isAndroidQOrHigher() && RomUtils.isTargetQOrHigher(context)) {
            return "";
        }
        SensitiveApiCallback bpeaApiCallback = DeviceRegisterManager.getBpeaApiCallback();
        boolean z = DeviceRegisterManager.isOpenBpe() && bpeaApiCallback != null;
        WifiInfo wifiInfo = getWifiInfo(context);
        if (wifiInfo != null) {
            str = z ? bpeaApiCallback.getMacAddress(wifiInfo) : m101x42be589e(wifiInfo);
        }
        if (!DEFAULT_MAC_ADDRESS.equals(str) && !TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = bpeaApiCallback != null ? bpeaApiCallback.getNetworkInterfaces() : NetworkInterface.getNetworkInterfaces();
            String networkInterfaceName = getNetworkInterfaceName();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                byte[] hardwareAddress = z ? bpeaApiCallback.getHardwareAddress(nextElement) : m105xb0cde684(nextElement);
                if (hardwareAddress != null && hardwareAddress.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    String sb2 = sb.toString();
                    if (nextElement.getName().equals(networkInterfaceName)) {
                        return sb2;
                    }
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String getNetworkInterfaceName() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "wifi.interface", "wlan0");
        } catch (Exception e) {
            e.printStackTrace();
            return "wlan0";
        }
    }

    public static JSONArray getMultiImei(Context context) throws JSONException {
        if (DeviceRegisterManager.checkPermissionBeforeCallSensitiveApi() && !InstallPmsUtils.checkReadPhoneStatePermission(context)) {
            return new JSONArray();
        }
        SensitiveApiCallback bpeaApiCallback = DeviceRegisterManager.getBpeaApiCallback();
        boolean z = DeviceRegisterManager.isOpenBpe() && bpeaApiCallback != null;
        JSONArray jSONArray = new JSONArray();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                jSONArray.put(createJsonObjForId(z ? bpeaApiCallback.getMeidBy0() : telephonyManager.getMeid(0), 0, ID_TYPE_MEID));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                jSONArray.put(createJsonObjForId(z ? bpeaApiCallback.getMeidBy1() : telephonyManager.getMeid(1), 1, ID_TYPE_MEID));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                jSONArray.put(createJsonObjForId(z ? bpeaApiCallback.getImeiBy0() : m104x72f14c84(telephonyManager, 0), 0, ID_TYPE_IMEI));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                jSONArray.put(createJsonObjForId(z ? bpeaApiCallback.getImeiBy1() : m104x72f14c84(telephonyManager, 1), 1, ID_TYPE_IMEI));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else {
            jSONArray.put(createJsonObjForId(getDeviceId(context, 0), 0, ID_TYPE_UNKNOWN));
            jSONArray.put(createJsonObjForId(getDeviceId(context, 1), 1, ID_TYPE_UNKNOWN));
        }
        return jSONArray;
    }

    public static boolean validMultiImei(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("id"))) {
                return true;
            }
        }
        return false;
    }

    private static JSONObject createJsonObjForId(String str, int i, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("id", str);
            jSONObject.put("slot_index", i);
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, str2);
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        com.ss.android.deviceregister.LogUtils.m88d(com.ss.android.deviceregister.LogUtils.TAG, "length:" + r0.length);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Class[] getMethodParamTypes(String str) {
        Class<?>[] clsArr = null;
        try {
            Method[] declaredMethods = TelephonyManager.class.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method = declaredMethods[i];
                if (str.equals(method.getName())) {
                    clsArr = method.getParameterTypes();
                    if (clsArr.length >= 1) {
                        break;
                    }
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.m89d(LogUtils.TAG, e.getMessage(), e);
        }
        return clsArr;
    }

    private static Object getPhoneInfo(int i, String str, Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method method = telephonyManager.getClass().getMethod(str, getMethodParamTypes(str));
            if (i >= 0) {
                return method.invoke(telephonyManager, Integer.valueOf(i));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.m89d(LogUtils.TAG, e.getMessage(), e);
            return null;
        }
    }

    private static String getDeviceId(Context context, int i) {
        String str = (String) getPhoneInfo(i, "getDeviceId", context);
        LogUtils.m88d(LogUtils.TAG, "getDeviceId  deviceId=" + str);
        return str;
    }

    public static String getCountry() {
        return Locale.getDefault().getCountry();
    }

    public static String getMacAddress(Context context) {
        return sWifiMacAddress.get(context);
    }
}
