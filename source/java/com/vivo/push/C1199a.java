package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1380g;

/* compiled from: BasePushClient.java */
/* renamed from: com.vivo.push.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1199a {
    public void getRegId(IPushQueryActionListener iPushQueryActionListener) {
        C1380g.m996a().execute(new RunnableC1203b(this, iPushQueryActionListener));
    }

    public void deleteRegid(IPushActionListener iPushActionListener, String str, String str2) {
        C1313a.m810a().m818h().mo754a(iPushActionListener, str, str2);
    }

    public void querySubscribeState(IPushActionListener iPushActionListener) {
        C1380g.m996a().execute(new RunnableC1230c(this, iPushActionListener));
    }
}
