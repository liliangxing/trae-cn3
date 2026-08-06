package com.xiaomi.push;

import android.os.Bundle;

/* loaded from: classes7.dex */
public class fp extends fn {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private a f522a;

    /* renamed from: a, reason: collision with other field name */
    private b f523a;
    private String b;

    /* loaded from: classes7.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: classes7.dex */
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

    public fp(b bVar) {
        this.f523a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f522a = null;
        a(bVar);
    }

    public fp(Bundle bundle) {
        super(bundle);
        this.f523a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f522a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f523a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f522a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    @Override // com.xiaomi.push.fn
    public Bundle a() {
        Bundle a2 = super.a();
        b bVar = this.f523a;
        if (bVar != null) {
            a2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.b;
        if (str != null) {
            a2.putString("ext_pres_status", str);
        }
        int i = this.a;
        if (i != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", i);
        }
        a aVar = this.f522a;
        if (aVar != null && aVar != a.available) {
            a2.putString("ext_pres_mode", this.f522a.toString());
        }
        return a2;
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f523a = bVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.a = i;
    }

    public void a(a aVar) {
        this.f522a = aVar;
    }

    @Override // com.xiaomi.push.fn
    /* renamed from: a */
    public String mo9909a() {
        StringBuilder sb = new StringBuilder("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"").append(p()).append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"").append(j()).append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"").append(fw.a(l())).append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"").append(fw.a(m())).append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"").append(fw.a(k())).append("\"");
        }
        if (this.f523a != null) {
            sb.append(" type=\"").append(this.f523a).append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<status>").append(fw.a(this.b)).append("</status>");
        }
        if (this.a != Integer.MIN_VALUE) {
            sb.append("<priority>").append(this.a).append("</priority>");
        }
        a aVar = this.f522a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>").append(this.f522a).append("</show>");
        }
        sb.append(o());
        fr a2 = a();
        if (a2 != null) {
            sb.append(a2.m9913a());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
