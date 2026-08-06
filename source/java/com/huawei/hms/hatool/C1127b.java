package com.huawei.hms.hatool;

import android.content.Context;

/* renamed from: com.huawei.hms.hatool.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1127b {

    /* renamed from: a */
    C1177s0 f1405a;

    /* renamed from: b */
    C1177s0 f1406b;

    /* renamed from: c */
    Context f1407c;

    /* renamed from: d */
    String f1408d;

    public C1127b(Context context) {
        if (context != null) {
            this.f1407c = context.getApplicationContext();
        }
        this.f1405a = new C1177s0();
        this.f1406b = new C1177s0();
    }

    /* renamed from: a */
    public C1127b m1429a(int i, String str) {
        C1177s0 c1177s0;
        C1182v.m1775a("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i);
        if (!C1171p1.m1686b(str)) {
            str = "";
        }
        if (i == 0) {
            c1177s0 = this.f1405a;
        } else {
            if (i != 1) {
                C1182v.m1786f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            }
            c1177s0 = this.f1406b;
        }
        c1177s0.m1736b(str);
        return this;
    }

    /* renamed from: a */
    public C1127b m1430a(String str) {
        C1182v.m1775a("hmsSdk", "Builder.setAppID is execute");
        this.f1408d = str;
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public C1127b m1431a(boolean z) {
        C1182v.m1775a("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f1405a.m1753j().m1574a(z);
        this.f1406b.m1753j().m1574a(z);
        return this;
    }

    /* renamed from: a */
    public void m1432a() {
        if (this.f1407c == null) {
            C1182v.m1778b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        C1182v.m1775a("hmsSdk", "Builder.create() is execute.");
        C1191z0 c1191z0 = new C1191z0("_hms_config_tag");
        c1191z0.m1835b(new C1177s0(this.f1405a));
        c1191z0.m1833a(new C1177s0(this.f1406b));
        C1160m.m1621a().m1623a(this.f1407c);
        C1143g0.m1502a().m1505a(this.f1407c);
        C1172q.m1687c().m1688a(c1191z0);
        C1160m.m1621a().m1624a(this.f1408d);
    }

    @Deprecated
    /* renamed from: b */
    public C1127b m1433b(boolean z) {
        C1182v.m1775a("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f1405a.m1753j().m1576b(z);
        this.f1406b.m1753j().m1576b(z);
        return this;
    }

    @Deprecated
    /* renamed from: c */
    public C1127b m1434c(boolean z) {
        C1182v.m1775a("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f1405a.m1753j().m1578c(z);
        this.f1406b.m1753j().m1578c(z);
        return this;
    }
}
