package com.bytedance.trae.conversation.billing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePromptCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
/* synthetic */ class BillingUpgradePromptCoordinator$engine$5 extends FunctionReferenceImpl implements Function2<String, BillingUpgradePromptData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingUpgradePromptCoordinator$engine$5(Object obj) {
        super(2, obj, BillingUpgradePromptStore.class, "savePending", "savePending(Ljava/lang/String;Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (BillingUpgradePromptData) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, BillingUpgradePromptData billingUpgradePromptData) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(billingUpgradePromptData, "p1");
        ((BillingUpgradePromptStore) this.receiver).savePending(str, billingUpgradePromptData);
    }
}
