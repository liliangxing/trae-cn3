package com.bytedance.upc.cache;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.upc.common.log.LogUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class ApiHookManager {
    public static AtomicBoolean mCacheOaid = new AtomicBoolean(false);

    public static Pair<Boolean, String> preHandle(String str, String str2, Object[] objArr) {
        try {
        } catch (Throwable th) {
            LogUtils.e("api hook manager prehandle err: " + th);
        }
        if (str.contains("android/telephony/TelephonyManager") && str2.contains("getImei")) {
            return preHandleImei();
        }
        if (str.contains("android/telephony/TelephonyManager") && str2.contains("getDeviceId")) {
            return preHandleDeviceId();
        }
        if (str.contains("android/telephony/TelephonyManager") && str2.contains("getSimOperator")) {
            return preHandleImsi();
        }
        if (str.equals("android/net/wifi/WifiInfo") && str2.equals("getMacAddress")) {
            return preHandleMac();
        }
        if (str.equals("java/net/NetworkInterface") && str2.equals("getHardwareAddress")) {
            return preHandleHardwareAddress();
        }
        if ((str.equals("com/bytedance/bdinstall/oaid") || str.equals("com/ss/android/deviceregister/base/Oaid")) && str2.equals("getOaidId")) {
            return preHandleOaid();
        }
        if ((str.equals("android/provider/Settings$System") || str.equals("android/provider/Settings$Secure")) && str2.equals("getString") && TextUtils.equals("android_id", (String) objArr[1])) {
            preHandleAndroidId();
        }
        return new Pair<>(false, null);
    }

    public static void postHandle(String str, String str2, Object[] objArr, Object obj) {
        if (obj != null) {
            try {
                if (str.contains("android/telephony/TelephonyManager") && str2.contains("getImei")) {
                    postHandleImei(obj);
                    return;
                }
                if (str.contains("android/telephony/TelephonyManager") && str2.contains("getDeviceId")) {
                    postHandleDeviceId(obj);
                    return;
                }
                if (str.contains("android/telephony/TelephonyManager") && str2.contains("getSimOperator")) {
                    postHandleImsi(obj);
                    return;
                }
                if (str.equals("android/net/wifi/WifiInfo") && str2.equals("getMacAddress")) {
                    postHandleMacOrHardwareAddress(obj);
                    return;
                }
                if (str.equals("java/net/NetworkInterface") && str2.equals("getHardwareAddress")) {
                    postHandleMacOrHardwareAddress(obj);
                    return;
                }
                if ((str.equals("com/bytedance/bdinstall/oaid/Oaid") || str.equals("com/ss/android/deviceregister/base/Oaid")) && str2.equals("getOaidId")) {
                    postHandleOaid(obj);
                } else if ((str.equals("android/provider/Settings$System") || str.equals("android/provider/Settings$Secure")) && str2.equals("getString") && TextUtils.equals("android_id", (String) objArr[1])) {
                    postHandleAndroidId(obj);
                }
            } catch (Throwable th) {
                LogUtils.e("api hook manager posthandle err: " + th);
            }
        }
    }

    private static Pair<Boolean, String> preHandleImei() {
        if (ApiHookCache.INSTANCE.check() != null) {
            return new Pair<>(false, "");
        }
        String obtain = ApiHookCache.INSTANCE.obtain(ApiHookCache.KEY_IMEI, "");
        if (!TextUtils.isEmpty(obtain)) {
            return new Pair<>(true, obtain);
        }
        return new Pair<>(false, "");
    }

    private static void postHandleImei(Object obj) {
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ApiHookCache.INSTANCE.save(ApiHookCache.KEY_IMEI, str);
        ApiHookRecord.INSTANCE.updateApiRecord(ApiHookRecord.KEY_IMEI, str);
    }

    private static Pair<Boolean, String> preHandleDeviceId() {
        if (ApiHookCache.INSTANCE.check() != null) {
            return new Pair<>(false, "");
        }
        String obtain = ApiHookCache.INSTANCE.obtain(ApiHookCache.KEY_DEVICE_ID, "");
        if (!TextUtils.isEmpty(obtain)) {
            return new Pair<>(true, obtain);
        }
        return new Pair<>(false, "");
    }

    private static void postHandleDeviceId(Object obj) {
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ApiHookCache.INSTANCE.save(ApiHookCache.KEY_DEVICE_ID, str);
        ApiHookRecord.INSTANCE.updateApiRecord(ApiHookRecord.KEY_DEVICE_ID, str);
    }

    private static Pair<Boolean, String> preHandleImsi() {
        return new Pair<>(false, null);
    }

    private static void postHandleImsi(Object obj) {
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ApiHookRecord.INSTANCE.updateApiRecord(ApiHookRecord.KEY_IMSI, str);
    }

    private static Pair<Boolean, String> preHandleMac() {
        return new Pair<>(false, null);
    }

    private static Pair<Boolean, String> preHandleHardwareAddress() {
        return new Pair<>(false, null);
    }

    private static void postHandleMacOrHardwareAddress(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ApiHookRecord.INSTANCE.updateApiRecord(ApiHookRecord.KEY_MAC, str);
            return;
        }
        if (obj instanceof byte[]) {
            StringBuilder sb = new StringBuilder();
            for (byte b : (byte[]) obj) {
                sb.append(String.format("%02X:", Byte.valueOf(b)));
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return;
            }
            ApiHookRecord.INSTANCE.updateApiRecord(ApiHookRecord.KEY_MAC, sb2);
        }
    }

    private static Pair<Boolean, String> preHandleOaid() {
        return new Pair<>(false, null);
    }

    private static void postHandleOaid(Object obj) {
        String str = (String) obj;
        if (!mCacheOaid.compareAndSet(false, true) || TextUtils.isEmpty(str)) {
            return;
        }
        ApiHookRecord.INSTANCE.updateApiRecord(ApiHookRecord.KEY_OAID, str);
    }

    private static Pair<Boolean, String> preHandleAndroidId() {
        return new Pair<>(false, null);
    }

    private static void postHandleAndroidId(Object obj) {
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ApiHookRecord.INSTANCE.updateApiRecord(ApiHookRecord.KEY_ANDROID_ID, str);
    }
}
