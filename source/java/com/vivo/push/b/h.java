package com.vivo.push.b;

import android.text.TextUtils;
import com.bytedance.vcloud.strategy.StrategyCenter;

/* compiled from: MsgArriveCommand.java */
/* loaded from: classes7.dex */
public final class h extends com.vivo.push.v {
    private String a;
    private String b;

    public h() {
        super(StrategyCenter.EVENT_PLAYER_RANGE_DETERMINED);
    }

    public h(String str) {
        this();
        this.a = str;
    }

    public h(String str, String str2) {
        this(str);
        this.b = str2;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("MsgArriveCommand.MSG_TAG", this.a);
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        dVar.a("MsgArriveCommand.NODE_INFO", this.b);
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.a = dVar.a("MsgArriveCommand.MSG_TAG");
        this.b = dVar.a("MsgArriveCommand.NODE_INFO");
    }
}
