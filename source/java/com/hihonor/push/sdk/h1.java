package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes6.dex */
public class h1 {
    public final SharedPreferences a;

    public h1(Context context, String str) {
        if (context != null) {
            Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
            if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str) & (!sharedPreferences.getBoolean(str, false))) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(str, true);
                edit.apply();
            }
            this.a = createDeviceProtectedStorageContext.getSharedPreferences(str, 0);
            return;
        }
        throw new NullPointerException("context is null!");
    }

    public boolean a(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public boolean a(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }
}
