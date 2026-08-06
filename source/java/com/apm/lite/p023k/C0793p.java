package com.apm.lite.p023k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.apm.lite.p022j.C0770e;

/* renamed from: com.apm.lite.k.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0793p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apm.lite.k.p$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f597a;

        static {
            int[] iArr = new int[C0770e.b.values().length];
            f597a = iArr;
            try {
                iArr[C0770e.b.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f597a[C0770e.b.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f597a[C0770e.b.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f597a[C0770e.b.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f597a[C0770e.b.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f597a[C0770e.b.MOBILE_5G.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: a */
    public static String m883a(Context context) {
        return m884a(m886c(context));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000a. Please report as an issue. */
    /* renamed from: a */
    public static String m884a(C0770e.b bVar) {
        String str;
        try {
            switch (AnonymousClass1.f597a[bVar.ordinal()]) {
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

    /* renamed from: b */
    public static boolean m885b(Context context) {
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

    /* renamed from: c */
    private static C0770e.b m886c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return C0770e.b.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return C0770e.b.WIFI;
                }
                if (type != 0) {
                    return C0770e.b.MOBILE;
                }
                int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                if (networkType != 3) {
                    if (networkType == 20) {
                        return C0770e.b.MOBILE_5G;
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
                                        return C0770e.b.MOBILE_4G;
                                    default:
                                        return C0770e.b.MOBILE;
                                }
                        }
                    }
                }
                return C0770e.b.MOBILE_3G;
            }
            return C0770e.b.NONE;
        } catch (Throwable unused) {
            return C0770e.b.MOBILE;
        }
    }
}
