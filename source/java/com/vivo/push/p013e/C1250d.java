package com.vivo.push.p013e;

import android.content.Context;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.p013e.p014a.C1245a;
import com.vivo.push.p013e.p014a.C1246b;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.request.C1347b;
import com.vivo.push.restructure.request.C1349d;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C1380g;
import com.vivo.push.util.C1393t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.e.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1250d implements InterfaceC1244a {
    @Override // com.vivo.push.p013e.InterfaceC1244a
    public final void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        C1380g.m996a().execute(new RunnableC1251e(this, str, iPushRequestCallback));
    }

    @Override // com.vivo.push.p013e.InterfaceC1244a
    public final void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        C1380g.m996a().execute(new RunnableC1252f(this, str, iPushRequestCallback));
    }

    @Override // com.vivo.push.p013e.InterfaceC1244a
    public final void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback) {
        C1380g.m996a().execute(new RunnableC1253g(this, iPushRequestCallback));
    }

    @Override // com.vivo.push.p013e.InterfaceC1244a
    public final void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback) {
        C1380g.m996a().execute(new RunnableC1254h(this, iPushRequestCallback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m683a(C1250d c1250d, String str, IPushRequestCallback iPushRequestCallback, int i) {
        if (C1313a.m810a().m817g().m643b() != 0) {
            C1393t.m1044b("core not support sync profileInfo");
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(AVMDLDataLoader.KeyIsLiveEnableMdlProto);
                return;
            }
        }
        Context m812b = C1313a.m810a().m812b();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new C1248b(str));
        }
        C1349d.m901a().m905a(new C1347b(new C1245a(new C1246b(m812b.getPackageName(), arrayList, i)), new C1256j(c1250d, iPushRequestCallback, i), 20000L));
    }
}
