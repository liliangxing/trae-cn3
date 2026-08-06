package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: PushClientSdkAppSp.java */
/* renamed from: com.vivo.push.util.z */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1399z extends C1376c {

    /* renamed from: b */
    private Context f725b;

    public C1399z(Context context) {
        if (context != null) {
            this.f725b = context;
            m1058a(context);
        }
    }

    /* renamed from: a */
    private synchronized void m1058a(Context context) {
        m982a(context, "com.vivo.push_preferences.appconfig_v1");
    }

    /* renamed from: c */
    public final String m1059c() {
        String obj;
        Context context = this.f725b;
        String packageName = context.getPackageName();
        Object m954a = C1373ah.m954a(context, packageName, "com.vivo.push.app_id");
        if (m954a != null) {
            obj = m954a.toString();
        } else {
            Object m954a2 = C1373ah.m954a(context, packageName, "app_id");
            obj = m954a2 != null ? m954a2.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? m989b("APP_APPID", "") : obj;
    }

    /* renamed from: d */
    public final String m1060d() {
        String obj;
        Context context = this.f725b;
        String packageName = context.getPackageName();
        Object m954a = C1373ah.m954a(context, packageName, "com.vivo.push.api_key");
        if (m954a != null) {
            obj = m954a.toString();
        } else {
            Object m954a2 = C1373ah.m954a(context, packageName, "api_key");
            obj = m954a2 != null ? m954a2.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? m989b("APP_APIKEY", "") : obj;
    }
}
