package com.apm.lite.k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.apm.lite.j.e;

/* loaded from: classes2.dex */
public final class p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apm.lite.k.p$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.b.values().length];
            a = iArr;
            try {
                iArr[e.b.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.b.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.b.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.b.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e.b.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[e.b.MOBILE_5G.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static String a(Context context) {
        return a(c(context));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000a. Please report as an issue. */
    public static String a(e.b bVar) {
        String str;
        try {
            switch (AnonymousClass1.a[bVar.ordinal()]) {
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
                    str = "mobile";
                    return str;
                case 6:
                    str = "5g";
                    return str;
                default:
                    return "";
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception unused) {
            return false;
        }
    }

    private static e.b c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return e.b.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return e.b.WIFI;
                }
                if (type != 0) {
                    return e.b.MOBILE;
                }
                int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                if (networkType != 3) {
                    if (networkType == 20) {
                        return e.b.MOBILE_5G;
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
                                        return e.b.MOBILE_4G;
                                    default:
                                        return e.b.MOBILE;
                                }
                        }
                    }
                }
                return e.b.MOBILE_3G;
            }
            return e.b.NONE;
        } catch (Throwable unused) {
            return e.b.MOBILE;
        }
    }
}
