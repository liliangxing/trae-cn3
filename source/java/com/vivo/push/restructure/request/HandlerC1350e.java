package com.vivo.push.restructure.request;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C1380g;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestManager.java */
/* renamed from: com.vivo.push.restructure.request.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class HandlerC1350e extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1349d f622a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1350e(C1349d c1349d, Looper looper) {
        super(looper);
        this.f622a = c1349d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Map map;
        Map map2;
        int i = message.what;
        map = this.f622a.f617a;
        if (map.containsKey(Integer.valueOf(i))) {
            map2 = this.f622a.f617a;
            C1380g.m996a().execute(new RunnableC1351f(this, (C1347b) map2.remove(Integer.valueOf(i))));
        }
    }
}
