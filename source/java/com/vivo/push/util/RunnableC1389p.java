package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.p017h.C1295u;
import java.util.List;

/* compiled from: ImageDownTask.java */
/* renamed from: com.vivo.push.util.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1389p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f718a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC1388o f719b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1389p(AsyncTaskC1388o asyncTaskC1388o, List list) {
        this.f719b = asyncTaskC1388o;
        this.f718a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j2;
        int i;
        NotifyArriveCallbackByUser notifyArriveCallbackByUser;
        C1295u.a aVar;
        insideNotificationItem = this.f719b.f712b;
        if (insideNotificationItem != null) {
            C1369ad m941c = C1369ad.m941c();
            j = this.f719b.f713c;
            m941c.m985a("com.vivo.push.notify_key", j);
            context = this.f719b.f711a;
            List list = this.f718a;
            insideNotificationItem2 = this.f719b.f712b;
            j2 = this.f719b.f713c;
            i = this.f719b.f715e;
            notifyArriveCallbackByUser = this.f719b.f716f;
            aVar = this.f719b.f717g;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j2, i, notifyArriveCallbackByUser, aVar);
        }
    }
}
