package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SpCache.java */
/* renamed from: com.vivo.push.util.ae */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1370ae implements InterfaceC1378e {

    /* renamed from: a */
    private static String f655a = "SpCache";

    /* renamed from: b */
    private static String f656b = "com.vivo.push.cache";

    /* renamed from: c */
    private SharedPreferences f657c;

    @Override // com.vivo.push.util.InterfaceC1378e
    /* renamed from: a */
    public final boolean mo939a(Context context) {
        if (this.f657c != null) {
            return true;
        }
        this.f657c = context.getSharedPreferences(f656b, 0);
        return true;
    }

    @Override // com.vivo.push.util.InterfaceC1378e
    /* renamed from: a */
    public final String mo938a(String str, String str2) {
        String string = this.f657c.getString(str, str2);
        C1393t.m1048d(f655a, "getString " + str + " is " + string);
        return string;
    }

    /* renamed from: a */
    public final void m947a() {
        SharedPreferences.Editor edit = this.f657c.edit();
        if (edit != null) {
            edit.clear();
            C1376c.m979a(edit);
        }
        C1393t.m1048d(f655a, "system cache is cleared");
    }
}
