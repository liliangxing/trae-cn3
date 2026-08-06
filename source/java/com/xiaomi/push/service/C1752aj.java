package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1494ba;

/* renamed from: com.xiaomi.push.service.aj */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1752aj {

    /* renamed from: a */
    private static long f2979a = 0;

    /* renamed from: a */
    private static String f2980a = "";

    /* renamed from: a */
    public static String m3692a() {
        if (TextUtils.isEmpty(f2980a)) {
            f2980a = C1494ba.m1624a(4);
        }
        StringBuilder append = new StringBuilder().append(f2980a);
        long j = f2979a;
        f2979a = 1 + j;
        return append.append(j).toString();
    }

    /* renamed from: b */
    public static String m3694b() {
        return C1494ba.m1624a(32);
    }

    /* renamed from: a */
    public static String m3693a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e) {
            AbstractC1417b.m1103d("Exception occurred when filtering registration packet id for log. " + e);
            return "UnexpectedId";
        }
    }
}
