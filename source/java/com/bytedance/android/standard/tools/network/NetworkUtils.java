package com.bytedance.android.standard.tools.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.bytedance.android.standard.tools.string.StringUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes3.dex */
public final class NetworkUtils {
    static final boolean DEBUG_MOBILE = false;
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final int MAX_24G = 2500;
    private static final int MAX_5G = 5900;
    private static final int MIN_24G = 2400;
    private static final int MIN_5G = 4900;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final int NR_STATE = 3;
    private static final String PARAMETER_SEPARATOR = "&";
    private static NetworkTypeInterceptor sNetworkTypeInterceptor;
    private static volatile boolean useCheckNetworkFast;
    private static NetworkType sNetworkType = NetworkType.UNKNOWN;
    private static boolean sIsReceiverRegisted = false;
    private static volatile long sInterval = 2000;
    private static long lastAdjustTime = 0;

    /* loaded from: classes3.dex */
    public interface NetworkTypeInterceptor {
        NetworkType getNetworkType();
    }

    private static String com_bytedance_android_standard_tools_network_NetworkUtils_android_net_wifi_WifiInfo_getMacAddress(WifiInfo wifiInfo) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String macAddress = wifiInfo.getMacAddress();
        heliosApiHook.postInvoke(101700, "android/net/wifi/WifiInfo", "getMacAddress", wifiInfo, objArr, macAddress, extraInfo, true);
        return macAddress;
    }

    private static byte[] com_bytedance_android_standard_tools_network_NetworkUtils_java_net_NetworkInterface_getHardwareAddress(NetworkInterface networkInterface) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()[B");
        Result preInvoke = heliosApiHook.preInvoke(101701, "java/net/NetworkInterface", "getHardwareAddress", networkInterface, objArr, "byte[]", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101701, "java/net/NetworkInterface", "getHardwareAddress", networkInterface, objArr, null, extraInfo, false);
            return (byte[]) preInvoke.getReturnValue();
        }
        byte[] hardwareAddress = networkInterface.getHardwareAddress();
        heliosApiHook.postInvoke(101701, "java/net/NetworkInterface", "getHardwareAddress", networkInterface, objArr, hardwareAddress, extraInfo, true);
        return hardwareAddress;
    }

    public static boolean is24GHz(int i) {
        return i > MIN_24G && i < 2500;
    }

    public static boolean is5GHz(int i) {
        return i > MIN_5G && i < MAX_5G;
    }

    public static void setUseCheckNetworkFast(boolean z) {
        useCheckNetworkFast = z;
    }

    private NetworkUtils() {
    }

    /* loaded from: classes3.dex */
    public enum CompressType {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int nativeInt;

        CompressType(int i) {
            this.nativeInt = i;
        }
    }

    /* loaded from: classes3.dex */
    public enum NetworkType {
        UNKNOWN(-1),
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        MOBILE_5G(6),
        WIFI_24GHZ(7),
        WIFI_5GHZ(8),
        MOBILE_3G_H(9),
        MOBILE_3G_HP(10);

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

        public boolean is4GOrHigher() {
            return this == MOBILE_4G || this == MOBILE_5G;
        }

        public boolean is3GOrHigher() {
            return this == MOBILE_3G || this == MOBILE_3G_H || this == MOBILE_3G_HP || this == MOBILE_4G || this == MOBILE_5G;
        }

        public boolean isAvailable() {
            return (this == UNKNOWN || this == NONE) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setNetworkType(NetworkType networkType) {
        sNetworkType = networkType;
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor networkTypeInterceptor) {
        sNetworkTypeInterceptor = networkTypeInterceptor;
    }

    public static boolean is2G(Context context) {
        NetworkType networkType = getNetworkType(context);
        return networkType == NetworkType.MOBILE || networkType == NetworkType.MOBILE_2G;
    }

    public static boolean isWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                NetworkTypeInterceptor networkTypeInterceptor = sNetworkTypeInterceptor;
                return (networkTypeInterceptor == null || networkTypeInterceptor.getNetworkType() == NetworkType.NONE) ? 1 == activeNetworkInfo.getType() : sNetworkTypeInterceptor.getNetworkType() == NetworkType.WIFI;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
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

    public static String getMacAddress(Context context) {
        try {
            String macAddressNew = getMacAddressNew(context);
            if (!StringUtils.isEmpty(macAddressNew)) {
                return macAddressNew;
            }
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return com_bytedance_android_standard_tools_network_NetworkUtils_android_net_wifi_WifiInfo_getMacAddress(connectionInfo);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getMacAddressNew(Context context) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                byte[] com_bytedance_android_standard_tools_network_NetworkUtils_java_net_NetworkInterface_getHardwareAddress = com_bytedance_android_standard_tools_network_NetworkUtils_java_net_NetworkInterface_getHardwareAddress(nextElement);
                if (com_bytedance_android_standard_tools_network_NetworkUtils_java_net_NetworkInterface_getHardwareAddress != null && com_bytedance_android_standard_tools_network_NetworkUtils_java_net_NetworkInterface_getHardwareAddress.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b : com_bytedance_android_standard_tools_network_NetworkUtils_java_net_NetworkInterface_getHardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    String sb2 = sb.toString();
                    if (nextElement.getName().equals("wlan0")) {
                        return sb2;
                    }
                }
            }
        } catch (SocketException unused) {
        }
        return null;
    }

    public static NetworkType getNetworkTypeFast(Context context) {
        checkNetworkTypeInit(context);
        adjustNetwork(context);
        return sNetworkType;
    }

    public static boolean is2GFast(Context context) {
        checkNetworkTypeInit(context);
        adjustNetwork(context);
        return sNetworkType.is2G();
    }

    public static boolean isWifiFast(Context context) {
        checkNetworkTypeInit(context);
        adjustNetwork(context);
        return sNetworkType.isWifi();
    }

    public static boolean isNetworkAvailableFast(Context context) {
        checkNetworkTypeInit(context);
        adjustNetwork(context);
        return sNetworkType.isAvailable();
    }

    private static void checkNetworkTypeInit(Context context) {
        NetworkTypeInterceptor networkTypeInterceptor = sNetworkTypeInterceptor;
        if (networkTypeInterceptor != null && networkTypeInterceptor.getNetworkType() != NetworkType.NONE) {
            sNetworkType = sNetworkTypeInterceptor.getNetworkType();
            return;
        }
        registerReceiver(context);
        if (sNetworkType == NetworkType.UNKNOWN) {
            sNetworkType = getNetworkTypeIntern(context);
        }
    }

    public static void setAdjustNetworkInterval(long j) {
        if (j > 0) {
            sInterval = j;
        }
    }

    private static void adjustNetwork(Context context) {
        if (System.currentTimeMillis() - lastAdjustTime > sInterval) {
            sNetworkType = getNetworkTypeIntern(context);
            lastAdjustTime = System.currentTimeMillis();
        }
    }

    private static void registerReceiver(Context context) {
        if (sIsReceiverRegisted || context == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        INVOKEVIRTUAL_com_bytedance_android_standard_tools_network_NetworkUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context.getApplicationContext(), new NetworkConnectChangeReceiver(), intentFilter);
        sIsReceiverRegisted = true;
    }

    private static boolean isNRConnected(TelephonyManager telephonyManager) {
        int i;
        try {
            Object invoke = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getServiceState", new Class[0]).invoke(telephonyManager, new Object[0]);
            for (Method method : Class.forName(invoke.getClass().getName()).getDeclaredMethods()) {
                i = (method.getName().equals("getNrStatus") || method.getName().equals("getNrState")) ? 0 : i + 1;
                method.setAccessible(true);
                return ((Integer) method.invoke(invoke, new Object[0])).intValue() == 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static NetworkType getNetworkTypeIntern(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return NetworkType.WIFI;
                }
                if (type == 0) {
                    int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                    if (networkType != 3) {
                        if (networkType == 20) {
                            return NetworkType.MOBILE_5G;
                        }
                        if (networkType != 5 && networkType != 6) {
                            switch (networkType) {
                                case 8:
                                case 9:
                                case 10:
                                    break;
                                default:
                                    switch (networkType) {
                                        case 12:
                                        case 14:
                                        case 15:
                                            break;
                                        case 13:
                                            return NetworkType.MOBILE_4G;
                                        default:
                                            return NetworkType.MOBILE;
                                    }
                            }
                        }
                    }
                    return NetworkType.MOBILE_3G;
                }
                return NetworkType.MOBILE;
            }
            return NetworkType.NONE;
        } catch (Throwable unused) {
            return NetworkType.MOBILE;
        }
    }

    public static NetworkType getNetworkType(Context context) {
        if (useCheckNetworkFast) {
            return getNetworkTypeFast(context);
        }
        return getNetworkTypeIntern(context);
    }

    public static String getNetworkTypeDetail(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return isWifi5GHz(context) ? "wifi5g" : "wifi";
                }
                if (type != 0) {
                    return "unknown";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (telephonyManager.getNetworkType()) {
                    case 2:
                        return "edge";
                    case 3:
                        return "umts";
                    case 4:
                        return "cdma";
                    case 5:
                        return "evdo_0";
                    case 6:
                        return "evdo_a";
                    case 7:
                    case 11:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    default:
                        return String.valueOf(telephonyManager.getNetworkType());
                    case 8:
                        return "hsdpa";
                    case 9:
                        return "hsupa";
                    case 10:
                        return "hspa";
                    case 12:
                        return "evdo_b";
                    case 13:
                        return "lte";
                    case 14:
                        return "ehrpd";
                    case 15:
                        return "hspap";
                    case 20:
                        return "nr";
                }
            }
            return "none";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static boolean isWifi5GHz(Context context) {
        return is5GHz(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getFrequency());
    }

    public static String getNetworkAccessTypeFast(Context context) {
        return getNetworkAccessType(getNetworkTypeFast(context));
    }

    public static String getNetworkAccessType(Context context) {
        return getNetworkAccessType(getNetworkType(context));
    }

    public static String getNetworkAccessType(NetworkType networkType) {
        return networkType == NetworkType.WIFI ? "wifi" : networkType == NetworkType.WIFI_24GHZ ? "wifi24ghz" : networkType == NetworkType.WIFI_5GHZ ? "wifi5ghz" : networkType == NetworkType.MOBILE_2G ? "2g" : networkType == NetworkType.MOBILE_3G ? "3g" : networkType == NetworkType.MOBILE_3G_H ? "3gh" : networkType == NetworkType.MOBILE_3G_HP ? "3ghp" : networkType == NetworkType.MOBILE_4G ? "4g" : networkType == NetworkType.MOBILE_5G ? "5g" : networkType == NetworkType.MOBILE ? "mobile" : "";
    }

    public static String format(List<Pair<String, String>> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, String> pair : list) {
            String encode = encode((String) pair.first, str);
            String str2 = (String) pair.second;
            String encode2 = str2 != null ? encode(str2, str) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
        }
        return sb.toString();
    }

    private static String encode(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_bytedance_android_standard_tools_network_NetworkUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
