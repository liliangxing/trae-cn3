package com.vivo.push;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c;
import com.vivo.push.util.C1393t;

/* compiled from: ClientSdkQueryParemeterDS.java */
/* renamed from: com.vivo.push.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1257f implements InterfaceC1343c.a<C1243e> {
    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c.a
    /* renamed from: a */
    public final /* synthetic */ InterfaceC1343c mo682a(String str) {
        return m684b(str);
    }

    /* renamed from: b */
    private static C1243e m684b(String str) {
        try {
            return new C1243e(new C1341a(str));
        } catch (Exception e) {
            C1393t.m1037a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
            return null;
        }
    }
}
