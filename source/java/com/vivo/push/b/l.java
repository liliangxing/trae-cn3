package com.vivo.push.b;

import com.bytedance.vcloud.strategy.StrategyCenter;

/* compiled from: OnDispatcherReceiveCommand.java */
/* loaded from: classes7.dex */
public final class l extends t {
    private int a;
    private int b;

    public l() {
        super(StrategyCenter.EVENT_LOAD_CONTROL_VERSION);
        this.a = -1;
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("key_dispatch_environment", this.a);
        dVar.a("key_dispatch_area", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.b("key_dispatch_environment", 1);
        this.b = dVar.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.a;
    }

    public final int f() {
        return this.b;
    }
}
