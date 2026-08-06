package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1591eq;
import com.xiaomi.push.C1609fh;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.aw */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1765aw extends XMPushService.AbstractC1731j {

    /* renamed from: a */
    private C1591eq f3093a;

    /* renamed from: a */
    private XMPushService f3094a;

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
    /* renamed from: a */
    public String mo2389a() {
        return "send a message.";
    }

    public C1765aw(XMPushService xMPushService, C1591eq c1591eq) {
        super(4);
        this.f3094a = xMPushService;
        this.f3093a = c1591eq;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
    /* renamed from: a */
    public void mo2390a() {
        try {
            C1591eq c1591eq = this.f3093a;
            if (c1591eq != null) {
                if (AbstractC1776e.m3828a(c1591eq)) {
                    this.f3093a.m2453c(System.currentTimeMillis() - this.f3093a.m2430a());
                }
                this.f3094a.m3547a(this.f3093a);
            }
        } catch (C1609fh e) {
            AbstractC1417b.m1093a(e);
            this.f3094a.m3546a(10, e);
        }
    }
}
