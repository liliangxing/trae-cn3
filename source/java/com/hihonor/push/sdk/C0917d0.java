package com.hihonor.push.sdk;

import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.C0966z;
import com.hihonor.push.sdk.InterfaceC0910b0;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.hihonor.push.sdk.d0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0917d0 implements InterfaceC0910b0 {

    /* renamed from: a */
    public final AtomicInteger f696a = new AtomicInteger(1);

    /* renamed from: b */
    public volatile IPushInvoke f697b;

    /* renamed from: c */
    public final InterfaceC0910b0.a f698c;

    /* renamed from: d */
    public ServiceConnectionC0923f0 f699d;

    public C0917d0(InterfaceC0910b0.a aVar) {
        this.f698c = aVar;
    }

    /* renamed from: a */
    public boolean m763a() {
        return this.f696a.get() == 3 || this.f696a.get() == 4;
    }

    /* renamed from: a */
    public final void m762a(int i) {
        Log.i("PushConnectionClient", "notifyFailed result: " + i);
        InterfaceC0910b0.a aVar = this.f698c;
        if (aVar != null) {
            C0966z.a aVar2 = (C0966z.a) aVar;
            aVar2.getClass();
            if (Looper.myLooper() == C0966z.this.f793a.getLooper()) {
                aVar2.m786a(HonorPushErrorEnum.fromCode(i));
            } else {
                C0966z.this.f793a.post(new RunnableC0964y(aVar2, i));
            }
        }
    }
}
