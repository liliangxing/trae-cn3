package com.bytedance.bdturing.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class SPUtil {
    public static void puString(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getString(Context context, String str, String str2, String str3) {
        return (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? str3 : context.getSharedPreferences(str, 0).getString(str2, str3);
    }
}
