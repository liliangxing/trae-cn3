package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.oneid.IDBindCallback;
import com.bytedance.tobshadow.applog.oneid.IDBindResult;

/* renamed from: com.bytedance.tobshadow.bdtracker.c4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RunnableC0401c4 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ IDBindCallback f481a;

    /* renamed from: b */
    public final /* synthetic */ IDBindResult f482b;

    public RunnableC0401c4(IDBindCallback iDBindCallback, IDBindResult iDBindResult) {
        this.f481a = iDBindCallback;
        this.f482b = iDBindResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f481a.onSuccess(this.f482b);
    }
}
