package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.oneid.IDBindCallback;

/* renamed from: com.bytedance.tobshadow.bdtracker.b4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RunnableC0393b4 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ IDBindCallback f469a;

    /* renamed from: b */
    public final /* synthetic */ int f470b;

    /* renamed from: c */
    public final /* synthetic */ String f471c;

    public RunnableC0393b4(IDBindCallback iDBindCallback, int i, String str) {
        this.f469a = iDBindCallback;
        this.f470b = i;
        this.f471c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f469a.onFail(this.f470b, this.f471c);
    }
}
