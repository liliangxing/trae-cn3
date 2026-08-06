package com.bytedance.android.monitorV2.lynx.jsb;

import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxViewProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/jsb/LynxViewProvider;", "", "view", "Lcom/lynx/tasm/LynxView;", "(Lcom/lynx/tasm/LynxView;)V", "getView", "()Lcom/lynx/tasm/LynxView;", "setView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewProvider {
    private LynxView view;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LynxViewProvider() {
        this(r0, 1, r0);
        LynxView lynxView = null;
    }

    public LynxViewProvider(LynxView lynxView) {
        this.view = lynxView;
    }

    public /* synthetic */ LynxViewProvider(LynxView lynxView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lynxView);
    }

    public final LynxView getView() {
        return this.view;
    }

    public final void setView(LynxView lynxView) {
        this.view = lynxView;
    }
}
