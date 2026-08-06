package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.C1609fh;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.XMPushService;
import java.util.Collection;

/* renamed from: com.xiaomi.push.service.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1791s extends XMPushService.AbstractC1731j {

    /* renamed from: a */
    private XMPushService f3213a;

    /* renamed from: a */
    private String f3214a;

    /* renamed from: a */
    private byte[] f3215a;

    /* renamed from: b */
    private String f3216b;

    /* renamed from: c */
    private String f3217c;

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
    /* renamed from: a */
    public String mo2389a() {
        return "register app";
    }

    public C1791s(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f3213a = xMPushService;
        this.f3214a = str;
        this.f3215a = bArr;
        this.f3216b = str2;
        this.f3217c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
    /* renamed from: a */
    public void mo2390a() {
        C1755am.b next;
        C1787p m3955a = C1788q.m3955a((Context) this.f3213a);
        if (m3955a == null) {
            try {
                m3955a = C1788q.m3956a(this.f3213a, this.f3214a, this.f3216b, this.f3217c);
            } catch (Exception e) {
                AbstractC1417b.m1103d("fail to register push account. " + e);
            }
        }
        if (m3955a == null) {
            AbstractC1417b.m1103d("no account for registration.");
            C1792t.m3978a(this.f3213a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        AbstractC1417b.m1089a("do registration now.");
        Collection<C1755am.b> m3707a = C1755am.m3702a().m3707a("5");
        if (m3707a.isEmpty()) {
            next = m3955a.m3952a(this.f3213a);
            C1795w.m4033a(this.f3213a, next);
            C1755am.m3702a().m3713a(next);
        } else {
            next = m3707a.iterator().next();
        }
        if (this.f3213a.m3563c()) {
            try {
                if (next.f2993a == C1755am.c.binded) {
                    C1795w.m4035a(this.f3213a, this.f3214a, this.f3215a);
                } else if (next.f2993a == C1755am.c.unbind) {
                    C1792t.m3982a(this.f3214a, this.f3215a);
                    XMPushService xMPushService = this.f3213a;
                    XMPushService xMPushService2 = this.f3213a;
                    xMPushService2.getClass();
                    xMPushService.m3548a(new XMPushService.C1723b(next));
                }
                return;
            } catch (C1609fh e2) {
                AbstractC1417b.m1103d("meet error, disconnect connection. " + e2);
                this.f3213a.m3546a(10, e2);
                return;
            }
        }
        C1792t.m3982a(this.f3214a, this.f3215a);
        this.f3213a.m3554a(true);
    }
}
