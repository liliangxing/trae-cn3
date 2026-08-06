package com.vivo.push;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.a.a.c;

/* compiled from: ClientSdkQueryResultDS.java */
/* loaded from: classes7.dex */
final class h implements c.a<g> {
    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.c a(String str) {
        return b(str);
    }

    private static g b(String str) {
        try {
            return new g(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e) {
            com.vivo.push.util.t.a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
            return null;
        }
    }
}
