package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public final class ae {
    public static String a(Context context) {
        try {
            String a = a(context, "auth400");
            return !TextUtils.isEmpty(a) ? new String(h.b(a)) : a;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(Context context, String str) {
        try {
            return context.getSharedPreferences("cu_auth", 0).getString(str, "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("cu_auth", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
