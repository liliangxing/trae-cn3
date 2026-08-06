package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.heytap.mcssdk.PushService;

/* loaded from: classes6.dex */
public class e {
    private static final String a = "shared_msg_sdk";
    private static final String b = "hasDefaultChannelCreated";
    private static final String c = "decryptTag";
    private Context d;
    private SharedPreferences e;
    private Object f;

    /* loaded from: classes6.dex */
    private static class a {
        static e a = new e();

        private a() {
        }
    }

    private e() {
        this.f = new Object();
        Context context = PushService.getInstance().getContext();
        if (context != null) {
            this.d = a(context);
        }
        Context context2 = this.d;
        if (context2 != null) {
            this.e = context2.getSharedPreferences(a, 0);
        }
    }

    private Context a(Context context) {
        boolean a2 = com.heytap.mcssdk.utils.a.a();
        d.b("fbeVersion is " + a2);
        return a2 ? context.createDeviceProtectedStorageContext() : context.getApplicationContext();
    }

    public static e c() {
        return a.a;
    }

    private SharedPreferences d() {
        Context context;
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.f) {
            SharedPreferences sharedPreferences2 = this.e;
            if (sharedPreferences2 != null || (context = this.d) == null) {
                return sharedPreferences2;
            }
            SharedPreferences sharedPreferences3 = context.getSharedPreferences(a, 0);
            this.e = sharedPreferences3;
            return sharedPreferences3;
        }
    }

    public void a(String str) {
        SharedPreferences d = d();
        if (d != null) {
            d.edit().putString(c, str).commit();
        }
    }

    public void a(boolean z) {
        SharedPreferences d = d();
        if (d != null) {
            d.edit().putBoolean(b, z).commit();
        }
    }

    public boolean a() {
        SharedPreferences d = d();
        if (d != null) {
            return d.getBoolean(b, false);
        }
        return false;
    }

    public String b() {
        SharedPreferences d = d();
        return d != null ? d.getString(c, "DES") : "DES";
    }
}
