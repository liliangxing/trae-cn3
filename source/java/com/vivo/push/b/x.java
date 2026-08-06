package com.vivo.push.b;

import com.bytedance.vcloud.strategy.StrategyCenter;

/* compiled from: PushModeCommand.java */
/* loaded from: classes7.dex */
public final class x extends com.vivo.push.v {
    private int a;

    @Override // com.vivo.push.v
    public final boolean d() {
        return true;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "PushModeCommand";
    }

    public x() {
        super(StrategyCenter.EVENT_PLAY_BUFFER_DIFF_RESULT);
        this.a = 0;
    }

    public final int e() {
        return this.a;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("com.bbk.push.ikey.MODE_TYPE", this.a);
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.a = dVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
