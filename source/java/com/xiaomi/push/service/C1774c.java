package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1591eq;
import com.xiaomi.push.C1609fh;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1774c extends XMPushService.AbstractC1731j {

    /* renamed from: a */
    private XMPushService f3137a;

    /* renamed from: a */
    private C1591eq[] f3138a;

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
    /* renamed from: a */
    public String mo2389a() {
        return "batch send message.";
    }

    public C1774c(XMPushService xMPushService, C1591eq[] c1591eqArr) {
        super(4);
        this.f3137a = xMPushService;
        this.f3138a = c1591eqArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
    /* renamed from: a */
    public void mo2390a() {
        try {
            C1591eq[] c1591eqArr = this.f3138a;
            if (c1591eqArr != null) {
                this.f3137a.m3556a(c1591eqArr);
            }
        } catch (C1609fh e) {
            AbstractC1417b.m1093a(e);
            this.f3137a.m3546a(10, e);
        }
    }
}
