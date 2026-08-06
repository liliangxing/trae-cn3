package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.j1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0448j1 extends AbstractC0441i1 {

    /* renamed from: b */
    public final Runnable f698b;

    public C0448j1(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "checkTask");
        this.f698b = runnable;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0441i1
    /* renamed from: a */
    public void mo457a() {
        this.f660a.removeCallbacks(this.f698b);
        this.f660a.postDelayed(this.f698b, 100L);
    }
}
