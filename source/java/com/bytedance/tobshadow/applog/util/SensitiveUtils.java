package com.bytedance.tobshadow.applog.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.tobshadow.applog.ISensitiveInfoProvider;
import com.bytedance.tobshadow.applog.Level;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.C0380a;
import com.bytedance.tobshadow.bdtracker.C0411e;
import com.bytedance.tobshadow.bdtracker.C0444i4;
import com.bytedance.tobshadow.bdtracker.C0458k4;
import com.bytedance.tobshadow.bdtracker.C0563z4;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SensitiveUtils {
    public static final String CHANNEL_APP_KEY = "UMENG_APPKEY";
    public static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    public static final String KEY_BUILD_SERIAL = "build_serial";
    public static final String KEY_MAC = "mac_address";
    public static final String KEY_MC = "mc";

    /* renamed from: a */
    public static final List<String> f418a = Collections.singletonList("SensitiveUtils");

    /* renamed from: com.bytedance.tobshadow.applog.util.SensitiveUtils$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0368a implements C0563z4.a {

        /* renamed from: a */
        public final /* synthetic */ Context f419a;

        public C0368a(Context context) {
            this.f419a = context;
        }

        /* renamed from: com_bytedance_tobshadow_applog_util_SensitiveUtils$a_android_telephony_TelephonyManager_getDeviceId */
        private static String m245xcae59850(TelephonyManager telephonyManager) {
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

        @Override // com.bytedance.tobshadow.bdtracker.C0563z4.a
        /* renamed from: a */
        public String mo240a() {
            if (!SensitiveUtils.hasReadPhoneStatePermission(this.f419a)) {
                return null;
            }
            LoggerImpl.global().debug(SensitiveUtils.f418a, "[DeviceMeta&READ_PHONE_STATE] Try to get device id.", new Object[0]);
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.f419a.getSystemService("phone");
                return telephonyManager == null ? "" : m245xcae59850(telephonyManager);
            } catch (Throwable th) {
                LoggerImpl.global().error(SensitiveUtils.f418a, "Get device id failed", th, new Object[0]);
                return null;
            }
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.SensitiveUtils$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0369b implements C0563z4.a {
        /* renamed from: com_bytedance_tobshadow_applog_util_SensitiveUtils$b_java_net_NetworkInterface_getHardwareAddress */
        private static byte[] m246xcf1eb966(NetworkInterface networkInterface) {
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

        @Override // com.bytedance.tobshadow.bdtracker.C0563z4.a
        /* renamed from: a */
        public String mo240a() {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(nextElement.getName())) {
                    LoggerImpl.global().debug(SensitiveUtils.f418a, C0380a.m252a("[DeviceMeta] Try to get hardware address from ").append(nextElement.getName()).append(".").toString(), new Object[0]);
                    byte[] m246xcf1eb966 = m246xcf1eb966(nextElement);
                    if (m246xcf1eb966 != null && m246xcf1eb966.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b : m246xcf1eb966) {
                            sb.append(String.format("%02X:", Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
            }
            return "";
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.SensitiveUtils$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0370c implements C0563z4.a {

        /* renamed from: a */
        public final /* synthetic */ Context f420a;

        public C0370c(Context context) {
            this.f420a = context;
        }

        /* renamed from: com_bytedance_tobshadow_applog_util_SensitiveUtils$c_android_telephony_TelephonyManager_getImei */
        private static String m247x56a9d945(TelephonyManager telephonyManager, int i) {
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

        @Override // com.bytedance.tobshadow.bdtracker.C0563z4.a
        /* renamed from: a */
        public String mo240a() {
            if (Build.VERSION.SDK_INT < 26 || !SensitiveUtils.hasReadPhoneStatePermission(this.f420a)) {
                return null;
            }
            LoggerImpl.global().debug(SensitiveUtils.f418a, "[DeviceMeta&READ_PHONE_STATE] Try to get imei and meid info", new Object[0]);
            int activeSubscriptionInfoCount = SubscriptionManager.from(this.f420a).getActiveSubscriptionInfoCount();
            JSONArray jSONArray = new JSONArray();
            TelephonyManager telephonyManager = (TelephonyManager) this.f420a.getSystemService("phone");
            for (int i = 0; i < activeSubscriptionInfoCount; i++) {
                String str = "";
                try {
                    jSONArray.put(SensitiveUtils.m242a(telephonyManager == null ? "" : telephonyManager.getMeid(i), i, "meid"));
                } catch (Throwable unused) {
                }
                if (telephonyManager != null) {
                    try {
                        str = m247x56a9d945(telephonyManager, i);
                    } catch (Throwable unused2) {
                    }
                }
                jSONArray.put(SensitiveUtils.m242a(str, i, "imei"));
            }
            return jSONArray.toString();
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.SensitiveUtils$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0371d implements C0563z4.a {

        /* renamed from: a */
        public final /* synthetic */ Context f421a;

        public C0371d(Context context) {
            this.f421a = context;
        }

        @Override // com.bytedance.tobshadow.bdtracker.C0563z4.a
        /* renamed from: a */
        public String mo240a() {
            if (Build.VERSION.SDK_INT < 26 || this.f421a.getApplicationInfo().targetSdkVersion < 26 || !SensitiveUtils.hasReadPhoneStatePermission(this.f421a)) {
                return "";
            }
            LoggerImpl.global().debug(SensitiveUtils.f418a, "[DeviceMeta&READ_PHONE_STATE] Try to get build serial.", new Object[0]);
            return Build.getSerial();
        }
    }

    /* renamed from: a */
    public static String m241a(Context context, int i) {
        Object obj = null;
        if (!hasReadPhoneStatePermission(context)) {
            return null;
        }
        LoggerImpl.global().debug(f418a, "[READ_PHONE_STATE] Try to get device id.", new Object[0]);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                Method method = telephonyManager.getClass().getMethod("getDeviceId", m243a("getDeviceId"));
                if (i >= 0) {
                    obj = method.invoke(telephonyManager, Integer.valueOf(i));
                }
            }
        } catch (Throwable th) {
            LoggerImpl.global().error(f418a, "Read phone info failed.", th, new Object[0]);
        }
        return (String) obj;
    }

    /* renamed from: a */
    public static JSONObject m242a(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("id", str);
            jSONObject.put("slot_index", i);
            jSONObject.put(DBData.FIELD_TYPE, str2);
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        com.bytedance.tobshadow.applog.log.LoggerImpl.global().debug(com.bytedance.tobshadow.applog.util.SensitiveUtils.f418a, "params length:" + r2.length, new java.lang.Object[0]);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Class[] m243a(String str) {
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
            LoggerImpl.global().error(f418a, "TelephonyManager reflect method:{} failed", e, str);
        }
        return clsArr;
    }

    public static void addSensitiveParamsForUrlQuery(C0458k4 c0458k4, StringBuilder sb, JSONObject jSONObject) {
        C0444i4.m460a(sb, KEY_BUILD_SERIAL, (String) c0458k4.m500a(jSONObject, KEY_BUILD_SERIAL, (String) null, (Class<String>) String.class));
        JSONArray jSONArray = (JSONArray) c0458k4.m500a(jSONObject, "sim_serial_number", (String) null, (Class<String>) JSONArray.class);
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder(((JSONObject) jSONArray.get(0)).optString("sim_serial_number"));
            for (int i = 1; i < jSONArray.length(); i++) {
                sb2.append(IWeiboService.Scope.EMPTY_SCOPE).append(((JSONObject) jSONArray.get(i)).optString("sim_serial_number"));
            }
            C0444i4.m460a(sb, "sim_serial_number", sb2.toString());
        } catch (JSONException e) {
            LoggerImpl.global().error(f418a, "failed to get sim_serial_number", e, new Object[0]);
        }
    }

    public static void appendSensitiveParams(C0458k4 c0458k4, JSONObject jSONObject, Map<String, String> map, boolean z, Level level) {
        if (level == Level.L0) {
            if (z) {
                String str = (String) c0458k4.m500a(jSONObject, KEY_MC, (String) null, (Class<String>) String.class);
                String str2 = (String) c0458k4.m500a(jSONObject, "udid", (String) null, (Class<String>) String.class);
                if (!TextUtils.isEmpty(str)) {
                    map.put(KEY_MAC, str);
                }
                if (C0411e.m361a(str2)) {
                    map.put("uuid", str2);
                }
            }
            String str3 = (String) c0458k4.m500a(jSONObject, KEY_ALIYUN_UUID, (String) null, (Class<String>) String.class);
            if (!TextUtils.isEmpty(str3)) {
                map.put(KEY_ALIYUN_UUID, str3);
            }
        }
        String str4 = (String) c0458k4.m500a(jSONObject, KEY_BUILD_SERIAL, (String) null, (Class<String>) String.class);
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        map.put(KEY_BUILD_SERIAL, str4);
    }

    /* renamed from: com_bytedance_tobshadow_applog_util_SensitiveUtils_android_net_wifi_WifiInfo_getMacAddress */
    private static String m244xecdd233e(WifiInfo wifiInfo) {
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

    public static String getDeviceId(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return C0563z4.m765a(context).m766a("TelephonyManager.getDeviceId", new C0368a(context));
        } catch (Throwable th) {
            LoggerImpl.global().error(f418a, "Get device id failed", th, new Object[0]);
            return null;
        }
    }

    public static String getMacAddress(ISensitiveInfoProvider iSensitiveInfoProvider, Context context) {
        return iSensitiveInfoProvider != null ? iSensitiveInfoProvider.getMac() : getMacAddressFromSystem(context);
    }

    public static String getMacAddressFromSystem(Context context) {
        String str;
        try {
            str = C0563z4.m765a(context).m766a("NetworkInterface.getHardwareAddress", new C0369b());
        } catch (Throwable th) {
            LoggerImpl.global().error(f418a, "Get HardwareAddress failed", th, new Object[0]);
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(OnekeyLoginConstants.NETWORK_TYPE_WIFI_STR);
            return (wifiManager == null || wifiManager.getConnectionInfo() == null) ? str : m244xecdd233e(wifiManager.getConnectionInfo());
        } catch (Throwable th2) {
            LoggerImpl.global().error(f418a, "Get MacAddress failed", th2, new Object[0]);
            return str;
        }
    }

    public static JSONArray getMultiImeiFallback(Context context) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(m242a(m241a(context, 0), 0, "unknown"));
        jSONArray.put(m242a(m241a(context, 1), 1, "unknown"));
        return jSONArray;
    }

    public static JSONArray getMultiImeiFromSystem(Context context) {
        try {
            String m766a = C0563z4.m765a(context).m766a("TelephonyManager.getMultiImei", new C0370c(context));
            return TextUtils.isEmpty(m766a) ? new JSONArray() : new JSONArray(m766a);
        } catch (Throwable th) {
            LoggerImpl.global().error(f418a, "Failed to get meid 0", th, new Object[0]);
            return null;
        }
    }

    public static String getSerialNumber(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            str = C0563z4.m765a(context).m766a("Build.getSerial", new C0371d(context));
        } catch (Throwable th) {
            LoggerImpl.global().error(f418a, "Build getSerial failed.", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
            str = Build.SERIAL;
        }
        return (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) ? "" : str;
    }

    public static boolean hasPermission(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            LoggerImpl.global().error(f418a, "check has permission failed.", th, new Object[0]);
            return false;
        }
    }

    public static boolean hasReadPhoneStatePermission(Context context) {
        return hasPermission(context, Build.VERSION.SDK_INT > 28 ? "android.permission.READ_PRECISE_PHONE_STATE" : "android.permission.READ_PHONE_STATE");
    }

    public static boolean validMultiImei(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return validMultiImei(new JSONArray(str));
            } catch (JSONException e) {
                LoggerImpl.global().error(f418a, "JSON handle failed", e, new Object[0]);
            }
        }
        return false;
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
}
