package com.xiaomi.push;

import android.os.Bundle;

/* renamed from: com.xiaomi.push.fp */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1617fp extends AbstractC1615fn {

    /* renamed from: a */
    private int f1798a;

    /* renamed from: a */
    private a f1799a;

    /* renamed from: a */
    private b f1800a;

    /* renamed from: b */
    private String f1801b;

    /* renamed from: com.xiaomi.push.fp$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* renamed from: com.xiaomi.push.fp$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public C1617fp(b bVar) {
        this.f1800a = b.available;
        this.f1801b = null;
        this.f1798a = Integer.MIN_VALUE;
        this.f1799a = null;
        m2624a(bVar);
    }

    public C1617fp(Bundle bundle) {
        super(bundle);
        this.f1800a = b.available;
        this.f1801b = null;
        this.f1798a = Integer.MIN_VALUE;
        this.f1799a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f1800a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f1801b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f1798a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f1799a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    @Override // com.xiaomi.push.AbstractC1615fn
    /* renamed from: a */
    public Bundle mo2573a() {
        Bundle mo2573a = super.mo2573a();
        b bVar = this.f1800a;
        if (bVar != null) {
            mo2573a.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f1801b;
        if (str != null) {
            mo2573a.putString("ext_pres_status", str);
        }
        int i = this.f1798a;
        if (i != Integer.MIN_VALUE) {
            mo2573a.putInt("ext_pres_prio", i);
        }
        a aVar = this.f1799a;
        if (aVar != null && aVar != a.available) {
            mo2573a.putString("ext_pres_mode", this.f1799a.toString());
        }
        return mo2573a;
    }

    /* renamed from: a */
    public void m2624a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f1800a = bVar;
    }

    /* renamed from: a */
    public void m2625a(String str) {
        this.f1801b = str;
    }

    /* renamed from: a */
    public void m2622a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.f1798a = i;
    }

    /* renamed from: a */
    public void m2623a(a aVar) {
        this.f1799a = aVar;
    }

    @Override // com.xiaomi.push.AbstractC1615fn
    /* renamed from: a */
    public String mo2575a() {
        StringBuilder sb = new StringBuilder("<presence");
        if (m2621p() != null) {
            sb.append(" xmlns=\"").append(m2621p()).append("\"");
        }
        if (m2610j() != null) {
            sb.append(" id=\"").append(m2610j()).append("\"");
        }
        if (m2613l() != null) {
            sb.append(" to=\"").append(C1624fw.m2647a(m2613l())).append("\"");
        }
        if (m2615m() != null) {
            sb.append(" from=\"").append(C1624fw.m2647a(m2615m())).append("\"");
        }
        if (m2611k() != null) {
            sb.append(" chid=\"").append(C1624fw.m2647a(m2611k())).append("\"");
        }
        if (this.f1800a != null) {
            sb.append(" type=\"").append(this.f1800a).append("\"");
        }
        sb.append(">");
        if (this.f1801b != null) {
            sb.append("<status>").append(C1624fw.m2647a(this.f1801b)).append("</status>");
        }
        if (this.f1798a != Integer.MIN_VALUE) {
            sb.append("<priority>").append(this.f1798a).append("</priority>");
        }
        a aVar = this.f1799a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>").append(this.f1799a).append("</show>");
        }
        sb.append(m2619o());
        C1619fr a2 = mo2573a();
        if (a2 != null) {
            sb.append(a2.m2628a());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
