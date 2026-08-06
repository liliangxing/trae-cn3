package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: PushClientSdkAppSp.java */
/* loaded from: classes7.dex */
public final class z extends c {
    private Context b;

    public z(Context context) {
        if (context != null) {
            this.b = context;
            a(context);
        }
    }

    private synchronized void a(Context context) {
        a(context, "com.vivo.push_preferences.appconfig_v1");
    }

    public final String c() {
        String obj;
        Context context = this.b;
        String packageName = context.getPackageName();
        Object a = ah.a(context, packageName, "com.vivo.push.app_id");
        if (a != null) {
            obj = a.toString();
        } else {
            Object a2 = ah.a(context, packageName, "app_id");
            obj = a2 != null ? a2.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? b("APP_APPID", "") : obj;
    }

    public final String d() {
        String obj;
        Context context = this.b;
        String packageName = context.getPackageName();
        Object a = ah.a(context, packageName, "com.vivo.push.api_key");
        if (a != null) {
            obj = a.toString();
        } else {
            Object a2 = ah.a(context, packageName, "api_key");
            obj = a2 != null ? a2.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? b("APP_APIKEY", "") : obj;
    }
}
