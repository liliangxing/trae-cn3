package com.hihonor.push.sdk;

import com.hihonor.push.sdk.C0966z;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* renamed from: com.hihonor.push.sdk.y */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0964y implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f789a;

    /* renamed from: b */
    public final /* synthetic */ C0966z.a f790b;

    public RunnableC0964y(C0966z.a aVar, int i) {
        this.f790b = aVar;
        this.f789a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f790b.m786a(HonorPushErrorEnum.fromCode(this.f789a));
    }
}
