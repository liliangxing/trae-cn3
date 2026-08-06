package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public class fm extends fn {
    private boolean a;
    private String b;

    /* renamed from: b, reason: collision with other field name */
    private boolean f515b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public fm() {
        this.b = null;
        this.c = null;
        this.a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f515b = false;
    }

    public fm(Bundle bundle) {
        super(bundle);
        this.b = null;
        this.c = null;
        this.a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f515b = false;
        this.b = bundle.getString("ext_msg_type");
        this.d = bundle.getString("ext_msg_lang");
        this.c = bundle.getString("ext_msg_thread");
        this.e = bundle.getString("ext_msg_sub");
        this.f = bundle.getString("ext_msg_body");
        this.g = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.a = bundle.getBoolean("ext_msg_trans", false);
        this.f515b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    public String b() {
        return this.b;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public String c() {
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public String d() {
        return this.i;
    }

    public void b(String str) {
        this.i = str;
    }

    public String e() {
        return this.j;
    }

    public void c(String str) {
        this.j = str;
    }

    public String f() {
        return this.k;
    }

    public void d(String str) {
        this.k = str;
    }

    public String g() {
        return this.l;
    }

    public void e(String str) {
        this.l = str;
    }

    public void f(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.f515b = z;
    }

    public void g(String str) {
        this.e = str;
    }

    public void h(String str) {
        this.f = str;
    }

    public void a(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public void i(String str) {
        this.c = str;
    }

    public String h() {
        return this.d;
    }

    public void j(String str) {
        this.d = str;
    }

    @Override // com.xiaomi.push.fn
    public Bundle a() {
        Bundle a = super.a();
        if (!TextUtils.isEmpty(this.b)) {
            a.putString("ext_msg_type", this.b);
        }
        String str = this.d;
        if (str != null) {
            a.putString("ext_msg_lang", str);
        }
        String str2 = this.e;
        if (str2 != null) {
            a.putString("ext_msg_sub", str2);
        }
        String str3 = this.f;
        if (str3 != null) {
            a.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.g)) {
            a.putString("ext_body_encode", this.g);
        }
        String str4 = this.c;
        if (str4 != null) {
            a.putString("ext_msg_thread", str4);
        }
        String str5 = this.h;
        if (str5 != null) {
            a.putString("ext_msg_appid", str5);
        }
        if (this.a) {
            a.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.i)) {
            a.putString("ext_msg_seq", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            a.putString("ext_msg_mseq", this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            a.putString("ext_msg_fseq", this.k);
        }
        if (this.f515b) {
            a.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.l)) {
            a.putString("ext_msg_status", this.l);
        }
        return a;
    }

    @Override // com.xiaomi.push.fn
    /* renamed from: a */
    public String mo9909a() {
        fr a;
        StringBuilder sb = new StringBuilder("<message");
        if (p() != null) {
            sb.append(" xmlns=\"").append(p()).append("\"");
        }
        if (this.d != null) {
            sb.append(" xml:lang=\"").append(h()).append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"").append(j()).append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"").append(fw.a(l())).append("\"");
        }
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"").append(d()).append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"").append(e()).append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"").append(f()).append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"").append(g()).append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"").append(fw.a(m())).append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"").append(fw.a(k())).append("\"");
        }
        if (this.a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.h)) {
            sb.append(" appid=\"").append(c()).append("\"");
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" type=\"").append(this.b).append("\"");
        }
        if (this.f515b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.e != null) {
            sb.append("<subject>").append(fw.a(this.e));
            sb.append("</subject>");
        }
        if (this.f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.g)) {
                sb.append(" encode=\"").append(this.g).append("\"");
            }
            sb.append(">").append(fw.a(this.f)).append("</body>");
        }
        if (this.c != null) {
            sb.append("<thread>").append(this.c).append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.b) && (a = a()) != null) {
            sb.append(a.m9913a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }

    @Override // com.xiaomi.push.fn
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fm fmVar = (fm) obj;
        if (!super.equals(fmVar)) {
            return false;
        }
        String str = this.f;
        if (str == null ? fmVar.f != null : !str.equals(fmVar.f)) {
            return false;
        }
        String str2 = this.d;
        if (str2 == null ? fmVar.d != null : !str2.equals(fmVar.d)) {
            return false;
        }
        String str3 = this.e;
        if (str3 == null ? fmVar.e != null : !str3.equals(fmVar.e)) {
            return false;
        }
        String str4 = this.c;
        if (str4 == null ? fmVar.c == null : str4.equals(fmVar.c)) {
            return this.b == fmVar.b;
        }
        return false;
    }

    @Override // com.xiaomi.push.fn
    public int hashCode() {
        String str = this.b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
