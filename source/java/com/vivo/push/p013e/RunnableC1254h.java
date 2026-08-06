package com.vivo.push.p013e;

import android.content.Context;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.p013e.p014a.C1245a;
import com.vivo.push.p013e.p014a.C1246b;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.request.C1347b;
import com.vivo.push.restructure.request.C1349d;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C1393t;
import java.util.ArrayList;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.e.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1254h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IPushRequestCallback f433a;

    /* renamed from: b */
    final /* synthetic */ C1250d f434b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1254h(C1250d c1250d, IPushRequestCallback iPushRequestCallback) {
        this.f434b = c1250d;
        this.f433a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1393t.m1044b("query all profileIds");
        if (C1313a.m810a().m817g().m643b() != 0) {
            C1393t.m1044b("core not support sync profileInfo");
            IPushRequestCallback iPushRequestCallback = this.f433a;
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(AVMDLDataLoader.KeyIsLiveEnableMdlProto);
                return;
            }
        }
        Context m812b = C1313a.m810a().m812b();
        C1349d.m901a().m905a(new C1347b(new C1245a(new C1246b(m812b.getPackageName(), new ArrayList(), 4)), new C1255i(this), 20000L));
    }
}
