package com.bytedance.tobshadow.bdtracker;

import android.content.Context;

/* renamed from: com.bytedance.tobshadow.bdtracker.u5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RunnableC0529u5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Context f1105a;

    public RunnableC0529u5(Context context) {
        this.f1105a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0522t5.f1074b.m456b(this.f1105a).putBoolean("_install_started_v2", true);
    }
}
