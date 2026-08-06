package com.bytedance.trae.conversation.billing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePromptCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
/* synthetic */ class BillingUpgradePromptCoordinator$engine$6 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingUpgradePromptCoordinator$engine$6(Object obj) {
        super(1, obj, BillingUpgradePromptStore.class, "clearPending", "clearPending(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        ((BillingUpgradePromptStore) this.receiver).clearPending(str);
    }
}
