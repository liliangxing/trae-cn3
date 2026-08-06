package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1515bv;
import com.xiaomi.push.service.C1750ah;
import com.xiaomi.push.service.C1768az;
import java.lang.ref.WeakReference;

/* renamed from: com.xiaomi.push.bm */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1506bm {

    /* renamed from: a */
    private static volatile C1506bm f1076a;

    /* renamed from: a */
    private Context f1077a;

    /* renamed from: a */
    private InterfaceC1516bw f1079a;

    /* renamed from: a */
    private InterfaceC1517bx f1080a;

    /* renamed from: e */
    private String f1087e;

    /* renamed from: f */
    private String f1088f;

    /* renamed from: a */
    private final String f1081a = "push_stat_sp";

    /* renamed from: b */
    private final String f1083b = "upload_time";

    /* renamed from: c */
    private final String f1085c = "delete_time";

    /* renamed from: d */
    private final String f1086d = "check_time";

    /* renamed from: a */
    private C1470ad.a f1078a = new C1470ad.a() { // from class: com.xiaomi.push.bm.1
        @Override // com.xiaomi.push.C1470ad.a
        /* renamed from: a */
        public String mo1133a() {
            return "10052";
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC1417b.m1101c("exec== mUploadJob");
            if (C1506bm.this.f1080a != null) {
                C1506bm.this.f1080a.m1721a(C1506bm.this.f1077a);
                C1506bm.this.m1683b("upload_time");
            }
        }
    };

    /* renamed from: b */
    private C1470ad.a f1082b = new C1470ad.a() { // from class: com.xiaomi.push.bm.2
        @Override // com.xiaomi.push.C1470ad.a
        /* renamed from: a */
        public String mo1133a() {
            return "10054";
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC1417b.m1101c("exec== DbSizeControlJob");
            C1515bv.m1703a(C1506bm.this.f1077a).m1708a(new RunnableC1508bo(C1506bm.this.m1684c(), new WeakReference(C1506bm.this.f1077a)));
            C1506bm.this.m1683b("check_time");
        }
    };

    /* renamed from: c */
    private C1470ad.a f1084c = new C1470ad.a() { // from class: com.xiaomi.push.bm.3
        @Override // com.xiaomi.push.C1470ad.a
        /* renamed from: a */
        public String mo1133a() {
            return "10053";
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1506bm.this.f1080a != null) {
                C1506bm.this.f1080a.m1722b(C1506bm.this.f1077a);
                C1506bm.this.m1683b("delete_time");
            }
        }
    };

    private C1506bm(Context context) {
        this.f1077a = context;
    }

    /* renamed from: a */
    public static C1506bm m1678a(Context context) {
        if (f1076a == null) {
            synchronized (C1506bm.class) {
                if (f1076a == null) {
                    f1076a = new C1506bm(context);
                }
            }
        }
        return f1076a;
    }

    /* renamed from: a */
    private boolean m1682a() {
        return C1750ah.m3674a(this.f1077a).m3686a(EnumC1638gj.StatDataSwitch.m2760a(), true);
    }

    /* renamed from: a */
    public void m1686a(C1515bv.a aVar) {
        C1515bv.m1703a(this.f1077a).m1707a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1683b(String str) {
        SharedPreferences.Editor edit = this.f1077a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        C1699o.m3458a(edit);
    }

    /* renamed from: a */
    public void m1689a(String str, String str2, Boolean bool) {
        if (this.f1079a != null) {
            if (bool.booleanValue()) {
                this.f1079a.m1719a(this.f1077a, str2, str);
            } else {
                this.f1079a.m1720b(this.f1077a, str2, str);
            }
        }
    }

    /* renamed from: a */
    public String m1685a() {
        return this.f1087e;
    }

    /* renamed from: b */
    public String m1690b() {
        return this.f1088f;
    }

    /* renamed from: a */
    public void m1688a(String str) {
        if (m1682a() && !TextUtils.isEmpty(str)) {
            m1687a(C1518by.m1723a(this.f1077a, str));
        }
    }

    /* renamed from: a */
    public void m1687a(C1637gi c1637gi) {
        if (m1682a() && C1768az.m3795a(c1637gi.m2750e())) {
            m1686a(C1512bs.m1699a(this.f1077a, m1684c(), c1637gi));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m1684c() {
        return this.f1077a.getDatabasePath(C1507bn.f1094a).getAbsolutePath();
    }
}
