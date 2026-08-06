package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.ss.android.account.model.internal.BDAccountPlatformEntity;

/* loaded from: classes7.dex */
public class ap {
    private static ap a;

    /* renamed from: a, reason: collision with other field name */
    private int f1000a = 0;

    /* renamed from: a, reason: collision with other field name */
    private Context f1001a;

    public static ap a(Context context) {
        if (a == null) {
            a = new ap(context);
        }
        return a;
    }

    private ap(Context context) {
        this.f1001a = context.getApplicationContext();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m10179a() {
        return com.xiaomi.push.w.f1095a.contains("xmsf") || com.xiaomi.push.w.f1095a.contains(BDAccountPlatformEntity.PLAT_NAME_XIAOMI) || com.xiaomi.push.w.f1095a.contains("miui");
    }

    public int a() {
        int i = this.f1000a;
        if (i != 0) {
            return i;
        }
        try {
            this.f1000a = Settings.Global.getInt(this.f1001a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f1000a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Uri m10178a() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}
