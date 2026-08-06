package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.fr */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1619fr {

    /* renamed from: a */
    private int f1818a;

    /* renamed from: a */
    private String f1819a;

    /* renamed from: a */
    private List<C1612fk> f1820a;

    /* renamed from: b */
    private String f1821b;

    /* renamed from: c */
    private String f1822c;

    /* renamed from: d */
    private String f1823d;

    public C1619fr(a aVar) {
        this.f1820a = null;
        m2626a(aVar);
        this.f1823d = null;
    }

    public C1619fr(int i, String str, String str2, String str3, String str4, List<C1612fk> list) {
        this.f1818a = i;
        this.f1819a = str;
        this.f1822c = str2;
        this.f1821b = str3;
        this.f1823d = str4;
        this.f1820a = list;
    }

    public C1619fr(Bundle bundle) {
        this.f1820a = null;
        this.f1818a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f1819a = bundle.getString("ext_err_type");
        }
        this.f1821b = bundle.getString("ext_err_cond");
        this.f1822c = bundle.getString("ext_err_reason");
        this.f1823d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f1820a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C1612fk m2561a = C1612fk.m2561a((Bundle) parcelable);
                if (m2561a != null) {
                    this.f1820a.add(m2561a);
                }
            }
        }
    }

    /* renamed from: a */
    private void m2626a(a aVar) {
        this.f1821b = aVar.f1848a;
    }

    /* renamed from: a */
    public Bundle m2627a() {
        Bundle bundle = new Bundle();
        String str = this.f1819a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f1818a);
        String str2 = this.f1822c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f1821b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f1823d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<C1612fk> list = this.f1820a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<C1612fk> it = this.f1820a.iterator();
            int i = 0;
            while (it.hasNext()) {
                Bundle m2564a = it.next().m2564a();
                if (m2564a != null) {
                    bundleArr[i] = m2564a;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: a */
    public String m2628a() {
        StringBuilder sb = new StringBuilder("<error code=\"");
        sb.append(this.f1818a).append("\"");
        if (this.f1819a != null) {
            sb.append(" type=\"");
            sb.append(this.f1819a);
            sb.append("\"");
        }
        if (this.f1822c != null) {
            sb.append(" reason=\"");
            sb.append(this.f1822c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f1821b != null) {
            sb.append("<").append(this.f1821b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f1823d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f1823d);
            sb.append("</text>");
        }
        Iterator<C1612fk> it = m2629a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().mo2572d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f1821b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(").append(this.f1818a).append(")");
        if (this.f1823d != null) {
            sb.append(" ").append(this.f1823d);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public synchronized List<C1612fk> m2629a() {
        List<C1612fk> list = this.f1820a;
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    /* renamed from: com.xiaomi.push.fr$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        public static final a f1824a = new a("internal-server-error");

        /* renamed from: b */
        public static final a f1825b = new a("forbidden");

        /* renamed from: c */
        public static final a f1826c = new a("bad-request");

        /* renamed from: d */
        public static final a f1827d = new a("conflict");

        /* renamed from: e */
        public static final a f1828e = new a("feature-not-implemented");

        /* renamed from: f */
        public static final a f1829f = new a("gone");

        /* renamed from: g */
        public static final a f1830g = new a("item-not-found");

        /* renamed from: h */
        public static final a f1831h = new a("jid-malformed");

        /* renamed from: i */
        public static final a f1832i = new a("not-acceptable");

        /* renamed from: j */
        public static final a f1833j = new a("not-allowed");

        /* renamed from: k */
        public static final a f1834k = new a("not-authorized");

        /* renamed from: l */
        public static final a f1835l = new a("payment-required");

        /* renamed from: m */
        public static final a f1836m = new a("recipient-unavailable");

        /* renamed from: n */
        public static final a f1837n = new a("redirect");

        /* renamed from: o */
        public static final a f1838o = new a("registration-required");

        /* renamed from: p */
        public static final a f1839p = new a("remote-server-error");

        /* renamed from: q */
        public static final a f1840q = new a("remote-server-not-found");

        /* renamed from: r */
        public static final a f1841r = new a("remote-server-timeout");

        /* renamed from: s */
        public static final a f1842s = new a("resource-constraint");

        /* renamed from: t */
        public static final a f1843t = new a("service-unavailable");

        /* renamed from: u */
        public static final a f1844u = new a("subscription-required");

        /* renamed from: v */
        public static final a f1845v = new a("undefined-condition");

        /* renamed from: w */
        public static final a f1846w = new a("unexpected-request");

        /* renamed from: x */
        public static final a f1847x = new a("request-timeout");

        /* renamed from: a */
        private String f1848a;

        public a(String str) {
            this.f1848a = str;
        }

        public String toString() {
            return this.f1848a;
        }
    }
}
