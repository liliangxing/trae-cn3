package com.bytedance.tobshadow.bdtracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* renamed from: com.bytedance.tobshadow.bdtracker.q5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0501q5 {

    /* renamed from: a */
    public static long f950a;

    /* renamed from: b */
    public static a f951b = a.UNKNOWN;

    /* renamed from: c */
    public static boolean f952c;

    /* renamed from: com.bytedance.tobshadow.bdtracker.q5$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum a {
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


        /* renamed from: a */
        public final int f966a;

        a(int i) {
            this.f966a = i;
        }

        /* renamed from: a */
        public boolean m625a() {
            return (this == UNKNOWN || this == NONE) ? false : true;
        }
    }

    /* renamed from: a */
    public static a m621a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return a.WIFI;
                }
                if (type != 0) {
                    return a.MOBILE;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return a.NONE;
                }
                int networkType = telephonyManager.getNetworkType();
                if (networkType != 3) {
                    if (networkType == 20) {
                        return a.MOBILE_5G;
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
                                        return a.MOBILE_4G;
                                    default:
                                        return a.MOBILE;
                                }
                        }
                    }
                }
                return a.MOBILE_3G;
            }
            return a.NONE;
        } catch (Throwable unused) {
            return a.MOBILE;
        }
    }

    /* renamed from: a */
    public static String m622a(Context context, boolean z) {
        a m623b = m623b(context, z);
        return m623b == a.WIFI ? OnekeyLoginConstants.NETWORK_TYPE_WIFI_STR : m623b == a.WIFI_24GHZ ? "wifi24ghz" : m623b == a.WIFI_5GHZ ? "wifi5ghz" : m623b == a.MOBILE_2G ? "2g" : m623b == a.MOBILE_3G ? "3g" : m623b == a.MOBILE_3G_H ? "3gh" : m623b == a.MOBILE_3G_HP ? "3ghp" : m623b == a.MOBILE_4G ? "4g" : m623b == a.MOBILE_5G ? "5g" : m623b == a.MOBILE ? "mobile" : "";
    }

    /* renamed from: b */
    public static a m623b(Context context, boolean z) {
        if (!f952c && context != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                m620x9c0e597d(context.getApplicationContext(), new C0562z3(), intentFilter);
            } finally {
                try {
                } finally {
                }
            }
        }
        if (f951b == a.UNKNOWN) {
            f951b = m621a(context);
        }
        if (z && System.currentTimeMillis() - f950a > 2000) {
            f951b = m621a(context);
            f950a = System.currentTimeMillis();
        }
        return f951b;
    }

    /* renamed from: b */
    public static boolean m624b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_tobshadow_bdtracker_q5_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m620x9c0e597d(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
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
