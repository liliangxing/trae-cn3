package com.xiaomi.push;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* renamed from: com.xiaomi.push.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1700p {
    /* renamed from: a */
    public static String m3459a(String str, String str2) {
        try {
            return (String) C1702q.m3463a(null, "android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            AbstractC1417b.m1089a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
