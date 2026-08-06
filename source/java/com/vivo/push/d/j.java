package com.vivo.push.d;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.t;

/* compiled from: NotifyGuideOutput.java */
/* loaded from: classes7.dex */
final class j implements b.a<i> {
    @Override // com.vivo.push.restructure.request.a.a.b.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.b a(com.vivo.push.restructure.request.a.a.a aVar) {
        return b(aVar);
    }

    private static i b(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            return new i(aVar);
        } catch (Exception e) {
            t.a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
            return null;
        }
    }
}
