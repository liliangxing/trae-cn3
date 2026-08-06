package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.hihonor.push.sdk.h1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0930h1 {

    /* renamed from: a */
    public final SharedPreferences f725a;

    public C0930h1(Context context, String str) {
        if (context != null) {
            Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
            if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str) & (!sharedPreferences.getBoolean(str, false))) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(str, true);
                edit.apply();
            }
            this.f725a = createDeviceProtectedStorageContext.getSharedPreferences(str, 0);
            return;
        }
        throw new NullPointerException("context is null!");
    }

    /* renamed from: a */
    public boolean m769a(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f725a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    /* renamed from: a */
    public boolean m768a(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f725a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }
}
