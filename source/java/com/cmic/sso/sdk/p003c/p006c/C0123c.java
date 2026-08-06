package com.cmic.sso.sdk.p003c.p006c;

import android.net.Network;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.p003c.p005b.AbstractC0118g;
import com.cmic.sso.sdk.p009e.C0135e;
import com.heytap.mcssdk.constant.C0879b;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HttpRequest.java */
/* renamed from: com.cmic.sso.sdk.c.c.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0123c {

    /* renamed from: a */
    String f255a;

    /* renamed from: b */
    private final String f256b;

    /* renamed from: c */
    private final Map<String, String> f257c;

    /* renamed from: d */
    private final String f258d;

    /* renamed from: e */
    private boolean f259e;

    /* renamed from: f */
    private final String f260f;

    /* renamed from: g */
    private Network f261g;

    /* renamed from: h */
    private long f262h;

    /* renamed from: i */
    private final String f263i;

    /* renamed from: j */
    private int f264j;

    /* renamed from: k */
    private final AbstractC0118g f265k;

    private C0123c(String str, Map<String, String> map, AbstractC0118g abstractC0118g, String str2, String str3) {
        this.f259e = false;
        this.f256b = str;
        this.f265k = abstractC0118g;
        this.f257c = map == null ? new HashMap<>() : map;
        this.f255a = abstractC0118g == null ? "" : abstractC0118g.mo219b().toString();
        this.f258d = str2;
        this.f260f = str3;
        this.f263i = abstractC0118g != null ? abstractC0118g.mo196a() : "";
        m261l();
    }

    public C0123c(String str, AbstractC0118g abstractC0118g, String str2, String str3) {
        this(str, null, abstractC0118g, str2, str3);
    }

    /* renamed from: l */
    private void m261l() {
        this.f257c.put(C0879b.f554C, AuthnHelper.SDK_VERSION);
        this.f257c.put("Content-Type", "application/json");
        this.f257c.put("CMCC-EncryptType", "STD");
        this.f257c.put("traceId", this.f260f);
        this.f257c.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.f263i);
        this.f257c.put("connection", "Keep-Alive");
    }

    /* renamed from: a */
    public void m265a(String str, String str2) {
        this.f257c.put(str, str2);
    }

    /* renamed from: a */
    public String m262a() {
        return this.f256b;
    }

    /* renamed from: b */
    public boolean m267b() {
        return this.f259e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m266a(boolean z) {
        this.f259e = z;
    }

    /* renamed from: c */
    public Map<String, String> m268c() {
        return this.f257c;
    }

    /* renamed from: d */
    public String m269d() {
        return this.f255a;
    }

    /* renamed from: e */
    public String m270e() {
        return this.f258d;
    }

    /* renamed from: f */
    public String m271f() {
        return this.f260f;
    }

    /* renamed from: g */
    public boolean m272g() {
        return !C0135e.m332a(this.f260f) || this.f256b.contains("logReport") || this.f256b.contains("uniConfig");
    }

    /* renamed from: h */
    public Network m273h() {
        return this.f261g;
    }

    /* renamed from: a */
    public void m264a(Network network) {
        this.f261g = network;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m263a(long j) {
        this.f262h = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public long m274i() {
        return this.f262h;
    }

    /* renamed from: j */
    public boolean m275j() {
        int i = this.f264j;
        this.f264j = i + 1;
        return i < 2;
    }

    /* renamed from: k */
    public AbstractC0118g m276k() {
        return this.f265k;
    }
}
