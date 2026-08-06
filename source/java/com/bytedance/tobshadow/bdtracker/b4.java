package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.oneid.IDBindCallback;

/* loaded from: classes5.dex */
public final class b4 implements Runnable {
    public final /* synthetic */ IDBindCallback a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public b4(IDBindCallback iDBindCallback, int i, String str) {
        this.a = iDBindCallback;
        this.b = i;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onFail(this.b, this.c);
    }
}
