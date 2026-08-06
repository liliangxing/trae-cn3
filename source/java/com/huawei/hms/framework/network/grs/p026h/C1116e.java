package com.huawei.hms.framework.network.grs.p026h;

import com.huawei.hms.framework.common.Logger;

/* renamed from: com.huawei.hms.framework.network.grs.h.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1116e {

    /* renamed from: a */
    private static final String f1381a = "e";

    /* renamed from: a */
    public static boolean m1375a(Long l) {
        if (l == null) {
            Logger.m1187v(f1381a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
        } catch (NumberFormatException unused) {
            Logger.m1187v(f1381a, "isSpExpire spValue NumberFormatException.");
        }
        if (l.longValue() - System.currentTimeMillis() >= 0) {
            Logger.m1185i(f1381a, "isSpExpire false.");
            return false;
        }
        Logger.m1185i(f1381a, "isSpExpire true.");
        return true;
    }

    /* renamed from: a */
    public static boolean m1376a(Long l, long j) {
        if (l == null) {
            Logger.m1187v(f1381a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l.longValue() - (System.currentTimeMillis() + j) >= 0) {
                Logger.m1187v(f1381a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.m1187v(f1381a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
