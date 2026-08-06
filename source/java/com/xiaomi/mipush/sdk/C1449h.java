package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1488av;

/* renamed from: com.xiaomi.mipush.sdk.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1449h {

    /* renamed from: a */
    private static int f856a = -1;

    /* renamed from: a */
    public static EnumC1458q m1304a(Context context) {
        if (m1306a(context)) {
            return EnumC1458q.HUAWEI;
        }
        if (m1308c(context)) {
            return EnumC1458q.OPPO;
        }
        if (m1309d(context)) {
            return EnumC1458q.VIVO;
        }
        return EnumC1458q.OTHER;
    }

    /* renamed from: a */
    public static boolean m1306a(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) != null) {
                if (m1305a()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m1305a() {
        try {
            String str = (String) C1488av.m1570a("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, "ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(str)) {
                if (Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m1307b(Context context) {
        Object m1568a = C1488av.m1568a(C1488av.m1570a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object m1569a = C1488av.m1569a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (m1569a != null && (m1569a instanceof Integer)) {
            int intValue = ((Integer) Integer.class.cast(m1569a)).intValue();
            if (m1568a != null) {
                if (m1568a instanceof Integer) {
                    f856a = ((Integer) Integer.class.cast(m1568a)).intValue() == intValue ? 1 : 0;
                } else {
                    f856a = 0;
                    AbstractC1417b.m1101c("google service is not avaliable");
                }
            }
            AbstractC1417b.m1101c("is google service can be used" + (f856a > 0));
            return f856a > 0;
        }
        AbstractC1417b.m1101c("google service is not avaliable");
        f856a = 0;
        return false;
    }

    /* renamed from: c */
    public static boolean m1308c(Context context) {
        boolean z = false;
        Object m1570a = C1488av.m1570a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (m1570a != null && (m1570a instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(m1570a)).booleanValue();
        }
        AbstractC1417b.m1101c("color os push  is avaliable ? :" + z);
        return z;
    }

    /* renamed from: d */
    public static boolean m1309d(Context context) {
        boolean z = false;
        Object m1570a = C1488av.m1570a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (m1570a != null && (m1570a instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(m1570a)).booleanValue();
        }
        AbstractC1417b.m1101c("fun touch os push  is avaliable ? :" + z);
        return z;
    }
}
