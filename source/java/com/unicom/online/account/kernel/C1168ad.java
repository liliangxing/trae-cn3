package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.unicom.online.account.kernel.ad */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1168ad {
    /* renamed from: a */
    public static Long m495a(Context context, String str) {
        long j = 0;
        try {
            j = context.getSharedPreferences("cuAuthCacheName", 0).getLong(str, 0L);
        } catch (Exception e) {
            C1165aa.m449c(e.getMessage());
        }
        return Long.valueOf(j);
    }

    /* renamed from: a */
    public static void m496a(Context context, String str, Long l) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
            edit.putLong(str, l.longValue());
            edit.commit();
        } catch (Exception e) {
            C1165aa.m449c(e.getMessage());
        }
    }
}
