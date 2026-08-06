package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* renamed from: com.unicom.online.account.kernel.ae */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1169ae {
    /* renamed from: a */
    public static String m497a(Context context) {
        try {
            String m498a = m498a(context, "auth400");
            return !TextUtils.isEmpty(m498a) ? new String(C1176h.m535b(m498a)) : m498a;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m498a(Context context, String str) {
        try {
            return context.getSharedPreferences("cu_auth", 0).getString(str, "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static void m499a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("cu_auth", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
