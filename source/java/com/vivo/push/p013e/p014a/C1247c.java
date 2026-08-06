package com.vivo.push.p013e.p014a;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b;
import com.vivo.push.util.C1393t;

/* compiled from: SyncProfileInfoInputDS.java */
/* renamed from: com.vivo.push.e.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1247c implements InterfaceC1342b.a<C1246b> {
    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b.a
    /* renamed from: a */
    public final /* synthetic */ InterfaceC1342b mo674a(C1341a c1341a) {
        return m679b(c1341a);
    }

    /* renamed from: b */
    private static C1246b m679b(C1341a c1341a) {
        try {
            return new C1246b(c1341a);
        } catch (Exception e) {
            C1393t.m1037a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
            return null;
        }
    }
}
