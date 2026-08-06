package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class fl extends fn {
    private a a;

    /* renamed from: a, reason: collision with other field name */
    private final Map<String, String> f513a;

    public String b() {
        return null;
    }

    public fl() {
        this.a = a.a;
        this.f513a = new HashMap();
    }

    public fl(Bundle bundle) {
        super(bundle);
        this.a = a.a;
        this.f513a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public synchronized void a(Map<String, String> map) {
        this.f513a.putAll(map);
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m9908a() {
        return this.a;
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.a = a.a;
        } else {
            this.a = aVar;
        }
    }

    @Override // com.xiaomi.push.fn
    public Bundle a() {
        Bundle a2 = super.a();
        a aVar = this.a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.fn
    /* renamed from: a, reason: collision with other method in class */
    public String mo9909a() {
        StringBuilder sb = new StringBuilder("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"").append(fw.a(l())).append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"").append(fw.a(m())).append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"").append(fw.a(k())).append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f513a.entrySet()) {
            sb.append(fw.a(entry.getKey())).append("=\"");
            sb.append(fw.a(entry.getValue())).append("\" ");
        }
        if (this.a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"").append(m9908a()).append("\">");
        }
        String b = b();
        if (b != null) {
            sb.append(b);
        }
        sb.append(o());
        fr a2 = a();
        if (a2 != null) {
            sb.append(a2.m9913a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static final a a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a(com.heytap.mcssdk.constant.b.y);

        /* renamed from: a, reason: collision with other field name */
        private String f514a;

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        private a(String str) {
            this.f514a = str;
        }

        public String toString() {
            return this.f514a;
        }
    }
}
