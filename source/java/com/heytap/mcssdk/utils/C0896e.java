package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.heytap.mcssdk.PushService;

/* renamed from: com.heytap.mcssdk.utils.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0896e {

    /* renamed from: a */
    private static final String f630a = "shared_msg_sdk";

    /* renamed from: b */
    private static final String f631b = "hasDefaultChannelCreated";

    /* renamed from: c */
    private static final String f632c = "decryptTag";

    /* renamed from: d */
    private Context f633d;

    /* renamed from: e */
    private SharedPreferences f634e;

    /* renamed from: f */
    private Object f635f;

    /* renamed from: com.heytap.mcssdk.utils.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class a {

        /* renamed from: a */
        static C0896e f636a = new C0896e();

        private a() {
        }
    }

    private C0896e() {
        this.f635f = new Object();
        Context context = PushService.getInstance().getContext();
        if (context != null) {
            this.f633d = m683a(context);
        }
        Context context2 = this.f633d;
        if (context2 != null) {
            this.f634e = context2.getSharedPreferences(f630a, 0);
        }
    }

    /* renamed from: a */
    private Context m683a(Context context) {
        boolean m646a = C0892a.m646a();
        C0895d.m661b("fbeVersion is " + m646a);
        return m646a ? context.createDeviceProtectedStorageContext() : context.getApplicationContext();
    }

    /* renamed from: c */
    public static C0896e m684c() {
        return a.f636a;
    }

    /* renamed from: d */
    private SharedPreferences m685d() {
        Context context;
        SharedPreferences sharedPreferences = this.f634e;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.f635f) {
            SharedPreferences sharedPreferences2 = this.f634e;
            if (sharedPreferences2 != null || (context = this.f633d) == null) {
                return sharedPreferences2;
            }
            SharedPreferences sharedPreferences3 = context.getSharedPreferences(f630a, 0);
            this.f634e = sharedPreferences3;
            return sharedPreferences3;
        }
    }

    /* renamed from: a */
    public void m686a(String str) {
        SharedPreferences m685d = m685d();
        if (m685d != null) {
            m685d.edit().putString(f632c, str).commit();
        }
    }

    /* renamed from: a */
    public void m687a(boolean z) {
        SharedPreferences m685d = m685d();
        if (m685d != null) {
            m685d.edit().putBoolean(f631b, z).commit();
        }
    }

    /* renamed from: a */
    public boolean m688a() {
        SharedPreferences m685d = m685d();
        if (m685d != null) {
            return m685d.getBoolean(f631b, false);
        }
        return false;
    }

    /* renamed from: b */
    public String m689b() {
        SharedPreferences m685d = m685d();
        return m685d != null ? m685d.getString(f632c, "DES") : "DES";
    }
}
