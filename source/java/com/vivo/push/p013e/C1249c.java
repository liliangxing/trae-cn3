package com.vivo.push.p013e;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c;
import com.vivo.push.util.C1393t;

/* compiled from: ProfileInfoDS.java */
/* renamed from: com.vivo.push.e.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1249c implements InterfaceC1343c.a<C1248b> {
    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c.a
    /* renamed from: a */
    public final /* synthetic */ InterfaceC1343c mo682a(String str) {
        return m681b(str);
    }

    /* renamed from: b */
    private static C1248b m681b(String str) {
        try {
            return new C1248b(new C1341a(str));
        } catch (Exception e) {
            C1393t.m1037a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
            return null;
        }
    }
}
