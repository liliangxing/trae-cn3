package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.oneid.IDBindCallback;
import com.bytedance.tobshadow.applog.oneid.IDBindResult;

/* loaded from: classes5.dex */
public final class c4 implements Runnable {
    public final /* synthetic */ IDBindCallback a;
    public final /* synthetic */ IDBindResult b;

    public c4(IDBindCallback iDBindCallback, IDBindResult iDBindResult) {
        this.a = iDBindCallback;
        this.b = iDBindResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onSuccess(this.b);
    }
}
