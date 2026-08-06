package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.xiaomi.push.fm */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1614fm extends AbstractC1615fn {

    /* renamed from: a */
    private boolean f1770a;

    /* renamed from: b */
    private String f1771b;

    /* renamed from: b */
    private boolean f1772b;

    /* renamed from: c */
    private String f1773c;

    /* renamed from: d */
    private String f1774d;

    /* renamed from: e */
    private String f1775e;

    /* renamed from: f */
    private String f1776f;

    /* renamed from: g */
    private String f1777g;

    /* renamed from: h */
    private String f1778h;

    /* renamed from: i */
    private String f1779i;

    /* renamed from: j */
    private String f1780j;

    /* renamed from: k */
    private String f1781k;

    /* renamed from: l */
    private String f1782l;

    public C1614fm() {
        this.f1771b = null;
        this.f1773c = null;
        this.f1770a = false;
        this.f1779i = "";
        this.f1780j = "";
        this.f1781k = "";
        this.f1782l = "";
        this.f1772b = false;
    }

    public C1614fm(Bundle bundle) {
        super(bundle);
        this.f1771b = null;
        this.f1773c = null;
        this.f1770a = false;
        this.f1779i = "";
        this.f1780j = "";
        this.f1781k = "";
        this.f1782l = "";
        this.f1772b = false;
        this.f1771b = bundle.getString("ext_msg_type");
        this.f1774d = bundle.getString("ext_msg_lang");
        this.f1773c = bundle.getString("ext_msg_thread");
        this.f1775e = bundle.getString("ext_msg_sub");
        this.f1776f = bundle.getString("ext_msg_body");
        this.f1777g = bundle.getString("ext_body_encode");
        this.f1778h = bundle.getString("ext_msg_appid");
        this.f1770a = bundle.getBoolean("ext_msg_trans", false);
        this.f1772b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f1779i = bundle.getString("ext_msg_seq");
        this.f1780j = bundle.getString("ext_msg_mseq");
        this.f1781k = bundle.getString("ext_msg_fseq");
        this.f1782l = bundle.getString("ext_msg_status");
    }

    /* renamed from: b */
    public String m2583b() {
        return this.f1771b;
    }

    /* renamed from: a */
    public void m2582a(boolean z) {
        this.f1770a = z;
    }

    /* renamed from: c */
    public String m2586c() {
        return this.f1778h;
    }

    /* renamed from: a */
    public void m2580a(String str) {
        this.f1778h = str;
    }

    /* renamed from: d */
    public String m2588d() {
        return this.f1779i;
    }

    /* renamed from: b */
    public void m2584b(String str) {
        this.f1779i = str;
    }

    /* renamed from: e */
    public String m2590e() {
        return this.f1780j;
    }

    /* renamed from: c */
    public void m2587c(String str) {
        this.f1780j = str;
    }

    /* renamed from: f */
    public String m2592f() {
        return this.f1781k;
    }

    /* renamed from: d */
    public void m2589d(String str) {
        this.f1781k = str;
    }

    /* renamed from: g */
    public String m2594g() {
        return this.f1782l;
    }

    /* renamed from: e */
    public void m2591e(String str) {
        this.f1782l = str;
    }

    /* renamed from: f */
    public void m2593f(String str) {
        this.f1771b = str;
    }

    /* renamed from: b */
    public void m2585b(boolean z) {
        this.f1772b = z;
    }

    /* renamed from: g */
    public void m2595g(String str) {
        this.f1775e = str;
    }

    /* renamed from: h */
    public void m2597h(String str) {
        this.f1776f = str;
    }

    /* renamed from: a */
    public void m2581a(String str, String str2) {
        this.f1776f = str;
        this.f1777g = str2;
    }

    /* renamed from: i */
    public void m2598i(String str) {
        this.f1773c = str;
    }

    /* renamed from: h */
    public String m2596h() {
        return this.f1774d;
    }

    /* renamed from: j */
    public void m2599j(String str) {
        this.f1774d = str;
    }

    @Override // com.xiaomi.push.AbstractC1615fn
    /* renamed from: a */
    public Bundle mo2573a() {
        Bundle mo2573a = super.mo2573a();
        if (!TextUtils.isEmpty(this.f1771b)) {
            mo2573a.putString("ext_msg_type", this.f1771b);
        }
        String str = this.f1774d;
        if (str != null) {
            mo2573a.putString("ext_msg_lang", str);
        }
        String str2 = this.f1775e;
        if (str2 != null) {
            mo2573a.putString("ext_msg_sub", str2);
        }
        String str3 = this.f1776f;
        if (str3 != null) {
            mo2573a.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f1777g)) {
            mo2573a.putString("ext_body_encode", this.f1777g);
        }
        String str4 = this.f1773c;
        if (str4 != null) {
            mo2573a.putString("ext_msg_thread", str4);
        }
        String str5 = this.f1778h;
        if (str5 != null) {
            mo2573a.putString("ext_msg_appid", str5);
        }
        if (this.f1770a) {
            mo2573a.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f1779i)) {
            mo2573a.putString("ext_msg_seq", this.f1779i);
        }
        if (!TextUtils.isEmpty(this.f1780j)) {
            mo2573a.putString("ext_msg_mseq", this.f1780j);
        }
        if (!TextUtils.isEmpty(this.f1781k)) {
            mo2573a.putString("ext_msg_fseq", this.f1781k);
        }
        if (this.f1772b) {
            mo2573a.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f1782l)) {
            mo2573a.putString("ext_msg_status", this.f1782l);
        }
        return mo2573a;
    }

    @Override // com.xiaomi.push.AbstractC1615fn
    /* renamed from: a */
    public String mo2575a() {
        C1619fr a;
        StringBuilder sb = new StringBuilder("<message");
        if (m2621p() != null) {
            sb.append(" xmlns=\"").append(m2621p()).append("\"");
        }
        if (this.f1774d != null) {
            sb.append(" xml:lang=\"").append(m2596h()).append("\"");
        }
        if (m2610j() != null) {
            sb.append(" id=\"").append(m2610j()).append("\"");
        }
        if (m2613l() != null) {
            sb.append(" to=\"").append(C1624fw.m2647a(m2613l())).append("\"");
        }
        if (!TextUtils.isEmpty(m2588d())) {
            sb.append(" seq=\"").append(m2588d()).append("\"");
        }
        if (!TextUtils.isEmpty(m2590e())) {
            sb.append(" mseq=\"").append(m2590e()).append("\"");
        }
        if (!TextUtils.isEmpty(m2592f())) {
            sb.append(" fseq=\"").append(m2592f()).append("\"");
        }
        if (!TextUtils.isEmpty(m2594g())) {
            sb.append(" status=\"").append(m2594g()).append("\"");
        }
        if (m2615m() != null) {
            sb.append(" from=\"").append(C1624fw.m2647a(m2615m())).append("\"");
        }
        if (m2611k() != null) {
            sb.append(" chid=\"").append(C1624fw.m2647a(m2611k())).append("\"");
        }
        if (this.f1770a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f1778h)) {
            sb.append(" appid=\"").append(m2586c()).append("\"");
        }
        if (!TextUtils.isEmpty(this.f1771b)) {
            sb.append(" type=\"").append(this.f1771b).append("\"");
        }
        if (this.f1772b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f1775e != null) {
            sb.append("<subject>").append(C1624fw.m2647a(this.f1775e));
            sb.append("</subject>");
        }
        if (this.f1776f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f1777g)) {
                sb.append(" encode=\"").append(this.f1777g).append("\"");
            }
            sb.append(">").append(C1624fw.m2647a(this.f1776f)).append("</body>");
        }
        if (this.f1773c != null) {
            sb.append("<thread>").append(this.f1773c).append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f1771b) && (a = mo2573a()) != null) {
            sb.append(a.m2628a());
        }
        sb.append(m2619o());
        sb.append("</message>");
        return sb.toString();
    }

    @Override // com.xiaomi.push.AbstractC1615fn
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1614fm c1614fm = (C1614fm) obj;
        if (!super.equals(c1614fm)) {
            return false;
        }
        String str = this.f1776f;
        if (str == null ? c1614fm.f1776f != null : !str.equals(c1614fm.f1776f)) {
            return false;
        }
        String str2 = this.f1774d;
        if (str2 == null ? c1614fm.f1774d != null : !str2.equals(c1614fm.f1774d)) {
            return false;
        }
        String str3 = this.f1775e;
        if (str3 == null ? c1614fm.f1775e != null : !str3.equals(c1614fm.f1775e)) {
            return false;
        }
        String str4 = this.f1773c;
        if (str4 == null ? c1614fm.f1773c == null : str4.equals(c1614fm.f1773c)) {
            return this.f1771b == c1614fm.f1771b;
        }
        return false;
    }

    @Override // com.xiaomi.push.AbstractC1615fn
    public int hashCode() {
        String str = this.f1771b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1776f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f1773c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f1774d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f1775e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
