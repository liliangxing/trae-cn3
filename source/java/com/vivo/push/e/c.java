package com.vivo.push.e;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.a.a.c;
import com.vivo.push.util.t;

/* compiled from: ProfileInfoDS.java */
/* loaded from: classes7.dex */
final class c implements c.a<b> {
    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.c a(String str) {
        return b(str);
    }

    private static b b(String str) {
        try {
            return new b(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e) {
            t.a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
            return null;
        }
    }
}
