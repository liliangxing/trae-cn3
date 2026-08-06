package com.cmic.sso.sdk.p003c;

import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p003c.p005b.AbstractC0118g;
import com.cmic.sso.sdk.p003c.p005b.C0114c;
import com.cmic.sso.sdk.p003c.p005b.C0115d;
import com.cmic.sso.sdk.p003c.p006c.C0123c;
import com.cmic.sso.sdk.p003c.p007d.C0127b;
import com.cmic.sso.sdk.p009e.C0133c;
import com.cmic.sso.sdk.p009e.C0147q;
import java.util.List;
import java.util.Map;

/* compiled from: RedirectHandler.java */
/* renamed from: com.cmic.sso.sdk.c.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0111b {

    /* renamed from: a */
    private String f191a;

    /* renamed from: b */
    private String f192b;

    /* renamed from: a */
    public C0123c m193a(C0123c c0123c, C0127b c0127b, C0088a c0088a) {
        List<String> list;
        Map<String, List<String>> m281b = c0127b.m281b();
        if (TextUtils.isEmpty(this.f191a) && (list = m281b.get("pplocation")) != null && list.size() > 0) {
            this.f191a = list.get(0);
        }
        C0147q.m400b(c0088a, String.valueOf(c0127b.m280a()));
        List<String> list2 = m281b.get("Location");
        if (list2 == null || list2.isEmpty()) {
            list2 = m281b.get("Location".toLowerCase());
        }
        if (list2 != null && list2.size() > 0) {
            String str = list2.get(0);
            this.f192b = str;
            if (!TextUtils.isEmpty(str)) {
                String m68b = c0088a.m68b("operatortype", AddressParam.TYPE_DISAPPROVE);
                if ("2".equals(m68b)) {
                    C0147q.m396a(c0088a, "getUnicomMobile");
                } else if ("3".equals(m68b)) {
                    C0147q.m396a(c0088a, "getTelecomMobile");
                } else {
                    C0147q.m396a(c0088a, "NONE");
                }
            }
        }
        C0133c.m328b("Location", this.f192b);
        C0123c m192a = m192a(this.f192b, c0123c.m271f(), "GET", new C0114c(c0123c.m276k().mo196a()));
        m192a.m264a(c0123c.m273h());
        return m192a;
    }

    /* renamed from: b */
    public C0123c m195b(C0123c c0123c, C0127b c0127b, C0088a c0088a) {
        String m68b = c0088a.m68b("operatortype", AddressParam.TYPE_DISAPPROVE);
        if ("2".equals(m68b)) {
            C0147q.m396a(c0088a, "getNewUnicomPhoneNumberNotify");
        } else if ("3".equals(m68b)) {
            C0147q.m396a(c0088a, "getNewTelecomPhoneNumberNotify");
        } else {
            C0147q.m396a(c0088a, "NONE");
        }
        C0147q.m400b(c0088a, String.valueOf(c0127b.m280a()));
        C0115d c0115d = new C0115d(c0123c.m276k().mo196a(), "1.0", c0127b.m282c());
        c0115d.m228c(c0088a.m67b("userCapaid"));
        if (c0088a.m70c("logintype") != 3) {
            if (c0088a.m69b("isRisk", false)) {
                c0115d.m227b("pre");
            } else {
                c0115d.m227b("authz");
            }
        } else {
            c0115d.m227b("pre");
        }
        C0123c m192a = m192a(this.f191a, c0123c.m271f(), "POST", c0115d);
        m192a.m264a(c0123c.m273h());
        this.f191a = null;
        return m192a;
    }

    /* renamed from: a */
    private C0123c m192a(String str, String str2, String str3, AbstractC0118g abstractC0118g) {
        C0123c c0123c = new C0123c(str, abstractC0118g, str3, str2);
        if (str3.equals("GET")) {
            c0123c.m265a("Content-Type", "application/x-www-form-urlencoded");
        }
        return c0123c;
    }

    /* renamed from: a */
    public String m194a() {
        return this.f191a;
    }
}
