package androidx.core.telephony;

import android.os.Build;
import android.telephony.TelephonyManager;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    private static String androidx_core_telephony_TelephonyManagerCompat_android_telephony_TelephonyManager_getDeviceId(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String deviceId = telephonyManager.getDeviceId();
        heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, deviceId, extraInfo, true);
        return deviceId;
    }

    public static String getImei(TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getImei(telephonyManager);
        }
        int subscriptionId = getSubscriptionId(telephonyManager);
        if (subscriptionId != Integer.MAX_VALUE && subscriptionId != -1) {
            return Api23Impl.getDeviceId(telephonyManager, SubscriptionManagerCompat.getSlotIndex(subscriptionId));
        }
        return androidx_core_telephony_TelephonyManagerCompat_android_telephony_TelephonyManager_getDeviceId(telephonyManager);
    }

    public static int getSubscriptionId(TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getSubscriptionId(telephonyManager);
        }
        try {
            if (sGetSubIdMethod == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                sGetSubIdMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSubIdMethod.invoke(telephonyManager, new Object[0]);
            if (num == null || num.intValue() == -1) {
                return Integer.MAX_VALUE;
            }
            return num.intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }

    private TelephonyManagerCompat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        static int getSubscriptionId(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    /* loaded from: classes2.dex */
    private static class Api26Impl {
        private static String androidx_core_telephony_TelephonyManagerCompat$Api26Impl_android_telephony_TelephonyManager_getImei(TelephonyManager telephonyManager) {
            HeliosApiHook heliosApiHook = new HeliosApiHook();
            Object[] objArr = new Object[0];
            ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
            Result preInvoke = heliosApiHook.preInvoke(101601, "android/telephony/TelephonyManager", "getImei", telephonyManager, objArr, "java.lang.String", extraInfo);
            if (preInvoke.isIntercept()) {
                heliosApiHook.postInvoke(101601, "android/telephony/TelephonyManager", "getImei", telephonyManager, objArr, null, extraInfo, false);
                return (String) preInvoke.getReturnValue();
            }
            String imei = telephonyManager.getImei();
            heliosApiHook.postInvoke(101601, "android/telephony/TelephonyManager", "getImei", telephonyManager, objArr, imei, extraInfo, true);
            return imei;
        }

        private Api26Impl() {
        }

        static String getImei(TelephonyManager telephonyManager) {
            return androidx_core_telephony_TelephonyManagerCompat$Api26Impl_android_telephony_TelephonyManager_getImei(telephonyManager);
        }
    }

    /* loaded from: classes2.dex */
    private static class Api23Impl {
        private static String androidx_core_telephony_TelephonyManagerCompat$Api23Impl_android_telephony_TelephonyManager_getDeviceId(TelephonyManager telephonyManager, int i) {
            HeliosApiHook heliosApiHook = new HeliosApiHook();
            Object[] objArr = {Integer.valueOf(i)};
            ExtraInfo extraInfo = new ExtraInfo(false, "(I)Ljava/lang/String;");
            Result preInvoke = heliosApiHook.preInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, "java.lang.String", extraInfo);
            if (preInvoke.isIntercept()) {
                heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, null, extraInfo, false);
                return (String) preInvoke.getReturnValue();
            }
            String deviceId = telephonyManager.getDeviceId(i);
            heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, deviceId, extraInfo, true);
            return deviceId;
        }

        private Api23Impl() {
        }

        static String getDeviceId(TelephonyManager telephonyManager, int i) {
            return androidx_core_telephony_TelephonyManagerCompat$Api23Impl_android_telephony_TelephonyManager_getDeviceId(telephonyManager, i);
        }
    }
}
