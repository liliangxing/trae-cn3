package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j1 extends i1 {
    public final Runnable b;

    public j1(Runnable checkTask) {
        Intrinsics.checkParameterIsNotNull(checkTask, "checkTask");
        this.b = checkTask;
    }

    @Override // com.bytedance.tobshadow.bdtracker.i1
    public void a() {
        this.a.removeCallbacks(this.b);
        this.a.postDelayed(this.b, 100L);
    }
}
