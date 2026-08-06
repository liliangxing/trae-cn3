package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes7.dex */
public final class ad {
    public static Long a(Context context, String str) {
        long j = 0;
        try {
            j = context.getSharedPreferences("cuAuthCacheName", 0).getLong(str, 0L);
        } catch (Exception e) {
            aa.c(e.getMessage());
        }
        return Long.valueOf(j);
    }

    public static void a(Context context, String str, Long l) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
            edit.putLong(str, l.longValue());
            edit.commit();
        } catch (Exception e) {
            aa.c(e.getMessage());
        }
    }
}
