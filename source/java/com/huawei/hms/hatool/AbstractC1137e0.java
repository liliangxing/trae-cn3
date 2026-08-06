package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.huawei.hms.hatool.e0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1137e0 {
    /* renamed from: a */
    private C1148i m1481a(int i) {
        String str;
        if (i != 0) {
            str = m1484f();
            if (!TextUtils.isEmpty(str)) {
                return new C1148i(EnumC1134d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new C1148i(EnumC1134d0.EMPTY, str);
    }

    /* renamed from: b */
    private C1148i m1482b(int i) {
        String str;
        if ((i & 4) != 0) {
            str = m1484f();
            if (!TextUtils.isEmpty(str)) {
                return new C1148i(EnumC1134d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new C1148i(EnumC1134d0.EMPTY, str);
    }

    /* renamed from: e */
    private boolean m1483e() {
        C1144g1 m1727b = C1176s.m1722c().m1727b();
        if (TextUtils.isEmpty(m1727b.m1533l())) {
            m1727b.m1526h(AbstractC1166o.m1653a());
        }
        return !TextUtils.isEmpty(m1727b.m1533l());
    }

    /* renamed from: f */
    private String m1484f() {
        C1144g1 m1727b = C1176s.m1722c().m1727b();
        if (TextUtils.isEmpty(m1727b.m1527i())) {
            m1727b.m1520e(C1187x0.m1808c());
        }
        return m1727b.m1527i();
    }

    /* renamed from: a */
    public C1148i m1485a(Context context) {
        String mo1489c = mo1489c();
        if (!TextUtils.isEmpty(mo1489c)) {
            return new C1148i(EnumC1134d0.UDID, mo1489c);
        }
        String mo1486a = mo1486a();
        if (!TextUtils.isEmpty(mo1486a)) {
            return new C1148i(EnumC1134d0.IMEI, mo1486a);
        }
        boolean m1483e = m1483e();
        String mo1488b = mo1488b();
        return !TextUtils.isEmpty(mo1488b) ? m1483e ? new C1148i(EnumC1134d0.SN, mo1488b) : new C1148i(EnumC1134d0.UDID, mo1487a(mo1488b)) : m1483e ? m1481a(mo1490d()) : m1482b(mo1490d());
    }

    /* renamed from: a */
    public abstract String mo1486a();

    /* renamed from: a */
    public abstract String mo1487a(String str);

    /* renamed from: b */
    public abstract String mo1488b();

    /* renamed from: c */
    public abstract String mo1489c();

    /* renamed from: d */
    public abstract int mo1490d();
}
