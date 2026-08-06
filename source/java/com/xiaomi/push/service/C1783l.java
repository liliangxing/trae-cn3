package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1490ax;
import com.xiaomi.push.C1655h;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1661hf;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1675ht;

/* renamed from: com.xiaomi.push.service.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1783l {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3867a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        try {
            byte[] m3870b = m3870b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
            if (m3870b != null) {
                C1796x.m4055a(context, C1793u.m3987a(m3870b), m3870b);
            } else {
                AbstractC1417b.m1089a("notify fcm notification error ：dencrypt failed");
            }
        } catch (Throwable th) {
            AbstractC1417b.m1091a("notify fcm notification error ", th);
        }
    }

    /* renamed from: a */
    public static byte[] m3869a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC1417b.m1089a("secret is empty, return null");
            return null;
        }
        try {
            return C1655h.m3007b(C1490ax.m1586a(str), bArr);
        } catch (Exception e) {
            AbstractC1417b.m1091a("encryption error. ", e);
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m3870b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC1417b.m1089a("secret is empty, return null");
            return null;
        }
        try {
            return C1655h.m3006a(C1490ax.m1586a(str), bArr);
        } catch (Exception e) {
            AbstractC1417b.m1091a("dencryption error. ", e);
            return null;
        }
    }

    /* renamed from: a */
    public static C1661hf m3866a(C1656ha c1656ha) {
        byte[] m3022a = c1656ha.m3022a();
        C1661hf c1661hf = new C1661hf();
        try {
            C1670ho.m3312a(c1661hf, m3022a);
            return c1661hf;
        } catch (C1675ht unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m3868a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }
}
