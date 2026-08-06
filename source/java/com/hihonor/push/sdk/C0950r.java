package com.hihonor.push.sdk;

import java.util.List;

/* renamed from: com.hihonor.push.sdk.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0950r implements InterfaceC0936k0<List<HonorPushDataMsg>> {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f754a;

    /* renamed from: b */
    public final /* synthetic */ C0952s f755b;

    public C0950r(C0952s c0952s, HonorPushCallback honorPushCallback) {
        this.f755b = c0952s;
        this.f754a = honorPushCallback;
    }

    @Override // com.hihonor.push.sdk.InterfaceC0936k0
    /* renamed from: a */
    public void mo731a(C0908a1<List<HonorPushDataMsg>> c0908a1) {
        if (c0908a1.m738e()) {
            C0952s c0952s = this.f755b;
            HonorPushCallback honorPushCallback = this.f754a;
            List<HonorPushDataMsg> m736c = c0908a1.m736c();
            c0952s.getClass();
            C0911b1.m753a(new RunnableC0954t(c0952s, honorPushCallback, m736c));
            return;
        }
        C0952s.m778a(this.f755b, this.f754a, -1, c0908a1.m735b().toString());
    }
}
