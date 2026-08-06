package com.xiaomi.push.service;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public class aj {
    private static long a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static String f979a = "";

    public static String a() {
        if (TextUtils.isEmpty(f979a)) {
            f979a = com.xiaomi.push.ba.a(4);
        }
        StringBuilder append = new StringBuilder().append(f979a);
        long j = a;
        a = 1 + j;
        return append.append(j).toString();
    }

    public static String b() {
        return com.xiaomi.push.ba.a(32);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("Exception occurred when filtering registration packet id for log. " + e);
            return "UnexpectedId";
        }
    }
}
