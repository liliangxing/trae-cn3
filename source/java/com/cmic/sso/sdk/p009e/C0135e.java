package com.cmic.sso.sdk.p009e;

import com.cmic.sso.sdk.auth.TokenListener;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: OverTimeUtils.java */
/* renamed from: com.cmic.sso.sdk.e.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0135e {

    /* renamed from: a */
    private static ConcurrentHashMap<String, TokenListener> f309a = new ConcurrentHashMap<>(16);

    /* renamed from: a */
    public static boolean m332a(String str) {
        return !f309a.containsKey(str);
    }

    /* renamed from: a */
    public static void m331a(String str, TokenListener tokenListener) {
        f309a.put(str, tokenListener);
    }

    /* renamed from: b */
    public static void m333b(String str) {
        f309a.remove(str);
    }

    /* renamed from: c */
    public static TokenListener m334c(String str) {
        return f309a.get(str);
    }
}
