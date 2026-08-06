package com.cmic.sso.sdk.p009e;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p009e.C0141k;
import com.cmic.sso.sdk.p009e.C0144n;
import com.heytap.mcssdk.constant.C0878a;

/* compiled from: PhoneScripUtils.java */
/* renamed from: com.cmic.sso.sdk.e.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0138h {

    /* renamed from: a */
    private static String f310a = null;

    /* renamed from: b */
    private static String f311b = null;

    /* renamed from: c */
    private static long f312c = 0;

    /* renamed from: d */
    private static int f313d = -1;

    /* renamed from: a */
    public static void m345a(boolean z, boolean z2) {
        C0141k.a m367a = C0141k.m367a();
        m367a.m376a("phonescripstarttime");
        m367a.m376a("phonescripcache");
        m367a.m376a("pre_sim_key");
        m367a.m376a("phonescripversion");
        if (z2) {
            m367a.m375a();
        } else {
            m367a.m380b();
        }
        if (z) {
            f310a = null;
            f311b = null;
            f312c = 0L;
            f313d = -1;
        }
    }

    /* renamed from: a */
    public static void m344a(final Context context, final String str, long j, final String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j <= 0) {
            return;
        }
        C0133c.m328b("PhoneScripUtils", "save phone scrip simKey = " + str2);
        f310a = str;
        long j2 = j * 1000;
        f312c = System.currentTimeMillis() + j2;
        C0133c.m328b("sLifeTime", f312c + "");
        f311b = str2;
        f313d = 2;
        if (!"operator".equals(str3)) {
            C0144n.m391a(new C0144n.a() { // from class: com.cmic.sso.sdk.e.h.1
                @Override // com.cmic.sso.sdk.p009e.C0144n.a
                /* renamed from: a */
                protected void mo128a() {
                    C0133c.m328b("PhoneScripUtils", "start save scrip to sp in sub thread");
                    C0138h.m349b(context, str, C0138h.f312c, str2);
                }
            });
        } else if (j2 > C0878a.f519e) {
            f312c = System.currentTimeMillis() + C0878a.f519e;
        } else {
            f312c = System.currentTimeMillis() + j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m349b(Context context, String str, long j, String str2) {
        String m318a = C0132b.m318a(context, str);
        if (TextUtils.isEmpty(m318a)) {
            return;
        }
        C0141k.a m367a = C0141k.m367a();
        m367a.m379a("phonescripcache", m318a);
        m367a.m378a("phonescripstarttime", j);
        m367a.m377a("phonescripversion", 2);
        m367a.m379a("pre_sim_key", str2);
        m367a.m380b();
    }

    /* renamed from: a */
    public static String m342a(Context context) {
        if (TextUtils.isEmpty(f310a)) {
            String m374b = C0141k.m374b("phonescripcache", "");
            if (TextUtils.isEmpty(m374b)) {
                C0133c.m326a("PhoneScripUtils", "null");
                return null;
            }
            f312c = C0141k.m365a("phonescripstarttime", 0L);
            f311b = C0141k.m374b("pre_sim_key", "");
            f313d = C0141k.m363a("phonescripversion", -1);
            String m323b = C0132b.m323b(context, m374b);
            f310a = m323b;
            return m323b;
        }
        return f310a;
    }

    /* renamed from: c */
    private static boolean m350c() {
        if (TextUtils.isEmpty(f310a)) {
            return !TextUtils.isEmpty(C0141k.m374b("phonescripcache", "")) && m346a(C0141k.m365a("phonescripstarttime", 0L));
        }
        C0133c.m328b("PhoneScripUtils", f311b + " " + f312c);
        return m346a(f312c);
    }

    /* renamed from: a */
    private static boolean m346a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        C0133c.m328b("PhoneScripUtils", j + "");
        C0133c.m328b("PhoneScripUtils", currentTimeMillis + "");
        return j - currentTimeMillis > C0878a.f531q;
    }

    /* renamed from: a */
    public static long m341a() {
        long m365a;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(f310a)) {
            C0133c.m328b("PhoneScripUtils", f311b + " " + f312c);
            m365a = f312c;
        } else {
            String m374b = C0141k.m374b("phonescripcache", "");
            m365a = C0141k.m365a("phonescripstarttime", 0L);
            if (TextUtils.isEmpty(m374b)) {
                j = 0;
                return Math.max(j / 1000, 0L);
            }
        }
        j = (m365a - currentTimeMillis) - C0878a.f531q;
        return Math.max(j / 1000, 0L);
    }

    /* renamed from: a */
    private static int m340a(String str) {
        String m374b;
        if (!TextUtils.isEmpty(f311b)) {
            m374b = f311b;
        } else {
            m374b = C0141k.m374b("pre_sim_key", "");
            f311b = m374b;
        }
        if (TextUtils.isEmpty(m374b)) {
            return 0;
        }
        return m374b.equals(str) ? 1 : 2;
    }

    /* renamed from: a */
    public static boolean m347a(C0088a c0088a) {
        int m340a = m340a(c0088a.m67b("scripKey"));
        c0088a.m60a("imsiState", m340a + "");
        C0133c.m328b("PhoneScripUtils", "simState = " + m340a);
        if (m340a == 0) {
            return false;
        }
        if (f313d == -1) {
            f313d = C0141k.m363a("phonescripversion", -1);
        }
        if (f313d != 2) {
            m345a(true, false);
            C0132b.m319a();
            C0133c.m328b("PhoneScripUtils", "phoneScriptVersion change");
            return false;
        }
        if (m340a == 2) {
            m345a(true, false);
            return false;
        }
        return m350c();
    }
}
