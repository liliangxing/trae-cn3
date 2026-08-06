package com.vivo.push.util;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.vivo.push.p010b.C1206c;

/* compiled from: OperateUtil.java */
/* renamed from: com.vivo.push.util.y */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1398y {
    /* renamed from: a */
    public static int m1057a(C1206c c1206c) {
        C1369ad m941c = C1369ad.m941c();
        int m1067b = c1206c.m1067b();
        long currentTimeMillis = System.currentTimeMillis();
        int m987b = m941c.m987b("com.vivo.push_preferences.operate." + m1067b + "OPERATE_COUNT", 0);
        long m988b = currentTimeMillis - m941c.m988b("com.vivo.push_preferences.operate." + m1067b + "START_TIME", 0L);
        if (m988b > DownloadConstants.DAY || m988b < 0) {
            m941c.m985a("com.vivo.push_preferences.operate." + m1067b + "START_TIME", System.currentTimeMillis());
            m941c.m984a("com.vivo.push_preferences.operate." + m1067b + "OPERATE_COUNT", 1);
        } else {
            if (m987b >= c1206c.m590e()) {
                return 1001;
            }
            m941c.m984a("com.vivo.push_preferences.operate." + m1067b + "OPERATE_COUNT", m987b + 1);
        }
        return 0;
    }
}
