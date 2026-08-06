package com.cmic.sso.sdk.p003c.p005b;

import com.cmic.sso.sdk.p009e.C0134d;
import org.json.JSONObject;

/* compiled from: RequestParameter.java */
/* renamed from: com.cmic.sso.sdk.c.b.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC0118g {
    /* renamed from: a */
    public abstract String mo196a();

    /* renamed from: a_ */
    protected abstract String mo218a_(String str);

    /* renamed from: b */
    public abstract JSONObject mo219b();

    /* renamed from: v */
    public String m250v(String str) {
        return C0134d.m329a(mo218a_(str)).toLowerCase();
    }
}
