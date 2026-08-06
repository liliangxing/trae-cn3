package com.bytedance.trae.conversation.billing;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePromptCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
/* synthetic */ class BillingUpgradePromptCoordinator$engine$2 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingUpgradePromptCoordinator$engine$2(Object obj) {
        super(1, obj, BillingUpgradePromptStore.class, "hasShown", "hasShown(Ljava/lang/String;)Z", 0);
    }

    public final Boolean invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return Boolean.valueOf(((BillingUpgradePromptStore) this.receiver).hasShown(str));
    }
}
