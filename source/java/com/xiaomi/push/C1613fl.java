package com.xiaomi.push;

import android.os.Bundle;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.fl */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1613fl extends AbstractC1615fn {

    /* renamed from: a */
    private a f1762a;

    /* renamed from: a */
    private final Map<String, String> f1763a;

    /* renamed from: b */
    public String mo2578b() {
        return null;
    }

    public C1613fl() {
        this.f1762a = a.f1764a;
        this.f1763a = new HashMap();
    }

    public C1613fl(Bundle bundle) {
        super(bundle);
        this.f1762a = a.f1764a;
        this.f1763a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f1762a = a.m2579a(bundle.getString("ext_iq_type"));
        }
    }

    /* renamed from: a */
    public synchronized void m2577a(Map<String, String> map) {
        this.f1763a.putAll(map);
    }

    /* renamed from: a */
    public a m2574a() {
        return this.f1762a;
    }

    /* renamed from: a */
    public void m2576a(a aVar) {
        if (aVar == null) {
            this.f1762a = a.f1764a;
        } else {
            this.f1762a = aVar;
        }
    }

    @Override // com.xiaomi.push.AbstractC1615fn
    /* renamed from: a */
    public Bundle mo2573a() {
        Bundle mo2573a = super.mo2573a();
        a aVar = this.f1762a;
        if (aVar != null) {
            mo2573a.putString("ext_iq_type", aVar.toString());
        }
        return mo2573a;
    }

    @Override // com.xiaomi.push.AbstractC1615fn
    /* renamed from: a */
    public String mo2575a() {
        StringBuilder sb = new StringBuilder("<iq ");
        if (m2610j() != null) {
            sb.append("id=\"" + m2610j() + "\" ");
        }
        if (m2613l() != null) {
            sb.append("to=\"").append(C1624fw.m2647a(m2613l())).append("\" ");
        }
        if (m2615m() != null) {
            sb.append("from=\"").append(C1624fw.m2647a(m2615m())).append("\" ");
        }
        if (m2611k() != null) {
            sb.append("chid=\"").append(C1624fw.m2647a(m2611k())).append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f1763a.entrySet()) {
            sb.append(C1624fw.m2647a(entry.getKey())).append("=\"");
            sb.append(C1624fw.m2647a(entry.getValue())).append("\" ");
        }
        if (this.f1762a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"").append(m2574a()).append("\">");
        }
        String mo2578b = mo2578b();
        if (mo2578b != null) {
            sb.append(mo2578b);
        }
        sb.append(m2619o());
        C1619fr a2 = mo2573a();
        if (a2 != null) {
            sb.append(a2.m2628a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    /* renamed from: com.xiaomi.push.fl$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        public static final a f1764a = new a(MonitorConstants.CONNECT_TYPE_GET);

        /* renamed from: b */
        public static final a f1765b = new a("set");

        /* renamed from: c */
        public static final a f1766c = new a(IAssociationStartMonitorEventService.KEY_RESULT);

        /* renamed from: d */
        public static final a f1767d = new a("error");

        /* renamed from: e */
        public static final a f1768e = new a("command");

        /* renamed from: a */
        private String f1769a;

        /* renamed from: a */
        public static a m2579a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = f1764a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = f1765b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = f1767d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = f1766c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = f1768e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        private a(String str) {
            this.f1769a = str;
        }

        public String toString() {
            return this.f1769a;
        }
    }
}
