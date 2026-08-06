package com.bytedance.trae.network;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BytecloudNetworkCacheReset.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\t\u001a\u00020\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/network/BytecloudNetworkCacheReset;", "", "<init>", "()V", "resetAction", "Lkotlin/Function0;", "", "setResetAction", StrategyConstants.ACTION, "onNetworkChanged", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BytecloudNetworkCacheReset {
    public static final BytecloudNetworkCacheReset INSTANCE = new BytecloudNetworkCacheReset();
    private static Function0<Unit> resetAction;

    private BytecloudNetworkCacheReset() {
    }

    public final void setResetAction(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        resetAction = action;
    }

    public final void onNetworkChanged() {
        Function0<Unit> function0 = resetAction;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
