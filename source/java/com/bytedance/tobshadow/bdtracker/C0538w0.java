package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.bdtracker.C0453k;

/* renamed from: com.bytedance.tobshadow.bdtracker.w0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0538w0 implements C0453k.d {

    /* renamed from: a */
    public final /* synthetic */ Throwable f1180a;

    public C0538w0(C0531v0 c0531v0, Throwable th) {
        this.f1180a = th;
    }

    @Override // com.bytedance.tobshadow.bdtracker.C0453k.d
    /* renamed from: a */
    public void mo499a(C0467m c0467m) {
        if (c0467m.getInitConfig() == null || !c0467m.getInitConfig().isMonitorEnabled()) {
            return;
        }
        C0547x2.m748b(c0467m.getMonitor(), this.f1180a);
    }
}
