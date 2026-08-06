package com.cmic.sso.sdk.p003c.p005b;

import com.bytedance.webx.addr.AddressParam;
import java.net.URLEncoder;

/* compiled from: BaseScripParameter.java */
/* renamed from: com.cmic.sso.sdk.c.b.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC0112a extends AbstractC0118g {

    /* renamed from: a */
    protected String f193a = "";

    /* renamed from: b */
    protected String f194b = "";

    /* renamed from: c */
    protected String f195c = "";

    /* renamed from: d */
    protected String f196d = "";

    /* renamed from: e */
    protected String f197e = "";

    /* renamed from: f */
    protected String f198f = "";

    /* renamed from: g */
    protected String f199g = "";

    /* renamed from: h */
    protected String f200h = "";

    /* renamed from: i */
    protected String f201i = "";

    /* renamed from: j */
    protected String f202j = AddressParam.TYPE_DISAPPROVE;

    /* renamed from: k */
    protected String f203k = "1.0";

    /* renamed from: l */
    protected String f204l = "";

    /* renamed from: m */
    protected String f205m = "";

    /* renamed from: n */
    protected String f206n = "";

    /* renamed from: o */
    protected String f207o = "";

    /* renamed from: p */
    protected String f208p = "";

    /* renamed from: q */
    protected String f209q = "";

    /* renamed from: r */
    protected String f210r = "";

    /* renamed from: s */
    protected String f211s = "";

    /* renamed from: t */
    protected String f212t = "";

    /* renamed from: u */
    protected String f213u = "002";

    /* renamed from: v */
    protected String f214v = "";

    /* renamed from: w */
    protected String f215w = "";

    /* renamed from: x */
    protected String f216x = "";

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public final String m216t(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    public void mo197a(String str) {
        this.f214v = str;
    }

    /* renamed from: b */
    public void m198b(String str) {
        this.f193a = m216t(str);
    }

    /* renamed from: c */
    public void m199c(String str) {
        this.f194b = m216t(str);
    }

    /* renamed from: d */
    public void m200d(String str) {
        this.f195c = m216t(str);
    }

    /* renamed from: e */
    public void m201e(String str) {
        this.f197e = m216t(str);
    }

    /* renamed from: f */
    public void m202f(String str) {
        this.f198f = m216t(str);
    }

    /* renamed from: g */
    public void m203g(String str) {
        this.f199g = URLEncoder.encode(m216t(str));
    }

    /* renamed from: h */
    public void m204h(String str) {
        this.f200h = URLEncoder.encode(m216t(str));
    }

    /* renamed from: i */
    public void m205i(String str) {
        this.f201i = URLEncoder.encode(m216t(str));
    }

    /* renamed from: j */
    public void m206j(String str) {
        this.f202j = m216t(str);
    }

    /* renamed from: k */
    public void m207k(String str) {
        this.f203k = m216t(str);
    }

    /* renamed from: l */
    public void m208l(String str) {
        this.f205m = m216t(str);
    }

    /* renamed from: m */
    public void m209m(String str) {
        this.f206n = m216t(str);
    }

    /* renamed from: n */
    public void m210n(String str) {
        this.f208p = m216t(str);
    }

    /* renamed from: o */
    public void m211o(String str) {
        this.f209q = m216t(str);
    }

    /* renamed from: p */
    public void m212p(String str) {
        this.f210r = m216t(str);
    }

    /* renamed from: q */
    public void m213q(String str) {
        this.f211s = m216t(str);
    }

    /* renamed from: r */
    public void m214r(String str) {
        this.f212t = m216t(str);
    }

    /* renamed from: s */
    public void m215s(String str) {
        this.f215w = str;
    }

    /* renamed from: u */
    public void m217u(String str) {
        this.f216x = str;
    }

    @Override // com.cmic.sso.sdk.p003c.p005b.AbstractC0118g
    /* renamed from: a */
    public String mo196a() {
        return this.f195c;
    }
}
