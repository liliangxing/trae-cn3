package com.bytedance.trae.conversation.billing;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePromptCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
/* synthetic */ class BillingUpgradePromptCoordinator$engine$4 extends FunctionReferenceImpl implements Function1<String, BillingUpgradePromptData> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingUpgradePromptCoordinator$engine$4(Object obj) {
        super(1, obj, BillingUpgradePromptStore.class, "loadPending", "loadPending(Ljava/lang/String;)Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", 0);
    }

    public final BillingUpgradePromptData invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((BillingUpgradePromptStore) this.receiver).loadPending(str);
    }
}
