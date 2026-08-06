package com.bytedance.realx.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Pattern;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes4.dex */
public class NetworkTypeUtils {
    private static final boolean DEBUG_MOBILE = false;
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String TAG = "NetworkTypeUtils";
    private static String debugInfo = "";
    private static NetworkTypeInterceptor sNetworkTypeInterceptor;

    /* loaded from: classes4.dex */
    public interface NetworkTypeInterceptor {
        NetworkType getNetworkType();
    }

    /* loaded from: classes4.dex */
    public enum CompressType {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int nativeInt;

        CompressType(int ni) {
            this.nativeInt = ni;
        }
    }

    /* loaded from: classes4.dex */
    public enum NetworkType {
        UNKNOWN(-1),
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        MOBILE_5G(6);

        final int nativeInt;

        NetworkType(int ni) {
            this.nativeInt = ni;
        }

        public int getValue() {
            return this.nativeInt;
        }

        public boolean isAvailable() {
            return this != NONE;
        }
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor interceptor) {
        sNetworkTypeInterceptor = interceptor;
    }

    public static boolean is2G(Context context) {
        NetworkType networkType = getNetworkType(context, null);
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

    public static NetworkInfo isNetWorkConnected(Context context, Intent intent) {
        NetworkInfo networkInfo;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) != null) {
            if (NetworkInfo.State.CONNECTED == networkInfo.getState() && networkInfo.isAvailable()) {
                if (networkInfo.getType() == 1 || networkInfo.getType() == 0) {
                    RXLogging.i(TAG, "-------networkInfo wifi or mobile is connected");
                }
                return networkInfo;
            }
            RXLogging.i(TAG, "------networkInfo is discconnected");
        }
        return null;
    }

    public static void registerReceiver(Context context, BroadcastReceiver receiver) {
        if (receiver == null || context == null) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            INVOKEVIRTUAL_com_bytedance_realx_base_NetworkTypeUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context.getApplicationContext(), receiver, intentFilter);
        } catch (Exception e) {
            RXLogging.i(TAG, "registerReceiver error: " + e.getMessage());
        }
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver receiver) {
        if (receiver == null || context == null) {
            return;
        }
        try {
            INVOKEVIRTUAL_com_bytedance_realx_base_NetworkTypeUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(context.getApplicationContext(), receiver);
        } catch (Exception e) {
            RXLogging.i(TAG, "unregisterReceiver error: " + e.getMessage());
        }
    }

    public static NetworkType getNetworkType(Context context, Intent intent) {
        int subtype;
        NetworkTypeInterceptor networkTypeInterceptor = sNetworkTypeInterceptor;
        if (networkTypeInterceptor != null && networkTypeInterceptor.getNetworkType() != NetworkType.NONE) {
            return sNetworkTypeInterceptor.getNetworkType();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if ((activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) && activeNetworkInfo == null && intent != null && ((activeNetworkInfo = isNetWorkConnected(context, intent)) == null || !activeNetworkInfo.isAvailable())) {
                RXLogging.i(TAG, "-----------info is null");
                return NetworkType.NONE;
            }
            int type = activeNetworkInfo.getType();
            debugInfo = "NetworkInfo type:" + type;
            if (1 == type) {
                return NetworkType.WIFI;
            }
            if (type == 0) {
                if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                    debugInfo += " getNetworkType through TelephoneManager;";
                    subtype = getNetWorkTypeThroughBPEA(context);
                } else {
                    subtype = activeNetworkInfo.getSubtype();
                    debugInfo += " getNetworkType through ConnectivityManager;";
                }
                debugInfo += " TelephonyManager type:" + subtype;
                switch (subtype) {
                    case 0:
                        return NetworkType.UNKNOWN;
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return NetworkType.MOBILE_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return NetworkType.MOBILE_3G;
                    case 13:
                    case 18:
                        return NetworkType.MOBILE_4G;
                    case 19:
                    default:
                        return NetworkType.UNKNOWN;
                    case 20:
                        return NetworkType.MOBILE_5G;
                }
            }
            return NetworkType.MOBILE;
        } catch (Throwable th) {
            debugInfo = th.toString();
            return NetworkType.UNKNOWN;
        }
    }

    public static String getDebugInfo() {
        return debugInfo;
    }

    public static String getNetworkAccessType(Context context) {
        return getNetworkAccessType(getNetworkType(context, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.base.NetworkTypeUtils$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType;

        static {
            int[] iArr = new int[NetworkType.values().length];
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType = iArr;
            try {
                iArr[NetworkType.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE_5G.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000a. Please report as an issue. */
    public static String getNetworkAccessType(NetworkType nt) {
        String str;
        try {
            switch (AnonymousClass1.$SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[nt.ordinal()]) {
                case 1:
                    str = "wifi";
                    return str;
                case 2:
                    str = "2g";
                    return str;
                case 3:
                    str = "3g";
                    return str;
                case 4:
                    str = "4g";
                    return str;
                case 5:
                    str = "5g";
                    return str;
                case 6:
                    str = "mobile";
                    return str;
                default:
                    return "";
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public static String format(final List<Pair<String, String>> params, final String encoding) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, String> pair : params) {
            String encode = encode((String) pair.first, encoding);
            String str = (String) pair.second;
            String encode2 = str != null ? encode(str, encoding) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
        }
        return sb.toString();
    }

    private static String encode(final String content, final String encoding) {
        if (encoding == null) {
            encoding = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(content, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static boolean isIpv4(String ip) {
        return Pattern.matches("^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$", ip);
    }

    public static boolean isIpv6(String ip) {
        return Pattern.matches("^\\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?\\s*$", ip);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getNetWorkTypeThroughBPEA(Context context) {
        int i;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            cls = Class.forName("com.bytedance.bpea.entry.api.device.info.TelephonyManagerEntry");
            cls2 = Class.forName("com.bytedance.bpea.basics.Cert");
            cls3 = Class.forName("com.bytedance.bpea.cert.token.TokenCert");
        } catch (Exception unused) {
            i = -1;
        }
        if (cls != null && cls2 != null && cls3 != null) {
            Method declaredMethod = cls.getDeclaredMethod("getNetworkType", TelephonyManager.class, cls2);
            Method declaredMethod2 = cls3.getDeclaredMethod("with", String.class);
            if (declaredMethod != null && declaredMethod2 != null) {
                i = ((Integer) declaredMethod.invoke(null, telephonyManager, declaredMethod2.invoke(null, "bpea-rtc_generic_device_info"))).intValue();
                try {
                    debugInfo += " getNetworkType through BPEA;";
                } catch (Exception unused2) {
                    RXLogging.i(TAG, "BPEA not exist");
                    if (i != -1) {
                    }
                }
                if (i != -1) {
                    return i;
                }
                int intValue = Integer.valueOf(telephonyManager.getDataNetworkType()).intValue();
                debugInfo += " getNetworkType through system;";
                return intValue;
            }
        }
        i = -1;
        if (i != -1) {
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_bytedance_realx_base_NetworkTypeUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_bytedance_realx_base_NetworkTypeUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
