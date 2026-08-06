package com.vivo.push;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.a.a.c;

/* compiled from: ClientSdkQueryParemeterDS.java */
/* loaded from: classes7.dex */
final class f implements c.a<e> {
    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.c a(String str) {
        return b(str);
    }

    private static e b(String str) {
        try {
            return new e(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e) {
            com.vivo.push.util.t.a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
            return null;
        }
    }
}
